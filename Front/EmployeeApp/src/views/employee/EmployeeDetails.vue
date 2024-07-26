<template>
    <div>
        <section>
            <div class="grid grid-cols-2 grid-rows-1 border border-slate-300 px-4 py-2 mx-5 my-2 rounded">
                <p>Name : {{ employeeFind.name }}</p>
                <p>Id number : {{ employeeFind.identificationNumber }}</p>
                <p>Email : {{ employeeFind.email }}</p>
                <p>Phone: {{ employeeFind.phone }}</p>
                <p>Address: {{ employeeFind.address }}</p>
                <p>Birth date: {{ employeeFind.birthDate }}</p>
                <p>date start contract: {{ employeeFind.contractStartDate }}</p>
                <p>date end contract: {{ employeeFind.contractEndDate }}</p>


            </div>
        </section>

        <section>
            <div>
                <VacationComponent v-for="vacation in vacations" :key="vacation.id" :vacation="vacation" />
            </div>
        </section>

        <section>
            <div>
                <AbsenseComponent v-for="absense in absenses" :key="absense.id" :absense="absense" />
            </div>
        </section>

        <div class="flex justify-center">
            <button @click="goBack"
                class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-1 px-3 mx-2 rounded">Back</button>
        </div>

    </div>
</template>

<script setup>
import { useAbsenseStore } from '@/stores/AbsenseStore';
import { useEmployeeStrore } from '@/stores/EmployeeStore';
import { useVacationStore } from '@/stores/VacationStore';
import VacationComponent from '../../components/VacationComponent.vue'
import AbsenseComponent from '../../components/AbsenseComponent.vue'
import { onBeforeMount, onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';


const employeeStore = useEmployeeStrore()
const vacationsStore = useVacationStore()
const AbsenseStore = useAbsenseStore()

const router = useRouter()

const employeeFind = ref({})
const vacations = ref([])
const absenses = ref([])

onMounted(async () => {
    const route = useRoute();
    const { idEmployee } = route.params
    if (idEmployee !== undefined) {
        employeeFind.value = await employeeStore.findEmployee(idEmployee);
        vacations.value = await vacationsStore.getVacationByEmployee(idEmployee)
        absenses.value = await AbsenseStore.getAbsenseByEmployee(idEmployee)

    }

})

const goBack = () => {
    router.go(-1)
}

</script>
