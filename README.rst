AttackHelper
============

*Great for dnd enthusiasts who want to save time in combat or for new players who want to make combat easier.*
 
The purpose of this program is to automate an attack in dungeons and dragons. Normally, making an attack takes time and you have to roll quite a few dice and make calculations, so this system aims to reduce the headache. This program is designed for certain characters in the game of dungeons and dragons. The types of characters for whom this program is meant for includes any characters that are barbarians of any level or paladins up to level 12. Any combination of these two classes is also viable, so long as paladin does not go beyond level 12. There is a limited selection of weapons available in this program at the moment. User must understand basic java to use this program as intended.

Unfamiliar with Dnd? No Problem!
--------------------------------
Terms to Know:

- Armor Class: a number assigned to every creature that shows how hard it is to hit
- Attack Roll: a number calculated by rolling a twenty sided die and adding different modifers to it
- Creature: refers to all living entities including monsters and players
- GM: this is the head of each dungeons and dragons campaign. They hold all information and designate the actions of non-player characters
- NAT TWENNY: this is a possible result of the attack roll of the program. A NAT TWENNY always hits the target and does extra damage.

The combat system of dungeons and dragons can be a daunting thing. AttackHelper is here to help simplify all of this for you, but there are still a few things you must know when fighting. As soon as combat begins in dungeons and dragons all creatures participating roll initiative and then during combat each creature takes its turn based on that initiative roll. Rolling initiative means to roll a twenty sided die and add your dexterity modifier to it. On your turn if you are nearby a creature, you can attack it - here is where you use the program. After configuring the program as you want (configuration information is available later), click on the large "Do The Thing" button on the left. The largest number at the bottom of the GUI is calculated using your stats and a simulated roll of a twenty sided die, and this number must surpass the enemy's armor class in order for the damage to go through. If the enemy's armor class is low enough, congrats! Simply tell your GM your total damage, as designated in the GUI. Otherwise, your attack does not hit.

Installation
------------

*Please note that you must have a java development kit installed on your computer.*

If you would like to download or just look at the code, please visit the github page https://github.com/howardjw2/AttackHelper/

If you're curious about the naming scheme of the java files, the name Bol comes from the character that this program was originally based on.

After the download and after making any desired changes, you can turn this into a jar file. You must have a java runtime environment if you wish to do this and you should have a basic understanding of java. To turn the program into a jar file, see https://docs.oracle.com/javase/tutorial/deployment/jar/build.html

Configurations in the Code
--------------------------



Configurations in the GUI
-------------------------

Configurations to Make Before Clicking the "Do The Thing" Button:

- Dropbox that allows you to select which weapons to attack with
- Dropbox that allows you to select if you have advantage or disadvantage on an attack roll
- Dropbox that allows you to select with how many charges of your Goat Staff you would like to hit with
- Dropbox that allows you to choose if you want to use a paladin's divine smite, and at what level
- Checkbox to be activated if your character is currently in a barbarian rage
- Checkbox to be activated if your character would like to use the battlemaster feature
- Checkbox to be activated only if you know your character will deal the extra damage of a critical attack (see NAT TWENNY above)
 
Configurations to Make After Clicking the "Do The Thing" Button:

- 4 buttons that allow you to mitigate damage, in case the enemy has resistance to a certain damage type. Every press of a button will halve the damage of the specified damage type.

Weapon Damages and Weapon Notes:

+----------------+----------------+----------------+----------------+----------------+
| Goat Staff     | Demon Hammer   | Javelin        | Longbow        | Fire Shield    |
+================+================+================+================+================+
| 1 six sided    | 1 eight sided  | 1 eight sided  | 1 eight sided  | 2 four sided   |
| die + 3        | die + 2 six    | die, no        | die, no        | dice           |
|                | sided dice + 2 | modifier       | modifier       |                |
+----------------+----------------+----------------+----------------+----------------+
| Add a six sided|                | A weapon with  | A weapon with  |                |
| die of damage  |                | a 30/120 range | a 150/600      |                |
| for each charge|                | range          | range          |                |
| of the charges |                |                |                |                |
| dropbox        |                |                |                |                |
+----------------+----------------+----------------+----------------+----------------+

Contribute
----------
 
- Issue Tracker: github.com/howardjw2/AttackHelper/issues
- Source Code: github.com/howardjw2/AttackHelper
 
Support
-------
 
For any questions or concerns, please contact me at notarealemail@____.com

If you have any complaints and would like points deducted off of this assignment, please forward all issues to pleasedontfailme@____.com

Please understand that this code was written by a younger version of myself and it doesn't hold up to many, if any, standards of cleanliness.
 
License
-------
 
The project is licensed under the BSD license.
