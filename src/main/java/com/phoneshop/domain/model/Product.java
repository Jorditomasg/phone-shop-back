package com.phoneshop.domain.model;

import lombok.Data;
import java.util.List;

@Data
public class Product {
    private String id;
    private String brand;
    private String model;
    private Double price;
    private String cpu;
    private String ram;
    private String os;
    private String displayResolution;
    private String battery;
    private String cameras;
    private String dimensions;
    private String weight;
    private String imageUrl;
    private List<ColorOption> colors;
    private List<StorageOption> storages;

    @Data
    public static class ColorOption {
        private String code;
        private String name;
    }

    @Data
    public static class StorageOption {
        private String code;
        private String capacity;
    }
}
