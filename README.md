# appointment-management-case-study

- [Project Overview](#Project-Mission)
  - [Stretch Goals](#Stretch-Goals)
  - [MVP](#Minimum-Viable-Product)
- [User Stories](#User-Stories)
  - [Deliverable Goals](#Deliverable-Goals)
  - [Stretch Goals](#Stretch-Goals)
- [Development Progress](#Progress-updates)

## Project Mission

### Stretch Goals

This will eventually be a tool that allows flexible and intuitive scheduling and rescheduling of patient appointments, designed
to minimize the time and effort required to adapt to unforeseen circumstances by doctor and patient alike, incurring no cost
to the patient. All patients will be presented with a calender displaying their doctor's schedule updated in real-time, and
should the need arise will be able to shift their appointment to any of the doctor's available time-slots. Doctors will be presented
with a calender that is up to date with the patients that are scheduled for each appointment's time block.

### Minimum Viable Product

For purposes of this capstone, however, development will need to be scaled back in order to deliver a complete product by the due date.
Deliverable will be an application that allows patients to seek and select a doctor of their choice, presenting their specialty (if applicable),
as well as the location of the doctor's practice and the doctor's contact information. After the patient speaks with the doctor to schedule
an appointment, the doctor can then put that information in to the application and it will update on both the doctor's end and the patient's end.
The doctor and patient will both be presented with a list of all of their upcoming appointments.

## User Stories

### Deliverable Goals

- As a user, I want to be able to sign up for an account so that I can store my information.

- As a user, I want to be able to log in to this account so that I can retrieve this information.

- As a patient, I want to be able to browse care providers, and view their contact information.

- As a patient, I want to see all of my upcoming appointments in a list-like view, displaying the date/time of the appointment and the general purpose of it.

- As a doctor, I want to see all of my upcoming appointments in a list-like view, displaying the date/time of the appointment and the patient's name so that
  I can gather relevant information ahead of time.

- As a doctor, I want to be able to schedule appointments with my patients, and have that information transferred to their app.

### Stretch Goals

- As a patient, I want to be able to select an appointment from this list to see more specific details about the appointment or reschedule it.

- As a patient, when I select see more specific details, I want to be able to see a detailed overview of the appointment, including the
  nature of the appointment, care provider, calender date, specific time, and practice address.

- As a patient, when I select reschedule, I want to see a calender view, and be able to select a day from that calender to reschedule to.

- As a patient, when I select a day from the calender, I want to be presented with a list of the doctor's available time blocks on that day, and be able to
  choose one of them to set my appointment to.

- As a doctor, I want to be able to select any day from a calender and see my upcoming appointments for that day, so that I may adequately prepare whatever I
  may need for them.

- As a doctor, I want to be notified if something in the scheduling of the next three days has changed.

### Progress updates

4/25/2022 End of School Day: 99% complete

User homepages rendered contingent to user type have been implemented. I can still add some optional things should I find time, but I'm inclined to leave everything as is for purposes of my presentation, since everything is functional without failure and looking clean.

4/24/2022 End of Day: 98% complete

Everything is styled and looks nice. Working on page redirect logic, but worst case scenario, those pages aren't really necessary and the app is fully functional and flows nicely if we default to using the appointments view as the user homepage. I would like to refactor a few things about the specific appointment view for both doctors and patients, and I'll get to that if I have time.

4/22/2022 End of School Day: 95% complete

Started writing tests today, all of which pass. It's a simple matter of echoing the written tests in other test classes since the logic across all classes is very similar. The login redirect functionality is now implemented, so I need to write the user landing pages for each login case, but this will be quite simple as the pages themselves will have minimal features with nothing more logically complicated than a few redirect buttons. All that truly remains is styling.

4/21/2022 End of School Day: 92% complete

I decided that the easiest and thus quickest method of setting up different user flows for this particular app is to branch in to two separate user flows starting from a different homepage view being presented upon login contingent on what type of user is being logged in. I've set up two distinct navbars each with their own navigation options to this end, and am working on implementing the selective display on login functionality. Past this, it's tests and styling.

4/20/2022 End of School Day: 88% complete

All of my user security and CRUD functionality is implemented without any failure. I still need to write tests and navigation functionality, as well as leverage Spring security to protect endpoints/extend permissions, but outside of that the only thing remaining to do is styling.

4/19/2022 End of School Day: 65% complete

I discovered I'd inadvertantly tied up my business logic and my security logic and it was preventing me from properly leveraging the JPA Repository "save" functionality for my tables, so I spent quite a bit of time disentangling those. They're now fully separated and everything is working as intended. Currently attempting to work through some odd user data persistence issues.

4/18/2022 End of School Day: 65% complete

Registration bug ran deeper than initially anticipated, I started experiencing complete failure to register so I had to iron that out before proceeding. On the bright side, user registration now works perfectly as intended with zero failures. I still need to write logic for retrieving and manipulating data specific to the logged in user, as well as the various role permissions, but this shouldn't take very long now that I can actually proceed with it. I've also reformatted this README and added navigation to it for easy reading.

4/17/2022 End of Day: 60% complete

Registration that creates users of different types is implemented. There are currently two bugs that might actually have the same cause, namely, sporadic registration failure and ID jumping in the database; but as of yet I've been unable to ascertain exactly what's going wrong. I'll ask tomorrow during class, perhaps somebody else has encountered this. Next step is writing logic that leverages these new user IDs to store and load data as well as protecting certain endpoints and delegating specific permissions based on the type of user, and figuring out how to use the principal user to load the correct data for the logged in user. This should be straightforward, I think, and then it's just a matter of writing tests and prettier front-end.

4/15/2022 End of School Day: 50% complete

Registration and login for a basic user is implemented, I need to implement logic to register this user as either a patient or doctor from the form data and then leverage Spring Security to protect various endpoints and create permissions for the two different types of user. Most of today was centered on engineering this functionality, I had a few unexpected things spring up but it's looking like pretty smooth sailing from here.

4/14/2022 End of School Day: 40% complete

Spent most of the day taking down what I had been working on after discovering what I was trying to implement wasn't really possible within the constraints of Spring Security. This is hopefully the last major revision this project will have to go through, five rebuilds later. I'll have more free time tonight than I've had the previous two nights so I'm going to try and get this registration up and running by the end of the night, so that I can begin building in earnest. Once again, after this is done, I'll need to write up front-end interfaces, unit tests, and integration tests.

4/13/2022 End of School Day: 40% complete

Continuing progress implementing Spring Security and user roles so that I have persistent user information to work with. I've spent a long time looking at various tutorials and none
really seem to cover this type of implementation, so hopefully I can get some more specific guidance tomorrow. As with yesterday, once persistent users are implemented, most of the rest of the code should write itself. Need to write front-end interface, unit tests, and integration tests.

4/12/2022 End of School Day: 35% complete

Baseline functionality for appointment CRUD operations implemented, fully implementing the desired displays is contingent upon ironing out the registration/login functionality.
Once I have persistent users implemented, it should be fairly quick refactoring to get the exact views that I want sorted out (in terms of logic at least), and that should easily
elevate me to 70 - 75% completion. After that I'll be needing to implement unit and integration tests, and get a visually clean front-end up and running.
