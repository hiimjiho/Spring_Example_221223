package com.example.quiz.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteMapper {
	public int insertSite(
			@Param("name")String name,
			@Param("url")String url);
}
