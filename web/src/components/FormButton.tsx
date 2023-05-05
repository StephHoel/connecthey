export function Button({ title }: any) {
   return (
      <button
         className='rounded-lg p-3 bg-violet-700 outline-none w-[40rem] mx-auto text-gray-300
                  focus:border-violet-500 focus:border-solid focus:border-2 focus:rounded-lg
                  hover:bg-violet-500 hover:text-gray-800 hover:rounded-lg '
      >
         {title}
      </button>
   )
}