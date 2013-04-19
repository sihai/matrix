$(function () {	
	if($("#category-tree")) {
		// My Category Tree
		$("#category-tree")
		.bind("before.jstree", function (e, data) {
			$("#alog").append(data.func + "<br />");
		})
		.jstree({
			// List of active plugins
			"plugins" : [ 
				"themes","json_data","ui","crrm","cookies","dnd","search","types","hotkeys","contextmenu" 
			],
	
			// I usually configure the plugin that handles the data first
			// This example uses JSON as it is most common
			"json_data" : {
				"data":[{"attr":{"id":"1","rel":"drive"},"data":"root","state":"closed"}],
				// This tree is ajax enabled - as this is most common, and maybe a bit more complex
				// All the options are almost the same as jQuery's AJAX (read the docs)
				"ajax" : {
					// the URL to fetch the data
					"url" : "/category_query.jhtml",
					// the `data` function is executed in the instance's scope
					// the parameter is the node being loaded 
					// (may be -1, 0, or undefined when loading the root nodes)
					"data" : function (n) { 
						// the result is fed to the AJAX request `data` option
						return {
							"_who_" : "_JS_TREE_",
							"parent" : n.attr ? n.attr("id") : 1  
						}; 
					}
				}
			},
			// Configuring the search plugin
			"search" : {
				// As this has been a common question - async search
				// Same as above - the `ajax` config option is actually jQuery's AJAX object
				"ajax" : {
					"url" : "/category_query.jhtml",
					// You get the search string as a parameter
					"data" : function (str) {
						return {
							"_who_" : "_JS_TREE_",
							"name" : str 
						}; 
					}
				}
			},
			// Using types - most of the time this is an overkill
			// read the docs carefully to decide whether you need types
			"types" : {
				// I set both options to -2, as I do not need depth and children count checking
				// Those two checks may slow jstree a lot, so use only when needed
				"max_depth" : -2,
				"max_children" : -2,
				// I want only `drive` nodes to be root nodes 
				// This will prevent moving or creating any other type as a root node
				"valid_children" : [ "drive" ],
				"types" : {
					// The default type
					"default" : {
						// I want this type to have no children (so only leaf nodes)
						// In my case - those are files
						"valid_children" : "none",
						// If we specify an icon for the default type it WILL OVERRIDE the theme icons
						"icon" : {
							"image" : "/assets/img/file.png"
						}
					},
					// The `folder` type
					"folder" : {
						// can have files and other folders inside of it, but NOT `drive` nodes
						"valid_children" : [ "default", "folder" ],
						"icon" : {
							"image" : "/assets/img/folder.png"
						}
					},
					// The `drive` nodes 
					"drive" : {
						// can have files and folders inside, but NOT other `drive` nodes
						"valid_children" : [ "default", "folder" ],
						"icon" : {
							"image" : "/assets/img/root.png"
						},
						// those prevent the functions with the same name to be used on `drive` nodes
						// internally the `before` event is used
						"start_drag" : false,
						"move_node" : false,
						"delete_node" : false,
						"remove" : false,
						"rename" : false
					}
				}
			},
			// UI & core - the nodes to initially select and open will be overwritten by the cookie plugin
	
			// the UI plugin - it handles selecting/deselecting/hovering nodes
			"ui" : {
				// this makes the node with ID node_4 selected onload
				"initially_select" : [ "node_4" ],
				"theme_name" : "classic" //设置皮肤样式
			},
			// the core plugin - not many options here
			"core" : { 
				// just open those two nodes up
				// as this is an AJAX enabled tree, both will be downloaded from the server
				"initially_open" : [ "node_2" , "node_3" ] 
			},
			"callback" : {
	            onselect : function (node, tree) {
	            	alert(node.id);
	            } 
			}
		})
		.bind("create.jstree", function (e, data) {
			alert("不允许的操作，请到类目管理页面操作！！！");
		})
		.bind("remove.jstree", function (e, data) {
			alert("不允许的操作，请到类目管理页面操作！！！");
		})
		.bind("rename.jstree", function (e, data) {
			alert("不允许的操作，请到类目管理页面操作！！！");
		})
		.bind("move_node.jstree", function (e, data) {
			alert("不允许的操作，请到类目管理页面操作！！！");
		})
		.bind("select_node.jstree", function (e, data) {
	    }).bind("dblclick_node.jstree", function (e, data) {
	    	$("#selected-category").append('<input type="checkbox" checked="true" name="brand_category" value="' + data.rslt.obj.attr("id") + '">' + data.rslt.obj.attr("name"));
	    }).bind("update.jstree", function (e, data) {
	    	alert("不允许的操作，请到类目管理页面操作！！！");
	    });
	}
});