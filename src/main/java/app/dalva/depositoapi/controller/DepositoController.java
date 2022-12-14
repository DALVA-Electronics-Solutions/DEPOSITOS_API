package app.dalva.depositoapi.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import app.dalva.depositoapi.model.dto.DepositoDto;
import app.dalva.depositoapi.model.request.DepositoRequest;
import app.dalva.depositoapi.model.response.DepositoDeleteResponse;
import app.dalva.depositoapi.model.response.DepositoListResponse;
import app.dalva.depositoapi.service.DepositoService;

@RestController
public class DepositoController {

    private final DepositoService depositoService;

    public DepositoController(DepositoService depositoService) {
        this.depositoService = depositoService;
    }

    @GetMapping("/deposito/{id}")
    public ResponseEntity<DepositoListResponse> getdeposito(@PathVariable("id") Long id) {
        DepositoListResponse response = depositoService.getdeposito(id);

        if (CollectionUtils.isEmpty(response.getDepositos())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @GetMapping("/depositos")
    public ResponseEntity<DepositoListResponse> getAlldepositos() {
        DepositoListResponse response = depositoService.getAlldepositos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/depositos/com/{comunicacao}")
    public ResponseEntity<DepositoListResponse> getAlldepositosFiltroCom(@PathVariable("comunicacao") Integer comunicacao) {
        DepositoListResponse response = depositoService.getAlldepositosFiltroCom(comunicacao);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/depositos/body/{body}")
    public ResponseEntity<DepositoListResponse> getAlldepositosFiltroBody(@PathVariable("body") String body) {
        DepositoListResponse response = depositoService.getAlldepositosFiltroBody(body);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/deposito")
    public ResponseEntity<DepositoDto> createdeposito(@RequestBody DepositoRequest request) {
        return new ResponseEntity<>(depositoService.createdeposito(request), HttpStatus.CREATED);
    }

    @PutMapping("/deposito/{id}")
    public ResponseEntity<DepositoDto> updatedeposito(@PathVariable("id") Long id, @RequestBody DepositoRequest request) {
        DepositoDto depositoDto = depositoService.updatedeposito(id, request);
        if (null == depositoDto) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(depositoDto, HttpStatus.OK);
        }
    }

    @DeleteMapping("/deposito/{id}")
    public ResponseEntity<DepositoDeleteResponse> deletedeposito(@PathVariable("id") Long id) {
        DepositoDeleteResponse response = depositoService.deletedeposito(id);
        if (0L == response.getDeleteddepositoCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/depositos")
    public ResponseEntity<DepositoDeleteResponse> deleteAlldeposito() {
        DepositoDeleteResponse response = depositoService.deleteAlldepositos();
        if (0L == response.getDeleteddepositoCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


    @DeleteMapping("/depositos/body/{body}")
    public ResponseEntity<DepositoDeleteResponse> deleteAlldepositosFiltroBody(@PathVariable("body") String body) {
        
        DepositoDeleteResponse response = depositoService.deleteAlldepositosFiltroBody(body);
        if (0L == response.getDeleteddepositoCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/depositos/vers")
    private String readVersdepositos() throws IOException{
        
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("depositos.vers").getFile());
        String data = FileUtils.readFileToString(file, "UTF-8");
            
        return data;
    }



    @PutMapping("/depositos/vers")
    public String updateVersDeposito() {
        String readVersDepositos="0";
	String str="0";
        try {
            readVersDepositos = readVersdepositos();
            int vers = Integer.parseInt(readVersDepositos);
            vers++;
            // UPDATE vers
            str = String.valueOf(vers);
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("depositos.vers").getFile());
        
          FileUtils.writeStringToFile(
                            file,
                            str,
                            StandardCharsets.UTF_8,
                            false // == append to end of file
                    );           
            
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
        return str;
    }


}
