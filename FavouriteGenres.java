// TC: O(S_g + S_u + U * G)
// SC: O(S_g + G)

// where
// S_g : Total No. of Songs across All Genres
// S_u : Total No. of Songs across All Users
// U : Total No. of Users
// G : Total No. of Genres

import java.util.*;

public class FavouriteGenres {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> res = new HashMap<>();
        
        HashMap<String, String> songToGenre = new HashMap<>();
        for(String g : genreMap.keySet()){
            for(String s : genreMap.get(g)){
                songToGenre.put(s, g);
            }
        }
        
        for(String u : userMap.keySet()){
            HashMap<String, Integer> count = new HashMap<>();
            int max = 0;
            for(String s : userMap.get(u)){
                String g = songToGenre.get(s);
                count.put(g, count.getOrDefault(g,0)+1);
                max = Math.max(count.get(g), max);
            }
            res.put(u, new ArrayList<>());
            for(String g : count.keySet()){
                if(count.get(g)==max){
                    res.get(u).add(g);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
            HashMap<String, List<String>> userSongs = new HashMap<>();
            userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
            userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));
            HashMap<String, List<String>> songGenres = new HashMap<>();
            songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));
            songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));
            songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));
            songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));
            songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));
            Map<String, List<String>> res = favoritegenre(userSongs, songGenres);
            System.out.println(res);
    }
}
