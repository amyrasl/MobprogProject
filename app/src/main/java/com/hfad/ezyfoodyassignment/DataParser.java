package com.hfad.ezyfoodyassignment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataParser {
    private HashMap<String, String> getSingleNearbyPlace(JSONObject googlePlaceJSON){
        HashMap<String, String> googlePlaceMap = new HashMap<>();
        String NameOfPlace = "-NA-";
        String vicinity = "-NA-";
        String latitude = "-NA-";
        String longitude = "-NA-";
        String reference = "-NA-";

        try {
            if (!googlePlaceJSON.isNull("name")){
                NameOfPlace = googlePlaceJSON.getString("name");
            }
            if (!googlePlaceJSON.isNull("vicinity")){
                NameOfPlace = googlePlaceJSON.getString("name");
            }
            latitude = googlePlaceJSON.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = googlePlaceJSON.getJSONObject("geometry").getJSONObject("location").getString("lat");
            reference = googlePlaceJSON.getString("reference");

            googlePlaceMap.put("place_name",NameOfPlace);
            googlePlaceMap.put("vicinity",vicinity);
            googlePlaceMap.put("lat",latitude);
            googlePlaceMap.put("lng",longitude);
            googlePlaceMap.put("reference",reference);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return googlePlaceMap;
    }

    private List<HashMap<String, String>> getAllNearbyPlaces(JSONArray jsonArray){
        int counter = jsonArray.length();

        List<HashMap<String, String>> NearbyPlaceList = new ArrayList<>();
        HashMap<String,String> NearbyplaceMap = null;

        for(int i=0; i<counter; i++){
            try {
                NearbyplaceMap = getSingleNearbyPlace((JSONObject) jsonArray.get(i));
                NearbyPlaceList.add(NearbyplaceMap);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return NearbyPlaceList;
    }

    public List<HashMap<String, String>> parse(String jSONdata){
        JSONArray jsonArray = null;
        JSONObject jsonObject;

        try {
            jsonObject = new JSONObject(jSONdata);
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getAllNearbyPlaces(jsonArray);
    }

}
