import axios from "axios";
import { defineStore } from "pinia";
import { ref } from "vue";

export const useVacationStore = defineStore('vacation',()=>{
    const vacation = ref([]);

    const fetchVacation = async ()=>{
        try{
            const response = await axios.get('http://localhost:8080/vacations/all')
        
            const data = response.data
            vacation.value = data;
        
            
                  
        }catch(error){
            console.error('Error fetching absense',error);
        }
    }

    const postVacation = async (vacation)=>{
        try{
            await axios.post('http://localhost:8080/vacations/save',vacation,{
                headers: {
                  'Content-Type': 'application/json'
                }})
            fetchVacation()

        }catch(error){
            console.log('Error Posting absense', error);
        }
    }

    const getVacationByEmployee = async (idEmployee)=>{
        try{
            const response = await axios.get('http://localhost:8080/vacations/employee/'+idEmployee)
            return response.data;
        }catch(error){
            console.log('Error Getting Vacation ',error);
        }
    }



    return{vacation,fetchVacation,postVacation,getVacationByEmployee}
})