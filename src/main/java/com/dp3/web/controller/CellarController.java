package com.dp3.web.controller;

import com.dp3.dao.CellarRepository;
import com.dp3.domain.Cellar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cellars")
@CrossOrigin("*")
public class CellarController {

    @Autowired
    private CellarRepository cellarRepository;

    @GetMapping("/all")
    public List<Cellar> getAllCellars(){
        Sort sortByCellarNameDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return cellarRepository.findAll(sortByCellarNameDesc);
    }

    @PostMapping("/createCellar")
    public ModelAndView createCellar(Model model, @Valid Cellar cellar){
        cellarRepository.save(cellar);
        model.addAttribute("cellars", cellarRepository.findAll());
        return new ModelAndView("redirect:/stock/all");
    }

    @GetMapping(value = "/cellar/{cellarName}")
    public ResponseEntity<Cellar> getCellarByCellarName(@PathVariable("cellarName") String cellarName){
        Cellar cellar = cellarRepository.findOne(cellarName);
        if(cellar == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(cellar, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/cellar/{cellarName}")
    public ResponseEntity<Cellar> updateCellar(@PathVariable("cellarName") String cellarName,
                                               @Valid @RequestBody Cellar cellar){
        Cellar cellarData = cellarRepository.findOne(cellarName);
        if(cellarData == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cellarData.setCellarName(cellar.getCellarName());
        cellarData.setDescription(cellar.getDescription());
        cellarData.setLocation(cellar.getLocation());
        Cellar updateCellar = cellarRepository.save(cellarData);
        return new ResponseEntity<>(updateCellar,HttpStatus.OK);
    }

    @DeleteMapping(value = "/cellar/{cellarName}")
    public void deleteCellar(@PathVariable("cellarName") String cellarName){
        cellarRepository.delete(cellarName);
    }

}
