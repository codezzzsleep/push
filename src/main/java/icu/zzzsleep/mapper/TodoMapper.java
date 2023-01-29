package icu.zzzsleep.mapper;

import icu.zzzsleep.project.Todo;

import java.util.List;

public interface TodoMapper {
    List<Todo> selectAll(int userid);
}
