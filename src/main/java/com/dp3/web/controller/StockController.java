package com.dp3.web.controller;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.StockRepository;
import com.dp3.dao.WineRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.Stock;
import com.dp3.domain.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/stock")
@CrossOrigin("*")
public class StockController {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private CellarRepository cellarRepository;

	@Autowired
	private WineRepository wineRepository;

	@GetMapping("/all")
	public ModelAndView stock(Model model){
		ModelAndView stock = new ModelAndView("stock");
		model.addAttribute("wines", wineRepository.findAll());
		model.addAttribute("stockList",stockRepository.findAll());
		model.addAttribute("cellars", cellarRepository.findAll());
		return stock;
	}



	@PostMapping("/createStock")
	public ModelAndView createWine(Model model, Stock stock){
		model.addAttribute("products", wineRepository.findAll());
		model.addAttribute("wines", wineRepository.findAll());
		model.addAttribute("cellars", cellarRepository.findAll());
		stockRepository.save(stock);
		return new ModelAndView("redirect:/stock/all");
	}

	@GetMapping(value = "/{stockCode}")
	public ResponseEntity<Stock> getStockByStockCode(@PathVariable("stockCode") String stockCode){
		Stock stock = stockRepository.findOne(stockCode);
		if(stock == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<>(stock, HttpStatus.OK);
		}
	}

	@PutMapping(value = "/edit/{stockCode}")
	public ResponseEntity<Stock> updateStock(@PathVariable("StockCode") String stockCode,
											 @Valid @RequestBody Stock stock){
		Stock stockData = stockRepository.findOne(stockCode);
		if(stockData == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		stockData.setProductName(stock.getProductName());
		stockData.setPrice(stock.getPrice());
		stockData.setQuantityOnStockBox(stock.getQuantityOnStockBox());
		Stock updateStock = stockRepository.save(stockData);
		return new ResponseEntity<>(updateStock,HttpStatus.OK);
	}

	@DeleteMapping(value = "/stock/{stockCode}")
	public void deleteStock(@PathVariable("stockCode") String stockCode){
		stockRepository.delete(stockCode);
	}

}

