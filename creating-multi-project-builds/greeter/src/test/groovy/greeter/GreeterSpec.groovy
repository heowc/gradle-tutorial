package greeter

import spock.lang.Specification
// 1)
// ./gradlew :greeter:test
// 2)
// cd greeter
// $ ../gradlew test
class GreeterSpec extends Specification {

    def 'Calling the entry point'() {

        setup: 'Re-route standard out'
        def buf = new ByteArrayOutputStream(1024)
        System.out = new PrintStream(buf)

        when: 'The entrypoint is executed'
        Greeter.main('gradlephant')

        then: 'The correct greeting is output'
        buf.toString() == "Hello, Gradlephant\n".denormalize()
    }
}