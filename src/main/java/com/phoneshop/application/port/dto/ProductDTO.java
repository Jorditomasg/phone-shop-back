package com.phoneshop.application.port.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProductDTO {
    private String id;
    private String marca;
    private String modelo;
    private Double precio;
    private String cpu;
    private String ram;
    private String sistema_operativo;
    private String resolucion_pantalla;
    private String bateria;
    private String camaras;
    private String dimensiones;
    private String peso;
    private String imagenUrl;
    private List<ColorOptionDTO> colors;
    private List<StorageOptionDTO> storages;

    @Data
    public static class ColorOptionDTO {
        private String code;
        private String name;
    }

    @Data
    public static class StorageOptionDTO {
        private String code;
        private String capacity;
    }
}
