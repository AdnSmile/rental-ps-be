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
    "no_wa": "string",
    "image": "base64" (optional)
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
        "image": "string",
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

<br />

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
    "status" : "T",
    "message" : "Successfully get list of menu",
    "page" : "number",
    "size" : "number",
    "data" : [
        {
            "menu_id" : "number",
            "menu_name" : "string",
            "menu_type" : "string" (value: Makanan / Minuman),
            "price" : "number",
            "stock" : "number",
            "menu" : "string",
            "created_at" : "date",
            "updated_at" : "date"
        },
        {
            "menu_id" : "number",
            "menu_name" : "string",
            "menu_type" : "string" (value: Makanan / Minuman),
            "price" : "number",
            "stock" : "number",
            "menu" : "string",
            "created_at" : "date",
            "updated_at" : "date"
        },
    ]
}
```

### Get menu list by Menu type

Request:
- Method : GET
- Endpoint : `/v1/api/menu/all`
- Params :
  - page : number (optional)
  - size : number (optional)
  - menu_type : "string" (value: Makanan / Minuman)

Response:
```
{
    "status" : "T",
    "message" : "Successfully get list of menu",
    "page" : "number",
    "size" : "number",
    "data" : [
        {
            "menu_id" : "number",
            "menu_name" : "string",
            "menu_type" : "string" (value: Makanan / Minuman),
            "price" : "number",
            "stock" : "number",
            "menu" : "string",
            "created_at" : "date",
            "updated_at" : "date"
        },
        {
            "menu_id" : "number",
            "menu_name" : "string",
            "menu_type" : "string" (value: Makanan / Minuman),
            "price" : "number",
            "stock" : "number",
            "menu" : "string",
            "created_at" : "date",
            "updated_at" : "date"
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
    "status" : "T",
    "message" : "Successfully get the menu with id 2",
    "data": {
        "menu_id" : "number",
        "menu_name" : "string",
        "menu_type" : "string" (value: Makanan / Minuman),
        "price" : "number",
        "stock" : "number",
        "menu" : "string",
        "created_at" : "date",
        "updated_at" : "date"
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
    "menu_name" : "string",
    "menu_type" : "string" (value: Makanan / Minuman),
    "price" : "number",
    "stock" : "number",
    "image" : "base64" (optional)
}
```

Response:
```
{
    "status": "T",
    "message": "Successfully create a menu",
    "data": {
        "menu_id" : "number",
        "menu_name" : "string",
        "menu_type" : "string" (value: Makanan / Minuman),
        "price" : "number",
        "stock": "number",
        "menu" : "string",
        "created_at" : "date",
        "updated_at" : "date"
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
        "menu" : "string",
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

<br />

## PS Room

### Get ps list

Request:
- Method : GET
- Endpoint : `/v1/api/ps/all`
- Params :
  - page: number (optional)
  - size: number (optional)

Response:
```
{
    "status" : "T",
    "message" : "Successfully get list of menu",
    "page" : "number",
    "size" : "number",
    "data" : [
        {
            "ps_id": "string",
            "ps_class": "string",
            "ps_type": "string",
            "status": "string",
            "hourly_rate": string,
            "created_at": "date",
            "updated_at": "date"
        },
        {
            "ps_id": "string",
            "ps_class": "string",
            "ps_type": "string",
            "status": "string",
            "hourly_rate": string,
            "created_at": "date",
            "updated_at": "date"
        }
    ]
}
```

<br />

### Get ps list by class

Request:
- Method : GET
- Endpoint : `/v1/api/ps/class`
- Params :
  - ps_class : "string" (vip/general)
  - page : number (optional)
  - size : number (optional)

Response:
```
{
    "status" : "T",
    "message" : "Successfully get list of menu",
    "page" : "number",
    "size" : "number",
    "data" : [
        {
            "ps_id": "string",
            "ps_class": "string",
            "ps_type": "string",
            "status": "string",
            "hourly_rate": string,
            "created_at": "date",
            "updated_at": "date"
        },
        {
            "ps_id": "string",
            "ps_class": "string",
            "ps_type": "string",
            "status": "string",
            "hourly_rate": string,
            "created_at": "date",
            "updated_at": "date"
        }
    ]
}
```

<br />

### Get ps list by class

Request:
- Method : GET
- Endpoint : `/v1/api/ps/type`
- Params :
  - ps_type : "string" (ps3/ps4/ps5)
  - page : number (optional)
  - size : number (optional)

Response:
```
{
    "status" : "T",
    "message" : "Successfully get list of menu",
    "page" : "number",
    "size" : "number",
    "data" : [
        {
            "ps_id": "string",
            "ps_class": "string",
            "ps_type": "string",
            "status": "string",
            "hourly_rate": string,
            "created_at": "date",
            "updated_at": "date"
        },
        {
            "ps_id": "string",
            "ps_class": "string",
            "ps_type": "string",
            "status": "string",
            "hourly_rate": string,
            "created_at": "date",
            "updated_at": "date"
        }
    ]
}
```

<br />

### Get PS room by id

Request:
- Method : DELETE
- Endpoint : `/v1/api/ps/{psId}`

Response:
```
{
    "status": "T",
    "message": "Successfully get list of playstation room by id VIP01",
    "data": {
        "ps_id": "string",
        "ps_class": "string",
        "ps_type": "string",
        "status": "string",
        "hourly_rate": string,
        "created_at": "date",
        "updated_at": "date"
    }
}
```

<br />

### Create PS room

Request:
- Method : POST
- Endpoint : `/v1/api/ps`
- Header :
  - token : value
- Body :
```
{
    "ps_id": "number",
    "ps_class": "string", (value: vip / general)
    "ps_type": "string",
    "status": "string",
    "hourly_rate": "number"
}
```

Response:
```
{
    "status": "T",
    "message": "Successfully create new playstation room",
    "data": {
        "ps_id": "string",
        "ps_class": "string",
        "ps_type": "string",
        "status": "string",
        "hourly_rate": "number",
        "created_at": "date",
        "updated_at": "date"
    }
}
```

<br />

### Update PS room

Request:
- Method : PUT
- Endpoint : `/v1/api/ps`
- Header :
  - token : value
- Body :
```
{
    "ps_class": "string", (value: vip / general)
    "ps_type": "string",
    "status": "string",
    "hourly_rate": "number"
}
```

Response:
```
{
    "status": "T",
    "message": "Successfully updated playstation room with id VIP02",
    "data": {
        "ps_id": "string",
        "ps_class": "string",
        "ps_type": "string",
        "status": "string",
        "hourly_rate": "number",
        "created_at": "date",
        "updated_at": "date"
    }
}
```

<br />

### DELETE PS room

Request:
- Method : DELETE
- Endpoint : `/v1/api/ps/{psId}`
- Header :
  - token : value

Response:
```
{
    "status": "T",
    "message": "Successfully deleted playstation room with id VIP10",
    "data": {}
}
```