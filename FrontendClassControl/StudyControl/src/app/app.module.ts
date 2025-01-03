import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Home/home/home.component';
import { FooterComponent } from './Home/footer/footer.component';
import { ContactComponent } from './Home/contact/contact.component';
import { AboutComponent } from './Home/about/about.component';
import { HeaderComponent } from './Home/header/header.component';
import { AdminLoginComponent } from './Admin/admin-login/admin-login.component';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminDashboardComponent } from './Admin/admin-dashboard/admin-dashboard.component';
import { AdminCourseComponent } from './Admin/admin-course/admin-course.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { CreatecourseComponent } from './Admin/admin-course/createcourse/createcourse.component';
import { CourseListComponent } from './Admin/admin-course/course-list/course-list.component';
import { UpdateCourseComponent } from './Admin/admin-course/updateCourse/update-course/update-course.component';
import { AdminSiderbarComponent } from './Admin/admin-siderbar/admin-siderbar.component';
import { ClassroomlistComponent } from './Admin/admin-classroom/classroomlist/classroomlist.component';
import { CreateClassroomComponent } from './Admin/admin-classroom/create-classroom/create-classroom.component';

import { UpdateClassroomComponent } from './Admin/admin-classroom/admin-classroom/update-classroom/update-classroom.component';
import { AdminClassroomComponent } from './Admin/admin-classroom/admin-classroom/admin-classroom.component';
import { AdminTeacherComponent } from './Admin/admin-teacher/admin-teacher/admin-teacher.component';
import { TeacherListComponent } from './Admin/admin-teacher/teacher-list/teacher-list.component';
import { GeneratePasswordForTeacherComponent } from './Admin/admin-teacher/generate-password-for-teacher/generate-password-for-teacher.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    ContactComponent,
    AboutComponent,
    AdminLoginComponent,
    AdminDashboardComponent,
    AdminCourseComponent,
    CreatecourseComponent,
    CourseListComponent,
    UpdateCourseComponent,
    AdminSiderbarComponent,
    ClassroomlistComponent,
    CreateClassroomComponent,
    AdminClassroomComponent,
    UpdateClassroomComponent,
    AdminTeacherComponent,
    TeacherListComponent,
    GeneratePasswordForTeacherComponent
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
   
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
