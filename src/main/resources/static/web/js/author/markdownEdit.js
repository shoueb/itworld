var oinit,oMarkdownInit,obuttoninit;

$(function () {
    oinit = new Init();
    oinit.HegitInit();
    oinit.Init();

    oMarkdownInit = new MarkdownInit()

    obuttoninit = new ButtonInit();
    obuttoninit.Init();
})

function Init() {
    oInit = new Object()
    var clientHeigt = document.documentElement.clientHeight
    oInit.Init = function(){

    }
    oInit.HegitInit = function(){
        $("#oriContent").css("height",clientHeigt-50);
    }

    return oInit;
}
function MarkdownInit(){
    oInit = new Object()
    var coverter = new showdown.Converter();
    oInit.getCoverter =function(){
        return coverter;
    }
    return oInit;
}
function ButtonInit(){
    oButtonInit = new Object()
    oButtonInit.Init = function(){
        $('#oriContent').on('keyup',function () {
            var text = $("#oriContent").val();
            var html = oMarkdownInit.getCoverter().makeHtml(text);
            $("#result").html(html)
        });
    }
    return oButtonInit;
}