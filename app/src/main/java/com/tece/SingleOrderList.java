package com.tece;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tece.JavaClasses.ProductList;
import com.tece.JavaClasses.SingleOrderListAdapter;

import java.util.ArrayList;
import java.util.List;

public class SingleOrderList extends AppCompatActivity  {

    private List<ProductList> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SingleOrderListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_order_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Context context=SingleOrderList.this;
        mAdapter = new SingleOrderListAdapter(movieList,context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);


        prepareMovieData();



    }

    private void prepareMovieData() {

        ProductList productList = new ProductList("Product 1", "Rack 01", "2015");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 01", "10");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 08", "30");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 07", "70");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 04", "1");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 03", "33");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 07", "21");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 03", "31");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 06", "44");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 04", "22");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 01", "41");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 08", "51");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 07", "66");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 07", "11");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 06", "21");
        movieList.add(productList);

        productList = new ProductList("Product 1", "Rack 05", "53");
        movieList.add(productList);

        mAdapter.notifyDataSetChanged();
    }

    /*@Override
    public void onClick(View view) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SingleOrderList.this);

        //AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("PASSWORD");

        // Setting Dialog Message
        alertDialog.setMessage("Enter Password");
        final EditText input = new EditText(SingleOrderList.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.ic_launcher_background);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        // Write your code here to execute after dialog


                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        dialog.cancel();
                    }
                });

        // closed

        // Showing Alert Message
        alertDialog.show();

    }*/
}
