<#macro login path isReg>
    <main class="login-form">
        <div class="cotainer">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header"><#if isReg> Регистрация<#else>Вход</#if></div>
                        <div class="card-body">
                            <form action="<#if !isReg>/login<#else>/reg</#if>" method="post">

                                <div class="form-group row">
                                    <label for="username" class="col-md-4 col-form-label text-md-right">Логин</label>

                                    <div class="col-md-6">
                                        <input type="text" id="username"
                                               class="form-control"
                                               name="username"
                                               required>
                                    </div>

                                </div>
                                <div class="form-group row">
                                    <label for="password" class="col-md-4 col-form-label text-md-right">Пароль</label>
                                    <div class="col-md-6">
                                        <input type="password" id="password" class="form-control" name="password"
                                               required>
                                    </div>
                                </div>
                                <!-- REGISTRATION FORM -->
                                <#if isReg>
                                    <!--             <div class="form-group row">
                                                     <label for="password2" class="col-md-4 col-form-label text-md-right">Пароль еще
                                                         раз</label>
                                                     <div class="col-md-6">
                                                         <input type="password" id="password2" class="form-control" name="password2"
                                                                required>
                                                     </div>
                                                 </div>
                                                 -->
                                    <div class="form-group row">
                                        <label for="email_address"
                                               class="col-md-4 col-form-label text-md-right">Почта</label>
                                        <div class="col-md-6">
                                            <input type="text" id="email_address" class="form-control" name="email"
                                                   required autofocus>
                                        </div>
                                    </div>

                                </#if>

                                <div class="form-group row">
                                    <div class="col-md-6 offset-md-4">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" name="remember"> Remember Me
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-6 offset-md-4">
                                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                    <button type="submit"
                                            class="btn btn-outline-dark align-top"><#if isReg>Создать<#else>Войти</#if></button>
                                    <a href="#" class="btn btn-link">
                                        Забыли пароль?
                                    </a>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </main>
</#macro>

<#macro logout>

    <div class="form-group col-md-3">
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-outline-dark align-top" type="submit"><#if user??>Выйти<#else>Войти</#if></button>

        </form>
    </div>

</#macro>