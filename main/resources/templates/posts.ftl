<#import "common/common.ftl" as c>
<#include "common/securityPage.ftl">

<@c.page true>
    <div class="container-fluid gedf-wrapper">

        <div class="row">

            <div class="col-3">

                <div class="card">
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
                                        <label class="sr-only" for="message"></label>
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
                                        <input type="text" id="tag" class="form-control" name="tags"
                                               placeholder="Тэг"
                                               value="<#if post??>${post.tags!''}</#if>">
                                    </div>

                                    <div class="input-group mb-3">
                                        <div class="custom-file">
                                            <input type="file" class="custom-file-input" id="inputGroupFile01"
                                                   name="file" aria-describedby="inputGroupFileAddon01">
                                            <label class="custom-file-label" for="inputGroupFile01">
                                            </label>
                                        </div>
                                    </div>
                                </div>


                            </div>
                            <div class="btn-toolbar justify-content-between">
                                <div class="btn-group">
                                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                    <button type="submit" class="btn btn-outline-primary">Отправить</button>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
            </div>

            <!--- \\\\\\\ Добавить Пост-->


            <div class="col">
                <#include "common/postList.ftl">
            </div>


            <!-- Post /////-->
            <div class="col-sm-3 gedf-main">
                <#include "common/search.ftl">

                <h5>Список тегов</h5>

                <#if tags??>
                    <#list tags as tag>
                        <a class="btn btn-secondary btn-sm m-1" href="/posts/search/${tag!''}">#${tag!''}</a>
                    </#list>
                </#if>

            </div>
        </div>
    </div>



    <!-- Что то в третью колонку сюда-->


</@c.page>