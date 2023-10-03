package com.luismcodes.notification.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.luismcodes.notification.entity.Notification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationReferentialUtil {

    public static String getJsonAttribute(String jsonString, String jsonAttribute) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonString);
            return jsonObject.getString(jsonAttribute);
        } catch (JSONException e) {
            log.error("Error occured while reading attribute from Json " + e);
            return null;
        }
    }

    public static String convertValue(Notification notification) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(notification);
    }
}
