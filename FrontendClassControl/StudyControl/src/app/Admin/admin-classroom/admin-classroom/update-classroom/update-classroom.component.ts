import { Component } from '@angular/core';
import { Classroom } from '../../../../models/Classroom';
import { ClassroomUpdateRequest } from '../../../../models/ClassroomUpdateRequest';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminserviceService } from '../../../../service/adminservice.service';

@Component({
  selector: 'app-update-classroom',
  templateUrl: './update-classroom.component.html',
  styleUrl: './update-classroom.component.css'
})
export class UpdateClassroomComponent {

  classroom: Classroom = new Classroom();
  submitted = false;
  teacher_Id: number = 0;
  
  constructor(private route: ActivatedRoute, private service: AdminserviceService, private router: Router) { }
  
  onSubmit() {
    this.submitted = true;
    this.updateClassroom();
  }

  updateClassroom() {
    console.log("inside create classroom");
    const classroomUpdateRequest: ClassroomUpdateRequest = {
      classroomId:this.classroom.classroom_Id,
      teacherId: this.teacher_Id,
      classroomName: this.classroom.classroom_Name,
      classroomDescription: this.classroom.classroom_Description
    };
    this.service.updateClassroom(classroomUpdateRequest).subscribe({
      next: (data) => {
        console.log('Classroom updated successfully', data);
        // Handle the success case, e.g., reset the form, show a message, etc.
        this.submitted = false;
        this.classroom = new Classroom();
        this.gotoList();
         // Reset the form
      },
      error: (error) => {
        console.error('Error creating classroom', error);
        // Handle the error case
        this.submitted = false;
      }
    });
  }

  gotoList() {
    this.router.navigate(['classroom-list']);
  }

}
