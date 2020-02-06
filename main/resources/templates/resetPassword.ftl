<#import "common/common.ftl" as c>

<@c.page false>

    ${message?if_exists}
    <form method="post" action="/resetPassword">
        <div class="row ">
            <div class="col">
                <label for="usrnm">Логин:</label>
                <input class="form-control ${(usernameError??)?string('is-invalid', '')}"
                       type="text" id="usrnm"
                       name="username"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <label for="psw">Пароль:</label>
                <input class="form-control ${(passwordError??)?string('is-invalid', '')}"
                       type="password"
                       name="password" id="psw"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="mt-3">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-outline-dark" type="submit">Обновить пароль</button>
        </div>
    </form>
</@c.page>