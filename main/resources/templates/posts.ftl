<#import "common/common.ftl" as c>

<@c.page>

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
<#include "common/postList.ftl">



</@c.page>