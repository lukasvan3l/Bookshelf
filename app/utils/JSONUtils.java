package utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import play.Logger;

public class JSONUtils {

    public static JSONObject parseJson(String json) {
        if (Utils.isNullOrEmpty(json))
            return null;

        try {
            return new JSONObject(json);
        } catch (JSONException e) {
            Logger.error(e, "Error parsing json: %s", json);
            return null;
        }
    }

    public static JSONArray parseJsonArray(String json) {
        if (Utils.isNullOrEmpty(json))
            return null;

        try {
            return new JSONArray(json);
        } catch (JSONException e) {
            Logger.error(e, "Error parsing json: %s", json);
            return null;
        }
    }

    public static JSONArray getChildArray(JSONObject object, String childName)
    {
    	if (!object.has(childName))
    		return null;
        try {
            return object.getJSONArray(childName);
        } catch (JSONException e) {
            Logger.error("getChildArray(%s) not found in %s", childName, object);
            return null;
        }
    }

    public static JSONObject getChildObject(JSONObject object, String childName)
    {
    	if (!object.has(childName))
    		return null;
        try {
            return object.getJSONObject(childName);
        } catch (JSONException e) {
            Logger.error("getChildObject(%s) not found in %s", childName, object);
            return null;
        }
    }

    public static String getChildString(JSONObject object, String childName)
    {
    	if (!object.has(childName))
    		return null;
        try {
            return object.getString(childName);
        } catch (JSONException e) {
            Logger.error("getChildString(%s) not found in %s", childName, object);
            return null;
        }
    }

    public static Integer getChildInt(JSONObject object, String childName)
    {
    	if (!object.has(childName))
    		return null;
        try {
            return object.getInt(childName);
        } catch (JSONException e) {
            Logger.error("getChildInt(%s) not found in %s", childName, object);
            return null;
        }
    }

    public static Boolean getChildBool(JSONObject object, String childName)
    {
    	if (!object.has(childName))
    		return null;
    	
        try {
            return object.getBoolean(childName);
        } catch (JSONException e) {
            Logger.error("Error getChildBool: %s in %s", childName, object);
            return null;
        }
    }
    
    public static String getObjectName(JSONObject object)
    {
    	 String[] vals = object.getNames(object);
         if (vals.length != 1)
         {
             Logger.error("Invalid: got multiple messageid's for " + object.toString());
             return null;
         }
         String messageIdStr = vals[0];
         return messageIdStr;
    }
    
    public static JSONObject jpathObject(JSONObject object, String jpath)
    {
    	if (jpath.startsWith("/"))
    		jpath = jpath.substring(1);
    	
    	String[] parts = jpath.split("/");
    	int count = 0;
    	for (String part : parts)
    	{
    		count++;
    		if (parts[0].equals("api") && (count == 1 || count == 2))
    			continue;
    		if (!part.isEmpty())
    		{
    			object = getChildObject(object, part);
    			if (object == null)
    				return null;
    		}
    	}
    	return object;
    }

}
