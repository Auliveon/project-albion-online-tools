<script setup>
const props = defineProps({
  text: {
    type: String,
    default: null
  }
});
</script>

<template>
  <footer class="gray">
    {{ props.text }}
  </footer>
</template>

<style scoped>
footer {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  color: var(--text-color-base);
  text-align: center;
}
</style>