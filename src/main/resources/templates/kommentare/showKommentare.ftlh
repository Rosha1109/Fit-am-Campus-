<#import "../layout.ftlh" as base>
<@base.layout>
    <a href="/sportTreffen"><-</a>
    <h2>SportTreffen Details</h2>
    <p><strong>Name:</strong> ${sportTreffen.name}</p>
    <p><strong>Datum:</strong> ${sportTreffen.datum}</p>
    <p><strong>Beschreibung:</strong> ${sportTreffen.description}</p>
    <p><strong>Ort:</strong> ${sportTreffen.ort}</p>
    <p><strong>Sportart:</strong> ${sportTreffen.sportArt}</p>

    <b>Wetter: ${weather.temperature} Lage: ${weather.weatherCode}</b>
    <br>


    <button><a href="/sportTreffen/${sportTreffen.id}/edit"> Update SportTreffen </a></button>
    <ul>
        <#list kommentare as kommentar>
            <li><a href="/sportTreffen/${kommentar.sportTreffen.id}/kommentare/${kommentar.kommentarId}">${kommentar.content}</a></li>
        </#list>
    </ul>
    <form action="/sportTreffen/${sportTreffen.id}/kommentare" method="post">
    <input placeholder="KommentarXYZ" name="content" type="text">
        <button type="submit">Create Kommentar</button>
    </form>

    <form action="/sportTreffen/${sportTreffen.id}" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
        <button>Delete Sporttreffen</button>
    </form>

        <iframe src="${mapUrl}" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>


</@base.layout>
