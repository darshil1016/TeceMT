package com.tece;

import android.widget.Toast;

import com.tece.JavaClasses.ProductAttributes;
import com.tece.Startup.ScannedList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alaeddin on 5/21/2017.
 */

public class GetData {

    Connection connect;
    String ConnectionResult = "";
    Boolean isSuccess = false;

    ScannedList scannedList=new ScannedList();
    public List<Map<String,String>> doInBackground() {

        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();
        try
        {
            ConnectionHelper conStr=new ConnectionHelper();
            connect =conStr.connectionclasss();        // Connect to database
            if (connect == null)
            {
                ConnectionResult = "Check Your Internet Access!";
            }
            else
            {
                // Change below query according to your own database.
                String query = "select * from Product";

                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String xx=rs.getString("product_name");
                String xY=rs.getString("product_name");
                System.out.println("Doneeeeee");
                System.out.println("bhai "+xx);

                /*while (rs.next()){
                    Map<String,String> datanum=new HashMap<String,String>();
                    datanum.put("ID",rs.getString("CountryId"));
                    datanum.put("Country",rs.getString("CountryName"));
                    datanum.put("Capital",rs.getString("CapitalCity"));
                    data.add(datanum);
                }*/


                ConnectionResult = " successful";
                isSuccess=true;
                connect.close();
            }
        }
        catch (Exception ex)
        {
            isSuccess = false;
            ConnectionResult = ex.getMessage();
        }

        return data;
    }

    /*public List<ProductAttributes> doInBackground() {

        List<ProductAttributes> data = null;
        data = new ArrayList<ProductAttributes>();
        try
        {
            ConnectionHelper conStr=new ConnectionHelper();
            connect =conStr.connectionclasss();        // Connect to database
            if (connect == null)
            {
                ConnectionResult = "Check Your Internet Access!";
            }
            else
            {
                // Change below query according to your own database.
                String query = "select * from Product";
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    *//*Map<String,String> datanum=new HashMap<String,String>();
                    datanum.put("ID",rs.getString("CountryId"));
                    datanum.put("Country",rs.getString("CountryName"));
                    datanum.put("Capital",rs.getString("CapitalCity"));
                    data.add(datanum);*//*
                    scannedList.makeToast(rs.getString("product_name"));
                    ProductAttributes productAttributes=new ProductAttributes(rs.getInt("product_id"),rs.getString("product_name"),rs.getString("prouduct_qrcode"));
                    System.out.println("Hello bhai"+rs.getString("product_name"));
                    data.add(productAttributes);
                }


                ConnectionResult = " successful";
                isSuccess=true;
                connect.close();
            }
        }
        catch (Exception ex)
        {
            isSuccess = false;
            ConnectionResult = ex.getMessage();
        }

        return data;
    }*/

}
