<template>
  <div id="login">
    <h1>Login</h1>
    <input v-model="input.email" type="text" name="email" placeholder="your email" />
    <input v-model="input.password" type="password" name="password" placeholder="your password" />
    <button type="button" v-on:click="login()">Login</button>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      input: {
        email: "",
        password: ""
      }
    };
  },
  methods: {
    login() {
      const promise = fetch("http://localhost:8084/users", {
        method: "GET"
      });
      promise.then(response => {
        const newPromise = response.json();
        newPromise.then(result => {
          console.log(result);
          result.map(userData => {
            console.log(userData);
            if (this.input.email != "" && this.input.password != "") {
              if (
                this.input.email == userData.email &&
                this.input.password == userData.password
              ) {
                alert("yeah");
              } else {
                alert("fuck");
              }
            } else {
              alert("Please enter your email and password!");
            }
          });
        });
      });
    }
  }
};
</script>
