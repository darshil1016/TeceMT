package com.tece.Startup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.tece.GetData;
import com.tece.JavaClasses.ProductAdapter;
import com.tece.JavaClasses.ProductAttributes;
import com.tece.R;

import java.util.ArrayList;
import java.util.List;

public class ScannedList extends AppCompatActivity  {


    private List<ProductAttributes> productList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductAdapter mAdapter;
    Button send;
    EditText product_name,product_qrcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_list);
        //recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        send=findViewById(R.id.buttonSend);
        product_name=findViewById(R.id.product_name);
        product_qrcode=findViewById(R.id.product_qrcode);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetData mydata =new GetData();
                int product_message = mydata.doInBackground(product_name.getText().toString(),product_qrcode.getText().toString());
                Toast.makeText(ScannedList.this, ""+product_message, Toast.LENGTH_SHORT).show();
            }
        });


       /* mAdapter = new ProductAdapter(productList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());*/
        //recyclerView.setAdapter(mAdapter);

        /*send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetData mydata =new GetData();
                productList=mydata.doInBackground();
                Toast.makeText(ScannedList.this, ""+productList.size(), Toast.LENGTH_SHORT).show();
                mAdapter=new ProductAdapter(productList);
                mAdapter.notifyDataSetChanged();
            }
        });*/

    }


    public void makeToast(String product_name) {
        Toast.makeText(this, ""+product_name, Toast.LENGTH_SHORT).show();
    }
}
