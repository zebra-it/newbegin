<#import "common/common.ftl" as c>

<@c.page>

    <div class="container">
        <h4>Список постов в каком то там порядке</h4>
        <a href="/statistics/grath">Grath</a>
        <table>
            <thead>
            <tr>
                <th>Text</th>
                <th></th>
                <th>Data</th>
                <th>Time</th>
            </tr>
            </thead>
            <tbody>
            <#list posts as post>
                <tr>
                    <td>${post.text}</td>
                    <td></td>

                    <td>${post.createDate}</td>
                    <td>${post.createTime}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>