

<!--- \\\\\\\Post-->
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
                                <a href="/user-posts/${post.author.id}">${post.authorName}</a>
                            <#else>${post.authorName}
                            </#if></div>
                        <div class="h7 text-muted">${post.createDate!''}  ${post.createTime!''}</div>
                        <b><a href="/posts/delete/${post.id}">delete</a></b>
                    </div>
                </div>
                <div>
                    <div class="dropdown">
                        <button class="btn btn-link dropdown-toggle" type="button" id="gedf-drop1"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-ellipsis-h"></i>
                        </button>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
                            <div class="h6 dropdown-header">Configuration</div>
                            <a class="dropdown-item" href="#">Save</a>
                            <a class="dropdown-item" href="#">Hide</a>
                            <a class="dropdown-item" href="#">Report</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="card-body">
            <p class="card-text">
                ${post.text}
            </p>
            <div class=" h7 mb-2">${post.tags!''}</div>
        </div>
        <div class="card-footer">
            <a href="#" class="card-link"><i class="fa fa-gittip"></i> Like</a>
            <a href="#" class="card-link"><i class="fa fa-comment"></i> Comment</a>
            <a href="#" class="card-link"><i class="fa fa-mail-forward"></i> Share</a>
        </div>
    <#else>
        Пусто :)
    </#list>
</div>

<!-- Post /////-->


