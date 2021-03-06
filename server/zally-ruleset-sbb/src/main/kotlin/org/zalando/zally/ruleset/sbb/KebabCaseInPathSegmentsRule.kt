package org.zalando.zally.ruleset.sbb

import com.typesafe.config.Config
import org.zalando.zally.core.CaseChecker
import org.zalando.zally.rule.api.Check
import org.zalando.zally.rule.api.Context
import org.zalando.zally.rule.api.Rule
import org.zalando.zally.rule.api.Severity
import org.zalando.zally.rule.api.Violation

@Rule(
    ruleSet = SBBRuleSet::class,
    id = "restful/best-practices/#use-lowercase-separate-words-with-hyphens-for-path-segments",
    severity = Severity.SHOULD,
    title = "Lowercase words with hyphens"
)
class KebabCaseInPathSegmentsRule(config: Config) {

    private val checker = CaseChecker.load(config)

    private val description = "Use lowercase separate words with hyphens for path segments"
    internal val lowerCaseHyphenSeparatedRegex = "^[a-z-]+$".toRegex()

    @Check(severity = Severity.SHOULD)
    fun checkKebabCaseInPathSegments(context: Context): List<Violation> =
        checker.checkPathSegments(context).map { Violation(description, it.pointer) }
}
