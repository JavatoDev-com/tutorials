import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {

  members;
  memberRegistrationForm;

  constructor(private formBuilder: FormBuilder,
    private apiService: ApiService) {
      this.memberRegistrationForm = this.formBuilder.group({
        firstName: '',
        lastName: ''
      });
    }

  ngOnInit(): void {
    this.getMembers();
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

  onSubmit(memberData) {
    this.memberRegistrationForm.reset();
    console.log('Your author registration successfully', memberData);
    this.apiService.createAMember(memberData).subscribe(response=>{
      console.log("Author creation successfull"+ response.id);
      this.getMembers();
    },error=>{
      console.log('Error in author registration');
    });
    
  }

}
