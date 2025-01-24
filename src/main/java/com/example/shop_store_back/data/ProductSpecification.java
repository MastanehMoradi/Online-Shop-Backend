package com.example.shop_store_back.data;

import com.example.shop_store_back.dto.FilterDTO;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class ProductSpecification {

    public static Specification<Product> productsEqual(FilterDTO filterDTO) {
        return new Specification<Product>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (filterDTO != null) {
                    if( !"".equals(filterDTO.getName())) {
                        Predicate predicateName = criteriaBuilder
                                .equal(root.get("name"), filterDTO.getName());
                        predicates.add(predicateName);
                    }
                    if( !"".equals(filterDTO.getCategory())){
                        Predicate predicateCategory = criteriaBuilder
                                .equal(root.get("category"), ProductCategory.valueOf(filterDTO.getCategory()));
                        predicates.add(predicateCategory);
                    }
                    Order predicateSort = criteriaBuilder.desc(root.get(filterDTO.getSort()));
                    query.orderBy(predicateSort);
                }

                return criteriaBuilder
                        .and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };//columnEqual() function ends
    }
}
