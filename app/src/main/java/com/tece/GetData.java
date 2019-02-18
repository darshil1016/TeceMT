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

    public int doInBackground(String product_name,String product_qrcode) {

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
               String query = "select product_id from Product where product_name = '"+product_name+"' and product_qrcode = "+product_qrcode;
                //String query="select product_name from Product where product_name='Fan' and product_qrcode=0";
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while(rs.next())
                {
                    String x= rs.getString("product_id");
                    System.out.print("bhai "+x);
                }



                ConnectionResult = " successful";
                isSuccess=true;
                connect.close();
                return 100;
            }
        }
        catch (Exception ex)
        {
            isSuccess = false;
            ConnectionResult = ex.getMessage();
            return -500;
        }

        return -100;

    }
   /* public List<Map<String,String>> doInBackground() {

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
                String query = "select product_name,product_qrcode from Product";

                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()){
                    Map<String,String> datanum=new HashMap<String,String>();
                    datanum.put("ID","1");
                    datanum.put("Country",rs.getString("product_name"));
                    datanum.put("Capital",rs.getString("product_qrcode"));
                    data.add(datanum);
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
