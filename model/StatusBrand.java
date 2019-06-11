package com.example.water.marketplace.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class StatusBrand {
    @SerializedName("Status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Brand> getModelBrandList() {
        return modelBrandList;
    }

    public void setModelBrandList(List<Brand> modelBrandList) {
        this.modelBrandList = modelBrandList;
    }

    @SerializedName("Brand")
    private List<Brand> modelBrandList;






    public static class Brand{
        @SerializedName("id_brand")
        private String id_brand;
        @SerializedName("image_brand")
        private String image_brand;
        @SerializedName("name_brand")
        private String name_brand;
        @SerializedName("rating_brand")
        private String rating_brand;



    public String getId_brand() {
        return id_brand;
    }

    public void setId_brand(String id_brand) {
        this.id_brand = id_brand;
    }

    public String getImage_brand() {
        return image_brand;
    }

    public void setImage_brand(String image_brand) {
        this.image_brand = image_brand;
    }

    public String getName_brand() {
        return name_brand;
    }

    public void setName_brand(String name_brand) {
        this.name_brand = name_brand;
    }

    public String getRating_brand() {
        return rating_brand;
    }

    public void setRating_brand(String rating_brand) {
        this.rating_brand = rating_brand;
    }
} }
