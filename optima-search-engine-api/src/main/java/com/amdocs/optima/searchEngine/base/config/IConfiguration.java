package com.amdocs.optima.searchEngine.base.config;

interface IConfiguration {

    String TRAC_LUCENE_INDEX_PROPERTY = "webtrac.lucene.index.dir";
    String TRAC_URL_REDIRECT = "webtrac.url.redirect";

    String DEFECTREVIEW_LUCENE_INDEX_PROPERTY = "defectreview.lucene.index.dir";
    String DEFECTREVIEW_URL_REDIRECT = "defectreview.url.redirect";

    String CQ_LUCENE_INDEX_PROPERTY = "clearquest.lucene.index.dir";
    String CQ_URL_REDIRECT = "clearquest.url.redirect";

    String DDTS_INDEX_PROPERTY = "ddts.lucene.index.dir";
    String DDTS_URL_REDIRECT = "ddts.url.redirect";
    String DDTS_VIEW_URL = "ddts.url.view";

    String LISTPICKS_SOURCE_DIR_PROPERTY = "listpicks.source.dir";
    String LISTPICKS_INDEX_PROPERTY = "listpicks.lucene.index.dir";
    String LISTPICKS_REDIRECT = "listpicks.url.redirect";

    String APSS_LUCENE_INDEX_PROPERTY = "apss.lucene.index.dir";
    String APSS_URL_REDIRECT = "apss.url.redirect";
    String APSS_SOLUTION_URL_REDIRECT = "apss.solution.url.redirect";

    String APSS_EXCEL_FILE_PROPERTY = "apss.excel.dir";
    String APSS_EXCEL_FILE_REMOTE_DIR = "apss.excel.remote.location";
    
    String INDEX_APSS_ATTCHMENTS_LOCATION = "index.apss.attachments.dir";
    String SRC_APSS_ATTCHMENTS_LOCATION = "source.apss.attachments.dir";
    String SRC_APSS_ATTCHMENTS_NEWWORK_LOCATION = "source.apss.attachments.network.dir";

    String SRC_PRODUCT_MANUAL_LOCATION = "source.productManual.dir";
    String INDEX_PRODUCT_MANUAL_LOCATION = "index.productManual.dir";
    String PRODUCT_MANUAL_URL_REDIRECT = "productManual.url.redirect";
    String SRC_PRODUCT_MANUAL_NEWWORK_LOCATION = "source.productManual.network.dir";

    String INDEX_MOP_RCA_LOCATION = "index.moprca.dir";
    String SRC_MOP_RCA_LOCATION = "source.moprca.dir";
    String SRC_MOP_RCA_NEWWORK_LOCATION = "source.moprca.network.dir";

    String SRC_TRAINING_LOCATION = "source.training.dir";
    String INDEX_TRAINING_LOCATION = "index.training.dir";
    String SRC_TRAINING_NEWWORK_LOCATION = "source.training.network.dir";
    String ELEARNING_URL_REDIRECT = "elearning.url.redirect";

    String TFS_LUCENE_INDEX_PROPERTY = "tfs.lucene.index.dir";
    String IS_DEBUG = "testing.isDebug";
    String DEBUG_SEARCH_USER_ID = "testing.search.userId";
    String DEBUG_VIEW_USER_ID = "testing.view.userId";
    String TFS_URL_USERNAME = "tfs.url.username";
    String TFS_URL_REDIRECT = "tfs.url.redirect";
    String TFS_URL_PASSWORD = "tfs.url.password";
    String TFS_NATIVE_DIR = "tfs.native.dir";
    String TFS_URL_LINK = "tfs.url.link";
    String TFS_REST_URL= "tfs.rest.url";
   

}
