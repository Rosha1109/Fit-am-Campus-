<#import "../layout.ftlh" as base>
<@base.layout>
    <h1>Registriere dich hier!</h1>
    <form action="/register" method="post">
        <input placeholder="Enter Username" name="username" type="text" required>
        <br>
        <input placeholder="Enter Password" name="password" type="password" required>
        <br>
        <input placeholder="Enter Email" name="email" type="email" required>
        <br>
        <button type="submit">Register</button>
    </form>
</@base.layout>
