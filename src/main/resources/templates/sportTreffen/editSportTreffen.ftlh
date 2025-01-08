<#import "../layout.ftlh" as base>
<@base.layout>

   <form action="/sportTreffen/${sportTreffen.id}" method="post">
      <input placeholder="${sportTreffen.name}" name="name" type="text">
      <input value="${sportTreffen.ort}" name="ort" type="text">
      <input value="${sportTreffen.datum}" name="datum" type="text">
      <input value="${sportTreffen.sportArt}" name="sportart" type="text">
      <input value="${sportTreffen.description}" name="beschreibung" type="text">
      <input type="hidden" name="_method" value="PUT">
      <button type="submit">Update Sporttreffen</button>
   </form>

</@base.layout>
