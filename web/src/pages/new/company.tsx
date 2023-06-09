import { FormEvent, useState } from "react";
import { useRouter } from "next/router";

import { BgBlur } from "@/components/BgBlur";
import { Button } from "@/components/FormButton";
import { Header } from "@/components/Header";
import { Input } from "@/components/Input";

import { RegisterError, RegisterErrorZip, RegisterFailed, RegisterSuccefully } from "@/lib/alert";
import { api } from "@/lib/axios";

export default function NewCompany() {
   const [cnpj, setCnpj] = useState('')
   const [name, setName] = useState('')
   const [cep, setCep] = useState('')
   const [email, setEmail] = useState('')

   const router = useRouter()

   async function register(event: FormEvent) {
      event.preventDefault()

      const type = "empresa"

      try {
         const response = await api.post('/company', {
            cnpjCompany: cnpj,
            fantasyNameCompany: name,
            postalCompany: cep,
            emailCompany: email,
         });

         const status = response.status

         // console.log(status)

         if (status == 201) {
            alert(RegisterSuccefully(type))

            setCnpj('')
            setName('')
            setCep('')
            setEmail('')

            router.push('/')
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
               Cadastre-se como negócio
            </div>

            <form onSubmit={register} className='grid gap-8 pb-8'>
               <Input
                  type='number'
                  max={99999999999}
                  title='CNPJ'
                  onChange={event => setCnpj(event.target.value)}
                  value={cnpj}
               />
               <Input
                  type='text'
                  title='Nome'
                  onChange={event => setName(event.target.value)}
                  value={name}
               />
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