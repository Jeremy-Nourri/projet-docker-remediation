import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ShowEmployee from '../views/employee/ShowEmployee.vue'
import FormEmployee from '../views/employee/FormEmployee.vue'
import ShowCandidate from '../views/candidate/ShowCandidate.vue'
import FormCandidate from '../views/candidate/FormCandidate.vue'
import AbsenseForm from '../views/absense/FormAbsense.vue'
import VacationForm from '../views/Vacation/FormVacation.vue'
import EmployeeDetail from '../views/employee/EmployeeDetails.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {path: '/',component: HomeView},
    {path:'/employee',component: ShowEmployee},
    {path: '/employee/update/:idEmployee', component: FormEmployee},
    {path:'/employee/add',component: FormEmployee},
    {path:'/candidate',component: ShowCandidate},
    {path:'/candidate/add',component: FormCandidate},
    {path: '/candidate/update/:idCandidate', component: FormCandidate},
    {path: '/employee/:idemployee/absense/add', component: AbsenseForm},
    {path: '/employee/:idemployee/vacation/add', component: VacationForm},
    {path: '/employee/:idEmployee/details', component: EmployeeDetail},

  ]
})

export default router
