import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

// Angular Material Modules
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';

interface Song {
  id: number;
  name: string;
  artist: string;
  album: string;
  duration: string;
  rating: number;
  language: string;
  image: string;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatToolbarModule,
    MatIconModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Music Playlist App';

 
  songs: Song[] = [
    { id: 1, name: 'Butta Bomma', artist: 'Armaan Malik', album: 'Ala Vaikunthapurramuloo', duration: '3:16', rating: 4.6, language: 'Telugu', image: 'assets/music/butta-bomma.jpg' },
    { id: 2, name: 'Samajavaragamana', artist: 'Sid Sriram', album: 'Ala Vaikunthapurramuloo', duration: '3:48', rating: 4.7, language: 'Telugu', image: 'assets/music/samajavaragamana.jpg' },
    { id: 3, name: 'Srivalli', artist: 'Sid Sriram', album: 'Pushpa: The Rise', duration: '3:42', rating: 4.5, language: 'Telugu', image: 'assets/music/srivalli.jpg' },
    { id: 4, name: 'Kesariya', artist: 'Arijit Singh', album: 'Brahmastra', duration: '4:28', rating: 4.4, language: 'Hindi', image: 'assets/music/kesariya.jpg' }
  ];

  
  selectedArtist: string = '';
  selectedAlbum: string = '';
  

  get artists() {
    return [...new Set(this.songs.map(s => s.artist))];
  }

 
  get albums() {
    return [...new Set(this.songs.map(s => s.album))];
  }


  get filteredSongs() {
    return this.songs.filter(song => {
      return (
        (!this.selectedArtist || song.artist === this.selectedArtist) &&
        (!this.selectedAlbum || song.album === this.selectedAlbum)
        
      );
    });
  }

  

  
  isTopRated(rating: number): boolean {
    return rating >= 4.5;
  }
}
