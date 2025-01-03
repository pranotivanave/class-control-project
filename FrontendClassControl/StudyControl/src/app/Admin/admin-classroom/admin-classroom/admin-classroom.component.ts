import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin-classroom',
  templateUrl: './admin-classroom.component.html',
  styleUrl: './admin-classroom.component.css'
})
export class AdminClassroomComponent {
/*
showCreateClassroomForm= false;

constructor(private router: Router) {}

createClassroom() {
  this.showCreateClassroomForm=true;
  this.router.navigate(['create-classroom']);
}
  
  
getAllClassroom() {
  this.showCreateClassroomForm = false;
  this.router.navigate(['classroom-list']);
}



}*/


/*
showCreateClassroomForm = false;

  constructor(private router: Router) {}

  createClassroom() {
    this.showCreateClassroomForm = true;
    this.router.navigate(['admin-classroom/create-classroom']);
  }

  getAllClassroom() {
    this.showCreateClassroomForm = false;
    this.router.navigate(['admin-classroom/classroom-list']);
  }
}*/

showCreateClassroomForm = false;

  constructor(private router: Router) {}

  createClassroom() {
    this.showCreateClassroomForm = true;
    this.router.navigate(['admin-classroom/create-classroom']);
  }

  getAllClassroom() {
    this.showCreateClassroomForm = false;
    this.router.navigate(['admin-classroom/classroom-list']);
  }
}
