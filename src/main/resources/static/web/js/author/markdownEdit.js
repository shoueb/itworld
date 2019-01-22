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
    var oInit = new Object()
    var clientHeigt = document.documentElement.clientHeight
    oInit.Init = function(){

    }
    oInit.HegitInit = function(){
        $("#oriContent").css("height",clientHeigt-50);
    }

    return oInit;
}
function MarkdownInit(){
    var oInit = new Object()
    var coverter = new showdown.Converter();
    oInit.getCoverter =function(){
        return coverter;
    }
    oInit.getCoverterHtml = function(){
        var text = $("#oriContent").val();
        return coverter.makeHtml(text)
    }
    return oInit;
}
function ButtonInit(){
    var oInit = new Object()

    var oTextarea = document.getElementById("oriContent");


    oInit.Init = function(){
        /*编辑*/
        $('#oriContent').on('keyup focus ',function () {
            var html = oMarkdownInit.getCoverterHtml();
            $("#result").html(html)
        });
        /*粗体*/
        $('#setBold').off('click').on('click',function(){
            var textSelection = oInit.funGetSelected(oTextarea);
            var MARK = "粗体文本";
            if (!textSelection || textSelection === MARK) {
                //没有文字选中，光标处插入
                oInit.funInsertMark(oTextarea,"**粗体文本**",2,6);
            } else {
                oInit.funTextAsMark(oTextarea, "**" + textSelection + "**");
            }
        })
        /*斜体*/
        $('#setItalic').off('click').on('click',function(){
            var textSelection = oInit.funGetSelected(oTextarea);
            var MARK = "斜体文本";
            if (!textSelection || textSelection === MARK) {
                //没有文字选中，光标处插入
                oInit.funInsertMark(oTextarea,"*斜体文本*",1,5);
            } else {
                oInit.funTextAsMark(oTextarea, "*" + textSelection + "*");
            }
        })
        /*链接*/ //[baidu](http://jianshu.com)
        $('#setLink').off('click').on('click',function(){
            $('#linkInput').val('');
            $('.linkModal').modal("show");
        })
        $('#setLinkModelBtn').off('click').on('click',function(){
            var link = $('#linkInput').val();
            if (link!==null&&link!=null){
                var markvlue = "[请在此处输入链接名称]("+link+")"
                oInit.funInsertMark(oTextarea,markvlue,1,11)
                $('.linkModal').modal("hide");
                oTextarea.focus();
            }
        })
        /*引用*/
        $('#setQuote').off('click').on('click',function(){
            var textSelection = oInit.funGetSelected(oTextarea);
            var MARK = "段落引用";
            if (!textSelection || textSelection === MARK) {
                //没有文字选中，光标处插入
                oInit.funInsertMark(oTextarea,">段落引用",1,5);
            } else {
                oInit.funTextAsMark(oTextarea, ">" + textSelection );
            }
        })
        /*代码*/
        $('#setCode').off('click').on('click',function(){
            var textSelection = oInit.funGetSelected(oTextarea);
            var MARK = "此处输入代码";
            if (!textSelection || textSelection === MARK) {
                //没有文字选中，光标处插入
                oInit.funInsertMark(oTextarea,"`此处输入代码`",1,7);
            } else {
                oInit.funTextAsMark(oTextarea, "`" + textSelection+"`" );
            }
        })
        /*图片*/
        $('#setImage').off('click').on('click',function(){
            $('.imageModal').modal("show");
        })
        /*有序列表*/
        $('#setListOl').off('click').on('click',function(){
            var textSelection = oInit.funGetSelected(oTextarea);
            var MARK = "列表项";
            if (!textSelection || textSelection === MARK) {
                //没有文字选中，光标处插入
                oInit.funInsertMark(oTextarea,"1.列表项",2,5);
            } else {
                oInit.funTextAsMark(oTextarea, "1." + textSelection );
            }
        })
        /*无序列表*/
        $('#setListUl').off('click').on('click',function(){
            var textSelection = oInit.funGetSelected(oTextarea);
            var MARK = "列表项";
            if (!textSelection || textSelection === MARK) {
                //没有文字选中，光标处插入
                oInit.funInsertMark(oTextarea,"- 列表项",2,5);
            } else {
                oInit.funTextAsMark(oTextarea, "- " + textSelection );
            }
        })
        /*标题*/
        $('#setTitle').off('click').on('click',function(){

        })
        /*分割线*/
        $('#setDividingLine').off('click').on('click',function(){
            var textSelection = oInit.funGetSelected(oTextarea);
            var MARK = "----------";
            if (!textSelection || textSelection === MARK) {
                //没有文字选中，光标处插入
                oInit.funInsertMark(oTextarea,"----------",0,10);
            } else {
                oInit.funTextAsMark(oTextarea, "----------" + textSelection );
            }
        })
        /*撤销*/
        $('#btnReply').off('click').on('click',function(){

        })
        /*重做*/
        $('#btnRedo').off('click').on('click',function(){

        })

    }
    oInit.funGetSelected = function(element){
        if (!window.getSelection) {
            //IE浏览器
            return document.selection.createRange().text;
        } else {
            return element.value.substr(element.selectionStart, element.selectionEnd - element.selectionStart);
        }
    }
    oInit.funInsertMark = function(textObj,markvalue,cursorStart,cursorEnd){
        var topic = markvalue, value = textObj.value, index = value.indexOf(topic);
        var start =cursorStart,end=cursorEnd
        if (index === -1) {
            //匹配
            oInit.funTextAsMark(textObj, topic);
        }
        value = textObj.value;
        index = value.indexOf(topic);
        if (textObj.createTextRange) {
            var range = textObj.createTextRange();
            range.moveEnd("character", -1 * value.length)
            range.moveEnd("character", index + 6);
            range.moveStart("character", index + 1);
            range.select();
        } else {
            textObj.setSelectionRange(index + start, index + end);
            textObj.focus();
        }
    }
    oInit.funTextAsMark = function(textObj, textFeildValue) {
        textObj.focus();
        if (textObj.createTextRange) {
            var caretPos = document.selection.createRange().duplicate();
            document.selection.empty();
            caretPos.text = textFeildValue;
        } else if (textObj.setSelectionRange) {
            var rangeStart = textObj.selectionStart;
            var rangeEnd = textObj.selectionEnd;
            var tempStr1 = textObj.value.substring(0, rangeStart);
            var tempStr2 = textObj.value.substring(rangeEnd);
            textObj.value = tempStr1 + textFeildValue + tempStr2;
            textObj.blur();
        }
    };
    return oInit;
}





$.fn.insertText = function (text) {
    var obj = $(this)[0];
    var range, node;
    if (!obj.hasfocus) {
        obj.focus();
    }

    if (document.selection && document.selection.createRange) {
        this.focus();
        document.selection.createRange().pasteHTML(text);
        this.focus();
    } else if (window.getSelection && window.getSelection().getRangeAt) {
        range = window.getSelection().getRangeAt(0);
        range.collapse(false);
        node = range.createContextualFragment(text);
        var c = node.lastChild;
        range.insertNode(node);
        if (c) {
            range.setEndAfter(c);
            range.setStartAfter(c)
        }
        var j = window.getSelection();
        j.removeAllRanges();
        j.addRange(range);
        this.focus();
    }
}