package com.football.manager.service.impl;

import com.football.manager.service.Parser;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseParser implements Parser {

    protected String startTag;
    protected String endTag;
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