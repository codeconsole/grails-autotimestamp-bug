# Use of autoTimestampEventListener.withoutTimestamps results in timestamps being disabled in ALL simultaneous threads.
## Grails 6+

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
