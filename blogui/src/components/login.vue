<template>
  <div>
    <div class="row">
      <div class="col-md-offset-3 col-md-6">
        <div class="panel panel-primary login-form">
          <div class="panel-heading">欢迎登陆</div>
          <div class="panel-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label for="username" class="col-md-2 control-label">用户名：</label>
                <div class="col-md-10">
                  <input type="text" class="form-control" id="username" placeholder="请输入用户名"/>
                </div>
              </div>
              <div class="form-group">
                <label for="password" class="col-md-2 control-label">密码：</label>
                <div class="col-md-10">
                  <input type="text" class="form-control" id="password" placeholder="请输入用密码"/>
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-11 col-md-offset-1">
                  <div class="checkbox">
                    <label>
                      <input type="checkbox"/> 记住密码
                    </label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-11 col-md-offset-1">
                  <button type="submit" class="btn btn-success">登陆</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

</script>
<style>
  .login-form{
    margin-top: 20%;
  }
</style>
