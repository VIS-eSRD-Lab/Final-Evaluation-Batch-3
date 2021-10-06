import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { TutorialService } from '../../../services/tutorial.service';
import { Tutorial } from '../../../classes/tutorial';
import {  FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-tutorial-list',
  templateUrl: './tutorial-list.component.html',
  styleUrls: ['./tutorial-list.component.css']
})
export class TutorialListComponent implements OnInit {
  tutorials: Observable<Tutorial[]>;
  searchForm;

  constructor(private tutorialService: TutorialService, private router: Router, private formBuilder: FormBuilder) {
    this.searchForm = this.formBuilder.group({
      name: '',
    });
  }

  ngOnInit(): void {
    console.log('Tutorial list');
    this.reloadData();
  }

  reloadData(){
    this.tutorials = this.tutorialService.getAll();
    console.log(this.tutorials);
  }

  deleteTutorial(id: string) {
    this.tutorialService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  tutorialDetails(id: string){
    this.router.navigate(['details', id]);
  }

  updateTutorial(id: string){
    this.router.navigate(['update', id]);
  }

}
