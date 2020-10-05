package com.example.project;

public class CupomFiscal {

	private static boolean isEmpty(String str){
		if(str == null) return true;
		int spaceCount = str.length() - str.replace(".", "").length();
		return (spaceCount == str.length());
	}

	private static String ENDLN = System.lineSeparator();

	public static String dadosLojaObjeto(Loja loja) {
		if(isEmpty(loja.getNomeLoja())){
			throw new RuntimeException("O campo nome da loja é obrigatório");
		}

		if(isEmpty(loja.getLogradouro())){
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}

		String numero1 = loja.getNumero() + "";
		if(loja.getNumero() == 0){
			numero1 = "s/n";
		}

		if(isEmpty(loja.getMunicipio())){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}
		
		if(isEmpty(loja.getEstado())){
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}

		if(isEmpty(loja.getCnpj())){
			throw new RuntimeException("O campo cnpj da loja é obrigatório");
		}

		if(isEmpty(loja.getInscricaoEstadual())){
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}

		String linha2 = loja.getLogradouro() + ", " + numero1;
		if (! isEmpty(loja.getComplemento())){
			linha2 += " " + loja.getComplemento();
		}
		
		String linha3 = "";
		if (! isEmpty(loja.getBairro())){
		  linha3 += loja.getBairro() + " - ";
		}
		linha3 += loja.getMunicipio() + " - " + loja.getEstado();
	  
		String linha4 = "";
		if (! isEmpty(loja.getCep())){
		  linha4 = "CEP:" + loja.getCep();
		}
		if (! isEmpty(loja.getTelefone())){
		  if (! isEmpty(linha4)){
			linha4 += " ";
		  }
		  linha4 += "Tel " + loja.getTelefone();
		}
		if (! isEmpty(linha4)){
		  linha4 += ENDLN;
		}
	  
		String linha5 = "";
		if (! isEmpty(loja.getObservacao())){
		  linha5 += loja.getObservacao();
		}
	  
		String output = loja.getNomeLoja() + ENDLN;
		output += linha2 + ENDLN;
		output += linha3 + ENDLN;
		output += linha4;
		output += linha5 + ENDLN;
		output += "CNPJ: " + loja.getCnpj() + ENDLN;
		output += "IE: " + loja.getInscricaoEstadual() + ENDLN;
	  
		return output;
	  }
}
