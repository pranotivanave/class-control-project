import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneratePasswordForTeacherComponent } from './generate-password-for-teacher.component';

describe('GeneratePasswordForTeacherComponent', () => {
  let component: GeneratePasswordForTeacherComponent;
  let fixture: ComponentFixture<GeneratePasswordForTeacherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GeneratePasswordForTeacherComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GeneratePasswordForTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
