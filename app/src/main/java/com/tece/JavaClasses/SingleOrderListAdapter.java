package com.tece.JavaClasses;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tece.R;

import java.util.List;

public class SingleOrderListAdapter extends RecyclerView.Adapter<SingleOrderListAdapter.MyViewHolder> {

    private List<ProductList> orderList;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView product_name, product_quantity, product_rackno;
        public RelativeLayout parentLayout;
        public ImageView imageView;


        public MyViewHolder(View view) {
            super(view);
            product_name = view.findViewById(R.id.product_name);
            product_rackno = view.findViewById(R.id.product_rackno);
            product_quantity = view.findViewById(R.id.product_quantity);
            parentLayout = view.findViewById(R.id.parent_layout);
            imageView = view.findViewById(R.id.status);
        }
    }


    public SingleOrderListAdapter(List<ProductList> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout_singleorderlist, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ProductList productList = orderList.get(position);
        holder.product_name.setText("Name :"+productList.getProduct_name());
        holder.product_rackno.setText("Rack No :"+productList.getProduct_rackno());
        holder.product_quantity.setText("Required Quantity "+productList.getProduct_quantity());
        if(productList.isStatus())
        {
            holder.imageView.setBackgroundResource(R.drawable.status_done);
        }
        else
        {
            holder.imageView.setBackgroundResource(R.drawable.status_notdone);

        }
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "hey "+position , Toast.LENGTH_SHORT).show();

                showRackNoAlert(position,holder);

            }
        });

    }

    private void showRackNoAlert(final int position, final MyViewHolder holder) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        //AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Rack No");

        // Setting Dialog Message
        alertDialog.setMessage("Scan or enter rack no");
        final EditText rackno = new EditText(context);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        rackno.setLayoutParams(lp);
        alertDialog.setView(rackno);

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.ic_launcher_background);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("Scan product",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        // Write your code here to execute after dialog
                        ProductList productList = orderList.get(position);
                        Toast.makeText(context, ""+rackno.getText().toString(), Toast.LENGTH_SHORT).show();
                        if(rackno.getText().toString().equals(productList.getProduct_rack_qr_code())) {
                            showProductAlert(rackno.getText().toString(), position,holder);
                        }
                        else
                        {
                            Toast.makeText(context,"wrong rack qr", Toast.LENGTH_SHORT).show();

                        }

                    }

                    private void showProductAlert(final String toString, final int position, final MyViewHolder holder) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

                        //AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                        // Setting Dialog Title
                        alertDialog.setTitle("Product");

                        // Setting Dialog Message
                        alertDialog.setMessage("Scan or enter product code");
                        final EditText productqrcode = new EditText(context);
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.MATCH_PARENT);
                        productqrcode.setLayoutParams(lp);
                        alertDialog.setView(productqrcode);

                        // Setting Icon to Dialog
                        alertDialog.setIcon(R.drawable.ic_launcher_background);

                        // Setting Positive "Yes" Button
                        alertDialog.setPositiveButton("Done",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int which) {
                                        // Write your code here to execute after dialog
                                        ProductList productList= orderList.get(position);
                                        Toast.makeText(context, "Rack no is "+toString+" and product code is "+productqrcode.getText().toString(), Toast.LENGTH_SHORT).show();
                                        if(productList.getProduct_qr_code().equals(productqrcode.getText().toString()))
                                        {
                                            productList.setStatus(true);
                                            Toast.makeText(context,"Success", Toast.LENGTH_SHORT).show();
                                            holder.imageView.setBackgroundResource(R.drawable.status_done);
                                        }
                                        else
                                        {
                                            Toast.makeText(context,"wrong qr", Toast.LENGTH_SHORT).show();

                                        }

                                    }
                                });
                        // Setting Negative "NO" Button
                        alertDialog.setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Write your code here to execute after dialog
                                        dialog.cancel();
                                    }
                                });

                        // closed

                        // Showing Alert Message
                        alertDialog.show();

                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        dialog.cancel();
                    }
                });

        // closed

        // Showing Alert Message
        alertDialog.show();
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
