// src/app/components/create-course/createcourse.component.ts
import { Component } from '@angular/core';

import { Course } from '../../../models/Course';
import { AdminserviceService } from '../../../service/adminservice.service';

@Component({
  selector: 'app-createcourse',
  templateUrl: './createcourse.component.html',
  styleUrls: ['./createcourse.component.css']
})
export class CreatecourseComponent {

 /*course: Course = new Course();
  submitted = false;

  constructor(private service: AdminserviceService) {}

  onSubmit() {
    this.submitted = true;
    this.createCourse();
  }

  createCourse() {
    console.log("inside create course");
    this.service.createCourse(this.course).subscribe({
      next: (data) => {
        console.log('Course created successfully', data);
        // Handle the success case, e.g., reset the form, show a message, etc.
      },
      error: (error) => {
        console.error('Error creating course', error);
        // Handle the error case
      }

      
    });
  }
 
}*/


/*course: Course = new Course();
submitted = false;
formVisible = false; // Add this variable to control form visibility

constructor(private service: AdminserviceService) {}

onSubmit() {
  this.submitted = true;
  this.createCourse();
}

createCourse() {
  console.log("inside create course");
  this.service.createCourse(this.course).subscribe({
    next: (data) => {
      console.log('Course created successfully', data);
      // Handle the success case, e.g., reset the form, show a message, etc.
    },
    error: (error) => {
      console.error('Error creating course', error);
      // Handle the error case
    }
  });
}

toggleFormVisibility() {
  this.formVisible = !this.formVisible; // Toggle form visibility
}
}*/


/*
course: Course = new Course();
  submitted = false;

  constructor(private service: AdminserviceService) {}

  onSubmit() {
    this.submitted = true;
    this.createCourse();
  }

  createCourse() {
    console.log("inside create course");
    this.service.createCourse(this.course).subscribe({
      next: (data) => {
        console.log('Course created successfully', data);
        // Handle the success case, e.g., reset the form, show a message, etc.
      },
      error: (error) => {
        console.error('Error creating course', error);
        // Handle the error case
      }
    });
  }
}*/

course: Course = new Course();
  submitted = false;

  constructor(private service: AdminserviceService) {}

  onSubmit() {
    this.submitted = true;
    this.createCourse();
  }

  createCourse() {
    console.log("inside create course");
    this.service.createCourse(this.course).subscribe({
      next: (data) => {
        console.log('Course created successfully', data);
        // Handle the success case, e.g., reset the form, show a message, etc.
      },
      error: (error) => {
        console.error('Error creating course', error);
        // Handle the error case
      }
    });
  }
}