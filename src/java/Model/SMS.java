/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shyamil
 */
public class SMS {

    private static String mobile;

    public String sendSms(String candidate) {
        try {
            // Construct data

            String apiKey = "apikey=" + URLEncoder.encode("iUVSkuWZTCg-vHCPc4mV99jDwQqYQQGNBbQK5GUMrg", "UTF-8");
            // System.out.println("sms sending process... to "+ SMS.mobile);
            //System.out.println(candidate);
            String message = "&message=" + URLEncoder.encode("You've voted for " + candidate + " party", "UTF-8");
            String sender = "&sender=" + URLEncoder.encode("TXTLCL", "UTF-8");
            String numbers = "&numbers=" + URLEncoder.encode(SMS.mobile, "UTF-8");

            // Send data
            String data = "https://api.textlocal.in/send/?" + apiKey + numbers + message + sender;
            URL url = new URL(data);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String sResult = "";
            while ((line = rd.readLine()) != null) {
                // Process line...
                sResult = sResult + line + " ";
            }
            rd.close();

            return sResult;
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error SMS " + e);
            return "Error " + e;
        } catch (MalformedURLException ex) {
            Logger.getLogger(SMS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void setMobile(String mobile) {
        SMS.mobile = mobile;
        System.out.println("SMS to " + SMS.mobile);
    }

    public String getMobile() {
        return SMS.mobile;
    }

}
