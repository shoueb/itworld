var oContentIframeInit,oReviewIframeInit,oInit

$('#contentIframe').load(function(){
    oContentIframeInit = new ContentIframeInit();
    oContentIframeInit.Init()
});

$('#reviewIframe').load(function(){
    oReviewIframeInit = new ReviewIframeInit();
    oReviewIframeInit.Init();
})

$(function () {
    
});

var ContentIframeInit = function(){

    var oInit = new Object();
    oInit.Init = function(){
        var iframe = document.getElementById('contentIframe');
        iframe.height =  iframe.contentWindow.document.documentElement.scrollHeight;
    }
    return oInit;
}

var ReviewIframeInit = function(){
    var oInit = new Object();
    oInit.Init = function(){
        var iframe = document.getElementById('reviewIframe');
        iframe.height =  iframe.contentWindow.document.documentElement.scrollHeight;
    }
    return oInit;
}

var Init = function () {
    var oInit = new Object();
    oInit.Init = function(){

    }
    return oInit;
}