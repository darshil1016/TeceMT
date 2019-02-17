package com.tece.JavaClasses;

public class ProductAttributes {

    private int id;
    private String name,qrcode;

    public ProductAttributes(){
    }

    public ProductAttributes(int id,String name,String qrcode) {
        this.id=id;
        this.name=name;
        this.qrcode=qrcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}
