package com.example.shop_store_back.service;

import com.example.shop_store_back.data.*;
import com.example.shop_store_back.dto.FilterDTO;
import com.example.shop_store_back.dto.ProductsResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductsResponseDto getProductsByFilter(FilterDTO filterDTO) {

        if (filterDTO == null || filterDTO.getName()==null){
            List<Product> products = repository.findAll();
            ProductsResponseDto productsResponseDto = new ProductsResponseDto();
            productsResponseDto.setCount(products.stream().toList().size());
            productsResponseDto.setNext("next");
            productsResponseDto.setResults(products.stream().toList());
            return productsResponseDto;
        }

        Pageable pageable = PageRequest.of(filterDTO.getPage() - 1, 100, Sort.by(filterDTO.getSort()).descending());
    /*
      caveat : usually, the request that comes from the front end starts with
      page 1 but JPA pagination starts from page 0. Therefore, the lowest the
      page that comes as request should be 1 and but it is actually 0 and hence
      (page - 1) is done to make it correct.
    */
        //return repo.findAll(StudentSpecification.columnEqual(filterDTOList), pageable);

        Page<Product> products = repository.findAll(ProductSpecification.productsEqual(filterDTO), pageable);
        ProductsResponseDto productsResponseDto = new ProductsResponseDto();
        productsResponseDto.setCount(products.stream().toList().size());
        productsResponseDto.setNext(products.nextPageable().next().toString());
        productsResponseDto.setResults(products.stream().toList());
        return productsResponseDto;
    }

    public Optional<Product> getProduct(Long id){
        return repository.findById(id);
    }

    public Trailer getTrailer(Long id) {
        return new Trailer(id, "name","preview trailer",
                "https://videos.pexels.com/video-files/8262768/8262768-sd_506_960_25fps.mp4");

    }

    public List<Screenshot> getScreenshot(Long id) {
        List<Screenshot> screenshots = new ArrayList<>();
        screenshots.add(new Screenshot(id,"https://img.freepik.com/premium-photo/house-illustration-icon-cartoon-graphics_1070876-8889.jpg",150,150));
        screenshots.add(new Screenshot(id+1,"https://img.freepik.com/premium-photo/house-illustration-icon-cartoon-graphics_1070876-8889.jpg",150,150));
        screenshots.add(new Screenshot(id+2,"https://img.freepik.com/premium-photo/house-illustration-icon-cartoon-graphics_1070876-8889.jpg",150,150));
        screenshots.add(new Screenshot(id+3,"https://img.freepik.com/premium-photo/house-illustration-icon-cartoon-graphics_1070876-8889.jpg",150,150));

        return  screenshots;
    }
}
