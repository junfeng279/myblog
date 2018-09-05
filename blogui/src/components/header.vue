<template>
  <nav class="navbar navbar-default nav-color div-shadow nav-height">
    <div class="navbar-header">
      <a class="navbar-brand pointerStyle " v-on:click="toHome">
        <img alt="Myblog" src="../assets/image/avatar.jpg" class="logo">
        <span class="logo-text">Myblog</span>
      </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="navbar-nav-item">
          <a v-on:click="toHome" class="pointerStyle">知识星球</a>
        </li>
        <li class="navbar-nav-item">
          <a v-on:click="toHome" class="pointerStyle">推荐书单</a>
        </li>
        <li class="navbar-nav-item">
          <a v-on:click="toHome" class="pointerStyle">开源书籍</a>
        </li>
        <li class="navbar-nav-item">
          <a v-on:click="toHome" class="pointerStyle">装备库</a>
        </li>
        <li class="navbar-nav-item">
          <a v-on:click="toHome" class="pointerStyle">归档</a>
        </li>
        <li class="navbar-nav-item">
          <a v-on:click="toHome" class="pointerStyle">关于</a>
        </li>
      </ul>
    </div>
  </nav>
</template>
<script>
  export  default {
    methods: {
      toHome: function () {
        this.$router.push({ name: 'Articles'})
      }
    }
  }
</script>
<style>
  .nav-color{
    background: #ffffff;
  }
  .navbar-brand{
    cursor: pointer;
  }
  .pointerStyle{
    cursor: pointer;
  }
  .div-shadow{
    box-shadow: 2px 2px 1px #888888;
  }
  .logo{
    background-image: url("../assets/image/avatar.jpg");
    border-radius: 50%;
    width: 40px;
    height: 40px;
    background-repeat: no-repeat;
    -webkit-background-size: 40px 40px;
    -moz-background-size: 40px 40px;
    background-size: 40px 40px;
    float: left;
  }
  .nav-height{
    height: 70px;
  }
  .header-text{
    float: left;
  }
  .navbar-header{
    height: 70px;
    margin-left: 50px;
  }
  .navbar-brand{
    height: 70px;
    width: 150px;
    line-height: 41px;
  }
  .navbar-brand:hover{
    color: #2e6da4 !important;
  }
  .logo-text{
    margin-left: 20px;
    font-size: 16px;
    display: inline-block;
    vertical-align: top;
    font-weight: 600;
  }
  .navbar-nav{
    height: 70px;
  }
  .navbar-nav-item{
    height: 70px;
    line-height: 70px !important;
  }
  .navbar-nav-item > a{
    height: 70px;
    line-height: 41px !important;
    font-size: 16px;
    display: inline-block;
    vertical-align: top;
    margin-left: 15px;
  }
</style>
