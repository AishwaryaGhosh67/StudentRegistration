import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrl: './student.component.scss'
})
export class StudentComponent {

  StudentArray: any[] = [];

  studentName: string = "";
  studentAddress: string = "";
  mobile: number = 0;

  currentId:number =0;

  constructor(private http: HttpClient) {
   this.getAllStudents();
  }

  register() {
    let bodyData = {
      "studentName": this.studentName,
      "studentAddress": this.studentAddress,
      "mobile": this.mobile
    };

    this.http.post("http://localhost:8081/api/student/save", bodyData, { responseType: 'text' }).subscribe((resultdata: any) => {
      console.log(resultdata);
      alert("Student Register Successfully");

      this.getAllStudents();

      this.studentName = "";
      this.studentAddress = "";
      this.mobile = 0;

    });
  }

  // Get all students
  getAllStudents(){
    this.http.get("http://localhost:8081/api/student/getAll").subscribe((resultData: any) => 
    {
      console.log(resultData);
      this.StudentArray = resultData;
    });
  }

  setUpdate(data:any)
  {
    this.studentName = data.studentName;
    this.studentAddress = data.studentAddress;
    this.mobile = data.mobile;
    this.currentId = data._id;
    alert(data._id);
  }

  UpdateRecords()
  {
    let bodyData = {
      "studentName": this.studentName,
      "studentAddress": this.studentAddress,
      "mobile": this.mobile
    };

    this.http.put("http://localhost:8081/api/student/edit/"+this.currentId, bodyData, {responseType: 'text'}).subscribe((resultData: any) =>
     {
      console.log(resultData);
      alert("Student Register Updated");
      this.getAllStudents();

      this.studentName = "";
      this.studentAddress = "";
      this.mobile = 0;

    })
  }

  save()
  {
    if(this.currentId == 0)
    {
      this.register();
    }
    else{
      this.UpdateRecords();
    }
  }


  // Delete
  
  setDelete(data:any){
    this.http.delete("http://localhost:8081/api/student/delete/"+data._id, {responseType:'text'}).subscribe((resultdata: any) => 
    {
      console.log(resultdata);
      alert("Student Deleted");

      this.getAllStudents();

      this.studentName = "";
      this.studentAddress = "";
      this.mobile = 0;

    })
  }

}
