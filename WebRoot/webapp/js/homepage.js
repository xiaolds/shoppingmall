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

function bindClickEventToSelect(option){
    //bind Click Event to select
    $.each(option,function(index, value){
        //console.info("value",value);
        $(value).bind("click", function (e) {
            pushPageRequest($(value).text(),dataCountPerPage);
            //$(value).attr("selected",true);
            e.stopPropagation();
        });
    });
}

//use Ajax to get data of current page
function pushPageRequest(currentPage, numberPerPage, maxPage){
    $.ajax({
        url:"toProductgetHomepageProduct.action",
        data:{
            "currentPage":currentPage,
            "numberPerPage": numberPerPage
        },
        dataType:"json",
        success: function (data, textStatus) {

            //console.info("textStatus", textStatus);
            if(textStatus==="success"){
                setOptionElement($("#option_span>select"), currentPage, maxPage);
                var $prdtDisplay = $(".product_display");
                var $prdtDetail = $(".product_detail").clone(true);
                //every time clone prdt_detail div
                $(".product_display").empty();
                console.info("Function Empty worked",true);
                $.each(data.productList,function(index, element){
                    var $prdtDetailClone = $prdtDetail.clone(true);
                    var $prdtDetailCloneChildren = $prdtDetailClone.children();
                    $($prdtDetailCloneChildren[0]).attr("src",element.url);
                    $($prdtDetailCloneChildren[1]).text(element.description);
                    $($prdtDetailCloneChildren[2]).html("<i>￥</i>"+element.presentprice);
                    $prdtDetailClone.appendTo($prdtDisplay);
                });

            }
        },
        error: function (errorCode) {
            alert("加载分页出现错误，错误代码：" + errorCode);
        }
    });

}

//according the maxpage to set the option element
function setOptionElement(select, currentPage, maxPage){
    var $option = select.children();    //the option elements

    if(currentPage > maxPage){
        return false;
    }

    $.each($option, function (index, element) {
        $(element).attr("hidden",false);
        var pageNumber = currentPage-(2-index);
        if(pageNumber < 1 || pageNumber > maxPage){
            $(element).attr("hidden",true);
        }else{
            $(element).text(pageNumber);
        }

    });

}


function pagination(){

   $.get("toProductgetHomepageProductCount.action",function(data){

        var currentPage = 1;    //first page
        //first get total page numbers
        var prdtCount = 0;

        prdtCount = data.prdtCount;
        console.info("product count",prdtCount);

        //get the page number
        var dataCountPerPage = 20;
        var pageCount = 0;
        if(prdtCount%dataCountPerPage===0){
            pageCount = parseInt(prdtCount/dataCountPerPage);
        }
        else{
            pageCount = parseInt(prdtCount/dataCountPerPage)+1;
        }
        console.info("pageCount", pageCount);

        //get Dom
        var $firstSpan = $("#first_span");
        var $prevSpan = $("#prev_span");
        var $optionSpan = $("#option_span option");
        var $nextSpan = $("#next_span");
        var $lastSpan = $("#last_span");

        setOptionElement($("#option_span select"), 1, prdtCount);
        pushPageRequest(1,dataCountPerPage,pageCount);

        //bind click event
        $firstSpan.bind('click',function(){
            currentPage=1;
            pushPageRequest(1,dataCountPerPage,pageCount);
        });
        $prevSpan.bind('click', function () {
            pushPageRequest(--currentPage,dataCountPerPage,pageCount);
        });
        $nextSpan.bind('click', function () {
            pushPageRequest(++currentPage,dataCountPerPage,pageCount);
        });
        $lastSpan.bind('click', function () {
            currentPage = pageCount;
            pushPageRequest(pageCount,dataCountPerPage,pageCount);
        });

        bindClickEventToSelect($optionSpan);
    });

}


