<#import "common/common.ftl" as c>

<@c.page>

    ${message?if_exists}

    <form method="post" action="/forgotPassword">
     <div class="row">
                    <div class="col">
                        <label for="eml">Почта:</label>
                        <input type="email" id="eml" name="email"
                               value="<#if user??>${user.email}</#if>"
                               class="form-control ${(emailError??)?string('is-invalid', '')}"
                               placeholder="some@some.com"/>
                        <#if emailError??>
                            <div class="invalid-feedback">
                                ${emailError}
                            </div>
                        </#if>
                    </div>
                </div>

            <div class="mt-3">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button class="btn btn-outline-dark" type="submit">Отправить код на почту</button>
            </div>
        </form>
</@c.page>