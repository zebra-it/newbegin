<#import "common/common.ftl" as c>

<@c.page>
    <div class=" container-sm ml-5 m-3 p-3 " style="max-width: 400px;">
        <h5>${username}</h5>
        ${message?if_exists}
        <form method="post">
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
            <div class="row">
                <div class="col">
                    <label for="psw2">Пароль еще раз:</label>
                    <input type="password" name="password2"
                           class="form-control ${(password2Error??)?string('is-invalid', '')}"
                           id="psw2"/>
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label for="eml">Почта:</label>
                    <input type="email" id="eml" name="email"
                           value="${email!''}"
                           class="form-control ${(emailError??)?string('is-invalid', '')}"
                    />
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="mt-3">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button class="btn btn-primary" type="submit">Сохранить</button>

        </form>
    </div>


</@c.page>