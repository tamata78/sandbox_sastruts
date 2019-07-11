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

import javax.annotation.Resource;

import com.example.entity.Actor;

public class ActorDaoClient {

	private static final String PATH = "examples/dao/tiger/DepartmentDao.dicon";

	@Resource
	protected static ActorDao dao;

	public static void main(String[] args) {
		Actor dept = new Actor();
		dept.setDeptno(99);
		dept.setDname("foo");
		dao.insert(dept);
		dept.setDname("bar");
		System.out.println("before update versionNo:" + dept.getVersionNo());
		dao.update(dept);
		System.out.println("after update versionNo:" + dept.getVersionNo());
		dao.delete(dept);

	}
}