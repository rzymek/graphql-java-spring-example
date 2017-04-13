## Start local docker instance
`docker run -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=PASSWORD -p 5432:5432 -d --name graphql-spring-postgres postgres`

## Scripts to remove local docker instance (if needed)
`docker stop graphql-spring-postgres && docker rm graphql-spring-postgres`

## Store and Product scripts
```
INSERT INTO public.store(
 	id, address, name, owner)
 	VALUES (1, 'Hackensack', 'Test', 1);
 	
INSERT INTO public.product(
    id, description, name, price, score, store_id)
    VALUES (1, 'test product description', 'test product name', 10.99, 4.5, 1);
```

## Postman commands
* https://www.getpostman.com/collections/804da6d5e6ff50b79dfa

## Problem with @Autowired in ProductRetriever and StoreRetriever 
### After the project has started add the following back to and restart the project
* ProductRetrieve.java
```
@Autowired
ProductMapper productMapper;
```
* StoreRetrieve.java
```
@Autowired
StoreMapper storeMapper;
```
