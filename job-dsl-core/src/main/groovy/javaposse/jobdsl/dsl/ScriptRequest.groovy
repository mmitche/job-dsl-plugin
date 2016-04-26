package javaposse.jobdsl.dsl

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class ScriptRequest {
    // Starting Object
    final String location

    // Starting Script
    final String body

    // Where can we load objects from, file://. or http://server/ or workspace://JOBNAME/
    final URL[] urlRoots

    // Ignore existing jobs
    final boolean ignoreExisting
    
    // Generate all jobs as disabled
    final boolean generateJobsAsDisabled

    ScriptRequest(String location, String body, URL urlRoot) {
        this(location, body, [urlRoot] as URL[])
    }

    ScriptRequest(String location, String body, URL[] urlRoots) {
        this(location, body, urlRoots, false)
    }

    ScriptRequest(String location, String body, URL urlRoot, boolean ignoreExisting) {
        this(location, body, [urlRoot] as URL[], ignoreExisting)
    }
    
    ScriptRequest(String location, String body, URL[] urlRoots, boolean ignoreExisting) {
        this(location, body, urlRoots, ignoreExisting, false)
    }
    
    ScriptRequest(String location, String body, URL urlRoot, boolean ignoreExisting, 
                  boolean generateJobsAsDisabled) {
        this(location, body, [urlRoot] as URL[], ignoreExisting)
    }

    ScriptRequest(String location, String body, URL[] urlRoots, boolean ignoreExisting, 
                  boolean generateJobsAsDisabled) {
        this.location = location
        this.body = body
        this.urlRoots = urlRoots
        this.ignoreExisting = ignoreExisting
        this.generateJobsAsDisabled = generateJobsAsDisabled
    }
}
