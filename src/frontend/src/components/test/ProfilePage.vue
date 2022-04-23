<template>
  <!-- ProfilePage.vue -->
     <account-info :username="user.username" @changeUsername="changeUsername($event)"/>
</template>

<script>

import AccountInfo  from './AccountInfo.vue'
export default {
    name: 'profilePage',
    components: {
        AccountInfo
    },
    data() {
      return {
        user: {
          username: 'matt'
        }
      }
    },
    methods: {
        changeUsername (username) {
        this.user.username = username;
   }
 }
}
</script>

<style>

</style>