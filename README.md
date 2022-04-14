# orderfood
Réalisation d'un site de commandes de fast-food. Ce site affichera juste les items et la partie administrative, sans tenir compte des commandes et des comptes utilisateurs.  
Le Back-end a été réalisé en SpringBoot  

## Documentation de l'API

### Requêtes GET
* Url pour récupérer toutes les catégories : _/categories_
* Url pour récupérer une catégorie particulière : _/category/`id`_, `id` étant l'id de la catégorie recherchée
* Url pour récupérer tous les items : _/items/all_
* Url pour récupérer tous les items d'une catégorie : _/items/`id`_, `id` étant la catégorie des items

### Requêtes POST
Pour chacune de ses requêtes, l'objet à passer est un tableau

* Url pour ajouter une ou plusieurs catégorie : _/add/categories_
* Url pour ajouter un ou plusieurs items : _/add/items/`id`_, `id` étant l'id de la catégorie de l'item

### Requêtes PUT
* Url pour mettre à jour une catégorie : _/update/category/`id`?name=`name`_, `id` étant l'id de la catégorie à modifier
  * `name` : facultatif
* Url pour mettre à jour un item : _/update/item/`id`?name=`name`&description=`description`&price=`price`&id\_category=`id`_, l'id après _/item/_ représente l'id de la catégorie de l'item à mettre à jour
  * `name` : facultatif
  * `description` : facultatif
  * `price` : facultatif
  * `id_category` : obligatoire

### Requêtes DELETE
* Url pour supprimer une catégorie : _/delete/category/`id`_, `id` étant l'id de la catégorie à supprimer. Cela supprime automatiquement tous les items qui y étaient associés.
* Url pour supprimer un item : _/delete/item/`id`_, `id` étant l'id de l'item à supprimer
