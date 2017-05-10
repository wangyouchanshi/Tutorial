package com.bwie.utils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Page {

	private int count;
	
	private int pageSize;
	
	private int currentPage;
	
	private int prevPage;
	
	private int nextPage;
	
	private int pageCount;
	
	private int startRecord;
	
	private void initStartRecord() {
		startRecord = (currentPage-1)*pageSize;
	}

	private void initNextPage() {
		if(currentPage==pageCount){
			nextPage = pageCount;
		}else{
			nextPage = currentPage+1;
		}
	}

	private void initPageCount() {
		pageCount = count/pageSize;
		if(count % pageSize != 0){
			pageCount++;
		}
	}

	private void initPrevPage() {
		if(currentPage==1){
			prevPage=1;
		}else{
			prevPage=currentPage-1;
		}
	}

	private void initCurrentPage(String page) {
		if(page==null){
			page = "1";
		}
		if(page.equals("")){
			page = "1";
		}
		this.currentPage = Integer.parseInt(page);
	}

	public int getCount() {
		return count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getStartRecord() {
		return startRecord;
	}

	
	
	
	public Page(String page, int count, int pageSize, String url,HttpServletRequest request){
		
		String[] pageArray = new String[4];
		String flag = url.indexOf("?") > -1 ? "&" : "?";
		initCurrentPage(page);
		initPrevPage();
		this.count = count;
		this.pageSize = pageSize;//ֵ
		initPageCount();//
		initNextPage();//
		initStartRecord();//
		
		
		
		if (currentPage == 0) {
			pageArray[0] = "首页";
		} else {
			pageArray[0] = "<a href=\"" + request.getContextPath() + "/" + url + flag + "page=1\">首页</a>";
		}
		
		if (currentPage == 0) {
			pageArray[1] = "上一页";
		} else {
			pageArray[1] = "<a href=\"" + request.getContextPath() + "/" + url + flag + "page=" + (currentPage - 1) + "\">上一页</a>";
		}
		
		if (currentPage < pageCount ) {
			pageArray[2] = "<a href=\"" + request.getContextPath() + "/" + url + flag + "page=" + (currentPage + 1) + "\">下一页</a>";
		} else {
			pageArray[2] = "下一页";
		}
		
		if (currentPage < pageCount - 1) {
			pageArray[3] = "<a href=\"" + request.getContextPath() + "/" + url + flag + "page=" + (pageCount ) + "\">尾页</a>";
		} else {
			pageArray[3] = "尾页";
		}
		
		//首页
				request.setAttribute("firstPage", pageArray[0]);
				//上一页
				request.setAttribute("precursorPage", pageArray[1]);
				//下一页
				request.setAttribute("nextPage", pageArray[2]);
				//尾页
				request.setAttribute("lastPage", pageArray[3]);
				//当前页
				request.setAttribute("currentPage", String.valueOf(currentPage + 1));
				//总页数
				request.setAttribute("pageCount", String.valueOf(pageCount));
				//总记录数
				request.setAttribute("count", count);
				//每一条显示记录
				request.setAttribute("pageSize", pageSize);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Page [count=" + count + ", pageSize=" + pageSize
				+ ", currentPage=" + currentPage + ", prevPage=" + prevPage
				+ ", nextPage=" + nextPage + ", pageCount=" + pageCount
				+ ", startRecord=" + startRecord + "]";
	}
	
}
