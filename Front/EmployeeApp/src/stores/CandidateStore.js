import axios from "axios";
import { defineStore } from "pinia";
import { ref } from "vue";

export const useCandidateStore = defineStore('candidate',()=>{
    const candidates = ref([]);
    const numberCandidate = ref(0);

    const fetchCandidate = async ()=>{
        try{
            const response = await axios.get('http://localhost:8080/candidates/all')
        
            const data = response.data
            candidates.value = data;
            numberCandidate.value = candidates.value.length;
            
                  
        }catch(error){
            console.error('Error fetching employee',error);
        }
    }

    const postCandidate = async (candidate)=>{
        try{
            console.log(candidate);
            await axios.post('http://localhost:8080/candidates/save',candidate,{
                headers: {
                  'Content-Type': 'application/json'
                }})
            fetchCandidate()

        }catch(error){
            console.log('Error Posting employe', error);
        }
    }

    const updateCandidate = async (id,candidate)=>{
        try{
            await axios.put('http://localhost:8080/candidates/edit/'+id,candidate,{
                headers: {
                  'Content-Type': 'application/json'
                }})
            fetchCandidate()

        }catch(error){
            console.log('Error Posting employe', error);
        }
    }

    const findCandidate = async (idCandidate)=>{
        try{
            
            const response = await axios.get('http://localhost:8080/candidates/details/'+idCandidate)
            return response.data

        }catch(error){
            console.log('Error Posting employee', error);
        }
    }

    const deleteCandidate = async (idCandidate)=>{
        try{
            await axios.delete('http://localhost:8080/candidates/delete/'+idCandidate)
            fetchCandidate()
        }catch(error){
            console.log('Error Deleting employee',error);
        }
    }

    return{candidates,numberCandidate,fetchCandidate,findCandidate,deleteCandidate,updateCandidate,postCandidate}
})