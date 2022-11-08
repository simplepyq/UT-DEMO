/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 * <p>
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package cn.niko.ut.demo.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.niko.ut.demo.service.DemoService;
import cn.niko.ut.demo.service.LogicService;
import cn.niko.ut.demo.service.PersistenceService;

/**
 * @author yongqi.pan
 * @since 2022/11/7 15:39
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Value("${spring.application.name:}")
    public String applicationName;

    @Resource
    private PersistenceService persistenceService;

    @Resource
    private LogicService logicService;

    @Override
    public String getStringByName(String name) {
        try {
            persistenceService.insert();
        } catch (Exception e) {
            throw new RuntimeException("exception");
        }
        logicService.doLogic(name);
        if (StringUtils.equalsIgnoreCase(applicationName, name)){
            return applicationName;
        }
        return "default";
    }
}
