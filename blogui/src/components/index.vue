<template>
  <div>
    <Header></Header>
    <div class="container b-container">
      <div class="col-md-2">
        <leftnav></leftnav>
      </div>
      <div class="col-md-10">
        <router-view/>
      </div>
    </div>
    <Footer></Footer>
  </div>
</template>
<script>
  import Header from './header'
  import Content from './content'
  import Leftnav from './leftnav'
  import Footer from './footer'
  export default {
    components:{
      Header,
      Content,
      Leftnav,
      Footer
    }
  }
</script>
<style>
  .b-container{
    margin-top: 10px;
  }
</style>
