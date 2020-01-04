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
        ${element.dateCreation?string.short} <br/><br/>
      </#if>
    </#list>
    <br/>
    <a>rajouter element</a>
    <form class="form-inline" method="POST" action="/relement">
      <div class="form-group" style="display: none">
        <label for="eliste">oui</label>
        <input type="text"
               class="form-control"
               id="eliste"
               name="eliste"
               placeholder="LeTitre"
               value="${liste.id}">
      </div>
      <div class="form-group">
        <label for="etitre">Titre</label>
        <input type="text"
               class="form-control"
               id="etitre"
               name="etitre"
               placeholder="LeTitre">
      </div>
      <div class="form-group">
        <label for="edescription">Description</label>
        <input type="text"
               class="form-control"
               id="edescription"
               name="edescription"
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
        <label for="ltitre">Titre</label>
        <input type="text"
              class="form-control"
              id="ltitre"
              name="ltitre"
              placeholder="LeTitre">
      </div>
      <div class="form-group">
        <label for="ldescription">Description</label>
        <input type="text"
              class="form-control"
              id="ldescription"
              name="ldescription"
              placeholder="Description de la liste">
      </div>
      <button type="submit" class="btn btn-default">creer liste</button>
    </form>
  </body>
</html>
