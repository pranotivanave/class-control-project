import { Classroom } from "./Classroom";
import { Material } from "./Material";
import { Submission } from "./Submission";

export class Assignment {
    assignment_Id: number;
    assignment_Title: string;
    assignment_Deadline: Date;
    
    classroom: Classroom[];
    material: Material[];
    submissions: Submission[];

    constructor(){
        this.assignment_Id=0;
        this.assignment_Title="";
        this.assignment_Deadline=new Date();
        this.classroom=[];
        this.material=[];
        this.submissions=[];
    }
}