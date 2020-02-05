<!--- \\\\\\\Post-->
<#include "securityPage.ftl">
<div class="card gedf-card">
    <#list posts as post>
    <div class="card-header">
        <div class="d-flex justify-content-between align-items-center">
            <div class="d-flex justify-content-between align-items-center">
                <div class="mr-2">
                    <img class="rounded-circle" width="45" src="https://picsum.photos/50/50" alt="">
                </div>
                <div class="ml-2">
                    <div class="h5 m-0">                <#if user??>
                            <a href="/posts/user-posts/${post.author.id}">${post.authorName}</a>
                        <#else>${post.authorName}
                        </#if></div>
                    <div class="h7 text-muted">${post.createDate!''}  ${post.createTime!''}</div>
                    <#if post.author.id = currentUserId>
                    <b><a href="/posts/delete/${post.id}">delete</a></b>
                    </#if>
                </div>
            </div>

        </div>

    </div>
    <div class="card-body">
        <p class="card-text">
            ${post.text}
            <#if post.filename??>
                <img src="\img\${post.filename}"style="width: 20%;">
            </#if>

        </p>
    </div>

        <div class="card-footer">
            <form action="/posts/search/" method="get">
                <div class="input-group">
                    <div class="input-group-prepend">

                        <button class="btn btn-outline-dark input-group-text" type="submit" id="button-addon2">
                            # ${post.tags!''}
                        </button>
                    </div>
                    <input type="hidden" class="form-control" name="text" value="${post.tags}">

                </div>
            </form>
        </div>
        <#else>
            Пусто :)
        </#list>
    </div>


    <!-- Post /////-->


