<#import "common/common.ftl" as c>
<#include "common/securityPage.ftl" >
<@c.page>


    <div class="container-fluid gedf-wrapper">
        <div class="row ">
            <div class="col-sm-3">
                <div class="card">
                    <div class="card-body">
                        <div class="h5">
                            <#if user??>@${userChannel.username}
                                <#if isCurrentUser>
                                    <a href="/user/profile/update"><i class="fas fa-pen ml-3"></i></a>
                                </#if><#else> Зеленый ананас</#if>
                        </div>
                        <div class="h7 text-muted"></div>
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
                            <div class="h5"><a href="user/followers/${userChannel.id}/list">${followersCount!''}</a>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="h6 text-muted">
                                Читаемые</a>
                            </div>
                            <div class="h5"><a href="user/following/${userChannel.id}/list">${followingCount!''}</a>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <#if !isCurrentUser>
                                <#if isFollower>
                                    <a  class="btn btn-info" href="/user/unsubscribe/${userChannel.id}">Отписаться</a>

                                <#else>
                                    <a  class="btn btn-info" href="/user/subscribe/${userChannel.id}">Подписаться</a>
                                </#if>
                            </#if></li>
                    </ul>

                </div>

            </div>
            <#include "common/postList.ftl">
        </div>
    </div>

</@c.page>