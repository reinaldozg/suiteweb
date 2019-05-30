package br.com.suite.gerador.staticos;


public class Funcionalidade {
	
	

	public final static String METODO_LISTAR_REPOSITORY = "List<@NOME_DA_CLASSE_PRIMEIRA_MAIUSCULA> @NOME_DO_METODO(@NOME_DOS_PARAMETRO_DO_METODO);";

	public final static String METODO_COM_RETORNO_CONTROLLER = "@GetMapping(path = \"@MAPPING_PATH_CONTROLLER\") " +
																  "public ResponseEntity<?> add(@Valid @NOME_DA_CLASSE_PRIMEIRA_MAIUSCULAEntity @NOME_DA_CLASSE_TUDO_MINUSCULA, BindingResult result) { " +
																  		"if (result.hasErrors()) " +
																  			"return new ResponseEntity<>(\"Parametros inválidos!\", HttpStatus.BAD_REQUEST); " +
																  		"return new ResponseEntity<>(@NOME_DA_CLASSE_TUDO_MINUSCULARepository.@NOME_DO_METODO(@NOME_DOS_PARAMETRO_MAIS_GET), HttpStatus.OK);" +
																  "}";

	
	
	
}
