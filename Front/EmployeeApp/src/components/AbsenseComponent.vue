<template>
    <div class="grid grid-cols-2 grid-rows-1 border border-slate-300 px-4 py-2 mx-5 my-2 rounded bg-orange-300 text-white">
        <div>
            Absense
        </div>
        
        <div>
            {{ absense.date }}
        </div>

    </div>
</template>

<script setup>

const {absense} = defineProps(["absense"])


</script>
