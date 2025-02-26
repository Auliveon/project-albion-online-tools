import {createRouter, createWebHistory} from 'vue-router';
import {MainPage} from "@/routers/subroutes/main/MainPageRouter";
import {CraftPage} from "@/routers/subroutes/craft/CraftPageRouter";
import {RouterPage} from "@/routers/subroutes/router/RouterPageView";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        ...MainPage,
        ...CraftPage,
        ...RouterPage,
    ]
});

router.beforeEach((to, from, next) => {
  if (to.meta['pageTitle']) {
    document.title = to.meta['pageTitle'];
  }
  next();
});

export default router;