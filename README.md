# Random Joke Generator 🎭

A Python application that fetches random jokes from an external API (JokeAPI) and displays them in a user-friendly format.

## Features

- ✨ Fetch random jokes from multiple categories
- 📂 Support for different joke types (single and two-part)
- 🔄 Get multiple jokes at once
- 🛡️ Error handling and robust API communication
- 🧪 Comprehensive unit tests
- 📚 Well-documented code

## Installation

1. Clone the repository:
```bash
git clone https://github.com/wajidahmad0305/TestAutomationAcc1.git
cd TestAutomationAcc1
```

2. Install dependencies:
```bash
pip install -r requirements.txt
```

## Usage

### Basic Usage

Run the main script:
```bash
python joke_generator.py
```

### As a Module

```python
from joke_generator import JokeGenerator

# Initialize the generator
generator = JokeGenerator()

# Get a random joke
joke = generator.get_random_joke()
generator.print_joke(joke)

# Get a joke from a specific category
programming_joke = generator.get_random_joke(category="Programming")
generator.print_joke(programming_joke)

# Get multiple jokes
multiple_jokes = generator.get_multiple_jokes(count=5, category="Any")
for joke in multiple_jokes:
    generator.print_joke(joke)

# Clean up
generator.close()
```

## Supported Categories

- **Any**: Random joke from any category
- **Knock-Knock**: Knock-knock jokes
- **General**: General jokes
- **Programming**: Programming-related jokes
- **Dark**: Dark humor jokes

## API Details

**API Used**: [JokeAPI](https://v2.jokeapi.dev)

**Endpoints**:
- `GET /joke/{category}` - Fetch a random joke from a specific category

**Parameters**:
- `type`: Type of joke (`single`, `twopart`, or `any`)
- `format`: Response format (`json`)

## Testing

Run the unit tests:
```bash
python -m unittest test_joke_generator.py
```

Run tests with verbose output:
```bash
python -m unittest test_joke_generator.py -v
```

## Project Structure

```
.
├── joke_generator.py          # Main module with JokeGenerator class
├── test_joke_generator.py     # Unit tests
├── requirements.txt           # Python dependencies
└── README.md                  # This file
```

## Example Output

```
🎭 Random Joke Generator 🎭
Using JokeAPI: https://v2.jokeapi.dev

1. Getting a random joke from any category:

==================================================
Joke: Why did the programmer quit? Because he didn't get arrays.
Category: Programming
==================================================

2. Getting a programming joke:

==================================================
Setup: Why do programmers prefer dark mode?
Delivery: Because light attracts bugs!
Category: Programming
==================================================
```

## Error Handling

The generator handles various error scenarios:
- **Invalid category**: Defaults to "Any" category
- **Network errors**: Gracefully handles connection failures
- **API errors**: Detects and reports API-side errors
- **Timeout**: Default 5-second timeout for requests

## Requirements

- Python 3.7+
- requests library

## License

This project is open source and available under the MIT License.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Disclaimer

This project uses the free JokeAPI service. Please respect their terms of service and rate limits.
