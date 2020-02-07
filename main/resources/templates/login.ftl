<#import "common/common.ftl" as c>
<#import "common/login.ftl" as l>
<@c.page false>


    <@l.login "/login" false/>
    <p class="mt-3"> ${message?if_exists}</p>
</@c.page>