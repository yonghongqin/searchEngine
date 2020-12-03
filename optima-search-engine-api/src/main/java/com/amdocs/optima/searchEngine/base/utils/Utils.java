/*
 * Brent Smith <brent.smith@comverse.com>
 *
 * Author: $Author$
 * Revision: $Revision$
 *
 * Copyright (C) 2006 Brent Smith 
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA*
 *
 */
package com.amdocs.optima.searchEngine.base.utils;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.lang3.StringEscapeUtils;

public class Utils {

    public static final int FORMAT_BYTE = 0;
    public static final int FORMAT_KIBI = 1;
    public static final int FORMAT_MEBI = 2;
    public static final int FORMAT_GIBI = 3;
    public static final int FORMAT_TEBI = 4;
    public static final int FORMAT_PEBI = 5;
    public static final int FORMAT_EXBI = 6;
    public static final int FORMAT_AUTO = 7;
    public static final int DIRECTORY_LEVEL = 2;

    private final Logger log = Logger.getLogger(this.getClass().getName());

    // Utility function to put a stack trace into a string and return it
    public static String getStackTrace(Throwable t) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        t.printStackTrace(printWriter);
        return result.toString();
    }

    // Utility function to strip any newline characters at the end of a string
    // on a Throwable's message
    public static String getMessage(Throwable t) {
        StringBuffer message = new StringBuffer(t.getMessage());
        while (message.charAt(message.length() - 1) == '\n') {
            message.deleteCharAt(message.length() - 1);
        }
        return message.toString();
    }

    /**
     * Converts a file size into a standard representation with the given units.
     *
     * source: http://physics.nist.gov/cuu/Units/binary.html Prefixes for binary
     * multiples Factor Name Symbol Origin Derivation 2^10 kibi Ki kilobinary:
     * (2^10)^1 kilo: (10^3)^1 2^20 mebi Mi megabinary: (2^10)^2 mega: (10^3)^2
     * 2^30 gibi Gi gigabinary: (2^10)^3 giga: (10^3)^3 2^40 tebi Ti terabinary:
     * (2^10)^4 tera: (10^3)^4 2^50 pebi Pi petabinary: (2^10)^5 peta: (10^3)^5
     * 2^60 exbi Ei exabinary: (2^10)^6 exa: (10^3)^6
     */
    public static String formatFileSize(DecimalFormat df, long fileSize, int unitsType)
            throws IllegalArgumentException {
        double size;

        if (df == null) {
            df = new DecimalFormat();
        }

        String retValue = null;
        switch (unitsType) {
            case FORMAT_BYTE:
                size = (double) fileSize;
                retValue = df.format(size) + " B";
                break;
            case FORMAT_KIBI:
                size = ((double) fileSize) / ((double) (1L << 10));
                retValue = df.format(size) + " KiB";
                break;
            case FORMAT_MEBI:
                size = ((double) fileSize) / ((double) (1L << 20));
                retValue = df.format(size) + " MiB";
                break;
            case FORMAT_GIBI:
                size = ((double) fileSize) / ((double) (1L << 30));
                retValue = df.format(size) + " GiB";
                break;
            case FORMAT_TEBI:
                size = ((double) fileSize) / ((double) (1L << 40));
                retValue = df.format(size) + " TiB";
                break;
            case FORMAT_PEBI:
                size = ((double) fileSize) / ((double) (1L << 50));
                retValue = df.format(size) + " PiB";
                break;
            case FORMAT_EXBI:
                size = ((double) fileSize) / ((double) (1L << 60));
                retValue = df.format(size) + " EiB";
                break;
            case FORMAT_AUTO:
                retValue = formatFileSize(df, fileSize);
                break;
            default:
                throw new IllegalArgumentException("The type argument is not valid");
        }

        return retValue;
    }

    public static String formatFileSize(long fileSize, int unitsType) throws IllegalArgumentException {
        return formatFileSize(null, fileSize, unitsType);
    }

    public static String formatFileSize(DecimalFormat df, long fileSize) throws IllegalArgumentException {

        if (fileSize / (1L << 60) >= 1) {
            return formatFileSize(df, fileSize, FORMAT_EXBI);
        } else if (fileSize / (1L << 50) >= 1) {
            return formatFileSize(df, fileSize, FORMAT_PEBI);
        } else if (fileSize / (1L << 40) >= 1) {
            return formatFileSize(df, fileSize, FORMAT_TEBI);
        } else if (fileSize / (1L << 30) >= 1) {
            return formatFileSize(df, fileSize, FORMAT_GIBI);
        } else if (fileSize / (1L << 20) >= 1) {
            return formatFileSize(df, fileSize, FORMAT_MEBI);
        } else if (fileSize / (1L << 10) >= 1) {
            return formatFileSize(df, fileSize, FORMAT_KIBI);
        } else {
            return formatFileSize(df, fileSize, FORMAT_BYTE);
        }
    }

    public static String formatFileSize(long fileSize) throws IllegalArgumentException {
        return formatFileSize(null, fileSize);
    }

    public static String formatTimeDifference(long timeDifference) {
        StringBuffer strDiff = new StringBuffer();
        DecimalFormat df = new DecimalFormat("00");

        if (timeDifference / (1000 * 3600) >= 1) {
            long hours = timeDifference / (1000 * 3600);
            strDiff.append(df.format(hours) + ":");
            timeDifference = timeDifference - (hours * 3600 * 1000);
        }

        if (timeDifference / (1000 * 60) >= 1) {
            long minutes = timeDifference / (1000 * 60);
            strDiff.append(df.format(minutes) + ":");
            timeDifference = timeDifference - (minutes * 60 * 1000);
        }

        long seconds = timeDifference / (1000);
        strDiff.append(df.format(seconds) + ".");
        timeDifference = timeDifference - (seconds * 1000);

        df = new DecimalFormat("000");
        strDiff.append(df.format(timeDifference));

        return strDiff.toString();

        /*
		 * hours = timeInSeconds / 3600; timeInSeconds = timeInSeconds - (hours
		 * * 3600); minutes = timeInSeconds / 60; timeInSeconds = timeInSeconds
		 * - (minutes * 60); seconds = timeInSeconds;
         */
    }

    /**
     * Useful for right padding a string.
     *
     * right pads {@code str} with spaces until it is {@code size} in length
     * truncates {@code str} to {@code size} if it is already greater in length
     */
    public static void rightPad(StringBuffer str, int size) {
        if (str == null) {
            return;
        }

        if (str.length() > size) {
            str.setLength(size);
        } else {
            for (int i = str.length(); i < size; i++) {
                str.append(" ");
            }
        }
    }

    public static String rightPad(String str, int size) {
        StringBuffer strBuf = new StringBuffer(str);
        rightPad(strBuf, size);
        return strBuf.toString();
    }

    public static void leftPad(StringBuffer str, int size) {
        if (str == null) {
            return;
        }

        if (str.length() > size) {
            str.setLength(size);
        } else {
            for (int i = str.length(); i < size; i++) {
                str.insert(0, " ");
            }
        }
    }

    public static String leftPad(String str, int size) {
        StringBuffer strBuf = new StringBuffer(str);
        leftPad(strBuf, size);
        return strBuf.toString();
    }

    public static String ellipsize(String str, int size) {
        if (str != null && str.length() > size) {
            return str.substring(0, size) + "...";
        }
        return str;
    }

    /**
     * Utility method to calculate the corresponding "local" time from the
     * "system" time, according to the given local timezone. The timezone for
     * the <code>serverDate</code> parameter is assumed to be the default system
     * timezone (specified by the TZ environment variable on UNIX platforms)
     *
     * @param serverDate The input date to convert, assumed to be in the default
     * system timezone
     * @param localTZ The target/local timezone
     * @return A new java.util.Date object corresponding to the local time in
     * the given target/local timezone
     */
    public static java.util.Date convertDateToLocalTime(java.util.Date serverDate, TimeZone localTZ) {

        // This is the timezone configured by the operating system in
        // which the JVM is running. On UNIX hosts, this is typically set by the
        // TZ
        // environment variable.
        TimeZone serverTZ = TimeZone.getDefault();

        // basic calculation
        // LocalTime = ServerTime + (LocalOffsetFromGMT - ServerOffsetFromGMT)
        long serverTime = serverDate.getTime();
        long newOffset = localTZ.getOffset(serverTime) - serverTZ.getOffset(serverTime);

        return new java.util.Date(serverTime + newOffset);
    }


    public static double getElapsedSeconds(LocalDateTime startTime) {
        long msecElapsed = ChronoUnit.MILLIS.between(startTime, LocalDateTime.now());
        double elapsed = msecElapsed / 1000.0;
        return elapsed;
    }

    public static String evaluateYear(String year) {
        String y = year;
        if (StringUtils.isNotEmpty(year) && StringUtils.isNotBlank(year)) {
            Pattern p = Pattern.compile("20(\\d{2})");
            Matcher matcher = p.matcher(year);

            if (matcher.find()) {
                y = matcher.group(1);
            }

        }
        // excel file has 06 and 07 together. we always use 06
        if (y != null && y.equals("07")) {
            y = "06";
        }

        return y;
    }

    public static void ListAllFilesRecursively(Path path, List<Path> files, boolean isRecursive) throws IOException {

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {

            for (Path entry : stream) {
                if (Files.isDirectory(entry) && isRecursive) {
                    ListAllFilesRecursively(entry, files, isRecursive);
                } else {
                    files.add(entry);
                }

            }
        }

    }

    public static String getStringSizeLengthFile(long size) {

        DecimalFormat df = new DecimalFormat("0.00");

        float sizeKb = 1024.0f;
        float sizeMo = sizeKb * sizeKb;
        float sizeGo = sizeMo * sizeKb;
        float sizeTerra = sizeGo * sizeKb;

        if (size < sizeMo) {
            return df.format(size / sizeKb) + " KB";
        } else if (size < sizeGo) {
            return df.format(size / sizeMo) + " MB";
        } else if (size < sizeTerra) {
            return df.format(size / sizeGo) + " Go";
        }

        return "";
    }

    public static String getFileExtension(String name) {

        return name.substring(name.lastIndexOf('.') + 1);
    }

    public static String splitString(String text, int lineSize) {
        if(text==null) return text;
        text=text.trim();
        List<String> formatedText = new ArrayList<>();

        Pattern p = Pattern.compile("\\b.{1," + (lineSize - 1) + "}\\b\\W?");
        Matcher m = p.matcher(text);

        while (m.find()) {
            formatedText.add(m.group());
        }
        return formatedText.stream().map(s -> s.trim()).collect(Collectors.joining("\n"));
    }

    public static String fileHierarchy(String filePath, String srcDocDir) {

        String dir = Arrays.asList(filePath
                .substring(Paths.get(srcDocDir).toFile().getAbsolutePath().length() + 1, filePath.length()).split("\\" + File.separator))
                .stream().limit(DIRECTORY_LEVEL)
                .collect(Collectors.joining(File.separator));
//            String fullDir="";
//            for(String dir:dirList){
//               DynaBean bean=new LazyDynaBean();
//               bean.set("displayDir", dir);
//               fullDir+=File.separator+dir;
//               bean.set("fullDir", fullDir);
//               fileHierarchy.add(bean);
//            }
//            
//            return fileHierarchy;
        return dir;
        //return Arrays.asList(filePath.replaceAll(srcDocDir.replace("\\\\", "\\"+File.separator), filePath));
    }

    public static List<String> fileHierarchyList(String filePath, String srcDocDir) {

        List<String> fileHierarchy = Arrays.asList(filePath
                .substring(Paths.get(srcDocDir).toFile().getAbsolutePath().length() + 1, filePath.length()).split("\\" + File.separator))
                .stream().limit(DIRECTORY_LEVEL)
                .filter(s -> !s.contains(".")) //filter the file out.  no escapse needed
                //                    .map(s->s.replaceAll("Comverse ONE", "C1"))
                //                    .map(s->s.replaceAll("COMVERSE_ONE","C1"))
                .collect(Collectors.toList());
//            String fullDir="";
//            for(String dir:dirList){
//               DynaBean bean=new LazyDynaBean();
//               bean.set("displayDir", dir);
//               fullDir+=File.separator+dir;
//               bean.set("fullDir", fullDir);
//               fileHierarchy.add(bean);
//            }
//            
//            return fileHierarchy;
        return fileHierarchy;
        //return Arrays.asList(filePath.replaceAll(srcDocDir.replace("\\\\", "\\"+File.separator), filePath));
    }

    public static Map<String, String> dirMapping(String dirString) {
        String fullDir = "";
        Map<String, String> mapping = new TreeMap<>();
        if (!StringUtils.isEmpty(dirString)) {
            for (String dir : dirString.split("\\" + File.separator)) {
                fullDir += File.separator + dir;
                mapping.put(dir, fullDir);
            }
        }

        return mapping;

    }

    public static void escapeHtml(DynaBean bean) {
        DynaProperty[] prop = bean.getDynaClass().getDynaProperties();
        Stream.of(prop).forEach(p -> {
            System.err.println("******" + p.getType() + "****" + p.getName() + "****" + bean.get(p.getName()));
            if (p.getType().isInstance(String.class)) {
                bean.set(p.getName(), StringEscapeUtils.escapeHtml4((String) bean.get(p.getName())));
            }
        });

    }

}
