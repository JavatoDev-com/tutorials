<template>
  <v-container>
    <h1>Welcome to the library</h1>
    <p>Library system by Javatodev.com.</p>
    <v-row>
      <v-col sm="4">
        <h3>Burrow a Book - Book Lending</h3>
        <v-autocomplete
          :items="members"
          color="white"
          item-value="id"
          item-text="firstName"
          label="Member"
          v-model="bookLending.memberId"
        ></v-autocomplete>
        <v-autocomplete
          :items="books"
          color="white"
          item-value="id"
          item-text="name"
          label="Books"
          v-model="bookLending.selectedBook"
        ></v-autocomplete>
        <v-btn depressed color="default" v-on:click="addBook">
          Add Book
        </v-btn>
        <v-btn color="success" v-on:click="lendBook">
          Lend The Books
        </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>
<script lang="ts">
import api from "@/service/apiService";

export default {
  name: "Dashboard",
  data() {
    return {
      bookLending: {
        selectedBook: "",
        memberId: "",
      },
      members: [],
      books: [],
      selectedBooks: []
    };
  },
  methods: {
    readMembers: async function() {
      const data = await api.readMembers();
      this.members = data;
    },
    readBooks: async function() {
      const data = await api.readBooks();
      this.books = data;
    },
    lendBook: async function() {
      console.log("Lending Books");
    },
    addBook: async function () {
      console.log("Adding Book"+this.bookLending.selectedBook)
    }
  },
  mounted() {
    this.readBooks();
    this.readMembers();
  },
};
</script>
