package com.bcu.springstudy.commons;

public class Search {
	private String keyword;
	private String option;
	
	public Search(String keyword, String option) {
		super();
		this.keyword = keyword;
		this.option = option;
	}
	
	public Search() {}

	@Override
	public String toString() {
		return "Search [keyword=" + keyword + ", option=" + option + "]";
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
}
