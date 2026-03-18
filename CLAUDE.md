# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Test Commands

```bash
mvn clean compile        # Compile the project
mvn test                 # Run all tests
mvn package              # Build JAR
mvn -Dtest=ClassName test  # Run a single test class (e.g., -Dtest=GroupAnagramsTest)
```

## Architecture

This is a Maven-based Java 25 project (`dev.amerida.algoritms`) containing algorithm and data structure implementations organized by category.

**Package layout under `src/main/java/dev/amerida/algoritms/`:**

| Package | Contents |
|---|---|
| `arrays/` | Array problems (Two Sum) |
| `common/` | General algorithms: anagram, fibonacci, gas station, LRU cache, most frequent word, palindrome, streams/collections, tricky questions |
| `concurrency/` | ExecutorService, thread-safe counter |
| `design_patterns/creational/` | Factory pattern |
| `leed_code/` | LeetCode-style problems (merge sorted lists, string decoder) |
| `stream/` | Java Streams examples: collect, filter, map, reduce, sort, grouping, summarizing |
| `strings/` | String problems: compression, anagrams, camel case, valid parentheses, etc. |

Tests mirror the source structure under `src/test/java/dev/amerida/algoritms/`.

## Conventions

- Each algorithm lives in its own sub-package (e.g., `strings/group_anagrams/GroupAnagrams.java`)
- Test classes follow the pattern `ClassNameTest` and use JUnit 5 (`@Test`, assertions from `org.junit.jupiter.api`)
- Utility algorithms typically expose `static` or instance methods — no framework wiring
- Invalid inputs throw `IllegalArgumentException`
- Note: some package names contain typos from their creation (`gast_station`, `leed_code`) — preserve these when adding related files to avoid breaking existing references