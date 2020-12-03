<template>
 <v-container>
    <h1>Book Management UI</h1>
    <p>This UI developed to handle Book Registration and Edits</p>
    <v-row>
      <v-col sm="12">
        <v-alert v-if="responseSuccess" dense text type="success">
          You have successfully added book.
        </v-alert>
      </v-col>
      <v-col sm="6">
        <h3>Book Registration</h3>
        <v-text-field
          v-model="bookRegistration.bookname"
          label="Name"
        ></v-text-field>
        <v-text-field
          v-model="bookRegistration.isbn"
          label="ISBN"
        ></v-text-field>
        <v-autocomplete
          :items="authors"
          color="white"
          item-value="id"
          item-text="firstName"
          label="Author"
          v-model="bookRegistration.authorId"
        ></v-autocomplete>
      
        <v-btn v-if="editingId" color="success" v-on:click="editBook">
          Edit
        </v-btn>
        <v-btn v-else color="primary" v-on:click="createBook">
          Register
        </v-btn>
      </v-col>
      <v-col sm="6">
        <h3>Registered Books</h3>
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
                <th class="text-left">
                  Action
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="book in books" :key="book.id">
                <td>{{ book.id }}</td>
                <td>{{ book.name }}</td>
                <td>{{ book.isbn }}</td>
                <td>
                  <v-btn icon color="pink" v-on:click="deleteBook(book.id)">
                    <v-icon>mdi-delete</v-icon>
                  </v-btn>
                  <v-btn icon color="blue" v-on:click="initiateEdit(book.id)">
                    <v-icon>mdi-pencil-box-outline</v-icon>
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
  name: "Book",
  data() {
    return {
      bookRegistration: {
        bookname: "",
        isbn: "",
        authorId: "",
      },
      authors: [],
      books: [],
      editingId : 0,
      responseSuccess: false
    };
  },
  methods: {
    createBook: async function() {
      const bookRequest = {
        name: this.bookRegistration.bookname,
        isbn: this.bookRegistration.isbn,
        authorId: this.bookRegistration.authorId,
      };
      const data = await api.createBook(bookRequest);
      this.bookRegistration.bookname = "";
      this.bookRegistration.isbn = "";
      this.bookRegistration.authorId = "";
      this.readBooks();
      this.responseSuccess = true;
    },
    readAuthors: async function() {
      const data = await api.readAuthors();
      this.authors = data;
    },
    readBooks: async function() {
      const data = await api.readBooks();
      this.books = data;
    },
    deleteBook: async function(bookId) {
      const data = await api.deleteBook(bookId);
      this.readBooks();
    },
    initiateEdit: async function (bookId) {
      this.editingId = bookId;
      const bookData = await api.readBook(this.editingId);
      this.bookRegistration.bookname = bookData.name;
      this.bookRegistration.isbn = bookData.isbn;
      this.bookRegistration.authorId = bookData.author.id;
    },
    editBook : async function () {
      console.log("Editing : "+this.editingId)
      const bookRequest = {
        name: this.bookRegistration.bookname,
        isbn: this.bookRegistration.isbn,
        authorId: this.bookRegistration.authorId,
      };
      const data = await api.updateBook(this.editingId, bookRequest);
      this.bookRegistration.bookname = "";
      this.bookRegistration.isbn = "";
      this.bookRegistration.authorId = "";
      this.editingId = 0;
      this.readBooks();
    }
  },
  mounted() {
    this.readAuthors();
    this.readBooks();
  },
};
</script>
