/**
* 向上移动选中的option
*/
function upSelectedOption(){
	if(null == $('#where').val()){
		alert('请选择一项');
		return false;
	}
	//选中的索引,从0开始
	var optionIndex = $('#where').get(0).selectedIndex;
	//如果选中的不在最上面,表示可以移动
	if(optionIndex > 0){
		$('#where option:selected').insertBefore($('#where option:selected').prev('option'));
	}
}

/**
* 向下移动选中的option
*/
function downSelectedOption(){
	if(null == $('#where').val()){
		alert('请选择一项');
		return false;
	}
	//索引的长度,从1开始
	var optionLength = $('#where')[0].options.length;
	//选中的索引,从0开始
	var optionIndex = $('#where').get(0).selectedIndex;
	//如果选择的不在最下面,表示可以向下
	if(optionIndex < (optionLength-1)){
		$('#where option:selected').insertAfter($('#where option:selected').next('option'));
	}
}

/**
* 移除选中的option
*/
function removeSelectedOption(){
	if(null == $('#where').val()){
		alert('请选择一项');
		return false;
	}
	$('#where option:selected').remove();
}

/**
* 获取所有的option值
*/
function getSelectedOption(){
	//获取Select选择的Text
	var checkText = $('#where').find('option:selected').text();
	//获取Select选择的Value
	var checkValue = $('#where').val();
	alert('当前被选中的text=' + checkText + ', value=' + checkValue);
	var ids = '';
	var options = $('#where')[0].options;
	for(var i=0; i<options.length; i++){
		ids = ids + '`' + options[i].id;
	}
	alert('当前被选中的编号顺序为' + ids);
}

/**
* 添加option
*/
function addSelectedOption(){
	//添加在第一个位置
	$('#where').prepend('<option value="hbin" id="where06">Haerbin</option>');
	//添加在最后一个位置
	$('#where').append('<option value="hlj" id="where07">HeiLongJiang</option>');
	$('#where').attr('size', 7);
}

