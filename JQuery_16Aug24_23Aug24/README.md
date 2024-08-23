JQuery
------------------------------------------------------------------------------------------------------

    is a javascript library.

    $("css-selector") returns a dom element that matches the selector 

    $(() => {}) the passed callback is executed once the page is loaded 

    $(javascriptObject) returns the object with additional fucntions of JQuery api

    Event Handling
    ---------------------------

        document.querySelector("#p1").addEventListener('click',()=>{})

        $("#p1").click(()=>{ })
        $("#p1").click()

        $("#p1").toggle(
            ()=>{},()=>{},()=>{},......
        )

        $("#p1").on({
            click:()=>{},
            mouseover:()=>{}......
        })

        $("#p1").off(click)     removes the click event handlet

    Content Access
    -------------------------------

        $("#p1").text()         returns the text content
        $("#p1").text("")       sets the text content

        $("#tb1").val()         returns the value of the text box
        $("#tb1").val(val)      sets the valeu of the text box

        $("#p1").css("border")
        $("#p1").css("border","1px solid black")

        $("#img1").attrib("src")
        $("#img1").attrib("src","imgs/logo1.png")

        $("#img1").prop("src")
        $("#img1").prop("src","imgs/logo1.png")

    Effect Api
    -------------------------------

        show(timeDelay)
        hide(timeDelay)
        toggle(timeDelay)

        fadeIn(timeDelay)
        fadeOut(timeDelay)
        fadeToggle(timeDelay)
        fadeTo(timeDelay,opacity)

        slideUp(timeDelay)
        slideDown(timeDelay)
        slideToggle(timeDelay)

        animate({css-style},timeDelay)

    Dom Manipulation
    -------------------------------
        ${parentElement}.append(element)
        ${parentElement}.prepend(element)

        ${element}.appendTo(parentElement)
        ${element}.prependTo(parentElement)

        ${element1}.after(element2)
        ${element1}.before(element2)

        ${element}.remove()

        ${element}.addClass("css-class")
        ${element}.removeClass("css-class")