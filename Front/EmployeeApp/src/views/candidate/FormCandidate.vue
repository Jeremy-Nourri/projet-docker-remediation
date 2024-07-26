<template>
   <div class="flex justify-center my-3">
      <form @submit.prevent="submitForm" action="#" class="flex flex-col w-1/2">
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Name :
         <input type="text" name="name" id="name" placeholder="Candidate name" v-model.trim="candidate.name" required value=""
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Identification Number :
         <input type="text" name="identificationNumber" id="identificationNumber" placeholder="123 4564 8797" v-model.trim="candidate.identificationNumber" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Address :
         <input type="text" name="address" id="address" placeholder="120 street of " v-model.trim="candidate.address" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Phone :
         <input type="text" name="phone" id="phone" placeholder="+xx 012345678" v-model.trim="candidate.phone" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Email :
         <input type="email" name="email" id="email" placeholder="email@email.com" v-model.trim="candidate.email" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Birth Date :
         <input type="date" name="birthDateStr" id="birthDateStr" v-model.trim="candidate.birthDateStr" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Observation :
         <input type="text" name="observation" id="observation" v-model.trim="candidate.observation" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Rating :
         <input type="number" max="10" name="rating" id="rating" v-model.trim="candidate.rating" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         Skills :
         <input type="text" name="skills" id="skills" v-model.trim="candidate.skills" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         TechnicalArea :
         <input type="text" name="technicalArea" id="technicalArea" v-model.trim="candidate.technicalArea" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
         JobInterviewDateStr :
         <input type="date" name="jobInterviewDateStr" id="jobInterviewDateStr" v-model.trim="candidate.jobInterviewDateStr" required
         class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
      </label>
      <button class="bg-green-500 hover:bg-green-700 text-white font-bold py-1 px-3 mx-2 rounded">submit</button>
   </form>
   </div>
  
</template>

<script setup>

import { useCandidateStore } from '@/stores/CandidateStore';
import{onBeforeMount, onMounted, ref}from 'vue';
import { useRoute, useRouter } from 'vue-router';

const candidateStore = useCandidateStore();
const router = useRouter()

const candidate = ref({
   name:"",
   identificationNumber:"",
   address:"",
   phone:"",
   email:"",
   birthDateStr:"",
   observation:"",
   rating:0,
   skills:"",
   technicalArea:"",
   jobInterviewDateStr:"",
})

const id = ref(0);



onMounted(async ()=>{
   const route = useRoute();
   const {idCandidate} = route.params
   id.value = idCandidate
   if(idCandidate != undefined){
      const candidateFind = await candidateStore.findCandidate(idCandidate);
      candidate.value = candidateFind;
      candidate.value.birthDateStr = candidateFind.birthDate
      candidate.value.jobInterviewDateStr = candidateFind.jobInterviewDateStr
   }
   
})

const submitForm = () => {
   if(id.value!== undefined){
      candidateStore.updateCandidate(id,candidate.value)
   }else{
      candidateStore.postCandidate(candidate.value)
   }
   router.go(-1)
}


</script>
