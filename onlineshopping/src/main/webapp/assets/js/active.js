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
			case 'Manage Products':
				$('#manageproducts').addClass('active');
				break;
			default: {
				$("#listproducts").addClass('active');
				$('#a_'+menu).addClass('active');
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
					lengthMenu: [ [-1,1,3,5,7],['All','1 Records','3 Records','5 Records','7 Records']],
					ajax :
						{
							url : jsonURL,
							
							dataSrc: ''
						},
					columns:
						[

							{
								data : 'code',
								mRender: function(data,type,row)
								{
									return '<img  src = "'+window.siteURL+'/resources/images/'+data+'.jpg" class="tableImg" />';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender: function(data,type,row)
								{
									return '&#8377; ' + data;
								}
							},
							{
								
								data : 'quantity',
								mRender: function(data,type,row)
								{
									if(data==0)
										{
											return '<span style="color:red">Out of Stock</span>';
										}
									else
										{
											return data;
										}
								}
							},
							{
								data : 'active'
							},
							{
								data: 'id',
								mRender: function(data,type,row)
								{
									
									var str = '';
									str += '<a href ="'+window.siteURL+'/show/'+data+'/product" class="btn btn-success "><span class="glyphicon glyphicon-eye-open"></span> </a> &nbsp ';
									
										if(row.quantity==0)
											{
												str += '<strike><a href="javascript:void(0)" class="btn btn-primary disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a></strike>'
											}
										else
											{
												str += '<a href="'+window.siteURL+'/add/cart/'+data+'/product" class="btn btn-primary "><span class="glyphicon glyphicon-shopping-cart"></span></a>'
			
											}
									
									return str;
								}
							}
							
						]
						
				});
			}
		});