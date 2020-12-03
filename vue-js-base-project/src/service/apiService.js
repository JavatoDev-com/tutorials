import axios from "axios";

const apiClient = {
  async readAuthors() {
    const response = await axios.get("/author");
    return response.data;
  },
  async createAuthor(requestData) {
    const response = await axios.post("/author", requestData);
    return response.data;
  },
  async readMembers() {
    const response = await axios.get("/member");
    return response.data;
  },
  async createMember(requestData) {
    const response = await axios.post("/member", requestData);
    return response.data;
  },
  async readBooks() {
    const response = await axios.get("/book");
    return response.data;
  },
  async createBook(requestData) {
    const response = await axios.post("/book", requestData);
    return response.data;
  },
  async deleteBook(bookId) {
    const response = await axios.delete("/book/"+bookId);
    return response.data;
  },
  async lendBook(requestData) {
    console.log(requestData);
    const response = await axios.post("/book/lend", requestData);
    return response.data;
  },
  async readBook(bookId) {
    const response = await axios.get("/book/"+bookId);
    return response.data;
  },
  async updateBook(bookId, requestData) {
    const response = await axios.patch("/book/"+bookId, requestData);
    return response.data;
  }
};

export default apiClient;
