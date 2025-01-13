<#import "../layout.ftlh" as base>
<@base.layout>
    <form action="/sportTreffen/${kommentar.sportTreffen.id}/kommentare/${kommentar.kommentarId}" method="post">
        <label>Kommentar test</label><br>
        <input type="text" value="${kommentar.content}" name="content"><br>
        <input type="hidden" name="_method" value="PUT"/>
        <button type="submit">Update Kommentar</button>
    </form>

    ${kommentar.content}
    <form action="/sportTreffen/${kommentar.sportTreffen.id}/kommentare/${kommentar.kommentarId}" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
        <button>Delete</button>
    </form>
</@base.layout>
#9061