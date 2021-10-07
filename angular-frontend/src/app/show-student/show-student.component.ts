import { StudentService } from './../student.service';
import { Component, OnInit } from '@angular/core';
import {  FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-show-student',
  templateUrl: './show-student.component.html',
  styleUrls: ['./show-student.component.css']
})
export class ShowStudentComponent implements OnInit {

  tutorials: any;
  searchForm;

  constructor(private service: StudentService, private formBuilder: FormBuilder) {
    this.searchForm = this.formBuilder.group({
      name: '',
    });
   }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    this.tutorials = this.service.getAll();
    console.log(this.tutorials);
  }

  deleteTutorial(id: string) {
    this.service.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

}
