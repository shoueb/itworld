$(function(){
    //添加导航点击事件
    $("#myBar li").click(function (e) {
        e.preventDefault()
        $(this).tab('show')
        window.location.href = $(this).children('a').attr('href');
    });
});