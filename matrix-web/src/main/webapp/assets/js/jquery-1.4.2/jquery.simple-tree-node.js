/*
 *
 * Copyright (c) 2010 C. F., Wong (<a href="http://cloudgen.w0ng.hk">Cloudgen Examplet Store</a>)
 * Licensed under the MIT License:
 * http://www.opensource.org/licenses/mit-license.php
 *
 */
(function($){if(typeof $.Tree=="undefined"){
	$(['<style>table.tsn-collapse-table{border-collapse:collapse;',
		'border:none;padding:0px;margin:0px;}',
		'td.tsn-blank-square{width:10px;height:10px;',
		'padding:0px;margin:0px;}',
		'span.tsn-content{font:13px}',
		'span.tsn-content-editable{font:13px}',
		'td.tsn-L-square{width:10px;height:10px;width:10px;',
		'height:10px;border-left:1px dashed #666;',
		'border-bottom:1px dashed #666;padding:0px;margin:0px;}',
		'td.tsn-square-leftLine{width:10px;height:10px;',
		'border-left:1px dashed #666;padding:0px;margin:0px;}',
		'td.tsn-rect-leftline{width:10px;height:20px;',
		'border-left:1px dashed #666;padding:0px;}',
		'td.tsn-rect-blank{width:10px;height:20px;',
		'padding:0px;margin:0px;}',
		'.tsn-pure-node{width:20px;height:20px;float:left;',
		'background:url(../images/options.gif) no-repeat 2px 2px;}',
		'.tsn-expandable-node{width:40px;height:20px;float:left;}',
		'.tsn-expanded-node{background:url(../images/pkg-open.gif) no-repeat 2px 1px;}',
		'.tsn-collapsed-node{background:url(../images/pkg-closed.gif) no-repeat 2px 1px;}',
		'</style>'].join('')).appendTo("head");
	function Tree(obj,root){
		var t=this;
		t.classname="Tree";
		t.lineColumn={};
		t.root=new $.TreeNode(root,{isRoot:true,tree:t});
		t.root.obj=obj;
	}
	Tree.prototype={
		createChild:function(a,b){
			return this.root.createChild(a,b)
		},
		paint:function(){
			var t=this;
			$(t.root.obj).html("");
			t.root.paint();
			return t;
		}
	};
	$.fn.tree=function(value){
		return new Tree(this,value)
	};
	$.TreeNode=function (value,options){
		var t=this,
			opts = $.extend({layer:0,parent:null,list:[],tree:null,isRoot:false,editable:true}, options),	
			parent=opts.parent;
		t.layer=opts.layer;
		t.value=value||"";
		t.parent=parent;
		if(!parent) this.obj=null;
		else t.obj=t.parent.obj;
		t.classname="TreeNode";
		t.isRoot=opts.isRoot;
		t.tree=opts.tree;
		t.list=opts.list;
		t.editable=opts.editable;
		if(parent!=null) parent.appendChild(t);
	};
	$.TreeNode.prototype={
		createChild:function(value,options){
			var childNode,
				opts = $.extend({editable:true,list:[]}, options);
			if(typeof value!="undefined"){
				if(typeof this.childList=="undefined") {
					this.childList=[];
				}
				if(typeof value=="string"){
					childNode=new $.TreeNode(value);
				} else if(typeof value=="object"){
					childNode=value
				} 
				childNode.editable=opts.editable;
				childNode.list=opts.list;
				childNode.parent=this;
				childNode.obj=this.obj;
				childNode.layer=this.layer+1;
				childNode.tree=this.tree;
				this.childList.push(childNode);
			}
			return childNode
		},
		toString:function(){
			var hasChildNodes=this.hasChildren(),
				nodeClass1=(this.editable)?' class="tsn-content-editable"':' class="tsn-content"',
				nodeClass=(this.isCollapsed)? "tsn-collapsed-node":"tsn-expanded-node";

			if(hasChildNodes)
				this.tree.lineColumn["p"+this.layer]=true;
			if (this.parent==null) return ((hasChildNodes)?'<div class="tsn-expandable-node '+nodeClass+'"></div>'
				:'<div class="tsn-pure-node"></div>')+'<span>'+this.value+'</span>';
			var s=[];
			s.push('<table class="tsn-collapse-table"><tr>');
			for(var i=0;i<this.layer-1;i++) s.push(this.getVertLine(i));
			s.push('<td><table class="tsn-collapse-table">');
			s.push('<tr><td class="tsn-blank-square"></td><td class="tsn-L-square"></td></tr>');
			if(this.parent.childList[this.parent.childList.length-1]==this) {
				s.push('<tr><td class="tsn-blank-square"></td><td class="tsn-blank-square"></td></tr>');
				this.tree.lineColumn["p"+(this.layer-1)]=false
			}else {
				s.push('<tr><td class="tsn-blank-square"></td><td class="tsn-square-leftLine"></td></tr>')
			}
			s.push('</table></td><td valign="middle">');
			if(hasChildNodes) s.push('<div class="tsn-expandable-node '+nodeClass+'"></div>');
			else s.push('<div class="tsn-pure-node"></div>');
			s.push('<span'+nodeClass1+'>'+this.value+'</span></td></tr></table>');
			return s.join('')
		},
		paint:function(){
			var t=this;
			if(t.isRoot){
				 t.target=$('<table style="border-collapse:collapse;"><tr><td style="padding:0px;margin:0px;"></td></tr></table>')
				.appendTo(t.obj).find("tr").data(t.classname,t);

			} else{
				 t.target=$('<tr><td style="padding:0px;margin:0px;"></td></tr>')
				.appendTo($(t.obj).find("tbody")[0]).data(t.classname,t);
			}
			t.target.find("td").append($(""+t));
			t.target.find(".tsn-expandable-node").data(t.classname,t);
			t.target.find(".tsn-content-editable").data(t.classname,t);
			if(t.hasChildren()){
				for(var i=0;i<t.childList.length;i++){
					t.childList[i].paint()
				}
			}
			if(t.isCollapsed) {
				 t.collapse();
			}
			return t
		},
		expand:function(){
			var t=this;
			if(!t.isCollapsed && t.hasChildren())
				for(var i=0;i<t.childList.length;i++)
					t.childList[i].show().expand();
			return t
		},
		show:function(){
			this.target.show();
			return this
		},
		hasChildren:function(){
			return this.childList && this.childList.length>0
		},
		collapse:function(value){
			var t=this;
			if(typeof value=="boolean" ){
				t.isCollapsed=value;
				if(!value) return t
			}
			if(t.hasChildren())
				for(var i=0;i<t.childList.length;i++)
					t.childList[i].hide().collapse()
			return t
		},
		hide:function(){
			this.target.hide();
			return this
		},
		getVertLine:function(column){
			if(typeof this.tree.lineColumn["p"+column]=="undefined" || this.tree.lineColumn["p"+column]) return '<td><table class="tsn-collapse-table">'
				+'<tr><td class="tsn-rect-blank"></td><td class="tsn-rect-leftline"></td></tr>'
				+'</table></td>';
			else
				return '<td><table class="tsn-collapse-table">'
				+'<tr><td class="tsn-rect-blank"></td><td class="tsn-rect-blank"></td></tr>'
				+'</table></td>';
		}
	}
	$(".tsn-content-editable").live("click",function(){
		var u=$(this);
		if(u.find("input").size()==0){ 
			var v=u.html().replace(/"/g,'\\"').replace(/</g,"&lt;"),
			node=u.data("TreeNode");
			u.removeClass("tsn-content-editable").addClass("tsn-edit");
			if(node.list!=null && node.list.length>0){
				var s=[];
				for(var i=0;i<node.list.length;i++) s.push('<option value="'+node.list[i]+'">'+node.list[i]+'</option>');
				u.html('<select class="tsn-updatedContent">'+s.join('')+'</select><input class="tsn-save" type="button" value="ok"/>')
			}else{
				u.html('<input class="tsn-updatedContent" type="text" value="'+v+'"/><input class="tsn-save" type="button" value="ok"/>')
			}
		}
	});
	$(".tsn-save").live("click",function(){
		var u=$(this).closest(".tsn-edit"),
			w=""+u.find(".tsn-updatedContent").val();
		u.removeClass("tsn-edit").addClass("tsn-content-editable")
		.html(w);
	});
	$(".tsn-expanded-node").live("click",function(){
		$(this).removeClass("tsn-expanded-node").addClass("tsn-collapsed-node")
		.data("TreeNode").collapse(true)
	});
	$(".tsn-collapsed-node").live("click",function(){
		$(this).removeClass("tsn-collapsed-node").addClass("tsn-expanded-node")
		.data("TreeNode").collapse(false).expand()
	});
}})(jQuery);