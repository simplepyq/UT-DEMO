/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 * <p>
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package cn.niko.ut.demo.openapi.controller.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yongqi.pan
 * @since 2022/11/7 15:36
 */
@Getter
@Setter
@ToString
public class MvcDemoResponse implements Serializable {

    private static final long serialVersionUID = -6955474241090007729L;

    private String category;
}
