package com.example.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.Execute;

import com.example.service.CityService;

public class IndexAction {

    @Resource
    CityService cityService;

    @Execute(validator = false)
    public String index() {
        cityService.mainMethod();

        return "index.jsp";
    }
}
