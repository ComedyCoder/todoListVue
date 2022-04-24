import CreateForm from '../components/CreateForm.vue'
import Vue from 'vue'
import FilterSelect from "@/components/FilterSelect";

export default {
    name: 'TodoList',
    components: {
        CreateForm,
        FilterSelect
    },
    data() {
        return {
            showModal: false,
            selectedID: "",
            selectedName: "",
            selectedIcon: "star",
            selectedCompleted: false,

            map: {
                1: {name: "map1", time: "Fir 3pm"}
            },
        }
    },
    mounted() {
        fetch("/api/tasks/getAll")
            .then((response) => {
                return response.json();
            })
            .then((data) => {
                this.map = data;
            })
    },
    methods: {
        async addTask(task) {
            // if task has no existing ID, it must be a new task they are trying to create.
            if (task.id === "") {
                this.selectedName = '';
                this.selectedIcon = 'star';
                let d = Date.now();
                task.id = d.toString();
                task.completed = false;
            }
            await fetch("/api/tasks/create", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(task)
            });
            this.map[task.id] = task
            this.selectedID = '';
            this.selectedName = '';
            this.selectedIcon = 'star';
            this.showModal = false;
            this.selectedCompleted = false;

        },
        editTask(item) {
            this.selectedID = item.id;
            this.selectedName = item.name;
            this.selectedIcon = item.icon;
            this.selectedCompleted = item.completed;
            this.showModal = true
        },
        async deleteTask(key) {
            await fetch("/api/tasks/delete?docID=" + key, {
                method: "DELETE",
            });
            Vue.delete(this.map, key);
        },
        async updateCheckbox(key, bool) {
            await fetch("/api/tasks/updateStatus?docID=" + key + "&bool=" + bool, {
                method: "PUT",
            });
            console.log("update >>>>" + bool);
        },
        async filterSelected(filter) {
            console.log("2nd");
            console.log(filter);
            fetch("/api/tasks/filterBy?filter=" + filter)
                .then((response) => {
                    return response.json();
                })
                .then((data) => {
                    this.map = data;
                })
        }
    }
}
