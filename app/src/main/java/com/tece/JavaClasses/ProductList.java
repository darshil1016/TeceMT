package com.tece.JavaClasses;

public class ProductList {
    private String product_name, product_rackno, product_quantity;

    public ProductList() {
    }

    public ProductList(String product_name, String product_rackno, String product_quantity) {
        this.product_name = product_name;
        this.product_rackno = product_rackno;
        this.product_quantity = product_quantity;
    }



    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_rackno() {
        return product_rackno;
    }

    public void setProduct_rackno(String product_rackno) {
        this.product_rackno = product_rackno;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}