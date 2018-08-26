<template>
  <nav class="navbar navbar-default nav-color">
    <div class="container">
      <div class="navbar-header">
        <a class="navbar-brand pointerStyle " v-on:click="toHome">
          <span class="glyphicon glyphicon-home"></span> Blog
        </a>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li>
            <a v-on:click="toHome" class="pointerStyle">文章列表</a>
          </li>
        </ul>
      </div>
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
</style>
