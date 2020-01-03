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
  </#list>
</body>
</html>
