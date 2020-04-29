package com.jn.websocket.demo.config;

import com.jn.audit.core.Auditor;
import com.jn.audit.mq.MessageTopicDispatcher;
import com.jn.websocket.demo.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditConfig {

    private DbService dbService;

    public DbService getDbService() {
        return dbService;
    }

    /**
     * 这是一个自定义的写入数据库的 Consumer
     */
    @Autowired
    public void setDbService(Auditor auditor, DbService dbService) {
        this.dbService = dbService;
        MessageTopicDispatcher dispatcher = auditor.getMessageTopicDispatcher();
        dispatcher.subscribe("DEFAULT", dbService);
    }

}
