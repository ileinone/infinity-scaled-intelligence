/*

Responsive Mobile Menu v1.0
Plugin URI: responsivemobilemenu.com

Author: Sergio Vitov
Author URI: http://xmacros.com

License: CC BY 3.0 http://creativecommons.org/licenses/by/3.0/

*/

var index = 0;

function responsiveMobileMenu() {	
	
//	navigation-ul
	
//	$('ul').each(function() {	
//		$(this).children("li").attr("data-slide", index);
//		index++;
//	});
	
	$('ul li').each(function(i) {
		index++;
		$(this).attr('data-slide', index);
    });
	index = 0;
	
	$('.rmm').each(function() {
		$(this).children('ul').addClass('rmm-main-list');	// mark main menu list
		
		var $style = $(this).attr('data-menu-style');	// get menu style
			if ( typeof $style == 'undefined' ||  $style == false )
				{
					$(this).addClass('graphite'); // set graphite style if style is not defined
				}
			else {
					$(this).addClass($style);
				}
				
				
		/* 	width of menu list (non-toggled) */
		
		var $width = 0;
			$(this).find('ul li').each(function() {
				$width += $(this).outerWidth();
			});
			
		// if modern browser
		
		if ($.support.leadingWhitespace) {
			$(this).css('max-width' , $width*1.05+'px');
		}
		// 
		else {
			$(this).css('width' , $width*1.05+'px');
		}
	
 	});
}

function getMobileMenu() {
	/* 	build toggled dropdown menu list */	
	$('.rmm').each(function() {	
		var menutitle = $(this).attr("data-menu-title");
		if ( menutitle == "" ) {
			menutitle = "Menu";
		}
		else if ( menutitle == undefined ) {
			menutitle = "Menu";
		}
		var $menulist = $(this).children('.rmm-main-list').html();
		var $menucontrols ="<div class='rmm-toggled-controls'><div class='rmm-toggled-title'>" + menutitle + "</div><div class='rmm-button'><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span></div></div>";
		$(this).prepend("<div class='rmm-toggled rmm-closed'>"+$menucontrols+"<ul>"+$menulist+"</ul></div>");
	});
}

function adaptMenu() {
	/* 	toggle menu on resize */
	$('.rmm').each(function() {
		var $width = $(this).css('max-width');
		$width = $width.replace('px', ''); 
		if ( $(this).parent().width() < $width*1.05 ) {
			$(this).children('.rmm-main-list').hide(0);
			$(this).children('.rmm-toggled').show(0);
		}
		else {
			$(this).children('.rmm-main-list').show(0);
			$(this).children('.rmm-toggled').hide(0);
		}
	});
}

function makeSlidingMenu() {
	
}

$(function() {

	 responsiveMobileMenu();
	 getMobileMenu();
	 adaptMenu();
	 makeSlidingMenu();
	 
	 /* slide down mobile menu on click */
	 
	 $('.rmm-toggled, .rmm-toggled .rmm-button').click(function(){
	 	if ($(this).is(".rmm-closed")) {
		 	$(this).find('ul').stop().show(300);
		 	$(this).removeClass("rmm-closed");
	 	} else {
	 		 makeSlidingMenu();
		 	$(this).find('ul').stop().hide(300);
		 	$(this).addClass("rmm-closed");
		 	index = 0;
			$(this).find('ul li').each(function(i) {
				index++;
				$(this).attr('data-slide', index);
				
				var links = $(this);
			    slide = $('.slide');
			    button = $('.button');
			    mywindow = $(window);
			    htmlbody = $('html,body');

			    slide.waypoint(function (event, direction) {
			        dataslide = $(this).attr('data-slide');
			        if (direction === 'down') {
			            $('.navigation li[data-slide="' + dataslide + '"]').addClass('active').prev().removeClass('active');
			        }
			        else {
			            $('.navigation li[data-slide="' + dataslide + '"]').addClass('active').next().removeClass('active');
			        }
			    });
			 
			    mywindow.scroll(function () {
			        if (mywindow.scrollTop() == 0) {
			            $('.navigation li[data-slide="1"]').addClass('active');
			            $('.navigation li[data-slide="2"]').removeClass('active');
			        }
			    });

			    function goToByScroll(dataslide) {
			        htmlbody.animate({
			            scrollTop: $('.slide[data-slide="' + dataslide + '"]').offset().top
			        }, 2000, 'easeInOutQuint');
			    }

			    links.click(function (e) {
			        e.preventDefault();
			        dataslide = $(this).attr('data-slide');
			        goToByScroll(dataslide);
			    });

			    button.click(function (e) {
		        e.preventDefault();
		        dataslide = $(this).attr('data-slide');
		        goToByScroll(dataslide);
			    });	 			
		    });
	 	}
	});	

});
	/* 	hide mobile menu on resize */
$(window).resize(function() {
 	adaptMenu();
});