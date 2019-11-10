package bfs.p127;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LeetCode: 127. 单词接龙
 */
public class Solution {

    Map<String, List<String>> graph = new HashMap<>();

    class WordCount {
        String word;
        Integer count;

        WordCount(String myWord, Integer myCount) {
            this.word = myWord;
            this.count = myCount;
        }

        public String getWord() {
            return this.word;
        }

        public Integer getCount() {
            return this.count;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size()==0) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }

        generateGraph(beginWord, wordList);
        return bfsGraph(beginWord, endWord);
    }


    private Integer bfsGraph(String beginWord, String endWord) {
        Queue<WordCount> queue = new LinkedBlockingQueue<>();
        Set<String> visit = new HashSet<>();
        queue.add(new WordCount(beginWord, 1));
        visit.add(beginWord);

        while (!queue.isEmpty()) {
            WordCount wc = queue.poll();
            String word = wc.getWord();
            Integer count = wc.getCount();
            //System.out.println("word: " + word + ", count: " + count);

            if (endWord.equals(word)) {
                return count;
            }

            List<String> neighbors = graph.get(word);
            //System.out.println("neighbors: " + neighbors);
            for (int i=0; i<neighbors.size(); i++) {
                if (!visit.contains(neighbors.get(i))) {
                    queue.add(new WordCount(neighbors.get(i),count+1));
                    visit.add(neighbors.get(i));
                }
            }
        }

        return 0;
    }


    // 生成图
    private void generateGraph(String beginWord, List<String> wordList) {
        wordList.add(beginWord);

        for (String word : wordList) {
            graph.put(word, new ArrayList<>());
        }

        for (int i=0; i<wordList.size(); i++) {
            for (int j=i+1; j<wordList.size(); j++) {
                if (connect(wordList.get(i), wordList.get(j))) {
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
    }

    // word1和word2是否只有一个字符不相等
    private boolean connect(String word1, String word2) {
        int count = 0;
        for (int i=0; i<word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count==1;
    }


    public static void main(String[] args) {
        Solution sl = new Solution();
        List<String> wl = new ArrayList<>();
        wl.add("hot");
        wl.add("dot");
        wl.add("dog");
        wl.add("lot");
        wl.add("log");
        wl.add("cog");
        sl.ladderLength("hit", "cog", wl);
    }
}
