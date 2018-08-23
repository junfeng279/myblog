<template>
  <div>
    <div class="panel panel-default">
      <div class="panel-body">
        <div class="row">
          <div class="col-md-12">
            <h2 class="article-title">
              {{blog.title}}
            </h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 article-meta">
            <span>
              <span class="label label-success">原创</span>
            </span>
            <span class="tag-divide">
                <i class="fa fa-calendar"></i>&nbsp;&nbsp;
                <span>{{convertDate(blog.created)}}</span>
            </span>
            <span class="tag-divide">
               <i class="fa fa-user"></i>&nbsp;&nbsp;
               <span>{{user.username}}</span>
            </span>
            <span class="tag-divide">
               <i class="fa fa-folder"></i>&nbsp;&nbsp;
               <span><a href="#">{{blog.categories}}</a></span>
            </span>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 article-content">
            <mavon-editor :toolbarsFlag="false" :subfield="false" :defaultOpen="preview" :editable="false"  v-bind:value="blog.content"/>
          </div>
        </div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-body">
        <div class="row comment-header">
          <div class="col-md-2">
            {{comments.length}} 条评论
          </div>
          <div class="col-md-2 col-md-offset-8">
            未登录用户
          </div>
        </div>
        <div class="row">
          <div class="panel panel-default">
            <div class="panel-body">
              <div class="row">
                <div class="col-md-2">
                  <a class="header-logo-invertocat thumbnail no-border" href="https://github.com/" data-hotkey="g d" aria-label="Homepage" data-ga-click="Header, go to dashboard, icon:logo">
                    <img src="../../assets/image/photo.png" class="no-border"/>
                  </a>
                </div>
                <div class="col-md-10">
                  <div class="row">
                    <div class="col-md-6">
                      <input type="text" class="form-control" placeholder="请输入用户名" v-model="comment.author"/>
                    </div>
                    <div class="col-md-6">
                      <input type="text" class="form-control" placeholder="请输入用邮箱" v-model="comment.email"/>
                    </div>
                  </div>
                  <div class="row comment-content">
                    <div class="col-md-12">
                      <textarea class="form-control" rows="3" placeholder="说点什么吧" v-model="comment.content"></textarea>
                    </div>
                  </div>
                  <div style="margin-top: 10px;">
                    <input type="button" class="btn btn-success pull-right" value="保存" v-on:click="saveComment"/>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="panel panel-default">
            <div class="panel-body no-border" v-if="comments.length===0">
              <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-10">
                  暂时没有评论信息
                </div>
              </div>
            </div>
            <div class="panel-body" v-else>
              <div class="row comments-content" v-for="(comment, index) in comments">
                <div class="col-md-2">
                  <a class="header-logo-invertocat thumbnail no-border" href="https://github.com/" data-hotkey="g d" aria-label="Homepage" data-ga-click="Header, go to dashboard, icon:logo">
                    <img src="../../assets/image/photo.png" class="no-border" width="50" height="50"/>
                  </a>
                </div>
                <div class="col-md-10 comment-content-back">
                  <div>{{comment.author}}： 发表于 {{convertDate(comment.created)}}</div>
                  <div>
                    <span>{{comment.content}}</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    name: "articleView",
    data: function () {
      return {
        blog: {},
        user: {},
        comment: {
          cid: '',
          author: '',
          ownerId: '',
          mail: '',
          content: ''
        },
        comments: {}
      }
    },
    methods: {
      getBlogById: function (cid) {
        const _this = this;
        const url = '/blog/blog/content/' + cid;
        const param = {};
        this.$api.get(url, param, r => {
          _this.blog = r.data;
          console.log(_this.blog);
          _this.getUserById(_this.blog.authorId);
        }, res => {
          alert("文章查询失败!")
        })
      },
      getUserById: function (uid) {
        const _this = this;
        const url = '/user/user/'+uid;
        const param = {};
        this.$api.get(url, param, r => {
          _this.user = r.data;
        }, res => {
          alert("用户查询失败!")
        })
      },
      saveComment: function () {
        const _this = this;
        this.comment.cid = this.blog.cid;
        const url = '/blog/blog/comment';
        const param = this.comment;
        this.$api.post(url, param, r => {
          _this.user = r.data;
          _this.getComments(_this.blog.cid, 0, 20);
          alert("保存评论成功!")
        }, res => {
          alert("保存评论失败!")
        })
      },
      getComments: function (cid, start, limit) {
        const _this = this;
        const url = '/blog/blog/comment/content/'+cid;
        const param = {
          page: start,
          pageSize: limit
        };
        this.$api.get(url, param, r => {
          _this.comments = r.data.content;
        }, res => {
          alert("查询评论失败!")
        })
      },
      convertDate: function (date) {
        const timestamp4 = new Date(date);
        return timestamp4.toLocaleDateString().replace(/\//g, "-") + " " + timestamp4.toTimeString().substr(0, 8);
      }
    },
    created: function () {
      //alert(this.$route.query.cid);
      this.getBlogById(this.$route.query.cid);
      this.getComments(this.$route.query.cid, 0, 20);
    },
    computed: {

    }
  }
</script>
<style>
  .markdown-body{
    border: none;
  }
  .v-note-panel{
    box-shadow: 0 0px 0px rgba(0,0,0,0.157), 0 0px 0px rgba(0,0,0,0.227) !important;
  }
  .article-title {
    margin-left: 25px;
    font-size: 1.5em;
    color: #009688;
    text-decoration: none;
    line-height: 1.3em;
  }
  .article-meta{
    margin-left: 25px;
    margin-top: 10px;
    font-size: 16px;
  }
  .article-content{
    margin-top: 8px;
  }
  .tag-divide{
    margin-left: 20px;
  }
  .comment-header{
    margin: 20px;
    border-bottom:2px dashed #F00;
  }
  .comment-content{
    margin-top: 20px;
  }
  .comments-content{
    margin-top: 20px;
  }
  .comment-content-back{
    background-color: #f9f9f9;
    overflow: auto;
    padding-top: 20px;
    padding-bottom: 20px;
  }
  .no-border{
    border: 0px solid;
    background-color: transparent;
  }
</style>
