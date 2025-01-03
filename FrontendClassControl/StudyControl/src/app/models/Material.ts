import { Classroom } from "./Classroom";
import { Assignment } from "./Assignment";

export enum MaterialType {
        NOTES = 'Notes',
        ASSIGNMENT_MATERIAL = 'Assignment Material'
    
}

export class Material {
    material_Id: number;
    material_Title: string;
    material_File: any; // Adjust data type based on your needs
    materialType: MaterialType;
    assignment: Assignment;
    classroom: Classroom;

    constructor(materialType: MaterialType){
        this.material_Id = 0;
        this.material_Title = "";
        this.material_File = null;
        this.materialType = materialType;
        this.assignment = new Assignment(); // Initialize an empty Assignment object
        this.classroom = new Classroom(); // Initialize an empty Classroom object
    }
}
