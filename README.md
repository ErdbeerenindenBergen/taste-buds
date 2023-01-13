# Taste Buds
​
Designed to find the perfect place to dine. Restaurant matching and voting application using MVC pattern and RESTful APIs. Registered Taste Buds users can search for restaurants in a desired area and create scheduled events. Friends are invited via unique links to view restaurant information and submit votes. The program will record votes and calculate the winning restaurants. Utilizes Java, SpringBoot, JSON, Vue.js, Yelp Fusion API, and PostgreSQL.
​


Log in: 
<img width="1005" alt="Screen Shot 2023-01-12 at 11 33 13 PM" src="https://user-images.githubusercontent.com/114823741/212240757-7c01c269-a976-4cd5-8797-0999be9f7400.png">
​


If you do not have an account, you can make one:
<img width="1007" alt="Screen Shot 2023-01-12 at 11 33 30 PM" src="https://user-images.githubusercontent.com/114823741/212240839-dce9a058-ded6-4114-b879-f320d1879ab6.png">
​


From there you can select whether to search for restaurants (and perhaps save some new favorites!) or to plan an event:
<img width="1012" alt="Screen Shot 2023-01-12 at 11 32 46 PM" src="https://user-images.githubusercontent.com/114823741/212240885-149cae94-49e1-4924-a536-fe5964a2689c.png">
​


If you choose to search for restaurants, you may enter a city or a zipcode (the state is optional). Anytime restaurants are displayed in a list like below, individualized links will be included below the image that connect to the restaurant's yelp page and to it's google location via google maps, which is navigable. Additional information will be displayed on the right side of the image, including ratings, opening hours, etc. and a link to dial the number if you are viewing the page with a cellphone.
<img width="997" alt="Screen Shot 2023-01-12 at 11 34 06 PM" src="https://user-images.githubusercontent.com/114823741/212241012-9d986953-5f87-4a82-912b-a4c8043eecd6.png">
​


If you choose to plan an event, you will be taken to the plan and event form page. Here you may toggle between three forms as you please. Your information is saved as you plan. You may not submit the form, however, until all required inputs are complete. Once all information is entered and you click submit, invitations will be emailed to your invitees.

Step 1. Plan the date and time of your event and give a deadline for when your "buds" must respond to an invite.
<img width="1011" alt="Screen Shot 2023-01-12 at 11 34 18 PM" src="https://user-images.githubusercontent.com/114823741/212241277-5091b70b-05ad-4c7a-ac83-44b76dbe4e70.png">

Step 2. Select your restaurants. The fork and knife icon will toggle from purple to gold (or the reverse). If the icon is gold, you have added a restaurant to your event list.
<img width="1008" alt="Screen Shot 2023-01-12 at 11 34 30 PM" src="https://user-images.githubusercontent.com/114823741/212241289-c5d88a10-99df-4057-a711-bdbcb3f20951.png">
<img width="1013" alt="Screen Shot 2023-01-12 at 11 50 45 PM" src="https://user-images.githubusercontent.com/114823741/212241654-8cf7641b-4046-4a85-bc50-1cb2704fe417.png">

Step 3. Invite your buds by entering their email addresses!
<img width="995" alt="Screen Shot 2023-01-12 at 11 40 14 PM" src="https://user-images.githubusercontent.com/114823741/212241603-45399d24-1803-46b4-844e-db69ed5d6570.png">
​


If you are invited to vote on an event, you will receive a link via email. Click the link to open your voting form. Here you'll find a list of all the restaurants selected for the event and you can vote "yes" or "no" by clicking on the thumbs-up or thumbs-down icon. Clicking one will disable the other. The thumbs-up icon appears green for a "yes" vote while the thumbs-down appears red for a "no" vote. 
<img width="1031" alt="Screen Shot 2023-01-12 at 11 52 30 PM" src="https://user-images.githubusercontent.com/114823741/212241915-06888e5f-9f0d-4c52-8fb0-e4f077f5cf27.png">
​


If you are an authenticated user, you may view the voting results from any event you have organized by going to the Events page. By clicking on an event, you'll see a ranked list of restaurants from most to least votes. The winning restaurant(s) will display a gold trophy below their images (we thought this would be helpful in case there is a tie!).
<img width="955" alt="Screen Shot 2023-01-13 at 12 14 01 AM" src="https://user-images.githubusercontent.com/114823741/212242753-9467b3a8-cd65-4f8e-8714-0496a85d457b.png">


We included an "About page" if you want to read more about our team.
<img width="1073" alt="Screen Shot 2023-01-12 at 11 41 27 PM" src="https://user-images.githubusercontent.com/114823741/212242930-a1fe8aa0-f72b-4298-9251-de89575435c7.png">


Finally, we ensured that our webpage was made mobile friendly. We also built all our CSS from scratch (without Bootstrap, Vuetify, etc.) so everything right down to the bars of the hamburger menu were hard-coded with care!

<img width="294" alt="Screen Shot 2023-01-13 at 12 20 49 AM" src="https://user-images.githubusercontent.com/114823741/212243498-71af7b0d-db2d-46c8-9c0b-b00d20aebd1a.png">     <img width="319" alt="Screen Shot 2023-01-13 at 12 21 27 AM" src="https://user-images.githubusercontent.com/114823741/212243502-10208125-8fc7-43c2-ba56-b1d6078f22d5.png">    <img width="324" alt="Screen Shot 2023-01-13 at 12 23 30 AM" src="https://user-images.githubusercontent.com/114823741/212243710-ef932f8e-f4b1-41cd-b25a-c9e70324f0f2.png">



