import { Component } from '@angular/core';
import { AdminserviceService } from '../../../service/adminservice.service';
import { Router } from '@angular/router';
import { Teacher } from '../../../models/Teacher';

@Component({
  selector: 'app-generate-password-for-teacher',
  templateUrl: './generate-password-for-teacher.component.html',
  styleUrl: './generate-password-for-teacher.component.css'
})
export class GeneratePasswordForTeacherComponent {

  teacher = new Teacher();

  constructor(private router:Router, private service:AdminserviceService){}

  generatePassword(teacherId: number): void {
    this.service.generatePasswordForTeacher(teacherId).subscribe({
      next: (response) => {
        console.log(response); // Handle success
        alert(response);
      },
      error: (error) => {
        console.error(error); // Handle error
        alert('Failed to generate password');
      }
    });
  }

}
