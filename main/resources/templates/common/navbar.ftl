<#import "login.ftl" as l>
<#include "securityPage.ftl" >
<nav class="navbar navbar-light bg-white">
    <a href="/" class="navbar-brand">InNutshell</a>
    <p class="navbar-text">
        ${name}
    </p>

    <div class="form-inline">
        <h5><a href="posts" class="">Посты</a></h5>
        <#if user??>
            <h5><a href="/user/profile">Профиль</a></h5>
        </#if>
        <#if isAdmin>
        <h5><a href="/user" class="">Список пользователей</a></h5>
            <h5><a href="/statistics" class="">Статистика</a></h5>
        </#if>

    </div>

</nav>