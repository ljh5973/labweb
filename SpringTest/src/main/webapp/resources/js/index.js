
$(document).ready(function(){



    console.log(document.getElementById("category-t"))
    detailT=document.querySelector(".side-content-detail-t")
    console.log(detailT);
    document.getElementById("category-t").onclick=function(){
        $(".side-content-detail-t").toggleClass("active");
        if($(".side-content-detail-t").hasClass("active")===true){
            $(".side-content-detail-t").css('display','block')
        }else{
            $(".side-content-detail-t").css('display','none')
        }
    
    }
    document.getElementById("category-p").onclick=function(){
        $(".side-content-detail-p").toggleClass("active");
        if($(".side-content-detail-p").hasClass("active")===true){
            $(".side-content-detail-p").css('display','block')
        }else{
            $(".side-content-detail-p").css('display','none')
        }
    }
    
    document.getElementById("category-o").onclick=function(){
        $(".side-content-detail-o").toggleClass("active");
        if($(".side-content-detail-o").hasClass("active")===true){
            $(".side-content-detail-o").css('display','block')
        }else{
            $(".side-content-detail-o").css('display','none')
        }
    }
    document.getElementById("category-s").onclick=function(){
        $(".side-content-detail-s").toggleClass("active");
        if($(".side-content-detail-s").hasClass("active")===true){
            $(".side-content-detail-s").css('display','block')
        }else{
            $(".side-content-detail-s").css('display','none')
        }
    }
    
})