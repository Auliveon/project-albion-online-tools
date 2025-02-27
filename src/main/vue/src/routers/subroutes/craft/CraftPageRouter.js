const CraftView = () => import("@/views/craft/CraftView")

export const CraftPage = [
    {
        path: '/craft',
        name: "CraftView",
        component: CraftView,
        props: (route) => route.query,
        meta: {
            pageTitle: "Albion Online Tools"
        }
    }
]