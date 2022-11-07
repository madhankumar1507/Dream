import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerhomeComponent } from './customerhome/customerhome.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: '', redirectTo:'/login',pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'customerhome',component:CustomerhomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
