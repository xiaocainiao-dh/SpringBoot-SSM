<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title></title>
</head>
<body>
    <table border="1" width="100%">
        <tr>
            <td>本地服务器</td>
            <td>http://192.168.160.129&nbsp;&nbsp;</td>
            <td>
                <font id="font438082">
                    <img src="/static/images/loading.gif"/>
                </font>
            </td>
        </tr>
        
        <#--<tr>
            <td rowspan="2" >OPD公众出具</td>
            <td>http://172.16.56.43&nbsp;&nbsp;</td>
            <td><font id="font440000"><img src="/resource/images/loading.gif"/></font></td>
        </tr>
        <tr>
            <td>http://172.16.56.44&nbsp;&nbsp;</td>
            <td><font id="font440001"><img src="/resource/images/loading.gif"/></font></td>
        </tr>
&lt;#&ndash;        <tr><td colspan="4"></</td></tr>&ndash;&gt;
        <tr>
            <td rowspan="2">OPD审查员</td>
            <td>http://172.16.56.60&nbsp;&nbsp;</td>
            <td><font id="font440002"><img src="/resource/images/loading.gif"/></font></td>
        </tr>
        <tr>
            <td>http://172.16.56.61&nbsp;&nbsp;</td>
            <td><font id="font440003"><img src="/resource/images/loading.gif"/></font></td>
        </tr>
&lt;#&ndash;        <tr><td colspan="4"></</td></tr>&ndash;&gt;
        <tr>
            <td rowspan="4">OPD公众获取</td>
            <td>http://172.16.57.1&nbsp;&nbsp;</td>
            <td><font id="font440004"><img src="/resource/images/loading.gif"/></font></td>
        </tr>
        <tr>
            <td>http://172.16.57.2&nbsp;&nbsp;</td>
            <td><font id="font440005"><img src="/resource/images/loading.gif"/></font></td>
        </tr>
        <tr>
            <td>http://172.16.57.3&nbsp;&nbsp;</td>
            <td><font id="font440006"><img src="/resource/images/loading.gif"/></font></td>
        </tr>
        <tr>
            <td>http://172.16.57.4&nbsp;&nbsp;</td>
            <td><font id="font440007"><img src="/resource/images/loading.gif"/></font></td>
        </tr>-->
    </table>
</body>
<script type="text/javascript" src="/static/js/jquery-1.4.2.js"></script>
<script>
    $.ajax({
        url: "/hservice.action",
        data: "&host=192.168.160.129&port=22&keys=7D6BD39149B69FE240D47789308742FC",
        type: "post",
        async:true,
        success: function(result){
            if(result=='1'){
                var font438082 = document.getElementById('font438082');
                font438082.innerHTML = "<img src=\"/static/images/zc.png\"/> ";
            } else {
                var font438082 = document.getElementById('font438082');
                font438082.innerHTML = result;
            }
        }
    });

    /*$.ajax({
        url: "/hservice.action",
        data: "&host=172.16.56.43&port=22&keys=F64BDCB28F996997C335D885B1866CBF",
        type: "post",
        async:true,
        success: function(result){
            if(result=='1'){
                var font438082 = document.getElementById('font440000');
                font438082.innerHTML = "<img src=\"/static/images/zc.png\"/> ";
            } else {
                var font438082 = document.getElementById('font440000');
                font438082.innerHTML = result;
            }
        }
    });

    $.ajax({
        url: "/hservice.action",
        data: "&host=172.16.56.44&port=22&keys=F64BDCB28F996997C335D885B1866CBF",
        type: "post",
        async:true,
        success: function(result){
            if(result=='1'){
                var font438082 = document.getElementById('font440001');
                font438082.innerHTML = "<img src=\"/static/images/zc.png\"/> ";
            } else {
                var font438082 = document.getElementById('font440001');
                font438082.innerHTML = result;
            }
        }
    });

    $.ajax({
        url: "/hservice.action",
        data: "&host=172.16.56.60&port=22&keys=F64BDCB28F996997C335D885B1866CBF",
        type: "post",
        async:true,
        success: function(result){
            if(result=='1'){
                var font438082 = document.getElementById('font440002');
                font438082.innerHTML = "<img src=\"/static/images/zc.png\"/> ";
            } else {
                var font438082 = document.getElementById('font440002');
                font438082.innerHTML = result;
            }
        }
    });

    $.ajax({
        url: "/hservice.action",
        data: "&host=172.16.56.61&port=22&keys=F64BDCB28F996997C335D885B1866CBF",
        type: "post",
        async:true,
        success: function(result){
            if(result=='1'){
                var font438082 = document.getElementById('font440003');
                font438082.innerHTML = "<img src=\"/static/images/zc.png\"/> ";
            } else {
                var font438082 = document.getElementById('font440003');
                font438082.innerHTML = result;
            }
        }
    });

    $.ajax({
        url: "/hservice.action",
        data: "&host=172.16.57.1&port=22&keys=F64BDCB28F996997C335D885B1866CBF",
        type: "post",
        async:true,
        success: function(result){
            if(result=='1'){
                var font438082 = document.getElementById('font440004');
                font438082.innerHTML = "<img src=\"/static/images/zc.png\"/> ";
            } else {
                var font438082 = document.getElementById('font440004');
                font438082.innerHTML = result;
            }
        }
    });

    $.ajax({
        url: "/hservice.action",
        data: "&host=172.16.57.2&port=22&keys=F64BDCB28F996997C335D885B1866CBF",
        type: "post",
        async:true,
        success: function(result){
            if(result=='1'){
                var font438082 = document.getElementById('font440005');
                font438082.innerHTML = "<img src=\"/static/images/zc.png\"/> ";
            } else {
                var font438082 = document.getElementById('font440005');
                font438082.innerHTML = result;
            }
        }
    });

    $.ajax({
        url: "/hservice.action",
        data: "&host=172.16.57.3&port=22&keys=F64BDCB28F996997C335D885B1866CBF",
        type: "post",
        async:true,
        success: function(result){
            if(result=='1'){
                var font438082 = document.getElementById('font440006');
                font438082.innerHTML = "<img src=\"/static/images/zc.png\"/> ";
            } else {
                var font438082 = document.getElementById('font440006');
                font438082.innerHTML = result;
            }
        }
    });

    $.ajax({
        url: "/hservice.action",
        data: "&host=172.16.57.4&port=22&keys=F64BDCB28F996997C335D885B1866CBF",
        type: "post",
        async:true,
        success: function(result){
            if(result=='1'){
                var font438082 = document.getElementById('font440007');
                font438082.innerHTML = "<img src=\"/static/images/zc.png\"/> ";
            } else {
                var font438082 = document.getElementById('font440007');
                font438082.innerHTML = result;
            }
        }
    });*/
</script>
</html>