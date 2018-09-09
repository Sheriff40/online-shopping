$(document).ready(
		function() {

			switch (window.menu) {

			case 'home':
				$('#home').addClass('active');
				break;
			case 'about':

				$("#about").addClass('active');
				break;
			case 'contact':
				$("#contact").addClass('active');
				break;
			default: {
				$("#listproducts").addClass('active');
				$('#a_' + menu).addClass('active');
				break;
			}

			}

			

			$table = $('#listProductTable');
			if ($table.length) {
				var jsonURL = '';
				if(window.categoryId=='')
					{
						
						jsonURL = window.siteURL + '/json/data/all/products';
					}
				else
					{
						
						jsonURL = window.siteURL + '/json/data/category/'+ window.categoryId +'/products';
						
					}
				$table.DataTable({
					
					ajax :
						{
							url : jsonURL,
							dataSrc: ''
						},
					columns:
						[
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice'
							},
							{
								data : 'active'
							}
						]
						
				});
			}
		});