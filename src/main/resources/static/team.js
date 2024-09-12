document.addEventListener('DOMContentLoaded', () => {
    const buttons = document.querySelectorAll('.details-btn');

    buttons.forEach(button => {
        button.addEventListener('click', () => {
            const infoBox = button.nextElementSibling;
            const isOpen = infoBox.classList.contains('open');

            // Close all info boxes
            document.querySelectorAll('.info-box').forEach(box => {
                box.classList.remove('open');
            });

            // If it was not open, open the clicked one
            if (!isOpen) {
                infoBox.classList.add('open');
            }
        });
    });
});
