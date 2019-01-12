var oInit,oButtonInit;

$(function(){
    oInit = new Init();
    oInit.Init();

    oButtonInit = new ButtonInit();
    oButtonInit.Init();

});

/*页面加载完成后需要初始化的东西放这 */
var Init = function(){
    oInit = new Object();
    oInit.Init = function(){

    }
    return oInit;
}

//按钮事件
var ButtonInit = function(){
    oButtonInit = new Object();
    oButtonInit.Init = function(){
        $(".articleType").off('click').on('click',function(){
            $(this).addClass("text-danger").siblings('.articleType').removeClass("text-danger");
        })

        $(".languageType").off('click').on('click',function(){
            $(this).addClass("text-danger").siblings('.languageType').removeClass("text-danger");
        })
    }
    return oButtonInit;
}