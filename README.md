# ISBNValidator

Practicing TDD with an ISBN Validator.

## Best Practices

### Rules of Testing

* Test One Item of Functionality per test
* Test Business Logic, not methods
* Tests must be repeatable, and consistent
* Tests must be thorough

### What tests should I write?

* What should the logic be?
* What is the opposite to that logic?
* Are there any edge cases?
* Are there any error conditions?

### JUnit Asserts

* assertEquals
* assertNotEquals
* assertNull
* assertNotNull
* assertThat(actual, Matcher) // e.g. assertThat(email, StringContains.containsString("@"));
* fail

### Mockito methods

* mock(myClass.class);
* when(mockClass.method()).thenReturn();
* verify(myClass, times(?)).myMethod(params); // times(1) is default
* verify(myClass, atLeast(?)).myMethod(params);
* verify(myClass, atMost(?)).myMethod(params);
* verify(myClass, never(?)).myMethod(params);
* params: anyString()
* params: any(myClass.class)
* doReturn(return_value).when(spy_object).method_call(params);


### Stubs vs Mocks

|                                | Stubs | Mocks |
| ------------------------------ |:-----:| -----:|
| Override external dependencies |   ✓   |   ✓   |
| Used to test data              |   ✓   |   ✗   |
| Used to test behavior          |   ✗   |   ✓   |

### Stubs, Mocks & Fakes

| Type | What's it for? | How to do it in Mockito            |
|------|----------------|------------------------------------|
| Fake | No tests       | mock()                             |
| Stub | Test data      | mock() <br/> when().thenReturn()   |
| Mock | Test behavior  | mock() <br/> verify().myMethod()   |

## Contributing

If you wish to contribute to this repo, please read the [Contributing document](.github/CONTRIBUTING.md).

## Support

If you need help with this project, please read the [Support document](.github/SUPPORT.md).

## License

[MIT License](LICENSE)
