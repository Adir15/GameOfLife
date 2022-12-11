# GameOfLife

The following program implements the game - the game of life.
It is a simulation game developed by the mathematician John Conway as a model for studying the life cycle of a living organism.
The game is played on a huge matrix whose members are possible living (existence) sites.
Each site can have one of the following two situations:
1. "There is life" - a place of life, will be marked as a full square on the matrix.
2. "There is no life" - an empty living space, will be marked as an empty square on the meter.

* From now on we will refer to each full square as "there is life" and an empty square as "no life"

When the initial image that opens when the game starts is random, and after that the full squares - the "living organisms" - operate according to Coway's genetic laws:
1. Birth - in every site where there is no life it has exactly 3 living neighbors, there will be birth in the next generation. Otherwise the cell will remain empty.
2. Death - in every site where there is life, which has 0 or 1 living neighbors, death will occur in the next generation as a result of loneliness.
Wherever there is life, even if 4 or more neighbors are alive, death will occur as a result of a population explosion.
3. Existence - in any site where there is life and it has 2 or 3 living neighbors, it will continue to exist in the next generation as well.

* The processes of birth, death and existence occur at the same time in all sites and thus a new life situation of a new generation is created.
*The diagonal squares should be considered as part of the neighbors of a square touching them.


# I implemented conway's idea with javafx.
When the game opens a matrix with a random amount of full squares will appear on it. 
Each press of the button will change the state of the squares on the matrix according to Conway's organism laws.

