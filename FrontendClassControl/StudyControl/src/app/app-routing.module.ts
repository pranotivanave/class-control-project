
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Home/home/home.component';
import { AboutComponent } from './Home/about/about.component';
import { ContactComponent } from './Home/contact/contact.component';
import { AdminLoginComponent } from './Admin/admin-login/admin-login.component';
import { AdminDashboardComponent } from './Admin/admin-dashboard/admin-dashboard.component';
import { AdminCourseComponent } from './Admin/admin-course/admin-course.component';
import { CreatecourseComponent } from './Admin/admin-course/createcourse/createcourse.component';
import { CourseListComponent } from './Admin/admin-course/course-list/course-list.component';
import { UpdateCourseComponent } from './Admin/admin-course/updateCourse/update-course/update-course.component';
import { CreateClassroomComponent } from './Admin/admin-classroom/create-classroom/create-classroom.component';
import { UpdateClassroomComponent } from './Admin/admin-classroom/admin-classroom/update-classroom/update-classroom.component';
import { ClassroomlistComponent } from './Admin/admin-classroom/classroomlist/classroomlist.component';
import { AdminClassroomComponent } from './Admin/admin-classroom/admin-classroom/admin-classroom.component';
import { GeneratePasswordForTeacherComponent } from './Admin/admin-teacher/generate-password-for-teacher/generate-password-for-teacher.component';
import { AdminTeacherComponent } from './Admin/admin-teacher/admin-teacher/admin-teacher.component';

/*const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'admin-login', component: AdminLoginComponent },
  { path: 'admin-dashboard', component: AdminDashboardComponent },

  {
    path: 'admin-courses', component: AdminCourseComponent, children: [
      { path: 'create', component: CreatecourseComponent },
      { path: 'list', component: CourseListComponent },
      { path: 'update-course/:courseId', component: UpdateCourseComponent },

      { path: 'admin-classroom', component: AdminClassroomComponent },
      { path: 'create-classroom', component: CreateClassroomComponent },
      { path: 'update-classroom', component: UpdateClassroomComponent },
      { path: 'classroom-list', component: ClassroomlistComponent },

      {path:'admin-teacher', component:AdminTeacherComponent},
      {path:'generateForTeacher', component:GeneratePasswordForTeacherComponent}

    ]
  },
];*/

const routes: Routes = [
{ path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'admin-login', component: AdminLoginComponent },
  { path: 'admin-dashboard', component: AdminDashboardComponent },
  {
    path: 'admin-courses', component: AdminCourseComponent, children: [
      { path: 'create', component: CreatecourseComponent },
      { path: 'list', component: CourseListComponent },
      { path: 'update-course/:courseId', component: UpdateCourseComponent },
    ]
  },

  {
    path: 'admin-classroom', component: AdminClassroomComponent, children: [
      { path: 'create-classroom', component: CreateClassroomComponent },
      { path: 'update-classroom/:classroomId', component: UpdateClassroomComponent },
      { path: 'classroom-list', component: ClassroomlistComponent },
    ]
  },
  {
    path: 'admin-teacher', component: AdminTeacherComponent, children: [
      { path: 'generate-password', component: GeneratePasswordForTeacherComponent },
    ]
  },
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
