import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../../../service/adminservice.service';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Teacher } from '../../../models/Teacher';

@Component({
  selector: 'app-teacher-list',
  templateUrl: './teacher-list.component.html',
  styleUrl: './teacher-list.component.css'
})
export class TeacherListComponent implements OnInit {


  public teachers: Observable<Teacher[]> = of([]);

  constructor(private service: AdminserviceService, private router: Router) { }
  
  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.teachers = this.service.getAllTeachers();
  }

 


}
