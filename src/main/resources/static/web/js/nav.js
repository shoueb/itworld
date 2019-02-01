$(function(){
    //添加导航点击事件
    $("#myBar li").click(function (e) {
        e.preventDefault();
        console.log("========"+$(this).children('a').attr('href'));
        window.location.href = $(this).children('a').attr('href');
    });
});