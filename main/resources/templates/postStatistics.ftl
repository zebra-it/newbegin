<#import "common/common.ftl" as c>

<@c.page true>

    <div class="container">
        <div id="container"
             style="width: 550px; height: 400px; margin: 0 auto"></div>
        <div id="container1"
             style="width: 550px; height: 400px; margin: 0 auto"></div>
    </div>

    <script inline="javascript">
        $(function () {
            Highcharts.chart('container', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Статистика постов'
                },

                xAxis: {
                    categories: [
                        <#list datePosts as key>
                        '${key}',
                        </#list>
                    ],
                    crosshair: true
                },
                yAxis: {
                    title: {
                        text: 'Колличество постов'
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0"/>' +
                        '<td style="padding:0"><b>{point.y} </b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        pointPadding: 0.2,
                        borderWidth: 0
                    }
                },
                series: [{
                    name: 'Дата',
                    colorByPoint: true,
                    data: [
                        <#list countPostsDate as key>
                        ${key},
                        </#list>
                    ]
                }],

            });
        });

        $(function () {
            Highcharts.chart('container1', {
                chart: {
                    type: 'line'
                },
                title: {
                    text: ''
                },

                xAxis: {
                    categories: [
                        <#list timePosts as key>
                        '${key}',
                        </#list>
                    ],
                    crosshair: true
                },
                yAxis: {
                    title: {
                        text: 'колличество'
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0"/>' +
                        '<td style="padding:0"><b>{point.y} </b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        pointPadding: 0.2,
                        borderWidth: 0
                    }
                },
                series: [{
                    name: 'время',
                    colorByPoint: true,
                    data: [
                        <#list countPostsTime as key>
                        ${key},
                        </#list>
                    ]
                }],

            });
        });
    </script>

</@c.page>