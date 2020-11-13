package com.SeleniumNotes;

public class day18_CI_CD_Jenkins {
    /*
    CI/CD  and  Jenkins :

    server - computer that is used to serve other computers.
     Environment - place where server is running application.
     All environments, except production, have a dummy data (fake data).
     dev --> test -->stage --> production
     dev - used by developers only
     test - used for functional testing, used by us and for non-functional testing like performance.
     stage - UAT (User Acceptance Testing)
     production - the real application, used by end-users.

      NOTE: There could be other environments, not every single company has only these 4.
       For example: UAT, Integration, pre-prod, TESTA, TESTB, TESTC,etc.

       when new build is deployed to any environment, smoke test should be automatically executed.
       daily, smoke test is running on the test environment. If something happened with a test
       environment, we won’t be able to work. When test environment is down, everybody should
       be aware of it asap. That's why we run smoke test after new build (because new changes
       could break something), and periodically (every morning), because something could happen
        overnight that caused server problems. After release, we do smoke test in the production
         environment, for sure.

CI - Continues Integration : It's software development practice, where developers
use VCS(version control system, like GIT) and integrate frequently their changes.
 Also, those changes will be automatically tested. (code quality scans, unit and integration tests)
  Continues Integration encourages developers to commit changes for often, so they can be tested
  and integrated into main branch. Also, developers will receive a feedback more often.
  I would say it's easier to digest small pieces little by little rather than digesting
   huge bulk at once.

CD -Continuous Delivery : Continuous Delivery is an automated build
   and execution of unit and integration tests, performing code analysis, also functional
   tests and also deploying to any supported platform any time. Each time a build or
   a set of code passes the tests, it’s automatically deployed out to a staging environment.
   In Continuous Delivery releasing to end users is a manual process. Continuous delivery
    involves human decision-making when it comes to deciding when to release the software
     to the customers.

CD - Continuous Deployment: Continuous deployment means that every change that you make,
goes through the pipeline, and if it passes all the tests, it automatically gets deployed
 into production. When a developer commits code, the automated processes takes the code
 and move it through the entire life-cycle and if it passes each gate, it gets deployed
 directly to production. The delivery speeds are notably faster due to elimination
 of manual steps.

 Continues Integration ==> build + unit test + integration tests + code analysis
 Continues Delivery ==> Continues Integration + smoke testing + regression testing +
        performance testing + deployment to Staging environment. Everything is automated
        except release.
 Continues Deployment ==> Continues Delivery + automatic release.

   The goal of CI/CD is a shorter release cycle. So end-users can get new version
   of application, with new features  with fixed bugs, faster.
    Faster software release -->better software --> higher client satisfaction

 Q: Is it possible to release new software without testing? -
 A: No, that's why testing/QA plays essential role in this entire process.
  Before releasing a new version of software, regression testing MUST be done.
   Regression testing can be done either manually or automatically.
   Manually - takes time, less accurate. If regression testing is done manually,
    forget about short release cycles. In my company, before automation,
    regression testing was done manually, and it was about 2 weeks.
     Before I left, our regression was running around 2.5 hours.
     It's because of parallelization and running 35 browsers at once.
      We used 5 servers to distribute tests and execute them faster.
      We were running regression in stage environment.
       every company have to have at least 4 environments: dev --> qa --> stage --> production

#dev - reserved for developers, once changes were committed, devs can build a new version
  of software and deploy it to dev environment.
#qa - reserved for us, this is were we do testing
#stage - preparation for release, this is were performance testing
  and UAT testing can be done before release
#production - environment of end-user, real data

 # dev - dev.vytrack.com #
 # qa - qa.vytrack.com
 # stage - stage.vytrack.com
 # production - vytrack.com

  deployment - process of creating a new build and delivering it to the application server.
  application server - program that makes web application running and accessible over the browser.
  All environments have same application, but with different version.
  Newest version in dev, oldest in production. Every environment has its own database,
   and all of them, except PRODUCTION, have dummy/fake data. dev - reserved for developers.
   Most of the companies just stick with Continues Delivery, and prefer to trigger
   release manually.

   Create AWS account: https://aws.amazon.com/console/ ROLE:
   any role PERSONAL ACCOUNT PROVIDE CREDIT CARD ANY ACOUNT NAME
FREE FOR 1 YEAR YOU CAN SHUTDOWN ACCOUNT ANY TIME FREE PLAN AMI:
Cybertek_Latest_BasicAuth - AWS - amazon web services From official website:

Amazon Web Services (AWS) is the world’s most comprehensive and broadly adopted cloud platform,
offering over 175 fully featured services from data centers globally.
Millions of customers—including the fastest-growing startups, largest enterprises,
and leading government agencies—are using AWS to lower costs, become more agile,
and innovate faster.

    Jenkins  is  an  open-source  automation  tool  written
in  Java  with plugins built for Continuous Integration purposes.
Jenkins is used to build  and  test  your  software  projects  continuously  making
  it  easier for  developers  to  integrate  changes  to  the  project,
  and  making  it easier  for  users  to  obtain  a  fresh  build.
  It  also  allows  you  to continuously  deliver  your  software  by  integrating
    with  a  large number of testing and deployment technologies.

With Jenkins, organizations can accelerate the software development process  through  automation.
  Jenkins  integrates  development  life-cycle processes of all kinds, including build,
   document, test, package, stage, deploy, static analysis, and much more.
    Jenkins  achieves  Continuous  Integration  with  the  help  of  plugins.
     Plugins allow the integration of Various DevOps stages. If you want to
      integrate a particular tool, you need to install the plugins for that tool.
        For  example:  Git,  Maven  2  project,  Amazon  EC2,  HTML publisher etc.

        Jenkins credentials: username and password is admin.
        enter into search box ip:8081 or ip:8080 to hit Jenkins.
        default port for Jenkins is 8080. In our case, it was switched to 8081.
         web application - any application used over the browser.

         Steps to create a smoke test job in Jenkins:
         1. Go to dashboard --> new item --> Smoke test | freestyle project
         2. Select git as a VCS and insert project URL: https://github.com/CybertekSchool/TestAutomationProject.git
         3. Build -->> Invoke Top-level maven targets --> clean test -P Smoke or, if you don't have a profile,
            use: clean test -Dcucumber.options="--tags @smoke_test"
         4. Proceed to Post Build actions --> Select cucumber report
         5. Click build now!!! Regarding scheduling tests: This field follows the syntax of cron
           (with minor differences). Specifically, each line consists of 5 fields separated by
            TAB or whitespace: MINUTE HOUR DOM MONTH DOW
             MINUTE Minutes within the hour (0–59)
             HOUR The hour of the day (0–23)
             DOM The day of the month (1–31)
             MONTH The month (1–12)
             DOW The day of the week (0–7) where 0 and 7 are Sunday.

  To specify multiple values for one field, the following operators are available.
  In the order of precedence, * specifies all valid values M-N specifies
  a range of values M-N/X or X steps by intervals of X through the specified range
  or whole valid range A,B,...,Z enumerates multiple values H 6 * * 1-5 Mon - Friday,
  around 6 AM MAKE SURE TO PUT SPACES
  TZ=US/Eastern
  H 6 * * 1-5
  H 21 * * *
     */

}
