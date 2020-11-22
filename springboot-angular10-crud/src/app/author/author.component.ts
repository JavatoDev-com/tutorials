import { Component, OnInit } from '@angular/core';
import { FormBuilder, } from '@angular/forms';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css'],
})
export class AuthorComponent implements OnInit {
  
  authors;
  authorRegistrationForm;

  constructor(
    private formBuilder: FormBuilder,
    private apiService: ApiService) {

    this.authorRegistrationForm = this.formBuilder.group({
      firstname: '',
      lastname: ''
    });

  }

  ngOnInit(): void {
    this.getAuthors();    
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

  onSubmit(authorData) {
    this.authorRegistrationForm.reset();
    const user_register_data = {
      firstName: authorData.firstname,
      lastName: authorData.lastname
    };
    console.log('Your author registration successfully', authorData);
    this.apiService.createAuthor(user_register_data).subscribe(response=>{
      console.log("Author creation successfull"+ response.id);
      this.getAuthors();
    },error=>{
      console.log('Error in author registration');
    });
    
  }

}
