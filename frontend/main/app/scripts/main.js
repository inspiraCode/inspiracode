var mainHeader = {
    view: function() {
        return m('nav.navbar.navbar-default.navbar-fixed-top', [
            m('.container-fluid', [
                m('.navbar-header', [
                    m('button.navbar-toggle.collapsed[data-toggle="collapse"][data-target="#bs1"][aria-expanded="false"]', [
                        m('span.sr-only', 'Toggle navigation'),
                        m('span.icon-bar', ''),
                        m('span.icon-bar', ''),
                        m('span.icon-bar', ''),

                    ]),
                    m('a.navbar-brand', 'Inspiracode')
                ]),
                m('.collapse.navbar-collapse#bs1', [
                    m('ul.nav.navbar-nav', [
                        // m('li.active', [
                        //     m('a', 'hola')
                        // ]),
                        // m('li', [
                        //     m('a', 'adios')
                        // ]),

                    ])
                ])
            ])
        ]);
    }
};


// var layoutContainer = {
//     view: function(){
//         return m('.container-fluid')
//     }
// }

var mainBody = {
    view: function() {
        return m('.mainBody', [
            filesNavWidget,
            codeMirrorWidget
        ]);
    }
};




var app = {
    view: function() {
        return [m.component(mainHeader), mainBody];
    }
};

m.mount(document.body, app);
