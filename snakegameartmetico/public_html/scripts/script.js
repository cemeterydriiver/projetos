let canvas = document.getElementById("snake"); // criar elemento que irá rodar o jogo
let context = canvas.getContext("2d");
let box = 32;
var r = Math.floor(Math.random() * 10 + 2);
var a = Math.floor(Math.random() * 10 + 2);
var n = 1;
var a1 = a + r;
var a2 = a1 + r;
var a3 = a2 + r;
var a4 = a3 + r;
var a5 = a4 + r;
var a6 = a5 + r;
let snake = []; // criar cobrinha como lista, já que ela vai ser uma série de coordenadas, que quando pintadas, criam os quadradinhos
snake[0] = {
    x: 8 * box,
    y: 8 * box
};
function sub(){
    var valor = document.getElementById('dados').valor.value;
  if (valor != 0){

  if(valor == r){
      window.location.href = "https://snakegame2c.000webhostapp.com/";
      alert("o valor correto é " + r);
  }
  else{
      window.location.href = "https://www.youtube.com/missaoaprender";
      alert("o valor correto é " + r);
    }
  }
}
let direction = "right";

let food = {
    x: Math.floor(Math.random() * 15 + 1) * box,
    y: Math.floor(Math.random() * 15 + 1) * box
}

function createBG () {
    context.fillStyle = "black";
    context.fillRect(0,0,16 * box, 16 * box); // desenha o retângulo usando x e y e a largura e altura setadas
}

function createSnake() {
    for (i = 0; i < snake.length; i++) {
        context.fillStyle = "yellow";
        context.fillRect(snake[i].x, snake[i].y, box, box);
    }
}

function createFood() {
    context.fillStyle = "#F00A0A";
    context.fillRect(food.x, food.y, box, box);
}

document.addEventListener('keydown', update); // quando um evento acontece, detecta e chama uma função

function update(event) {
    if (event.keyCode == 37 && direction != 'right') direction = 'left';
    if (event.keyCode == 38 && direction != 'down') direction = 'up';
    if (event.keyCode == 39 && direction != 'left') direction = 'right';
    if (event.keyCode == 40 && direction != 'up') direction = 'down';
}

function startGame() {
    if (snake[0].x > 15 * box && direction == "right") {
    direction = "down";
    snake[0].x = 480;}
    if (snake[0].x < 0 && direction == 'left'){
    direction = "up";
    snake[0].x = 0;}
    if (snake[0].y > 15 * box && direction == "down"){
    direction = "left";
    snake[0].y = 480;}
    if (snake[0].y < 0 && direction == 'up'){
    direction = "right";
    snake[0].y = 0;}

    for (i = 1; i < snake.length; i++) {
        if (snake[0].x == snake[i].x && snake[0].y == snake[i].y) {
            clearInterval(game);
            alert("você perdeu, diga a razão da P.A para continuar")
            document.getElementById('over').style.opacity= "1";
        }
    }

    createBG();
    createSnake();
    createFood();

    let snakeX = snake[0].x;
    let snakeY = snake[0].y;

    if( direction == "right") snakeX += box;
    if (direction == "left") snakeX -= box;
    if (direction == "up") snakeY -= box;
    if (direction == "down") snakeY += box;

    if (snakeX != food.x || snakeY != food.y) {
        snake.pop(); // pop tira o último elemento da lista
            
    } else {    
switch(n){
    case 1:
        const a1n = document.getElementById("a1");
        n++;
        a1n.innerHTML = a1;
        a1n.style.color = '#3FBDF4';
        break;
    case 2:
        const a6n = document.getElementById("a6");
        n++;
        a6n.innerHTML = a6;
        a6n.style.color = '#3FBDF4';
        break;
    case 3:
        const a3n = document.getElementById("a3");
        n++;
        a3n.innerHTML = a3;
        a3n.style.color = '#3FBDF4';
        break;
    case 4:
        const a4n = document.getElementById("a4");
        n++;
        a4n.innerHTML = a4;
        a4n.style.color = '#3FBDF4';
        break;
    case 5:
        const a5n = document.getElementById("a5");
        n++;
        a5n.innerHTML = a5;
        a5n.style.color = '#3FBDF4';
        break;
    case 6:
        const a2n = document.getElementById("a2");
        n++;
        a2n.innerHTML = a2;
        a2n.style.color = '#3FBDF4';
        break;
}
        food.x = Math.floor(Math.random() * 15 + 1) * box;
        food.y = Math.floor(Math.random() * 15 + 1) * box;
    }

    let newHead = {
        x: snakeX,
        y: snakeY
    };

    snake.unshift(newHead); // método unshift adiciona o primeiro quadrado da cobrinha
}
let game = setInterval(startGame, 140);