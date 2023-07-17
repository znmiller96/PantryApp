# Pantry Api

# Docker

### Postgres
connect to db:`psql -U znmiller`

list databases: `\l`

connect to db: `\c database`

list tables: `\dt`

# Dev Notes
- when creating a one to one connection need to make sure to convert to DTO object because if you convert to json will have infinite loop from connecting objects