import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {

loginForm: FormGroup;
  loginError: string | null = null;
  loginSuccessMessage: string | null = null;

  private readonly correctUsername = 'admin';
  private readonly correctPassword = 'admin123';

  constructor(private fb: FormBuilder, private router: Router) {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
    const username = this.loginForm.get('username')?.value;
    const password = this.loginForm.get('password')?.value;

    if (this.loginForm.valid) {
      if (username === this.correctUsername && password === this.correctPassword) {
        console.log('Login successful');
        this.loginSuccessMessage = 'Login successful';
        setTimeout(() => { // Delay navigation to ensure success message is visible
          this.router.navigate(['/admin-dashboard']);
        }, 1000); // Change the delay time as needed
        this.loginError = null;
      } else {
        this.loginError = 'Invalid username or password';
      }
    }
  }
}