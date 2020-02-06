<#import "common/common.ftl" as c>


<@c.page true>
    <div class="container-fluid gedf-wrapper">
        <div class="row">

            <div class="col-md-3">
                <div class="card">
                    <div class="card-body">
                        <div class="h7 text-muted">
                            <div class="row ml-3">
                                <h3>${userChannel.username}</h3>
                                <#if isCurrentUser>
                                    <a href="/user/profile/update"><i class="fas fa-pen ml-3"></i></a>
                                </#if>
                            </div>
                        </div>
                        <div class="h7">Developer of web applications, JavaScript, PHP, Java, Python, Ruby, Java,
                            Node.js,
                            etc.
                        </div>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="h6 text-muted">
                                Читатели
                            </div>
                            <div class="h5"><a href="/user/followers/${userChannel.id}/list">${subscribersCount}</a></div>
                        </li>
                        <li class="list-group-item">
                            <div class="h6 text-muted">
                                Читаемые
                            </div>
                            <div class="h5"><a href="/user/following/${userChannel.id}/list">${subscriptionsCount}</a>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <#if !isCurrentUser>
                                <#if isSubscriber>
                                    <a class="btn btn-info" href="/user/unsubscribe/${userChannel.id}">Отписаться</a>
                                <#else>
                                    <a class="btn btn-info" href="/user/subscribe/${userChannel.id}">Подписаться</a>
                                </#if>
                            </#if></li>
                    </ul>
                </div>
            </div>


            <div class="col-8 ">
                <#include "common/postList.ftl" />
            </div>
        </div>
    </div>
    </div>
</@c.page>