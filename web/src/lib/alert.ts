export function RegisterSuccefully(s: String) {
   return `Cadastro de ${s} feito com sucesso!`
}

export function RegisterFailed(s: String) {
   return `Falha ao tentar cadastrar ${s}.\nNão sabemos o que aconteceu, mas você pode tentar novamente mais tarde`
}

export function RegisterError(s: String) {
   return `Algum erro não permitiu fazermos o registro de ${s}, por favor, tente novamente`
}

export function RegisterErrorZip(s: String) {
   return `Este CEP não é válido e não conseguimos fazer o registro de ${s}, por favor, tente novamente`
}

export function GeneralError() {
   return 'Ocorreu algum erro inexperado, por favor, tente novamente'
}

export function SearchFailed(s: String) {
   return `Falha ao tentar procurar por ${s}\nNão sabemos o que aconteceu, mas você pode tentar novamente mais tarde`
}

export function LoginFailed (s: String) {
   return `Falha ao tentar logar ${s}.\nNão sabemos o que aconteceu, mas você pode tentar novamente mais tarde`
}