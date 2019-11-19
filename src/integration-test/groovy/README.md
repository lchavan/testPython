# Integration Test Formatting and Best Practices

This directory contains all integration tests for the application. Integration tests should be annotated with
`@SpringBootTest`, and should be uniformly named based on the classes they are testing.

For example, integration tests for the `SampleService.java` service should look like:

```groovy
@SpringBootTest
class SampleServiceIT extends Specification {

    def 'Should execute the sample method'() {
    
        given: 'The user exists'
            ...
        
        when: 'The sample service is called'
            ...
        
        then: 'The service returns a sample'
            ...
    }
}
```