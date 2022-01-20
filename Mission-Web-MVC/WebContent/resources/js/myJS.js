/**
 * 내가 만든 함수들
 */


// Form에서 입력데이터 유무체크
function isNull(obj, msg) {
		if(obj.value =='') {
			alert(msg)
			obj.focus()
			return true
		}
		return false
	}