import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Course } from '../../../models/Course';
import { AdminserviceService } from '../../../service/adminservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css'
})
export class CourseListComponent implements OnInit {

  public courses: Observable<Course[]> = of([]);

  constructor(private service: AdminserviceService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.courses = this.service.getAllCourse();
  }
/*
  updateCourse(courseId: number): void {
    this.router.navigate(['/update-course', courseId]);
  }*/

  updateCourse(courseId: number): void {
    this.router.navigate(['/admin-courses/update-course', courseId]);
  }

  deleteCourse(courseId: number): void {
    this.service.deleteCourse(courseId).subscribe(() => {
      console.log('Course deleted successfully');
      this.getAll();
    });
  }


}