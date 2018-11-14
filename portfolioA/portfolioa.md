# Executive Summary / Overview
 ### Client:
Our client is the Electrical and Electronic Engineering department. Our main point of contact is Dr Nick Simpson. The business sector is non-profit university use.
### Key Problem:
The main Electrical and Electronic Engineering Laboratory has recently undergone refurbishment resulting in approximately 90 sets of state-of-the-art test and measurement equipment, to be used by undergraduate students for their projects. However students just turn up whenever they like and causing a lack of spare seats and organisation in the lab. They also have to just turn up and hope there is space.
### Product Solution:
In order to help the students book their seats and equipment efficiently, our solution is a booking and attendance system, which will be a website, for the seats in the EE laboratory. The main website page will include a plan overview of the seats in the lab, where a user can clearly see the location of each seat. They can select a time period and the seat colours will change depending on the availability of the seats. The seats could be: available, booked for a lab session (by the admin, this will be for actual lab sessions for units on the course), unavailable (the seat has been booked) or locked (this would mean the seat is in the process of being booked, but not yet confirmed). This will allow the user to see availability of any seat at any time during the week with only a couple of clicks. Once they click on one seat, they will be given a page which they can select which equipment they will require when they use the laboratory. There will be a provided list of equipment and then a text box which the entered data gets sent the lab technician, Richard Walker, to view special requests or equipment which is not on the list. Some equipment might be unavailable also. Whilst they are doing this their seat will be locked so no other user can select this seat even though it is yet to be booked. The user will then confirm the seat booking.
The normal user, which will be a student, can view the entire weeks laboratory seats starting Monday at 9am, and they can book up to 3 consecutive hours. The student will then scan in to the lab using their UCARD, which will then record their attendance, and then they scan their UCARD to sign out. They will scan their UCARD on a RFID scanner in the lab itself. If they book seats and do not attend 3 times then they will be blacklisted. The way to get off the blacklist is to talk to the admin, they will decide if the student can be removed or not. A student would register for the website via a tablet and RFID scanner in the lab. They would enter their details onto the tablet, then once they have finished they will scan their UCARD as the final piece of data. This will record their unique UCARD ID and associate this with their account to track attendance.
The admin, will have a slightly different web page with more power than the basic user. They will be able to book for the coming week from Friday 9am, because they will need to book the set lab sessions for units before the normal students book these seats. They can also block book seats, not just one, and can remove students bookings. The admin can also view the blacklist and the equipment list.


# Laboratory Booking System : Requirements

### StakeHolders :
Approximately 200 EE students (user) : The main user of this web-app. They want to book it just for their own needs.
Mr.Richard Walker (admin) : He is the lab technician who will be using the project on a daily basis. Will be booking seats each week for set classes and will be the administrator of the system.
(Optional) Support / Maintenance people after the project is finished
Lecturers (user)  : There may be lecturers who want to use the lab for their own work or book it for special cases

#  Goals
###  1.Booking a seat
* Log-in
* Select time slot for booking
* Select seats for booking
* Select extra equipment needed
* Confirm
* Receive confirmation email

Alternative Flow : You click the equipment first then go back and find the slot which corresponds to the equipment available.

Exceptional Flow : The booking seat you want becomes “in progress” and the user has to wait until it is available or select an alternative seat.

Functional Requirements :
System should only allow students to book one week in advance
Student should be able to cancel their booking prior to time allocated
Student should not be able to cancel it after the time
Student must only be able to edit their bookings
Student must be able to reset their password in case they forget it

Non-functional Requirement:
Dependability : The user must be able to book their time slot if it is not “in progress” or must be able to book an alternative seat in that time slot (parallel access should be solved)

### 2. Admin Booking
* Admin Login
* Select time slot
* Select the seat(s) number
* Click confirm

Alternative Flow : Sometimes the admin wants to book the slot of seats first then select the time.
Exceptional Flow : If the seat is not available, he select the alternative time slot or select other seats.

Functional Requirement:
System should provide the admin absolute control of the timetable
Admin should be able to cancel/edit/add any bookings any time during the one week period
Admin should have a strong validation / secure login in order to access their privileges
Admin should be able to view/edit the blacklist of students
Admin must be able to print out the timetable
Admin should be able to access the timetable of the next week on Friday (9am)

### 3. Admin selection of Equipments (similar functional requirement as Admin Booking and Booking a seat)
* Admin Login
* Go to Equipment Page
* Select Time slot
* Select the number available for each

Alternative Flow : The Admin select the equipment first then select time slot (if the equipment is not going to be available for the whole day.

Exceptional Flow : none since he has the absolute control

Blacklisting
Student does not turn up for booking time slot
A strike is sent into their account and to admin table of names
If there are 3 strikes we send the name into blacklist
The Student booking account is temporarily blocked
Student is sent an email to contact admin and set up a meeting

Alternative Flow : The student sets up their own meeting with the admin and resolve problem at the first or two strikes.



Exceptional Flow : The student doesn’t set up a meeting and admin must be the one who contacts them instead.

### 4. Registering
* Enter Details
* Scan UCARD

Alternative Flow: None.
Exceptional Flow: If the scanner is not working or the user cannot scan their ucard, then they must go to the lab technician who has a spare RFID reader. If there is still a problem then the lab technician will use the number written on the UCARD in place of the scanned number.

Functional Requirement:
System should be able to provide a valid account for each individual student(to their UCARD)
Students should be able to edit their account details
Students should be able to access/register/login using their UCARD
System must register the unique ID of UCARD each time it is scanned
System must be friendly to all users (Especially those with dyslexia) by using san serif font
Registration and Bookings must be done on the web app available
Students user ID should be strictly linked to their ID on university email address.

Non-Functional Requirement :
Security Requirement : User personal info must be accessed by them
Students should use strong password(combination of capital letter, numbers and lower case...).
Students should use their own UCARD for registration.

User Interface Requirement :
Seats should be numbered for ease of use and common understanding.
The user interface should be efficient in terms of both feedback speed and interaction time.
The personal information for each user should be protected and only accessed by its account owner.
The booking information should be described with all personal information detail.
Images and its description form the signature of the document.
The User Interface should be able to interoperate across a wide variety of platforms, media types and networks.
Each button must clearly be labeled for the user
Each important progress should have a confirmation.
The User Interface should differentiate read-only displays from those that allow users to edit.
The control panel button should be large enough to guarantee that users do not hit a wrong one accidently.
The currently selected options should be highlighted in a list of options.
The font size (character height) shall be based on reading distance and guidance of HE75. Character height (inches) = Distance (minutes of arc)/(57.3 x 60)
There should be a saving button/function where the admin can save the schedule of last week booking and re-book it again in the next week

### 5. Blacklisting
* Student does not turn up for booking time slot
* A strike is sent into their account and to admin table of names
* If there are 3 strikes we send the name into blacklist
* The Student booking account is temporarily blocked
* Student is sent an email to contact admin and set up a meeting

Alternative Flow : The student sets up their own meeting with the admin and resolve problem at the first or two strikes.
Exceptional Flow : The student doesn’t set up a meeting and admin must be the one who contacts them instead.



# Stakeholders and Goals Relationship Diagram

# UML Diagram

* Development Testing Login
* Logout function
* Registration function
* Admin update function
* Seats Booking function
* Web UI function
* Confirmation email function

# Development Testing
| Testing Input | Expected Output |
| --------------| ----------------|
|Registered Username with wrong password | Username or Password incorrect |
|Logout function processed and cannot access account after refreshing| User cannot access account after refresh |
| Enter either only username and password | A text popup with “both username and password is required to login” |
| Registered using existing ucard number | Account id and email are already in the database and filled within registration form |
| Registered using non-existing ucard number| Account id and email should not exist and error message is displayed |
| Admin books the whole seats of a block/all seats/ a row | The student’s display of booking should show that it is booked/locked |
|Two users are in the same page with one booking a seat and the other still looking at a seat |The user who is still looking should see the seat status as “locked” and shouldn’t be able to access the booking of the particular seat |
| Time slot selected and seats and are displayed | Check with database, the information on both should matched |
| Manipulate the seats selection in the database | The seat booked should match in the student/admin display on web UI |
| Book a seat with selected equipment and time slot | Check confirmation email, the details should matched what was being selected |
| Enter “000000000000” as username and “11111111” as password | Error should display as “format of username doesn’t match” |
| Enter “admin” as username and “00000000000000” as password | Error should display “format of username doesn’t match” |
| Enter correct username “test@my.bristol.ac.uk” and “12345Abc” as password while adding it manually on the database | Login should be successful |
