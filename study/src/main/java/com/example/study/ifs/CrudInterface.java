package com.example.study.ifs;

import com.example.study.model.network.Header;

public interface CrudInterface<Req, Res> {
    // API 의  CRUD 에서 반드시 재정의해야하는 것

    Header<Res> create(Header<Req> request);        // todo request object 추가. 나중에 추가될것.

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header<Res> delete(Long id);


}
