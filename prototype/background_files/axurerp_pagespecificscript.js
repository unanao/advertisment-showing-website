
var PageName = 'background';
var PageId = 'p7573602c7eb64185a201d1779dd694eb'
var PageUrl = 'background.html'
document.title = 'background';

if (top.location != self.location)
{
	if (parent.HandleMainFrameChanged) {
		parent.HandleMainFrameChanged();
	}
}

var $OnLoadVariable = '';

var $CSUM;

var hasQuery = false;
var query = window.location.hash.substring(1);
if (query.length > 0) hasQuery = true;
var vars = query.split("&");
for (var i = 0; i < vars.length; i++) {
    var pair = vars[i].split("=");
    if (pair[0].length > 0) eval("$" + pair[0] + " = decodeURIComponent(pair[1]);");
} 

if (hasQuery && $CSUM != 1) {
alert('Prototype Warning: Variable values were truncated.');
}

function GetQuerystring() {
    return '#OnLoadVariable=' + encodeURIComponent($OnLoadVariable) + '&CSUM=1';
}

function PopulateVariables(value) {
  value = value.replace(/\[\[OnLoadVariable\]\]/g, $OnLoadVariable);
  value = value.replace(/\[\[PageName\]\]/g, PageName);
  return value;
}

function OnLoad() {

}

var u16 = document.getElementById('u16');

var u7 = document.getElementById('u7');

var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u2 = document.getElementById('u2');
gv_vAlignTable['u2'] = 'top';
var u19 = document.getElementById('u19');

var u13 = document.getElementById('u13');
gv_vAlignTable['u13'] = 'top';
var u22 = document.getElementById('u22');
gv_vAlignTable['u22'] = 'center';
var u12 = document.getElementById('u12');
gv_vAlignTable['u12'] = 'top';
var u5 = document.getElementById('u5');

var u8 = document.getElementById('u8');
gv_vAlignTable['u8'] = 'top';
var u10 = document.getElementById('u10');
gv_vAlignTable['u10'] = 'top';
var u0 = document.getElementById('u0');

var u21 = document.getElementById('u21');

var u17 = document.getElementById('u17');

var u3 = document.getElementById('u3');

var u23 = document.getElementById('u23');

var u14 = document.getElementById('u14');

var u6 = document.getElementById('u6');
gv_vAlignTable['u6'] = 'top';
var u9 = document.getElementById('u9');

var u20 = document.getElementById('u20');
gv_vAlignTable['u20'] = 'center';
var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'top';
var u18 = document.getElementById('u18');

var u24 = document.getElementById('u24');

var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
if (window.OnLoad) OnLoad();
