package com.alocar.backend.web.util; /**
 * Sample Java code for youtube.search.list
 * See instructions for running these code samples locally:
 * https://developers.google.com/explorer-help/guides/code_samples#java
 */

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;

import java.security.GeneralSecurityException;

public class YouTubeUtil {
    public static final String API_KEY = "AIzaSyC_FMeN5J9yh5VK6Q-wlggAxOY9ooxxZeQ";

    private static final String APPLICATION_NAME = "My First Project";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /**
     * Build and return an authorized API client service.
     *
     * @return an authorized API client service
     * @throws GeneralSecurityException, IOException
     */
    public static YouTube getService() throws Exception {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, request -> {
        })
                .setApplicationName(APPLICATION_NAME)
                .build();
    }


}