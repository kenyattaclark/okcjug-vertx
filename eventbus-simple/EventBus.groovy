def handler = { message ->
	println "Recieved message ${message.body}"
}

vertx.eventBus.registerHandler('example.address', handler)

vertx.setPeriodic(1000, {
	vertx.eventBus.send('example.address', 'OKCJUG Rocks!')
})