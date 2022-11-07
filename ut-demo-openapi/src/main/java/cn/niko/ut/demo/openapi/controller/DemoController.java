/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 * <p>
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package cn.niko.ut.demo.openapi.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.niko.ut.demo.openapi.controller.pojo.MvcDemoRequest;
import cn.niko.ut.demo.openapi.controller.pojo.MvcDemoResponse;
import cn.niko.ut.demo.service.CategoryService;

/**
 * @author yongqi.pan
 * @since 2022/11/7 15:31
 */
@RestController
@RequestMapping("/ut")
public class DemoController {

    @Resource
    private CategoryService categoryService;

    @PostMapping("/mvc/demo")
    public MvcDemoResponse mvcDemo(@RequestBody MvcDemoRequest request) {
        MvcDemoResponse response = new MvcDemoResponse();
        response.setCategory(categoryService.getCategoryByName(request.getName()));
        return response;
    }
}
