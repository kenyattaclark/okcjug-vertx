def handler = { message ->
    println "Recieved message ${message.body}"
}

vertx.eventBus.registerHandler('example.address', handler)
