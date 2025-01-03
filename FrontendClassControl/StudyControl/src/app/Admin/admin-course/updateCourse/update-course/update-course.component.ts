import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Course } from '../../../../models/Course';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminserviceService } from '../../../../service/adminservice.service';

@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrl: './update-course.component.css'
})
export class UpdateCourseComponent  implements OnInit {
  /*course: Course = new Course();
  courseId: number = 0;

  constructor(private route: ActivatedRoute, private service: AdminserviceService, private router: Router) { }
  
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


  onSubmit() {
    this.updateCourse();
  }

  updateCourse() {
    this.service.updateCourse(this.course).subscribe((data) => {
      this.course = new Course();
      this.gotoList();
    });
  }

  gotoList() {
    this.router.navigate(['course-list']);
  }
}*/
course: Course = new Course();
  courseId: number = 0;

  constructor(
    private route: ActivatedRoute, 
    private service: AdminserviceService, 
    private router: Router
  ) { }

  ngOnInit(): void {
    this.courseId = this.route.snapshot.params['id'];
    this.service.getCourseById(this.courseId).subscribe((data: Course) => {
      this.course = data;
    });
  }

  onSubmit() {
    this.updateCourse();
  }

  updateCourse() {
    this.service.updateCourse(this.course).subscribe(() => {
      this.gotoList();
    });
  }

  gotoList() {
    this.router.navigate(['/course-list']);
  }
}