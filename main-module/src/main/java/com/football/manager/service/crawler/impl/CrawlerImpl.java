package com.football.manager.service.crawler.impl;

import com.football.manager.entity.Task;
import com.football.manager.service.crawler.Crawler;
import com.football.manager.service.crawler.CrawlerException;
import com.football.manager.util.SystemUtil;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

@Service
public class CrawlerImpl implements Crawler {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    private static final String HTTP_METHOD = "GET";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String ACCEPT_ENCODING_KEY = "Accept-Encoding";
    private static final String ACCEPT_ENCODING = "GZIP";

    @Value("${url.pattern}")
    private String urlPattern;

    public CrawlerImpl(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    @Override
    public String get(Task task) {
        try {
            URL url = new URL(getUrl(task));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(HTTP_METHOD);
            con.setRequestProperty(HTTP.USER_AGENT, USER_AGENT);
            con.setRequestProperty(ACCEPT_ENCODING_KEY, ACCEPT_ENCODING);

            checkResponse(con);

            BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(con.getInputStream()), StandardCharsets.UTF_8));

            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            SystemUtil.closeQuietly(in);
            return response.toString();
        } catch (Exception e) {
            String errorMessage = String.format("Unexpected exception during execute task %s", task);
            log.error(errorMessage, e);
            throw new CrawlerException(errorMessage, e);
        }
    }

    private void checkResponse(HttpURLConnection con) throws IOException {
        int responseCode = con.getResponseCode();
        if (responseCode != 200) {
            throw new CrawlerException("Bad response code: " + responseCode);
        }
    }

    private String getUrl(Task task) {
        return urlPattern.replaceAll("%seasonId", String.valueOf(task.getSessionId()))
                .replaceAll("%roundId", String.valueOf(task.getRoundId()))
                .replaceAll("%competitionId", String.valueOf(task.getCompetitionId()))
                .replaceAll("%type", String.valueOf(task.getType()));
    }

}