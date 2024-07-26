<template>

    <div class="grid grid-cols-5 grid-rows-1 border border-slate-300 px-4 py-2 mx-5 my-2 rounded">
        <p>{{employee.name}}</p>
        <p>{{employee.identificationNumber}}</p>
        <p>{{employee.email}}</p>
        <div class="col-span-2">
            <button class="bg-green-500 hover:bg-green-700 text-white font-bold py-1 px-3 mx-2 rounded" @click="detailsEmployee">
                Details
            </button>
            <button class="bg-red-500 hover:bg-red-700 text-white font-bold py-1 px-3 mx-2 rounded" @click="deleteEmployee">
                Delete
            </button>
            <button class="bg-cyan-500 hover:bg-cyan-700 text-white font-bold py-1 px-3 mx-2 rounded" @click="editEmployee">
                Update
            </button>
            <button class="bg-orange-500 hover:bg-orange-700 text-white font-bold py-1 px-3 mx-2 rounded" @click="addAbsence">
                + Absence
            </button>
            <button class="bg-emerald-500 hover:bg-emerald-700 text-white font-bold py-1 px-3 mx-2 rounded" @click="addVacation">
                + Vacation
            </button>
        </div>
    </div>

</template>

<script setup>
import { useEmployeeStrore } from '@/stores/EmployeeStore';
import {useRouter } from 'vue-router';

const router = useRouter();

const employeeStore = useEmployeeStrore();

const {employee} = defineProps(["employee"])


const detailsEmployee = ()=>{
    router.push(`/employee/${employee.id}/details`)
}

const deleteEmployee = ()=>{
    employeeStore.deleteEmployee(employee.id)
    router.push("/employee")
}
const editEmployee = ()=>{
    router.push(`/employee/update/${employee.id}`)
}
const addAbsence = ()=>{
    router.push(`/employee/${employee.id}/absense/add`)
}
const addVacation = ()=>{
    router.push(`/employee/${employee.id}/vacation/add`)
}

</script>
