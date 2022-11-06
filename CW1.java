import java.util.ArrayList;
import java.util.Scanner;

public class CW1
{
    private static ArrayList<SongRecord> songRecords = new ArrayList<>();

    public static void AddSong(
        String trackName,
        String artistName,
        Integer playCount)
    {
        songRecords.add(new SongRecord(trackName, artistName, playCount));
    }

    public static void RemoveSong(String trackName) {
        for (int i = songRecords.size() - 1; i >= 0; i--) {
            if (songRecords.get(i).TrackName.equals(trackName)) {
                songRecords.remove(i);
            }
        }
    }

    public static void main(String[] args)
    {

        AddSong("The Adults Are Talking", "The Strokes", 234198458);
        AddSong("Shotgun", "George Ezra", 769385834);
        AddSong("Basket Case", "Green Day", 742442141);
        AddSong("Umbrella", "Rihanna", 983460195);
        AddSong("Rasputin", "Boney M", 413416677);
        AddSong("Dancing Queen", "ABBA", 821695747);
        AddSong("Im Still Standing", "Elton John", 583098683);
        AddSong("Something Just Like This", "Cold Play", 1953346889);
        AddSong("Dynamite", "BTS", 1516134715);
        AddSong("What Makes You Beautful", "One Direction", 803853615);

        Boolean stop = false;

        System.out.println("CO452 Programming Concepts 2022/23");
        System.out.println("==================================");
        System.out.println();
        System.out.println("by Harrison Tween");



        while (!stop) {

            System.out.println();
            System.out.println("MAIN MENU");
            System.out.println();
            System.out.println("1. Add Song: A|a");
            System.out.println("2. Remove Song: R|r");
            System.out.println("3. Print All Songs: S|s");
            System.out.println("4. Print Songs with streams higher than ... : L|l");
            System.out.println("5. Quit: Q|q");
            System.out.println();

            Scanner input = new Scanner(System.in);
            System.out.print("Please Enter An Option... : ");
            String option = input.nextLine();
            System.out.println("You entered string " + option);

            input.close();

            switch (option)
            {
                case "Q":
                case "5":
                {
                    stop = true;
                    break;
                }

                case "A":
                case "a":
                case "1":
                {
                    System.out.println("Please Enter Song Name...");
                    Scanner songName = new Scanner(System.in);
                    String SongName = songName.nextLine();
                    songName.close();
                    System.out.println("You entered string " + SongName);

                    System.out.println();

                    System.out.println("Please Enter Artist...");
                    Scanner artistName = new Scanner(System.in);
                    String ArtistName = artistName.nextLine();
                    artistName.close();


                    System.out.println("Please Enter Number Of Streams...");
                    Scanner streams = new Scanner(System.in);
                    Integer Streams = streams.nextInt();
                    streams.close();


                    AddSong(SongName, ArtistName, Streams); //
                    break;
                }

                case "R":
                case "r":
                case "2":
                {
                    Integer count = 0;
                    for (SongRecord songRecord : songRecords) {
                        count += 1;
                        System.out.println("Song " + count + ": " + songRecord.PrintDetails());
                    }

                    System.out.println("Please Enter Song Name...");
                    Scanner songName = new Scanner(System.in);
                    String SongName = songName.nextLine();
                    songName.close();

                    if (songRecords.contains(SongName)) { //
                        RemoveSong(SongName); 
                    } else {
                        System.out.println("No song with that name was found...");
                        System.out.println();
                    }
                    break;
                }

                case "S":
                case "s":
                case "3": 
                {
                    Integer count = 0;
                    for (SongRecord songRecord : songRecords) {
                        count += 1;
                        System.out.println("Song " + count + ": " + songRecord.PrintDetails());
                    }
                    break;
                }

                case "4":
                case "l":
                case "L":
                {
                    System.out.println("Please Enter Number Of Streams...");
                    Scanner streams = new Scanner(System.in);
                    Integer Streams = streams.nextInt();
                    streams.close();

                    Integer count = 0;
                    for (SongRecord songRecord : songRecords) {
                        if (songRecord.PlayCount > Streams) {
                            count += 1;
                            System.out.println("Song " + count + " " + songRecord.PrintDetails());  
                        }
                    }
                    break;
                }

                default : 
                {
                    System.out.println("Invalid Input");

                break;
                }


            }
            Integer count = 0;
            for (SongRecord songRecord : songRecords) {
                count += 1;
                System.out.println("Song " + count + ": " + songRecord.PrintDetails());             
            }    
        }


        
       
        // for(int i=0; i<music.length; i++) {
        //     System.out.println();
        //     for(int j=0; j<music[i].length; j++) {
        //         System.out.print(music[i][j]+ " ");
        //     }
        // }

        // System.out.print(music[0]);

        // Music<String, String, Integer> music = new Music<String, String, Integer>("A", "B", 3);

        
        // String[][] Music = { {"Beautiful", "Anne-Marie", "863015"}, 
        //                     {"Bad Habits", "Ed Sheeran", "127191452"}, 
        //                     {"Halo", "Beyonce", "991888598"}, 
        //                     {"Clash",  "Dave (feat. Stormzy)", "7070513"}, 
        //                     {"It Gets Better", "Swedish House Mafia", "7563930"} };

        // System.out.println(Arrays.toString(Music));
        
        // int Music[][] = new int[5][3];


       // String[][][] Music = { {"Beautiful", }, {"Anne-Marie",}, {863015,} };
    }
}