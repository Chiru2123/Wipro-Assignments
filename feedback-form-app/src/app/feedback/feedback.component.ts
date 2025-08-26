import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators, FormGroup } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-feedback',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  submittedMessage = '';
  feedbackForm!: FormGroup;   

 constructor(private readonly fb: FormBuilder) {}


  ngOnInit(): void {
    this.feedbackForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      subject: ['', [Validators.required, Validators.maxLength(40)]],
      comments: ['', [Validators.required, Validators.maxLength(350)]]
    });
  }

  onSubmit() {
    if (this.feedbackForm.valid) {
      this.submittedMessage = 'Thank you! We will get back to you shortly.';
      console.log('Form Data:', this.feedbackForm.value);
    } else {
      this.submittedMessage = '';
    }
  }

  getError(controlName: string) {
    const control = this.feedbackForm.get(controlName);
    if (control?.touched && control?.invalid) {
      if (control.errors?.['required']) {
        return controlName + ' is required';
      }
      if (control.errors?.['email']) {
        return 'Enter a valid email';
      }
      if (control.errors?.['maxlength']) {
        return controlName + ' is too long';
      }
    }
    return '';
  }
}
