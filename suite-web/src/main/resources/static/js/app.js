var config = window.config = {};

// Config reference element
var $ref = $("#ref");

// Configure responsive bootstrap toolkit
config.ResponsiveBootstrapToolkitVisibilityDivs = {
    'xs': $('<div class="device-xs 				  hidden-sm-up"></div>'),
    'sm': $('<div class="device-sm hidden-xs-down hidden-md-up"></div>'),
    'md': $('<div class="device-md hidden-sm-down hidden-lg-up"></div>'),
    'lg': $('<div class="device-lg hidden-md-down hidden-xl-up"></div>'),
    'xl': $('<div class="device-xl hidden-lg-down			  "></div>'),
};

ResponsiveBootstrapToolkit.use('Custom', config.ResponsiveBootstrapToolkitVisibilityDivs);

//validation configuration
config.validations = {
	debug: true,
	errorClass:'has-error',
	validClass:'success',
	errorElement:"span",

	// add error class
	highlight: function(element, errorClass, validClass) {
		$(element).parents("div.form-group")
		.addClass(errorClass)
		.removeClass(validClass); 
	}, 

	// add error class
	unhighlight: function(element, errorClass, validClass) {
		$(element).parents(".has-error")
		.removeClass(errorClass)
		.addClass(validClass); 
	},

	// submit handler
    submitHandler: function(form) {
        form.submit();
    }
}

//delay time configuration
config.delayTime = 50;

// chart configurations
config.chart = {};

config.chart.colorPrimary = tinycolor($ref.find(".chart .color-primary").css("color"));
config.chart.colorSecondary = tinycolor($ref.find(".chart .color-secondary").css("color"));
$(function() {
	animate({
		name: 'flipInY',
		selector: '.error-card > .error-title-block'
	});


	setTimeout(function(){
		var $el = $('.error-card > .error-container');

		animate({
			name: 'fadeInUp',
			selector: $el 
		});

		$el.addClass('visible');
	}, 1000);
})
//LoginForm validation
$(function() {

	if (!$('#login-form').length) {
        return false;
    }

    var loginValidationSettings = {
	    rules: {
	        username: {
	            required: true,
	            required: true
	        },
	        password: "required",
	        agree: "required"
	    },
	    messages: {
	        username: {
	            required: "Please enter username",
	            required: "Please enter a valid email address"
	        },
	        password:  "Please enter password",
	        agree: "Please accept our policy"
	    },
	    // invalidHandler: function() {
		// 	animate({
		// 		name: 'shake',
		// 		selector: '.auth-container'
		// 	});
		// }
	}

	$.extend(loginValidationSettings, config.validations);

	$('#login-form').validate(loginValidationSettings);
	

	// new PerfectScrollbar('.auth-container', {

	// 	// A list of handlers to scroll the element.
	
	// 	handlers: ['click-rail', 'drag-thumb', 'keyboard', 'wheel', 'touch'], 
	
	// 	// The scroll speed applied to mousewheel event.
		
	// 	wheelSpeed: 1, 
	
	// 	// If true, when the scroll reaches the end of the side,
	
	// 	// mousewheel event will be propagated to parent element.
	
	// 	wheelPropagation: false, 
	
	// 	// When set to an integer value, the thumb part of the scrollbar
	
	// 	// will not shrink below that number of pixels.
	
	// 	minScrollbarLength: null, 
	
	// 	// When set to an integer value, the thumb part of the scrollbar
	
	// 	// will not expand over that number of pixels.
	
	// 	maxScrollbarLength: null, 
	
	// 	// When set to true, and only one (vertical or horizontal) scrollbar
	
	// 	// is visible then both vertical and horizontal scrolling will affect the scrollbar.
	
	// 	useBothWheelAxes: false, 
	// 	// When set to true, the scroll bar in X axis will not be available,
	
	// 	// regardless of the content width.
	
	// 	suppressScrollX: false, 
	
	// 	// When set to true, the scroll bar in Y axis will not be available,
	
	// 	// regardless of the content height.
	
	// 	suppressScrollY: false, 
	
	// 	// true: swipe scrolling will be eased
	
	// 	swipeEasing: true, 
	
	// 	// The number of pixels the content width can surpass the
	
	// 	// container width without enabling the X axis scroll bar.
	
	// 	scrollXMarginOffset: 0, 
	
	// 	// The number of pixels the content height can surpass the
	
	// 	// container height without enabling the Y axis scroll bar.
	
	// 	scrollYMarginOffset: 0,
	// });


})
//ResetForm validation
$(function() {
	if (!$('#reset-form').length) {
        return false;
    }

    var resetValidationSettings = {
	    rules: {
	        email1: {
	            required: true,
	            email: true
	        }
	    },
	    messages: {
	        email1: {
	            required: "Please enter email address",
	            email: "Please enter a valid email address"
	        }
	    },
	    invalidHandler: function() {
			animate({
				name: 'shake',
				selector: '.auth-container > .card'
			});
		}
	}

	$.extend(resetValidationSettings, config.validations);

    $('#reset-form').validate(resetValidationSettings);
})
//SignupForm validation
$(function() {
	if (!$('#signup-form').length) {
        return false;
    }

    var signupValidationSettings = {
	    rules: {
	    	firstname: {
	    		required: true,
	    	},
	    	lastname: {
	    		required: true,
	    	},
	        email: {
	            required: true,
	            email: true
	        },
	        password: {
				required: true,
				minlength: 8
	        },
	        retype_password: {
				required: true,
				minlength: 8,
				equalTo: "#password"
			},
			agree: {
				required: true,
			}
	    },
	    groups: {
	    	name: "firstname lastname",
			pass: "password retype_password",
		},
		errorPlacement: function(error, element) {
			if (
				element.attr("name") == "firstname" || 
				element.attr("name") == "lastname" 
			) {
				error.insertAfter($("#lastname").closest('.row'));
				element.parents("div.form-group")
				.addClass('has-error');
			} 
			else if (
				element.attr("name") == "password" || 
				element.attr("name") == "retype_password" 
			) {
				error.insertAfter($("#retype_password").closest('.row'));
				element.parents("div.form-group")
				.addClass('has-error');
			}
			else if (element.attr("name") == "agree") {
				error.insertAfter("#agree-text");
			}
			else {
				error.insertAfter(element);
			}
		},
	    messages: {
	    	firstname: "Please enter firstname and lastname",
	    	lastname: "Please enter firstname and lastname",
	        email: {
	            required: "Please enter email",
	            email: "Please enter a valid email address"
	        },
	        password: {
	        	required: "Please enter password fields.",
	        	minlength: "Passwords should be at least 8 characters."
	        },
	        retype_password: {
	        	required: "Please enter password fields.",
	        	minlength: "Passwords should be at least 8 characters."
	        },
	        agree: "Please accept our policy"
	    },
	    invalidHandler: function() {
			animate({
				name: 'shake',
				selector: '.auth-container > .card'
			});
		}
	}

	$.extend(signupValidationSettings, config.validations);

    $('#signup-form').validate(signupValidationSettings);
});
/***********************************************
*        Animation Settings
***********************************************/
function animate(options) {
	var animationName = "animated " + options.name;
	var animationEnd = "webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend";
	$(options.selector)
	.addClass(animationName)
	.one(animationEnd, 
		function(){
			$(this).removeClass(animationName);
		}
	);
}


$(function() {
	var $itemActions = $(".item-actions-dropdown");

	$(document).on('click',function(e) {
		if (!$(e.target).closest('.item-actions-dropdown').length) {
			$itemActions.removeClass('active');
		}
	});
	
	$('.item-actions-toggle-btn').on('click',function(e){
		e.preventDefault();

		var $thisActionList = $(this).closest('.item-actions-dropdown');

		$itemActions.not($thisActionList).removeClass('active');

		$thisActionList.toggleClass('active');	
	});
});

/***********************************************
*        NProgress Settings
***********************************************/
var npSettings = { 
	easing: 'ease', 
	speed: 2000 
}

NProgress.configure(npSettings);
$(function() {
	setSameHeights();

	var resizeTimer;

	$(window).resize(function() {
		clearTimeout(resizeTimer);
        resizeTimer = setTimeout(setSameHeights, 150);
	});
});


function setSameHeights($container) {

	$container = $container || $('.sameheight-container');

	var viewport = ResponsiveBootstrapToolkit.current();

	$container.each(function() {

		var $items = $(this).find(".sameheight-item");

		// Get max height of items in container
		var maxHeight = 0;

		$items.each(function() {
			$(this).css({height: 'auto'});
			maxHeight = Math.max(maxHeight, $(this).innerHeight());
		});


		// Set heights of items
		$items.each(function() {
			// Ignored viewports for item
			var excludedStr = $(this).data('exclude') || '';
			var excluded = excludedStr.split(',');

			// Set height of element if it's not excluded on 
			if (excluded.indexOf(viewport) === -1) {
				$(this).innerHeight(maxHeight);
			}
		});
	});
}


$(function () {

    
});
$(function () {

    if (!$('#formulario-visits-chart').length) {
        return false;
    }

    // drawing visits chart
    drawVisitsChart();

    var el = null;
    var item = 'visits';

    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {

        el = e.target;
        item = $(el).attr('href').replace('#', '');
        switchHistoryCharts(item);

    });

    $(document).on("themechange", function () {
        switchHistoryCharts(item);
    });

    function switchHistoryCharts(item) {
        var chartSelector = "#formulario-" + item + "-chart";

        if ($(chartSelector).has('svg').length) {
            $(chartSelector).empty();
        }

        switch (item) {
            case 'visits':
                drawVisitsChart();
                break;
            case 'downloads':
                drawDownloadsChart();
                break;
        }
    }

    function drawVisitsChart() {
        var dataVisits = [
            { x: '2015-09-01', y: 70 },
            { x: '2015-09-02', y: 75 },
            { x: '2015-09-03', y: 50 },
            { x: '2015-09-04', y: 75 },
            { x: '2015-09-05', y: 50 },
            { x: '2015-09-06', y: 75 },
            { x: '2015-09-07', y: 86 }
        ];


        Morris.Line({
            element: 'formulario-visits-chart',
            data: dataVisits,
            xkey: 'x',
            ykeys: ['y'],
            ymin: 'auto 40',
            labels: ['Visits'],
            xLabels: "day",
            hideHover: 'auto',
            yLabelFormat: function (y) {
                // Only integers
                if (y === parseInt(y, 10)) {
                    return y;
                }
                else {
                    return '';
                }
            },
            resize: true,
            lineColors: [
                config.chart.colorSecondary.toString(),
            ],
            pointFillColors: [
                config.chart.colorPrimary.toString(),
            ]
        });
    }

    function drawDownloadsChart() {

        var dataDownloads = [
            {
                year: '2006',
                downloads: 1300
            },
            {
                year: '2007',
                downloads: 1526
            },
            {
                year: '2008',
                downloads: 2000
            },
            {
                year: '2009',
                downloads: 1800
            },
            {
                year: '2010',
                downloads: 1650
            },
            {
                year: '2011',
                downloads: 620
            },
            {
                year: '2012',
                downloads: 1000
            },
            {
                year: '2013',
                downloads: 1896
            },
            {
                year: '2014',
                downloads: 850
            },
            {
                year: '2015',
                downloads: 1500
            }
        ];

        Morris.Bar({
            element: 'formulario-downloads-chart',
            data: dataDownloads,
            xkey: 'year',
            ykeys: ['downloads'],
            labels: ['Downloads'],
            hideHover: 'auto',
            resize: true,
            barColors: [
                config.chart.colorPrimary.toString(),
                tinycolor(config.chart.colorPrimary.toString()).darken(10).toString()
            ],
        });
    }
});




$(function() {

	$(".wyswyg").each(function() {

		var $editor = $(this).find(".editor");
		var $toolbar = $(this).find(".toolbar");

		var editor = new Quill($editor.get(0), {
			theme: 'snow',
			// modules: {
			// 	toolbar: toolbarOptions
			// }
			modules: {
				toolbar: $toolbar.get(0)
			}
		});

		// var $toolbar = $(this).find(".toolbar");
		// var $editor = $(this).find(".editor");


		// var editor = new Quill($editor.get(0), {
		// 	theme: 'snow'
		// });

		// editor.addModule('toolbar', {
		// 	container: $toolbar.get(0)     // Selector for toolbar container
		// });



	});

});

$(function () {

	$('#sidebar-menu, #customize-menu').metisMenu({
		activeClass: 'open'
	});

	$('#sidebar-collapse-btn').on('click', function(event){
		event.preventDefault();
		
		$("#app").toggleClass("sidebar-open");
	});

	$("#sidebar-overlay").on('click', function() {
		$("#app").removeClass("sidebar-open");
	});

	if ($.browser.mobile) {
		var $appContainer = $('#app ');
		var $mobileHandle = $('#sidebar-mobile-menu-handle ');

		$mobileHandle.swipe({
			swipeLeft: function() {
				if($appContainer.hasClass("sidebar-open")) {
					$appContainer.removeClass("sidebar-open");	
				}
			},
			swipeRight: function() {
				if(!$appContainer.hasClass("sidebar-open")) {
					$appContainer.addClass("sidebar-open");
				}
			},
			// excludedElements: "button, input, select, textarea, .noSwipe, table", 
			triggerOnTouchEnd: false
		});
	}
	
});
$(function () {

	$('.chat-message-edit').on('change keyup keydown paste cut', 'textarea', function () {
		$(this).height(0).height(this.scrollHeight);
		
	}).find('textarea').change();
	

    $('#collapse-chat-btn').on('click', function(event){
			event.preventDefault();		
			$("#app").addClass("sidebar-chat-open");
	});

	$('#chat-header-open-btn').on('click', function(event){
		event.preventDefault();		
		$("#app").addClass("sidebar-chat-open");
	});

	$('#chat-header-close-btn').on('click', function(event){
		event.preventDefault();		
		$("#app").removeClass("sidebar-chat-open");
	});
	

	$('.chat-contact-item').on('click', function(event){
		event.preventDefault();	
		$("#app").addClass("sidebar-chat-open");
		$('.chat-contact-item').removeClass('active');
		$(this).addClass('active');
	});

	function expandTextarea(id) {
		document.getElementById(id).addEventListener('keyup', function() {
			this.style.overflow = 'hidden';
			this.style.height = 0;
			this.style.height = this.scrollHeight + 'px';
		}, false);
	}
	
});
$(function () {

    $('#quick-panel-btn').on('click', function(event){
		event.preventDefault();		
		$("#app").toggleClass("sidebar-quick-panel-open");
	});

	$("#sidebar-quick-panel-overlay").on('click', function() {
		$("#app").removeClass("sidebar-quick-panel-open");
	});

});
// Animating dropdowns is temporary disabled
// Please feel free to send a pull request :)

// $(function() {
// 	$('.nav-profile > li > a').on('click', function() {
// 		var $el = $(this).next();


// 		animate({
// 			name: 'flipInX',
// 			selector: $el
// 		});
// 	});
// })

var modalMedia = {
	$el: $("#modal-media"),
	result: {},
	options: {},
	open: function(options) {
		options = options || {};
		this.options = options;


		this.$el.modal('show');
	},
	close: function() {
		if ($.isFunction(this.options.beforeClose)) {
			this.options.beforeClose(this.result);
		}

		this.$el.modal('hide');

		if ($.isFunction(this.options.afterClose)) {
			this.options.beforeClose(this.result);
		}
	}
};
$(function () {

	// Local storage settings
	var themeSettings = getThemeSettings();

	// Elements

	var $app = $('#app');
	var $styleLink = $('#theme-style');
	var $customizeMenu = $('#customize-menu');

	// Color switcher
	var $customizeMenuColorBtns = $customizeMenu.find('.color-item');

	// Position switchers
	var $customizeMenuRadioBtns = $customizeMenu.find('.radio');


	// /////////////////////////////////////////////////

	// Initial state

	// On setting event, set corresponding options

	// Update customize view based on options

	// Update theme based on options

	/************************************************
	*				Initial State
	*************************************************/

	setThemeSettings();

	/************************************************
	*					Events
	*************************************************/

	// set theme type
	$customizeMenuColorBtns.on('click', function() {
		themeSettings.themeName = $(this).data('theme');

		setThemeSettings();
	});


	$customizeMenuRadioBtns.on('click', function() {

		var optionName = $(this).prop('name');
		var value = $(this).val();

		themeSettings[optionName] = value;

		setThemeSettings();
	});

	function setThemeSettings() {
		setThemeState()
		.delay(config.delayTime)
		.queue(function (next) {

			setThemeColor();
			setThemeControlsState();
			saveThemeSettings();

			$(document).trigger("themechange");	
			
			next();
		});	
	}

	/************************************************
	*			Update theme based on options
	*************************************************/

	function setThemeState() {
		// set theme type
		if (themeSettings.themeName) {
			$styleLink.attr('href', 'css/app-' + themeSettings.themeName + '.css');
		}
		else {
			$styleLink.attr('href', 'css/app.css');
		}

		// App classes
		$app.removeClass('header-fixed footer-fixed sidebar-fixed');

		// set header
		$app.addClass(themeSettings.headerPosition);

		// set footer
		$app.addClass(themeSettings.footerPosition);

		// set footer
		$app.addClass(themeSettings.sidebarPosition);

		return $app;
	}

	/************************************************
	*			Update theme controls based on options
	*************************************************/

	function setThemeControlsState() {
		// set color switcher
		$customizeMenuColorBtns.each(function() {
			if($(this).data('theme') === themeSettings.themeName) {
				$(this).addClass('active');
			}
			else {
				$(this).removeClass('active');
			}
		});

		// set radio buttons
		$customizeMenuRadioBtns.each(function() {
			var name = $(this).prop('name');
			var value = $(this).val();

			if (themeSettings[name] === value) {
				$(this).prop("checked", true );
			}
			else {
				$(this).prop("checked", false );
			}
		});
	}

	/************************************************
	*			Update theme color
	*************************************************/
	function setThemeColor(){
		config.chart.colorPrimary = tinycolor($ref.find(".chart .color-primary").css("color"));	
		config.chart.colorSecondary = tinycolor($ref.find(".chart .color-secondary").css("color"));	
	}

	/************************************************
	*				Storage Functions
	*************************************************/

	function getThemeSettings() {
		var settings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) : {};

		settings.headerPosition = settings.headerPosition || '';
		settings.sidebarPosition = settings.sidebarPosition || '';
		settings.footerPosition = settings.footerPosition || '';

		return settings;
	}

	function saveThemeSettings() {
		localStorage.setItem('themeSettings', JSON.stringify(themeSettings));
	}

});
$(function() {	
	$("body").addClass("loaded");
});

/***********************************************
*        NProgress Settings
***********************************************/

// start load bar
NProgress.start();

// end loading bar 
NProgress.done();


/***********************************************
*        PerfectScrollbar
***********************************************/
//const pss = document.querySelectorAll('.ps-scrollview-auto');
//console.log(pss);
//pss.forEach(function(ps_value){    
//   let ps = new PerfectScrollbar(ps_value);
//   ps.update();
//})
