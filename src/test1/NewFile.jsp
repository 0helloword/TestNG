<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
from selenium import webdriver
dr=webdriver.Firefox()
dr.get('file:///D:/1.html')
js='document.getElementsByClassName("scroll")[0].scrollTop=10000' 
# 就是这么简单，修改这个元素的scrollTop就可以
dr.execute_script(js)
</body>
</html>