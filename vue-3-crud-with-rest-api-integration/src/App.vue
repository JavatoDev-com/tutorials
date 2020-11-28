<template>
  <v-app id="inspire">
    <v-app-bar app color="white" flat>
      <v-container class="py-0 fill-height">
        <v-btn v-for="link in links" :key="link.name" :to="link.url" text>
          {{ link.name }}
        </v-btn>

        <v-spacer></v-spacer>

        <v-responsive max-width="260"> </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col>
            <v-sheet min-height="70vh" rounded="lg">
              <!--  -->
              <router-view></router-view>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import Vue from "vue";
import Dashboard from "./components/Dashboard.vue";

export default Vue.extend({
  name: "App",

  components: {
    Dashboard,
  },

  data: () => ({
    links: [
      {
        name: "Dashboard",
        url: "/",
      },
      {
        name: "Member",
        url: "/member",
      },
      {
        name: "Author",
        url: "/author",
      },
      {
        name: "Book",
        url: "/book",
      },
    ],
  }),
});
</script>
<style>
.main-body {
  padding-top: 10px;
  padding-right: 10px;
}
</style>
