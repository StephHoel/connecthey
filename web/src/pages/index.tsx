/* eslint-disable @next/next/no-img-element */
import Image from 'next/image'

import { FormEvent, useState } from 'react';

import { Input } from '@/components/Input'

import { api } from '../lib/axios'
import { useRouter } from 'next/router';

export default function Home() {
  const [cnpj, setCnpj] = useState('')
  const [name, setName] = useState('')
  const [cep, setCep] = useState('')
  const [email, setEmail] = useState('')

  const router = useRouter()

  async function register(event: FormEvent) {
    event.preventDefault()

    console.log({ cnpj, name, cep, email })

    try {
      const response = await api.post('/api/company', {
        cnpjCompany: cnpj,
        fantasyNameCompany: name,
        postalCompany: cep,
        emailCompany: email,
      });

      const status = response.data.message

      if (status == 'User registered successfully') {
        alert('Usuário cadastrado com sucesso!\nFaça o login para acessar sua conta!')
        router.push('/')
      } else {
        alert('ERRO! Falha ao tentar registrar. Não sabe o que aconteceu, mas você pode tentar novamente mais tarde.')
      }
    } catch (error) {
      console.log(error)
      alert('Falha ao tentar registrar, tente novamente!')
    }
  }

  return (
    <div className='bg-gradient-to-r from-violet-400 to-violet-500 
                    w-screen h-full min-h-screen bg-cover pb-8'>
      {/* top */}
      <div className='w-full h-28 bg-violet-600 opacity-70 space-x-[30%] 
                      py-4 grid grid-flow-col text-gray-300'>
        <div className='text-left ml-12 text-5xl self-center'>
          Connect Hey
        </div>
        <div className='grid grid-flow-col text-right items-center'>
          <div className='mr-28 space-x-8 flex'>
            <p><a onClick={() => { router.push("companies") }} className='cursor-pointer hover:text-gray-100 hover:font-semibold'>Procurar Empresas</a></p>
            <p>|</p>
            <p><a onClick={() => { router.push("suppliers") }} className='cursor-pointer hover:text-gray-100 hover:font-semibold'>Procurar Fornecedores</a></p>
          </div>
        </div>
      </div>

      {/* main */}
      <div className='w-[80%] mx-auto my-14 text-center text-6xl text-gray-700'>
        Aqui é onde você encontra empresas que podem ajudar seu negócio de alguma forma!
      </div>

      <div className='w-1/2 min-w-[450px] m-auto backdrop-opacity-50 bg-white/30 
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

