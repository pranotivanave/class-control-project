import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivationEnd, NavigationEnd, Router } from '@angular/router';
// import { ActivationEnd, Router } from '@angular/router';

import { filter } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
//export class AppComponent {
  //title = 'StudyControl';
 /* hideHeader: boolean = false;
  hideFooter: boolean = false;

  constructor(private router: Router) {
    this.router.events
      .pipe(
        filter((event): event is ActivationEnd => event instanceof ActivationEnd)
      )
      .subscribe((event: ActivationEnd) => {
        this.hideHeader = event.snapshot.data['hideHeader'] || false;
      });*/
      
      export class AppComponent
{
      isLoggedIn: boolean = false;
      isLoginPage: boolean = false;
    
      constructor(private router: Router) {
        this.router.events.subscribe((event) => {
          if (event instanceof NavigationEnd) {
            this.checkLoginStatus(event.urlAfterRedirects);
            this.checkLoginPage(event.urlAfterRedirects);
          }
        });
      }
    
      private checkLoginStatus(url: string): void {
        // Check if the user is logged in based on the URL or other criteria
        // For demonstration purposes, let's assume the user is logged in if the URL contains '/admin',
        // '/teacher', or '/student'
        this.isLoggedIn = url.includes('/admin') || url.includes('/teacher') || url.includes('/student');
      }
    
      private checkLoginPage(url: string): void {
        // Check if the current page is a login page for admin, teacher, or student
        this.isLoginPage = url.includes('/admin-login') || url.includes('/teacher-login') || url.includes('/student-login');
      }
    }