/**
 * create by Lids on 2016/06/22
 */

$(window).load(function(){
    
    loadProductContent();
    isOnline();
});

function isOnline(){

    var COOKIE_NAME = "UserStateCookie";

    if($.cookie(COOKIE_NAME)){
        $(".link_login").text($.cookie(COOKIE_NAME)+"请登录");
    }
    else{
        console.info("cookieLog","no Cookies");
    }
    //

}

function loadProductContent(){

    var content_list = $(".content_list");
    //<li><a href="url"></a></li>

    $.ajax({
        url:"toProductgetContent.action",
        async:false,
        success:function(data){
            $.each(data.data,function(i,value){

                var name = value.categorydesc;
                var url = value.url;
                var str = "<li><a href='"+url+"'>"+name+"</a></li>";
                content_list.append(str);
            });
            
        },
        error:function(){
            alert("获取目录失败");
        }
    });
}