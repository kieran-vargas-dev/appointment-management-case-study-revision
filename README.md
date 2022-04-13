# appointment-management-case-study

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

4/12/2022 End of School Day: 35% complete
Baseline functionality for appointment CRUD operations implemented, fully implementing the desired displays is contingent upon ironing out the registration/login functionality.
Once I have persistent users implemented, it should be fairly quick refactoring to get the exact views that I want sorted out (in terms of logic at least), and that should easily
elevate me to 70 - 75% completion. After that I'll be needing to implement unit and integration tests, and git a visually clean front-end up and running.
