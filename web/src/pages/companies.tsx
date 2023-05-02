import { FormEvent, Key, useEffect, useState } from "react";

import { MagnifyingGlass } from 'phosphor-react';

import { Header } from "@/components/Header";
import ScrollToTop from '@/components/ToTop';

import { api } from "@/lib/axios";
import { doc, zip } from '@/lib/format';
import { Company } from '@/lib/model';
import { BgBlur } from "@/components/BgBlur";
import { GeneralError, SearchFailed } from "@/lib/alert";

export default function Companies() {

   const [listCompany, setListCompany] = useState<any>(null)
   const [isLoaded, setIsLoaded] = useState<boolean>(false);
   const [searchCompany, setSearchCompany] = useState("");

   useEffect(() => {
      const fetchData = async () => {
         try {
            const response = await api.get(`/company`);

            const status = response.status

            if (status == 200) {
               setListCompany(response.data)
               setIsLoaded(true)
            }

         } catch (error: any) {
            // console.log("Error: " + error.response.data.message)
            console.log(error)
            setIsLoaded(false)

            alert(GeneralError())

         }
      };

      if (!isLoaded) {
         fetchData();
      }

   }, [isLoaded]);

   async function search(event: FormEvent) {
      event.preventDefault()

      setIsLoaded(false)

      let uri = ""
      const type = "empresas"

      if (searchCompany != "") {
         uri = `/company/name/${searchCompany.toLowerCase()}`
      } else {
         uri = "/company"
      }

      try {
         const response = await api.get(uri);

         const status = response.status

         if (status == 200) {
            setListCompany(null)
            setListCompany(response.data)

            setSearchCompany("")

            setIsLoaded(true)
         }
         else {
            alert(SearchFailed(type))
         }

      } catch (error: any) {
         // console.log("Error: " + error.response.data.message)
         console.log(error)


         alert(SearchFailed(type))

      }
   }

   return (
      <div>
         <Header />

         <BgBlur>
            <form onSubmit={search}>

               <div className="flex items-center">
                  <MagnifyingGlass className="mr-2 text-gray-500" />
                  <input
                     className='rounded-lg p-3 text-violet-700 outline-none w-[35rem] mr-4
               placeholder:px-2 placeholder:text-violet-400
               focus:outline-violet-500 focus:outline focus:outline-offset-0 focus:outline-4 focus:rounded-lg'
                     placeholder="Pesquise uma empresa"
                     onChange={event => setSearchCompany(event.target.value)}
                     value={searchCompany}
                  />
                  <button
                     className='rounded-lg bg-violet-700 outline-none mx-auto p-2  text-gray-400
            focus:border-violet-500 focus:border-solid focus:border-2 focus:rounded-lg
            hover:bg-violet-500 hover:text-gray-800 hover:rounded-lg '
                  >
                     Buscar
                  </button>
               </div>

            </form>
         </BgBlur>

         <BgBlur>
            <div className="w-fit max-w-3/4 mx-auto my-8 text-gray-600 grid grid-cols-2 gap-4">
               {isLoaded && listCompany.length > 0 ?
                  listCompany.map((item: Company, index: any) => (
                     <div
                        key={index}
                        className="col-span-1 py-4 px-8 border-b-2 border-b-gray-400 no-border-last"
                     >
                        <p className="text-4xl">
                           {item.fantasyNameCompany}
                        </p>
                        <p className="px-4 text-2xl">
                           CNPJ: {doc(item.cnpjCompany)}
                        </p>
                        <p className="px-4 text-2xl">
                           CEP: {zip(item.postalCompany)}
                        </p>
                        <p className="px-4 text-2xl">
                           E-mail: {item.emailCompany}
                        </p>

                     </div>
                  ))
                  :
                  <div className='text-6xl text-center col-span-2 my-12'>
                     {listCompany != null ?
                        "Infelizmente ainda não temos empresas!"
                        :
                        "Carregando..."
                     }
                  </div>
               }
            </div>
         </BgBlur>

         <ScrollToTop />
      </div>
   )
}