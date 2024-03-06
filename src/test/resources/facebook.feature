Feature: Facebook create new account

Background: Facebook launching function
Given Launch the facebook "https://www.facebook.com"
And Navigate to facebook

@fb
Scenario Outline: enter data
When enter the name "<firstname>"
When enter the surname "<surename>"
When enter the gamil "<mail>"
When enter the reenter "<reenter>"
When enter the password "<newpassword>"
When enter the date "<date>"
When enter the month "<month>"
When enter the year "<year>"
When select the gender "<gender>"


Then create new account
And take the screenshot "<firstname>" 

Examples: 

|firstname|surename|mail         |reenter      |newpassword|date|month|year |gender|
|Surya   |S   |surya@gmail.co    |surya@gmail.co |surya    |23  |feb  |2000 |Male  |
|akalya  |S   |akal@gmail.co     |akal@gmail.co |akalya    |21  |aug  |2000 |Female  |
|prakash |S   |psk@gmail.co      |psk@gmail.co |prakash    |25  |jan |2002 |Male  |
|aki     |S   |aki@gmail.co      |aki@gmail.co |aki        |24  |oct |2001 |Female|