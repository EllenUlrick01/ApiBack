package br.com.EllenUlrick.Carros.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {

    private static final Integer Integer = null;
    private int counter = 1;
    private Map<Integer, Carro> carro;
    private Map<Integer, String> items;
    private LocalDate date = LocalDate.now();

    public CarroController() {

        carro = new HashMap<Integer, Carro>();
    }

    //Mapping home
    @GetMapping("/")
    public ResponseEntity<Object> carro() {
        items = new HashMap<Integer, String>();
        items.put(0, "Endpoints disponíveis: ");
        items.put(1, "/");
        items.put(2, "/carro   with GET, POST, PUT");
        items.put(3, "/carro/{id}  with GET, DELETE");

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    //Mapping all carro
    @GetMapping("/carro")
    public ResponseEntity<List<Carro>> List() {

        final List<Carro> result = new ArrayList<>(carro.values());

        if (result.isEmpty()) {
            System.out.println("Não há carros registrados!");
            return new ResponseEntity("Não há carros registrados!", HttpStatus.NOT_FOUND);
        }
        System.out.println("Carro encontrado!");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //Mapping course with id
    @RequestMapping(value = "/carros/{id}", method = RequestMethod.GET)
    public ResponseEntity<Carro> Find(@PathVariable("id") Integer id) {

        HttpHeaders responseHeaders = new HttpHeaders();
        Carro carros = carro.get(id);

    if (carro == null) {
        responseHeaders.set("Mensagem de Retorno", "Carro não encontrado!");
        return new ResponseEntity("Carro não encontrado!", responseHeaders, HttpStatus.NOT_FOUND);
    }
        System.out.println("Carro encontrado -> " + ((Carro) carro).getNome());
        responseHeaders.set("Return message", "Course successfully found!");
    
        return new ResponseEntity(carro(), responseHeaders, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/carro", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Carro> postCourse(@RequestBody Carro Carro){

        HttpHeaders responseHeaders = new HttpHeaders();
        br.com.EllenUlrick.Carros.api.Carro newCarro = new Carro(counter,Carro.getIdMarca(),Carro.getMarca(), Carro.getidCarro(), Carro.getNome(), Carro.getidCor(), Carro.getnomeCor(), date);
        Carro.put(counter, newCarro);
        counter++;

        if (newCarro.getNome().isEmpty()) {
            responseHeaders.set("Retornar Mensagem", "Carro não encontrado");
            return new ResponseEntity("Carro não encontrado!", responseHeaders, HttpStatus.NOT_FOUND);
        }

        System.out.println("Carro criado com sucesso-> " + Carro.getNome());
        responseHeaders.set("Retornar Mensagem", "Carro criado com Sucesso!");
        return new ResponseEntity<Carro>(newCarro, responseHeaders, HttpStatus.OK);
    }

    //Modifying a course with PUT method
    @RequestMapping(value = "/carro/" , method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Carro> putCarro(@RequestBody Carro carro) {

        HttpHeaders responseHeaders = new HttpHeaders();
        Carro ModifiedCarro = new Carro(Carro.getIdMarca(), counter, null, counter, null, counter, null, date);
        Carro id = carro.get(carro.getidCarro());

        if (id == null) {
            responseHeaders.set("Retornar Mensagem", "Carro não encontrado");
            return new ResponseEntity("Carro não encontrado",responseHeaders, HttpStatus.NOT_FOUND);
        }

        carro.put(carro.getidCarro(), ModifiedCarro);
        System.out.println("Carro modificado com sucesso -> " + carro.getNome());
        responseHeaders.set("Retornar Mensagem", "Carro mofificado com Sucesso!");
        return new ResponseEntity<Carro>(ModifiedCarro, responseHeaders, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/carro/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Carro>DeleteCourse(@PathVariable Integer id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        Carro carros = carro.remove(id);

        if (carro == null) {
            responseHeaders.set("Retornar Mensagem", "ID não encontrado");
            return new ResponseEntity("Id não encontrado", responseHeaders, HttpStatus.NOT_FOUND);
        }

        System.out.println("Carro deletado com sucesso->  " + carros.getNome());
        responseHeaders.set("Retornar Mensagem", "Carro deletado com Sucesso");
        return new ResponseEntity<>(carros, responseHeaders, HttpStatus.OK);
    }
}
