<template>
  <nav class="navbar navbar-default nav-color">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" v-on:click="toHome">
          <span class="glyphicon glyphicon-home"></span> Blog
        </a>
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
</style>
