<template>
  <div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4>添加用户</h4>
       </div>
      <div class="panel-body">
        <form class="form-horizontal">
          <div class="form-group">
            <label for="username" class="col-md-2 control-label">用户名：</label>
            <div class="col-md-10">
              <input type="text" class="form-control" id="username" placeholder="请输入用户名" v-model="user.username"/>
            </div>
          </div>
          <div class="form-group">
            <label for="password" class="col-md-2 control-label">密码：</label>
            <div class="col-md-10">
              <input type="text" class="form-control" id="password" placeholder="请输入用密码" v-model="user.password"/>
            </div>
          </div>
          <div class="form-group">
            <label for="email" class="col-md-2 control-label">邮件：</label>
            <div class="col-md-10">
              <input type="text" class="form-control" id="email" placeholder="请输入邮件" v-model="user.email"/>
            </div>
          </div>
          <div class="form-group">
            <label for="homeUrl" class="col-md-2 control-label">地址：</label>
            <div class="col-md-10">
              <input type="text" class="form-control" id="homeUrl" placeholder="请输入地址" v-model="user.homeUrl"/>
            </div>
          </div>
          <div class="form-group">
            <label for="groupName" class="col-md-2 control-label">组名称：</label>
            <div class="col-md-10">
              <input type="text" class="form-control" id="groupName" placeholder="请输入组名称" v-model="user.groupName"/>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-11 col-md-offset-1">
              <button type="submit" class="btn btn-success" v-on:click="save">保存</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    name: "addUser",
    data: function () {
      return {
        user: {
          username: '',
          password: '',
          email: '',
          homeUrl: '',
          groupName: ''
        }
      }
    },
    methods: {
      save: function () {
        const _this = this;
        const url = '/user/user';
        const param = this.user;
        this.$api.post(url, param, r => {
          console.log(r)
        }, res => {
          console.log(res)
        } )
      }
    }
  }
</script>
<style>

</style>
