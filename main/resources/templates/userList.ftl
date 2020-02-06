<#import "common/common.ftl" as c>

<@c.page true>


    <div class="container">
        <h4>Список пользователей</h4>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td><a href="/user/${user.id}">edit</a></td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>
</@c.page>