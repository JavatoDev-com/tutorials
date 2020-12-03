<template>
<v-container>
    <h1>Author Management UI</h1>
    <p>This UI developed to handle Author Registration.</p>
    <v-row>
      <v-col sm="12">
        <v-alert v-if="responseSuccess" dense text type="success">
          You have successfully added author.
        </v-alert>
      </v-col>
      <v-col sm="6">
        <h3>Author Registration</h3>
        <v-text-field
          v-model="userRegistration.firstName"
          label="First name"
        ></v-text-field>
        <v-text-field
          v-model="userRegistration.lastName"
          label="Last name"
        ></v-text-field>
        <v-btn color="primary" v-on:click="createAuthor">
          Register
        </v-btn>
      </v-col>
      <v-col sm="6">
        <h3>Registered Authors</h3>
        <v-simple-table>
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-left">
                  ID
                </th>
                <th class="text-left">
                  First Name
                </th>
                <th class="text-left">
                  Last Name
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="author in registeredAuthors" :key="author.id">
                <td>{{ author.id }}</td>
                <td>{{ author.firstName }}</td>
                <td>{{ author.lastName }}</td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import api from "@/service/apiService";

export default {
  name: "Author",
  data() {
    return {
      userRegistration: {
        firstName: "",
        lastName: "",
      },
      registeredAuthors: [],
      responseSuccess: false
    };
  },
  methods: {
    readAuthors: async function() {
      const data = await api.readAuthors();
      this.registeredAuthors = data;
    },
    createAuthor: async function() {
      const requestData = {
        firstName: this.userRegistration.firstName,
        lastName: this.userRegistration.lastName,
      };
      await api.createAuthor(requestData);
      this.userRegistration.firstName = "";
      this.userRegistration.lastName = "";
      this.readAuthors();
      this.responseSuccess = true;
    },
  },
  mounted() {
    this.readAuthors();
  },
};
</script>
