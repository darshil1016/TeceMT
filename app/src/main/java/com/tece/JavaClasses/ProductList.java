package com.tece.JavaClasses;

public class ProductList {
    private String product_name, product_rackno, product_quantity,product_qr_code,product_rack_qr_code;
    private boolean status;

    public String getProduct_qr_code() {
        return product_qr_code;
    }

    public void setProduct_qr_code(String product_qr_code) {
        this.product_qr_code = product_qr_code;
    }

    public String getProduct_rack_qr_code() {
        return product_rack_qr_code;
    }

    public void setProduct_rack_qr_code(String product_rack_qr_code) {
        this.product_rack_qr_code = product_rack_qr_code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ProductList() {
    }

    public ProductList(String product_name, String product_rackno, String product_quantity,String product_qr_code,String product_rack_qr_code,boolean status) {
        this.product_name = product_name;
        this.product_rackno = product_rackno;
        this.product_quantity = product_quantity;
        this.product_qr_code = product_qr_code;
        this.product_rack_qr_code = product_rack_qr_code;
        this.status = status;

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