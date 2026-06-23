import requests
import json
from typing import Dict, Optional

class JokeGenerator:
    """
    A random joke generator that fetches jokes from the JokeAPI.
    Supports multiple categories and joke types.
    """
    
    BASE_URL = "https://v2.jokeapi.dev/joke"
    CATEGORIES = ["Any", "Knock-Knock", "General", "Programming", "Dark"]
    JOKE_TYPES = ["single", "twopart"]
    
    def __init__(self):
        """Initialize the JokeGenerator."""
        self.session = requests.Session()
    
    def get_random_joke(self, category: str = "Any", joke_type: str = "any") -> Optional[Dict]:
        """
        Fetch a random joke from the API.
        
        Args:
            category (str): The joke category (Any, Knock-Knock, General, Programming, Dark)
            joke_type (str): Type of joke (single, twopart, any)
        
        Returns:
            Dict: Joke data or None if request fails
        """
        try:
            # Validate inputs
            if category not in self.CATEGORIES:
                print(f"Invalid category. Available: {', '.join(self.CATEGORIES)}")
                category = "Any"
            
            # Build URL with parameters
            url = f"{self.BASE_URL}/{category}"
            params = {
                "type": joke_type,
                "format": "json"
            }
            
            # Make the API request
            response = self.session.get(url, params=params, timeout=5)
            response.raise_for_status()
            
            joke_data = response.json()
            
            # Check if error in response
            if joke_data.get("error"):
                print(f"API Error: {joke_data.get('message', 'Unknown error')}")
                return None
            
            return joke_data
        
        except requests.exceptions.RequestException as e:
            print(f"Error fetching joke: {e}")
            return None
    
    def print_joke(self, joke_data: Optional[Dict]) -> None:
        """
        Print a joke in a formatted way.
        
        Args:
            joke_data (Dict): The joke data from the API
        """
        if not joke_data:
            print("No joke data to display.")
            return
        
        print("\n" + "="*50)
        
        if joke_data.get("type") == "single":
            print(f"Joke: {joke_data.get('joke')}")
        else:
            print(f"Setup: {joke_data.get('setup')}")
            print(f"Delivery: {joke_data.get('delivery')}")
        
        print(f"Category: {joke_data.get('category')}")
        print("="*50 + "\n")
    
    def get_multiple_jokes(self, count: int = 5, category: str = "Any") -> list:
        """
        Fetch multiple jokes.
        
        Args:
            count (int): Number of jokes to fetch
            category (str): The joke category
        
        Returns:
            list: List of joke data
        """
        jokes = []
        for _ in range(count):
            joke = self.get_random_joke(category)
            if joke:
                jokes.append(joke)
        return jokes
    
    def close(self) -> None:
        """Close the session."""
        self.session.close()


def main():
    """
    Main function to demonstrate the JokeGenerator.
    """
    print("🎭 Random Joke Generator 🎭")
    print("Using JokeAPI: https://v2.jokeapi.dev")
    
    generator = JokeGenerator()
    
    try:
        # Get a single random joke
        print("\n1. Getting a random joke from any category:")
        joke = generator.get_random_joke()
        generator.print_joke(joke)
        
        # Get a programming joke
        print("2. Getting a programming joke:")
        programming_joke = generator.get_random_joke(category="Programming")
        generator.print_joke(programming_joke)
        
        # Get multiple jokes
        print("3. Getting 3 random jokes:")
        multiple_jokes = generator.get_multiple_jokes(count=3)
        for idx, j in enumerate(multiple_jokes, 1):
            print(f"\nJoke {idx}:")
            generator.print_joke(j)
    
    finally:
        generator.close()
        print("\n✅ Done! Thanks for laughing!")


if __name__ == "__main__":
    main()
