import unittest
from unittest.mock import patch, MagicMock
from joke_generator import JokeGenerator
import requests


class TestJokeGenerator(unittest.TestCase):
    """
    Unit tests for the JokeGenerator class.
    """
    
    def setUp(self):
        """Set up test fixtures."""
        self.generator = JokeGenerator()
    
    def tearDown(self):
        """Clean up after tests."""
        self.generator.close()
    
    def test_initialization(self):
        """Test that JokeGenerator initializes correctly."""
        self.assertIsNotNone(self.generator.session)
        self.assertIsNotNone(self.generator.BASE_URL)
        self.assertEqual(len(self.generator.CATEGORIES), 5)
    
    @patch('requests.Session.get')
    def test_get_random_joke_success(self, mock_get):
        """Test successful joke retrieval."""
        mock_response = MagicMock()
        mock_response.json.return_value = {
            "type": "single",
            "joke": "Why did the programmer quit? Because he didn't get arrays.",
            "category": "Programming",
            "error": False
        }
        mock_get.return_value = mock_response
        
        joke = self.generator.get_random_joke()
        
        self.assertIsNotNone(joke)
        self.assertEqual(joke["type"], "single")
        self.assertIn("joke", joke)
    
    @patch('requests.Session.get')
    def test_get_random_joke_two_part(self, mock_get):
        """Test two-part joke retrieval."""
        mock_response = MagicMock()
        mock_response.json.return_value = {
            "type": "twopart",
            "setup": "Why did the chicken cross the road?",
            "delivery": "To get to the other side!",
            "category": "Knock-Knock",
            "error": False
        }
        mock_get.return_value = mock_response
        
        joke = self.generator.get_random_joke()
        
        self.assertIsNotNone(joke)
        self.assertEqual(joke["type"], "twopart")
        self.assertIn("setup", joke)
        self.assertIn("delivery", joke)
    
    @patch('requests.Session.get')
    def test_get_random_joke_api_error(self, mock_get):
        """Test handling of API errors."""
        mock_response = MagicMock()
        mock_response.json.return_value = {
            "error": True,
            "message": "Invalid category"
        }
        mock_get.return_value = mock_response
        
        joke = self.generator.get_random_joke(category="Invalid")
        
        self.assertIsNone(joke)
    
    @patch('requests.Session.get')
    def test_get_random_joke_network_error(self, mock_get):
        """Test handling of network errors."""
        mock_get.side_effect = requests.exceptions.RequestException("Connection error")
        
        joke = self.generator.get_random_joke()
        
        self.assertIsNone(joke)
    
    @patch('requests.Session.get')
    def test_get_multiple_jokes(self, mock_get):
        """Test fetching multiple jokes."""
        mock_response = MagicMock()
        mock_response.json.return_value = {
            "type": "single",
            "joke": "Test joke",
            "category": "Any",
            "error": False
        }
        mock_get.return_value = mock_response
        
        jokes = self.generator.get_multiple_jokes(count=3)
        
        self.assertEqual(len(jokes), 3)
        self.assertTrue(all(isinstance(joke, dict) for joke in jokes))
    
    def test_print_joke_single(self, capsys=None):
        """Test printing a single joke."""
        joke_data = {
            "type": "single",
            "joke": "Test joke",
            "category": "Programming"
        }
        
        # Should not raise any exception
        self.generator.print_joke(joke_data)
    
    def test_print_joke_two_part(self, capsys=None):
        """Test printing a two-part joke."""
        joke_data = {
            "type": "twopart",
            "setup": "Setup",
            "delivery": "Delivery",
            "category": "Knock-Knock"
        }
        
        # Should not raise any exception
        self.generator.print_joke(joke_data)
    
    def test_print_joke_none(self, capsys=None):
        """Test printing None joke data."""
        # Should not raise any exception
        self.generator.print_joke(None)
    
    def test_invalid_category(self):
        """Test handling of invalid category."""
        # Should default to 'Any' category
        with patch('requests.Session.get') as mock_get:
            mock_response = MagicMock()
            mock_response.json.return_value = {"error": False}
            mock_get.return_value = mock_response
            
            self.generator.get_random_joke(category="InvalidCategory")
            
            # Verify that the request was made (even with invalid category)
            mock_get.assert_called_once()


if __name__ == "__main__":
    unittest.main()
