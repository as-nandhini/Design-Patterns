package com.example.designpatterns.structural;
interface MediaPlayer {
    void play(String fileName);
}
class AdvancedMediaPlayer {
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
class MediaAdapter implements MediaPlayer {
    private final AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();
    @Override
    public void play(String fileName) {
        if (fileName != null && fileName.endsWith(".mp4")) {
            advancedPlayer.playMP4(fileName);
        } else {
            System.out.println("MediaAdapter: Unsupported format: " + fileName);
        }
    }
}
class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String fileName) {
        if (fileName == null) {
            System.out.println("No file specified.");
            return;
        }
        if (fileName.endsWith(".mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else if (fileName.endsWith(".mp4")) {
            MediaAdapter adapter = new MediaAdapter();
            adapter.play(fileName);
        } else {
            System.out.println("Unsupported format: " + fileName);
        }
    }
}
public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("song.mp3");
        player.play("movie.mp4");
        player.play("clip.avi");
    }
}