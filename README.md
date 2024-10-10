# Rental PS API Documentation

## Authentication

### Register

Request:
- Method : POST
- Endpoint : `/v1/api/register`
- Body :
```
{
    "username": "string, unique",
    "password": "string",
    "email": "string, unique",
    "no_wa": "string"
}
```

Response:
```
{
    "status": "T",
    "message": "Successfully registered user",
    "data": {
        "username": "string, unique",
        "email": "string, unique",
        "no_wa": "string",
        "role": "string",
        "created_at": "date"
    }
}
```

### Login

Request:
- Method : POST
- Endpoint : `/v1/api/login`
- Body :
```
{
    "username": "string, unique",
    "password": "string",
}
```

Response:
```
{
    "status": "T",
    "message": "Successfully logged in",
    "data": {
        "user_id": "number",
        "username": "string, unique",
        "email": "string, unique",
        "no_wa": "string",
        "role": "string",
        "token": "string"
    }
}
```

## Menu

### Get menu list

Request:
- Method : GET
- Endpoint : `/v1/api/menu/all`
- Params :
  - page: number (optional)
  - size: number (optional)

Response:
```
{
    "status": "T",
    "message": "Successfully get list of menu",
    "data": [
        {
            "menu_id": "number",
            "menu_name": "string",
            "menu_type": "string" (value: Makanan / Minuman),
            "price": "number",
            "stock": "number",
            "created_at": "date",
            "updated_at": "date"
        },
        {
            "menu_id": "number",
            "menu_name": "string",
            "menu_type": "string" (value: Makanan / Minuman),
            "price": "number",
            "stock": "number",
            "created_at": "date",
            "updated_at": "date"
        },
    ]
}
```

### Get menu by id

Request:
- Method : GET
- Endpoint : `/v1/api/menu/{menuId}`
- Header :
  - token : value

Response:
```
{
    "status": "T",
    "message": "Successfully get the menu with id 2",
    "data": {
        "menu_id": "number",
        "menu_name": "string",
        "menu_type": "string" (value: Makanan / Minuman),
        "price": "number",
        "stock": "number",
        "created_at": "date",
        "updated_at": "date"
    }
}
```

### Create menu

Request:
- Method : POST
- Endpoint : `/v1/api/menu`
- Header :
  - token : value
- Body :
```
{
    "menu_name": "string",
    "menu_type": "string" (value: Makanan / Minuman),
    "price": "number",
    "stock": "number"
}
```

Response:
```
{
    "status": "T",
    "message": "Successfully create a menu",
    "data": {
        "menu_id": "number",
        "menu_name": "string",
        "menu_type": "string" (value: Makanan / Minuman),
        "price": "number",
        "stock": "number",
        "created_at": "date",
        "updated_at": "date"
    }
}
```

### Update menu

Request:
- Method : PUT
- Endpoint : `/v1/api/menu/{menuId}`
- Header :
  - token : value
- Body :
```
{
    "menu_name": "string",
    "menu_type": "string" (value: Makanan / Minuman),
    "price": "number",
    "stock": "number"
}
```

Response:
```
{
    "status": "T",
    "message": "Successfully update a menu with id 1",
    "data": {
        "menu_id": "number",
        "menu_name": "string",
        "menu_type": "string" (value: Makanan / Minuman),
        "price": "number",
        "stock": "number",
        "created_at": "date",
        "updated_at": "date"
    }
}
```

### DELETE menu 

Request:
- Method : DELETE
- Endpoint : `/v1/api/menu/{menuId}`
- Header :
  - token : value

Response:
```
{
    "status": "T",
    "message": "Successfully delete a menu with id 4",
    "data": {}
}
```