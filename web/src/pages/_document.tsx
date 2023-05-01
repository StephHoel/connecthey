import { Html, Head, Main, NextScript } from 'next/document'

export default function Document() {
  return (
    <Html lang="pt-br">
      <Head />
      <body className='bg-gradient-to-r from-violet-400 to-violet-500 
                      w-screen h-full min-h-screen bg-cover pb-8'>
        <Main />
        <NextScript />
      </body>
    </Html>
  )
}
