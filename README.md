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

## Contributing

If you wish to contribute to this repo, please read the [Contributing document](.github/CONTRIBUTING.md).

## Support

If you need help with this project, please read the [Support document](.github/SUPPORT.md).

## License

[MIT License](LICENSE)
