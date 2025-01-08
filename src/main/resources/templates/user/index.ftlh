<#import "../layout.ftlh" as base>
<@base.layout>
<form method="post" action="/register">
    <label for="email">Email:</label>
    <input type="text" id="email" name="username">
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <button type="submit">Login</button>
    <a href="http://localhost:8080/login">Schon regristriert?</a>
</form>
</@base.layout>
