package com.springjourney.Week3Practice.Controllers;

import com.springjourney.Week3Practice.Entities.Films;
import com.springjourney.Week3Practice.Repositories.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmsController {

    @Autowired
    private FilmsRepository filmsRepository;
    //----------------Sorting---------------------
    @GetMapping(path = "/all")
    public List<Films> getElementsBySorting(@RequestParam(defaultValue = "filmId") String sortBy){
       // return  filmsRepository.findBy(Sort.by(sortBy,"imdbRating"));\
        //  Alternative Way Of Doing Sorting
        return filmsRepository.findBy(Sort.by(Sort.Order.asc("genre"),Sort.Order.desc("imdbRating")));
    }



    //  -----------------Pagination----------------
    @GetMapping(path = "/page/all")
    public List<Films> getElementsByPagination(@RequestParam(defaultValue = "filmId") String sortBy,
                                               @RequestParam(defaultValue = "0") int pageNumber){
        int Page_Size=3;
        Pageable pageable= PageRequest.of(pageNumber,Page_Size,Sort.by("genre").ascending());
        return filmsRepository.findAll(pageable).getContent();
    }



}
