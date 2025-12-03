package fmgp

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom
import com.raquo.laminar.api.L.{*, given}

// import javascriptLogo from "/javascript.svg"
@js.native @JSImport("/javascript.svg", JSImport.Default)
val javascriptLogo: String = js.native

@main
def DAPP(): Unit = {
  println("poooll")

  lazy val appContainer = dom.document.querySelector("#app")
  // renderOnDomContentLoaded(appContainer, div(h1("renderOnDomContentLoaded")))

  windowEvents(_.onLoad).foreach { _ =>
    println("windowEvents onLoad")
    // we can render here
  }(unsafeWindowOwner)

  // render(dom.document.querySelector("#app"), Main.appElement())
  renderOnDomContentLoaded(appContainer, Main.appElement())

}

object Main {
  def appElement(): Element = {
    div(
      h1("Hello, Decentralized World!"),
      p("This is a template for the dApp using WASM"),
      p("Available also via a cloudflare ipfs gateway: https://dapp-template.fabiopinheiro.com"),
      p("See https://github.com/FabioPinheiro/scalajs-dapp-template/actions"),
      a(
        href := "https://developer.mozilla.org/en-US/docs/Web/JavaScript",
        target := "_blank",
        img(src := javascriptLogo, className := "logo vanilla", alt := "JavaScript logo"),
      ),
      h1(
        "laminar chartjs example"
      ), // https://github.com/sjrd/scalajs-sbt-vite-laminar-chartjs-example/tree/laminar-end-state
      a(href := "https://www.scala-js.org/doc/tutorial/laminar.html", target := "_blank"),
      Chartjs.renderDataTable(),
      Chartjs.renderDataList(),
    )
  }
}
