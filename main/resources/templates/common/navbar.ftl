<#import "login.ftl" as l>
<#include "securityPage.ftl" >
<nav class="navbar navbar-light bg-white">

    <div class="d-flex flex-row bd-highlight mb-3">
        <div class="p-2 bd-highlight">
            <@l.logout/>

        </div>
        <div class="p-2 bd-highlight">
            <a href="/" class="">InNutshell</a>
            <#if user??><i class="fas fa-circle"></i><#else><i class="far fa-circle"></i></#if>
            <#if user??>${name}<#else>Гость</#if>
        </div>
    </div>


    <div class="d-flex flex-row bd-highlight mb-3">

        <div class="d-flex flex-row bd-highlight mb-3">
            <div class="form-inline">
                <div class="p-2 bd-highlight">

                    <a href="/posts" class="">Посты</a>
                </div>
                <div class="p-2 bd-highlight">
                    <#if user??>
                        <a href="/user/profile">Профиль</a>
                    </#if>
                </div>
                <div class="p-2 bd-highlight">
                    <#if isAdmin>
                        <a href="/user" class="">Список пользователей</a>
                        <a href="/statistics" class="">Статистика</a>
                    </#if>
                </div>
            </div>
        </div>

</nav>