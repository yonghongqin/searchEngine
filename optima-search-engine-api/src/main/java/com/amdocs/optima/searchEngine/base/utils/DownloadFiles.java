package com.amdocs.optima.searchEngine.base.utils;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.Properties;

public class DownloadFiles {

    public static void downloadNewFiles(String localFileDir, boolean isRecursive, String remoteFileDir, Predicate<Path> filter) throws IOException {
        Path localFilePath = Paths.get(localFileDir);
        if (!Files.exists(localFilePath)) {
            Files.createDirectory(localFilePath);
        }

        List<Path> localFileNames = getLocalFiles(localFileDir, isRecursive, filter);

        Path sourcePath = Paths.get(remoteFileDir);

        Files.walk(Paths.get(remoteFileDir))
                .filter(s -> !localFilePath.resolve(sourcePath.relativize(s)).toFile().exists())
                .filter(Files::isReadable)
                .forEach(remoteFilePath -> {
                    try {
                        Files.createDirectories(localFilePath.resolve(sourcePath
                                        .relativize(remoteFilePath)));
                        Files.copy(remoteFilePath, localFilePath.resolve(sourcePath.relativize(remoteFilePath)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        Path remoteFilePath = Paths.get(remoteFileDir.replace("\\u0020", "%20"));
        List<Path> remotePath = Files.walk(remoteFilePath).filter(filter)
                .filter(Files::isReadable)
                //.filter(p->localFileNames.contains(p.toFile().getName()))
                .collect(Collectors.toList());

        for (Path path : remotePath) {
            try {
                System.out.println("Copying file" + path.toFile().getAbsolutePath());
                Files.copy(path, Paths.get(localFilePath + File.separator + path.toFile().getName()), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static List<Path> getLocalFiles(String localFileDir, boolean isRecursive, Predicate<Path> filter) throws IOException {

        List<Path> localFileNames = null;
        if (isRecursive) {
            Path localFilePath = Paths.get(localFileDir);
            localFileNames = Files.walk(localFilePath).filter(filter)
                    .filter(Files::isReadable)
                    .collect(Collectors.toList());
        } else {
            localFileNames = Files.list(Paths.get(localFileDir))
                    .filter(Files::isRegularFile)
                    .filter(filter)
                    .collect(Collectors.toList());
        }

        return localFileNames;

    }

    public static void main(String[] args) throws IOException {
//        String remoteFileDir = props.getProperty(IConfiguration.APSS_EXCEL_FILE_REMOTE_DIR);
//        String localFileDir = "C:\\Projects\\Test";
//        //String localFileDir = ConfigurationManager.getInstance().getProperty(IConfiguration.APSS_EXCEL_FILE_PROPERTY);
//        Predicate<Path> filter = path -> path.toFile().getName().endsWith(IConstants.EXCELX);
//        //downloadNewFiles(localFileDir,false,remoteFileDir,filter);
////String remoteFileDir = ConfigurationManager.getInstance().getProperty(IConfiguration.APSS_EXCEL_FILE_PROPERTY);
////		String localFileDir = "C:\\Projects\\Test";
//        Files.walkFileTree(Paths.get(remoteFileDir), new CopyFileVisitor(Paths.get(localFileDir)));
    }

    public static class CopyFileVisitor extends SimpleFileVisitor<Path> {

        private final Path targetPath;
        private Path sourcePath = null;

        public CopyFileVisitor(Path targetPath) {
            this.targetPath = targetPath;
        }

        @Override
        public FileVisitResult preVisitDirectory(final Path dir,
                final BasicFileAttributes attrs) throws IOException {
            if (sourcePath == null) {
                sourcePath = dir;
            } else {
                Files.createDirectories(targetPath.resolve(sourcePath
                        .relativize(dir)));
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(final Path file,
                final BasicFileAttributes attrs) throws IOException {
            Path target = targetPath.resolve(sourcePath.relativize(file));
            if (!target.toFile().exists()) {
                Files.copy(file, target);
            }
            return FileVisitResult.CONTINUE;
        }
    }

    private Properties props;


    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

}
