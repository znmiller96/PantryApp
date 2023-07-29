# Pantry Api

# Docker

### Postgres
connect to db:`psql -U znmiller`

list databases: `\l`

connect to db: `\c database`

list tables: `\dt`

# Dev Notes
- when creating a one to one connection need to make sure to convert to DTO object because if you convert to json will have infinite loop from connecting objects

### Postman

TODO add link to postman collection

These code snippets belong in pre-request script

`pm.environment.set('variableName', 'value');` this is how to set variables in

```
var moment = require('moment')
pm.environment.set('currentDate', moment().format(("YYYY-MM-DD")));
pm.environment.set('weekFurtureDate', moment().subtract(-7,'day').format(("YYYY-MM-DD")))
pm.environment.set('weekPastDate', moment().subtract(7,'day').format(("YYYY-MM-DD")))
```
date variables with varying dates


# Spring Boot Annotations
`@AllArgsConstructor` generates a constructor for dependency injection

`@JsonFormat(pattern="yyyy-MM-dd")` sets format the date will be set at when converted to json sting

`@JsonInclude(JsonInclude.Include.NON_NULL)` allows json object to deserialize objects with null values

`@JsonIgnoreProperties(ignoreUnknown = true)` will ignore all unknown variables in json (all variables in json and not in class)

`@JsonDeserialize(builder = PantryDto.Builder.class)` sets the builder class to handle json object deserialization

`@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")` sets the name of method that creates class and prefix of set methods in builder class for deserialization

`@Id` assign variable as primary key in table

```
@SequenceGenerator(
name = "pantry_id_sequence",
sequenceName = "pantry_id_sequence",
allocationSize = 1,
initialValue = 1000
)
@GeneratedValue(
strategy = GenerationType.SEQUENCE,
generator = "pantry_id_sequence"
)
```
determines the pattern of number generation
- `name`, `sequenceName`, and `generator` should match (maybe? this makes it easier for me to follow) and should be unique for tables that are not a one to one connection (pantry and connected dao classes)
- `allocationSize` sets increment value
- `initialValue` is starting value
- `strategy` logic of generating values
- **need to read more about** did a good bit of copying