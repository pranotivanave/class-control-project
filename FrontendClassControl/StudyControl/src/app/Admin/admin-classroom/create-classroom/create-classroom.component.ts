import { Component } from '@angular/core';
import { Classroom } from '../../../models/Classroom';
import { AdminserviceService } from '../../../service/adminservice.service';
import { ClassroomCreateRequest } from '../../../models/ClassroomCreateRequest';

@Component({
  selector: 'app-create-classroom',
  templateUrl: './create-classroom.component.html',
  styleUrl: './create-classroom.component.css'
})
export class CreateClassroomComponent {

  /*classroom: Classroom = new Classroom();
  submitted = false;
  course_Id: number = 0;
  teacher_Id: number = 0;

  constructor(private service: AdminserviceService) {}

  onSubmit() {
    this.submitted = true;
    this.createClassroom();
  }

  createClassroom() {
    console.log("inside create classroom");
    const classroomRequest: ClassroomCreateRequest = {
      courseId: this.course_Id,
      teacherId: this.teacher_Id,
      classroomName: this.classroom.classroom_Name,
      classroomDescription: this.classroom.classroom_Description
    };
    this.service.createClassroom(classroomRequest).subscribe({
      next: (data) => {
        console.log('Classroom created successfully', data);
        // Handle the success case, e.g., reset the form, show a message, etc.
        this.submitted = false;
        this.classroom = new Classroom(); // Reset the form
      },
      error: (error) => {
        console.error('Error creating classroom', error);
        // Handle the error case
        this.submitted = false;
      }
    });
  }

}*/




classroom: Classroom = new Classroom();
  submitted = false;
  course_Id: number = 0;
  teacher_Id: number = 0;

  constructor(private service: AdminserviceService) {}

  onSubmit() {
    this.submitted = true;
    this.createClassroom();
  }

  createClassroom() {
    const classroomRequest: ClassroomCreateRequest = {
      courseId: this.course_Id,
      teacherId: this.teacher_Id,
      classroomName: this.classroom.classroom_Name,
      classroomDescription: this.classroom.classroom_Description
    };
    this.service.createClassroom(classroomRequest).subscribe({
      next: (data) => {
        console.log('Classroom created successfully', data);
        this.submitted = false;
        this.classroom = new Classroom(); // Reset the form
      },
      error: (error) => {
        console.error('Error creating classroom', error);
        this.submitted = false;
      }
    });
  }
}
