var theLayout;

var layoutWidgetConfig = function(element, isInitialized) {
    if (!isInitialized) {
        theLayout = new dhtmlXLayoutObject({
            parent: element, // parent container
            pattern: "2U", // layout's pattern

            offsets: { // optional, offsets for fullscreen init
                top: 10, // you can specify all four sides
                right: 10, // or only the side where you want to have an offset
                bottom: 10,
                left: 10
            },

            cells: [ // optional, cells configuration according to the pattern
                // you can specify only the cells you want to configure
                // all params are optional
                {
                    id: "a", // id of the cell you want to configure
                    text: "Folders", // header text
                    collapsed_text: "Folders", // header text for a collapsed cell
                    header: false, // hide header on init
                    width: 300, // cell init width
                    collapse: false, // collapse on init
                    fix_size: [false, true] // fix cell's size, [width,height]
                },
                {
                    id: "b", // id of the cell you want to configure
                    text: "File", // header text
                    collapsed_text: "File", // header text for a collapsed cell
                    header: false, // hide header on init
                    collapse: false, // collapse on init
                    fix_size: [false, true] // fix cell's size, [width,height]
                },

            ]
        });
    }
};


var layoutWidget = {
    view: function() {
        return m('.layoutWidget', { config: layoutWidgetConfig }, '');
    }
};
