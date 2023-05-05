import { FormEvent, useState } from 'react';
import { useRouter } from 'next/router';

import { BgBlur } from '@/components/BgBlur';
import { Button } from '@/components/FormButton';
import { Header } from '@/components/Header';
import { Input } from '@/components/Input'

import { GeneralError, LoginFailed, RegisterError, RegisterErrorZip, RegisterFailed, RegisterSuccefully } from '@/lib/alert';
import { api } from '@/lib/axios'
import { hash } from '@/lib/format';

export default function Login() {
   const [username, setUsername] = useState('')
   const [pass, setPass] = useState('')

   const router = useRouter()

   async function login(event: FormEvent) {
      event.preventDefault()

      const type = "usuário"

      try {
         const response = await api.post('/user', {
            usernameUser: username,
            passwordUser: hash(pass),
         });

         const status = response.status

         // console.log(status)

         if (status == 200) {
            setUsername('')
            setPass('')

            router.push('/user/home')
         }
         else {
            alert(LoginFailed(type))
         }

      } catch (error: any) {
         // console.log("Error: " + error.response.data.message)
         console.log(error)

         alert(GeneralError())

      }
   }

   return (
      <div>
         <Header logged={false} />

         <BgBlur>
            <div className='w-fit mx-auto'>
               <div className='m-4 mb-8 text-center text-4xl'>
                  Faça seu login aqui
               </div>

               <form onSubmit={login} className='grid gap-8 pb-8'>

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

                  <Button title="Entrar" />
               </form>
            </div>
         </BgBlur>

      </div>
   )
}

