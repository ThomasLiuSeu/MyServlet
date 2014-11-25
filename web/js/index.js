Ext.onReady(function() {

    var myTplComboStore = new Ext.data.ArrayStore({
        idIndex :0,
        fields : ['id', 'name'],
        data : [[1,'AAA'], [2, 'BBB']]
    })

    var myTplCombo = {
        xtype : 'combo',
        mode : 'local',
        store : myTplComboStore,
        displayField:  'name',
        valueField:'id',
        autoLoad: true
    }

//    myTplCombo.load();
    var myPanel = new Ext.form.FormPanel({
        items : [{
            xtype:'combo',
            id : 'xueli-combo',
            name:'study',
            store:['专科','本科','硕士','博士'],
            fieldLabel:'学历',
            anchor:'95%',
            listeners : {
                select : function() {
                    this.getEl().up('.x-form-item').first().setDisplayed(false);
                }
            }
        }  ]
    })

    var myWin = new Ext.Viewport({
        height : 100,
        width : 100,
        title : 'Welcome',
        items : [myPanel]
    })
})