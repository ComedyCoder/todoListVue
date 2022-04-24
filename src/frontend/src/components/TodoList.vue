<template>
  <div>
    <FilterSelect @filterSelected="filterSelected($event)"/>
    <h1>TodoList</h1>
    <!-- The List of Todos -->
    <ul>
      <li v-for="(value, key) in map" :key="key">
        <!--each item in the list -->
        <input type="checkbox" id="checkbox" v-model="value.completed" @click="updateCheckbox(key, !value.completed)">
        <div class="todoName">
          <font-awesome-icon :icon="value.icon"/>
          {{ value.name }}
        </div>

        <div class="todoTime">
          <font-awesome-icon icon="clock"/>
          {{ value.time }}
        </div>

        <button @click="editTask(value)">Edit</button>
        <button @click="deleteTask(key)">x</button>
      </li>
    </ul>

    <button class="btbModal" @click.prevent="showModal = true">
      +
    </button>

    <transition name="fade" appear>
      <div class="modal-overlay" v-if="showModal" @click="showModal=false"></div>
    </transition>
    <transition name=slide appear v-if="showModal">
      <div class="modal">
        <CreateForm @addTask="addTask($event)" :selectedID="selectedID" :selectedName="selectedName"
                    :selectedIcon="selectedIcon"/>
      </div>
    </transition>
  </div>
</template>

<script src="../scripts/todoList.js"></script>

<style>
ul {
  margin: 0 auto;
  width: 30%;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  border-radius: 10px;
  background: white;
  list-style: none;
}

li {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1%;
  padding: 2%;
  border-bottom: 2px solid lightgray;
}

li .todo {
  flex: 1;
}

li input {
  width: 5%;
}

button {
  appearance: none;
  outline: none;
  border: none;
  cursor: pointer;
  display: inline-block;
  margin: 1%;
  border-radius: 50%;
  background-image: linear-gradient(to right, #CC2E5D, #FF585F);
  color: #FFF;
  box-shadow: 3px 3px rgba(0, 0, 0, 0.4);
  transition: 0.4s ease-out;
}

button:hover {
  box-shadow: 6px 6px rgba(0, 0, 0, 0.6);
}

.btbModal {
  height: 100px;
  width: 100px;
  font-size: 50px;
  font-weight: 700;
}

.modal-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 97;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 98;
  background-color: rgba(0, 0, 0, 0.3);
}

.modal {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 99;

  width: 100%;
  max-width: 400px;
  background-color: #FFF;
  border-radius: 16px;

  padding: 25px;

}

.fade-enter-active,
.fade-leave-active {
  transition: opacity .5s;
}

.fade-enter,
.fade-leave-to {
  opacity: 0;
}

.slide-enter-active,
.slide-leave-active {
  transition: transform .5s;
}

.slide-enter,
.slide-leave-to {
  transform: translateY(-50%) translateX(100vw);
}


</style>