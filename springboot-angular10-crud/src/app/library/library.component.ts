import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import _ from 'lodash';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {

  members;
  books;
  selectedBooks;
  selectedMember;
  selectedBook;
  lendingStatus;

  constructor(private apiService:ApiService) {
    }

  ngOnInit(): void {
    this.getMembers();
    this.getBooks();
    this.selectedBooks=[];
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

  getMembers() {
    this.apiService.getMembers().subscribe(response=>{
      this.members = response;
      console.log(JSON.stringify(response));
    },
    error=>{
      console.log(error)
    })
  }

  addBook() {
    console.log("Selected Member : "+this.selectedMember);
    console.log("Adding a Book : "+this.selectedBook.id);
    this.selectedBooks.push(this.selectedBook);
  }

  removeBook(bookData) {
    _.remove(this.selectedBooks, function(data){
      return data.id == bookData
    })
  }

  lend() {
    console.log("Initiating book lending");

    if (!_.isEmpty(this.selectedBooks)) {
      
      let selectedIds = []
      this.selectedBooks.forEach(book => {
        selectedIds.push(book.id);
      });

      const book_lending_request = {
        bookIds: selectedIds,
        memberId: this.selectedMember
      };

      console.log('Your lending request', book_lending_request);

      this.apiService.lendABook(book_lending_request).subscribe(response => {
        this.lendingStatus = true;
        console.log("Lending Response : "+response);
        this.selectedBooks=[];
        this.selectedMember='';
        this.selectedBook='';
      });
    }
  }

}
