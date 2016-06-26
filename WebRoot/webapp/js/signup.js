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
                required:true

            }
        }
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