var branah = {};
branah.util = {
	keyCode : function(b) {
		if (!b) {
			var b = window.event;
		}
		if ($.browser.mozilla) {
			var a = b.keyCode;
			switch (a) {
			case 59:
				a = 186;
				break;
			case 107:
				a = 187;
				break;
			case 109:
				a = 189;
				break;
			case 61:
				a = 187;
				break;
			case 173:
				a = 189;
				break;
			}
			return a;
		}
		if ($.browser.opera) {
			var a = b.keyCode;
			switch (a) {
			case 59:
				a = 186;
				break;
			case 61:
				a = 187;
				break;
			case 109:
				a = 189;
				break;
			}
			return a;
		}
		return b.keyCode;
	},
	isCtrl : function(a) {
		if (!a) {
			var a = window.event;
		}
		return a.ctrlKey;
	},
	isAlt : function(a) {
		if (!a) {
			var a = window.event;
		}
		return a.altKey;
	},
	isShift : function(a) {
		if (!a) {
			var a = window.event;
		}
		return a.shiftKey;
	},
	insertAtCaret : function(c, d) {
		
		var f = this.getSelectionStart(c);
		var b = this.getSelectionEnd(c);
		var a = c.value.length;
		c.value = c.value.substring(0, f) + d + c.value.substring(b, a);
		this.setCaretPosition(c, f + d.length, 0);
	},
	deleteAtCaret : function(d, c, g) {
		var h = this.getSelectionStart(d);
		var b = this.getSelectionEnd(d);
		var a = d.value.length;
		if (c > h) {
			c = h;
		}
		if (b + g > a) {
			g = a - b;
		}
		var f = d.value.substring(h - c, b + g);
		d.value = d.value.substring(0, h - c) + d.value.substring(b + g);
		this.setCaretPosition(d, h - c, 0);
		return f;
	},
	getSelectionStart : function(d) {
		d.focus();
		if (d.selectionStart !== undefined) {
			return d.selectionStart;
		} else {
			if (document.selection) {
				var b = document.selection.createRange();
				if (b == null) {
					return 0;
				}
				var a = d.createTextRange();
				var c = a.duplicate();
				a.moveToBookmark(b.getBookmark());
				c.setEndPoint("EndToStart", a);
				return c.text.length;
			}
		}
		return 0;
	},
	getSelectionEnd : function(d) {
		d.focus();
		if (d.selectionEnd !== undefined) {
			return d.selectionEnd;
		} else {
			if (document.selection) {
				var b = document.selection.createRange();
				if (b == null) {
					return 0;
				}
				var a = d.createTextRange();
				var c = a.duplicate();
				a.moveToBookmark(b.getBookmark());
				c.setEndPoint("EndToStart", a);
				return c.text.length + b.text.length;
			}
		}
		return d.value.length;
	},
	setCaretPosition : function(d, f, c) {
		var a = d.value.length;
		if (f > a) {
			f = a;
		}
		if (f + c > a) {
			c = a - c;
		}
		d.focus();
		if (d.setSelectionRange) {
			d.setSelectionRange(f, f + c);
		} else {
			if (d.createTextRange) {
				var b = d.createTextRange();
				b.collapse(true);
				b.moveEnd("character", f + c);
				b.moveStart("character", f);
				b.select();
			}
		}
		d.focus();
	},
	selectAll : function(a) {
		this.setCaretPosition(a, 0, a.value.length);
	}
};
branah.layout = function() {
	this.keys = [];
	this.deadkeys = [];
	this.dir = "ltr";
	this.name = "US";
	this.lang = "en";
};
branah.layout.prototype.loadDefault = function() {
	this.keys = [ {
		i : "k0",
		c : "0",
		n : "`",
		s : "~"
	}, {
		i : "k1",
		c : "0",
		n : "1",
		s : "!"
	}, {
		i : "k2",
		c : "0",
		n : "2",
		s : "@"
	}, {
		i : "k3",
		c : "0",
		n : "3",
		s : "#"
	}, {
		i : "k4",
		c : "0",
		n : "4",
		s : "$"
	}, {
		i : "k5",
		c : "0",
		n : "5",
		s : "%"
	}, {
		i : "k6",
		c : "0",
		n : "6",
		s : "^"
	}, {
		i : "k7",
		c : "0",
		n : "7",
		s : "&"
	}, {
		i : "k8",
		c : "0",
		n : "8",
		s : "*"
	}, {
		i : "k9",
		c : "0",
		n : "9",
		s : "("
	}, {
		i : "k10",
		c : "0",
		n : "0",
		s : ")"
	}, {
		i : "k11",
		c : "0",
		n : "-",
		s : "_"
	}, {
		i : "k12",
		c : "0",
		n : "=",
		s : "+"
	}, {
		i : "k13",
		c : "1",
		n : "q",
		s : "Q"
	}, {
		i : "k14",
		c : "1",
		n : "w",
		s : "W"
	}, {
		i : "k15",
		c : "1",
		n : "e",
		s : "E"
	}, {
		i : "k16",
		c : "1",
		n : "r",
		s : "R"
	}, {
		i : "k17",
		c : "1",
		n : "t",
		s : "T"
	}, {
		i : "k18",
		c : "1",
		n : "y",
		s : "Y"
	}, {
		i : "k19",
		c : "1",
		n : "u",
		s : "U"
	}, {
		i : "k20",
		c : "1",
		n : "i",
		s : "I"
	}, {
		i : "k21",
		c : "1",
		n : "o",
		s : "O"
	}, {
		i : "k22",
		c : "1",
		n : "p",
		s : "P"
	}, {
		i : "k23",
		c : "0",
		n : "[",
		s : "{"
	}, {
		i : "k24",
		c : "0",
		n : "]",
		s : "}"
	}, {
		i : "k25",
		c : "0",
		n : "\\",
		s : "|"
	}, {
		i : "k26",
		c : "1",
		n : "a",
		s : "A"
	}, {
		i : "k27",
		c : "1",
		n : "s",
		s : "S"
	}, {
		i : "k28",
		c : "1",
		n : "d",
		s : "D"
	}, {
		i : "k29",
		c : "1",
		n : "f",
		s : "F"
	}, {
		i : "k30",
		c : "1",
		n : "g",
		s : "G"
	}, {
		i : "k31",
		c : "1",
		n : "h",
		s : "H"
	}, {
		i : "k32",
		c : "1",
		n : "j",
		s : "J"
	}, {
		i : "k33",
		c : "1",
		n : "k",
		s : "K"
	}, {
		i : "k34",
		c : "1",
		n : "l",
		s : "L"
	}, {
		i : "k35",
		c : "0",
		n : ";",
		s : ":"
	}, {
		i : "k36",
		c : "0",
		n : "'",
		s : '"'
	}, {
		i : "k37",
		c : "1",
		n : "z",
		s : "Z"
	}, {
		i : "k38",
		c : "1",
		n : "x",
		s : "X"
	}, {
		i : "k39",
		c : "1",
		n : "c",
		s : "C"
	}, {
		i : "k40",
		c : "1",
		n : "v",
		s : "V"
	}, {
		i : "k41",
		c : "1",
		n : "b",
		s : "B"
	}, {
		i : "k42",
		c : "1",
		n : "n",
		s : "N"
	}, {
		i : "k43",
		c : "1",
		n : "m",
		s : "M"
	}, {
		i : "k44",
		c : "0",
		n : ",",
		s : "<"
	}, {
		i : "k45",
		c : "0",
		n : ".",
		s : ">"
	}, {
		i : "k46",
		c : "0",
		n : "/",
		s : "?"
	}, {
		i : "k47",
		c : "0",
		n : "\\",
		s : "|"
	} ];
	this.dir = "ltr";
	this.name = "US";
	this.lang = "en";
};
branah.layout.prototype.load = function(a) {
	this.keys = a.keys;
	this.deadkeys = a.deadkeys;
	this.dir = a.dir;
	this.name = a.name;
	this.lang = a.lang ? a.lang : "en";
};
branah.ajaxSyncRequest = function(str)
{
	
	// Creating a new XMLHttpRequest object
	var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest(); // for IE7+, Firefox, Chrome, Opera,
										// Safari
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); // for IE6, IE5
	}
	
	// Create a asynchronous GET request
	xmlhttp.open("GET", "get-transliterate?trans=" + str, false);
	xmlhttp.send(null);
	
	// Execution blocked till server send the response
	if (xmlhttp.readyState == 4) { 
		if (xmlhttp.status == 200) 
		{
			return xmlhttp.responseText;
			// document.getElementById("message").innerHTML =
			// xmlhttp.responseText;
			// alert(xmlhttp.responseText);
		} 
		else
		{
			alert('Something is wrong !!');
		}
	}
};
branah.layout.parser = {
	keyCodes : [ 192, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 189, 187, 81, 87,
			69, 82, 84, 89, 85, 73, 79, 80, 219, 221, 220, 65, 83, 68, 70, 71,
			72, 74, 75, 76, 186, 222, 90, 88, 67, 86, 66, 78, 77, 188, 190,
			191, 220 ],
	getKeyCode : function(d, b, e) {
		var a = d.length;
		for ( var c = 0; c < a; c++) {
			if (d[c].i == e) {
				return b == 1 ? (d[c].s ? d[c].s : "") : (d[c].n ? d[c].n : "");
			}
		}
		return 0;
	},
	getKey : function(c, d) {
		var a = c.length;
		for ( var b = 0; b < a; b++) {
			if (c[b].i == d) {
				return c[b];
			}
		}
		return null;
	},
	isDeadkey : function(b, d) {
		if (!b) {
			return false;
		}
		var a = b.length;
		for ( var c = 0; c < a; c++) {
			if (b[c].k == d) {
				return true;
			}
		}
		return false;
	},
	getMappedValue : function(b, e, d) {
		if (!b) {
			return "";
		}
		
		var a = b.length;
		for ( var c = 0; c < a; c++) {
			if (b[c].k == d && b[c].b == e) {
				return b[c].c;
			}
		}
		return "";
	},
	getKeyId : function(b) {
		for ( var a = 0; a < 48; a++) {
			if (this.keyCodes[a] == b) {
				return a;
			}
		}
		return -1;
	},
	getState : function(d, f, a, b, e) {
		var c = "n";
		if (!f && !a && d) {
			c = "n";
		} else {
			if (!f && a && !d) {
				c = "s";
			} else {
				if (!f && a && d) {
					c = "s";
				} else {
					if (f && !a && !d) {
						c = "n";
					} else {
						if (f && !a && d) {
							c = "t";
						} else {
							if (f && a && !d) {
								c = "s";
							} else {
								if (f && a && d) {
									c = "f";
								}
							}
						}
					}
				}
			}
		}
		if ((c == "n" || c == "s") && b) {
			if (e == "1") {
				if (c == "n") {
					c = "s";
				} else {
					c = "n";
				}
			}
			if (e == "SGCap") {
				if (c == "n") {
					c = "y";
				} else {
					if (c == "s") {
						c = "z";;
					}
				}
			}
		}
		return c;
	}
};
branah.keyboard = function(a, b) {
	

	this.defaultLayout = new branah.layout();
	this.defaultLayout.loadDefault();
	this.virtualLayout = new branah.layout();
	this.virtualLayout.loadDefault();
	this.currentLayout = this.virtualLayout;
	this.shift = false;
	this.caps = false;
	this.transliterate = false;
	this.alt = false;
	this.ctrl = false;
	this.trans = "";
	this.counter = 0;
	this.interval = 0;
	this.prev = "";
	this.cancelkeypress = false;
	this.customOnBackspace = function(e) {
	};
	this.customOnEnter = function() {
	};
	this.customOnSpace = function() {
		return false;
	};
	this.customOnKey = function(e) {
		return false;
	};
	this.customOnEsc = function() {
	};
	this.customDrawKeyboard = function(e) {
		return e;
	};
	this.textbox = $("#" + b);
	this.nativeTextbox = document.getElementById(b);
	var d = [ '<div id="branah-keyboard">' ];
	for ( var c = 0; c < 13; c++) {
		d.push('<button id="branah-k', c, '" class="branah-key"></button>');
	}
	d.push('<button id="branah-backspace"><span>Backspace</span></button>');
	d.push('<div class="branah-clear"></div>');
	d.push('<button id="branah-tab"><span>Tab</span></button>');
	for ( var c = 13; c < 25; c++) {
		d.push('<button id="branah-k', c, '" class="branah-key"></button>');
	}
	d.push('<button id="branah-k25"></button>');
	d.push('<div class="branah-clear"></div>');
	d.push('<button id="branah-caps-lock"><span>Caps Lock</span></button>');
	for ( var c = 26; c < 37; c++) {
		d.push('<button id="branah-k', c, '" class="branah-key"></button>');
	}
	d
			.push('<button id="branah-enter" class="branah-enter"><span>Enter</span></button>');
	d.push('<div class="branah-clear"></div>');
	d.push('<button id="branah-left-shift"><span>Shift</span></button>');
	d.push('<button id="branah-k47" class="branah-key"></button>');
	for ( var c = 37; c < 47; c++) {
		d.push('<button id="branah-k', c, '" class="branah-key"></button>');
	}
	d.push('<button id="branah-right-shift"><span>Shift</span></button>');
	d.push('<div class="branah-clear"></div>');
	d.push('<button id="branah-left-ctrl"><span>Ctrl</span></button>');
	d.push('<button id="branah-transliterate"><span>Transliterate</span></button>');
	// d.push('<button id="branah-left-alt"><span>Alt</span></button>');
	d.push('<button id="branah-space"><span>Space</span></button>');
	d.push('<button id="branah-right-alt"><span>Alt</span></button>');
	d
			.push('<button id="branah-escape" title="Turn on/off keyboard input conversion"><span>Esc</span></button>');
	d.push('<button id="branah-right-ctrl"><span>Ctrl</span></button>');
	d.push('<div class="branah-clear"></div>');
	d.push("</div>");
	document.getElementById(a).innerHTML = d.join("");
	this.wireEvents();
	this.drawKeyboard();
};
branah.keyboard.prototype.loadDefaultLayout = function(a) {
	this.defaultLayout.load(a);
	this.drawKeyboard();
};
branah.keyboard.prototype.loadVirtualLayout = function(a) {
	this.virtualLayout.load(a);
	this.drawKeyboard();
	this.textbox.attr("dir", this.attr("dir"));
};
branah.keyboard.prototype.switchLayout = function() {
	this.currentLayout = (this.currentLayout === this.defaultLayout) ? this.virtualLayout
			: this.defaultLayout;
	this.reset();
	this.drawKeyboard();
	this.textbox.attr("dir", this.attr("dir"));
};
branah.keyboard.prototype.onEsc = function() {
	this.switchLayout();
	this.customOnEsc();
};
branah.keyboard.prototype.onTransliterate = function() {
	this.transliterate = !this.transliterate;
	this.switchLayout();
	// this.drawKeyboard();
};
branah.keyboard.prototype.onShift = function() {
	this.shift = !this.shift;
	this.drawKeyboard();
};
branah.keyboard.prototype.onAlt = function() {
	this.alt = !this.alt;
	this.drawKeyboard();
};
branah.keyboard.prototype.onCtrl = function() {
	this.ctrl = !this.ctrl;
	this.drawKeyboard();
};
branah.keyboard.prototype.onCapsLock = function() {
	this.caps = !this.caps;
	this.drawKeyboard();
};
branah.keyboard.prototype.onBackspace = function() {
	
	if (this.prev != "") {
		this.prev = "";
		this.shift = false;
		this.drawKeyboard();
	} else {
		var a = branah.util.deleteAtCaret(this.nativeTextbox, 1, 0);
		if(this.transliterate){
			
			this.trans = this.trans.substring(0, this.trans.length-1);
			
		}
		this.customOnBackspace(a);
	}
};
branah.keyboard.prototype.onEnter = function() {
	if(this.transliterate){ this.trans = ""; }// this.nativeTextbox.value=
												// this.nativeTextbox.value
												// +"\u000A";}
	branah.util.insertAtCaret(this.nativeTextbox, "\u000A");
	this.customOnEnter();
};
branah.keyboard.prototype.onSpace = function() {
	if (!this.customOnSpace()) {
		if(this.transliterate) this.trans = this.trans +" ";
		branah.util.insertAtCaret(this.nativeTextbox, "\u0020");
	}
};
branah.keyboard.prototype.attr = function(a) {
	if (a == "dir") {
		return this.currentLayout.dir;
	} else {
		if (a == "lang") {
			return this.currentLayout.lang;
		} else {
			if (a == "name") {
				return this.currentLayout.name;
			}
		}
	}
	return "";
};
branah.keyboard.prototype.reset = function() {
	this.shift = false;
	this.caps = false;
	this.alt = false;
	this.ctrl = false;
	this.trans = "";
	// this.transliterate = false;
	this.counter = 0;
	this.interval = 0;
	this.prev = "";
};
branah.keyboard.prototype.stopRepeat = function() {
	if (this.interval != 0) {
		clearInterval(this.interval);
		this.counter = 0;
		this.interval = 0;
	}
};
branah.keyboard.prototype.onKey = function(e) {
	var b = branah.layout.parser.getKey(this.currentLayout.keys, e);
	if (b) {
		
		var d = branah.layout.parser.getState(this.ctrl, this.alt, this.shift,
				this.caps, b.c ? b.c : "0");
		var c = b[d] ? b[d] : "";
		if (this.prev != "") {
			
			var a = branah.layout.parser.getMappedValue(
					this.currentLayout.deadkeys, c, this.prev);
			if (a != "") {
				branah.util.insertAtCaret(this.nativeTextbox, a);
			}
			this.prev = "";
		} else {
			
			if (branah.layout.parser.isDeadkey(this.currentLayout.deadkeys, c)) {
				this.prev = c;
			} else {
				if (c != "") {
					if (!this.customOnKey(c)) {
						if(this.transliterate){
							this.trans = this.trans + c;
							// alert(this.trans);
							// branah.util.deleteAtCaret(this.nativeTextbox,
							// this.trans.length, 0);
							var tran = branah.ajaxSyncRequest(this.trans);
							//this.nativeTextbox.value = this.nativeTextbox.value.replace(tran, "");
							this.nativeTextbox.value = tran;
							// this.nativeTextbox.value =
							// this.nativeTextbox.value.substring(0,
							// this.nativeTextbox.length-this.trans.length) +
							// tran;
							// branah.util.insertAtCaret(this.nativeTextbox,
							// branah.ajaxSyncRequest(this.trans));
						}
						else
						{
							branah.util.insertAtCaret(this.nativeTextbox, c);
						}
					}
				}
			}
		}
	}
};

branah.util.getUTF8Length= function(string) {
    var utf8length = 0;
    for (var n = 0; n < string.length; n++) {
        var c = string.charCodeAt(n);
        if (c < 128) {
            utf8length++;
        }
        else if((c > 127) && (c < 2048)) {
            utf8length = utf8length+2;
        }
        else {
            utf8length = utf8length+3;
        }
    }
    return utf8length;
 };

branah.keyboard.prototype.drawKeyboard = function() {
	if (!this.currentLayout.keys) {
		return
	}
	var d, c, f, e;
	var a = this.currentLayout.keys.length;
	for ( var b = 0; b < a; b++) {
		c = this.currentLayout.keys[b];
		if (!$("branah-" + c.i)) {
			continue;
		}
		f = branah.layout.parser.getState(this.ctrl, this.alt, this.shift,
				this.caps, c.c ? c.c : "0");
		e = c[f] ? c[f] : "";
		if (this.prev != "") {
			e = branah.layout.parser.getMappedValue(
					this.currentLayout.deadkeys, e, this.prev);
		}
		if (!this.shift) {
			e = this.customDrawKeyboard(e);
			if (e == "") {
				e = "&nbsp;";
			}
			d = '<div class="branah-label-reference">'
					+ branah.layout.parser.getKeyCode(this.defaultLayout.keys,
							0, c.i)
					+ '</div><div class="branah-label-natural">' + e + "</div>";
		} else {
			if (e == "") {
				e = "&nbsp;";
			}
			d = '<div class="branah-label-reference">'
					+ branah.layout.parser.getKeyCode(this.defaultLayout.keys,
							0, c.i) + '</div><div class="branah-label-shift">'
					+ e + "</div>";
		}
		document.getElementById("branah-" + c.i).innerHTML = d;
	}
	if (this.ctrl) {
		$("#branah-left-ctrl").addClass("branah-recessed");
		$("#branah-right-ctrl").addClass("branah-recessed");
	} else {
		$("#branah-left-ctrl").removeClass("branah-recessed");
		$("#branah-right-ctrl").removeClass("branah-recessed");
	}
	if (this.alt) {
		$("#branah-left-alt").addClass("branah-recessed");
		$("#branah-right-alt").addClass("branah-recessed");
	} else {
		$("#branah-left-alt").removeClass("branah-recessed");
		$("#branah-right-alt").removeClass("branah-recessed");
	}
	if (this.shift) {
		$("#branah-left-shift").addClass("branah-recessed");
		$("#branah-right-shift").addClass("branah-recessed");
	} else {
		$("#branah-left-shift").removeClass("branah-recessed");
		$("#branah-right-shift").removeClass("branah-recessed");
	}
	if (this.transliterate) {
		$("#branah-transliterate").addClass("branah-recessed");
	} else {
		$("#branah-transliterate").removeClass("branah-recessed");
	}
	if (this.caps) {
		$("#branah-caps-lock").addClass("branah-recessed");
	} else {
		$("#branah-caps-lock").removeClass("branah-recessed");
	}
};
branah.keyboard.prototype.wireEvents = function() {
	var a = this;
	$("#branah-keyboard")
			.delegate(
					"button",
					"mousedown",
					function(c) {
						var b = this.id;
						a.interval = setInterval(
								function() {
									a.counter++;
									if (a.counter > 5) {
										switch (b) {
										case "branah-backspace":
											a.onBackspace();
											break;
										default:
											if (b
													.search("branah-k([0-9])|([1-3][0-9])|(4[0-7])") != -1) {
												a.onKey(b.substr(7));
												a.shift = false;
												a.alt = false;
												a.ctrl = false;
												a.drawKeyboard();
											}
											break;
										}
									}
								}, 50);
					});
	$("#branah-keyboard").delegate("button", "mouseup", function(b) {
		a.stopRepeat();
	});
	$("#branah-keyboard").delegate("button", "mouseout", function(b) {
		a.stopRepeat();
	});
	$("#branah-keyboard").delegate("button", "click", function(c) {
		var b = this.id;
		switch (b) {
		case "branah-left-shift":
		case "branah-right-shift":
			a.onShift();
			break;
		case "branah-left-alt":
		case "branah-right-alt":
			a.onCtrl();
			a.onAlt();
			break;
		case "branah-left-ctrl":
		case "branah-right-ctrl":
			a.onAlt();
			a.onCtrl();
			break;
		case "branah-escape":
			a.onEsc();
			break;
		case "branah-transliterate":
			a.onTransliterate();
			break;
		case "branah-caps-lock":
			a.onCapsLock();
			break;
		case "branah-backspace":
			a.onBackspace();
			break;
		case "branah-enter":
			a.onEnter();
			break;
		case "branah-space":
			a.onSpace();
			break;
		default:
			if (b.search("branah-k([0-9])|([1-3][0-9])|(4[0-7])") != -1) {
				a.onKey(b.substr(7));
				a.shift = false;
				a.alt = false;
				a.ctrl = false;
				a.drawKeyboard();
			}
			break;
		}
	});
	a.textbox.bind("keydown", function(d) {
		
		var c = branah.util.keyCode(d);
		
		if ((c == 65 || c == 67 || c == 86 || c == 88 || c == 89 || c == 90)
				&& (a.ctrl && !a.alt && !a.shift)) {
			
			return
		}
		if (a.currentLayout == a.defaultLayout && c != 27) {
		switch(c){
		case 8:
			a.onBackspace();
			d.preventDefault();
			break;
		case 32:
			a.onSpace();
			d.preventDefault();
			break;
		case 10:
			a.onEnter();
			d.preventDefault();
			break;
		}
			if(a.transliterate && (c>=65 && c<=90)) {
				var keycode = d.keyCode;
				if(!a.shift) keycode = keycode +32;  
				a.trans = a.trans + String.fromCharCode(keycode);
				var tran = branah.ajaxSyncRequest(a.trans);
				a.nativeTextbox.value = tran;
				d.preventDefault();
			}
			
			return
		}
		
		switch (c) {
		case 17:
			a.ctrl = false;
			a.onCtrl();
			break;
		case 18:
			a.alt = false;
			a.onAlt();
			break;
		case 16:
			a.shift = false;
			a.onShift();
			break;
		case 27:
			a.onEsc();
			break;
		case 8:
			a.onBackspace();
			d.preventDefault();
			break;
		case 32:
			a.onSpace();
			d.preventDefault();
			break;
		case 10:
			a.onEnter();
			d.preventDefault();
			break;
		default:
		
			var b = branah.layout.parser.getKeyId(branah.util.keyCode(d));
		
			if (b != -1) {
				a.onKey("k" + b);
				a.drawKeyboard();
				d.preventDefault();
				a.cancelkeypress = true;
			}
			break;
		}
	});
	if ($.browser.opera) {
		a.textbox.bind("keypress", function(b) {
			if (a.cancelkeypress) {
				b.preventDefault();
				a.cancelkeypress = false;
			}
		});
	}
	a.textbox.bind("keyup", function(b) {
		
		switch (branah.util.keyCode(b)) {
		case 17:
			a.ctrl = true;
			a.onCtrl();
			break;
		case 18:
			a.alt = true;
			a.onAlt();
			break;
		case 16:
			a.shift = true;
			a.onShift();
			break;
		default:
		}
	});
};
var keyboard = null;
function showKeyboard () {
	/*keyboard = new branah.keyboard("keyboard","editor");*/
	keyboard = new branah.keyboard("virtualKBDiv", "inputTextArea");
	//alert("called");
	var a = {
		name : "Devanagari - INSCRIPT",
		dir : "ltr",
		keys : [ {
			i : "k1",
			c : "0",
			n : "1",
			s : "\u090d",
			t : "\u0967"
		}, {
			i : "k2",
			c : "0",
			n : "2",
			s : "\u0945",
			t : "\u0968"
		}, {
			i : "k3",
			c : "0",
			n : "3",
			t : "\u0969"
		}, {
			i : "k4",
			c : "0",
			n : "4",
			t : "\u096a"
		}, {
			i : "k5",
			c : "0",
			n : "5",
			t : "\u096b"
		}, {
			i : "k6",
			c : "0",
			n : "6",
			t : "\u096c"
		}, {
			i : "k7",
			c : "0",
			n : "7",
			t : "\u096d"
		}, {
			i : "k8",
			c : "0",
			n : "8",
			t : "\u096e"
		}, {
			i : "k9",
			c : "0",
			n : "9",
			s : "(",
			t : "\u096f"
		}, {
			i : "k10",
			c : "0",
			n : "0",
			s : ")",
			t : "\u0966"
		}, {
			i : "k11",
			c : "0",
			n : "-",
			s : "\u0903"
		}, {
			i : "k12",
			c : "0",
			n : "\u0943",
			s : "\u090b",
			t : "\u0944"
		}, {
			i : "k13",
			c : "0",
			n : "\u094c",
			s : "\u0914"
		}, {
			i : "k14",
			c : "0",
			n : "\u0948",
			s : "\u0910"
		}, {
			i : "k15",
			c : "0",
			n : "\u093e",
			s : "\u0906"
		}, {
			i : "k16",
			c : "0",
			n : "\u0940",
			s : "\u0908",
			t : "\u0963"
		}, {
			i : "k17",
			c : "0",
			n : "\u0942",
			s : "\u090a"
		}, {
			i : "k18",
			c : "0",
			n : "\u092c",
			s : "\u092d"
		}, {
			i : "k19",
			c : "0",
			n : "\u0939",
			s : "\u0919"
		}, {
			i : "k20",
			c : "0",
			n : "\u0917",
			s : "\u0918",
			t : "\u095a"
		}, {
			i : "k21",
			c : "0",
			n : "\u0926",
			s : "\u0927"
		}, {
			i : "k22",
			c : "0",
			n : "\u091c",
			s : "\u091d",
			t : "\u095b"
		}, {
			i : "k23",
			c : "0",
			n : "\u0921",
			s : "\u0922",
			t : "\u095c"
		}, {
			i : "k24",
			c : "0",
			n : "\u093c",
			s : "\u091e"
		}, {
			i : "k26",
			c : "0",
			n : "\u094b",
			s : "\u0913"
		}, {
			i : "k27",
			c : "0",
			n : "\u0947",
			s : "\u090f"
		}, {
			i : "k28",
			c : "0",
			n : "\u094d",
			s : "\u0905"
		}, {
			i : "k29",
			c : "0",
			n : "\u093f",
			s : "\u0907",
			t : "\u0962"
		}, {
			i : "k30",
			c : "0",
			n : "\u0941",
			s : "\u0909"
		}, {
			i : "k31",
			c : "0",
			n : "\u092a",
			s : "\u092b"
		}, {
			i : "k32",
			c : "0",
			n : "\u0930",
			s : "\u0931"
		}, {
			i : "k33",
			c : "0",
			n : "\u0915",
			s : "\u0916",
			t : "\u0958"
		}, {
			i : "k34",
			c : "0",
			n : "\u0924",
			s : "\u0925"
		}, {
			i : "k35",
			c : "0",
			n : "\u091a",
			s : "\u091b",
			t : "\u0952"
		}, {
			i : "k36",
			c : "0",
			n : "\u091f",
			s : "\u0920"
		}, {
			i : "k0",
			c : "0",
			n : "\u094a",
			s : "\u0912"
		}, {
			i : "k25",
			c : "0",
			n : "\u0949",
			s : "\u0911"
		}, {
			i : "k37",
			c : "0",
			n : "\u0946",
			s : "\u090e",
			t : "\u0953"
		}, {
			i : "k38",
			c : "0",
			n : "\u0902",
			s : "\u0901"
		}, {
			i : "k39",
			c : "0",
			n : "\u092e",
			s : "\u0923",
			t : "\u0954"
		}, {
			i : "k40",
			c : "0",
			n : "\u0928",
			s : "\u0929"
		}, {
			i : "k41",
			c : "0",
			n : "\u0935",
			s : "\u0934"
		}, {
			i : "k42",
			c : "0",
			n : "\u0932",
			s : "\u0933"
		}, {
			i : "k43",
			c : "0",
			n : "\u0938",
			s : "\u0936"
		}, {
			i : "k44",
			c : "0",
			n : ",",
			s : "\u0937",
			t : "\u0970"
		}, {
			i : "k45",
			c : "0",
			n : ".",
			s : "\u0964",
			t : "\u0965"
		}, {
			i : "k46",
			c : "0",
			n : "\u092f",
			s : "\u095f"
		}, {
			i : "k47",
			c : "0",
			n : "\u0949",
			s : "\u0911"
		} ],
		deadkeys : []
	};
	keyboard.loadVirtualLayout(a);
	$("#page").attr("lang", "en");
	$("#inputTextArea").attr("dir", keyboard.attr("dir"));
	$("#inputTextArea").focus();
}
