import { Classroom } from "./Classroom";
import { Course } from "./Course";

export class Student {
  student_Id: number;
  student_FullName: string;
  student_Email: string;
  student_MobileNo: string;
  student_BirthDate: Date;
  student_Password: string;
  classrooms: Classroom[];
  course: Course;

  constructor() {
    this.student_Id = 0;
    this.student_FullName = "";
    this.student_Email = "";
    this.student_MobileNo = "";
    this.student_BirthDate = new Date();
    this.student_Password = "";
    this.classrooms = [];
    this.course = new Course();
  }
}
