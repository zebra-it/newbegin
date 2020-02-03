<#import "common/common.ftl" as c>
<#import "common/login.ftl" as l>
<@c.page>

${message?if_exists}
    <@l.login "/reg" true/>
</@c.page>