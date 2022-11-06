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

    public static void RemoveSongByIndex(Integer songIndex) {
        songRecords.remove((int)songIndex);
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

        Scanner input = new Scanner(System.in);

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

            System.out.print("Please Enter An Option... : ");
            String option = input.nextLine();
            System.out.println();
            //System.out.println("You entered string " + option);

            switch (option)
            {
                case "Q":
                case "q":
                case "5":
                {
                    stop = true;
                    break;
                }

                case "A":
                case "a":
                case "1":
                {
                    System.out.print("Please Enter Song Name... : ");
                    String SongName = input.nextLine();

                    System.out.println();

                    System.out.print("Please Enter Artist... : ");
                    String ArtistName = input.nextLine();

                    System.out.println();

                    try {

                        System.out.print("Please Enter Number Of Streams... : ");
                        Integer Streams = input.nextInt();
                        input.nextLine();
                        AddSong(SongName, ArtistName, Streams); //

                    }

                    catch(Exception e) {

                        System.out.println(e.getMessage());
                        input.nextLine();
                        
                    }
                    break;
                }

                case "R":
                case "r":
                case "2":
                {
                    for (SongRecord songRecord : songRecords) {
                        int index = songRecords.indexOf((songRecord));
                        System.out.println("Song Index: " + (index+1) + " | Song Details: " + songRecord.PrintDetails());
                    }

                    try {
                        System.out.println();
                        System.out.print("Please Enter Song Index... : ");
                        Integer songIndex = input.nextInt();
                        input.nextLine();

                        if ((songRecords.size() > (songIndex-1)) && ((songIndex-1) >= 0)) { //
                            RemoveSongByIndex((songIndex-1)); 
                        } else {
                            System.out.println("Index out of range, try again...");
                        }
                    }
                    catch(Exception e) {

                        System.out.println(e.getMessage());
                        input.nextLine();

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
                    System.out.print("Please Enter Number Of Streams... : ");

                    try {
                        Integer Streams = input.nextInt();
                        input.nextLine();
                        System.out.println();
                        Integer count = 0;
                        for (SongRecord songRecord : songRecords) {
                            if (songRecord.PlayCount > Streams) {
                                count += 1;
                                System.out.println("Song " + count + " " + songRecord.PrintDetails());  
                            }
                        }
                    }
                    catch(Exception e) {
                        
                        System.out.println(e.getMessage());
                        input.nextLine();
                    }

                    break;
                }

                default : 
                {
                    System.out.println("Invalid Input");

                break;
                }


            }
        }
        input.close();
    }
}