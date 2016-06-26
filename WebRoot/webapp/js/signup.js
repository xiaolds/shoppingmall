/**
 created by Lids
 **/
//登陆操作
function signup(){
    var jInputBox = $("input");
    var jMsg = $("#msg");
    var isComplete = true;
    jInputBox.each(function(){
        if(""===$(this).val()){
            var txt = $(this).attr("placeholder");
            jMsg.text(txt+"not null");
            isComplete=false;
            return false;
        }
    });
    if(!isComplete) return;
    $.post("toUsersignUp.action",$("#signup_form").serialize(),function(data, textStatus){
        console.log("data",data);
        console.log("textStatus",textStatus);
        if("success"===textStatus){
            window.location.href="welcome.html";
        }
    });
}
 $(window).load(function(){
     imgToolTip();
     formValidate();
 });

//表单验证
function formValidate(){
    $("#signup_form").validate({
        rules:{
            nickName:{
                required:true,
                minlength:5
            },
            realName:{
                required:true,
                minlength:5
            },
            age:{
                required:true,
                digits:true
            },
            sex:{

            },
            password:{
                minlength:6
            },
            email:{
              email:true
            },
            mobilePhone:{
              rangelength:[11,11]
            }
        },
        message:{

        }
    });
    
    //单独进行后端验证
    var $nickName = $("input[name=nickName]");
    var $email = $("input[name=email]");
    var $mobilePhone = $("input[name=mobilePhone]");

    $nickName.bind("blur",function(){
       //失去焦点，发送验证
        $.ajax({
            url:"toUserfindUserByNickName.action",
            dataType:"json",
            data:{
                "nickName":$nickName.val()
            },
            success:function(data,type){
                if(data.UserStateCode===30014){
                    //未被占用
                    alert("该昵称未被占用");
                }
                else if(data.UserStateCode===30011){
                    alert("该昵称已被占用");
                }
            }

        });

    });
    
    $email.bind("blur",function(){
        //失去焦点，发送验证
         $.ajax({
             url:"toUserfindUserByEmail.action",
             dataType:"json",
             data:{
                 "email":$email.val()
             },
             success:function(data,type){
                 if(data.UserStateCode===30015){
                     //未被占用
                     alert("该email未被占用");
                 }
                 else if(data.UserStateCode===30012){
                     alert("该email已被占用");
                 }
             }

         });

     });
    
    $mobilePhone.bind("blur",function(){
        //失去焦点，发送验证
         $.ajax({
             url:"toUserfindUserByPhoneNumber.action",
             dataType:"json",
             data:{
                 "mobilePhone":$mobilePhone.val()
             },
             success:function(data,type){
                 if(data.UserStateCode===30016){
                     //未被占用
                     alert("该号码未被占用");
                 }
                 else if(data.UserStateCode===30013){
                     alert("该号码已被占用");
                 }
             }

         });

     });

}

function imgToolTip(){
    var jImage = $(".signup_tip>img");
    jImage.mouseover(function(e){
        var toolTip = "<div id='toolTip'><img src='"+jImage.attr("src")+"'></div>";
        $("body").append(toolTip);
        $("#toolTip>img").css({
            "width":330+"px",
            "height":525+"px"
        });
        $("#toolTip").css({
            "position":"fixed",
            "top":(e.pageY)+"px",
            "left":(e.pageX)+"px"
        }).show("fast");
    }).mouseout(function(){
        $("#toolTip").remove();
    }).mousemove(function(e){
        $("#toolTip").css({
            "position":"fixed",
            "top":(e.pageY)+"px",
            "left":(e.pageX)+"px"
        });
    });
}