/**
 * Created by Lids on 2016/6/22.
 */
function byClass(parent,oClass){

    var aEl=parent.getElementsByTagName("*");
    var arr=[];
    for (var i=0; i<aEl.length; i++){

        if (aEl[i].className==oClass){
            arr.push(aEl[i]);
        };
    };
    return arr;
};

function move(index){

    var oOut=byClass(document,"out")[index];
    var oCon=byClass(oOut,"con")[0];
    var aConLi=oCon.getElementsByTagName("li");
    var oNav=byClass(oOut,"nav")[0];
    var aSpan=oNav.getElementsByTagName("span");

    var timer=null;
    var ind=0;
    var index=0;

    oOut.style.width=aConLi[0].offsetWidth+"px";
    oOut.style.height=aConLi[0].offsetHeight+"px";
    oNav.style.width=aConLi[0].offsetWidth+"px";

    for( var i=0;i<aSpan.length;i++){
        aSpan[i].index=i;
        aSpan[i].onmouseover=function(){
            index=this.index;
            for(var i=0;i<aSpan.length;i++){
                aSpan[i].className="";
            };
            ind=0;
            var start=oCon.offsetLeft;
            var end=-aConLi[0].offsetWidth*index;
            var change=end-start;
            clearInterval(timer);
            timer=setInterval(function(){

                ind++;
                if (ind>30){
                    ind=30;
                    clearInterval(timer);
                };
                oCon.style.left=Tween.Cubic.easeOut(ind,start,change,30)+"px";
            },30);
            aSpan[this.index].className="active";
        };
    };
};
window.onload=function(){
    var oOut=byClass(document,"out")
    for(var i=0;i<oOut.length;i++){
        move(i);
    };
};
