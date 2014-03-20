<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jack.lanqiubus.common.constant.SiteConstant"%>
<%@page import="com.jack.lanqiubus.common.util.ConfigManager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>信息管理后台</title>

<link href="static/dwz/themes/default/style.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="static/dwz/themes/css/core.css" rel="stylesheet"
	type="text/css" media="screen" />
<!--[if IE]>
<link href="/static/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<!--[if lte IE 6]>
<script src="/static/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<![endif]-->
<script src="static/dwz/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="static/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="static/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="static/dwz/js/dwz.min.js" type="text/javascript"></script>
<script src="static/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		DWZ.init("static/dwz/dwz.frag.xml", {
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",
				orderDirection : "orderDirection"
			}, //【可选】
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "static/dwz/themes"
				}); // themeBase 相对于index页面的主题base路径
			}
		});
	});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://52cfml.com">标志</a>
				<ul class="nav">
					<li><a href="login.html">退出</a></li>
				</ul>
			</div>
			<!-- navMenu -->
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>杰之蓝信息管理系统</h2>
					<div>收缩</div>
				</div>
				<div class="accordion" fillSpace="sidebar">
				<c:forEach items="${MenuList }" var="RootMenu">
				<c:if test="${RootMenu.isshow }">
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>${RootMenu.name }
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<c:forEach items="${RootMenu.childMenu }" var="childMenu">
								<c:choose>
									<c:when
										test="${childMenu.childMenu.size()>0 && childMenu.isshow}">
										<li><a href="tabsPage.html" target="navTab">主框架面板</a>
											<ul>
												<li><a href="main.html" target="navTab" rel="main">我的主页</a></li>
											</ul></li>
									</c:when>
									<c:when
										test="${childMenu.childMenu.size()==0 && childMenu.isshow}">
										<li><a
											href="${childMenu.controller}/${childMenu.action}"
											target="navTab">${childMenu.name }</a></li>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</div>
				</c:if>
				</c:forEach>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<p>
									<a href="https://code.csdn.net/dwzteam/dwz_jui/tree/master/doc"
										target="_blank" style="line-height:19px"><span>DWZ框架使用手册</span></a>
								</p>
								<p>
									<a href="http://pan.baidu.com/s/18Bb8Z" target="_blank"
										style="line-height:19px">DWZ框架开发视频教材</a>
								</p>
							</div>
							<div class="right">
								<p style="color:red">
									DWZ官方微博 <a href="http://weibo.com/dwzui" target="_blank">http://weibo.com/dwzui</a>
								</p>
							</div>
							<p>
								<span>DWZ富客户端框架</span>
							</p>
							<p>
								DWZ官方微博:<a href="http://weibo.com/dwzui" target="_blank">http://weibo.com/dwzui</a>
							</p>
						</div>
						<div class="pageFormContent" layoutH="80"
							style="margin-right:230px">


							<h2>DWZ系列开源项目:</h2>
							<div class="unit">
								<a href="https://code.csdn.net/dwzteam/dwz_jui" target="_blank">dwz富客户端框架
									- jUI</a>
							</div>
							<div class="unit">
								<a href="https://code.csdn.net/dwzteam/dwz_ssh2" target="_blank">dwz4j企业级Java
									Web快速开发框架(Hibernate+Spring+Struts2) + jUI整合应用</a>
							</div>
							<div class="unit">
								<a href="https://code.csdn.net/dwzteam/dwz_springmvc"
									target="_blank">dwz4j企业级Java Web快速开发框架(Mybatis + SpringMVC)
									+ jUI整合应用</a>
							</div>
							<div class="unit">
								<a href="https://code.csdn.net/dwzteam/dwz_thinkphp"
									target="_blank">ThinkPHP + jUI整合应用</a>
							</div>
							<div class="unit">
								<a href="https://code.csdn.net/dwzteam/dwz_zendframework"
									target="_blank">Zend Framework + jUI整合应用</a>
							</div>
							<div class="unit">
								<a href="http://www.yiiframework.com/extension/dwzinterface/"
									target="_blank">YII + jUI整合应用</a>
							</div>

							<div class="divider"></div>
							<h2>常见问题及解决:</h2>
							<pre style="margin:5px;line-height:1.4em">
Error loading XML document: dwz.frag.xml
直接用IE打开index.html弹出一个对话框：Error loading XML document: dwz.frag.xml
原因：没有加载成功dwz.frag.xml。IE ajax laod本地文件有限制, 是ie安全级别的问题, 不是框架的问题。
解决方法：部署到apache 等 Web容器下。
</pre>

							<div class="divider"></div>
							<h2>
								有偿服务(<span style="color:red;">公司培训，技术支持，解决使用jUI过程中出现的全部疑难问题</span>):
							</h2>
							<br />
							<pre style="margin:5px;line-height:1.4em;">
合作电话(杜权)：010-52897073 18600055221
邮箱：support@j-ui.com
来往：pinglive01(吴平)
jQuery.DWZ-jUI-9群: 329597326 (其它群已满)
</pre>
						</div>

						<div style="width:230px;position: absolute;top:60px;right:0"
							layoutH="80">
							<iframe width="100%" height="430" class="share_self"
								frameborder="0" scrolling="no"
								src="http://widget.weibo.com/weiboshow/index.php?width=0&height=430&fansRow=2&ptype=1&skin=1&isTitle=0&noborder=1&isWeibo=1&isFans=0&uid=1739071261&verifier=c683dfe7"></iframe>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>

	<div id="footer">
		Copyright &copy; 2014 <a href="javascript:void(0);" target="dialog">杰之蓝</a>
	</div>

	<!-- 注意此处js代码用于google站点统计，非DWZ代码，请删除 -->
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-16716654-1' ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? ' https://ssl'
					: ' http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>

</body>
</html>