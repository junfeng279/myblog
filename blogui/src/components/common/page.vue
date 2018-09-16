<template>
  <nav aria-label="Page navigation">
    <ul class="pagination pagination-lg pageClass">
      <li class="previous disabled" v-if="page.currentPage===1"><a href="javascript:void(0)"><span aria-hidden="true">&larr;</span> Older</a></li>
      <li class="previous" v-else><a href="javascript:void(0)" v-on:click="clickPage(page.currentPage - 1)"><span aria-hidden="true">&larr;</span> Older</a></li>
      <template v-if="page.totalPage <= 10">
        <template v-for="item in page.totalPage">
          <li v-bind:class="{active:(item === page.currentPage)}">
            <a href="javascript:void(0)" v-on:click="clickPage(item)">{{item}}</a>
          </li>
        </template>
      </template>
      <template v-else>
        <template v-if="page.currentPage <= 4">
          <template v-for="item in (page.currentPage+2)">
            <li v-bind:class="{active:(item === page.currentPage)}">
              <a href="javascript:void(0)" v-on:click="clickPage(item)">{{item}}</a>
            </li>
          </template>
          <li class="disabled"><a href="#">...</a></li>
          <li><a href="javascript:void(0)" v-on:click="clickPage(page.totalPage)">{{page.totalPage}}</a></li>
        </template>
        <template v-else-if="page.currentPage < (page.totalPage-3)">
          <li><a href="javascript:void(0)" v-on:click="clickPage(1)">1</a></li>
          <li class="disabled"><a href="javascript:void(0)">...</a></li>
          <template v-for="item in 5">
            <li v-bind:class="{active:((item + page.currentPage -3) === page.currentPage)}">
              <a href="javascript:void(0)" v-on:click="clickPage(item + page.currentPage -3)">{{item + page.currentPage -3}}</a>
            </li>
          </template>
          <li class="disabled"><a href="javascript:void(0)">...</a></li>
          <li><a href="javascript:void(0)" v-on:click="clickPage(page.totalPage)">{{page.totalPage}}</a></li>
        </template>
        <template v-else-if="page.currentPage >= (page.totalPage-3)">
          <li><a href="javascript:void(0)" v-on:click="clickPage(1)">1</a></li>
          <li class="disabled"><a href="javascript:void(0)">...</a></li>
          <template v-for="item in (page.totalPage-page.currentPage+3)">
            <li v-bind:class="{active:((item + page.currentPage -3) === page.currentPage)}">
              <a href="javascript:void(0)" v-on:click="clickPage(item + page.currentPage - 3)">{{item + page.currentPage - 3}}</a>
            </li>
          </template>
        </template>
      </template>
      <li class="next disabled" v-if="page.currentPage===page.totalPage"><a href="javascript:void(0)">Newer <span aria-hidden="true">&rarr;</span></a></li>
      <li class="next" v-else><a href="javascript:void(0)" v-on:click="clickPage(page.currentPage + 1)">Newer <span aria-hidden="true">&rarr;</span></a></li>
    </ul>
  </nav>
</template>
<script>
  export default {
    props:{
      page: {
      }
    },
    methods: {
      clickPage: function (currentPage) {
        this.$emit('searchData', currentPage);
      }
    }
  }
</script>
<style>
  .pageClass{
    margin-left: 19%;
  }
</style>
