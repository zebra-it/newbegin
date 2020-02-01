<#import "common/common.ftl" as c>
<#import "common/login.ftl" as l>
<@c.page>

    <#if message??>

    </#if>
    <@l.login "/login" true/>
</@c.page>