---
title: hexo-next新增文章
---
# hexo-next新增文章

<!-- more -->

* ## 安装hexo

  > 1.安装node.js和git
  >
  > 2.安装hexo
  >
  > ```
  > #安装hexo
  > npm install -g hexo
  > #新建自己的项目文件夹(myproject)并进入自己的项目文件夹
  > cd myproject
  > hexo init
  > #安装依赖
  > npm install
  > #hexo编译和启动
  > hexo g
  > hexo s
  > #访问http://localhost:4000,查看hexo是否搭建成功
  > ```

  # 安装hexo-next

  >1.安装hexo-next插件
  >
  >```
  >#先myproject目录下执行
  >git clone https://github.com/theme-next/hexo-theme-next.git
  >#修改myproject目录下的_conf.yml
  >theme: next
  >```

![alt 修改config](/pictures/update_hexo_config.png)

* # 新建文章

  > 1.新建文章(文章名称:doc)
  >
  > ```
  > hexo new doc
  > ```
  >
  > 2.使用markdown编辑器修改文章
  >
  > ```
  > #文章目录
  > /myproject/_posts/doc
  > ```

* # 发布文章

  > 1.修改myproject目录下的_conf.yml配置文件
  >
  > ```
  > #修改deploy属性
  > ```
  >
  > ![alt 修改config](/pictures/update_display_config.jpg)
  >
  > 2.发布命令
  >
  > ```
  > hexo d
  > ```