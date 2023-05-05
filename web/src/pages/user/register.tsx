import { FormEvent, useState } from 'react';
import { useRouter } from 'next/router';

import { BgBlur } from '@/components/BgBlur';
import { Button } from '@/components/FormButton';
import { Header } from '@/components/Header';
import { Input } from '@/components/Input'

import { RegisterError, RegisterErrorZip, RegisterFailed, RegisterSuccefully } from '@/lib/alert';
import { api } from '@/lib/axios'
import { hash } from '@/lib/format';

export default function Register() {
   const [cnpj, setCnpj] = useState('')
   const [cpf, setCpf] = useState('')
   const [name, setName] = useState('')
   const [username, setUsername] = useState('')
   const [email, setEmail] = useState('')
   const [pass, setPass] = useState('')
   const [isChecked, setIsChecked] = useState<boolean>(true)

   const router = useRouter()

   async function register(event: FormEvent) {
      event.preventDefault()

      const type = "usuário"

      // console.log({ cnpj, name, cep, email })

      try {
         const response = await api.post('/user/new', {
            docUser: !isChecked ? cnpj : cpf,
            nameUser: name,
            usernameUser: username,
            emailUser: email,
            passwordUser: hash(pass),
            isCpfUser: isChecked,
         });

         const status = response.status

         // console.log(status)

         if (status == 201) {
            alert(RegisterSuccefully(type))

            setCnpj('')
            setCpf('')
            setName('')
            setUsername('')
            setEmail('')
            setPass('')

            router.push({
               pathname: '/user/login',
               query: { user: username },
            })
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
            <div className='w-fit mx-auto'>
               <div className='m-4 mb-8 text-center text-4xl'>
                  Cadastre-se abaixo
               </div>

               <form onSubmit={register} className='grid gap-8 pb-8'>

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
                              className={`absolute left-1 top-1 w-6 h-6 rounded-full transition transform ${isChecked ? "translate-x-full bg-violet-600" : "bg-gray-500"} `}
                           ></div>
                        </div>
                        <div className="ml-4 font-bold text-violet-800 whitespace-nowrap">
                           Você é PF?
                        </div>
                     </label>
                  </div>

                  {!isChecked ?
                     < Input
                        type='number'
                        max={99999999999999}
                        title='CNPJ'
                        onChange={event => setCnpj(event.target.value)}
                        value={cnpj}
                     />
                     :
                     <Input
                        type='number'
                        max={99999999999}
                        title='CPF'
                        onChange={event => setCpf(event.target.value)}
                        value={cpf}
                     />
                  }

                  {!isChecked ?
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
                     type='text'
                     title='Usuário'
                     onChange={event => setUsername(event.target.value)}
                     value={username}
                  />

                  <Input
                     type='password'
                     title='Senha'
                     onChange={event => setPass(event.target.value)}
                     value={pass}
                  />

                  <Input
                     type='email'
                     title='E-mail'
                     onChange={event => setEmail(event.target.value)}
                     value={email}
                  />

                  <Button title="Registrar" />
               </form>
            </div>
         </BgBlur>

      </div>
   )
}