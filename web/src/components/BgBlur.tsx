export function BgBlur({ children }:any) {
   return (
      <div className='w-fit m-auto my-14 backdrop-opacity-90 bg-white/70 
                        py-4 px-8 text-gray-700 rounded-xl'>
         {children}
      </div>
   )
}