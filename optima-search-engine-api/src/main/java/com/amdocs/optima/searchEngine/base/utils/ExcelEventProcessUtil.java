package com.amdocs.optima.searchEngine.base.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.amdocs.optima.searchEngine.framework.IConstants;
import com.amdocs.optima.searchEngine.framework.IConstants.*;
import com.amdocs.optima.searchEngine.model.docs.APSSAdditionaInfo;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

public class ExcelEventProcessUtil {

    private Logger log = Logger.getLogger(this.getClass().getName());

    public void processAllSheets(File file, IndexWriter writer, Map<String, APSSAdditionaInfo> map, Map<String, APSSAdditionaInfo> descMap, Map<String, APSSAdditionaInfo> acctMap, ApssType type) throws Exception {
        OPCPackage pkg = OPCPackage.open(file.getAbsolutePath());
        XSSFReader r = new XSSFReader(pkg);
        SharedStringsTable sst = r.getSharedStringsTable();

        XMLReader parser = fetchSheetParser(sst, writer, map, descMap, acctMap, extractYearByFileName(file), type);
        XSSFReader.SheetIterator sheets = (XSSFReader.SheetIterator) r.getSheetsData();

        while (sheets.hasNext()) {
            try (InputStream sheet = sheets.next() //System.out.println("sheet name:"+sheets.getSheetName());
                    ) {
                if (file.getName().startsWith(IConstants.PRE_CASE_NOTES_NEW)
                        && !sheets.getSheetName().equals(type.getValue())) {
                    continue;
                }

                //System.out.println("sheet name after:"+sheets.getSheetName());
                InputSource sheetSource = new InputSource(sheet);
                parser.parse(sheetSource);
            }
        }

//		else{
//			Iterator<InputStream> sheets = r.getSheetsData();
//			 while(sheets.hasNext()) {
//					InputStream sheet = sheets.next();
//					InputSource sheetSource = new InputSource(sheet);
//					parser.parse(sheetSource);
//					sheet.close();
//				}
//		}
        //pkg.close();
    }

    public XMLReader fetchSheetParser(SharedStringsTable sst, IndexWriter writer, Map<String, APSSAdditionaInfo> map, Map<String, APSSAdditionaInfo> descMap, Map<String, APSSAdditionaInfo> acctMap, String caseYear, ApssType type) throws SAXException {
        XMLReader parser
                = XMLReaderFactory.createXMLReader(
                        "com.sun.org.apache.xerces.internal.parsers.SAXParser"
                );
        ContentHandler handler = new SheetHandler(sst, writer, map, descMap, acctMap, caseYear, type);
        parser.setContentHandler(handler);
        return parser;
    }

    private String extractYearByFileName(File file) {
        String year = null;

        if (file.getName().startsWith(IConstants.PRE_CASE_NOTES_OLD)) {

            if (file.getAbsolutePath().contains(IConstants.FIRST_EXTRACT)) {
                //file name is like Case Notes extract 2005 and down.xslx		
                year = file.getName().substring(IConstants.PRE_CASE_NOTES_OLD.length(), IConstants.PRE_CASE_NOTES_OLD.length() + 2);

            }
        } else if (file.getName().startsWith(IConstants.PRE_CASE_NOTES_NEW)) {
            year = IConstants.YEAR_TO_DO;
        } else if (file.getAbsolutePath().contains(IConstants.THIRD_EXTRACT)) {
            year = IConstants.YEAR2016;
        } else if (file.getAbsolutePath().contains(IConstants.SECOND_EXTRACT)) {
            year = IConstants.YEAR2015;

        }

        return year;
    }

    /**
     * See org.xml.sax.helpers.DefaultHandler javadocs
     */
    private static class SheetHandler extends DefaultHandler {

        private SharedStringsTable sst;
        private IndexWriter writer;
        private final Map<String, APSSAdditionaInfo> descRamDir;
        private final Map<String, APSSAdditionaInfo> accountRamDir;
        private ApssType type;
        private String caseYear;
        private String lastContents;
        private boolean nextIsString;
        private boolean isHeader = false;
        private int key;
        private Map<Integer, String> headerMap = new HashMap<>();
        private Map<Integer, String> columnMap = new HashMap<>();
        private int count = 0;
        private Logger log = Logger.getLogger(SheetHandler.class);
        private String caseId = null;
        private int lastColKey = 0;
        private Map<String, APSSAdditionaInfo> map;
        private String title;

        Document doc = new Document();
        //StringBuilder sb=new StringBuilder("");

        private SheetHandler(SharedStringsTable sst, IndexWriter writer, Map<String, APSSAdditionaInfo> map, Map<String, APSSAdditionaInfo> descMap, Map<String, APSSAdditionaInfo> acctMap, String caseYear, ApssType type) {
            this.sst = sst;
            this.writer = writer;
            this.caseYear = caseYear;
            this.descRamDir = descMap;
            this.accountRamDir = acctMap;
            this.type = type;
            this.map = map;
        }

        @Override
        public void startElement(String uri, String localName, String name,
                Attributes attributes) throws SAXException {
            // c => cell

//			if ("sheet".equals(name))  {
//				
//			}
            if (name.equals("c")) {
                // Print the cell reference
                headerMap(attributes.getValue("r"));

                // Figure out if the value is an index in the SST
                String cellType = attributes.getValue("t");
                nextIsString = cellType != null && cellType.equals("s");
            }
            // Clear contents cache
            lastContents = "";
        }

        @Override
        public void endElement(String uri, String localName, String name)
                throws SAXException {

            // Process the last contents as required.
            // Do now, as characters() may be called more than once
            if (nextIsString) {
                int idx = Integer.parseInt(lastContents);
                lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
                nextIsString = false;
            }

            // v => contents of a cell
            // Output after we've seen the string contents
            if (name.equals("v")) {
                if (isHeader) {
                    lastColKey = 0;
                    //some excel with DBMS_LOB started but no any content for those columns
                    if (StringUtils.isNotEmpty(lastContents) && !lastContents.startsWith("DBMS_LOB")) {
                        headerMap.put(key, lastContents);
                    }
                } else {

                    if (lastColKey == 0) {
                        lastColKey = headerMap.keySet().stream().max(Integer::compare).get();
                    }

//					if(headerMap.get(key).equals(lastContents)){
//						headerMap.forEach((key,value)->System.out.println(""+key +":"+value));
//						
//					}
                    if (columnMap.isEmpty()) {
                        mapColumnName();
                    }

                    String columnName = columnMap.get(key);
                    //CASE ID for case_account excel has special character in CASE ID column
                    if (key == 'A') {
                        columnName = ApssCaseColumn.CASE_ID.getValue();
                    }
                    //if(type.compareTo(ApssType.DESCP)==0 && headerMap.get(key).equals("Notes"))  columnName=ApssCaseColumn.DESCRIPTION.getValue();

                    boolean isWrite = isNeedIndex(columnName);
//                    if (columnName == null) {
//                        headerMap.forEach((key, value) -> System.out.println("" + key + ":" + value));
//                    }

                    if (key == 'A') {
                        caseId = lastContents;
                    }

                    boolean isPutInMemory = type.compareTo(ApssType.ACCOUNT) == 0 || type.compareTo(ApssType.DESCP) == 0;
                    if (isWrite) {
                        if (isPutInMemory) {
                            if (key != 'A') {
                                if (columnName.equals(ApssCaseColumn.CASE_TITLE.getValue())) {
                                    title = lastContents;
                                } else {
                                    APSSAdditionaInfo additionalInfo=new APSSAdditionaInfo();
                                    if (type.compareTo(ApssType.DESCP) == 0) {
                                        additionalInfo.setTitle(title);
                                        additionalInfo.setDesc(lastContents);
                                        map.put(caseId, additionalInfo);
                                    } else {
                                        additionalInfo.setAccountName(lastContents);
                                        map.put(caseId, additionalInfo);
                                    }

                                }

                            }

                        } else {
                            if (type.compareTo(ApssType.NOTE) == 0 && ApssCaseColumn.ENTRY_YEAR.getValue().equals(columnName)) {
                                lastContents = Utils.evaluateYear(lastContents);
                            }
                            if ((type.compareTo(ApssType.NOTE) == 0 ||type.compareTo(ApssType.SUB_CASE) == 0|| type.compareTo(ApssType.SOLUTION) == 0) 
                                    &&ApssCaseColumn.CASE_ID.getValue().equals(columnName)) {
                                
                                lastContents=lastContents.toLowerCase();
                                //doc.add(new TextField(columnName, lastContents.toLowerCase(), Field.Store.YES));
                            }
//                            if (( type.compareTo(ApssType.SOLUTION) == 0) 
//                                    &&ApssCaseColumn.ENTRY_YEAR.getValue().equals(columnName)) {
//
//                                try {
//                                    lastContents= DateUtils.parseDate(lastContents, "YYYY").toString();
//                                    System.out.println("*******"+lastContents);
//                                } catch (ParseException ex) {
//                                    java.util.logging.Logger.getLogger(ExcelEventProcessUtil.class.getName()).log(Level.SEVERE, null, ex);
//                                }
//                            }
                            doc.add(getFieldOnColumn(columnName));
                            
                            
                        }
                    }

                    //log.debug(headerMap.get(key)+":"+lastContents);
                    //sb.append(mapColumnName(headerMap.get(key))+":"+lastContents);
                    try {
                        //the last column of every row
                        if (key == lastColKey) {

                            if (type.compareTo(ApssType.NOTE) == 0 || type.compareTo(ApssType.SUB_CASE) == 0) {
                                if (!headerMap.containsValue(ApssCaseColumn.ENTRY_YEAR.getValue())) {
                                    //First row will always be case id(A=65)
                                    if (caseYear != null) {
                                        String docYear = Utils.evaluateYear(caseYear.equals(IConstants.YEAR_TO_DO) ? extractYear(caseId) : caseYear);
                                        doc.add(new StringField(ApssCaseColumn.ENTRY_YEAR.getValue(), docYear,
                                                Field.Store.YES));
                                    } 

                                }

                                String descrption = descRamDir.get(caseId) == null ? "" : descRamDir.get(caseId).getDesc();
                                if (!headerMap.containsValue(ApssCaseColumn.CASE_TITLE.getMapSource().get(0))) {
                                    String caseTitle = descRamDir.get(caseId) == null ? "" : descRamDir.get(caseId).getTitle();
                                    if (StringUtils.isEmpty(caseTitle)) {
                                        caseTitle = "";
                                    }
                                    doc.add(new TextField(ApssCaseColumn.CASE_TITLE.getValue(), caseTitle,Field.Store.YES));
                                }
                                if (StringUtils.isEmpty(descrption)) {
                                    descrption = "n/a";
                                }
                                doc.add(new TextField(ApssCaseColumn.DESCRIPTION.getValue(), descrption,
                                        Field.Store.YES));

                                if (!headerMap.containsValue(ApssCaseColumn.ACCOUNT_NAME.getMapSource().get(0))) {
                                    if (type.compareTo(ApssType.SUB_CASE) == 0) {
                                        Pattern p=Pattern.compile("(.*)-[0-9]+");
                                        Matcher m=p.matcher(caseId);
                                        //use case id instead of sub case id to get account number
                                        if(m.find()) caseId=m.group(1); 
                                    }
                                    String accountName = accountRamDir.get(caseId)==null?"":accountRamDir.get(caseId).getAccountName();
                                    if (StringUtils.isEmpty(accountName)) {
                                        accountName = "";
                                    }
                                    doc.add(new StringField(ApssCaseColumn.ACCOUNT_NAME.getValue(), accountName,
                                            Field.Store.YES));
                                }

                            }


                            if (!isPutInMemory) {
                                writer.addDocument(doc);

                                doc = new Document();
                            }

                            //log.trace("adding case id=" + caseId);
                            //System.out.println(sb.toString());
                            //sb=new StringBuilder("");
                            count++;
                        }

                    } catch (IOException e) {
                        throw new SAXException(e.getMessage());
                    }

                }
            }

        }

        private Field getFieldOnColumn(String columnName) {
            Field field = new StringField(columnName, lastContents, Field.Store.YES);
            if (Stream.of(ApssCaseColumn.DESCRIPTION, ApssCaseColumn.CASE_TITLE,
                    ApssCaseColumn.EMAIL_NOTES, ApssCaseColumn.NOTE_TEXT, ApssCaseColumn.PHONE_LOG,
                    ApssCaseColumn.RESOLUTION_TITLE,ApssCaseColumn.RESOLUTION_DESC)
                    .anyMatch(f -> f.getValue().equals(columnName))) {

                field = new TextField(columnName, lastContents, Field.Store.YES);
            }

            return field;
        }

        private boolean isNeedIndex(String columnName) {
            boolean isWrite = false;
            if (type.compareTo(ApssType.NOTE) == 0 ||type.compareTo(ApssType.SUB_CASE) == 0
                    ||type.compareTo(ApssType.SOLUTION) == 0|| columnName.equals(ApssCaseColumn.CASE_ID.getValue())) {
                isWrite = true;
            } else if (type.compareTo(ApssType.DESCP) == 0 && (columnName.equals(ApssCaseColumn.DESCRIPTION.getValue()) || columnName.equals(ApssCaseColumn.CASE_TITLE.getValue()))) {
                isWrite = true;
            } else if (type.compareTo(ApssType.EMAIL) == 0 && columnName.equals(ApssCaseColumn.EMAIL_NOTES.getValue())) {
                isWrite = true;
            }  else if (type.compareTo(ApssType.PHONE) == 0 && columnName.equals(ApssCaseColumn.PHONE_LOG.getValue())) {
                isWrite = true;
            } else if (type.compareTo(ApssType.ACCOUNT) == 0 && columnName.equals(ApssCaseColumn.ACCOUNT_NAME.getValue())) {
                isWrite = true;
            }

            return isWrite;
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            lastContents += new String(ch, start, length);
        }

        private void headerMap(String rAttribute) {
            isHeader = false;
            Pattern p = Pattern.compile("([A-Z])(\\d+)");
            Matcher matcher = p.matcher(rAttribute);
            String seq = null;
            if (matcher.find()) {
                key = matcher.group(1).charAt(0);
                seq = matcher.group(2);
                isHeader = (seq != null && seq.equals("1"));
            }

        }

        private String extractYear(String caseId) {

            Pattern pattern = Pattern.compile("\\d*-\\d{2}\\d{2}(\\d{2})-*");
            Matcher matcher = pattern.matcher(caseId);
            String year = null;
            if (matcher.find()) {
                year = matcher.group(1);
            }
            return year;
        }

        private void mapColumnName() {
            //String caseId=null;
//			if(id!=null&&(id.equals("Case ID")||id.equals("CASE_ID")||id.equals("Id Number"))){
//				caseId=CASE_ID;
//			}

            headerMap.forEach((k, v) -> {
                String columN = Stream.of(ApssCaseColumn.values())
                        .filter(e -> e.getMapSource().contains(type.getValue().concat(v)))
                        .findFirst().map(ApssCaseColumn::getValue).orElse(v);

                if (columN.equals(v)) {
                    columN = Stream.of(ApssCaseColumn.values())
                            .filter(e -> e.getMapSource().contains(v))
                            .findFirst().map(ApssCaseColumn::getValue).orElse(v);
                }

                columnMap.put(k, columN);

            });

            //columnMap.forEach((k,v)->System.out.println(k+":"+v));
        }

    }

}
