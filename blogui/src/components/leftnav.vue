<template>
  <div class="row">
    <div class="col-md-12">
      <ul class="nav nav-pills nav-stacked">
        <li role="presentation" v-bind:class="{active: selected == 'AddUser'}"><a v-on:click="choose('AddUser')">添加用户</a></li>
        <li role="presentation" v-bind:class="{active: selected == 'ListBlog'}"><a v-on:click="choose('ListBlog')">查看文章</a></li>
        <li role="presentation" v-bind:class="{active: selected == 'AddBlog'}"><a v-on:click="choose('AddBlog')">添加文章</a></li>
        <li role="presentation" v-bind:class="{active: selected == 'ListUser'}"><a v-on:click="choose('ListUser')">查看用户</a></li>
      </ul>
    </div>
  </div>
</template>
<script>
  export default {
    data: function () {
      return {
        selected: 'AddUser'
      }
    },
    methods: {
      choose: function (flag) {
        this.selected = flag;
        this.$router.push({ name: flag });
      }
    },
    created: function(){
      this.selected = this.$route.query.selected;
    }
  }
</script>
<style>
</style>
