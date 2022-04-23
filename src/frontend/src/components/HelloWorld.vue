<template>
  <div class="hello">
    <p>{{ msg }}</p>
   
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
    fetch("/api/messages/hello")
    .then((response) => response.text())
    .then((data) => {
      this.msg = data;
    })
  }
}


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
.hello p {
  color: #42b983;
  position: relative;
}
.hello img {
 
  width: 5%;
  height: auto;
}
</style>
