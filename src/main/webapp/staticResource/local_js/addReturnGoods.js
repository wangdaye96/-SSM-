/**
 * 增加商品退货订单js
 */
$(document).ready(function(){
    let Num="";
    for(let i=0;i<7;i++){
        Num+=Math.floor(Math.random()*10);
    }
    document.getElementById("returnId").value=Num;
});