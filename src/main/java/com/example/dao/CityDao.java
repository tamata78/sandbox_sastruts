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
package com.example.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.Arguments;
import org.seasar.dao.annotation.tiger.Query;
import org.seasar.dao.annotation.tiger.S2Dao;

import com.example.dto.CitySearchCondition;
import com.example.entity.City;

@S2Dao(bean = City.class)
public interface CityDao {
    // テーブル全件更新
    List<City> getAllCitys();

    // 引数設定
    @Arguments( { "cityId", "countryId" })
    void getCityByCityIdCountryId(Integer cityId, Integer countryId);

    // Where句設定
    @Query("cityId BETWEEN ? AND ? ORDER BY empno")
    List<City> getCitysByCityId(Integer minCityId, Integer minCountryId);

    // 主キー検索
    @Arguments( { "cityId" })
    City getCityByCityId(Integer cityId);

    // DTOキー アノテーションなしでDTO引数とみなす
    List<City> getCitysBySearchCondition(CitySearchCondition dto);

    // DTOでの更新
    void update(City employee);

}