# Zally: A minimalistic, simple-to-use OpenAPI 2 and 3 linter

[![Latest Release](https://img.shields.io/github/v/release/schweizerischebundesbahnen/zally.svg)](https://github.com/SchweizerischeBundesbahnen/zally/releases)
[![Test Status](https://travis-ci.com/SchweizerischeBundesbahnen/zally.svg?branch=master)](https://travis-ci.com/SchweizerischeBundesbahnen/zally)
[![Build Status](https://github.com/SchweizerischeBundesbahnen/zally/workflows/Build%20&%20Deploy%20latest/badge.svg?branch=master)](https://github.com/SchweizerischeBundesbahnen/zally/actions?query=workflow%3A%22Build+%26+Deploy+latest%22)

![GitHub contributors](https://img.shields.io/github/contributors/schweizerischebundesbahnen/zally)
![GitHub License](https://img.shields.io/github/license/schweizerischebundesbahnen/zally)

<img src="logo.png" width="200" height="200" />

Zally is a quality assurance tool. It's a linter for OpenAPI specifications, which:

- Increases the quality of APIs
- Checks compliance
- Delivers early feedback for API designers
- Ensures the same look-and-feel of APIs
- Supports API-First approach
- Provides best practices and advices

Its standard configuration will check your APIs against the rules defined in
[Zalando's RESTful Guidelines](http://zalando.github.io/restful-api-guidelines/),
but anyone can use it **out-of-the-box**.

Zally's easy-to-use [CLI](cli/README.md) uses the server in the background so that
you can check your API *on the spot*. It also features an intuitive
[Web UI](web-ui/README.md) that shows implemented rules and lints external files
and (with its online editor) API definitions.

## Features

- Support for OpenAPI 3 and (Swagger) OpenAPI 2 specifications
- RESTful API, CLI and Web interface
- Rich Check configuration
- Ignore functionality (`x-zally-ignore` extension)
- Java/Kotlin API for new Checks + helper functions

## Quick start guide

Trying out Zally is easy. You can build and run the whole Zally stack (web-ui, server
and database) by executing:

```bash
./build-and-run.sh
```

Web UI is accessible on `http://localhost:8080`; Zally server on `http://localhost:8000`

## Documentation and Manuals

Please consult the following documents for more information:

- [Zally Concepts](documentation/concepts.md)
- [How to operate](documentation/operation.md) Zally tools
- [How to use Zally](documentation/usage.md)
- [How to develop new Rules](documentation/rule-development.md)
- [Building Under Windows Subsystem for Linux](documentation/build-under-wsl.md)

## Contributing

Zally welcomes contributions from the open source community. To get started, take a
look at our [contributing guidelines](CONTRIBUTING). Then check our
[Project Board](https://github.com/zalando/zally/projects/1) and
[Issues Tracker](https://github.com/zalando/zally/issues) for ideas.

## Roadmap

For Zally [version 1.5](https://github.com/zalando/zally/milestone/3), we're focusing on:

- Improve extensibility of Zally
  - Plugin mechanism for Rules (Sets)
  - Utilities and helper functions for Check development
- Improve quality by introducing a better testing approach for integration tests
- Make the usage of Zally easier by providing high-quality documentation for
  - End users
  - Check developers
  - Operators and administrators

If you have ideas for these items, please let us know.

## Contact

Feel free to join our [Gitter room](https://gitter.im/zalando/zally) or contact one
of the [maintainers](MAINTAINERS) directly.

## Alternatives 

Zally is not the only linter for OpenAPI v2 and v3. There is [an article](https://nordicapis.com/8-openapi-linters/) comparing different OpenAPI linters.

So why should you choose Zally?
- It supports [Zalando's RESTful Guidelines](http://zalando.github.io/restful-api-guidelines/)
- It can be used in multiple ways: RESTful API, CLI and Web interface
- Highly customizable (with Kotlin)  

## License

MIT license with an exception. See [license file](LICENSE).

## Publish

### Prerequisites

* [Signing plugin](https://docs.gradle.org/current/userguide/signing_plugin.htm) configured
* `OSSRH_JIRA_USERNAME` and `OSSRH_JIRA_PASSWORD` environment variables to access [Maven Central Repo](https://oss.sonatype.org/) are 
configured

### Steps

1. Create a separate branch with a name `release-<release-version>`.
2. Update current version in `server/gradle.properties` from `-SNAPSHOT` to a final version.
3. Release Zally server and API using the command
   ```
   cd server
   ./gradlew clean build publishAllPublicationsToMavenRepository
   ```
4. Commit `server/gradle.properties` with the release version
5. Create a tag
    ```shell script
    git tag v<release-version> -m "Version <release-version>"
    ```
6. Bump version in `server/gradle.properties` to the next `-SNAPSHOT`

7. Push `release` branch and tag
   ```shell script
    git push origin
    git push origin <tag-name>
   ```
8. Create a Pull Request with the version update
9. Create and publish a release with a new version in GitHub
