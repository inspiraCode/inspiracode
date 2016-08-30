var theTreeView;

var filesNavWidgetConfig = function(element, isInitialized) {
    if (!isInitialized) {
        theTreeView = new dhtmlXTreeView({
            parent: element, // id/object, container for treeview
            skin: "dhx_skyblue", // string, optional, treeview's skin
            // iconset: "font_awesome", // string, optional, sets the font-awesome icons
            multiselect: false, // boolean, optional, enables multiselect
            checkboxes: false, // boolean, optional, enables checkboxes
            dnd: false, // boolean, optional, enables drag-and-drop
            context_menu: false, // boolean, optional, enables context menu
            // json: "filename.json", // string, optional, json file with struct
            // xml: "filename.xml", // string, optional, xml file with struct
            items: [{ // array, optional, array with tree struct
                id: 1,
                text: "Books",
                open: 1,
                items: [
                    { id: 2, text: "Turned at Dark / C. C. Hunter" },
                    { id: 3, text: "Daire Meets Ever / Alyson Noël" },
                    { id: 4, text: "Socs and Greasers / Rob Lowe" },
                    { id: 5, text: "Privacy and Terms.pdf" },
                    { id: 6, text: "Licence Agreement.pdf" }
                ]
            }],
            onload: function() {} // callable, optional, callback for load
        });
    }
};

var filesNavWidget = {
    view: function() {
        return m('.filesNavWidget', { config: filesNavWidgetConfig }, '');
    }
};
