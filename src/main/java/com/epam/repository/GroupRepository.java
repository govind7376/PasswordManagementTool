package com.epam.repository;
import com.epam.entity.Group;
import org.springframework.data.repository.CrudRepository;
public interface GroupRepository extends CrudRepository<Group, Integer> {
  Group findByGroupName(String groupName);
    boolean existsByGroupName(String  groupName);
}
