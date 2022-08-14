package com.mayuran19.datasourceconfig.service;

import com.mayuran19.datasourceconfig.domain.SomeTable;
import com.mayuran19.datasourceconfig.repository.SomeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
@Slf4j
public class SomeService {
    private final SomeRepository someRepository;

    public SomeService(SomeRepository someRepository) {
        this.someRepository = someRepository;
    }

    public void testWallet(){
        for(int i = 0; i < 100; i++){
            SomeTable someTable = new SomeTable();
            someTable.setId(new Random().nextLong());
            someTable.setSomeText("some text");
            someRepository.save(someTable);
        }

        var list = new ArrayList<SomeTable>();
        for(int i = 0; i < 100; i++){
            SomeTable someTable = new SomeTable();
            someTable.setId(new Random().nextLong());
            someTable.setSomeText("some text");
            list.add(someTable);
        }
        someRepository.saveAll(list);
    }
}
