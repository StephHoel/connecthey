import { useRouter } from "next/router"

export function Header() {
   const router = useRouter()

   return (
      <div className='w-full h-28 bg-violet-600 opacity-70 space-x-[30%] 
                     py-4 grid grid-flow-col text-gray-300'>
         <div className='text-left ml-12 text-5xl self-center'>
         <a onClick={() => { router.push("/") }} className='cursor-pointer hover:text-gray-100 hover:font-semibold'>Connect Hey</a>
         </div>
         <div className='grid grid-flow-col text-right items-center'>
            <div className='mr-28 space-x-8 flex'>
               <p><a onClick={() => { router.push("companies") }} className='cursor-pointer whitespace-nowrap hover:text-gray-100 hover:font-semibold'>Procurar Empresas</a></p>
               <p>|</p>
               <p><a onClick={() => { router.push("suppliers") }} className='cursor-pointer whitespace-nowrap hover:text-gray-100 hover:font-semibold'>Procurar Fornecedores</a></p>
            </div>
         </div>
      </div>
   )
}