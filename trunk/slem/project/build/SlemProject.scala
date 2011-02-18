/**
 * Slem project definition
 *
 * Copyright 2010, Timothy Morton, All rights reserved.
 */

import sbt._
import reaktor.scct.ScctProject

class SlemProject (info: ProjectInfo) extends DefaultProject (info) with ScctProject
{
    // Configure paths
    override def mainScalaSourcePath = "src"
    override def testScalaSourcePath = "src"

    // Specyify how to find source and test files.  Sources are
    //    - all .scala files, except
    //    - files whose names end in Tests.scala, which are tests
    def mainSourceFilter = "*.scala" && -testSourceFilter
    def testSourceFilter = "*Tests.scala"
    override def mainSources = descendents (mainSourceRoots, mainSourceFilter)
    override def testSources = descendents (testSourceRoots, testSourceFilter)

    // Set compiler options
    override def compileOptions = super.compileOptions ++ Seq (Unchecked)

    // Include www.scala-tools.org snapshot repository in search
    val scalaToolsSnapshots = ScalaToolsSnapshots

    // Declare dependencies on other libraries
    val kiama = "com.googlecode" %% "kiama" % "1.0.0"

    // By default, only log warnings or worse
    log.setLevel (Level.Warn)
}
