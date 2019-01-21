var oinit,oRichtextInit,obuttoninit;

$(function () {
    oinit = new Init();
    oinit.Init();

    oRichtextInit = new RichtextInit()

    obuttoninit = new ButtonInit();
    obuttoninit.Init();
})

function Init() {
    var oInit = new Object()
    oInit.Init = function(){

    }


    return oInit;
}
function RichtextInit(){
    var oInit = new Object()
    var um = UM.getEditor('myEditor');
    oInit.getUe =function(){
        return um;
    }
    return oInit;
}
function ButtonInit(){
    var oButtonInit = new Object()
    oButtonInit.Init = function(){

    }
    return oButtonInit;
}