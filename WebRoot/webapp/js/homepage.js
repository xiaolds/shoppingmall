/**
 * create by Lids on 2016/06/22
 */

$(window).load(function(){
    loadProductContent();
});

function loadProductContent(){

    var content_list = $(".content_list");
    //<li><a href="url"></a></li>

    $.ajax({
        url:"toProductgetContent.action",
        async:false,
        success:function(data){
//        	var str;
            $.each(data.data,function(i,value){
                //取出数据
                var name = value.categorydesc;
                var url = value.url;
                var str = "<li><a href='"+url+"'>"+name+"</a></li>";
                console.log("li",str);
                content_list.append(str);
            });
            
            console.info("fuck");
        },
        error:function(){
            alert("加载目录出错");
        }
    });
}