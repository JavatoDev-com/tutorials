import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../api.service';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-bookupdate',
  templateUrl: './bookupdate.component.html',
  styleUrls: ['./bookupdate.component.css'],
})
export class BookupdateComponent implements OnInit {
  bookId;
  updateBookForm;
  authors;
  updateSuccess;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private apiService: ApiService
  ) {
    this.updateBookForm = this.formBuilder.group({
      name: '',
      isbn: '',
      authorId: '',
      id: '',
    });
  }

  ngOnInit(): void {
    this.bookId = this.route.snapshot.paramMap.get('id');
    this.apiService.readBook(this.bookId).subscribe((response) => {
      console.log('Response from Core ' + JSON.stringify(response));
      this.updateBookForm.patchValue({
        name: response.name,
        isbn: response.isbn,
        authorId: response.author.id,
        id: response.id,
      });
    });
    this.getAuthors();
  }

  getAuthors() {
    this.apiService.getAllAuthors().subscribe(
      (response) => {
        this.authors = response;
        console.log(JSON.stringify(response));
      },
      (error) => {
        console.log(error);
      }
    );
  }

  onSubmit(updateData) {
    console.log(updateData);
    this.apiService
      .updateBook(updateData.id, updateData)
      .subscribe((response) => {
        console.log('Update book done' + response);
        this.updateSuccess = true;
      }, error=>{
        this.updateSuccess = false;
      });
  }
}
