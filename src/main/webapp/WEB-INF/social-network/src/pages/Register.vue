<template>
  <div id="register">
    <h1>Création de personne</h1>
    <form id="formPerson">
      <p>
        Firstname :
        <input v-model="input.firstname" type="text" name="firstname" />
      </p>
      <p>
        Lastname :
        <input v-model="input.lastname" type="text" name="lastname" />
      </p>
      <p>
        Password :
        <input v-model="input.password" type="text" name="password" />
      </p>
      <p>
        Email :
        <input v-model="input.email" type="text" name="email" />
      </p>
      <p>
        Birth Date :
        <input v-model="input.birthdate" type="date" name="birthdate" />
      </p>
      <p>
        <input type="submit" value="Register" v-on:click.prevent="register" />
      </p>
    </form>
    <div>
      <router-link :to="{name: 'Login'}">
        <strong>login</strong>
      </router-link>
    </div>
  </div>
</template>

<script>
// import axios from "axios";
export default {
  name: "Register",
  data() {
    return {
      input: {
        firstname: "",
        lastname: "",
        password: "",
        email: "",
        birthdate: ""
      }
    };
  },
  methods: {
    register() {
      const url = "http://localhost:8084/users";
      const body = {
        firstname: this.input.firstname,
        lastname: this.input.lastname,
        password: this.input.password,
        email: this.input.email,
        birthdate: this.input.birthdate
      };

      const xhr = new XMLHttpRequest();
      xhr.open("POST", url);
      xhr.setRequestHeader("Content-type", "application/json");
      xhr.onload = function() {
        console.log(body);
      };
      xhr.send(JSON.stringify(body));
      //   axios
      //     .post("http://localhost:8085/users", {
      //       firstname: this.firstname,
      //       lastname: this.lastname,
      //       email: this.email,
      //       password: this.password,
      //       birthdate: this.birthdate,
      //     })
      //     .then((result) => {
      //       console.log(result);
      //     });
    }
  }
};
</script>
