<template>
  <v-container>
    <h1>Member Management UI</h1>
    <p>This UI developed to handle Member Registration.</p>
    <v-row>
      <v-col sm="12">
        <v-alert v-if="responseSuccess" dense text type="success">
          You have successfully added member.
        </v-alert>
      </v-col>
      <v-col sm="6">
        <h3>Member Registration</h3>
        <v-text-field
          v-model="memberRegistration.firstName"
          label="First name"
        ></v-text-field>
        <v-text-field
          v-model="memberRegistration.lastName"
          label="Last name"
        ></v-text-field>
        <v-btn color="primary" v-on:click="createMember">
          Register
        </v-btn>
      </v-col>
      <v-col sm="6">
        <h3>Registered Members</h3>
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
              <tr v-for="member in registeredMembers" :key="member.id">
                <td>{{ member.id }}</td>
                <td>{{ member.firstName }}</td>
                <td>{{ member.lastName }}</td>
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
  name: "Member",
  data() {
    return {
      memberRegistration: {
        firstName: "",
        lastName: "",
      },
      registeredMembers: [],
      responseSuccess: false,
    };
  },
  methods: {
    readMembers: async function() {
      const data = await api.readMembers();
      this.registeredMembers = data;
    },
    createMember: async function() {
      const requestData = {
        firstName: this.memberRegistration.firstName,
        lastName: this.memberRegistration.lastName,
      };
      await api.createMember(requestData);
      this.memberRegistration.firstName = "";
      this.memberRegistration.lastName = "";
      this.readMembers();
      this.responseSuccess = true;
    },
  },
  mounted() {
    this.readMembers();
  },
};
</script>
