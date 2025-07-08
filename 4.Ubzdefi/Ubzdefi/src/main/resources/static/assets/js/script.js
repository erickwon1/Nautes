$(document).ready(function() {
  // 체크박스 변경 이벤트 핸들러
  $('.form-check-input').change(function() {
    const isChecked = $(this).prop('checked');
    if (isChecked) {
      $(this).closest('tr').addClass('table-primary');
    } else {
      $(this).closest('tr').removeClass('table-primary'); 
    }
  });
  $('.form-check-input').each(function() {
      const isChecked = $(this).prop('checked');
      if (isChecked) {
          $(this).closest('tr').addClass('table-primary');
      }
  });
  // 테이블 수정 모달 활성화
  $('.table_modify_on tbody tr').dblclick(function(){
    $('#modify_modal').modal('show');
  });
    // 모달 z-index값 조정
    $(document).on('show.bs.modal', '.modal', function(event) {
        var zIndex = 1040 + (10 * $('.modal:visible').length);
        $(this).css('z-index', zIndex);
        setTimeout(function() {
        $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');
        }, 0);
    });
});