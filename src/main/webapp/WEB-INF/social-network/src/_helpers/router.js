import Vue from "vue";
import VueRouter from "vue-router";

import Login from "../pages/Login"
import HomePage from "../pages/HomePage";
import Register from "../pages/Register";

Vue.use(VueRouter);

const router = new VueRouter({
    mode: "history",
    routes: [{
            path: "/",
            name: 'Login',
            component: Login
        },
        {
            path: "/homepage",
            name: "HomePage",
            component: HomePage
        },
        {
            path: "/register",
            name: "Register",
            component: Register
        },
        {
            path: "*",
            redirect: '/'
        }
    ],
});

export default router;