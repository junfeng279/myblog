<template>
  <div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <div class="row">
          <div class="col-md-11">
            <h4>添加文章</h4>
          </div>
          <div class="col-md-1">
            <button type="submit" class="btn btn-success" v-on:click="save">保存</button>
          </div>
        </div>
      </div>
      <div class="panel-body">
        <form class="form-horizontal">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label for="title" class="col-md-2 control-label">标题：</label>
                <div class="col-md-10">
                  <input type="text" class="form-control" id="title" placeholder="请输入标题" v-model="blog.title"/>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <label for="slug" class="col-md-2 control-label">网址：</label>
                <div class="col-md-10">
                  <input type="text" class="form-control" id="slug" placeholder="请输入网址" v-model="blog.slug"/>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label class="col-md-2 control-label">分类：</label>
                <div class="col-md-10 mul_index">
                  <multiselect
                    v-model="category"
                    :options="categories"
                    :multiple="false"
                    :close-on-select="true"
                    :clear-on-select="false"
                    :taggable="true"
                    :searchable="true"
                    @tag="addCategory">
                  </multiselect>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <label class="col-md-2 control-label">标签：</label>
                <div class="col-md-10 mul_index">
                  <multiselect
                    v-model="values"
                    :options="options"
                    :multiple="true"
                    :taggable="true"
                    :searchable="true"
                    @tag="addTag">
                  </multiselect>
                </div>
              </div>
            </div>
          </div>
        </form>
        <mavon-editor ref=md @imgAdd="$imgAdd" @imgDel="$imgDel" v-model="blog.content" :ishljs="true" class="b_mavon"/>
        <div class="divider b_div"></div>
        <div class="form-group col-md-4">
          <label class="col-sm-6">开启评论：</label>
          <div class="col-sm-6">
            <div class="toggle toggle-success" v-bind:class="[blog.allowComment?'allow-true':'allow-false']" v-on:click="allowCommentData"></div>
          </div>
        </div>
        <div class="form-group col-md-4">
          <label class="col-sm-6">是否允许ping：</label>
          <div class="col-sm-6">
            <div class="toggle toggle-success" v-bind:class="[blog.allowPing?'allow-true':'allow-false']" v-on:click="allowPingData"></div>
          </div>
        </div>
        <div class="form-group col-md-4">
          <label class="col-sm-6">是否订阅：</label>
          <div class="col-sm-6">
            <div class="toggle toggle-success" v-bind:class="[blog.allowFeed?'allow-true':'allow-false']" v-on:click="allowFeedData"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import Multiselect from 'vue-multiselect'
  import toggle from '../../assets/js/toggles'
  import {mavonEditor} from 'mavon-editor'

  export default {
    name: 'AddBlog',
    data: function () {
      return {
        category: [],
        categories: [],
        values: [],
        options: [],
        blog:{
          title: '',
          slug: '',
          content: '',
          tags: '',
          categories: '',
          allowComment: false,
          allowPing: false,
          allowFeed: false,
          authorId: '1'
        }
      }
    },
    methods: {
      save: function(){
        const _this = this;
        const url = '/blog/blog/content';
        this.blog.tags = this.values.join(",");
        this.blog.categories = this.category.join(",");
        const param = this.blog;
        this.$api.post(url, param, r => {
          alert("文章保存成功!")
        }, res => {
         alert("文章保存失败!")
        } )
      },
      addCategory: function (lib){
        this.categories.push(lib)
        this.category.push(lib)
      },
      addTag: function (lib){
        this.values.push(lib)
        this.options.push(lib)
      },
      allowCommentData: function(){
        this.blog.allowComment = !this.blog.allowComment;
      },
      allowPingData: function(){
        this.blog.allowPing = !this.blog.allowPing;
      },
      allowFeedData: function(){
        this.blog.allowFeed = !this.blog.allowFeed;
      },
      $imgAdd: function(pos, $file){
        // 第一步.将图片上传到服务器.
        const formdata = new FormData();
        formdata.append('file', $file);
        this.$api.post('blog/blog/content/upload', formdata, r => {
          const url = r.data;
          // 第二步.将返回的url替换到文本原位置![...](0) -> ![...](url)
          // $vm.$img2Url 详情见本页末尾
          alert(url);
          this.$refs.md.$img2Url(pos, 'http://127.0.0.1:8003/blog' + url);
        }, res => {
          alert("图片保存失败!")
        });
      },
      $imgDel: function (pos) {
        alert(pos);
      }
    },
    created: function () {

    },
    components: {
      Multiselect
    },
    mounted: function () {
      $('.toggle').toggles({
        on: true,
        text: {
          on: '开启',
          off: '关闭'
        }
      });
      $('div.allow-false').toggles({
        off: true,
        text: {
          on: '开启',
          off: '关闭'
        }
      });
    }
  }

</script>
<style>
  @import "../../assets/css/toggles.css";
  .b_mavon{
    height: 500px;
  }
  .mul_index{
    z-index: 2000;
  }
  .b_div{
    height: 20px;
  }
</style>
