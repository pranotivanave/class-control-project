import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-teacher',
  templateUrl: './admin-teacher.component.html',
  styleUrl: './admin-teacher.component.css'
})
export class AdminTeacherComponent {
  constructor(private router:Router){}
  

  generatePasswordForTeacher(){
    console.log("Inside admin teacher generate password");
    this.router.navigate(['generateForTeacher']);
  }

}
