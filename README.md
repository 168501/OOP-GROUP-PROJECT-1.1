In our project,  we will focus on the operations found in a hotel via an program in object oriented programming.
Here are its following classes;
1)	MainSystem Class:

It serves as the menu for the Hotel Management System.
It provides options to:
I.	Book a reservation
II.	Log in as a receptionist
III.	View hotel information
IV.Employee Details
V.Supply details
VI.	Exit the system

2)	Reception Class:

The Reception class handles operations related to guest check-in and check-out.
It interacts with text files to manage reservations and current guest information.
It logs check-in and check-out events in the logs.txt file.
3)	Reservation Class:

This  handles the booking of reservations.
It collects guest information such as name, phone number, room type, check-in date, and duration.
It generates a guest ID and stores the reservation details in the reservations.txt file.

4)	Hotel Class:

This represents the hotel entity with properties like name, location, and contact details.
It is used to instantiate a hotel object in the HotelInfo class.
ReceptionistLogin Class:

The ReceptionistLogin class handles the login functionality for receptionists.
It prompts for a password and grants access to receptionist operations if the password is correct.
It calls the Reception class for receptionist tasks.
5)	HotelInfo Class:

This class displays information about the hotel.
It creates an instance of the Hotel class and prints details such as name, location, and contact information.

6)	Staff Class:

This class represents the staff information of the hotel.
It holds the records of all the information of the staff personnel and where each station the member works at.

7)	Supply Class:
This class holds the records of the supplies in the hotel and where the hotel gets its supplies from.


Text Files:
reservations.txt:

This text file stores information about reservations.
Each reservation entry includes guest details like name, phone number, room type, check-in date, and duration.
currentGuests.txt:

This text file keeps track of guests who are currently checked in.
It stores guest information, including guest ID, name, room type, and check-in status.
logs.txt:

The logs.txt file logs check-in and check-out action.
Each log includes the guest's name, guest ID, and the date and time of the action.
How to Run:
Compile and run the MainSystem class.
Select an option from menu:
Option 1: Book a reservation
Option 2: Log in as a receptionist
Option 3: View hotel information
Option 4: Exit the system
