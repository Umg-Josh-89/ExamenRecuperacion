/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beesion.ms.test.service.crossword;


import java.util.HashSet;
import java.util.Set;

public class Crossword {
    private final Set<String> dictionary;

    public Crossword(Set<String> dictionary) {
        this.dictionary = new HashSet<>(dictionary);
    }

    public boolean validateBoard(char[][] board) {
        try {
            validateAllRows(board);
            validateAllColumns(board);
            return true;
        } catch (InvalidCrosswordException e) {
            return false;
        }
    }

    private void validateAllRows(char[][] board) throws InvalidCrosswordException {
        for (char[] row : board) {
            validateSequence(row);
        }
    }

    private void validateAllColumns(char[][] board) throws InvalidCrosswordException {
        for (int col = 0; col < board[0].length; col++) {
            char[] column = new char[board.length];
            for (int row = 0; row < board.length; row++) {
                column[row] = board[row][col];
            }
            validateSequence(column);
        }
    }

    private void validateSequence(char[] sequence) throws InvalidCrosswordException {
        StringBuilder currentWord = new StringBuilder();
        
        for (char c : sequence) {
            if (c == '#') {
                checkWord(currentWord);
                currentWord.setLength(0); // Reset
            } else {
                currentWord.append(c);
            }
        }
        checkWord(currentWord);
    }

    private void checkWord(StringBuilder word) throws InvalidCrosswordException {
        if (word.length() >= 2) {
            String wordStr = word.toString();
            if (!dictionary.contains(wordStr)) {
                throw new InvalidCrosswordException("Invalid word: " + wordStr);
            }
        }
    }
}