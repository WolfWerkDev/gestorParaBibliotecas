package com.library.api.domain.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
    String fullTitle = null; // Guarda el título completo si llega al final
}

