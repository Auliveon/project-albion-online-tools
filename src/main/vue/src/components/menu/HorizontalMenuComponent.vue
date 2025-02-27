<script setup>
import router from "@/routers/Routers";
import {ref} from "vue";

const props = defineProps({
  items: {
    type: Array,
    default: () => []
  }
});

const currentRoute = ref('/');

async function navigateTo(routeName, path) {
  currentRoute.value = path;
  await router.push({name: routeName});
}

</script>

<template>
  <div class="flex light-blue-gray text-color-white">
    <h2 class="mg-l-1">Albion Online Tools</h2>
    <div class="mg-l-auto mg-r-1 mg-t-20px">
      <label
          v-for="item in props.items"
          :key="item.path"
          class="navbar-item mg-l-2"
          :class="{ selected: currentRoute === item.path }"
          @click="navigateTo(item.id, item.path)"
      >
        {{ item.name }}
      </label>
    </div>

  </div>
</template>

<style scoped>

label.navbar-item {
  font-size: 24px;
  transition: text-shadow 0.3s ease-in-out;
  height: 30px;
  cursor: pointer;
  color: var(--text-color-base);

}

label.navbar-item.selected {
  font-size: 24px;
  transition: color 0.5s ease-in-out;
  height: 30px;
  text-shadow: 0 0 12px white;
  cursor: default;
}

label.navbar-item:hover {
  text-shadow: 0 0 12px white;
}

label.navbar-item.selected:hover {
  color: white;
}

</style>