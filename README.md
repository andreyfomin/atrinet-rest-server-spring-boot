# Atrinet REST Device API

##1. Get list of all devices.
####  PROTOCOL: GET
[http://localhost:7777/devices/list]
(http://localhost:7777/devices/list)

##2. Add new device.
####  PROTOCOL: POST
[http://localhost:7777/devices/add]
(http://localhost:7777/devices/add)

```
 {
    "id": 3,
    "status": "OK",
    "name": "20.25.30.3",
    "ipAdress": "20.25.30.3",
    "location": "F2",
    "serialNumber": "N/A",
    "barCode": "N/A",
    "cleiCode": "N/A",
    "usiCode": "N/A",
    "swVersion": "5.0.4.b",
    "hwVersion": "14.00",
    "type": "A-4100",
    "contact": "efi"
}
```

##3. Update existing device.
####  PROTOCOL: POST
[http://localhost:7777/devices/update]
(http://localhost:7777/devices/update)

```
 {
    "id": 3,
    "status": "OK",
    "name": "20.25.30.3",
    "ipAdress": "20.25.30.3",
    "location": "F2",
    "serialNumber": "N/A",
    "barCode": "N/A",
    "cleiCode": "N/A",
    "usiCode": "N/A",
    "swVersion": "5.0.4.b",
    "hwVersion": "14.00",
    "type": "A-4100",
    "contact": "efi"
}
```

##4. Remove existing device.
####  PROTOCOL: GET
[http://localhost:7777/devices/remove/{deviceId}]
(http://localhost:7777/devices/remove/{deviceId})

```
 {
    "id": 3,
    "status": "OK",
    "name": "20.25.30.3",
    "ipAdress": "20.25.30.3",
    "location": "F2",
    "serialNumber": "N/A",
    "barCode": "N/A",
    "cleiCode": "N/A",
    "usiCode": "N/A",
    "swVersion": "5.0.4.b",
    "hwVersion": "14.00",
    "type": "A-4100",
    "contact": "efi"
}
```

# Atrinet REST Monitoring

##1. Gives very reassuring {"status":"UP"} and it's used for health checks
####  PROTOCOL: GET
[http://localhost:7777/health]
(http://localhost:7777/health)

##2. it's used to read metrics collected by application, and by default returns a list of "system" metrics
####  PROTOCOL: GET
[http://localhost:7777/metrics]
(http://localhost:7777/metrics)


##1. Get list of all devices.
####  PROTOCOL: GET
[http://localhost:7777/devices/list]
(http://localhost:7777/devices/list)


## List of useful sites for client development project

* [coffeescript](http://coffeescript.org/)
* [javascript to coffee script](http://js2.coffee/)
* [less](http://lesscss.org/)
* [css to less](http://css2less.cc/)
* [Jade](http://jade-lang.com/) - Jade is a terse language for writing HTML templates.
* [Modernizr](http://modernizr.com/) - JavaScript library that detects HTML5 and CSS3 features in the user’s browser.
* [DHTMLX](http://dhtmlx.com/) - set of useful js elements (tables, trees, menu).
* [sugarjs](http://sugarjs.com/) - Javascript library that extends native objects with helpful methods.
* [DataTales](http://www.datatables.net/) - DataTables is a plug-in for the jQuery Javascript library.
* [Jeditable](http://www.appelsiini.net/projects/jeditable) - Edit in place (inline edit) plugin with possibility to create your own input types.
* [AngularJS](https://angularjs.org/) - HTML enhanced for web apps.
* [AngularJS Tutorial](https://docs.angularjs.org/tutorial) - A great way to get introduced to AngularJS
* [Font Awesome](http://fontawesome.io/) - Gives you scalable vector icons that can instantly be customized.
* [Bootstrap](http://getbootstrap.com/) - The most popular HTML, CSS, and JS framework for developing responsive, mobile first projects on the web.
* [html5test](http://html5test.com/) - How well does your browser support html5?
* [w3schools](http://www.w3schools.com/) - Learn how to create a website on your own computer.


## README format

Markdown is a markup language with plain text formatting syntax designed so that it can be converted 
to HTML and many other formats using a tool by the same name.

[markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
