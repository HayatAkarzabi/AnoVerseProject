<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Chat en ligne</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; background-color: #f4f4f4; }
        #chat-container { width: 400px; margin: 20px auto; background: white; padding: 10px; border-radius: 8px; box-shadow: 0px 0px 10px gray; }
        #messages { border: 1px solid #ddd; height: 300px; overflow-y: auto; padding: 5px; text-align: left; }
        .message { background: #e1ffc7; padding: 5px; margin: 5px; border-radius: 5px; max-width: 70%; }
        .message.me { background: #c7dcff; text-align: right; margin-left: auto; }
        input, button { padding: 10px; margin-top: 10px; width: calc(100% - 22px); }
    </style>
    <script>
        var pseudo = prompt("Entrez votre pseudo:");
        var ws = new WebSocket("ws://localhost:8080/TON_PROJET/chat");

        ws.onmessage = function(event) {
            var chatBox = document.getElementById("messages");
            var messageElement = document.createElement("div");
            messageElement.classList.add("message");

            if (event.data.startsWith("IMG:")) {
                var img = document.createElement("img");
                img.src = event.data.substring(4);
                img.style.maxWidth = "100px";
                messageElement.appendChild(img);
            } else {
                messageElement.innerText = event.data;
            }

            chatBox.appendChild(messageElement);
            chatBox.scrollTop = chatBox.scrollHeight;
        };

        function sendMessage() {
            var input = document.getElementById("message");
            var message = input.value.trim();
            if (message !== "") {
                ws.send(pseudo + " : " + message);
                displayMessage("Moi : " + message, "me");
                input.value = "";
            }
        }

        function sendImage(event) {
            var file = event.target.files[0];
            if (file) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    var dataURL = e.target.result;
                    ws.send("IMG:" + dataURL);
                    displayMessage("Moi : IMG", "me");
                };
                reader.readAsDataURL(file);
            }
        }

        function displayMessage(content, type) {
            var chatBox = document.getElementById("messages");
            var messageElement = document.createElement("div");
            messageElement.classList.add("message", type);

            if (content.startsWith("IMG:")) {
                var img = document.createElement("img");
                img.src = content.substring(4);
                img.style.maxWidth = "100px";
                messageElement.appendChild(img);
            } else {
                messageElement.innerText = content;
            }

            chatBox.appendChild(messageElement);
            chatBox.scrollTop = chatBox.scrollHeight;
        }
    </script>
</head>
<body>
<div id="chat-container">
    <h2>Chat en ligne</h2>
    <div id="messages"></div>
    <input type="text" id="message" placeholder="Écrire un message...">
    <button onclick="sendMessage()">Envoyer</button>
    <br>
    <input type="file" accept="image/*" onchange="sendImage(event)">
</div>
</body>
</html>
