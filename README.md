# Use of autoTimestampEventListener.withoutTimestamps results in timestamps being disabled in ALL simultaneous threads.
## Grails 6+

Exists in either Grails 6 or 7
```
cd grails6
sdk env
gradle bootRun

cd grails7
sdk env
gradle bootRun
```


Request 1: http://localhost:8080/sample/create
```
Sample.save(flush:true).dateCreated == new Date()
```

Request 2: http://localhost:8080/sample/block
```groovy
autoTimestampEventListener.withoutTimestamps() {
    Thread.sleep(30000)
}
```

Simultaneous Request 3: http://localhost:8080/sample/create
```
Sample.save(flush:true).dateCreated == NULL!
```
