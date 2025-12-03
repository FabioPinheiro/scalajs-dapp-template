import org.scalajs.linker.interface.{ModuleInitializer, ModuleSplitStyle}
import scala.sys.process._

inThisBuild(Seq(scalaVersion := "3.7.4"))

/** Versions */
lazy val V = new {
  val scalajsDom = "2.8.1"
  val laminar = "17.0.0"
  val munit = "1.2.1"
}

/** Dependencies */
lazy val D = new {
  val dom = Def.setting("org.scala-js" %%% "scalajs-dom" % V.scalajsDom)
  val laminar = Def.setting("com.raquo" %%% "laminar" % V.laminar)
  val munit = Def.setting("org.scalameta" %%% "munit" % V.munit % Test)
}

lazy val dapp = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .settings(
    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,
    // Compile / scalaJSModuleInitializers +=  ModuleInitializer.mainMethod("fmgp.DAPP", "main").withModuleID("dapp"),

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "fmgp" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig := {
      scalaJSLinkerConfig.value
        .withModuleKind(ModuleKind.ESModule)
        // .withExperimentalUseWebAssembly(true) // use the Wasm backend
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("dapp")))
    },

    // // Configure Node.js (at least v23) to support the required Wasm features
    // jsEnv := {
    //   val config = org.scalajs.jsenv.nodejs.NodeJSEnv
    //     .Config()
    //     .withArgs(
    //       List(
    //         "--experimental-wasm-exnref", // always required
    //         "--experimental-wasm-jspi", // required for js.async/js.await
    //         "--experimental-wasm-imported-strings", // optional (good for performance)
    //         // "--turboshaft-wasm", // optional, Node.js 23.x.x only, but significantly increases stability
    //       )
    //     )
    //   new org.scalajs.jsenv.nodejs.NodeJSEnv(config)
    // },

    libraryDependencies += D.dom.value, // Depend on the scalajs-dom library. It provides static types for the browser DOM APIs.
    libraryDependencies += D.laminar.value,
    libraryDependencies += D.munit.value, // Testing framework
  )
