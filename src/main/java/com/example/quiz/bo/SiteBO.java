package com.example.quiz.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quiz.dao.SiteMapper;

@Service
public class SiteBO {
	@Autowired
	private SiteMapper siteMapper;
	
	public int getSite(String name, String url) {
		return siteMapper.insertSite(name, url);
	}
}
