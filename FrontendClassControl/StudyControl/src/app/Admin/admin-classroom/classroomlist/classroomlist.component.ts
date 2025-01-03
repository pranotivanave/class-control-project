import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminserviceService } from '../../../service/adminservice.service';
import { Classroom } from '../../../models/Classroom';
import { Observable, of } from 'rxjs';


@Component({
  selector: 'app-classroomlist',
  templateUrl: './classroomlist.component.html',
  styleUrl: './classroomlist.component.css'
})
export class ClassroomlistComponent implements OnInit {

  public classrooms: Observable<Classroom[]> = of([]);

  constructor(private service: AdminserviceService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.classrooms = this.service.getAllClassroom();
  }

  updateClassroom(classroomId: number): void {
    //this.router.navigate(['/update-classroom', classroomId]);
    this.router.navigate([`/admin-classroom/update-classroom/${classroomId}`]);
  }

  deleteClassroom(classroomId: number): void {
    this.service.deleteClassroom(classroomId).subscribe(() => {
      console.log('Classroom deleted successfully');
      this.getAll();
    });
  }

}
