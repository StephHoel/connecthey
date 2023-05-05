import { BgBlur } from "@/components/BgBlur";
import { Header } from "@/components/Header";

export default function Home() {
   return (
      <div>
         <Header logged={true} />

         <BgBlur>
            cadastro negócio
            cadastro fornecedor
            procurar negócio
            procurar fornecedor
         </BgBlur>
      </div>
   )
};
