import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthorComponent } from './author/author.component';
import { BookComponent } from './book/book.component';
import { LibraryComponent } from './library/library.component';
import { BookupdateComponent } from './bookupdate/bookupdate.component';
import { MemberComponent } from './member/member.component';

const routes: Routes = [
  {path: '', component: LibraryComponent},
  {path: 'author', component: AuthorComponent},
  {path: 'book', component: BookComponent},
  {path: 'library', component: LibraryComponent},
  {path: 'book/:id', component: BookupdateComponent},
  {path: 'member', component: MemberComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  
}
