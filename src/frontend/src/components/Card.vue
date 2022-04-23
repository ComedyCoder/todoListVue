<template>
  <div class="card">
    <a v-bind:href="link">
    <img :src="require('@/assets/' + image + '')" alt="vue" style="width:100%"/>
    <h4 v-bind:style="{'color': textColour}">{{name}}</h4>
    <p>{{tech}}</p>
    </a>
  </div>
</template>

<script>
export default {
  name: 'Card',
  props: {
    textColour: String,
    image: String,
    name: String,
    tech: String,
    link: String
  }

}
</script>

<style>
.card {
  background: white;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  border-radius: 5% ;
  width: 49%;
  cursor: pointer;
}

.card:hover {
   box-shadow: 0 16px 32px 0 rgba(0,0,0,0.2);
   width: 60%;
}

.card img {
margin-top: 2%;
}
.card p {
    font-family: monospace;
    font-size: small;
    color: black;
}
a {
  text-decoration: none; /* no underline */
}

</style>