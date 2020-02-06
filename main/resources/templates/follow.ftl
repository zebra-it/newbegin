<#import "common/common.ftl" as c>

<@c.page true>

    <div class="container">
        <h3>${userChannel.username}</h3>
        <#if type = "followers">Подписаны <#else>Подписан</#if>
        <ul class="list-group">
            <#list users as user>
                <li class="list-group-item">
                    <a href="/posts/user-posts/${user.id}">${user.getUsername()}</a>
                </li>
                <#else>
                никого
            </#list>
        </ul>
    </div
</@c.page>