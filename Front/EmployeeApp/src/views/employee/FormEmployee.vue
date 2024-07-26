<template>
   <div class="flex justify-center my-3">
      <form @submit.prevent="submitForm" action="#" class="flex flex-col w-1/2">
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Name :
         <input type="text" name="name" id="name" placeholder="Employee name" v-model.trim="employee.name" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Identification Number :
         <input type="text" name="identificationNumber" id="identificationNumber" placeholder="123 4564 8797" v-model.trim="employee.identificationNumber" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Address :
         <input type="text" name="address" id="address" placeholder="120 street of " v-model.trim="employee.address" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Phone :
         <input type="text" name="phone" id="phone" placeholder="+xx 012345678" v-model.trim="employee.phone" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Email :
         <input type="email" name="email" id="email" placeholder="email@email.com" v-model.trim="employee.email" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Birth Date :
         <input type="date" name="birthDateStr" id="birthDateStr" v-model.trim="employee.birthDateStr" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <div class="flex flex-row justify-evenly w-full">
         <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
            Contract Start Date :
            <input type="date" name="contractStartDateStr" id="contractStartDateStr" v-model.trim="employee.contractStartDateStr" required
            class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
         </label>
         <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
            Contract End Date :
            <input type="date" name="contractEndDateStr" id="contractEndDateStr" v-model.trim="employee.contractEndDateStr"
            class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
         </label>

      </div>

      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Occupation :
         <input type="text" name="occupation" id="occupation" placeholder="occupation" v-model.trim="employee.occupation" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>

      <div class="flex flex-row justify-evenly w-full">
         <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Password :
         <input type="password" name="password" id="password" v-model.trim="employee.password" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Admin :
         <input type="checkbox" name="admin" id="admin" v-model.trim="employee.admin"
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Salary :
         <input type="number" name="salary" id="salary"  v-model.trim="employee.salary" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      </div>

      
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Observation :
         <input type="text" name="observation" id="observation" v-model.trim="employee.observation" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <button class="bg-green-500 hover:bg-green-700 text-white font-bold py-1 px-3 mx-2 rounded">submit</button>
   </form>
   </div>
  
</template>

<script setup>
import { useEmployeeStrore } from '@/stores/EmployeeStore';
import{onMounted, ref}from 'vue';
import { useRoute, useRouter } from 'vue-router';

const employeeStore = useEmployeeStrore();
const router = useRouter()

const employee = ref({
   name:"",
   identificationNumber:"",
   address:"",
   phone:"",
   email:"",
   birthDateStr:"",
   contractStartDateStr:"",
   contractEndDateStr:"",
   occupation:"",
   password:"",
   admin:false,
   salary:0,
   observation:""
})

const id = ref(0);



onMounted(async ()=>{
   const route = useRoute();
   const {idEmployee} = route.params
   id.value = idEmployee
   if(idEmployee != undefined){
      const employeeFind = await employeeStore.findEmployee(idEmployee);
      employee.value = employeeFind;
      employee.value.birthDateStr = employeeFind.birthDate
      employee.value.contractStartDateStr = employeeFind.contractStartDate
      employee.value.contractEndDateStr = employeeFind.contractEndDate
   }
   
})

const submitForm = () => {
   if(id.value!== undefined){
      employeeStore.updateEmployee(id,employee.value)
   }else{
      employeeStore.postEmployee(employee.value)
   }
   router.go(-1)
}


</script>
