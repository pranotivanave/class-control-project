import { Classroom } from "./Classroom";
import { Course } from "./Course";

export class Teacher{
  teacher_Id: number;
  teacher_FullName: string;
  teacher_Email: string;
  teacher_MobileNo: string;
  teacher_BirthDate: Date;
  teacher_Password: string;
  teacher_Expertise: string;
  courses: Course[];
  classroom: Classroom[];

  constructor() {
    this.teacher_Id = 0;
    this.teacher_FullName = "";
    this.teacher_Email = "";
    this.teacher_MobileNo = "";
    this.teacher_BirthDate = new Date();
    this.teacher_Password = "";
    this.teacher_Expertise = "";
    this.courses = [];
    this.classroom = [];
  }
}