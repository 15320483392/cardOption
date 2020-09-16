package com.card.option.pay.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WTar
 * @date 2020/9/16 17:18
 */
@Slf4j
@RestController
@RequestMapping("/code")
@Api(value = "ScanCodeController", tags = {"扫码接口"})
public class ScanCodeController {
}
