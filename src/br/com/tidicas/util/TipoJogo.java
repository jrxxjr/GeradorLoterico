package br.com.tidicas.util;

public enum TipoJogo {

    /* Outros tipos de jogos alterar o tamanho da lista de quantidade de dezenas para a quantidade de possibilidades de escolha */
	
	/* MegaSena - Neste tipo de jogo se escolhe 6 numeros entre 60 numeros */				
	MEGA_SENA ("60"),
	MEGA_SENA_DEZENAS ("6"),
	
	/* LotoFacil - Neste tipo de jogo se escolhe 15 numeros entre 25 numeros */
	LOTO_FACIL ("25"),
	LOTO_FACIL_DEZENAS ("15"),

	/* Quina - Neste tipo de jogo se escolhe 5 numeros entre 80 numeros */
	QUINA ("80"),
	QUINA_DEZENAS ("5"),
	
	/* Lotomania - Neste tipo de jogo se escolhe 50 numeros entre 100 numeros */
	LOTOMANIA ("100"),
	LOTOMANIA_DEZENAS ("50"),
	
	/* DuplaSena - Neste tipo de jogo se escolhe 6 numeros entre 50 numeros */
	DUPLASENA ("50"),
	DUPLASENA_DEZENAS ("6");

	private String parametro;
	
	private TipoJogo(String parametro){
		this.parametro = parametro;
	}
	
	@Override
    public String toString() {
        return this.parametro;
    }

}