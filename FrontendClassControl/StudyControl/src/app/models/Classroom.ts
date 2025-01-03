import { Course } from "./Course";
import { Teacher } from "./Teacher";

export class Classroom{
    classroom_Id:number;
    classroom_Name:string;
    classroom_Description:string;
    teacher:Teacher[];
    course:Course[];
    
    constructor(){
        this.classroom_Id=0;
        this.classroom_Name="";
        this.classroom_Description="";
        this.teacher=[];
        this.course=[];
    }
}