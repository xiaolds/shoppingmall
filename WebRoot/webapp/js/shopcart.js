/**
 * Created by Lids on 2016/7/5.
 */

var Shopcart = {

    newInstance: function(){
        var shopcart={};

        shopcart.loadTable = function () {
            var $table = $("#product_table");
            $table.dataTable();
        }
        return shopcart;
    }
};

$(window).load(function(){
    var shop = Shopcart.newInstance();
    shop.loadTable();
});



