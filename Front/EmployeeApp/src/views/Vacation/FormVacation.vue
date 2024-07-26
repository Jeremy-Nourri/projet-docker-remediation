<template>
    <div class="flex justify-center my-3">
       <form @submit.prevent="submitForm" action="#" class="flex flex-col w-1/2">
       <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
          Start vacation Date :
          <input type="date" name="startStr" id="startStr" v-model.trim="vacation.startStr" required
          class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
       </label>

       <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
          End vacation Date :
          <input type="date" name="endStr" id="endStr" v-model.trim="vacation.endStr" required
          class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
       </label>
    
       <button class="bg-green-500 hover:bg-green-700 text-white font-bold py-1 px-3 mx-2 rounded">submit</button>
    </form>
    </div>
   
 </template>
 
 <script setup>
 
 import { useVacationStore } from '@/stores/VacationStore';
 import { useEmployeeStrore } from '@/stores/EmployeeStore';
 import{onBeforeMount, onMounted, ref}from 'vue';
 import { useRoute, useRouter } from 'vue-router';
 
 const employeeStore = useEmployeeStrore();
 const vacationStore = useVacationStore()
 const router = useRouter()
 
 const vacation = ref({
    employeeId:1,
    startStr:"",
    endStr:""
 })
 
 
 onMounted(async ()=>{
    const route = useRoute();
   const {idemployee} = route.params
   vacation.employeeId = idemployee
    
    
 })
 
 const submitForm = () => {
    vacationStore.postVacation(vacation.value)
    router.go(-1)
 }
 
 
 </script>