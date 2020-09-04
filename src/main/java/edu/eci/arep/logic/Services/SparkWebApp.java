package edu.eci.arep.logic.Services;
import edu.eci.arep.logic.Model.LinkedList;
import edu.eci.arep.logic.Services.SortAlgorithm.BubbleSort;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

/**
 * This is a simple WebApplication deployed in Heroku using SparkWeb.
 * @author Johan Arias
 */

public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
        post("/parcial1",(req, response) -> {

            response.status(200);
            response.type("application/json");
            LinkedList<Double> linkedList = new LinkedList<Double>();
            Calculator calculator = new Calculator();
            List arr = new ArrayList<Double>();
            String [] data = req.body().split(",");

            for (String datum : data) {
                linkedList.addNodeRight(Double.parseDouble(datum));
                arr.add(Double.parseDouble(datum));
            }
            double mean = calculator.calcMean(linkedList);
            double sd = calculator.calcSum(linkedList);
            arr = BubbleSort.sort(arr);
            return JsonBuild.toJson(mean,sd,arr);
        });

    }

    /**
     * @param req This is the object that represents the HTTP request
     *            in order to retrieve a resource from the web server.
     * @param res This is the object that represents the HTTP response
     *            given by the webserver
     * @return A string with html code that will build the web page, in this case
     *          the resource located at /inputdata
     */
    private static String inputDataPage(Request req, Response res) {
        return "<!DOCTYPE html>"
        + "<html>"
        + "<body>"
        + "<h2>PARCIAL 1 AREP</h2>"
        + "<p> Insert a set of numbers separated by a <br> " +
                "comma and we will calculate the mean and standard deviation </p>"
        + "<form action=\"/results\">"
        + "  Data set:<br>"
        + "  <input type=\"text\" name=\"data\" >"
        + "  <br>"
        + "  <input type=\"submit\" value=\"Submit\">"
        + "</form>"
        + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
        + "</body>"
        + "</html>";
    }

    /**
     * This method retrieves a data set from a parameter from the resource "inputdata"
     * called data and builds the webpage based on this set.
     * @param req This is the object that represents the HTTP request
     *             in order to retrieve a resource from the web server.
     * @param res This is the object that represents the HTTP response
     *      *            given by the webserver
     * @return A string with html code that will build the web page, in this case
     *      *          the resource located at /results
     */
    private static JSONObject resultsPage(Request req, Response res) {

        LinkedList<Double> linkedList = new LinkedList<Double>();
        Calculator calculator = new Calculator();
        List arr = new ArrayList<Double>();
        String [] data = req.queryParams("data").split(",");

        for (String datum : data) {
            linkedList.addNodeRight(Double.parseDouble(datum));
            arr.add(Double.parseDouble(datum));
        }
        double mean = calculator.calcMean(linkedList);
        double sd = calculator.calcSum(linkedList);
        arr = BubbleSort.sort(arr);
        return JsonBuild.toJson(mean,sd,arr);
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }


}
