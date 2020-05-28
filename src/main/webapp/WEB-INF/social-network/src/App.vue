<template>
  <div id="app">
    <router-view />
    <div>
      <router-link :to="{name: 'Register'}">
        <strong>Register</strong>
      </router-link>
    </div>
    <!-- <div>
      <router-link :to="{name: 'Login'}">
        <strong>login</strong>
      </router-link>
    </div>-->
  </div>
</template>

<script>
export default {
  name: "App",
  components: {}
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
