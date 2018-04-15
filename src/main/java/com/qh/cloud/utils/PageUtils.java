package com.qh.cloud.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 分页工具类
 * @author QingHang
 * @date 2017年1月11日
 * @param <T>
 */
public class PageUtils<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int currentPage = 0;// 当前页

	private int pageSize = 15;// 每页显示的条数

	private int startRow = 0;// 开始查询的条数

	private int previousPage = 0;// 上一页

	private int nextPage = 0;// 下一页

	private int totalRecords = 0;// 总记录数

	private int totalPage = 0;// 总页数

	private int pageNum = 9;// 页面中显示多少个页链接

	private String url;

	private boolean isShow = true; // 是否需要分页

	private Map<String, Object> params = new HashMap<String, Object>(); // 存放查询参数

	private List<T> recordsList; // 存放查询结果

	@SuppressWarnings("unused")
	private int pageNo = 0;// 分页使用

	public boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(boolean isShow) {
		this.isShow = isShow;
	}

	public String getUrl() {
		return url;
	}

	public PageUtils(int currentPage, int pageSize) {
		if (currentPage < 1) {
			this.currentPage = 1;
		} else {
			this.currentPage = currentPage;
		}
		if (pageSize != 0) {
			this.pageSize = pageSize;
		} else {
			try {
				this.pageSize = Integer.parseInt(Configuration.getInstance().getString(Constants.PAGESIZE));
			} catch (Exception e) {
				this.pageSize = 20;
			}
		}
		this.pageNo = (this.currentPage - 1) * this.pageSize;
	}

	public PageUtils(int currentPage, String url) {
		if (currentPage < 1) {
			this.currentPage = 1;
		} else {
			this.currentPage = currentPage;
		}
		this.url = url;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	/*
	 * public void setCurrentPage(int currentPage) { if(currentPage<1){ currentPage = 1; }
	 * this.currentPage = currentPage; }
	 */
	public int getPageSize() {
		if (pageSize != 0)
			return pageSize;
		try {
			pageSize = Configuration.getInstance().getInt(Constants.PAGESIZE);
		} catch (Exception e) {
			pageSize = 20;
		}
		return pageSize;
	}

	/*
	 * public void setPageSize(int pageSize) { if(pageSize<1){ pageSize = 20; } this.pageSize =
	 * pageSize; }
	 */
	public int getStartRow() {
		startRow = (getCurrentPage() - 1) * getPageSize();
		if (startRow < 0)
			startRow = 0;
		return startRow;
	}

	public int getPreviousPage() {
		previousPage = getCurrentPage() - 1;
		if (previousPage < 1)
			previousPage = 1;
		return previousPage;
	}

	public int getNextPage() {
		nextPage = getCurrentPage() + 1;
		if (nextPage > getTotlePage())
			nextPage = totalPage;
		return nextPage;
	}

	public int getTotalRecords() {
		if (totalRecords < 1)
			totalRecords = 0;
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getTotlePage() {
		totalPage = (int) Math.ceil(((double) this.getTotalRecords()) / this.getPageSize());
		// if(this.getTotalRecords()%this.getPageSize()>0){
		// totalPage++;
		// }
		// if(totalPage==0) totalPage=1;
		return totalPage;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public Map<String, Object> getReturnInfo() {
		params.put("recordsList", recordsList);
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);
		params.put("reason", ContantStr.SUCCESS);
		params.put("totalRecords", totalRecords);
		return params;
	}

	public Map<String, Object> getReturnInfo(String errMsg) {
		params.put("errMsg", errMsg);
		params.put("reason", ContantStr.FAILED);
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public List<T> getRecordsList() {
		return recordsList;
	}

	public void setRecordsList(List<T> recordsList) {
		this.recordsList = recordsList;
	}

	public int getPageNo() {
		return (getCurrentPage() - 1) * pageSize;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String toString() {
		// if(!this.getIsShow()){
		// return "";
		// }
		if (StringUtils.isEmpty(url)) {
			return "";
		}
		int start = getCurrentPage(), end = getCurrentPage() + pageNum;
		int temp = (int) Math.floor(pageNum / 2); // 用于算当前页离end和start页的距离
		if (pageNum >= getTotlePage()) {
			start = 1;
			end = getTotlePage();
		} else if (temp + getCurrentPage() < getTotlePage()) {
			if (getCurrentPage() <= temp) {
				start = 1;
				end = pageNum;
			} else {
				start = getCurrentPage() - temp;
				end = getCurrentPage() + temp;
			}
		} else if (temp + getCurrentPage() >= getTotlePage()) {
			start = getTotlePage() - pageNum + 1;
			end = getTotlePage();
		}
		if ((start == end && start == 1) || start > end)
			return "";
		StringBuffer result = new StringBuffer();
		result.append("<div class='page'  align='right'>");
		if (getCurrentPage() == 1) {
			result.append(ContantStr.CURRENT_PAGE);
		} else {
			result.append("<a href='" + url + Constants.CURRENTPAGE + "=1'>" + ContantStr.CURRENT_PAGE + "</a>");
		}
		result.append("&nbsp;&nbsp;");
		for (int i = start; i <= end; i++) {
			if (i != getCurrentPage()) {
				result.append("<a href='" + url + Constants.CURRENTPAGE + "=" + i + "'>[" + i + "]</a>&nbsp;&nbsp;");
			} else {
				result.append("<font color=\"#ff0000\">" + i + "</font>&nbsp;&nbsp;");
			}
		}
		// strB.append(" ... (共").append(totalPage).append("页)&nbsp&nbsp");
		if (this.getCurrentPage() == this.getTotlePage()) {
			result.append(ContantStr.LAST_PAGE);
		} else {
			result.append("<a href='" + url + Constants.CURRENTPAGE + "=" + this.getTotlePage())
					.append("'>" + ContantStr.LAST_PAGE + "</a>");
		}
		result.append("</div>");
		result.append("<br class='clear'/>");
		return result.toString();
	}
}
