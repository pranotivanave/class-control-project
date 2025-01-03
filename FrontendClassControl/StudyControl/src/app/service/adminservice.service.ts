import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from '../models/Course';
import { ClassroomCreateRequest } from '../models/ClassroomCreateRequest';
import { Classroom } from '../models/Classroom';
import { ClassroomUpdateRequest } from '../models/ClassroomUpdateRequest';
import { Teacher } from '../models/Teacher';


@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {
 

  baseUrl = "http://localhost:8091";
  getCourseById: any;
  constructor(private http: HttpClient) { }

  //---------------admin managing courses--------------------------------------------------------

  createCourse(course: Object): Observable<Object> {
    console.log('create admin service');
    return this.http.post(`${this.baseUrl}/course/create`, course);
  }


  getAllCourse(): any {
    console.log("inside service");
    return this.http.get(`${this.baseUrl}/getAllCourses`);
  }

  /*
  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.baseUrl}/course/${id}`);
  }
  */

  updateCourse(course: Course): Observable<Object> {
    console.log("inside admin course update");
    return this.http.put(`${this.baseUrl}/course/update`, course);
  }

  deleteCourse(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/course/delete/${id}`, { responseType: 'text' });
  }

  //---------------admin managing classrooms--------------------------------------------------------

  createClassroom(classroom: ClassroomCreateRequest): Observable<Object> {
    console.log('inside admin service');
    return this.http.post(`${this.baseUrl}/classroom/create`, classroom);
  }


  getAllClassroom(): any {
    console.log("inside admin-classroom list");
    return this.http.get(`${this.baseUrl}/getAllClassrooms`);
  }

  updateClassroom(classroom: ClassroomUpdateRequest): Observable<Object> {
    console.log("inside admin classroom update");
    return this.http.put(`${this.baseUrl}/classroom/create`, classroom);
  }

  deleteClassroom(id: number): Observable<any> {
    console.log("inside admin classroom delete");
    return this.http.delete(`${this.baseUrl}/classroom/delete/${id}`);
  }


  //---------------admin managing teachers--------------------------------------------------------

  getAllTeachers(): any {
    console.log("inside admin-teacher list");
    return this.http.get(`${this.baseUrl}/getAllTeachers`);
  }

  generatePasswordForTeacher(teacherId: number): Observable<string> {
    const url = `${this.baseUrl}/generatePasswordForTeacher/${teacherId}`;
    return this.http.post<string>(url, null, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  addTeacherToCourse(teacherId: number, courseId: number): Observable<string> {
    const url = `${this.baseUrl}/admin/addTeacherToCourse/${teacherId}/${courseId}`;
    const body = { teacherId, courseId };
    return this.http.post<string>(url, body, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }
}




















