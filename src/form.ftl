<html>
  <head>
    <title>Formulaire!</title>
    <link rel="stylesheet" href="CSS/reset.css"/>
    <link rel="stylesheet" href="CSS/site.css"/>
  </head>
  <body class="corps">
    <form class="form-inline" method="POST" action="/modif${element.name}">
      <div class="form-group">
        <label for="telement">Titre</label>
        <input type="text"
          class="form-control"
          id="telement"
          name="telement"
          placeholder="titre"
          value="${element.titre}">
      </div>
      <div class="form-group">
        <label for="delement">Description</label>
        <input type="text"
          class="form-control"
          id="delement"
          name="delement"
          placeholder="description"
          value="${element.description}">
      </div>
      <div class="form-group" style="display: none">
        <label for="idelement">oui</label>
        <input type="text"
              class="form-control"
              id="idelement"
              name="idelement"
              placeholder="id"
              value="${element.id}">
      </div>
      <div class="form-group" style="display: none">
        <label for="name">oui</label>
        <input type="text"
              class="form-control"
              id="name"
              name="name"
              value="${element.name}">
      </div>
      <button type="submit" class="btn btn-default">Modifier</button>
    </form>
  </body>
</html>
