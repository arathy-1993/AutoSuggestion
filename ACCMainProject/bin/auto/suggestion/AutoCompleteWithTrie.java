package auto.suggestion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class AutocompleteWithTrie 
{
	public static void main(String[] args) 
	{
		Trie trieObject = new Trie();
		String fileName = "D:\\Canada\\University\\Semester 1\\ACC\\ACCMainProject\\resources\\Dictionary.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) //try with resources
		{ 
			stream.forEach(value -> trieObject.insertWord(value.toLowerCase()));
		} 
		catch (IOException e)
		{
			System.out.println("Error while reading file" + e);
		}
		Scanner sc= new Scanner(System.in); 
		String prefix= sc.nextLine(); 
		List<String> autoCompleteObject = trieObject.autoComplete(prefix);
		System.out.println("\nThe top 5 auto suggestions are:");
		System.out.println("--------------------------------");
		autoCompleteObject.stream().limit(5).forEach(System.out::println); // takes list of stream as input and prints the same
	}
}
