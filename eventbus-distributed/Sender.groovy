vertx.setPeriodic(1000, {
    vertx.eventBus.send('example.address', 'OKCJUG Rocks!')
})
