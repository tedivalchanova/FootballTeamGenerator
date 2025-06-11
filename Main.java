

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();
        Player player;
        List<Team> allTeams = new ArrayList<>();
        Team found = null;
        while (!line.equals("END")) {
            String[] split = line.split(";");
            String command = split[0];
            String teamName = split[1];
            try {

                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        allTeams.add(team);
                        found=team;

                        break;
                    case "Add":
                        player = new Player(split[2], Integer.parseInt(split[3]),
                                Integer.parseInt(split[4]), Integer.parseInt(split[5]),
                                Integer.parseInt(split[6]), Integer.parseInt(split[7]));


                        for (Team currentTeam : allTeams) {
                            if (currentTeam.getName().equalsIgnoreCase(teamName)) {
                                found = currentTeam;


                                found.addPlayer(player);
                                break;
                            }
                        }


                        break;
                    case "Remove":

                        String name = split[2];
                        found.removePlayer(name);


                        break;
                    case "Rating":
                        System.out.println(found.getName() + " - " + found.getRating());
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            line = scanner.nextLine();
        }


    }


}
