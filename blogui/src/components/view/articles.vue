<template>
  <div class="b-view">
    <div class="panel panel-default div-shadow" v-for="(item, index) in blogs">
      <div class="panel-body">
        <div class="row">
          <div class="col-md-12">
            <header class="article-heading">
              <h2>
                <a v-on:click="blogDetail(item.cid)">{{item.title}}</a>
              </h2>
            </header>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <span>
              <span class="label label-success" v-if="item.allowFeed">原创</span>
              <span class="label label-warning" v-else>转发</span>
              &nbsp;&nbsp;
            </span>
            <span>
                <i class="fa fa-calendar"></i>&nbsp;
                <span>{{convertDate(item.created)}}</span>&nbsp;&nbsp;
            </span>
            <span>
               <i class="fa fa-user"></i>&nbsp;
               <span>{{item.authorId}}</span>&nbsp;&nbsp;
            </span>
            <span>
               <i class="fa fa-folder"></i>&nbsp;
               <span><a href="#">{{item.categories}}</a></span>
            </span>
          </div>
        </div>
        <div class="row article-content">
          <div class="col-md-12">
            {{substringMessage(0, item.content)}}
          </div>
        </div>
      </div>
      <div class="panel-footer">
        <span class="fa fa-tag"></span>
        <span class="article-tags" v-for="(tag, index) in tags(item.tags)">
          <span v-if="index != 0">,</span>
          {{tag}}
        </span>
      </div>
    </div>
    <div>
      <Page :page="page" v-on:searchData="searchPageBlog"></Page>
    </div>
  </div>
</template>
<script>
  import Page from '../common/page';
  export default {
    name: 'blogView',
    data: function () {
      return {
        blogs: {},
        page: {
          currentPage: 0,
          totalPage: 0
        }
      }
    },
    methods: {
      searchBlogs: function (start, limit) {
        const _this = this;
        const url = '/blog/blog/content';
        const param = {
          page: start,
          pageSize: limit
        };
        this.$api.get(url, param, r => {
          _this.blogs = r.data.content;
          _this.page.currentPage = r.data.pageable.pageNumber + 1;
          _this.page.totalPage = r.data.totalPages;
          console.log(_this.blogs);
        }, res => {
          alert("文章查询失败!")
        })
      },
      substringMessage: function (num, message) {
        return message.substring(0, 230) + '....';
      },
      blogDetail: function (cid) {
        this.$router.push({ name: 'ArticleView', query: { cid: cid }})
      },
      tags: function (strTag) {
        return strTag.split(",");
      },
      convertDate: function (date) {
        const timestamp4 = new Date(date);
        return timestamp4.toLocaleDateString().replace(/\//g, "-") + " " + timestamp4.toTimeString().substr(0, 8);
      },
      searchPageBlog: function(currentPage){
        const start = (currentPage - 1) * 20;
        const limit = 20;
        this.searchBlogs(start, limit);
      }
    },
    components: {
      Page
    },
    created: function () {
      this.searchBlogs(0, 20);
    }
  }
</script>
<style>
  .b-view{
    text-align: left;
  }
  .b-calendar{
    width: 20px;
    height: 20px;
  }
  .article-content{
    margin-top: 30px;
  }
  .panel-footer{
    background-color: #ffffff !important;
  }
  .article-tags{
    margin-left: 5px;
  }
  .div-shadow{

    -webkit-border-radius: 0px;

    -moz-border-radius: 0px;

    border-radius: 0px;

    -webkit-box-shadow: #bbbbbb 0px 0px 5px;

    -moz-box-shadow: #bbbbbb 0px 0px 5px;

    box-shadow: #bbbbbb 0px 0px 5px;
  }
</style>
