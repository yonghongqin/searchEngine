package com.amdocs.optima.searchEngine.framework;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;

public interface IConstants {


    /**
     * APSS
     */
    public static String APSS = "apss";
    public static String APSS_SOLUTION = "solution";
    public static String APSS_REVIEW = "apssReview";
    public static String APSS_ACCOUNTS = "accountSet";
    public static String APSS_YEAR = "yearSet";
    public static String APSS_PRODUCT_LINE = "productLineSet";
    public static String CQ_SERVICE_NAME = "serviceNameSet";
    public static String CQ_CBS_MODULE = "cbsMoudleSet";
    public static String DOC_TYPES = "dcoTypeSet";
    public static String ALL_ACCOUNTS = "All Accounts";
    public static String ALL_YEARS = "All Years";
    public static String ALL_PRODUCT_LINES = "All Product Lines";


    /**
     * Session Keys
     */
    // Used to store the "User" JavaBean corresponding to the currently logged in user into
    // the session scope
    public static String SESSION_USER_KEY = "session.User";
    public static String SESSION_TIMEZONE_KEY = "session.TimeZone";

    // This is the application's context name, which is primarily used as a qualifier on permissions
    // So the fully qualified name for the permission "LoginPermission" would be "<ContextName>.LoginPermission"
    // This is so other applications can create their own permissions with the same name but a
    // different context name
    public static String APPLICATION_CONTEXT_NAME = "WebManager";
    public static final String SEARCH_OPTIMA_GLOBAL_ERROR = "GlobalError";
    public static final String FILTER_DOC_TYPE = "filterDocType";
    public static final String SUB_INDEX_DIR_SECOND = "subIndexDirSecond";
    public static final String SUB_INDEX_DIR_FIRST = "subIndexDirFirst";
    public static final String CBS_MODULE = "cbsModule";
    public static final String SERVICE_NAME = "serviceName";
    public static final int CQ_FETCH_SIZE = 1000;
    public static final int PAGE_SIZE = 25;
    public static final String SESSION_SEARCH_RESULT = "pagedListHolder";
    public static final String MODEL_ATTRIBUTE_ACCOUNT_LIST = "accountList";
    public static final String SEARCH_OPTIMA_RESULT_VIEW = "SearchOptima";
    public static final String MODLE_ATTRIBUTE_PRODUCTION_LINE_LIST = "productionLineList";
    public static final String MODEL_ATTRIBUTE_YEAR_LIST = "yearList";
    public static final String MODEL_ATTRIBUTE_SERVICE_NAME_LIST = "serviceNameList";
    public static final String MODEL_ATTRIBUTE_CBS_MODULE_LIST = "cbsModuleList";
    public static String MODEL_ATTRIBUTE_DDTS_PROJECT_LIST = "ddtsProjectList";
    public static String MODEL_ATTRIBUTE_DDTS_VERSION_LIST = "ddtsVersionList";
    public static String MODLE_ATTRIBUTE_DDTS_MODULE_LINE_LIST = "ddtsModuleList";
    static final String MODEL_ATTRIBUTE_DOC_TYPE_LIST = "docTypeList";
    static final String MODEL_ATTRIBUTE_DIR_FIRST_LIST = "dirFirstList";
    static final String MODEL_ATTRIBUTE_DIR_SECOND_LIST = "dirSecondList";
    static String MODEL_ATTRIBUTE_TFS_ITEM_TYPE_LIST = "workItemTypeList";
    public static String ACCOUNT="Account";
    public static String STATUS="Status";
    public static String STATE="State";
    public static String ACTIVATED_DATE="ActivatedDate";
    public static String WORK_ITEM_TYPE="WorkItemType";  
    String HISTORY="History";
    String TFS= "tfs"; 
    String DDTS_PROJECT= "project";
    String DDTS_MODULE = "module";
    String DDTS_VERSION="version";
    
    String CALL_LOG="callLog";
    String JOURNALS="journals";
    

    String HIGHLIGHT_LEFT = "<span class=\"hl\"><strong><font color=\"#9932CC\">";
    String HIGHLIGHT_RIGHT = "</font></strong></span>";
    // highlight stuff
    SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(HIGHLIGHT_LEFT, HIGHLIGHT_RIGHT);
    Map<String,Float> boostMap=new HashMap<String,Float>() {
            {put(SEARCH_TITLE,100f);
             put(SEARCH_ID,100f);
            }
        };
     String FEB2016_TO_APR17_SUBCASE = "Subcases Feb 16-April-17-Notes";
     String FEB2016_TO_APR17_SOLUTION = "Solutions Feb 16-April-17";
     String FEB2016_TO_APR17__TITLE_DESC = "Cases Feb 16-April-17- Title and Desc";
     String FILTER_ACCTS = "filterAccts";
     String FILTER_PROD_LINES = "filterProdLines";
     String FILTER_YEARS = "filterYears";
     String FILTER_CBS_MODULE = "filterCbsModule";
     String FILTER_SERVICE_NAME = "filterServiceName";
     String SEARCH_CONTENT = "content";
     String DESCRIPTION = "Description";
    String IS_SOLUTION= "isSolution";
    String IS_SUB_CASE = "isSubCase";
    String FIRST_DIR_TYPES = "firstDirTypes";
    String SECOND_DIR_TYPES = "secondDirTypes";
    String INDEX_FILE_HIERARCHY_FRIST = "dirFirst";
    String INDEX_FILE_HIERARCHY_SECOND = "dirSecond";
    String INDEX_FILE_HIERARCHY = "dir";
    String INDEX_APSS_SOLUTION_DIR = File.separator + "solution";
    String RELEASE_NUMBER = "releaseNumber";
    String ENTITY_TYPE = "entityType";
    String PRODUCT_LINE = "productLine";
    String NOTE_TYPE = "noteType";
    String NOTE_TEXT = "noteText";
    String FIRST_EXTRACT = "First Extract";
    String SECOND_EXTRACT = "Second extract";
    String THIRD_EXTRACT = "Third extract";
    String PRE_CASE_NOTES_OLD = "Case Notes extract 20";
    String PRE_CASE_NOTES_NEW = "KC1 History Notes Report";
    String YEAR2015 = "15";
    String YEAR2016 = "16";
    String YEAR_TO_DO = "TODO";
    String ENTRY_YEAR = "Entry Year";
    String INDEX_CASE_ONLY_DIR = File.separator + "case";
    String INDEX_EMAILS_DIR = File.separator + "email";
    int MAX_RESULTS = 100;
    String SEARCH_ID = "id";
    String SEARCH_TYPE = "type";
    String SEARCH_SCORE = "score";
    String SEARCH_BEST_FRAGMENT = "bestFragment";
    String SEARCH_LINK = "link";
    String SEARCH_URL = "url";
    String SEARCH_TITLE = "title";
    String INDEX_SUB_CASE_DESC_DIR = File.separator + "subCase";
    String INDEX_CASE_PHONE_DIR = File.separator + "phone";

    String INDEX_FILE_CONTENT = "fileContent";
    String INDEX_FILE_NAME = "fileName";
    String INDEX_FILE_ID = "fileId";
    String INDEX_FILE_LOCATION = "url";

    String PDF = ".pdf";
    String MSDOC = ".doc";
    String MS2003DOC = ".docx";
    String PPTX = ".ppt";
    String PPT = ".pptx";
    String EXCEL = ".xls";
    String EXCELX = ".xlsx";
    String MOP_CATEGORY = "filterMopCategory";
    String DOC_TYPE = "filterDocType";
    String MOP_CATEGORY_LIST = "mopCategorys";
    String PRODUCT_MANUAL_MAP = "productManualMap";
    String APSS_SOLUTION__TYPE = "Solution Type";
    String INDEX_FILE_EXT = "ext";
    String INDEX_FILE_SIZE = "size";

    int LENGTH_PER_LINE = 100;

    public String OPTIMA_SEARCH_USER = "optimasearch";

    public int OPTIMA_SEARCH_USER_ID = 0;
    public int OPTIMA_VIEW_USER_ID = -1;
    public int DEBUG_OPTIMA_SEARCH_USER_ID = -2;
    public int DEBUG_OPTIMA_VIEW_USER_ID = -3;
/*
    enum TfsColumn{
        SEARCH_ID("id"),
        SEARCH_TITLE("title"),
        WORK_ITEM_TYPE("System.WorkItemType"),
        ASSIGNED_TO(System.AssignedTo(),
        TEAM_PROJECT(System.TeamProject,
        DESCRIPTION(System.Description,
        HISTORY(System.History,
        REASON(System.Reason,
        STATE(System.State,
        TEST_PATH(Microsoft.VSTS.Test.TestPath,
        ACTIVATED_DATE(Microsoft.VSTS.Common.ActivatedDate,
        ISSUE(Microsoft.VSTS.Common.Issue,
        EXIT_CRITERIA(Microsoft.VSTS.Common.ExitCriteria,
        RANK(Microsoft.VSTS.Common.Rank,
        RELATED_WORK_ITEM(Microsoft.VSTS.Common.RelatedWorkItems,
        REJECTION_REASON(Microsoft.VSTS.Common.RejectionReason,
        REPRO_STEPS(Microsoft.VSTS.TCM.ReproSteps,
        ACCOUNT(NBU.Account,
        QA_REQUIRED(NBU.QARequired,
        STATUS(NBU.Status,
        BUG_TYPE(NBU.BugType,
        FOUND_AT(NBU.FoundAt,
        AREA_ID(System.AreaId,
        AREA_PATH(System.AreaPath
    }
    */
    enum ApssCaseColumn {
        CASE_ID("id", Arrays.asList("Case ID", "CASE_ID", "Case_ID", "Id Number", "Subcase ID", "Solution ID")),
        RELEASE_NUMBER("releaseNumber", Arrays.asList("RELEASE_#", "Instance Version")),
        ENTITY_TYPE("entityType", Arrays.asList("ENTITY_TYPE", "Entity Type")),
        PRODUCT_LINE("productLine", Arrays.asList("PRODUCT_LINE", "Product Line")),
        NOTE_TYPE("noteType", Arrays.asList("NOTE_TYPE", "Action Type", "Activity Name")),
        NOTE_TEXT("noteText", Arrays.asList("NOTE_TEXT", "Notes", "Note Text")),
        ENTRY_YEAR("year", Arrays.asList("Entry Year","Creation Date")),
        ACCOUNT_NAME("acct", Arrays.asList("Account Name")),
        DESCRIPTION("desc", Arrays.asList(ApssType.DESCP.getValue() + "NOTE_TEXT", ApssType.DESCP.getValue() + "Notes","Problem Description")),
        CASE_TITLE("title", Arrays.asList("Case Title","Solution Title")),
        SOLUTION_DESC("solutionDesc", Arrays.asList("Resolution Description")),
        RESOLUTION_TITLE("resTitle", Arrays.asList("Resolution Title")),
        RESOLUTION_DESC("resDes", Arrays.asList("Resolution Description")),
        EMAIL_NOTES("noteText", Arrays.asList(ApssType.EMAIL.getValue() + "Notes", ApssType.DESCP.getValue() + "NOTE_TEXT", ApssType.DESCP.getValue() + "Note Text")),
        SUB_CASE("noteText", Arrays.asList("Note/E-mail/Phone Details", ApssType.SUB_CASE + "Notes")),
        PHONE_LOG("noteText", Arrays.asList(ApssType.PHONE.getValue() + "NOTE_TEXT")),
        ASSOCIATED_CASE_ID("associatedCaseId", Arrays.asList("Solution Associated Cases.ID Number")),
        ASSOCIATED_CR_ID("associatedCrId", Arrays.asList( "Solution Associated CRs.ID Number"));

        private String value;
        private List<String> mapSource;

        private ApssCaseColumn(String value, List<String> mapSource) {
            this.value = value;
            this.mapSource = mapSource;

        }

        public String getValue() {
            return value;
        }

        public List<String> getMapSource() {
            return mapSource;
        }

    }

    
    enum ApssType {
        NOTE("Notes"), DESCP("Description"), EMAIL("Emails"), SUB_CASE("Subcase"), PHONE("Phones"),
         SOLUTION("Solution"), ACCOUNT("Account"), DEFAULT("DEFAULT");

        private String value;

        private ApssType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum SearchOptions {
        searchAll(0),searchClearQuest(1), searchAPSS(2), searchListPicks(3),searchDOC(4), searchMopRcA(5), 
        searchTraining(6),searchTRAC(7), searchDDTS(8), searchTFS(9);
        
        private final int value;

        private SearchOptions(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }
 
    enum PageAttributes {
        query, pg, pgsz, page, pageSize, nextPage, prevPage, lastPage, start, end, hits,
        elapsed, searchNum
        

    }

    enum AdvancedSearchAttributes {
        year, release, account, module, servicename

    }

    enum DocumentTypeExtension {
        PDF("pdf", Arrays.asList("pdf")),
        DOC("doc", Arrays.asList("doc", "docx")),
        PPT("ppt", Arrays.asList("ppt", "pptx")),
        EXCEL("excel", Arrays.asList("xls", "xlsx")),
        VIDEO("video", Arrays.asList("mp3", "mp4", "swf", "wrf")),
        ELEARNING("elearning", Arrays.asList("elearning"));

        private String value;
        private List<String> mapSource;

        private DocumentTypeExtension(String value, List<String> mapSource) {
            this.value = value;
            this.mapSource = mapSource;

        }

        public String getValue() {
            return value;
        }

        public List<String> getMapSource() {
            return mapSource;
        }

    }

    

    enum TfsFieldsMapping {
        ID("ID", "ID"),
        TITLE("Title", "title"),
        PPT("Description", "description"),
        EXCEL("Work Item Type","workItemType"),
        VIDEO("Assigned To","assignedTo"),
        ELEARNING("elearning","elearning");

        private String value;
        private String mapSource;

        private TfsFieldsMapping(String value, String mapSource) {
            this.value = value;
            this.mapSource = mapSource;

        }

        public String getValue() {
            return value;
        }

        public String getMapSource() {
            return mapSource;
        }

    }

    

        
}
