import { Component, HostListener, OnInit, Inject, PLATFORM_ID } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule, isPlatformBrowser } from '@angular/common';


import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';

interface Movie {
  title: string;
  poster: string;
  genre: string;
  rating: number;
  description: string;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule,
    MatCardModule,
    MatIconModule,
    MatSelectModule,
    MatGridListModule,
    MatToolbarModule,
    MatFormFieldModule,
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  selectedGenre: string = 'All';
  cols: number = 4;

  constructor(@Inject(PLATFORM_ID) private readonly platformId: Object) {}

  
  movies: Movie[] = [
  {
    title: 'Bahubali',
    poster: '/assets/movies/bahubali.jpg',
    genre: 'Action',
    rating: 5,
    description: 'An epic story of two brothers fighting for a kingdom.'
  },
  {
    title: 'RRR',
    poster: '/assets/movies/rrr.jpg',
    genre: 'Action',
    rating: 5,
    description: 'A tale of friendship and rebellion against oppression.'
  },
  {
    title: 'Coolie',
    poster: '/assets/movies/coolie.jpg',
    genre: 'Drama',
    rating: 3,
    description: 'A classic entertainer.'
  },
  {
    title: 'Hi Nanna',
    poster: '/assets/movies/hi nanna.jpg',   
    genre: 'Drama',
    rating: 4,
    description: 'A family drama highlighting emotional bonds and values.'
  }
];

  get filteredMovies() {
    if (this.selectedGenre === 'All') {
      return this.movies;
    }
    return this.movies.filter((m) => m.genre === this.selectedGenre);
  }

  get averageRating() {
    const total = this.movies.reduce((acc, m) => acc + m.rating, 0);
    return (total / this.movies.length).toFixed(1);
  }

  
  ngOnInit() {
    if (isPlatformBrowser(this.platformId)) {
      this.onResize();
    }
  }

  
  @HostListener('window:resize', [])
  onResize() {
    if (isPlatformBrowser(this.platformId)) {
      const width = window.innerWidth;
      if (width <= 480) {
        this.cols = 1;
      } else if (width <= 768) {
        this.cols = 2;
      } else if (width <= 1024) {
        this.cols = 3;
      } else {
        this.cols = 4;
      }
    }
  }
}
