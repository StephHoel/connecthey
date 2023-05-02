import { Html, Head, Main, NextScript } from 'next/document'

export default function Document() {
  return (
    <Html lang="pt-br">
      <Head />
      <body className='bg-bg-all bg-cover bg-no-repeat overflow-x-hidden w-screen h-full min-h-screen pb-8'>
        <Main />
        <NextScript />
      </body>
    </Html>
  )
}
