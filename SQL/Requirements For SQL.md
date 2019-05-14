## This will be a variType map


# Global Music

## Tasks

- Design
- Code
- Test
- Group Report
- Individual Reflective Report
- Presentation

## Design

#### Features

- Public / Corporate
	/- Register
		- Username varchar(255),
		- Password varchar(255),
		- First Name varchar(255),
		- Last Name varchar(255),
		- Address varchar(255),
		- Phone int,
		- Email varchar(255),
		- Payment Details varchar(255)

	
	- Login
	- Account
		- Edit Account Details
	- Bookings
		- Previous Bookings
		- Current Bookings
	- Promotion
	- All Events
	- Band Profiles
		- Events
	- Book
		- 1 - * People
		- Price (Dependent)
		- Payment Public (Pay at Checkout)
		- Payment Corporate (Invoice)
		- No Cancellations

- Admin
	- Login
	- Events
	- Bookings
		- Confirm a booking (On Payment)
	- Invoice

- Agent
	- Book Events
		- Venu
		- Band
		- Time

- Organizer
	- Create Events
		- Venu
		- Band
		- Time
	- Edit / Cancel Events

> Desktop then web and mobile

#### DATABASE

- user
	- ID
	- USERNAME
	- PASSWORD
	- FNAME
	- LNAME
	- EMAIL
	- PHONE
	- COMPANY
	- DOB
	- SUD
	- TYPE

- ticket
	- ID
	- UID *
		- UFNAME
		- ULNAME
		- UCOMPANY
	- EID *
		- ENAME
		- EPRICE
		- EVENU
		- EDATE
		- ETIME
	- AMOUNT

- invoice
	- ID int,
	- UID * int,
		- UCOMPANY varchar(255),
	- EID * int,
		- ENAME varchar(255),
		- EPRICE varchar(255),
		- EAMOUNT varchar(255),
		- EDATE date,
		- ETIME time
	- DOP

- event
	- ID int,
	- NAME varchar(255),
	- VID * 
		- VNAME
		- VADDRESS
		- VCAPACITY
	- DATE
	- TIME
	- BID *
		- BNAME
	- PRICE

- band
	- ID
	- NAME
	- BIO
	- GENRE
	- MEMBERS
	- AMOUNT
	- URL
	- IMAGE

- venue
	- ID
	- NAME
	- ADDRESS
	- CAPACITY

## Code

#### DATABASE

- Create database tables

#### CLIENT (GUI)

#### SERVER

## Test