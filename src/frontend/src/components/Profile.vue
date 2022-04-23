<template>
  <div class="profileCard">
  <div class="container">
      <img src="../assets/logo.png" alt="developer" style="width:100%">
      <div class="textContainer">
        <h4><b>McClaine Beirne</b></h4> 
        <div class="break"></div> <!-- break to a new row -->
        <p>Developer</p> 
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'Profile',
}
</script>

<style>
.profileCard {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: 20%;
}
.profileCard:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}
.container {
  display: inline-flex;
  padding: 2px 16px;
  width: 90%;
  height: 90%;
}
.container img {
  width: inherit;
  height: inherit;
  border-radius: 50%;
}
.textContainer {
    margin-top: 10%;
   flex-direction: column;
}
.textContainer  h4 {
    color: #000; 
    
  
}

.break {
    border: black;
    border-bottom: double;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
}

.textContainer  p {
    flex-grow: 1;
    height: 10%;
     background-color: green;
}
</style>