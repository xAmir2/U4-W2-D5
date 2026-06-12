package amirka;


import amirka.entities.Collection;
import amirka.entities.Genre;
import amirka.entities.TableGames;
import amirka.entities.VideoGame;
import amirka.exception.Duplicate;
import amirka.exception.NotFound;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Collection collection = new Collection();

        while (true) {
            System.out.println("Select option: " +
                    "\n1. Add VideoGame" +
                    "\n2. Add TableGame" +
                    "\n3. Search using ID" +
                    "\n4. Search using price" +
                    "\n5. Search TableGames using the number of players" +
                    "\n6. Remove game" +
                    "\n7. Update general game info (Price, Title and Year)" +
                    "\n8. Update VideoGame (Platform, Game hours and Genre)" +
                    "\n9. Update TableGame (Players and average game duration)" +
                    "\n10. Statistics" +
                    "\n11. Show entire collection" +
                    "\n12. Exit"
            );

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter video game ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter video game title:");
                        String title = sc.nextLine();
                        System.out.println("Enter video game year of release:");
                        int year = sc.nextInt();
                        System.out.println("Enter video game's price:");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter supported video game platforms:");
                        String platform = sc.nextLine();
                        System.out.println("Enter the amount of time (hours) needed to complete the video game:");
                        int gameHours = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the video game genre:");
                        Genre genre = Genre.valueOf(sc.nextLine()
                                .toUpperCase());
                        collection.addGame(new VideoGame(id, title, year, price, platform, gameHours, genre));
                        System.out.println("Game added successfully!");
                    }
                    case 2 -> {
                        System.out.println("Enter table game ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter table game title:");
                        String title = sc.nextLine();
                        System.out.println("Enter table game year of release:");
                        int year = sc.nextInt();
                        System.out.println("Enter table game's price:");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter table game's max player(s):");
                        int players = sc.nextInt();
                        System.out.println("Enter the average duration of a game (mins):");
                        int gameDurationMin = sc.nextInt();
                        sc.nextLine();
                        collection.addGame(new TableGames(id, title, year, price, players, gameDurationMin));
                        System.out.println("Game added successfully!");
                    }
                    case 3 -> {
                        System.out.println("Enter the ID to find the game you are looking for:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Game you were looking for:" + collection.findGameUsingId(id));
                    }
                    case 4 -> {
                        System.out.println("Enter the amount you willing to spend:");
                        double price = sc.nextDouble();
                        collection.findGameUsingPrice(price)
                                .forEach(System.out::println);
                    }
                    case 5 -> {
                        System.out.println("Find a game based on how many players are playing:");
                        int players = sc.nextInt();
                        sc.nextLine();

                        collection.findTableGamesUsingPlayers(players)
                                .forEach(System.out::println);
                    }
                    case 6 -> {
                        System.out.println("Enter ID to remove game:");
                        int id = sc.nextInt();
                        collection.removeGame(id);
                        System.out.println("Game successfully removed!");
                    }
                    case 7 -> {
                        System.out.println("Enter game current ID:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new price:");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter new title:");
                        String title = sc.nextLine();
                        System.out.println("Enter new year of release:");
                        int year = sc.nextInt();

                        collection.updateGameParams(id, price, title, year);
                    }
                    case 8 -> {
                        System.out.println("Enter game current ID:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new supported platform(s):");
                        String platforms = sc.nextLine();
                        System.out.println("Enter the new amount of time (hours) needed to complete the video game:");
                        int gameHours = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Update the game genre:");
                        Genre genre = Genre.valueOf(sc.nextLine()
                                .toUpperCase());
                        collection.updateVideoGame(id, platforms, gameHours, genre);
                    }
                    case 9 -> {
                        System.out.println("Enter game current ID:");
                        int id = sc.nextInt();
                        System.out.println("Enter table game's max player(s):");
                        int players = sc.nextInt();
                        System.out.println("Enter new game average duration (mins):");
                        int gameDurationMin = sc.nextInt();
                        collection.updateTableGames(id, players, gameDurationMin);
                    }
                    case 10 -> {
                        collection.stats();
                    }
                    case 11 -> {
                        System.out.println(collection);
                    }
                    case 12 -> {
                        System.out.println("Thanks for taking part!");
                        return;
                    }

                }
            } catch (Duplicate | NotFound e) {
                System.out.println("Error" + e.getMessage());
            } catch (Exception e) {
                System.out.println("General error" + e.getMessage());
            }
        }
    }
}
