## Run

```
mvn spring-boot:run
```

# Open graphiql
http://localhost:8080/

```
{
  info {
    serverTime
    props(key: "PID") {
      value
    }
  }
  products(id:3){
    store{
      name
    }
  }
  stores{
    products{
      price
    }
  }
}

```