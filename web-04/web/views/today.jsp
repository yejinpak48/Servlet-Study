<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%
	Date now = new Date();
	String today = String.format("%tY년 %tm월 %td일 %tA", now, now, now, now);
%>

<sub style="color:lightgray"><%= today %></sub>
