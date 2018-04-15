<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%
    	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        request.setAttribute("path", basePath);
        
        request.setAttribute("active", "merge");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<link rel="stylesheet" href="css/bootstrap.min.css" rel="external nofollow" />
 <style>
  .tab1{
   border:1px solid #ddd;
   border-top:none;
   padding:30px;
   border-radius:0 0 5px 5px;/*把边框变为圆角：top-left、top-right、bottom-right、bottom-left*/
  }
 </style>
	<script src="${path}/js/jQuery-2.2.0.min.js"></script>
	<script src="${path}/js/select_move.js"></script>
	<script src="js/jquery-2.1.0.js"></script>
 <script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container nav Yahei">
	   <div class="modal-body Yahei" >
			<div id="updown" class="col-xs-5" style="float: left; margin-top: 20px;margin-left: 20px;"> 
				<select id="where" name="where" size="5" style="width:200px;height: 150px;">
					<option value="hk" id="where01">Hong Kong</option>
					<option value="tw" id="where02">Taiwan</option>
					<option value="cn" id="where03">China</option>
					<option value="us" id="where04">United States</option>
					<option value="ca" id="where05">Canada</option>
				</select>
			</div>
			
			 <div class="col-xs-2 operation" style="float: left; margin-top:10px; margin-left: 20px;">
                  <p><button class="btn btn-info" type="button" onclick="">Add&gt;</button></p>
                  <p><button class="btn btn-info" type="button" onclick="">&lt;Remove</button></p>
                  <p><button class="btn btn-info" type="button" onclick="">Add All&gt;&gt;</button></p>
                  <p><button class="btn btn-info" type="button" onclick="">&lt;&lt;Remove All</button></p>
             </div>
			
			<div id="updown" class="modal-body Yahei" style="float: left; margin-top: 20px;margin-left: 20px;"> 
				<select id="where" name="where" size="5" style="width:200px;height: 150px;">
					<option value="hk" id="where01">Hong Kong</option>
					<option value="tw" id="where02">Taiwan</option>
					<option value="cn" id="where03">China</option>
					<option value="us" id="where04">United States</option>
					<option value="ca" id="where05">Canada</option>
				</select>
			</div>
		</div>
		<div class="col-xs-2 operation" style=" margin-top:10px; margin-left: 20px;">
			<input type="button" value="上移" onclick="upSelectedOption()"/>
			<input type="button" value="下移" onclick="downSelectedOption()"/>
			<input type="button" value="删除" onclick="removeSelectedOption()"/>
			<input type="button" value="确定" onclick="getSelectedOption()"/>
			<input type="button" value="添加" onclick="addSelectedOption()"/> 
		</div>
		
		
		
		<br>
	    <div class="container">
        <h1 class="page-header">选项卡内容</h1>
        <!--tabs-left:选项卡在左边显示  -->
        <div class="tabbable">
            <!--nav-pills，nav-tabs，nav-stacked :改变选项卡的样式-->
            <ul class="nav nav-tabs">
                <li class="active"><a href="#tab1" data-toggle="tab">Java</a>
                </li>
                <li><a href="#tab2" data-toggle="tab">C++</a>
                </li>
                <li><a href="#tab3" data-toggle="tab">.Net</a>
                </li>
            </ul>
            <!-- 选项卡相对应的内容 -->
            <div class="tab-content">
                <div class="tab-pane active" id="tab1">
                    <p>Java</p>
                </div>
                <div class="tab-pane" id="tab2">
                    <p>C++</p>
                </div>
                <div class="tab-pane" id="tab3">
                    <p>.Net</p>
                </div>
            </div>
        </div>
    </div>
	</div>
</body>
</html>