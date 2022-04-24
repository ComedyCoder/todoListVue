<template>
  <div id="app" >
    <img  id="me" alt="Vue logo" src="./assets/me.png">
    <HelloWorld />
    <TodoList />
     <Stack />

  </div>
</template>

<script>
import Stack from './components/Stack.vue'
import HelloWorld from './components/HelloWorld.vue'
import TodoList from './components/TodoList.vue';

export default {
  name: 'App',
  components: {
     HelloWorld,
    TodoList,
    Stack,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
#me {
  width: 15%;
  height: auto;
  border-radius: 50%;
}
body {
  margin: 0;
  background: url("./assets/earth.png") 
}

</style>
