<template>
  <v-container>
    <h1>Welcome to the library</h1>
    <p>Library system by Javatodev.com.</p>
    <v-row>
      <v-col sm="12">
        <v-alert v-if="responseSuccess" dense text type="success">
          You have successfully added book lending request.
        </v-alert>
      </v-col>
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
      <v-col sm="8">
        <h3>Selected Books</h3>
        <v-simple-table>
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-left">
                  ID
                </th>
                <th class="text-left">
                  Name
                </th>
                <th class="text-left">
                  ISBN
                </th>
                <th class="text-left">
                  Action
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="book in selectedBooks" :key="book.id">
                <td>{{ book.id }}</td>
                <td>{{ book.name }}</td>
                <td>{{ book.isbn }}</td>
                <td>
                  <v-btn icon color="pink" v-on:click="removeBook(book.id)">
                    <v-icon>mdi-delete</v-icon>
                  </v-btn>
                </td>
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
  name: "Dashboard",
  data() {
    return {
      bookLending: {
        selectedBook: 0,
        memberId: "",
      },
      members: [],
      books: [],
      selectedBooks: [],
      responseSuccess: false,
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
      let selectedIds = [];
      this.selectedBooks.forEach((book) => {
        selectedIds.push(book.id);
      });
      console.log("Lending Books " + selectedIds);
      const request = {
        bookIds: selectedIds,
        memberId: this.bookLending.memberId,
      };
      const bookLendingResponse = await api.lendBook(request);
      console.log(bookLendingResponse);
      this.responseSuccess = true;
      this.selectedBooks = [];
      this.bookLending.selectedBook = 0;
      this.bookLending.memberId = "";
    },
    addBook: async function() {
      console.log("Adding Book" + this.bookLending.selectedBook);
      const bookData = await api.readBook(this.bookLending.selectedBook);
      console.log("Added Book " + bookData.id);
      this.selectedBooks.push(bookData);
    },
    removeBook: function(bookId) {
      console.log("Removing Book " + bookId);
      this.selectedBooks = this.selectedBooks.filter(
        (book) => book.id != bookId
      );
    },
  },
  mounted() {
    this.readBooks();
    this.readMembers();
  },
};
</script>
