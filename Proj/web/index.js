function mudarImg() {
    let white = document.querySelector('.white')
    let black = document.querySelector('.black')



    if (white.style.display == 'none') {
        white.style.display = 'flex'
        black.style.display = 'none'
    }else {
        white.style.display = 'none'
        black.style.display = 'flex'
    }
   
}