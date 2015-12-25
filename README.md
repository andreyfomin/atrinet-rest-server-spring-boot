# Atrinet REST Device API

##1. Get list of all devices.
####  PROTOCOL: GET
[http://localhost:7777/devices/list](http://localhost:7777/devices/list)

##2. Add new device.
####  PROTOCOL: POST
[http://localhost:7777/devices/add](http://localhost:7777/devices/add)

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
[http://localhost:7777/devices/update](http://localhost:7777/devices/update)

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
[http://localhost:7777/devices/remove/{deviceId}](http://localhost:7777/devices/remove/{deviceId})

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
[http://localhost:7777/health](http://localhost:7777/health)

##2. it's used to read metrics collected by application, and by default returns a list of "system" metrics
####  PROTOCOL: GET
[http://localhost:7777/metrics](http://localhost:7777/metrics)


##1. Get list of all devices.
####  PROTOCOL: GET
[http://localhost:7777/devices/list](http://localhost:7777/devices/list)


## List of useful sites for client development project

* [spring-boot](http://projects.spring.io/spring-boot/)
* [spring-boot reference](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/)
* [spring projects](http://spring.io/projects)
* [spring-framework](http://projects.spring.io/spring-framework/)
* [gradle docs](https://docs.gradle.org/current/release-notes)
* [gradle eclipse plugin](https://docs.gradle.org/current/userguide/eclipse_plugin.html)



## README format

Markdown is a markup language with plain text formatting syntax designed so that it can be converted 
to HTML and many other formats using a tool by the same name.

[markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
