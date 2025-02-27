const RouterView = () => import("@/views/router/RouterView")

export const RouterPage = [
    {
        path: '/router',
        name: "RouterView",
        component: RouterView,
        props: (route) => route.query,
        meta: {
            pageTitle: "Albion Online Tools"
        }
    }
]