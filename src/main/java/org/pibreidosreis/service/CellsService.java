package org.pibreidosreis.service;

import org.pibreidosreis.entity.Cell;
import org.pibreidosreis.repository.CellsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CellsService extends AbstractService<Cell>{

    private AddressesService addressesService;

    @Autowired
    public CellsService(CellsRepository repository, AddressesService addressesService) {
        super(repository);
        this.addressesService = addressesService;
    }

    @Override
    public void onBeforeInsert(Cell cell) {
        this.addressesService.insert(cell.getAddress());
    }
}
