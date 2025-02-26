package com.phoneshop.application.port.mapper;

import com.phoneshop.application.port.dto.ProductDTO;
import com.phoneshop.domain.model.Product;

import java.util.List;

public class ProductMapper {

    private ProductMapper() {
        // Ponemos clase privada para evitar instanciación
    }

    public static ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setMarca(product.getBrand());
        dto.setModelo(product.getModel());
        dto.setPrecio(product.getPrice());
        dto.setCpu(product.getCpu());
        dto.setRam(product.getRam());
        dto.setSistema_operativo(product.getOs());
        dto.setResolucion_pantalla(product.getDisplayResolution());
        dto.setBateria(product.getBattery());
        dto.setCamaras(product.getCameras());
        dto.setDimensiones(product.getDimensions());
        dto.setPeso(product.getWeight());
        dto.setImagenUrl(product.getImageUrl());

        if (product.getColors() != null) {
            List<ProductDTO.ColorOptionDTO> colorDTOs = product.getColors().stream()
                    .map(c -> {
                        ProductDTO.ColorOptionDTO colorDTO = new ProductDTO.ColorOptionDTO();
                        colorDTO.setCode(c.getCode());
                        colorDTO.setName(c.getName());
                        return colorDTO;
                    })
                    .toList();
            dto.setColors(colorDTOs);
        }

        if (product.getStorages() != null) {
            List<ProductDTO.StorageOptionDTO> storageDTOs = product.getStorages().stream()
                    .map(s -> {
                        ProductDTO.StorageOptionDTO storageDTO = new ProductDTO.StorageOptionDTO();
                        storageDTO.setCode(s.getCode());
                        storageDTO.setCapacity(s.getCapacity());
                        return storageDTO;
                    })
                    .toList();
            dto.setStorages(storageDTOs);
        }

        return dto;
    }
}
