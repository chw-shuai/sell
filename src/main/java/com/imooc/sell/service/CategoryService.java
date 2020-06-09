package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @author 常红伟
 */
public interface CategoryService {

    /**
     * 查询一个类目
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有类目
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 查询包含某些类型的类目
     * @param categoryTypeIn
     * @return
     */
    List<ProductCategory>findByCategoryTypeIn(List<Integer> categoryTypeIn);

    /**
     * 更新  和 保存
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);

}
