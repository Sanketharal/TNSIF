
const diceFaces = {
    1: [[0, 0, 0], [0, 1, 0], [0, 0, 0]],
    2: [[1, 0, 0], [0, 0, 0], [0, 0, 1]],
    3: [[1, 0, 0], [0, 1, 0], [0, 0, 1]],
    4: [[1, 0, 1], [0, 0, 0], [1, 0, 1]],
    5: [[1, 0, 1], [0, 1, 0], [1, 0, 1]],
    6: [[1, 0, 1], [1, 0, 1], [1, 0, 1]]
};


// this create dice face dots
function createDiceFace(diceElement, number) { 
    diceElement.innerHTML = "";
    const face = diceFaces[number];

    face.forEach(row => {
        row.forEach(dot => {
            const div = document.createElement("div");
            if (dot) div.classList.add("dot");
            diceElement.appendChild(div);
        });
    });
}

document.getElementById("rollButton").addEventListener("click", function () {
    let diceValues = [];
    let diceElements = document.querySelectorAll(".dice");

    // Add shaking animation
    diceElements.forEach(dice => {
        dice.style.animation = "shake 0.5s";
    });

    setTimeout(() => {
        // Roll dice (generate random numbers from 1 to 6)
        for (let i = 0; i < 4; i++) {
            let roll = Math.floor(Math.random() * 6) + 1;
            diceValues.push(roll);
            createDiceFace(diceElements[i], roll); // Show dots
            diceElements[i].classList.remove("winner");
        }

        // max value and determine winner
        let maxRoll = Math.max(...diceValues);
        let winners = [];

        diceValues.forEach((value, index) => {
            if (value === maxRoll) {
                winners.push(`Player ${index + 1}`);
                diceElements[index].classList.add("winner");
            }
        });

        // Check for tie and ask to re-roll
        if (winners.length > 1) {
            document.getElementById("winnerText").textContent = `It's a tie in ${winners.join(" & ")} must roll again!`;
        } else {
            document.getElementById("winnerText").textContent = `${winners[0]} is the winner!`;
        }

        // this help us tl Remove animation after roll
        setTimeout(() => {
            diceElements.forEach(dice => {
                dice.style.animation = "";
            });
        }, 500);
        
    }, 500);
});
