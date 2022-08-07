package online.db.model.dto;

import online.db.model.enums.FourCategory;

public class ProductsRequest {

    private String manufacturer;
    private String model;
    private int weight;
    private Double price;
    private String about;

    private FourCategory fourCategory;
}
