# How the SBB ruleset is created

We take the approach to start from Zalando's ruleset and then tailor it to SBB's need.

## Initial Steps
1. Copy from zally-ruleset-zalando
2. Refactor package names
3. Add directory 'zalando-ruleset-sbb' to 'settings.gradle.kts'
4. Add 'compile(project(":zally-ruleset-sbb"))' to 'build.gradke.kts'
5. Rename 'ZalandoRuleSet' to 'SBBRuleSet'

## Configuration of Rules
- Removed "Provide API Identifier" (215)
- Removed "Provide API Audience" (219)
- Removed "Following Naming Convention for Hostnames" (224)
- Removed "Use 429 With Header For Rate Limits" (153)
- Removed "Snake_case for property names" (118) 
- Removed "Snake_case for query params" (118) 
- Removed "Secure Endpoints with OAuth 2.0" (104) - Managed by SBB's APIM
- Removed "Secure All Endpoints With Scopes" (105) - Managed by SBB's APIM

- Set "Secure All Endpoints With Scopes" (105) to SHOULD
- Set "Response As JSON Object" (110) to SHOULD
- Set "Use Problem JSON" (176) to SHOULD
- Set "Prefer Compatible Extensions" (107) to MAY
- Set "Pluralize Resource Names" (134) to SHOULD
- Set "Propietary Headers" (183) to SHOULD and specify some SBB specific ones

- Added "CamelCase in Property Names" rule (hint: it's configured via CaseChecker in reference.conf)
- Added "CamelCase for Query Params" rule (hint: it's configured via CaseChecker in reference.conf)
- Added "Do URI Versioning"
- Added zipkin headers (X-B3-ParentSpanId, X-B3-SpanId, X-B3-TraceId, X-B3-Sampled)
- Added SBB headers (Requester-Info, Request-Id, Process-Id, Correlation-Id, Transaction-Id, X-Contract-Id, X-Conversation-Id)

## Todo
- Adjust links to SBB ruleset (https://schweizerischebundesbahnen.github.io/api-principles/restful/)
- Add documentation for newly added rules