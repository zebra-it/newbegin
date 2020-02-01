<#import "common/common.ftl" as c>

<@c.page>
    <div>

        <form method="post" action="/logout">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="Exit">
        </form>
    </div>
    <div>
        <form method="post" action="/posts/newpost">
            <input type="text" name="text" placeholder="Введите сообщение"
                   class=" ${(textError??)?string('is-invalid', '')}"
            value="<#if post??>${post.text}</#if>"/>
            <#if textError??>
                <div class="invalid-feedback">
                    Ошибочка: ${textError}
                </div>
            </#if>
            <input type="text" name="tags" placeholder="Тэг">

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Добавить</button>
        </form>
    </div>

<#include "common/search.ftl">
    <div>Список сообщений</div>
    <div class="container">
        <#if posts??>
            <#list posts as post>
                <div>
                    <a href="/posts/details/${post.id}">205041</a>
                    <span>text: ${post.text}</span>

                    <i>${post.createDate!''}</i>
                    <i>${post.createTime!''}</i>
                    </br>
                    <i>tags: ${post.tags!''}</i>

                    <strong>author: ${post.getAuthorName()}</strong>
                    <b><a href="/posts/delete/${post.id}">delete</a></b>
                </div>

            <#else>
                No message
            </#list>
        </#if>

    </div>


</@c.page>