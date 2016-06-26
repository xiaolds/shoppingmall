/**
 * 登陆按钮按下
 */
document.onkeyup = function (event) {
    var e = event || window.event;
    var keyCode = e.keyCode || e.which;
    switch (keyCode) {
        case 13:
            login();
            break;             
        default:
            break;
    }
};


/**账户登录*/
function login(){
			var userName = document.getElementById("userName").value;
			var userPwd = document.getElementById("userPwd").value;
			
			Ext.Ajax.request({
				method : 'post',
				async: false,	
				params : { nickName:userName, password:userPwd },
				url : 'toUserlogin.action',
				success : function(response,options) {
					try {
						var obj = eval("("+response.responseText+")");
						var loginCode = obj.UserStateCode;						
									
						switch(loginCode){
							case 3000:								
								window.location.href = "webapp/page/homepage.html";
								break;
							default:
								Ext.MessageBox.alert("提示","登陆失败---错误码为:"+loginCode+"!");
								break;
						}
																		
					} catch (e) {																	
						Ext.MessageBox.alert("提示", "登陆失败--js页面有错!",function(){
							
						});
					}
				},
				failure : function(response,options) {										
					Ext.MessageBox.alert("提示", "登陆失败--ajax访问后台有错!",function(){
						
					});
				}
			});				
			
		}

/**
 * 注册事件
 */
function signup() {
	
	
	
}