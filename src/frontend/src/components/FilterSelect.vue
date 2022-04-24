<template>
  <div class="filter">
    <label>Show Tasks that are:</label>
    <form>
     <select v-model="filter"  @change="onChange()">
        <option value="all">all</option>
        <option value="completed">completed</option>
        <option value="onGoing">On going</option>
        <option value="important">Important</option>
      </select>
    </form>
  </div>
</template>

<script>
export default {
  name: 'FilterSelect',
  data() {
    return {
    filter: String
  }
  },
  methods: {
    onChange() {
      console.log("1st");
      console.log(this.filter);
      this.$emit('filterSelected', this.filter);
    }
  }
}
</script>

<style >
.filter select {
  width: 15%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
  text-align: center;
  margin: auto;
}

</style>