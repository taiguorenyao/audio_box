<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>盒子会员登录</title>
    <link rel="stylesheet" href="/static/css/pintuer.css">
    <link rel="stylesheet" href="/static/css/admin.css">
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/pintuer.js"></script>
    <script src="/static/js/respond.js"></script>
    <script src="/static/js/admin.js"></script>
    <link type="image/x-icon" href="/static/images/box.ico" rel="shortcut icon" />
    <link href="/static/images/box.ico" rel="bookmark icon" />
</head>
<body style="background-image: url('/static/images/wap_bg.jpg');background-attachment: fixed;background-repeat: no-repeat;background-size: cover;">
<div class="container">
    <div class="line">
        <div class="xs6 xm4 xs3-move xm4-move">
            <br /><br />
            <div class="media media-y">
                <a href="http://www.pintuer.com" target="_blank"><img style="width:100%" src="/static/logo/logo.png
" class="radius" alt="后台管理系统" /></a>
            </div>
            <br /><br />
            <div class="media media-y">
                <div class="panel-foot text-center" style="color:red">需要邀请码请加QQ：3353400836</div>
            </div>
            <form action="/wap/logindo" id="loginForm" method="post">
                <div class="panel">
                    <div class="panel-head"><strong>登录盒子系统</strong><span style="font-size:18px;color: red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${errorCode}</span></div>
                    <div class="panel-body" style="padding:30px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input" name="account" placeholder="登录账号" data-validate="required:请填写账号,length#>=5:账号长度不符合要求" />
                                <span class="icon icon-user"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input" name="pwd" placeholder="登录密码" data-validate="required:请填写密码,length#>=6:密码长度不符合要求" />
                                <span class="icon icon-key"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field">
                                <input type="text" class="input" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                                <img alt="验证码" title="点击换一张" id="imgCode" onclick="getCode();" src="/security/cuapCode?code=<%=Math.random()%>"  width="80" height="32" class="passcode" />
                            </div>
                        </div>
                    </div>
                    <div class="panel-foot text-center"><button class="button button-block bg-main text-big">登录</button></div>
                    <div class="panel-foot text-center"><a href="/wap/userreg">注册</a></div>

                </div>
            </form>
            <span style="color:#fff;text-align:center;">本产品中提供的软件功能供于开放及学习，任何单位或个人通过本产品提供任何服务与开发者无关。</span>
        </div>
    </div>
</div>
<%
request.getSession().removeAttribute("errorCode");
%>
</body>
</html>
<script type="text/javascript">
    function getCode() {
        document.getElementById("imgCode").src = "/security/cuapCode?code="
                + Math.random();
    }
</script>