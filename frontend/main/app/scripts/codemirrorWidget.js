var theCodeMirror;
var codeMirrorWidgetConfig = function(element, init) {
    if (!init) {
        theCodeMirror = CodeMirror(element, {
            mode: 'javascript',
            value: "function myScript(){\n\treturn 100;\n}\n",
        });
    }
}

var codeMirrorWidget = {
    view: function(ctrl) {
        return m('.codeMirrorWidget', { config: codeMirrorWidgetConfig }, '');
    }
};
