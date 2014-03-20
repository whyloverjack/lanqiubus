<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SEM123后台管理</title>
<link rel='stylesheet' href='static/css/login.css' type='text/css' />
<script src="static/dwz/jquery-1.7.2.min.js" type="text/javascript"></script>
</head>
<body>

	<div id="login">
		<h1>
			<a href="#" title="">SEM123后台管理</a>
		</h1>
		<form accept-charset="utf-8" action="admin/login" method="post">
			<p>
				<label>帐号：</label> <input class="input" name="username"
					id="username" size="20" type="text" />
			</p>
			<p>
				<label>密码：</label> <input class="input" name="password"
					id="password" size="20" type="password" />
			</p>
			<p class="submit">
				<input class="button-primary" name="commit" id="loginBut"
					type="submit" value="登录" />
			</p>
		</form>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
    $('#loginBut').bind('click', function(){
        var data = new Object();
        data.username = $.trim($('#username').val());
        data.password = $.trim($('#password').val());
                if(data.username == ''){
            alert('请输入帐号！'); $('#username').focus(); return false;
        }
        if(data.password == ''){
            alert('请输入密码！'); $('#password').focus(); return false;
        }
        if(data.code != undefined && data.code == ''){
            alert('请输入验证码！'); $('#code').focus(); return false;
        }
        data.flag = 'islogin';
        $.post('/admin/login',data,function(res){
            if(res.msg != undefined){
                alert(res.msg);
            }
            if(res.status!=0){
                if(res.status==1){
                    $('.input').val('');
                }else if(res.status==2){
                    $('#code').val('');
                }else{
                    location.reload();
                }
                if(data.code != undefined){
                    $('#codeimg').click();
                }else{
                    location.reload();
                }
                return false;
            }
            //location.href=res.goto;
        },'json');
        return false;
    });
});
</script>
</html>


