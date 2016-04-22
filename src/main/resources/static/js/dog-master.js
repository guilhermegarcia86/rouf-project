$('#dialogExclusao').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	var idCachorro = button.data('codigo');
	var nomeCachorro = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if(!action.endsWith('/')){
		action += '/';
	}
	
	form.attr('action', action + idCachorro);
	modal.find('.modal-body span').html('Tem certeza que deseja exlcuir o registro <strong>' + nomeCachorro + '</strong>?');
});

$(function() {
	$('[rel="tooltip"]').tooltip();
});