package com.imooc.sell.controller;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.utils.ResultVOUtil;
import com.imooc.sell.vo.ProductInfoVO;
import com.imooc.sell.vo.ProductVO;
import com.imooc.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 常红伟
 */
@RestController
@RequestMapping("/buyer/product")
@Slf4j
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * @Cacheable  第一次访问会执行方法里面的内容，并将返回值设置进redis，下次访问就不会进入方法而是直接在redis取
     * @return
     */
    @GetMapping("/list")
   // @Cacheable(cacheNames = "product",key = "123")
    public ResultVO list(){

        //1.查询所有上架商品
        List<ProductInfo> upAll = productService.findUpAll();

        //2.查询需要的类目
        List<ProductCategory> categoryList = categoryService.findAll();

        //存放类目的集合
        List<ProductVO>productVOList = new ArrayList<>();
        //3.数据拼装   将查询出所有的类目进行遍历 进行拼装
        for(ProductCategory productCategory:categoryList){
            //外层数据     ProductVO
            ProductVO productVO = new ProductVO();
            //拼接外层类目名称 name 根据查询出的所有类目 提取指定的属性 添加到对应VO层对象
            productVO.setCategoryName(productCategory.getCategoryName());
            //拼接外层类目类型 type
            productVO.setCategoryType(productCategory.getCategoryType());
            //存放商品的list集合
            List<ProductInfoVO> productInfoVOList =new ArrayList<>();
            //拼接foods   foods是一个数组是由productInfo对象组成  所以先拼接food对象
            for (ProductInfo productInfo :upAll){
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())){
                        ProductInfoVO productInfoVO = new ProductInfoVO();
                        // BeanUtils.copyProperties     前 复 后
                        BeanUtils.copyProperties(productInfo,productInfoVO);
                        productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

}
