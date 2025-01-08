<#import "../layout.ftlh" as base>
<@base.layout>
    <ul>
        <#list sportTreffen as sportTreffen>
            <li><a href="/sportTreffen/${sportTreffen.id}/kommentare">${sportTreffen.name}</a></li>
        </#list>
    </ul>
    <form action="/sportTreffen" method="post">
        <input placeholder="NameXYZ" name="name" type="text">
        <input placeholder="OrtXYZ" name="ort" type="text">
        <input placeholder="Datum" name="datum" type="text">
        <input placeholder="sportartXYZ" name="sportArt" type="text">
        <input placeholder="BeschreibungXYZ" name="description" type="text">
<br>
        <button type="submit"> Create Sporttreffen</button>
    </form>
</@base.layout>
