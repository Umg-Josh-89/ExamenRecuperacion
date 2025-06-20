package CrosswordTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rodol
 */



import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import com.beesion.ms.test.service.crossword.Crossword;
public class CrosswordTest {
    
    private Set<String> dictionary;
    private Crossword validator;
    
       
    @BeforeEach
    public void setUp() {
        dictionary = new HashSet<>();
        dictionary.add("HELLO");
        dictionary.add("WORLD");
        dictionary.add("WORD"); 
        dictionary.add("JAVA");
        dictionary.add("CODE");
        dictionary.add("CAT");
        dictionary.add("PYTHON");
        
        validator = new Crossword(dictionary);
    }
    
    @Test
    public void testValidBoard() {
        char[][] board = {
            {'H','E','L','L','O','#','W','O','R','D'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'J','A','V','A','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'C','O','D','E','#','C','A','T','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','#','P','Y','T','H','O','N','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'}
        };
        
        assertTrue(validator.validateBoard(board), 
            "El tablero debería ser válido con todas las palabras en el diccionario");
    }
    
    @Test
    public void testShortWordNotValidated() {
        char[][] board = {
            {'H','E','L','L','O','#','W','O','R','D'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'J','A','V','A','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'C','O','D','E','#','C','A','T','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','#','P','Y','T','H','O','N','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','A','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'}
        };
        
        assertTrue(validator.validateBoard(board), 
            "El tablero debería ser válido ya que 'A' es demasiado corta para validar");
    }
    
    
    @Test
    public void testInvalidWordInRow() {
        char[][] board = {
            {'H','E','L','L','O','#','W','O','R','D'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'J','A','V','A','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'C','O','D','E','#','C','A','T','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','#','P','Y','T','H','O','N','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','#','I','N','V','A','L','I','D','#'},
            {'#','#','#','#','#','#','#','#','#','#'}
        };
        
        assertFalse(validator.validateBoard(board));
    }
    
    @Test
    public void testInvalidWordInColumn() {
        char[][] board = {
            {'H','E','L','L','O','#','W','O','R','D'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'J','A','V','A','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'C','O','D','E','#','C','A','T','#','#'},
            {'#','#','#','#','#','#','#','#','#','I'},
            {'#','#','P','Y','T','H','O','N','#','N'},
            {'#','#','#','#','#','#','#','#','#','V'},
            {'#','#','#','#','#','#','#','#','#','A'},
            {'#','#','#','#','#','#','#','#','#','L'}
        };
        
        assertFalse(validator.validateBoard(board));
    }
    
    @Test
    public void testEmptyDictionary() {
        Crossword emptyValidator = new Crossword(new HashSet<>());
        char[][] board = {
            {'H','I'}
        };
        
        assertFalse(emptyValidator.validateBoard(board));
    }
}