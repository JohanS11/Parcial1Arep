package edu.eci.arep.logic.Services;

import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Json build.
 * @author Johan Sebastian Arias
 */
public class JsonBuild {

    /**
     * Get json string.
     *
     * @param arr the arraylist
     * @return the string
     */
    public static JSONObject toJson(double mean,double sum,List<Double> arr) {
        JSONObject jsObject = new JSONObject();
        jsObject.put("Mean", mean);
        jsObject.put("Addition", sum);
        jsObject.put("SortedArray", arr);
        return jsObject;
    }
}