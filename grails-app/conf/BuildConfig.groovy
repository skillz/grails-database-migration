if(System.getenv('TRAVIS_BRANCH')) {
    grails.project.repos.grailsCentral.username = System.getenv("GRAILS_CENTRAL_USERNAME")
    grails.project.repos.grailsCentral.password = System.getenv("GRAILS_CENTRAL_PASSWORD")    
}

grails.project.work.dir = 'target'
grails.project.docs.output.dir = 'docs/manual' // for backwards-compatibility, the docs are checked into gh-pages branch

grails.project.fork = false

grails.project.dependency.resolver = "maven"

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

    repositories {
        mavenRepo name: 'Skillz Nexus Grails Repository', url: 'http://nexus.skillz.com/content/groups/grails'
    }

	dependencies {
		compile('org.liquibase:liquibase-core:2.0.5') {
			excludes 'junit', 'easymockclassextension', 'ant', 'servlet-api', 'spring'
		}
		test 'commons-dbcp:commons-dbcp:1.4'
	}

	plugins {
		build(':release:3.0.1', ':rest-client-builder:2.0.1') {
			export = false
		}

		runtime "${System.getProperty('hibernatePluginVersion',':hibernate:3.6.10.12')}", {
			export = false
		}
	}
}

grails.project.repos.snapshots.url = 'http://nexus.skillz.com/content/repositories/snapshots/'
grails.project.repos.default = 'snapshots'
grails.release.scm.enabled = false
