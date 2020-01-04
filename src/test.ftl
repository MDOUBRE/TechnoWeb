<html>
  <head>
    <title>Welcome!</title>
  </head>
  <body>
    <#list listes as liste>
      <h2>${liste.titre}</h2>
      id :  ${liste.id} <br/>
      description : ${liste.description} <br/>
      date creation : ${liste.dateCreation?string.short} <br/>
      <br/>
      <#list elements as element>
        <#if element.idListe == liste.id>
          ${element.id}: ${element.titre} <br/>
          ${element.description} <br/>
          ${element.dateCreation?string.short} <br/>
        </#if>
      </#list>
      <br/>
      <a>rajouter element</a>
      <form class="form-inline" method="POST" action="/relement">
        <div class="form-group">
          <label for="titre">Titre</label>
          <input type="text"
                class="form-control"
                id="titre"
                name="titre"
                placeholder="LeTitre">
        </div>
        <div class="form-group">
          <label for="description">Description</label>
          <input type="text"
                class="form-control"
                id="description"
                name="description"
                placeholder="Description de l'element">
        </div>
        <button type="submit" class="btn btn-default">creer element</button>
      </form>
      <br/>
    </#list>
    <br/>
    <a>rajouter liste</a>
    <form class="form-inline" method="POST" action="/rliste">
      <div class="form-group">
        <label for="titre">Titre</label>
        <input type="text"
        
              class="form-control"
              id="titre"
              name="titre"
              placeholder="LeTitre">
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <input type="text"
              class="form-control"
              id="description"
              name="description"
              placeholder="Description de la liste">
      </div>
      <button type="submit" class="btn btn-default">creer liste</button>
    </form>
  </body>
</html>
