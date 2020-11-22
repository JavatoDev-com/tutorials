import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthorComponent } from './author/author.component';
import { BookComponent } from './book/book.component';
import { LibraryComponent } from './library/library.component';

const routes: Routes = [
  {path: '', component: AuthorComponent},
  {path: 'author', component: AuthorComponent},
  {path: 'book', component: BookComponent},
  {path: 'library', component: LibraryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
