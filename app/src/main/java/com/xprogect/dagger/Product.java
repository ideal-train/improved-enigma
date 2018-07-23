package com.xprogect.dagger;

import javax.inject.Inject;

/**
 * @author Administrator
 * @since 2018/7/18
 * function：
 */
public class Product {
    Product product;
    //这里可以看到加入了注解方式
    @Inject
    public Product() {
//    public Product(Product product) {
//        this.product=product;
    }
}
