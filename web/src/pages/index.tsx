import { FormEvent, useState } from 'react';
import { useRouter } from 'next/router';

import { Input } from '@/components/Input'
import { Header } from '@/components/Header';

import { api } from '@/lib/axios'

export default function Home() {
  const [cnpj, setCnpj] = useState('')
  const [name, setName] = useState('')
  const [cep, setCep] = useState('')
  const [email, setEmail] = useState('')

  const router = useRouter()

  async function register(event: FormEvent) {
    event.preventDefault()

    // console.log({ cnpj, name, cep, email })

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
        alert('Sua empresa foi cadastrada com sucesso!')

        setCnpj('')
        setName('')
        setCep('')
        setEmail('')

        router.push('/')
      }
      else {
        alert('ERRO! Falha ao tentar cadastrar sua empresa.\nNão sabemos o que aconteceu, mas você pode tentar novamente mais tarde')
      }

    } catch (error: any) {
      // console.log("Error: " + error.response.data.message)
      console.log(error)

      if (error.response.data.message == "This Zip Code is not valid") {
        alert('Este CEP não é válido e não conseguimos registrar sua empresa, tente novamente por favor!')
      } else {
        alert('Algum erro não permitiu registrarmos sua empresa, tente novamente por favor!')
      }

    }
  }

  return (
    <div>
      <Header />

      <div className='w-[80%] mx-auto my-14 text-center text-6xl text-gray-700'>
        Aqui é onde você encontra empresas que podem ajudar seu negócio de alguma forma!
      </div>

      <div className='w-fit m-auto backdrop-opacity-50 bg-white/30 
                      py-4 px-8 text-gray-700 rounded-xl'>
        <div className='m-4 text-center text-4xl'>
          Cadastre sua empresa!
        </div>
        <form onSubmit={register} className='grid gap-8'>
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
          <button
            className='rounded-lg p-3 bg-violet-700 outline-none w-[40rem] mx-auto  text-gray-400
            focus:border-violet-500 focus:border-solid focus:border-2 focus:rounded-lg
            hover:bg-violet-500 hover:text-gray-800 hover:rounded-lg '
          >
            Enviar
          </button>
        </form>
      </div>

    </div>
  )
}

