import { Component } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.css'
})
export class ContactComponent {

  contact = {
    name: '',
    email: '',
    phone: '',
    message: ''
  };

  onSubmit() {
    // Handle form submission
    console.log('Contact Form Data:', this.contact);
    // Here you can add your form submission logic
  }
}

