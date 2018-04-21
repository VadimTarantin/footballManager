package com.football.manager.service.impl;

import com.football.manager.service.Parser;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseParser implements Parser {

    @Value("${wide.table.parser.start.tag}")
    protected String startTag;
    @Value("${wide.table.parser.end.tag}")
    protected String endTag;
    @Value("${wide.table.parser.entities.to.cut}")
    protected List<String> entitiesToCut = new ArrayList<>();

    public void setStartTag(String startTag) {
        this.startTag = startTag;
    }

    public void setEndTag(String endTag) {
        this.endTag = endTag;
    }

    public void setEntitiesToCut(List<String> entitiesToCut) {
        this.entitiesToCut = entitiesToCut;
    }

    protected String cutTable(String response){
        int start = response.indexOf(startTag);
        int end = response.indexOf(endTag);
        String content = response.substring(start, end + endTag.length());
        return cutEntities(content);
    }

    protected String cutEntities(String content) {
        for (String entity : entitiesToCut) {
            content = content.replaceAll(entity, "");
        }
        return content;
    }

}