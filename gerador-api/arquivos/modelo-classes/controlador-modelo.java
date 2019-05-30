package @NOME_PACKAGE_DE_CONTROLADOR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import @NOME_PACKAGE_DE_ENTIDADE.@NOME_DA_CLASSE_PRIMEIRA_MAIUSCULAEntity;
import @NOME_PACKAGE_DE_REPOSITORIO.@NOME_DA_CLASSE_PRIMEIRA_MAIUSCULARepository;

@RestController
@RequestMapping("/@NOME_DA_CLASSE_TUDO_MINUSCULA_NO_PLURAL")
public class @NOME_DA_CLASSE_PRIMEIRA_MAIUSCULAController {

	@Autowired 
	@NOME_DA_CLASSE_PRIMEIRA_MAIUSCULARepository @NOME_DA_CLASSE_TUDO_MINUSCULARepository;
	
	
	@INICIO_DA_IMPLEMENTACAO_DA_CLASSE
	

}
