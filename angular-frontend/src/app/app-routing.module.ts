import { ShowStudentComponent } from './show-student/show-student.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateTutorialComponent } from './components/tutorial/create-tutorial/create-tutorial.component';
import { TutorialDetailsComponent } from './components/tutorial/tutorial-details/tutorial-details.component';
import { UpdateTutorialComponent } from './components/tutorial/update-tutorial/update-tutorial.component';
import { TutorialListComponent } from './components/tutorial/tutorial-list/tutorial-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'tutorial', pathMatch: 'full' },
  { path: 'tutorials', component: TutorialListComponent},
  { path: 'details/:id', component: TutorialDetailsComponent },
  { path: 'create', component: CreateTutorialComponent },
  { path: 'update/:id', component: UpdateTutorialComponent},
  { path: 'students', component: ShowStudentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
