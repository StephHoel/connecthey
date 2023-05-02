import { useRouter } from "next/router"
import { MagnifyingGlass } from 'phosphor-react';

export function Header() {
   const router = useRouter()

   return (
      <div className='w-screen h-28 bg-violet-600 opacity-90 space-x-[30%] 
                     py-4 grid grid-flow-col text-gray-300'>
         <div className='text-left ml-12 text-5xl self-center'>
            <a onClick={() => { router.push("/") }} className='cursor-pointer hover:text-gray-100 hover:font-semibold'>Connect Hey</a>
         </div>
         <div className='grid grid-flow-col text-right items-center text-3xl'>
            <div className='space-x-4 flex pr-96'>
               <p><a onClick={() => { router.push("/companies") }} className='cursor-pointer whitespace-nowrap flex items-center hover:text-gray-100 hover:font-semibold'>
                     <span className="inline-flex mr-2">
                        <MagnifyingGlass size={15} />
                     </span>
                     <span>Negócios</span>
               </a></p>
               <p>|</p>
               <p><a onClick={() => { router.push("/suppliers") }} className='cursor-pointer whitespace-nowrap flex items-center hover:text-gray-100 hover:font-semibold'>
                  <span className="inline-flex mr-2">
                     <MagnifyingGlass size={15} />
                  </span>
                  <span>Fornecedores</span>
               </a></p>
               <p>|</p>
               <p><a onClick={() => { router.push("/new/company") }} className='cursor-pointer whitespace-nowrap hover:text-gray-100 hover:font-semibold'>Cadastrar Negócios</a></p>
               <p>|</p>
               <p><a onClick={() => { router.push("/new/supplier") }} className='cursor-pointer whitespace-nowrap hover:text-gray-100 hover:font-semibold'>Cadastrar Fornecedores</a></p>
            </div>
         </div>
      </div>
   )
}