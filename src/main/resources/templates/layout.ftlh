<#macro layout>
    <!doctype html>
    <html lang="en">
    <head>
        <title>FitAmCampus</title>
    </head>
    <body>
    <header>
       Sporttreffen
    </header>
    <hr>
    <main>
        <#nested>
    </main>
    <hr>
    <footer>
        <a href="/#">Imprint</a>
        <br>
        <a href="/#">About Us</a>
        <br>
        <a href="/logout">Logout</a>
        <br>
        <a href="/h2-console">console</a>
    </footer>
    </body>
    </html>
</#macro>