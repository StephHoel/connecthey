import { useState, useEffect } from 'react';
import { ArrowUp } from 'phosphor-react';

const ScrollToTop = () => {
   const [isVisible, setIsVisible] = useState<boolean>(false);

   useEffect(() => {
      const toggleVisibility = () => {
         if (window.pageYOffset > 300) {
            setIsVisible(true);
         } else {
            setIsVisible(false);
         }
      };

      window.addEventListener('scroll', toggleVisibility);

      return () => window.removeEventListener('scroll', toggleVisibility);
   }, []);

   const scrollToTop = () => {
      window.scrollTo({
         top: 0,
         behavior: 'smooth',
      });
   };

   return (
      <div>
         {isVisible && (
            <div
               className="w-12 h-12 fixed bottom-8 right-8 rounded-full cursor-pointer 
               bg-gray-600 text-white flex justify-center items-center"
               onClick={scrollToTop}
            >
               <ArrowUp size={32} />
            </div>
         )}
      </div>
   );
};

export default ScrollToTop;
