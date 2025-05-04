package com.library.api.domain.trie;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Trie {
    private final TrieNode root = new TrieNode();

    public void insert(String title) {
        TrieNode current = root;
        for (char c : title.toLowerCase().toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }
        current.isEndOfWord = true;
        current.fullTitle = title;
    }

    public List<String> searchByPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode current = root;

        for (char c : prefix.toLowerCase().toCharArray()) {
            if (!current.children.containsKey(c)) {
                return results;
            }
            current = current.children.get(c);
        }

        dfs(current, results);
        return results;
    }

    private void dfs(TrieNode node, List<String> results) {
        if (node.isEndOfWord) {
            results.add(node.fullTitle);
        }
        for (char c : node.children.keySet()) {
            dfs(node.children.get(c), results);
        }
    }
}

