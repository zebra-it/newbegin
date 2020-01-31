<#import "common/common.ftl" as c>

<@c.page>

<div class="container">
    <#if post??>
        <div>
            <span>${post.text}</span>

            <i>${post.createDate}</i>
            <i>${post.createTime}</i>
        </div>
    </#if>
</div>

</@c.page>