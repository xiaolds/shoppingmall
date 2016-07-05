/**
 * Created by Lids on 2016/7/5.
 */

var Shopcart = {

    newInstance: function(){
        var shopcart={};

        //加载并格式化table
        shopcart.loadTable = function () {
            var $table = $("#product_table");
            $table.dataTable({
                "serverSide": true,
                "ajax":{
                    "url": "toUsergetShopcart.action",
                    "type":"POST",
                    "dataSrc":function(json){
                    	console.info("json",json);
                    }
                }

            });
        };
        return shopcart;
    }
};

$(window).load(function(){
    var shop = Shopcart.newInstance();
    shop.loadTable();
});



