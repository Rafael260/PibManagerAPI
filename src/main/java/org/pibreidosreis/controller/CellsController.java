package org.pibreidosreis.controller;

import org.pibreidosreis.dto.CellDTO;
import org.pibreidosreis.entity.Cell;
import org.pibreidosreis.service.CellsService;
import org.pibreidosreis.service.MembersService;
import org.pibreidosreis.util.mapper.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/cells")
public class CellsController {

    private CellsService cellsService;
    private MembersService membersService;

    @Autowired
    public CellsController(CellsService cellsService, MembersService membersService) {
        this.cellsService = cellsService;
        this.membersService = membersService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CellDTO>> listAll() {
        List<CellDTO> all = cellsService.findAll(CellDTO.class);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CellDTO> findById(@PathVariable Long id) {
        Cell cell = cellsService.findById(id);
        return new ResponseEntity<>(MapperUtils.map(cell,CellDTO.class), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CellDTO> create(@Valid @RequestBody CellDTO cellDTO) {
        Cell newCell = MapperUtils.map(cellDTO, Cell.class);
        System.out.println("Vai buscar o membro pelo id");
        newCell.setLeader(membersService.findById(cellDTO.getLeaderId()));
        newCell = cellsService.insert(newCell);
        return new ResponseEntity<>(MapperUtils.map(newCell, CellDTO.class),
                HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CellDTO> update(@PathVariable Long id,
                                            @Valid @RequestBody CellDTO cellDTO) {
        cellDTO.setId(id);
        Cell cell = cellsService.update(MapperUtils.map(cellDTO, Cell.class));
        return new ResponseEntity<>(MapperUtils.map(cell, CellDTO.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        cellsService.deleteById(id);
    }
}
