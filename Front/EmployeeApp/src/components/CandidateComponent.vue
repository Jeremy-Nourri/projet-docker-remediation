<template>

    <div class="grid grid-cols-5 grid-rows-1 border border-slate-300 px-4 py-2 mx-5 my-2 rounded">
        <p>{{candidate.name}}</p>
        <p>{{candidate.identificationNumber}}</p>
        <p>{{candidate.email}}</p>
        <div class="col-span-2">
            <button class="bg-green-500 hover:bg-green-700 text-white font-bold py-1 px-3 mx-2 rounded" @click="detailsCandidate">
                Details
            </button>
            <button class="bg-red-500 hover:bg-red-700 text-white font-bold py-1 px-3 mx-2 rounded" @click="deleteCandidate">
                Delete
            </button>
            <button class="bg-cyan-500 hover:bg-cyan-700 text-white font-bold py-1 px-3 mx-2 rounded" @click="editCandidate">
                Update
            </button>
        </div>
    </div>

</template>

<script setup>
import { useCandidateStore } from '@/stores/CandidateStore';
import {useRouter } from 'vue-router';

const router = useRouter();

const candidateStore = useCandidateStore();

const {candidate} = defineProps(["candidate"])


const detailsCandidate = ()=>{
    router.push(`/candidate/details/${candidate.id}`)
}

const deleteCandidate = ()=>{
    candidateStore.deleteCandidate(candidate.id)
    router.go(0)
}
const editCandidate = ()=>{
    router.push(`/candidate/update/${candidate.id}`)
}

</script>
