package ro.democaip.repository;

import ro.democaip.domain.Task;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import java.util.List;

/**
 * Spring Data JPA repository for the Task entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("select task from Task task where task.assigner.login = ?#{principal.username}")
    List<Task> findByAssignerIsCurrentUser();

    @Query("select task from Task task where task.assignee.login = ?#{principal.username}")
    List<Task> findByAssigneeIsCurrentUser();

}
