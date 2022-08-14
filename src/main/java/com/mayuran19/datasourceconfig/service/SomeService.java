package com.mayuran19.datasourceconfig.service;

import com.mayuran19.datasourceconfig.domain.SomeTable;
import com.mayuran19.datasourceconfig.repository.SomeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class SomeService {
    private final SomeRepository someRepository;

    public SomeService(SomeRepository someRepository) {
        this.someRepository = someRepository;
    }

    public void testWallet(){
        SomeTable someTable = new SomeTable();
        someTable.setId(new Random().nextLong());
        someTable.setSomeText("some text");
        someRepository.save(someTable);
    }
}
