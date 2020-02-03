<#import "login.ftl" as l>
<#include "securityPage.ftl" >

<nav class="navbar navbar-light">
    <div class="bd-highlight">
        <a href="<#if user??>/posts<#else>/</#if>" class="navbar-brand">InNutshell</a>
    </div>


       <span class="navbar-brand"> <#if user??><i class="fas fa-circle"></i><#else><i class="far fa-circle"></i></#if>
        <#if user??>${name}<#else>Гость</#if>
        <#if user??><@l.logout/></#if></span>





</nav>