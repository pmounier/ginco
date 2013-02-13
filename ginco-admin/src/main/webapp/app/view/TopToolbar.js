Ext.define('HadocApp.view.TopToolbar', {
    extend: 'Ext.toolbar.Toolbar',
    alias: 'widget.topToolBar',
    localized: true,
    xNewLabel: "New",
    xAdministrationLabel: "Administration",
    xControlLabel: "Control",
    xTopWelcomeLabel: "Hadoc GINCO Back-office",
    xJournalLabel: "Journal",
    xExportLabel: "Exports",
    xAboutLabel: "About",
    xSearchLabel: "Search",
    xSearchFieldText: "Search a term",
    xConnectedAsLabel: "Connected as",
    xNewMenu_ThesaurusLabel: "Thesaurus",
    xNewMenu_ConceptLabel: "Concept",
    xNewMenu_TermLabel: "Term",
    xNewMenu_GroupLabel: "Group of Concepts",
    xHelpLabel: "Help",
    height: 64,

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {	xtype: 'box',autoEl: {tag: 'img', src:'images/ginco-logo-xs.png', width:'32px', alt:'logo ginco'}},
                { xtype: 'box', autoEl: { tag: 'div', cls: 'title-bar', html: '<h1>Gestionnaire Thesaurus GINCO</h1>' }},
                {
                    xtype: 'tbseparator',
                    flex: 2,
                    height: 10,
                    width: 10
                },
                {
                    xtype: 'buttongroup',
                    title: me.xControlLabel,
                    columns: 1,
                    items: [
                        {
                            xtype: 'button',
                            disabled: false,
                            text: me.xNewLabel,
                            menu: {
                                xtype: 'menu',
                                width: 200,
                                items: [
                                    {
                                        xtype: 'keymenuitem',
                                        id: 'newThesaurusBtn',
                                        text: me.xNewMenu_ThesaurusLabel,
                                        cmdTxt: 'Ctrl+1'
                                    },
                                    {
                                        xtype: 'menuitem',
                                        disabled: true,
                                        text: me.xNewMenu_ConceptLabel
                                    },
                                    {
                                        xtype: 'menuitem',
                                        disabled: true,
                                        text: me.xNewMenu_TermLabel
                                    },
                                    {
                                        xtype: 'menuseparator'
                                    },
                                    {
                                        xtype: 'menuitem',
                                        disabled: true,
                                        text: me.xNewMenu_GroupLabel
                                    }
                                ]
                            }
                        }
                    ]
                },
                {
                    xtype: 'buttongroup',
                    title: me.xAdministrationLabel,
                    columns: 2,
                    items: [
                        {
                            xtype: 'button',
                            text: me.xJournalLabel,
                            disabled: true
                        },
                        {
                            xtype: 'button',
                            disabled: true,
                            text: me.xExportLabel
                        }
                    ]
                },
                {
                    xtype: 'buttongroup',
                    title: me.xHelpLabel,
                    columns: 2,
                    items: [
                        {
                            xtype: 'button',
                            id: 'aproposbtn',
                            text: me.xAboutLabel
                        },
                        {
                            xtype: 'button',
                            id: 'accessibilitybtn',
                            text: "Accessibilité",
                            enableToggle: true
                        }
                    ]
                },
                {
                    xtype: 'tbseparator',
                    flex: 2,
                    height: 10,
                    width: 10
                },
                {
                    xtype: 'triggerfield',
                    width: 276,
                    fieldLabel: me.xSearchLabel,
                    emptyText: me.xSearchFieldText,
                    hideTrigger: false,
                    repeatTriggerClick: false,
                    disabled: true
                },
                {
                    xtype: 'label',
                    text: me.xConnectedAsLabel
                }
            ]
        });

        me.callParent(arguments);
    }

});