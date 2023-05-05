import { FormEvent, useEffect, useState } from "react";
import { useRouter } from "next/router";

import { BgBlur } from "@/components/BgBlur";
import { Button } from "@/components/FormButton";
import { Header } from "@/components/Header";
import { Input } from "@/components/Input";

import { RegisterError, RegisterErrorZip, RegisterFailed, RegisterSuccefully } from "@/lib/alert";
import { api } from "@/lib/axios";

export default function NewSupplier() {
   const [cnpj, setCnpj] = useState('')
   const [cpf, setCpf] = useState('')
   const [rg, setRG] = useState('')
   const [date, setDate] = useState('')
   const [name, setName] = useState('')
   const [cep, setCep] = useState('')
   const [email, setEmail] = useState('')
   const [isChecked, setIsChecked] = useState<boolean>(false);

   const router = useRouter()

   useEffect(() => {
      console.log(isChecked)

      if (isChecked) {
         setCpf('')
         setRG('')
         setDate('')
      } else {
         setCnpj('')
      }
   }, [isChecked])

   async function register(event: FormEvent) {
      event.preventDefault()

      const type = "fornecedora"

      try {
         const response = await api.post('/supplier', {
            cnpjCpfSupplier: isChecked ? cnpj : cpf,
            isCnpjSupplier: isChecked,
            nameSupplier: name,
            postalSupplier: cep,
            emailSupplier: email,
            rgSupplier: rg,
            birthdaySupplier: date,
         });

         const status = response.status

         // console.log(status)

         if (status == 201) {
            alert(RegisterSuccefully(type))

            setCnpj('')
            setIsChecked(false)
            setCpf('')
            setRG('')
            setDate('')
            setName('')
            setCep('')
            setEmail('')

            // router.push('/')
         }
         else {
            alert(RegisterFailed(type))
         }

      } catch (error: any) {
         // console.log("Error: " + error.response.data.message)
         console.log(error)

         if (error.response.data.message == "This Zip Code is not valid") {
            alert(RegisterErrorZip(type))
         } else {
            alert(RegisterError(type))
         }

      }
   }

   return (
      <div>
         <Header />

         <BgBlur>
            <div className='m-4 text-center text-4xl'>
               Cadastre-se como fornecedor
            </div>
            <form onSubmit={register} className='grid gap-8'>

               {/* checkbox slider */}
               <div className="relative inline-block w-10 mr-2 align-middle select-none transition duration-200 ease-in">
                  <label htmlFor="checkbox-slider" className="flex items-center cursor-pointer">
                     <div className="relative">
                        <input
                           id="checkbox-slider"
                           type="checkbox"
                           className="sr-only"
                           checked={isChecked}
                           onChange={(e) => setIsChecked(e.target.checked)}
                        />
                        <div className="block bg-gray-200 w-14 h-8 rounded-full"></div>
                        <div
                           className={`absolute left-1 top-1 w-6 h-6 rounded-full transition transform
                           ${isChecked
                                 ? "translate-x-full bg-violet-600"
                                 : "bg-gray-500"
                              }`}
                        ></div>
                     </div>
                     <div className="ml-4 font-bold text-violet-800 whitespace-nowrap">
                        Você é PJ?
                     </div>
                  </label>
               </div>

               {isChecked ? (
                  < Input
                     type='number'
                     max={99999999999999}
                     title='CNPJ'
                     onChange={event => setCnpj(event.target.value)}
                     value={cnpj}
                  />
               ) : (
                  <Input
                     type='number'
                     max={99999999999}
                     title='CPF'
                     onChange={event => setCpf(event.target.value)}
                     value={cpf}
                  />
               )}

               {isChecked ?
                  null :
                  <Input
                     type='number'
                     max={99999999999}
                     title='RG'
                     onChange={event => setRG(event.target.value)}
                     value={rg}
                  />
               }

               {isChecked ?
                  null :
                  <Input
                     type='date'
                     title='Data de Nascimento'
                     onChange={event => setDate(event.target.value)}
                     value={date}
                  />
               }

               {isChecked ?
                  <Input
                     type='text'
                     title='Nome Fantasia'
                     onChange={event => setName(event.target.value)}
                     value={name}
                  />
                  :
                  <Input
                     type='text'
                     title='Nome Completo'
                     onChange={event => setName(event.target.value)}
                     value={name}
                  />
               }

               <Input
                  type='number'
                  max={99999999}
                  title='CEP'
                  onChange={event => setCep(event.target.value)}
                  value={cep}
               />

               <Input
                  type='email'
                  title='E-mail'
                  onChange={event => setEmail(event.target.value)}
                  value={email}
               />

               <Button title="Enviar" />
            </form>
         </BgBlur >

      </div>
   )
}