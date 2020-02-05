<#import "common/common.ftl" as c>
<#include "common/securityPage.ftl">

<@c.page>
    <div class="container-fluid gedf-wrapper">

    <div class="row ">

        <div class="col-sm-3">
            <div class="card">
                <div class="card-body">


                    <#include "common/search.ftl">
                </div>
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
                        <form method="post" action="/posts/newpost" enctype="multipart/form-data">
                            <div class="tab-content" id="myTabContent">

                                <div class="tab-pane fade show active" id="posts" role="tabpanel"
                                     aria-labelledby="posts-tab">

                                    <div class="form-group">
                                        <label class="sr-only" for="message">post</label>
                                        <textarea class="form-control ${(textError??)?string('is-invalid', '')}"
                                                  name="text"
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
                                    <div class="form-group">
                                        <label class="sr-only" for="tag">tag</label>
                                        <input type="file" id="tag" class="form-control" name="file" placeholder="file">
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
                </div>
            </div>
        </div>

        <!--- \\\\\\\ Добавить Пост-->
        <div class="col-sm-5">

            <#include "common/postList.ftl">
        </div>
        <!-- Post /////-->

        <div class="col-sm-2">


            <h3>Популярные теги</h3>


            <#if topTags??>
                <#list topTags as tag>
                    <div class="btn btn-secondary btn-sm">
                   # ${tag}
                    </div>


                </#list>
            </#if>

        </div>
        <!-- Что то в третью колонку сюда-->
    </div>

</@c.page>