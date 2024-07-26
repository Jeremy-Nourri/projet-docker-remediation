import axios from "axios";
import { defineStore } from "pinia";
import { ref } from "vue";

export const useAbsenseStore = defineStore('absense',()=>{
    const absense = ref([]);

    const fetchAbsense = async ()=>{
        try{
            const response = await axios.get('http://localhost:8080/absenses/all')
        
            const data = response.data
            absense.value = data;
        
            
                  
        }catch(error){
            console.error('Error fetching absense',error);
        }
    }

    const postAbsense = async (absense)=>{
        try{
            await axios.post('http://localhost:8080/absenses/save',absense,{
                headers: {
                  'Content-Type': 'application/json'
                }})
            fetchAbsense()

        }catch(error){
            console.log('Error Posting absense', error);
        }
    }

    const getAbsenseByEmployee = async (idEmployee)=>{
        try{
            const response = await axios.get('http://localhost:8080/absenses/employee/'+idEmployee)
            return response.data;
        }catch(error){
            console.log('Error Getting Absense ',error);
        }
    }


    return{absense,fetchAbsense,postAbsense,getAbsenseByEmployee}
})