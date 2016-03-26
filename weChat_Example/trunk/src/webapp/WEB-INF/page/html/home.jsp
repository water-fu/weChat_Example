<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();

	String cssPath = path + "/resource/css";
	String jsPath = path = "/resource/javascript";

	request.setAttribute("cssPath", cssPath);
	request.setAttribute("jsPath", jsPath);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">

        <link rel="stylesheet" type="text/css" href="${cssPath}/reset.css" media="all">
		<link rel="stylesheet" type="text/css" href="${cssPath}/common.css" media="all">
		<link rel="stylesheet" type="text/css" href="${cssPath}/home-32.css" media="all">

		<script type="text/javascript" src="${jsPath}/jQuery.js"></script>
		<script type="text/javascript" src="${jsPath}/audio.js"></script>

		<title>微官网</title>
        
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
        <meta name="Keywords" content="">
        <meta name="Description" content="">

        <!-- Mobile Devices Support @begin -->
		<meta content="telephone=no, address=no" name="format-detection">
		<meta name="apple-mobile-web-app-capable" content="yes"> <!-- apple devices fullscreen -->
		<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
        <!-- Mobile Devices Support @end -->

		<link rel="shortcut icon" href="http://stc.weimob.com/img/favicon.ico">

		<link rel="stylesheet" type="text/css" href="${cssPath}/weimobfont.css" media="all">
		<link rel="stylesheet" type="text/css" href="${cssPath}/font-awesome.css" media="all">

		<style>
			.body{
				display:block;
				background:url('http://img.weimob.com/static/c8/4b/c0/image/20151003/20151003183329_12832.jpg') no-repeat 0 0;
				background-size:100% 100%;
			}
		</style>
    </head>

    <body onselectstart="return true;" ondragstart="return false;">


	<div class="body ofh">
	 
		<script>
			window.addEventListener("DOMContentLoaded", function(){
				playbox.init("playbox");
			}, false);
		</script>

		<span id="playbox" class="btn_music on" style="left:80%!important;" onclick="playbox.init(this).play();">
			<audio src="http://video.weimob.com/video/c8/4b/c0/mp3/20150509/LOVE-结婚进行曲.mp3" loop="" id="audio"></audio>
		</span>
		<!--
			用户分类管理
		-->
		<section>
			<ul class="list_ul">
				<li>
					<a href="http://wx3808e2630a6716e4.m.weimob.com/weisite/list?pid=483419&bid=986707&wechatid=otB29judkPoMtU47xPIMk1EvCFKc&ltid=1223344&wxref=mp.weixin.qq.com">
						<figure>
							<div>
								<span class="icon-wmfont wm-home"></span>
							</div>
							<figcaption>
								<label>巴黎春天</label>
							</figcaption>
						</figure>
					</a>
				</li>
				<li>
					<a href="http://wx3808e2630a6716e4.m.weimob.com/weisite/list?pid=483419&bid=986707&wechatid=otB29judkPoMtU47xPIMk1EvCFKc&ltid=1223346&wxref=mp.weixin.qq.com">
						<figure>
							<div>
								<span class="icon-heart"></span>
							</div>
							<figcaption>
								<label>最新活动</label>
							</figcaption>
						</figure>
					</a>
				</li>
				<li>
					<a href="http://wx3808e2630a6716e4.m.weimob.com/weisite/channel?pid=483419&bid=986707&wechatid=otB29judkPoMtU47xPIMk1EvCFKc&categoryid=1223343&wxref=mp.weixin.qq.com">
						<figure>
							<div>
								<span class="icon-plane"></span>
							</div>
							<figcaption>
								<label>境外旅拍</label>
							</figcaption>
						</figure>
					</a>
				</li>
				<li>
					<a href="http://wx3808e2630a6716e4.m.weimob.com/weisite/list?pid=483419&bid=986707&wechatid=otB29judkPoMtU47xPIMk1EvCFKc&ltid=1223341&wxref=mp.weixin.qq.com">
						<figure>
							<div>
								<span class="icon-camera"></span>
							</div>
							<figcaption>
								<label>主题内景</label>
							</figcaption>
						</figure>
					</a>
				</li>
				<li>
					<a href="http://wx3808e2630a6716e4.m.weimob.com/weisite/channel?pid=483419&bid=986707&wechatid=otB29judkPoMtU47xPIMk1EvCFKc&categoryid=1223342&wxref=mp.weixin.qq.com">
						<figure>
							<div>
								<span class="icon-sun"></span>
							</div>
							<figcaption>
								<label>特色外景</label>
							</figcaption>
						</figure>
					</a>
				</li>
				<li>
					<a href="http://wx3808e2630a6716e4.m.weimob.com/weisite/channel?pid=483419&bid=986707&wechatid=otB29judkPoMtU47xPIMk1EvCFKc&categoryid=1223347&wxref=mp.weixin.qq.com">
						<figure>
							<div>
								<span class="icon-wmfont wm-mcard"></span>
							</div>
							<figcaption>
								<label>新人客照</label>
							</figcaption>
						</figure>
					</a>
				</li>
				<li>
					<a href="tel:4006531520">
						<figure>
							<div>
								<span class="icon-phone"></span>
							</div>
							<figcaption>
								<label>联系我们</label>
							</figcaption>
						</figure>
					</a>
				</li>
			</ul>
		</section>
	</div>

	<footer style="overflow:visible;">
		<div class="weimob-copyright">
			<a href="http://fad.ngrok.natapp.cn/home" style="color:#B70000!important">© XXXXXXXXXX</a>
		</div>
	</footer>
	<div mark="stat_code" style="width:0px; height:0px; display:none;"></div>

	<%--<script type="text/javascript" src="${jsPath}/jweixin-1.0.0.js"></script>--%>

	<script src="${jsPath}/wm.js"></script>

	</body>
</html>