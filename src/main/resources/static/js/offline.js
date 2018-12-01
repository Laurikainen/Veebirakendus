var offliner = (function() {
	var offlineIndex = (function() {
		var indexKey = 'offline-index',
			index;

		function getIndex() {
			if (index) {
				return index;
			}

			var indexStr = localStorage.getItem( indexKey );
			index = ( indexStr ? JSON.parse( indexStr ) : {} );
			return index;
		}

		function setIndex(index) {
			var json = JSON.stringify( index );
			localStorage.setItem( indexKey, json );
		}

		return {
			add: function(pathname, title) {
				var index = getIndex();
				index[pathname] = title;
				setIndex( index );
			},
			remove: function(pathname) {
				var index = getIndex();
				delete index[pathname];
				setIndex( index );
			},
			getTitle: function(pathname) {
				return getIndex()[pathname];
			},
			isIndexed: function(pathname) {
				return pathname in getIndex();
			},
			getKeys: function() {
				return Object.keys( getIndex() );
			},
			clear: function() {
				setIndex( {} );
			}
		};
	})();

	var snapshot,
		$body = $( document.body );

	$(function() {
		// capture output before js messes with it
		offliner.snapshotPage();
	});

	return {
		isOffline: false, // this is set in userFallback
		addCachingIframe: function() {
			$body.prepend(
				'<iframe src="/userFallback" style="position:absolute;top:-999em;visibility:hidden"></iframe>'
			);
		},
		cacheCurrentPage: function() {
			var pathname = location.pathname,
				content = snapshot || document.body.innerHTML;

			offlineIndex.add( pathname, document.title );
			localStorage.setItem( pathname, content );
		},
		removeCurrentPage: function() {
			var pathname = location.pathname;
			localStorage.removeItem( pathname );
			offlineIndex.remove( pathname );
		},
		renderCurrentPage: function() {
			var pathname = location.pathname,
				title,
				content;

			if ( this.isCached( location.href ) ) {
				title = offlineIndex.getTitle( pathname ) + ' (offline)';
				content = localStorage.getItem( pathname );
			}
			else {

                if(pathname == "/user"){
                window.location.href = "/upload"}
				title = 'Error (offline)';
                //var regex = new RegExp('<body\B</body>');
                	//document.head = '<title th:text="#{tron_fall}"></title>\n    <th:block th:include="fragments/head"/>';
                    //\n<header th:include="fragments/navigation :: navigation"/>
				//content = "<h1>Error!</h1>";
				//Gets the JSON for last used webpage and looks whether it's in Estonian
				var string = JSON.stringify(localStorage.getItem(localStorage.key(localStorage.length-2))),
                    expr = />Inglise keel</;
				//alert(expr.test(string));
				//alert(localStorage.getItem(localStorage.key(localStorage.length-2)));

				//content = //This massive stringified file is basically a blank page that shows us a navigation bar and error message
                if(expr.test(string)){
				    content = "\n    <script src=\"/static/js/jquery-1.7.1.js\"></script>\n    <script src=\"/static/js/offline.js\"></script>\n    <script>\n\t\t$( function() {\n\t\t\tif ( !offliner.isOffline ) {\n\t\t\t\toffliner.cacheCurrentPage();\n\t\t\t\toffliner.addCachingIframe();\n\t\t\t}\n\n\t\t});\n    </script>\n\n\n<header>\n    <ul>\n        <li><a href=\"/\">Mängu Info</a></li>\n        <li><a href=\"/play_game\">Mängi mängu</a></li>\n        <li><a href=\"/forum\">Foorum</a></li>\n        <li><a href=\"/user\">Kasutaja Info</a></li>\n        <li><a href=\"/statistics\">Statistika</a></li>\n        <li style=\"float:right\"><a href=\"/login\">Logi sisse</a></li>\n        <li style=\"float:right\"><a href=\"?lang=en\" rel=\"alternate\" hreflang=\"en\">Inglise keel</a></li>\n        <li style=\"float:right\"><a href=\"?lang=et\" rel=\"alternate\" hreflang=\"et\">Eesti keel</a></li>\n        <li style=\"float:right\"><a href=\"/sitemap\">Sisukaart</a></li>\n    </ul>\n</header>\n\n<h1>Viga!</h1>\n\n<a>Ilma veebiühenduseta on kasutatavad vaid viimati külastatud veebilehed.</a>\n\n";


                }
                else{
                    content = "\n    <script src=\"/static/js/jquery-1.7.1.js\"></script>\n    <script src=\"/static/js/offline.js\"></script>\n    <script>\n\t\t$( function() {\n\t\t\tif ( !offliner.isOffline ) {\n\t\t\t\toffliner.cacheCurrentPage();\n\t\t\t\toffliner.addCachingIframe();\n\t\t\t}\n\n\t\t});\n    </script>\n\n\n<header>\n    <ul>\n        <li><a href=\"/\">Game Info</a></li>\n        <li><a href=\"/play_game\">Play Game</a></li>\n        <li><a href=\"/forum\">Forum</a></li>\n        <li><a href=\"/user\">User Info</a></li>\n        <li><a href=\"/statistics\">Statistics</a></li>\n        <li style=\"float:right\"><a href=\"/login\">Login</a></li>\n        <li style=\"float:right\"><a href=\"?lang=en\" rel=\"alternate\" hreflang=\"en\">English</a></li>\n        <li style=\"float:right\"><a href=\"?lang=et\" rel=\"alternate\" hreflang=\"et\">Estonian</a></li>\n        <li style=\"float:right\"><a href=\"/sitemap\">Sitemap</a></li>\n    </ul>\n</header>\n\n<h1>Error!</h1>\n\n<a>Without internet access you can only see the websites you've recently visited.</a>\n\n\n\n";
                }

				}
            // We don't add scripts with a src, they're already there
			$body.empty().append(
				$( content ).filter( ':not(script[src])' )
			);

			document.title = title;
		},
		isCached: function(url) {
			// This is a pretty dumb way of getting the pathname.
			// See http://mathiasbynens.be/demo/url-regex for infos
			var pathname = /\/[^\/]+(\/[^?#]+)/.exec(url);
			pathname = pathname ? pathname[1] : '/';
			return offlineIndex.isIndexed( pathname );
		},
		snapshotPage: function() {
			snapshot = document.body.innerHTML;
		},
		clearAll: function() {
			offlineIndex.getKeys().forEach( function(key) {
				localStorage.removeItem( key );
			});
			offlineIndex.clear();
		}
	};
})();

function cachePage() {
    if ( !offliner.isOffline ) {
                offliner.cacheCurrentPage();
                offliner.addCachingIframe();
            }

}
function renderPage(){
		offliner.isOffline = true;
		// We only want to render the page if we're not in the hidden iframe
		if ( location.hash != '#iframed' ) {
			offliner.renderCurrentPage();
		}
}