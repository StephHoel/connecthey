import { InputHTMLAttributes } from "react";

export function Input({ title, ...rest }: InputHTMLAttributes<HTMLInputElement>) {
   return (
      <div className='items-center mx-auto'>
         <div>
            <label
               className='font-bold text-violet-800 ml-4'
            >
               {title}
            </label>
         </div>

         <input {...rest}
            required
            placeholder={title == "CNPJ" ? "CNPJ (somente números)" : title == "Nome" ? "Nome Fantasia" : title == "CEP" ? "CEP (somente números)" : title}
            className='rounded-lg p-3 text-violet-700 outline-none w-[40rem]
               placeholder:px-2 placeholder:text-violet-400
               focus:outline-violet-500 focus:outline focus:outline-offset-0 focus:outline-4 focus:rounded-lg 
               hover:outline-violet-500 hover:outline hover:outline-offset-0 hover:outline-4 hover:rounded-lg 
            '
         />
      </div >
   )
}