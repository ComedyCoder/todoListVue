// AccountInfo.vue

<template>
   <div id='account-info'>
     <button @click='ChildchangeUsername()'>Change Username</button>
       {{username}}
   </div>
</template>
 
<script>
export default {
 name: 'accountInfo',
 props: {
   username: String
 },
 methods: {
   ChildchangeUsername() {
    this.$emit('changeUsername', 'mattmaribojoc')
   }
 }
}
</script>

<style> 
    #account-info{
        color: #FFF;
        font-size: xx-large;
    }
</style>