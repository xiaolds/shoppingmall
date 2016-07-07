/**
 * Created by Lids on 2016/7/5.
 */

var Shopcart = {

    newInstance: function(){
        var shopcart={};

        //鍔犺浇骞舵牸寮忓寲table
        shopcart.loadTable = function () {
            var $table = $("#product_table");
            $table.dataTable();
        };
        //浠嶴erver绔姞杞借〃鏍兼暟鎹紝骞惰В鏋�
        shopcart.loadTableData = function () {
            var $table = $("#product_table");
            //从服务器获取数据
            $.ajax({
               url:"toUsergetShopcart.action",
                type:"post",
                success: function (data, textStatus) {
                    //TODO
                    //var htmlText = "<tr><th>12</th><th>上海老酸奶</th><th>￥10</th><th>3</th></tr>";
                    if("success"===textStatus){
                        var $tbody = $('tbody');
                        var htmlStr = '';
                        $.each(data.prdtList, function (index, element) {
                             htmlStr += '<tr><th>'+element.prdtId+'</th><th>'+element.prdtName+'</th><th>￥'+element.prdtPrice+'</th><th>3</th></tr>';
                        });
                        $tbody.html(htmlStr);
                    }
                }
            });
        };

        //浠巗ever绔姞杞界敤鎴峰鍚�
        shopcart.getUserName = function () {
            $.ajax({
              url:"toUsergetOnlineUserName.action",
                type:"post",
                success: function (data, textStatus) {
                    if("success" === textStatus){
                    	console.info("userName",data.UserName);
                        if(data.UserName){
                            $(".link_login").text(data.UserName);
                        }
                    }
                }
            });
        };
        return shopcart;
    }
};

$(window).load(function(){
    var shop = Shopcart.newInstance();
    shop.getUserName();
    shop.loadTable();
    shop.loadTableData();
});



