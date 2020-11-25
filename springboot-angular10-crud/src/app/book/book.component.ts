import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'],
})
export class BookComponent implements OnInit {
  books;
  authors;
  registerBookForm;
  deletionStatus;

  constructor(
    private formBuilder: FormBuilder,
    private apiService: ApiService
  ) {
    this.registerBookForm = this.formBuilder.group({
      name: '',
      isbn: '',
      authorId: '',
    });
  }

  ngOnInit(): void {
    this.getAuthors();
    this.getBooks();
  }
  

  getAuthors() {
    this.apiService.getAllAuthors().subscribe(response=>{
      this.authors = response;
      console.log(JSON.stringify(response));
    },
    error=>{
      console.log(error)
    })
  }

  onSubmit(bookData) {
    this.registerBookForm.reset();
    this.apiService.createBook(bookData).subscribe(response=>{
      console.log("Book creation successfull"+ response.id);
      this.getBooks();
      console.log('Your book registration successfully', bookData);
    },error=>{
      console.log('Error in book registration');
    });
    
  }


  getBooks() {
    this.apiService.readBooks().subscribe(response=>{
      this.books = response;
      console.log(JSON.stringify(response));
    },
    error=>{
      console.log(error)
    })
  }

  deleteBook(bookId) {
    console.log("Deleting book ", bookId);
    this.apiService.removeBook(bookId).subscribe(response=>{
      console.log("Book deletion success"+response)
      this.getBooks();
      this.deletionStatus = true;
    });
    
  }

}
