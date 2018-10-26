1. Is v1 ok?
2. is v2 ok?

3.
Request:
Refactor code,
introduce method
```
boolean isOpen()
```
in Group and reuse it in UserRegistration by replicing the line
```
if (group.getStudents().size() >= group.getLimit()) {
    ...
}
```
