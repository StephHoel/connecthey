import bcrypt from 'bcryptjs';

export function doc(doc: String) {
   //[0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2}
   if (doc.length == 14)
      return doc.substring(0, 2) + "." + doc.substring(2, 5) + "." + doc.substring(5, 8) + "/" + doc.substring(8, 12) + "-" + doc.substring(12, 14)
   else
      return doc.substring(0, 3) + "." + doc.substring(3, 6) + "." + doc.substring(6, 9) + "-" + doc.substring(9, 11)
}

export function zip(zip: String) {
   return zip.substring(0, 2) + "." + zip.substring(2, 5) + "-" + zip.substring(5, 8)
}

export function hash(hash: string) {
   return bcrypt.hashSync(hash, 5)
}
