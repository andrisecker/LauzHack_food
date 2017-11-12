## LauzHack 2017 : OpenFoodprint

Working on the [Openfood](https://openfood.ch) database, we want to show people the impact their food choices have on the climate, and try to suggest a better alternative. Our app will scan the barcodes of food items available in the Swiss market and connect to the information stored in the Openfood dataset to find the ingredients contained in the food item. Then we scraped the [CleanMetrics](http://www.foodemissions.com/foodemissions/Calculator.aspx) webpage to find a dataset that maps the ingredients to a metric describing the climate impact (we took a simple idea of the total carbon content released during its production minus the transportation cost and the waste). This allows us to estimate a value of the climate footprint of the product by mapping the ingredients to the footprint.

### Steps involved 

* Look at the dataset involved and extract the ingredients. In general, we have the different ingredients in the major Swiss languages, at least in German and French, and often in Italian and sometimes even in English. Often the tagged languages (MTurked) are wrong, so we use the IBM Watson API to find the language of the ingredients and translate everything to English.

* We scraped the dataset with per unit climate impact and mapped the translated Openfood items to find the total climate impact.

* The app shows this to the user and hopes to convince the user to choose otherwise

### Further plans

* We have information about the energy and nutrient content about the food products as well and we can suggest the user a product which can give a similar nutritional and energy value but have a lower climate impact. 

* We can gamify this to incentivise reducing the climactic impact even more. 

* Eventually, an entire dietary plan can be entered into the app and a proper climactic impact can be done and a change can be suggested, while keeping in mind the budget and the nutritional value

* For all of this, we need much better annotations and comparing of ingredients across languages. More importantly, we need a better dataset for the climactic impact and also incorporate food wastage, which is an important area where the climactic impact comes in.
