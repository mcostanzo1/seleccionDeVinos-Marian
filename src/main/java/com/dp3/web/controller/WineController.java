package com.dp3.web.controller;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.WineRepository;
import com.dp3.domain.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/wines")
@CrossOrigin("*")
public class WineController {

    @Autowired
    private WineRepository wineRepository;

    @Autowired
    private CellarRepository cellarRepository;

    @GetMapping("/all")
    public List<Wine> getAllWines(){
        Sort sortByWineNameDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return wineRepository.findAll(sortByWineNameDesc);
    }

    @PostMapping("/createWine")
    public ModelAndView createWine(Model model, Wine wine){
        model.addAttribute("cellars", cellarRepository.findAll());
        wineRepository.save(wine);
        return new ModelAndView("redirect:/stock/all");
    }

    @GetMapping(value = "/wine/{wineName}")
    public ResponseEntity<Wine> getWineByWineName(@PathVariable("wineName") String wineName){
        Wine wine = wineRepository.findOne(wineName);
        if(wine == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(wine, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/wine/{wineName}")
    public ResponseEntity<Wine> updateWine(@PathVariable("wineName") String wineName,
                                                @RequestBody Wine wine){
        Wine wineData = wineRepository.findOne(wineName);
        if(wineData == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        wineData.setWineName(wine.getWineName());
        wineData.setClasify(wine.getClasify());
        wineData.setQuantityOnBox(wine.getQuantityOnBox());
        wineData.setQuantityOnStockBox(wine.getQuantityOnStockBox());
        Wine updateWine = wineRepository.save(wineData);
        return new ResponseEntity<>(updateWine,HttpStatus.OK);
    }

    @DeleteMapping(value = "/wine/{wineName}")
    public void deleteWine(@PathVariable("wineName") String wineName){
        wineRepository.delete(wineName);
    }

}
