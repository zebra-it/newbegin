<#import "login.ftl" as l>
<#include "securityPage.ftl" >

<nav class="navbar navbar-light bg-white">

    <div class="bd-highlight">

        <#if user??><i class="fas fa-circle"></i><#else><i class="far fa-circle"></i></#if>
        <#if user??><span class="navbar-brand">${name}</span><#else>Гость</#if>
        <#if user??><@l.logout/></#if>
    </div>

    <div class="bd-highlight">
        <a href="/" class="navbar-brand">InNutshell</a>
    </div>
    <#if user??>
        <form class="form-inline">
            <div class="input-group">

            </div>
        </form>
    </#if>
</nav>