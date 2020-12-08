package com.amdocs.optima.searchEngine.repo;

import org.springframework.data.repository.CrudRepository;

import com.amdocs.optima.searchEngine.model.webmanager.QueryLog;

public interface LogRepository extends CrudRepository<QueryLog, String> {

}
