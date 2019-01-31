(function() {
    $(function() {
        // marked
        var markedRender = new marked.Renderer();
        marked.setOptions({
            renderer: markedRender,
            gfm: true,
            tables: true,
            breaks: true,  // '>' 换行，回车换成 <br>
            pedantic: false,
            sanitize: true,
            smartLists: true,
            smartypants: false
        });
        markDownToHtml($("#context").val());
    });

    function markDownToHtml(markdown) {
        $('.markdown-body').html(marked(markdown));
        $('.markdown-body pre code').each(function(i, block) {
            Prism.highlightElement(block);
        });
    }
})();