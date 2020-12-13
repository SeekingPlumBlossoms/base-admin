let tableIns;
let tableInsOnLine;
let tree;

layui.use(['element', 'form', 'table', 'layer', 'laydate', 'tree', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    tree = layui.tree;
    let height = document.documentElement.clientHeight;
    //用户列表
    tableIns = table.render({
        elem: '#productTable'
        , url: ctx + '/user/product/page'
        , method: 'POST'
        //请求前参数处理
        , request: {
            pageName: 'page' //页码的参数名称，默认：page
            , limitName: 'rows' //每页数据量的参数名，默认：limit
        }
        , response: {
            statusName: 'flag' //规定数据状态的字段名称，默认：code
            , statusCode: true //规定成功的状态码，默认：0
            , msgName: 'msg' //规定状态信息的字段名称，默认：msg
            , countName: 'records' //规定数据总数的字段名称，默认：count
            , dataName: 'rows' //规定数据列表的字段名称，默认：data
        }
        //响应后数据处理
        , parseData: function (res) { //res 即为原始返回的数据
            var data = res.data;
            return {
                "flag": res.flag, //解析接口状态
                "msg": res.msg, //解析提示文本
                "records": data.records, //解析数据长度
                "rows": data.rows //解析数据列表
            };
        }
        , toolbar: '#productSuTable'
        , title: '用户列表'
        , cols: [[
            {field: 'id', title: 'ID', hide: true}
            , {field: 'prodcutId', title: '产品Id'}
            , {field: 'prodcutName', title: '产品名称'}
            , {field: 'upProdcutId', title: '上游产品id'}
            , {field: 'upProdcutName', title: '上游产品名称'}
            , {field: 'productValue', title: '产品面值'}
            // , {fixed: 'right', title: '操作', toolbar: '#liOrderTable'}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
    });

//头工具栏事件
    table.on('toolbar(test)', function (obj) {
        switch (obj.event) {
            case 'query':
                let prodcutId = $("#prodcutId").val();
                let prodcutName = $("#prodcutName").val();
                let upProdcutId = $("#upProdcutId").val();
                let upProdcutName = $("#upProdcutName").val();
                let productValue = $("#productValue").val();

                let query = {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , done: function (res, curr, count) {
                        //完成后重置where，解决下一次请求携带旧数据
                        // this.where = {};
                    }
                };
                //设定异步数据接口的额外参数
                query.where = {
                    prodcutId: prodcutId,
                    prodcutName: prodcutName,
                    upProdcutId: upProdcutId,
                    upProdcutName: upProdcutName,
                    productValue: productValue
                };
                tableIns.reload(query);
                $("#prodcutId").val(prodcutId);
                $("#prodcutName").val(prodcutName);
                $("#upProdcutId").val(upProdcutId);
                $("#upProdcutName").val(upProdcutName);
                $("#productValue").val(productValue);
                break;
        }
    });
});
