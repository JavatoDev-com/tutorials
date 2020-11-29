<template>
  <v-container>
    <h1>Library Dashboard</h1>
    <v-row>
      <v-col sm="6">
          <v-text-field
            v-model="model"
            :counter="max"
            :rules="rules"
            label="First name"
          ></v-text-field>
      </v-col>
    </v-row>
  </v-container>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class Dashboard extends Vue {}
</script>
