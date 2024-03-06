Feature: Ajio


Background: Ajio launching function
Given Launch the Ajio "https://www.ajio.com"
And Navigate to Kids and click the clothing

@ajio
Scenario: kids clothing sorthing

When user click sort dropdown and select option in a dropdown with one dim map
|sort1|highest|
|sort2|Discount|
|sort3|lowest|
|sort4|What|
|sort5|Ratings|
|sort6|Relevance|

Then validate result