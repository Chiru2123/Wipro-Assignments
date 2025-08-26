import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-calculator',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
  num1: number = 0;
  num2: number = 0;
  result: number = 0;

  count: number = 0;

  addNumbers() {
    this.result = this.num1 + this.num2;
  }

  subtractNumbers() {
    this.result = this.num1 - this.num2;
  }

  multiplyNumbers() {
    this.result = this.num1 * this.num2;
  }

  divideNumbers() {
    if (this.num2 !== 0) {
      this.result = this.num1 / this.num2;
    } else {
      alert("Division by zero is not allowed!");
      this.result = 0;
    }
  }

  increment() {
    this.count++;
  }

  decrement() {
    this.count--;
  }
}
