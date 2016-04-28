
//动态生成EASYUI linkbutton按钮（解决datagrid行动态输出按钮效果不显示的问题）
function createLinkElement(title, event, icon) {

	var str = '<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-plain" plain="true" style="padding: 3px;"';
    str = str + 'onclick="' + event + '">';
    str = str + '<span class="l-btn-left"><span class="l-btn-text ' + icon + '" style="padding: 8px;"">';
    str = str + '</span>'+title+'</span></a>';
    return str;

}

//js获取项目根路径，如： http://localhost:8080/RentCarSystem
function getRootPath(){
    //获取当前网址，如： http://localhost:8080/RentCarSystem/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： RentCarSystem/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/RentCarSystem
    var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}


function CreateDisabledElement(title, icon) {

    var str = '<a href="javascript:void(0)" class="easyui-linkbutton l-btn-disabled" iconcls="' + icon + '" plain="true" style=" text-decoration:none; " >';

    //str = str + 'onclick="' + event + '">';

    str = str + '<span class="l-btn-left"><span class="l-btn-text ' + icon + '" style="padding-left: 20px; color:#ccc; ">';

    str = str + title + '</span></span></a>';

    return str;

}
//将时间戳转化为日期格式
function fromatDate(date){
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var hour = date.getHours();
	var minutes = date.getMinutes();
	var seconds = date.getSeconds();
	return year+"-"+month+"-"+day+" "+hour+":"+minutes+":"+seconds;
}

//动态生成文本或者链接的Title（解决datagrid列文字被自动截断的问题）
function createTextTitle(title, islink, urlstring) {

    var str = "";

    if (islink == "true") {
        str = '<a href="' + urlstring + '" title="' + title + '" > ' + title + '</a>';
    }
    else {
        str = '<span title="' + title + '" > ' + title + '</span>';
    }

    return str;
}

//动态生成文本或者链接的Title（解决datagrid列文字被自动截断的问题）
function createTextTitleAddTip(title, islink, urlstring,tipcontent) {

    var str = "";

    if (islink == "true") {
        str = '<a id="#biaoqian_tip" href="' + urlstring + '" title="' + tipcontent + '" > ' + title + '</a>';
    }
    else {
        str = '<span id="#biaoqian_tip"  title="' + tipcontent + '" > ' + title + '</span>';
    }

    return str;
}

//动态生成红色提示文本或者链接的Title（解决datagrid列文字被自动截断的问题）
function createRedTextTitle(title, islink, urlstring,text) {

    var str = "";

    if (islink == "true") {
        str = '<a href="' + urlstring + '" title="' + title + '"> <font color="red">' + title + '</font></a>';
    }
    else {
        str = '<span title="' + title + '"><font color="red"> ' + text + '</font></span>';
    }

    return str;
}

//标题提示
function showtooltip() {

    $('a[title],span[title],input[title]').mouseover(function (e) {

        this.myTitle = this.title;

        //this.myHref = this.href;

        //this.myHref = (this.myHref.length > 30 ? this.myHref.toString().substring(0, 30) + "..." : this.myHref);

        this.title = "";

        //var tooltip = "<div id='tooltip'><p>" + this.myTitle + "<em>" + this.myHref + "</em>" + "</p></div>";
        var tooltip = "<div id='tooltip'><p>" + this.myTitle + "</p></div>";

        $('body').append(tooltip);

        $('#tooltip').css({ "opacity": "0.8", "top": (e.pageY + 20) + "px", "left": (e.pageX + 10) + "px" }).show('fast');

    }).mouseout(function () {
        this.title = this.myTitle; $('#tooltip').remove();

    }).mousemove(function (e) {
        $('#tooltip').css({ "top": (e.pageY + 20) + "px", "left": (e.pageX + 10) + "px" });

    });

}

//标题提示（预览带HTML标签内容用）
function showtooltipbycontent() {

    $('a[title],span[title],input[title]').mouseover(function (e) {

        this.myTitle = this.title;

        //this.myHref = this.href;

        //this.myHref = (this.myHref.length > 30 ? this.myHref.toString().substring(0, 30) + "..." : this.myHref);

        this.title = "";

        //var tooltip = "<div id='tooltip'><p>" + this.myTitle + "<em>" + this.myHref + "</em>" + "</p></div>";
        var tooltip = "<div id='tooltip'><p>" + this.myTitle + "</p></div>";

        $('body').append(tooltip);

        $('#tooltip').css({ "opacity": "0.8", "top": (e.pageY + 20) + "px", "left": (e.pageX + 10) + "px" }).show('fast');

    }).mouseout(function () {
        this.title = this.myTitle; $('#tooltip').remove();

    }).mousemove(function (e) {
        $('#tooltip').css({ "top": (e.pageY + 20) + "px", "left": (e.pageX + 10) + "px" });

    });

}


//easyui-datagrid 表头宽度自适应
function initeasyuigridwidth() {

    var headerTds = $(".datagrid-header-inner table tr:first-child").children();

    var bodyTds = $(".datagrid-body table tr:first-child").children();

    bodyTds.each(function (i, obj) {

        var headerTd = $(headerTds.get(i));
        var bodyTd = $(bodyTds.get(i));

        headerTd.width(bodyTd.width());

    });

}





/**
* willcheck:要进行处理的表格对象(或者行的集合即可)
* colnum:要进行合并单元格的列
*/
function coltogather(willcheck, colnum) {
    var alltext = [], togotherNum = [], oldnum = [], id = 1, lasttext = null, rmflag = 1;
    //逐列的数据进行扫描,得到里面的不重复的数据,以及各个数据的数目,然后将依据此结果进行设置rowspan属性
    willcheck.each(function () {
        var _rmnum = this.getAttribute('rmnum');
        if (!_rmnum) _rmnum = 0;
        var trdom = jQuery('td:eq(' + (colnum - _rmnum) + ')', this)
        var text = jQuery(trdom).text();
        //如果上一行记录文本为空,说明是第一行
        if (lasttext == null) {
            lasttext = text;
        } else {
            //如果当前行和上一行记录一样,说明要进行合并,合并的单元格数目就加1
            if (lasttext != text) {
                togotherNum.push(id);
                lasttext = text;
                id = 1;
            } else {
                id++;
            }
        }

    });
    togotherNum.push(id);
    //复制allnum数组中的数据到oldnum数组
    jQuery.each(togotherNum, function (i, n) {
        oldnum[i] = n;
    });
    var index = 0, len = togotherNum.length;
    //逐行进行处理,设置指定列的rowspan属性,以及将要合并的单元格remove!
    willcheck.each(function () {
        // 得到一个属性表示该行已经被移除了几个td
        var _rmnum = this.getAttribute('rmnum');
        if (!_rmnum)
            _rmnum = 0;
        var tddom = jQuery('td:eq(' + (colnum - _rmnum) + ')', this)
        if (togotherNum[index] == oldnum[index]) {
            tddom.attr('rowSpan', togotherNum[index]);
            if (togotherNum[index] > 1)
                togotherNum[index] = togotherNum[index] - 1;
            else
                index++;
        } else {
            if (togotherNum[index] == 0) {
                index++;
                tddom.attr('rowSpan', togotherNum[index]);
            } else {
                tddom.remove();
                if (--togotherNum[index] == 0) {
                    index++;
                }
            }
            // 移除了td之后,要在tr里面添加一个属性标示已经移除的td的数目
            if (_rmnum == 0) {
                jQuery(this).attr('rmnum', 1);
            } else {
                jQuery(this).attr('rmnum', 1 + _rmnum * 1);
            }
        }
    });
    //清空数组
    alltext = null;
    togotherNum = null;
    oldnum = null;
}


function isinarr(arr, str) {
    for (var i = arr.length - 1; i >= 0; i--) {
        if (arr[i] == str) {
            return i;
        }
    }
    return -1;
}

function checktable(id) {
    var tdnum = 0;
    $('#' + id + ' tr').each(function () {
        if (tdnum == 0) {
            tdnum = $('td', this).size();
        } else {
            if (tdnum != $('td', this).size()) {
                tdnum = -1;
                return false;
            }
        }
    });
    if (tdnum > 0)
        return true;
    return false;
}

//$.ajax加载等待中
function commonajaxloading() {

    $("<div class=\"datagrid-mask\"></div>").css({ display: "block", width: "100%", height: $(window).height() }).appendTo("#wnavt"); //等待效果显示在wnavt控件
    $("<div class=\"datagrid-mask-msg\"></div>").html($.fn.datagrid.defaults.loadMsg).appendTo("#wnavt").css({ display: "block", left: $(window).width() * 0.5, top: $(window).height() * 0.5 }); //上同

}

//$.ajax通用加载等待中（直接调用模板页等待特效）
function trmsajaxloading(loadingtxt) {

    //$("<div class=\"datagrid-mask\"></div>").css({ display: "block" }).appendTo("#wnavt"); //等待效果显示在wnavt控件
    //$("<div class=\"datagrid-mask-msg\"></div>").html($.fn.datagrid.defaults.loadMsg).appendTo("#wnavt").css({ display: "block" }); //上同
    $(".overlay").css({ 'display': 'block', 'opacity': '0.8' });

    $(".showbox").stop(true).animate({ 'margin-top': '210px', 'opacity': '1' }, 200);

    $("#span_AjaxLoadingTxt").html(loadingtxt);


    //$(".showbox").stop(true).animate({ 'margin-top': '250px', 'opacity': '0' }, 400);

    //$(".overlay").css({ 'display': 'none', 'opacity': '0' });

}

//$.ajax通用加载结束（直接调用模板页等待特效）
function trmsajaxloadover(loadovertxt) {

    $("#span_AjaxLoadingTxt").html(loadovertxt);

    setTimeout(function () {

        $(".showbox").stop(true).animate({ 'margin-top': '210px', 'opacity': '0' }, 400);

        $(".overlay").css({ 'display': 'none', 'opacity': '0' });

    }, 800);

}


//$.ajax关闭“加载等待”
function commonajaxloadover() {

    $("#wnavt").find("div.datagrid-mask-msg").remove();
    $("#wnavt").find("div.datagrid-mask").remove();

}

//关闭body滚动条
function closebodyscroll(){
   $(document.body).css({"overflow-x":"hidden","overflow-y":"hidden"}); 
}

//开启body滚动条
function openbodyscorll(){
   $(document.body).css({"overflow-x":"auto","overflow-y":"auto"});

}

//Json对象转Json字符串
function JsonOtoJsonS(o) {
    if (o == undefined) { return ""; }
    var r = [];
    if (typeof o == "string") return "\"" + o.replace(/([\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
    if (typeof o == "object") {
        if (!o.sort) {
            for (var i in o)
                r.push("\"" + i + "\":" + JsonOtoJsonS(o[i]));
            if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {
                r.push("toString:" + o.toString.toString());
            }
            r = "{" + r.join() + "}"
        } else {
            for (var i = 0; i < o.length; i++)
                r.push(JsonOtoJsonS(o[i]));
            r = "[" + r.join() + "]";
        }
        return r;
    }
    return o.toString().replace(/\"\:/g, '":""');
}


$.extend($.fn.validatebox.defaults.rules, {     
   positive_int:{     
       validator:function(value){     
           if (value){     
               return /^[0-9]*[1-9][0-9]*$/.test(value);     
           } else {     
                return true;     
           }     
       },     
       message:'只能输入正整数.'
   }


});
//只能输入一定范围的数字
$.extend($.fn.validatebox.defaults.rules, {
    num_range: {
        validator: function (value, param) {
            if (value.length>0) {
                var pp = /[\d.]/.test(value);
                if (pp ) {
                    if (value >= 0 && value <= param[0]) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            } 
        },
        message: '必须输入0到{0}的数字.'
    }

});




//课程添加部分
$.extend($.fn.validatebox.defaults.rules, {
    C_NameLength: {
        validator: function (value, param) {
            return value.length >= param[0];
        },
        message: '课程名称必须{0}个字以上！'
    },
    C_TypeIDInt: {
        validator: function (value) {

            if (value == "" || value == "请选择课程类型") {
                return false;
            }
            else {
                return true;
            }
        },
        message: '课程类型必须选择！'
    },
    C_CategoryIDInt: {
        validator: function (value) {

            if (value == "" || value == "请选择课程分类") {
                return false;
            }
            else {
                return true;
            }
        },
        message: '课程分类必须选择！'
    },
    C_SimnetDefaultDcsInt: {
        validator: function (value) {

            if (value == "" || value == "请选择课程DCS风格") {
                return false;
            }
            else {
                return true;
            }
        },
        message: '课程DCS风格必须选择！'
    },
    C_CreditInt: {
        validator: function (value) {
            if (value) {
                return /^[0-9]*[1-9][0-9]*$/.test(value);
            } else {
                return true;
            }
        },
        message: '标准学时只能输入正整数！'
    } 
});


//对象定义（构造函数)
//参数：所有参数须为字符串形式.
//当参数长度为1时，参数值将是字符串之间连接的分隔符
//当参数长度大于1时，最后一位将是字符串之间的分隔符,其余的参数将是字符串值
//当不指定参数时，分隔符默认为空白
//也可以不指定分隔符，而在ToString中显式指定分隔符
//如：var str = new StringBuilder(',')； 则在ToString时，将使用,号作为分隔符连接字符串
// var str = new StringBuilder('a','b','c',','); 则在ToString时，将输出 'a,b,c'
function StringBuilder() {
    this._buffers = [];
    this._length = 0;
    this._splitChar = arguments.length > 0 ? arguments[arguments.length - 1] : '';

    if (arguments.length > 0) {
        for (var i = 0, iLen = arguments.length - 1; i < iLen; i++) {
            this.Append(arguments[i]);
        }
    }
}

//向对象中添加字符串
//参数：一个字符串值
StringBuilder.prototype.Append = function (str) {
    this._length += str.length;
    this._buffers[this._buffers.length] = str;
}
StringBuilder.prototype.Add = StringBuilder.prototype.append;

//向对象附加格式化的字符串
//参数：参数一是预格式化的字符串，如：'{0} {1} {2}'
//格式参数可以是数组，或对应长度的arguments,
//参见示例
StringBuilder.prototype.AppendFormat = function () {
    if (arguments.length > 1) {
        var TString = arguments[0];
        if (arguments[1] instanceof Array) {
            for (var i = 0, iLen = arguments[1].length; i < iLen; i++) {
                var jIndex = i;
                var re = eval("/\\{" + jIndex + "\\}/g;");
                TString = TString.replace(re, arguments[1][i]);
            }
        }
        else {
            for (var i = 1, iLen = arguments.length; i < iLen; i++) {
                var jIndex = i - 1;
                var re = eval("/\\{" + jIndex + "\\}/g;");
                TString = TString.replace(re, arguments[i]);
            }
        }
        this.Append(TString);
    }
    else if (arguments.length == 1) {
        this.Append(arguments[0]);
    }
}

//字符串长度（相当于ToString()后输出的字符串长度
StringBuilder.prototype.Length = function () {
    if (this._splitChar.length > 0 && (!this.IsEmpty())) {
        return this._length + (this._splitChar.length * (this._buffers.length - 1));
    }
    else {
        return this._length;
    }
}
//字符串是否为空
StringBuilder.prototype.IsEmpty = function () {
    return this._buffers.length <= 0;
}
//清空
StringBuilder.prototype.Clear = function () {
    this._buffers = [];
    this._length = 0;
}
//输出
//参数：可以指定一个字符串（或单个字符），作为字符串拼接的分隔符
StringBuilder.prototype.ToString = function () {
    if (arguments.length == 1) {
        return this._buffers.join(arguments[1]);
    }
    else {
        return this._buffers.join(this._splitChar);
    }
}

$.extend($.fn.combo.methods, {
    /**
    * 禁用combo文本域
    * @param {Object} jq
    * @param {Object} param stopArrowFocus:是否阻止点击下拉按钮时foucs文本域
    * activeTextArrow:是否激活点击文本域也显示下拉列表
    * stoptype:禁用类型，包含disable和readOnly两种方式
    */
    disableTextbox: function (jq, param) {
        return jq.each(function () {
            param = param || {};
            var textbox = $(this).combo("textbox");
            var that = this;
            var panel = $(this).combo("panel");
            var data = $(this).data('combo');
            if (param.stopArrowFocus) {
                data.stopArrowFocus = param.stopArrowFocus;
                var arrowbox = $.data(this, 'combo').combo.find('span.combo-arrow');
                arrowbox.unbind('click.combo').bind('click.combo', function () {
                    if (panel.is(":visible")) {
                        $(that).combo('hidePanel');
                    }
                    else {
                        $("div.combo-panel").panel("close");
                        $(that).combo('showPanel');
                    }
                });
                textbox.unbind('mousedown.mycombo').bind('mousedown.mycombo', function (e) {
                    e.preventDefault();
                });
            }
            if (param.activeTextArrow) {
                data.activeTextArrow = param.activeTextArrow;
                textbox.bind('click.mycombo', function () {
                    if (panel.is(":visible")) {
                        $(that).combo('hidePanel');
                    }
                    else {
                        $("div.combo-panel").panel("close");
                        $(that).combo('showPanel');
                    }
                });
            }
            textbox.prop(param.stoptype ? param.stoptype : 'disabled', true);
            data.stoptype = param.stoptype ? param.stoptype : 'disabled';
        });
    },
    /**
    * 还原文本域
    * @param {Object} jq
    */
    enableTextbox: function (jq) {
        return jq.each(function () {
            var textbox = $(this).combo("textbox");
            var data = $(this).data('combo');
            if (data.stopArrowFocus) {
                var that = this;
                var panel = $(this).combo("panel");
                var arrowbox = $.data(this, 'combo').combo.find('span.combo-arrow');
                arrowbox.unbind('click.combo').bind('click.combo', function () {
                    if (panel.is(":visible")) {
                        $(that).combo('hidePanel');
                    }
                    else {
                        $("div.combo-panel").panel("close");
                        $(that).combo('showPanel');
                    }
                    textbox.focus();
                });
                textbox.unbind('mousedown.mycombo');
                data.stopArrowFocus = null;
            }
            if (data.activeTextArrow) {
                textbox.unbind('click.mycombo');
                data.activeTextArrow = null;
            }
            textbox.prop(data.stoptype, false);
            data.stoptype = null;
        });
    }
});


//iframe自适应高度
function AdaptiveIframeHeight(frameobj, parentobj) {

//    var frame = parentobj.getElementById("mainFrame");
//    var win = frame.contentWindow,
//    var doc = win.document,
//    var html = doc.documentElement,
//    var body = doc.body;

    // 获取高度 
//    var iframe = parentobj.getElementById("mainFrame");
//    var height = Math.max(iframe.contentWindow.document.body.scrollHeight, iframe.contentWindow.document.body.offsetHeight,
//                       iframe.contentWindow.document.documentElement.clientHeight, iframe.contentWindow.document.documentElement.scrollHeight, iframe.contentWindow.document.documentElement.offsetHeight);

//    alert(iframe.contentWindow.document.body.scrollHeight);
//    alert(iframe.contentWindow.document.body.offsetHeight);
//    alert(iframe.contentWindow.document.documentElement.clientHeight);
//    alert(iframe.contentWindow.document.documentElement.scrollHeight);
//    alert(iframe.contentWindow.document.documentElement.offsetHeight);
    //alert(iframe.contentWindow.document.body.scrollHeight);

    //根据iframe子页面高度调整父窗口高度
    //var iframe = parentobj.getElementById("mainFrame");
    //var bHeight = iframe.contentWindow.document.body.scrollHeight;
    //alert(bHeight);

//    var iframe = parentobj.getElementById("mainFrame");

//    var bHeight = iframe.contentWindow.document.body.scrollHeight;

//    //var pHeight = $(frameobj).height();

//    //var hHeight = iframe.contentWindow.document.documentElement.clientHeight

//    var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;

//    if (bHeight > 300) {

//        dHeight = bHeight;

//    } else {
//        dHeight = bHeight + 730;
//    }

//    $(parentobj).find('iframe').height(dHeight);

}


// Ajax 文件下载
jQuery.download = function (url, data, method) {
    // 获取url和data
    if (url && data) {
        // data 是 string 或者 array/object
        data = typeof data == 'string' ? data : jQuery.param(data);
        // 把参数组装成 form的  input
        var inputs = '';
        jQuery.each(data.split('&'), function () {
            var pair = this.split('=');
            inputs += '<input type="hidden" name="' + pair[0] + '" value="' + pair[1] + '" />';
        });
        // request发送请求
        jQuery('<form action="' + url + '" method="' + (method || 'post') + '">' + inputs + '</form>')
    .appendTo('body').submit().remove();
    };
};

//Easyui Tree方法扩展 - getLevel(获取节点级别)
//var node = $().tree("getSelected");
//var lv = $().tree("getLevel", node.target);
$.extend($.fn.tree.methods, {
    getLevel: function (jq, target) {
        var l = $(target).parentsUntil("ul.tree", "ul");
        return l.length + 1;
    }
});

$.extend($.fn.combotree.methods, {
    getLevel: function (jq, target) {
        var l = $(target).parentsUntil("ul.combotree", "ul");
        return l.length + 1;
    }
});










