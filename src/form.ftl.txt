<html>
  <head> 
    <title>Formulaire!</title>
    <link rel="stylesheet" href="CSS/reset.css"/>
    <link rel="stylesheet" href="CSS/site.css"/>
  </head>
  <body class="corps">
    <form>
      <div class="form-group" style="display: none">
        <label for="didliste">oui</label>
        <input type="text"
          class="form-control"
          id="didliste"
          name="didliste"
          placeholder="id"
          value="${liste.id}">
      </div>
      <div class="form-group" style="display: none">
        <label for="didliste">oui</label>
        <input type="text"
          class="form-control"
          id="didliste"
          name="didliste"
          placeholder="id"
          value="${liste.id}">
      </div>
      <button type="submit" class="btn btn-default">Modifier</button>
    </form>
  </body>
</html>
