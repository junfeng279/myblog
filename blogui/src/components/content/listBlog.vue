<template>
  <div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4>查看文章</h4>
      </div>
      <table class="table table-striped table-hover">
        <thead class="t_head">
        <tr>
          <th>#</th>
          <th>标题</th>
          <th>分类</th>
          <th>状态</th>
          <th>浏览量</th>
        </tr>
        </thead>
        <tbody class="t-body">
        <tr v-for="(item, index) in blogs">
          <td>{{index}}</td>
          <td>{{item.title}}</td>
          <td>{{item.categories}}</td>
          <td>{{item.status}}</td>
          <td>{{item.hit}}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'listBlog',
    data: function () {
      return {
          blogs: {}
      }
    },
    methods: {
      getAll: function () {
        const _this = this;
        const url = '/blog/blog/content';
        const param = {
          page: 0,
          pageSize: 20
        };
        this.$api.get(url, param, r => {
          _this.blogs = r.data.content;
          console.log(_this.blogs);
        }, res => {
          alert("文章查询失败!")
        })
      }
    },
    created: function () {
      this.getAll();
    }
  }
</script>
<style>
  .t-body{
    text-align: left;
  }
</style>
