## Contribution

1. Pre-commit checks are used in this project. Add the pre-commit hook by running the following
   command:

```bash
$ ln -s ../../config/pre-commit.sh .git/hooks/pre-commit
```

2. Please adhere to the project structure and conventions
   * Format code with `./gradlew detekt`
   * Add new features using the _public impl wiring_ module structure
   * Implement unit tests
   * Have fun :)
