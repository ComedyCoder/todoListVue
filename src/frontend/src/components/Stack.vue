<template>
    <div id="techStack">
      <div class=CardCollcetion>
        <Card textColour="#42b983" image="logo.png" name="Vue" tech="Front-end" link="https://vuejs.org/v2/guide/"/>
        <Card textColour="#2d3e50" image="js.png" name="JavaScript" tech="Language" link="https://developer.mozilla.org/en-US/docs/Web/JavaScript"/>
      </div>
      <div class=CardCollcetion>
        <Card textColour="#77bc20" image="spring.png" name="Spring" tech="Back-end" link="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/"/>
        <Card textColour="#e84134" image="java.png" name="Java" tech="Language" link="https://docs.oracle.com/en/java/"/>
      </div>
      <div class=CardCollcetion>
      <Card textColour="#fea610" image="firebase.png" name="Firebase" tech="Data-store" link="https://firebase.google.com/docs/firestore"/>
      </div>
  </div>
</template>

<script>
import Card from '../components/Card.vue'
export default {
    name: 'Stack',
  components: {
    Card
  }

}
</script>

<style>
  .CardCollcetion {
  display: inline-flex;
  justify-content: space-between;
  width: 32%;
  margin-bottom: 5%;

}

#techStack{
  display: inline-flex;
  justify-content: space-between;
  width: 40%;
  margin-left: 5%;
}

</style>