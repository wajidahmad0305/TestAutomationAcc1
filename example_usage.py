#!/usr/bin/env python3
"""
Example usage scenarios for the Joke Generator.
Demonstrates various ways to use the JokeGenerator class.
"""

from joke_generator import JokeGenerator
import time


def example_1_single_joke():
    """
    Example 1: Fetch and display a single random joke.
    """
    print("\n" + "="*60)
    print("EXAMPLE 1: Single Random Joke")
    print("="*60)
    
    generator = JokeGenerator()
    joke = generator.get_random_joke()
    generator.print_joke(joke)
    generator.close()


def example_2_category_specific():
    """
    Example 2: Fetch jokes from specific categories.
    """
    print("\n" + "="*60)
    print("EXAMPLE 2: Category-Specific Jokes")
    print("="*60)
    
    generator = JokeGenerator()
    categories = ["Programming", "Knock-Knock", "Dark", "General"]
    
    for category in categories:
        print(f"\n📍 Fetching {category} joke...")
        joke = generator.get_random_joke(category=category)
        generator.print_joke(joke)
        time.sleep(0.5)  # Be respectful to the API
    
    generator.close()


def example_3_multiple_jokes():
    """
    Example 3: Fetch multiple jokes at once.
    """
    print("\n" + "="*60)
    print("EXAMPLE 3: Multiple Jokes")
    print("="*60)
    
    generator = JokeGenerator()
    jokes = generator.get_multiple_jokes(count=5, category="Programming")
    
    print(f"\n🎭 Fetched {len(jokes)} programming jokes:\n")
    for idx, joke in enumerate(jokes, 1):
        print(f"Joke #{idx}:")
        generator.print_joke(joke)
    
    generator.close()


def example_4_filtered_jokes():
    """
    Example 4: Get jokes based on type (single vs two-part).
    """
    print("\n" + "="*60)
    print("EXAMPLE 4: Different Joke Types")
    print("="*60)
    
    generator = JokeGenerator()
    
    print("\n📝 Single Joke:")
    single_joke = generator.get_random_joke(joke_type="single")
    generator.print_joke(single_joke)
    
    print("\n📖 Two-Part Joke:")
    two_part_joke = generator.get_random_joke(joke_type="twopart")
    generator.print_joke(two_part_joke)
    
    generator.close()


def example_5_error_handling():
    """
    Example 5: Demonstrate error handling.
    """
    print("\n" + "="*60)
    print("EXAMPLE 5: Error Handling")
    print("="*60)
    
    generator = JokeGenerator()
    
    print("\n⚠️  Attempting to fetch joke with invalid category:")
    joke = generator.get_random_joke(category="InvalidCategory")
    generator.print_joke(joke)
    
    print("✅ Program handled the error gracefully!")
    generator.close()


def main():
    """
    Run all examples.
    """
    print("\n" + "*"*60)
    print("*" + " "*58 + "*")
    print("*" + "  JOKE GENERATOR - USAGE EXAMPLES".center(58) + "*")
    print("*" + " "*58 + "*")
    print("*"*60)
    
    try:
        example_1_single_joke()
        example_2_category_specific()
        example_3_multiple_jokes()
        example_4_filtered_jokes()
        example_5_error_handling()
        
        print("\n" + "*"*60)
        print("✨ All examples completed successfully! ✨")
        print("*"*60 + "\n")
    
    except Exception as e:
        print(f"\n❌ An error occurred: {e}")


if __name__ == "__main__":
    main()
