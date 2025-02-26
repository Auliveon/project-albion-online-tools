<script setup>
import {RouterView} from "vue-router";
import HorizontalMenu from "@/components/menu/HorizontalMenu";

window.addEventListener('vite:preloadError', () => {
  alert("Ошибка загрузки ресурсов сервера!");
  window.top.location.replace(window.location.origin + "/");
})

const menuItems = [
  {
    id: 'MainView',
    name: 'Main',
    path: '/'
  },
  {
    id: 'CraftView',
    name: 'Craft',
    path: '/craft'
  },
  {
    id: 'RouterView',
    name: 'Router',
    path: '/router'
  },
]
</script>

<template>
  <HorizontalMenu :items="menuItems"/>
  <RouterView />
</template>