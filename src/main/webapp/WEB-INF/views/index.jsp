<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/favicon.ico">

    <title>报加班系统</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <script type="text/javascript">
    function study() {
        document.form.action="study.do";
    }

    function giveup() {
        document.form.action="giveup.do";
    }

    </script>
    <div class="container">
    <div class="jumbotron">
    <div class="container">
    			<h1>好好学习，天天向上</h1>
    				<form name="form" method="POST" role="form">
    					<legend>上报加班</legend>
    					<div class="form-group">
    						<label for="">账号</label>
    						<input type="text" class="form-control" name="account" placeholder="账号" style="width:50%">
    						<label for="">密码</label>
    						<input type="password" class="form-control" name="password" placeholder="密码" style="width:50%">
                            <label for="">加班地点</label>
                            <select name="place" id="input" class="form-control" required="required" style="width:50%">
                                <option value="四楼俱乐部">四楼俱乐部</option>
                                <option value="406">406</option>
                                <option value="502">502</option>
                                <option value="503">503</option>
                            </select>
    					</div>		
    					<button type="submit" class="btn btn-primary" onclick="study()">上报加班</button>
                        <button type="submit" class="btn btn-primary" onclick="giveup()">退报加班</button>
                        <a class="btn btn-primary" data-toggle="modal" href='#modal-register'>注册账号</a>
                        <div class="modal fade" id="modal-register">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">注册</h4>
                                    </div>
                                    <form action="registerUser.do" method="POST" role="form">
                                        
                                        <div class="modal-body">
                                            <legend>输入账号信息</legend>
                                    
                                            <div class="form-group">
                                                <label for="">姓名</label>
                                                <input type="text" class="form-control" name="name" placeholder="真实姓名">
                                                <label for="">账号</label>
                                                <input type="text" class="form-control" name="account" placeholder="账号">
                                                <label for="">密码</label>
                                                <input type="password" class="form-control" name="password" placeholder="密码">
                                                <label for="">宿舍号</label>
                                                <input type="number" class="form-control" name="homenum" placeholder="411">
                                                <label for="">年级</label>
                                                <select name="年级" id="input" class="form-control" required="required">
                                                    <option value="大一">大一</option>
                                                    <option value="大二">大二</option>
                                                    <option value="大三">大三</option>
                                                </select>
                                            </div>
                                        </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                        <button type="submit" class="btn btn-primary" data-toggle="modal" href='#modal-success'>注册账号</button>
                                        
                                    </div>
                                    </form>
                                </div>
                            </div>
                        </div>
    				</form>
                <div class="modal fade" id="modal-success" >
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">提示信息</h4>
                            </div>
                                <div class="modal-body">
                                注册成功！
                                </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                        
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><a href="admin.do">点击查看加班情况</a></h3>
                    </div>
                    <div class="panel-body">
                    <table class="table">
                        <caption>今晚加班情况</caption>
                        <thead>
                            <tr>
                                <td>姓名</td>
                                <td>宿舍号</td>
                                <td>加班地点</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${user}" var="u">
                            <tr>
                                <td>${u.name}</td>
                                <td>${u.homenum}</td>
                                <td>${u.place}</td>
                                <td><a href="info.do?name=${u.username}"><button type="button" class="btn btn-default">查看最近加班情况</button></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>	
    	</div>
    </div>
    	</div>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
