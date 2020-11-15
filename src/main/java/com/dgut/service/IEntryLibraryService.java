package com.dgut.service;

import com.dgut.domain.EntryLibrary;

import java.util.List;

public interface IEntryLibraryService {

    Integer insert(EntryLibrary entryLibrary);

    List<EntryLibrary> findByName(String drugName);
    
    EntryLibrary findById(Integer id);

	EntryLibrary findMax();

	Integer updateStatus(Integer id);

	List<EntryLibrary> findAll();
}
