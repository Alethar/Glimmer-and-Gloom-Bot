# Glimmer-and-Gloom-Bot

EXAMPLE OF WORKING:
https://drive.google.com/file/d/1iD8VV77YpvhW54jfNrHOmfXmKOWtr1jy/view


This bot solves the game Glimmer and Gloom from Flight Rising a desired amount of times. The game is a puzzle game, and the objective is to make all tiles/hexes the same color. Each hex can be one of two colors, and clicking on a hex reverses the color of it and the surrounding 6 hexes.

The delays between each step/turn, the amount of games played/finished, and more variables can all be customized.

The bot relies on visual reading of on-screen pixels: the pixel position of the top left hex, distance to the hex to the right of it must be tuned before using the bot. (if you want to repeat games you should also tune the "play game", "hard mode", and "play again" button positions.

The most efficient combination of moves is calculated each time and executed with a slight delay between each step due to in-game lag. If enabled, the bot will automatically start and play a desired amount of games.
