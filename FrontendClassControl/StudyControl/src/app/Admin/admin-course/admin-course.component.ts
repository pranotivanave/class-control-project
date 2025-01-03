import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-course',
  templateUrl: './admin-course.component.html',
  styleUrl: './admin-course.component.css'
})
export class AdminCourseComponent {



showCreateCourseForm = false;

constructor(private router: Router) {}

createCourse() {
  this.showCreateCourseForm = true;
}

getAllCourse() {
  this.showCreateCourseForm = false;
  this.router.navigate(['admin-courses/list']);
}

updateCourse(courseId: string) {  // Assuming a course ID is needed
  this.showCreateCourseForm = false;
  this.router.navigate(['admin-courses/update-course', courseId]);
}
}