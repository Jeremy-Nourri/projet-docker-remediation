<script setup>
import { useCandidateStore } from '@/stores/CandidateStore';
import { useEmployeeStrore } from '@/stores/EmployeeStore';
import { onBeforeMount, onMounted, ref } from 'vue';

const employeeStore = useEmployeeStrore();
const candidateStore = useCandidateStore();

onMounted(async ()=>{
  await employeeStore.fetchEmployee();
  await candidateStore.fetchCandidate();
})
</script>

<template>
  
  <main>
    <div>
      <p>Number of Employees</p>
      <p>{{ employeeStore.numberEmployee }}</p>
    </div>
    <div>
      <p>Number of Candidate</p>
      <p>{{ candidateStore.numberCandidate }}</p>
    </div>
  </main>
</template>
