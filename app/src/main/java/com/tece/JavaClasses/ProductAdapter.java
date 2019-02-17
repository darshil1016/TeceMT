package com.tece.JavaClasses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tece.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<ProductAttributes> productList;

    public ProductAdapter(List<ProductAttributes> productList){
        this.productList=productList;
    }
    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_attributes_recycler_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int i) {

        ProductAttributes productAttributes=productList.get(i);
        holder.product_id.setText(productAttributes.getId());
        holder.product_name.setText(productAttributes.getName());
        holder.product_qrcode.setText(productAttributes.getQrcode());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView product_id,product_name,product_qrcode;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            product_id=itemView.findViewById(R.id.product_id);
            product_name=itemView.findViewById(R.id.product_name);
            product_qrcode=itemView.findViewById(R.id.product_qrcode);
        }
    }
}
