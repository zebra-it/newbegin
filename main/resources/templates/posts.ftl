<#import "common/common.ftl" as c>
<#include "common/securityPage.ftl">

<@c.page>
    <div class="container-fluid gedf-wrapper">

    <div class="row">

        <div class="col-sm-3">
            <div class="card">
                <div class="card-body">
                    <div class="h5"><#if user??>@${user.username} <#else> Зеленый ананас</#if></div>
                    <div class="h7 text-muted"></div>
                    <div class="h7">Developer of web applications, JavaScript, PHP, Java, Python, Ruby, Java, Node.js,
                        etc.
                    </div>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <div class="h6 text-muted">Followers</div>
                        <div class="h5">5.2342</div>
                    </li>
                    <li class="list-group-item">
                        <div class="h6 text-muted">Following</div>
                        <div class="h5">6758</div>
                    </li>
                    <li class="list-group-item"><a href="/user/profile">Профиль</a></li>
                    <#if isAdmin>
                        <li class="list-group-item"><a href="/user" class="">Список пользователей</a></li>
                        <li class="list-group-item"><a href="/statistics" class="">Статистика</a></li>



                    </#if>
                </ul>
                <#include "common/search.ftl">
            </div>

        </div>


    <!--- \\\\\\\ Добавить Пост-->
    <div class="card gedf-card">
        <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="posts-tab" data-toggle="tab" href="#posts" role="tab"
                       aria-controls="posts" aria-selected="true">Добавить пост</a>
                </li>
            </ul>
        </div>

        <div class="card-body">
            <form method="post" action="/posts/newpost">
                <div class="tab-content" id="myTabContent">

                    <div class="tab-pane fade show active" id="posts" role="tabpanel" aria-labelledby="posts-tab">

                        <div class="form-group">
                            <label class="sr-only" for="message">post</label>
                            <textarea class="form-control ${(textError??)?string('is-invalid', '')}" name="text"
                                      id="message" rows="3" placeholder="Что думаете?"
                                      value="<#if post??>${post.text}</#if>"
                            ></textarea>
                            <#if textError??>
                                <div class="invalid-feedback">
                                    Ошибочка: ${textError}
                                </div>
                            </#if>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="tag">tag</label>
                            <input type="text" id="tag" class="form-control" name="tags" placeholder="Тэг"
                                   value="<#if post??>${post.tag}</#if>">

                        </div>

                    </div>

                </div>
                <div class="btn-toolbar justify-content-between">
                    <div class="btn-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-outline-dark">Отправить</button>
                    </div>
                </div>
            </form>
        </div>
        <#include "common/postList.ftl">

    </div>
    <!-- Post /////-->
    </div>

</@c.page>