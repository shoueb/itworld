var oInit,oButtonInit;
//初始化
$(function(){

    oInit = new Init();
    oInit.Init();

    oButtonInit = new ButtonInit();
    oButtonInit.Init();
    //执行分页方法
    buildPage();
});

/*页面加载完成后需要初始化的东西放这 */
var Init = function(){
    oInit = new Object();
    oInit.Init = function(){

    }
    return oInit;
};

//初始化按钮事件【一般为点击事件】
var ButtonInit = function(){
    oButtonInit = new Object();
    oButtonInit.Init = function(){
        $(".articleType").off('click').on('click',function(){
            $(this).addClass("text-danger").siblings('.articleType').removeClass("text-danger");
        });

        $(".languageType").off('click').on('click',function(){
            $(this).addClass("text-danger").siblings('.languageType').removeClass("text-danger");
        });
    };
    return oButtonInit;
};
//登陆函数   也可以写到ButtonInit 的Init中
function login() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/doLogin" ,//url
        data: {username:$("#username").val(), pwd:$("#pwd").val()},
        success: function (result) {
            console.log(result);//打印服务端返回的数据(调试用)
            if (result.code === 1) {
               window.location.href="/login";
               return true;
            }else{
                alert(result.msg);
            }
        },
        error : function() {
            alert("系统异常！");
        }
    });
}

//构建分页
function buildPage() {
    var str="";
    if(1==page) {
        str = str + " <li class=\"page-item active\"><a class=\"page-link\" href=\"javascript:void(0);\">1</a></li>";
    }else{
        str = str + " <li class=\"page-item \"><a class=\"page-link\" href=\"javascript:void(0);\">1</a></li>";
    }
    if(page<=5){
        for(var i=2;i<20;i++){
            if(i==page){
                str=str+" <li class=\"page-item active\"><a class=\"page-link\" href=\"javascript:void(0);\">"+i+"</a></li>";
            }else{
                str=str+" <li class=\"page-item \"><a class=\"page-link\" href=\"javascript:void(0);\">"+i+"</a></li>";
            }
        }
    }
    if(200==page) {
        str = str + " <li class=\"page-item active\"><a class=\"page-link\" href=\"javascript:void(0);\">200</a></li>";
    }else{
        str = str + " <li class=\"page-item \"><a class=\"page-link\" href=\"javascript:void(0);\">...</a></li>";
        str = str + " <li class=\"page-item \"><a class=\"page-link\" href=\"javascript:void(0);\">200</a></li>";
    }
    $("#page").html(str);
}