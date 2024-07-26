<script setup>
import { useEmployeeStrore } from '@/stores/EmployeeStore';
import EmployeeComponent from '../../components/EmployeeComponent.vue'
import { onBeforeMount, onMounted } from 'vue';

const employeeStore = useEmployeeStrore();

onMounted(async ()=>{
  await employeeStore.fetchEmployee();
})

</script>

<template>
    <section class="mx-5 my-2">
        <button class="bg-blue-700 hover:bg-blue-900 text-white font-bold py-2 px-4 mx-2 rounded">
            <RouterLink to="/employee/add">+ Employee</RouterLink>
        </button>
    </section>
    <section>
        <div>
            <EmployeeComponent 
            v-for="employee in employeeStore.employees"
            :key="employee.id"
            :employee = "employee" />
        </div>
    </section>
</template>
