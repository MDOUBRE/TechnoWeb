<html>
  <head> 
    <title>Welcome!</title>
    <link rel="stylesheet" href="CSS/reset.css"/>
    <link rel="stylesheet" href="CSS/site.css"/>
  </head>
  <body class="corps">
    <#list listes as liste>
      <h2>${liste.titre}</h2>
      id :  ${liste.id} <br/>
      description : ${liste.description} <br/>
      date creation : ${liste.dateCreation?string.short} <br/>
      <br/>
      <form class="form-inline" method="POST" action="/dliste">
        <div class="form-group" style="display: none">
          <label for="didliste">oui</label>
          <input type="text"
                class="form-control"
                id="didliste"
                name="didliste"
                placeholder="id"
                value="${liste.id}">
        </div>
        <button type="submit" class="btn btn-default">delete liste</button>
      </form>
      <br/>
      <#list elements as element>
        <#if element.idListe == liste.id>
          ${element.id}: ${element.titre} <br/>
          ${element.description} <br/>
          ${element.dateCreation?string.short} <br/>          
          statut : ${element.statut} <br/>
          <form class="form-inline" method="POST" action="/delement">
            <div class="form-group" style="display: none">
              <label for="didelement">oui</label>
              <input type="text"
                    class="form-control"
                    id="didelement"
                    name="didelement"
                    placeholder="id"
                    value="${element.id}">
            </div>
            <button type="submit" class="btn btn-default">delete element</button>
          </form>
          <#if element.statut == 0>
            <form class="form-inline" method="POST" action="/faitelement">
              <div class="form-group" style="display: none">
                <label for="fidelement">oui</label>
                <input type="text"
                      class="form-control"
                      id="fidelement"
                      name="fidelement"
                      placeholder="id"
                      value="${element.id}">
              </div>
              <button type="submit" class="btn btn-default">faitelement</button>
            </form>
          </#if>
          <br>
          <br/>
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
