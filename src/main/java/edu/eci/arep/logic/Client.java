package edu.eci.arep.logic;

import edu.eci.arep.logic.Services.SparkWebApp;
import jdk.nashorn.internal.ir.debug.ClassHistogramElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * The type Client that makes a post Request to heroku server and returns a
 * JsonObject with the response.
 */
public class Client {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://secret-spire-04197.herokuapp.com/parcial1");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //System.out.println("COOON "+con);
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        String datos = "1,2,4,56,7";
        //System.out.println("AYUDAAA ---------"+con.getRequestMethod());
        try(OutputStream out = con.getOutputStream()){
            byte[] input = datos.getBytes("utf-8");
            out.write(input,0,input.length);
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"))){
            StringBuilder response = new StringBuilder();
            String rta =null;
            while((rta = br.readLine()) != null){
                response.append(rta.trim());
            }
            System.out.println(response.toString());
        }


    }
}
