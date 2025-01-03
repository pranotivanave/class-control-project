import { Student } from "./Student";
import { Assignment } from "./Assignment";

export class Submission {
  submission_Id: number;
  submissionDateTime: Date;
  assignment_SubmissionFile: any; // Adjust data type based on your needs
  student: Student;
  assignment: Assignment;

  constructor() {
    this.submission_Id = 0;
    this.submissionDateTime = new Date();
    this.assignment_SubmissionFile = null;
    this.student = new Student();
    this.assignment = new Assignment();
  }
}
