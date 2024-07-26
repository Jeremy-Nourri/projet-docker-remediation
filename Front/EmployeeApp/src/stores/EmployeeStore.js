import axios from "axios";
import { defineStore } from "pinia";
import { ref } from "vue";

export const useEmployeeStrore = defineStore('employee',()=>{
    const employees = ref([]);
    const numberEmployee = ref(0);

    const fetchEmployee = async ()=>{
        try{
            const response = await axios.get('http://localhost:8080/employees/all')
        
            const data = response.data
            employees.value = data;
            numberEmployee.value = employees.value.length;
            
                  
        }catch(error){
            console.error('Error fetching employee',error);
        }
    }

    const postEmployee = async (employee)=>{
        try{
            console.log(employee);
            await axios.post('http://localhost:8080/employees/save',employee,
                {
                headers: {
                  'Content-Type': 'application/json'
                }})
            fetchEmployee();

        }catch(error){
            console.log('Error Posting employe', error);
        }
    }

    const updateEmployee = async (id,employee)=>{
        try{
            await axios.put('http://localhost:8080/employees/edit/'+id,employee,{
                headers: {
                  'Content-Type': 'application/json'
                }})
            fetchEmployee();

        }catch(error){
            console.log('Error Posting employe', error);
        }
    }

    const findEmployee = async (idEmployee)=>{
        try{
            
            const response = await axios.get('http://localhost:8080/employees/details/'+idEmployee)
            return response.data

        }catch(error){
            console.log('Error Posting employee', error);
        }
    }

    const deleteEmployee = async (idEmployee)=>{
        try{
            await axios.delete('http://localhost:8080/employees/delete/'+idEmployee)
            fetchEmployee();
        }catch(error){
            console.log('Error Deleting employee',error);
        }
    }

    return{employees,numberEmployee,fetchEmployee,postEmployee,findEmployee,updateEmployee,deleteEmployee}
})
