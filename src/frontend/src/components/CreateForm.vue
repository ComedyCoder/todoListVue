<template>
  <form> 
      <label>Title:</label>
      <input type="name" required v-model="selectedName" />
      <label>Icon:</label>
      <select v-model="selectedIcon">
        <option value="star">Important</option>
        <option value="laptop-code">Work</option>
        <option value="gamepad">Fun</option>
        <option value="bed">Relax</option>
      </select>
      <button class="btbForm" @click.prevent="clicked()"><i class="fas fa-plus"></i>+</button>

  </form>
</template>

<script>
export default {
  name: 'createForm',
  props: {
    selectedID: String,
    selectedName: String,
    selectedIcon: String,
    selectedCompleted: Boolean,
  },
   methods: {
    clicked() {
      let name = this.selectedName;
      let id = this.selectedID;
      let time = this.createDateTime();
      let icon = this.selectedIcon;
      let completed = this.selectedCompleted;
      this.$emit('addTask', {id, name, time, icon, completed});
    },
     createDateTime() {
       let date = new Date();
       let day = date.getDate() + "/" + date.getMonth()+1 + "/" + date.getFullYear()
       let time = date.getHours() + ":" + date.getMinutes();
       let event = time + " : " + day;
       return event;
     }
  }

}
</script>

<style>
  .btbForm {
  height: 50px;
  width: 50px;
  font-size: 43px;
  font-weight: 400;
  }
  label {
      color: #FF585F;
      display: inline-block;
      margin: 25px 0 15px;
      font-size: 0.6em;
      text-transform: uppercase;
      letter-spacing: 1px;
      font-weight: bold;
  }
  input, select {
      display: block;
      padding: 10px 6px;
      width: 100%;
      box-sizing: border-box;
      border: none;
      border-bottom: 1px solid #ddd;
      color: #555;
  }

</style>