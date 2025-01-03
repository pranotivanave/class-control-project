import { AfterViewInit, Component } from '@angular/core';

@Component({
  selector: 'app-admin-siderbar',
  templateUrl: './admin-siderbar.component.html',
  styleUrl: './admin-siderbar.component.css'
})
export class AdminSiderbarComponent implements AfterViewInit 

{
  ngAfterViewInit() {
    const sidebar = document.getElementById('sidebar');
    const sidebarCollapse = document.getElementById('sidebarCollapse');
    const sidebarOverlay = document.getElementById('sidebarOverlay');

    if (sidebarCollapse) {
      sidebarCollapse.addEventListener('click', () => {
        if (sidebar) {
          sidebar.classList.toggle('collapsed');
        }
      });
    }

    if (sidebarOverlay) {
      sidebarOverlay.addEventListener('click', () => {
        if (sidebar) {
          sidebar.classList.remove('collapsed');
        }
      });
    }

   
  }
}



