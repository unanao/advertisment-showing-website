<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.util.*,com.bancai.utils.*,com.opensymphony.xwork2.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
/**
 *usage:
 *  In Action, define:   Pager p = new Pager();
 *  In jsp, include pager like:
 *     <s:include value="/_pager.jsp">
 *         <s:param name="url">a/applist?appIntId=<s:property value="appIntId"/>&other=${other}</s:param>
 *     </s:include>  
 *  NOTE:if url doesn't have parameters, include url SHOULD LIKE:  a/applist?
 *       which will end with ?
 *               
 *@author lzc, hubaiyu
 */
String argName = request.getParameter("argName") == null ? "p" :request.getParameter("argName");
Pager p = (Pager)ActionContext.getContext().getValueStack().findValue(argName);
String url = request.getParameter("url");
int allRecord = new Long(p.getTotal()).intValue();
int pageNow = p.getPageNow();
int pageSize = p.getPageSize();
int showPage = p.getShowPage();

//------Page style beings------ 
    int allPage;    //总页数
    if ((int)pageSize < 1){
        pageSize = 2;
    }
    if ((int)pageNow < 1){
        pageNow = 1;
    }
    
    /*计算总页数*/
    if(allRecord > 0){
        allPage = allRecord%pageSize == 0 ? allRecord/pageSize : (allRecord/pageSize+1);
    } else {
        allPage = 1;
    }
    
    if (pageNow > allPage){
        pageNow = allPage;
    }
    if (showPage > allPage){
        showPage = allPage;
    }
    
    /* 分页样式 */
    int pagePrev  = (pageNow > 1) ? pageNow - 1 : 1;
    int pageNext  = (pageNow < allPage) ? pageNow + 1 : allPage;
    
    String pageFirstStr = url + "&"+argName+".pageNow=1"+"&"+argName+".pageSize=" + pageSize;
    String pagePrevStr = url + "&"+argName+".pageNow=" + pagePrev + "&"+argName+".pageSize=" + pageSize;
    String pageNextStr = url + "&"+argName+".pageNow=" + pageNext + "&"+argName+".pageSize=" + pageSize;
    String pageLastStr = url + "&"+argName+".pageNow=" + allPage + "&"+argName+".pageSize=" + pageSize;
    
    String res = "共" + allPage + "页";
    res = res + "  <a class=\"text\" href=\"" + pageFirstStr + "\">首页</a>  ";
    if(pageNow!=1) {
        res = res + "<a class=\"item\" href=\"" + pagePrevStr + "\">&lt;&lt;</a> ";
    }
    /*当前页在前showPpage页内*/
    if(pageNow < showPage){
        for(int i=1;i<=showPage;i++){
            if(i==pageNow) {
                res = res + "<span class='currpage'>" + i + "</span>";
            }
            else {
                res = res + "<a class=\"pagenum\" href=\"" + url + "&"+argName+".pageNow=" + i + "&"+argName+".pageSize=" + pageSize + "\">" + i+ "</a>";
            }
        }
    }
    /*当前页在最后showPage页内*/
    else if(pageNow>allPage-showPage){
        for(int i=allPage-showPage+1;i<=allPage;i++){
            if(i==pageNow) {
                res = res + "<span class='currpage'>" + i + "</span>";
            }
            else {
                res = res + "<a class=\"pagenum\" href=\"" + url + "&"+argName+".pageNow=" + i + "&"+argName+".pageSize=" + pageSize + "\">" + i+ "</a>";
            }
        }
    }
    else{
        for(int i=pageNow-(showPage/2);i<=pageNow+(showPage/2);i++){
            if(i==pageNow) {
                res = res + "<span class='currpage'>" + i + "</span>";
            }
            else {
                res = res + "<a class=\"pagenum\" href=\"" + url + "&"+argName+".pageNow=" + i + "&"+argName+".pageSize=" + pageSize + "\">" + i+ "</a>";
            }
        }
    }
    if(pageNow!=allPage) {
        res = res + "  <a class=\"item\" href=\"" + pageNextStr + "\">&gt;&gt;</a>";
    }
    res = res + "   <a class=\"text\" href='" + pageLastStr + "'>尾页</a>";
    
    //output page html to jsp outputstream
    out.print(res);
%>