import { defineConfig } from "vite";
import scalaJSPlugin from "@scala-js/vite-plugin-scalajs";


export default defineConfig(({ command, mode, ssrBuild }) => {

  return {
    root: './vite',
    build: {
      outDir: './dist',
      // minify: 'terser', // defualt is 'esbuild'
      // manifest: true,
      // sourcemap: true,
    },
    preview: {
      port: 8091,
    },
    plugins: [
      scalaJSPlugin({
        cwd: '.', // path to the directory containing the sbt build // default: '.'
        // projectID: '.', // sbt project ID from within the sbt build to get fast/fullLinkJS from
        uriPrefix: 'scalajs', // URI prefix of imports that this plugin catches
      }),
    ]
  }
});