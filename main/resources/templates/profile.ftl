<#import "common/common.ftl" as c>
<#include "common/securityPage.ftl" >
<@c.page>
   <#if isCurrentUser>
   <a href="/user/profile/update">Редактировать</a>
   </#if>
   <#include "common/postList.ftl">

</@c.page>