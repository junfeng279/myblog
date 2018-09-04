<template>
  <div class="container">
    <Header></Header>
    <div class="row b-content">
      <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default">
          <div class="panel-heading">
            用户注册
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
                <label for="password" class="col-md-2 control-label">组：</label>
                <div class="col-md-10">
                  <input type="text" class="form-control" id="groupName" placeholder="所属组" v-model="user.groupName"/>
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-11 col-md-offset-1">
                  <button type="submit" class="btn btn-success" v-on:click="submit">注册</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <Footer></Footer>
  </div>
</template>
<script>
  import Header from './header'
  import Footer from './footer'
  export default {
    name: "Register",
    data: function () {
      return {
        user: {
          username: '',
          password: '',
          groupName: ''
        }
      }
    },
    methods: {
      submit: function () {
        if (this.user.username === ''){
          alert("用户名不能为空!");
          return;
        }
        if (this.user.password === ''){
          alert("密码不能为空!");
          return;
        }
        const _this = this;
        const url = '/auth/register';
        const param = this.user;
        this.$api.post(url, param, r => {
          alert("用户注册成功!");
          _this.$router.push({ name: 'Login'});
        }, res => {
          alert("用户登录失败!");
        })
      }
    },
    components:{
      Header,
      Footer
    }
  }
</script>
<style>
  .b-content{
    min-height: 350px;
    margin-top: 10%;
  }
</style>
