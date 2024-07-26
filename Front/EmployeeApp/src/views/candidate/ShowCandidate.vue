<template>
    <section class="mx-5 my-2">
        <button class="bg-blue-700 hover:bg-blue-900 text-white font-bold py-2 px-4 mx-2 rounded">
            <RouterLink to="/candidate/add">+ Candidate</RouterLink>
        </button>
    </section>
    <section>
        <div>
            <CandidateComponent 
            v-for="candidate in candidateStore.candidates"
            :key="candidate.id"
            :candidate = "candidate" />
        </div>
    </section>
</template>

<script setup>
import { useCandidateStore } from '@/stores/CandidateStore';
import CandidateComponent from '../../components/CandidateComponent.vue'
import { onBeforeMount, onMounted } from 'vue';

const candidateStore = useCandidateStore();

onMounted(async ()=>{
  await candidateStore.fetchCandidate();
})

</script>
