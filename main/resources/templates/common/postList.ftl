<!--- \\\\\\\Post-->
<#include "securityPage.ftl">
<div class="card mb-3" style="max-width: 700px;">

    <#list posts as post>
        <div class="row no-gutters">
            <div class="col-md-4">
                <#if post.filename??>
                    <img class="rounded mx-auto" src="\img\${post.filename}" style="width: 70%;">
                <#else>
                </#if>
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h6 class="card-title">

                    </h6>
                    <p class="card-text">    ${post.text}</p>
                    <p class="card-text">

                        <small class="text-muted">
                            ${post.createDate!''}
                            ${post.createTime!''}
                        </small>
                        <#if user??>
                            <a href="/posts/user-posts/${post.author.id}">${post.authorName}</a>
                        <#else>${post.authorName}
                        </#if>
                        <#if post.author.id = currentUserId>
                            <a class="btn btn-light btn-sm" href="/posts/delete/${post.id}">delete</a>
                        </#if>
                    </p>
                    <div class="card-footer bg-transparent">
                        <#if post.tags != ''>
                        <form action="/posts/search/${post.tags!''}" method="get">
                            <div class="input-group">
                                <div class="input-group-prepend">

                                    <button class="btn btn-outline-dark input-group-text" type="submit"
                                            id="button-addon2">

                                        # ${post.tags!''}

                                    </button>
                                </div>
                                <input type="hidden" class="form-control" name="tag" value="${post.tags}">
                            </div>
                        </form>
                        </#if>

                    </div>
                </div>
            </div>
        </div>
    <#else>
        Пусто :)
    </#list>
</div>

<!-- Post /////-->


