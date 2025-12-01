# scalajs-dapp-template

This is a template to create to create [single-page applications](https://developer.mozilla.org/en-US/docs/Glossary/SPA) and is also a DApp deployed to the IPFS network (pined by [Pinata](https://pinata.cloud/))


Required to set up:
 - GitHub Secrets: 
   - `PINATA_API_KEY`
   - `PINATA_API_SECRET`
   - `CLOUDFLARE_API_TOKEN`
 - GitHub variables:
   - `CLOUDFLARE_ZONE_ID`
   - `CLOUDFLARE_HOSTNAME_IDENTIER`

## IPFS pining

Use the https://ipfs.github.io/pinning-services-api-spec/

## cloudflare gateway

https://scalajs-dapp-template.fabiopinheiro.com/

## TODO

- minimal Scala.js DApp aplication (maybe with wasm)
- action to update the config cloudflare as a web3 gateway