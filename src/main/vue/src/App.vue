<script setup>
import {RouterView} from "vue-router";
import HorizontalMenuComponent from "@/components/menu/HorizontalMenuComponent";
import FooterComponent from "@/components/footer/FooterComponent";

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
  <HorizontalMenuComponent :items="menuItems"/>
  <RouterView />
  <FooterComponent :text="'© 2025 Albion Online Tools. All rights reserved.'"/>
</template>