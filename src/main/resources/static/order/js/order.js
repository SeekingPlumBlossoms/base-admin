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
        elem: '#orderTable'
        , url: ctx + '/user/order/page'
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
        , toolbar: '#liOrderTable'
        , title: '用户列表'
        , cols: [[
            {field: 'id', title: 'ID', hide: true}
            , {field: 'orderId', title: '订单号'}
            , {field: 'downOrderId', title: '商户订单号'}
            , {field: 'account', title: '充值账号'}
            , {field: 'productName', title: '商品名称'}
            , {field: 'buyValue', title: '购买面值'}
            , {field: 'buyPrice', title: '购买金额'}
            , {field: 'orderTime', title: '订单时间'}
            , {field: 'orderEndTime', title: '完成时间'}
            , {field: 'downName', title: '商户名称'}
            , {field: 'orderStatus', title: '订单状态',template: function (d) {
                    if(d === 0){
                        return '成功'
                    }else if(d === 1){
                        return '失败'
                    }if(d === 2){
                        return '处理中'
                    }else {
                        return '未知'
                    }
                }}
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
                let orderId =$("#orderId").val();
                let account =$("#account").val();
                let downOrderId =$("#downOrderId").val();
                let downName =$("#downName").val();
                let productName =$("#productName").val();
                let buyValue =$("#buyValue").val();
                let orderStatus =$("#orderStatus").val();
                let queryOrderStartTime =$("#queryOrderStartTime").val();
                let queryOrderEndTime =$("#queryOrderEndTime").val();

                //todo 获取页面上的值传递后端
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
                    orderId : orderId,
                    account: account,
                    downOrderId : downOrderId,
                    downName : downName,
                    productName : productName,
                    buyValue : buyValue,
                    orderStatus : orderStatus,
                    queryOrderStartTime : queryOrderStartTime,
                    queryOrderEndTime : queryOrderEndTime
                };
                tableIns.reload(query);
                $("#orderId").val(orderId);
                $("#account").val(account);
                $("#downOrderId").val(downOrderId);
                $("#downName").val(downName);
                $("#productName").val(productName);
                $("#buyValue").val(buyValue);
                $("#orderStatus").val(orderStatus);
                // $("#queryOrderStartTime").val(queryOrderStartTime);
                // $("#queryOrderEndTime").val(queryOrderEndTime);
                break;
        }
    });


    //日期选择器
    laydate.render({
        elem: '#queryOrderStartTime',
        format: "yyyy-MM-dd HH:mm:ss"
    });

    //日期选择器
    laydate.render({
        elem: '#queryOrderEndTime',
        format: "yyyy-MM-dd HH:mm:ss"
    });
});
