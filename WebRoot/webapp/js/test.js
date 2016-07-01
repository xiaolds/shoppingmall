/**
 * Created by Lids on 2016/6/29.
 */

var animal = {

    //static private
    newInstance: function () {

        var animal = {};
        var eye = "animal eye";
        var leg = "animal leg";

        animal.getEye = function (){
            return eye;
        };

        animal.getLeg = function () {
            return leg;
        };

        return animal;

    }

};

var cat = {

    newInstance: function () {
        var cat = animal.newInstance();
        cat.i = 0;
        return cat;
    }

};

var cat1 = cat.newInstance();
console.info(cat1.getLeg());

/*
window.onload = function () {
    var cat1 = cat.newInstance();
    console.info(cat1.getLeg());
};
*/




