import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/login'
import Index from '@/components/index'
import AddUser from '@/components/content/addUser'
import ListUser from '@/components/content/listUser'
import AddBlog from '@/components/content/addBlog'
import ListBlog from '@/components/content/listBlog'
import View from '@/components/view'
import ArticleView from '@/components/view/articleView'
import Articles from '@/components/view/articles'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/index',
      name: 'Index',
      component: Index,
      children: [
        {
          path: 'addUser',
          name: 'AddUser',
          component: AddUser
        },
        {
          path: 'listUser',
          name: 'ListUser',
          component: ListUser
        },
        {
          path: 'addBlog',
          name: 'AddBlog',
          component: AddBlog
        },
        {
          path: 'listBlog',
          name: 'ListBlog',
          component: ListBlog
        }
      ]
    },
    {
      path: '/view',
      name: 'View',
      component: View,
      children: [
        {
          path: 'articleView',
          name: 'ArticleView',
          component: ArticleView
        },
        {
          path: 'articles',
          name: 'Articles',
          component: Articles
        }
      ]
    }
  ]
})
