import axios from "axios";

const apiClient = {
  async readAuthors() {
    const response = await axios.get("/author");
    console.log(response.data);
    return response.data;
  },
  async createAuthor(requestData: any) {
    const response = await axios.post("/author", requestData);
    return response.data;
  },
  async readMembers() {
    const response = await axios.get("/member");
    console.log(response.data);
    return response.data;
  },
  async createMember(requestData: any) {
    const response = await axios.post("/member", requestData);
    return response.data;
  },
};

export default apiClient;
