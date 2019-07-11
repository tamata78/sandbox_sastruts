/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.service;

import java.util.List;

import javax.annotation.Resource;

import com.example.dao.CityDao;
import com.example.dto.CitySearchCondition;
import com.example.entity.City;

public class CityService {

    /** Dao */
    @Resource
    CityDao cityDao;

    public void mainMethod() {
        // @Argumentsメソッド
        cityDao.getCityByCityIdCountryId(null, null);
        cityDao.getCityByCityIdCountryId(13, null);
        cityDao.getCityByCityIdCountryId(null, 82);
        cityDao.getCityByCityIdCountryId(13, 82);

        // @Queryメソッド
        List<City> citys = cityDao.getCitysByCityId(1, 10);
        for (int i = 0; i < citys.size(); ++i) {
            System.out.println(citys.get(i));
        }

        CitySearchCondition dto = new CitySearchCondition();
        dto.city = "Aden";
        citys = cityDao.getCitysBySearchCondition(dto);
        for (int i = 0; i < citys.size(); ++i) {
            System.out.println(citys.get(i));
        }

        City city = cityDao.getCityByCityId(4);
        System.out.println("before Date:" + city.lastUpdate);
        cityDao.update(city);
        System.out.println("after Date:" + city.lastUpdate);

    }
}