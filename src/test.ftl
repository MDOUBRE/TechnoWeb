<html>
  <head>
    <title>The List</title>
    <link rel="stylesheet" href="CSS/reset.css"/>
    <link rel="stylesheet" href="CSS/site.css"/>
  </head>
  <body class="corps">
    <#list listes as liste>
      <h2>${liste.titre}</h2>
      ${liste.description} <br/>
      ${liste.dateCreation?string.short}
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
      <form class="form-inline" method="POST" action="/form">
        <div class="form-group" style="display: none">
          <label for="midelement">oui</label>
          <input type="text"
                class="form-control"
                id="midelement"
                name="midelement"
                placeholder="id"
                value="${liste.id}">
        </div>
        <div class="form-group" style="display: none">
          <label for="name">oui</label>
          <input type="text"
                class="form-control"
                id="name"
                name="name"
                placeholder="id"
                value="${liste.name}">
        </div>
        <button type="submit" class="btn btn-default">Modifier Liste</button>
      </form>
      <#list elements as element>
        <#if element.idListe == liste.id>
          <#if element.statut == "Fait">
            <h3>- <strike>${element.titre}</strike></h3>
          </#if>
          <#if element.statut == "A faire">
            <h3>- ${element.titre}</h3>
          </#if>
          ${element.description} <br/>
          ${element.dateCreation?string.short} <br/>
          <#if element.statut == "A faire">
            <b>${element.statut}</b>
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
              <button type="submit" class="btn btn-default">Fait</button>
            </form>
          </#if>
          <form class="form-inline" method="POST" action="/form">
            <div class="form-group" style="display: none">
              <label for="midelement">oui</label>
              <input type="text"
                    class="form-control"
                    id="midelement"
                    name="midelement"
                    placeholder="id"
                    value="${element.id}">
            </div>
            <div class="form-group" style="display: none">
              <label for="name">oui</label>
              <input type="text"
                    class="form-control"
                    id="name"
                    name="name"
                    placeholder="id"
                    value="${element.name}">
            </div>
            <button type="submit" class="btn btn-default">Modifier Element</button>
          </form>
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
        </#if>
      </#list>
      <br/>
      <a>Rajouter element</a>
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
        <button type="submit" class="btn btn-default">Nouvel element</button>
      </form>
      <br/>
    </#list>
    <br/>
    <a>Rajouter liste</a>
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
      <button type="submit" class="btn btn-default">Nouvelle liste</button>
    </form>
  </body>
</html>
