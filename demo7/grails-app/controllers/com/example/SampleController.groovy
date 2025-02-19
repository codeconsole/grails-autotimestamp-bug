package com.example

class SampleController {

    static scaffold = Sample

    def block() {
        Sample.gormPersistentEntity.mappingContext.eventListeners.find {
            it.class == org.grails.datastore.gorm.events.AutoTimestampEventListener
        } withoutTimestamps() {
            Thread.sleep(30000)
        }
        flash.message = "30 second blocking on withoutTimestamps complete"
        redirect action: 'index'
    }

    def failedBinding() {
        def sample = new Sample()
        sample.with {
            name = params.name
        }
        log.info "sample.name '${sample.name}' should not be null."
        respond sample
    }

}
