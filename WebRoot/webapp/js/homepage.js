/**
 * create by Lids on 2016/06/22
 */
$(window).load(function(){
    
    loadProductContent();
    isOnline();
    //pagination
    pagination();
});

function isOnline(){

    var COOKIE_NAME = "UserStateCookie";
    var userName = $.cookie(COOKIE_NAME);
    var $name = $(".link_login");
    var $logout = $(".link_regist");

    if(userName){

        $.ajax({
           url:"toUserisOnline.action",
           data:{"nickName":userName},
            dataType:"json",
            async:false,
            success: function(data,textStatus){
                //
                var userStateCode = data.UserStateCode;
                switch (userStateCode){
                    case 3003:
                        //user online
                        $name.text(userName);
                        $logout.text("退出");
                        $logout.bind("click",function(e){
                            $.ajax({
                                url:"toUserlogout.action",
                                async:false,
                                data:{"nickName":userName},
                                dataType:"json",
                                success:function(data, textStatus){
                                    var userStateCode = data.UserStateCode;
                                    if(userStateCode==3002){
                                        console.info("logout","logout successful!");
                                        window.location.href="../../login.html";
                                    }else{
                                        console.info("logout error","error code:"+userStateCode);
                                    }

                                }
                            });
                            e.preventDefault();
                        });

                        break;
                    case 30031:
                        //user outline
                        $name.text(userName+"请登录");
                        $logout.text("免费注册");
                        break;
                    default:
                        console.info(userStateCode,"错误码 :"+userStateCode);
                        break;
                }
            },
            error: function(jqXHR,textStatus){
                if(textStatus==="timeOut"){
                    alert("超时");
                }else if(textStatus==="error"){
                    alert("网络错误");
                }
                else{
                    alert("未知错误" + textStatus);
                }
            }
        });
    }
    else{
        console.info("cookieLog","no Cookies");
    }



}

function loadProductContent(){

    var content_list = $(".content_list");
    //<li><a href="url"></a></li>

    $.ajax({
        url:"toProductgetContent.action",
        data:{"grade":1},
        dataType:"json",
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
            alert("无法加载目录");
        }
    });
}

function pagination(){
    var currentPage = 1;    //first page
    //first get total page numbers
    var prdtCount = 0;
    $.get("toProductgetHomepageProductCount.action",function(response, status){
        prdtCount = reponse.prdtCount;
        console.info("product count",prdtCount);
    });
    var dataCountPerPage = 30;
    var pageCount = (prdtCount/dataCountPerPage)+1;

    //get Dom
    var $firstSpan = $("#first_span");
    var $prevSpan = $("#prev_span");
    var $optionSpan = $("#option_span");
    var $nextSpan = $("#next_span");
    var $lastSpan = $("#last_span");

    //bind click event
    $firstSpan.bind('click',function(){
        currentPage=1;
       pushPageRequest(1,dataCountPerPage);
    });
    $prevSpan.bind('click', function () {
       pushPageRequest(--currentPage,dataCountPerPage);
    });
    $nextSpan.bind('click', function () {
        pushPageRequest(++currentPage,dataCountPerPage);
    });
    $lastSpan.bind('click', function () {
       pushPageRequest(pageCount,dataCountPerPage);
    })

}


function bindClickEventToSelect(select){
    //bind Click Event to select
    $.each(select,function(index, value){
        value.bind("click", function (e) {
            pushPageRequest(value.text(),30);
        });
    });
}

//use Ajax to get data of current page
function pushPageRequest(currentPage, numberPerPage){
    $.ajax({
        url:"toProductgetHomepageProduct.action",
        data:{
            "currentPage":currentPage,
            "numberPerPage": numberPerPage
        },
        dataType:"json",
        success: function (data, textStatus) {
            //TODO use the data compelete the prdt detail
            console.info("textStatus", textStatus);
            if(textStatus==="success"){
                var $select = $("#option_span>select");
                //empty
                $select.empty();
                for(var i = currentPage; i < currentPage+5;++i){
                    //append option element to select
                    var str = "<option>"+i+"</option>";
                    var $option = $(str);
                    $select.append($option);
                }
                bindClickEventToSelect($select);
            }
        },
        error: function (errorCode) {
            alert("加载分页出现错误，错误代码：" + errorCode);
        }
    });


}

