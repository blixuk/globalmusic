
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
	- Register
		- Username
		- Password
		- First Name
		- Last Name
		- Address
		- Phone
		- Email
		- Payment Details
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
`		- EPRICE
		- EVENU
		- EDATE
		- ETIME
	- AMOUNT

- invoice
	- ID
	- UID *
		- UCOMPANY
	- EID *
		- ENAME
		- EPRICE
		- EAMOUNT
		- EDATE
		- ETIME
	- DOP

- event
	- ID
	- NAME
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