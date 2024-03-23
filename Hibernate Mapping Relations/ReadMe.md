Hibernate is a popular object-relational mapping (ORM) framework for Java applications. It provides a bridge between the object-oriented domain model of an application and the relational database that persists the application's data. One of the core features of Hibernate is its ability to map Java classes to database tables and Java data types to SQL data types, facilitating the management of database operations and data persistence.<br>
When discussing Hibernate mapping relations, we're essentially talking about how Hibernate maps relationships between entities (Java objects) based on the relationships between tables in a database. These relationships are usually one-to-one, one-to-many, many-to-one, and many-to-many, reflecting the cardinality between the tables/entities.<br>

### 1. One-to-One Relationship
A one-to-one relationship between two entities means that one row in a table A is related to exactly one row in table B and vice versa. It is a way to map the relationship between two entities (Java classes) that are related to each other in a one-to-one fashion. In a database schema, this is often represented by having a foreign key in one table that references the primary key of another table, where each primary key value is associated with precisely one (or zero) foreign key in the related table. This type of relationship is common for scenarios where an entity should or can only have a single instance of another entity. This is typically represented in Hibernate using the `@OneToOne` annotation. 

For example, if you have an `Employee` entity and an `EmployeeDetails` entity, where each employee has exactly one set of details, you could map this relationship on the `Employee` class like so:
```java
@OneToOne(mappedBy = "employee")
private EmployeeDetails employeeDetails;
```
And in the `EmployeeDetails` class, you would have a reference back to the `Employee`:
```java
@OneToOne
@JoinColumn(name = "employee_id")
private Employee employee;
```

### 2. One-to-Many and Many-to-One Relationships
A one-to-many relationship means that a row in table A can be related to many rows in table B. Conversely, a many-to-one relationship means that many rows in table B can be related to one row in table A. In a @OneToMany relationship, you have two entities where one entity (let's call it the "parent") can be associated with multiple instances of another entity (let's call these the "children"). This is a common scenario in data modeling. For instance, in a database schema for a school, a single Teacher entity might be associated with multiple Student entities, indicating that a teacher can have many students. In Hibernate, `@OneToMany` and `@ManyToOne` annotations are used to map these relationships.

For instance, if one `Department` can have many `Employees`, but each `Employee` belongs to only one `Department`, you would have:
```java
// In Department class
@OneToMany(mappedBy = "department")
private Set<Employee> employees = new HashSet<>();

// In Employee class
@ManyToOne
@JoinColumn(name = "department_id")
private Department department;
```

### 3. Many-to-Many Relationship
A many-to-many relationship between two entities means that rows in table A can relate to multiple rows in table B and vice versa. A many-to-many relationship exists between two entities when each entity can be associated with multiple instances of the other entity. This kind of relationship requires a third table, known as a join table, to track the associations between the two entities. Hibernate maps this relationship using the `@ManyToMany` annotation.

For example, if you have an `Author` entity and a `Book` entity, where authors can write many books and books can have many authors, you might map it like this:
```java
// In Author class
@ManyToMany(mappedBy = "authors")
private Set<Book> books = new HashSet<>();

// In Book class
@ManyToMany
@JoinTable(
  name = "author_book", 
  joinColumns = @JoinColumn(name = "book_id"), 
  inverseJoinColumns = @JoinColumn(name = "author_id")
)
private Set<Author> authors = new HashSet<>();
```
