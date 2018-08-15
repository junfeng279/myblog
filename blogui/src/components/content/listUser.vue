<template>
  <div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4>查看用户</h4>
      </div>
      <table class="table table-striped table-hover">
        <thead class="t_head">
          <tr>
            <th>#</th>
            <th>用户名</th>
            <th>用户地址</th>
            <th>邮件</th>
            <th>组名称</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in users">
            <td>{{index}}</td>
            <td>{{item.username}}</td>
            <td>{{item.homeUrl}}</td>
            <td>{{item.email}}</td>
            <td>{{item.groupName}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'listUser',
    data: function () {
      return {
        users: {}
      }
    },
    methods: {
      getAll: function () {
        const _this = this;
        const url = '/user/user';
        const param = {
          page: 0,
          pageSize: 20
        };
        this.$api.get(url, param, r => {
          _this.users = r.data.content;
          console.log(_this.users);
        }, res => {
          alert("用户查询失败!")
        })
      }
    },
    created: function () {
      this.getAll();
    }
  }
</script>
<style>

</style>
