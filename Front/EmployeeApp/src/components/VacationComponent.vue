<template>
    <div class="grid grid-cols-3 grid-rows-1 border border-slate-300 px-4 py-2 mx-5 my-2 rounded bg-blue-300 text-white">
        <div>
            Vacation
        </div>
        
        <div>
            {{ vacation.start }}
        </div>

        <div>
            {{ vacation.end }}
        </div>
    </div>
</template>

<script setup>

const {vacation} = defineProps(["vacation"])


</script>
