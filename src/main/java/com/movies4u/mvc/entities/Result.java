package com.movies4u.mvc.entities;

import java.util.List;

public class Result {

	private int page;
	
	private List<?> result;
	
	private int total_pages;
	
	private long total_results;
	
	public Result() {}

	public Result(int page, List<?> result, int total_pages, long total_results) {
		super();
		this.page = page;
		this.result = result;
		this.total_pages = total_pages;
		this.total_results = total_results;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<Movies> result) {
		this.result = result;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public long getTotal_results() {
		return total_results;
	}

	public void setTotal_results(long total_results) {
		this.total_results = total_results;
	}
	
}
