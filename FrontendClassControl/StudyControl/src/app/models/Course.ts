import { Classroom } from "./Classroom";
import { Teacher } from "./Teacher";

export class Course{
    course_Id:number;
	course_Name:string;
	course_Description:string;
    classroom:Classroom[];
    teacher:Teacher[];

    constructor()
    {
        this.course_Id=0;
        this.course_Name="";
        this.course_Description="";
        this.classroom=[];
        this.teacher=[];
    }
}