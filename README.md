# Hotel
Develop a program to simulate the operation of a hotel in (accelerated) real time.<br/>

Class "hotel": characterized by capacity (how many guests can take) and remembers the list of people who live in it at the moment. The class "request for stay" is characterized by the last name of the guest and the number of milliseconds of stay.<br/>

There are operations in the "hotel": settlements of the "request" (either successfully settles and returns true, or returns false in case of a lack of free places), eviction of the given "request" (explicitly called by the request itself at the right time - the hotel should not independently count milliseconds for each guest, because he can potentially extend his stay), search for a guest by last name.<br/>

The "request" checks into the hotel on its own, creating a separate thread for this (this can happen either automatically in the constructor or in a special method). If it is impossible to settle, the application goes into the waiting mode for the appearance of free places. After a successful settlement, the application counts (sleep) the specified number of milliseconds - and is evicted, freeing up a place in the hotel.<br/>

The main function tries to "accommodate" several requests in a hotel. But not at the same time, but at some intervals of time - in order to simulate the situation of their non-simultaneous arrival.<br/>

The hotel class displays diagnostic messages reporting check-in (successful and unsuccessful) and check-out operations - with time, request information, and number of remaining beds. It is required to visually demonstrate an unsuccessful check-in, waiting and subsequent successful check-in to a hotel after someone has been evicted.<br/>
