import {Component, OnInit, ViewChild} from '@angular/core';
import { MatTable } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';
import { RouterOutlet, Router, ActivationStart } from '@angular/router';
import 'rxjs/add/operator/toPromise';
import { CourseRegistrationService } from './course-registration.service';

export interface CourseRegistration{
  id: number;
  studentId: number;
  courseId: number;
  courseName: string;
  courseFee: number;
  phase: number;
  session: number;
  regStatus: boolean;
  paymentStatus: boolean;
  dueDate: Date;
  requestDate: Date;
  createdOn: Date;
}

export interface Student{
  id: number;
  name: string;
  dob: Date;
  phone: string;
  email: string;
  batch: string;
  prevPhase: number;
  currentPhase: number;
}



@Component({
  selector: 'app-course-registration',
  templateUrl: './course-registration.component.html',
  styleUrls: ['./course-registration.component.css']
})
export class CourseRegistrationComponent implements OnInit {

  private students: Student[];
  
  displayedColumns: string[] = ['id', 'name', 'dob', 'phone', 'action'];
  dataSource: Student[];
  
  @ViewChild(MatTable,{static:true}) table: MatTable<any>;
  @ViewChild(RouterOutlet) outlet: RouterOutlet;
  
  constructor(
    public dialog: MatDialog,
    private courseRegistrationService: CourseRegistrationService,
    private router: Router
  ) {}
  
  reloadData(){
    this.router.events.subscribe(e => {
      if (e instanceof ActivationStart && e.snapshot.outlet === "administration")
        this.outlet.deactivate();
      });
      this.getAllCourseRegistration();
  }

  ngOnInit(): void {
    this.reloadData();
  }
  getAllCourseRegistration() {
    this.courseRegistrationService.findAllStudent()
    .then(
      students => {
        this.students = students;
        this.dataSource = students;
        console.log(this.dataSource);
      },
      err => {
        console.log(err);
      }
      )
    }
      
  openDialog(action: any, obj: { action: any; }) {
    obj.action = action;
    const dialogRef = this.dialog.open(DialogBoxComponent, {
      width: '700px',
      data:obj
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(result.data);
      if(result.event == 'Add'){
        this.addRowData(result.data);
      }
    });
  }

  addRowData(row_obj: CourseRegistration){
    this.courseRegistrationService.createCourseRegistration(row_obj);
    this.reloadData();
  }
}
