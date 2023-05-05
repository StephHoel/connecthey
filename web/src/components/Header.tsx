import { useRouter } from "next/router"
import { MagnifyingGlass } from 'phosphor-react';

export function Header({ logged }: any) {
   const router = useRouter()

   const notLogged = () => {
      return
   }

   return (
      <header className='w-screen h-28 bg-violet-600 opacity-90 space-x-[30%] text-gray-300
                        flex justify-between items-center p-4'>
         <div className="text-left ml-12 text-5xl self-center font-semibold">
            <a onClick={() => { router.push("/") }} className='cursor-pointer whitespace-nowrap hover:text-white'>
               Connect Hey
            </a>
         </div>

         {logged ?
            <nav className="flex items-center space-x-4 text-right text-3xl font-semibold pr-16">
               <a onClick={() => { router.push("/companies") }}
                  className="cursor-pointer whitespace-nowrap hover:text-white">
                  <span className="inline-flex mr-2"> <MagnifyingGlass size={15} /> </span>
                  Negócios
               </a>
               <a className="text-3xl">|</a>
               <a onClick={() => { router.push("/suppliers") }}
                  className="cursor-pointer whitespace-nowrap hover:text-white">
                  <span className="inline-flex mr-2"> <MagnifyingGlass size={15} /> </span>
                  Fornecedores
               </a>
               <a className="text-3xl">|</a>
               {/* <a onClick={() => { router.push("/new/company") }}
                  className="cursor-pointer whitespace-nowrap hover:text-white">
                  Cadastrar Negócios
               </a>
               <a className="text-3xl">|</a>
               <a onClick={() => { router.push("/new/supplier") }}
                  className="cursor-pointer whitespace-nowrap hover:text-white">
                  Cadastrar Fornecedores
               </a>
               <a className="text-3xl">|</a> */}
               <a onClick={() => { router.push("/user/logout") }}
                  className="cursor-pointer whitespace-nowrap hover:text-red-500">
                  Sair
               </a>
            </nav>
            :
            <nav className="flex items-center space-x-4 text-right text-3xl font-semibold pr-16">
               <a onClick={() => { router.push("/user/register") }}
                  className="cursor-pointer whitespace-nowrap hover:text-white">
                  Cadastrar-se
               </a>
               <a className="text-3xl">|</a>
               <a onClick={() => { router.push("/user/login") }}
                  className="cursor-pointer whitespace-nowrap hover:text-white">
                  Login
               </a>
            </nav>
         }
      </header>
   )
}