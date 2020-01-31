<#import "common/common.ftl" as c>
<#import "common/login.ftl" as l>
<@c.page>

    <#if message??>
        <span>${message}</span>
    </#if>
    <@l.login "/login" true/>
</@c.page>