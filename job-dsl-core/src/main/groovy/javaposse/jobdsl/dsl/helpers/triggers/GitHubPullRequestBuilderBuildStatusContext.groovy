package javaposse.jobdsl.dsl.helpers.triggers

import javaposse.jobdsl.dsl.Context
import javaposse.jobdsl.dsl.Preconditions

class GitHubPullRequestBuilderBuildStatusContext implements Context {
    private static final Set<String> VALID_BUILD_RESULT = ['SUCCESS', 'ERROR', 'FAILURE']

    List<Node> messages = []
    
    /**
     * Message to post in comment if the build result is as specified.
     * Can be called multiple times.
     */
    void completedComment(String buildResult, String message) {
        Preconditions.checkArgument(
                VALID_BUILD_RESULT.contains(buildResult),
                "buildResult must be one of ${VALID_BUILD_RESULT.join(', ')}"
        )

        messages << new NodeBuilder().'org.jenkinsci.plugins.ghprb.extensions.comments.GhprbBuildResultMessage' {
            delegate.message(message ?: '')
            delegate.result(buildResult)
        }
    }
}
