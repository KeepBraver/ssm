package com.dgut.service;

import java.util.List;

import com.dgut.domain.DrugLibrary;

public interface IDrugLibraryService {

	List<DrugLibrary> findAll();

	Integer add(DrugLibrary drugLibrary);

}
