<template>
  <div>
    <Header></Header>
    <div class="container b-container">
      <div class="col-md-2">
        <LeftView></LeftView>
      </div>
      <div class="col-md-8">
        <router-view/>
      </div>
      <div class="col-md-2">
        <RightView></RightView>
      </div>
    </div>
    <Footer></Footer>
  </div>
</template>
<script>
  import Header from './header'
  import Footer from './footer'
  import LeftView from './view/left'
  import RightView from './view/right'

  export default {
    name: 'viewInfo',
    components:{
      Header,
      Footer,
      LeftView,
      RightView
    }
  }
</script>
<style>
  .b-container{
    width: 98% !important;
    margin-top: 10px;
  }
</style>
