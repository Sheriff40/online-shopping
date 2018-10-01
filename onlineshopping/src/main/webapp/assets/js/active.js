$(document)
		.ready(
				function() {

					/* Activation of menus */
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
						$('#a_' + menu).addClass('active');
						break;
					}

					}

					/* View products data table */
					$table = $('#listProductTable');
					if ($table.length) {
						var jsonURL = '';
						if (window.categoryId == '') {

							jsonURL = window.siteURL
									+ '/json/data/all/products';
						} else {

							jsonURL = window.siteURL + '/json/data/category/'
									+ window.categoryId + '/products';

						}
						$table
								.DataTable({
									lengthMenu : [
											[ -1, 1, 3, 5, 7 ],
											[ 'All', '1 Records', '3 Records',
													'5 Records', '7 Records' ] ],
									ajax : {
										url : jsonURL,

										dataSrc : ''
									},
									columns : [
											{
												data : 'id'
											},

											{
												data : 'code',
												mRender : function(data, type,
														row) {
													return '<img  src = "'
															+ window.siteURL
															+ '/resources/images/'
															+ data
															+ '.jpg" class="tableImg" />';
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
												mRender : function(data, type,
														row) {
													return '&#8377; ' + data;
												}
											},
											{

												data : 'quantity',
												mRender : function(data, type,
														row) {
													if (data == 0) {
														return '<span style="color:red">Out of Stock</span>';
													} else {
														return data;
													}
												}
											},
											{
												data : 'active'
											},
											{
												data : 'id',
												mRender : function(data, type,
														row) {

													var str = '';
													str += '<a href ="'
															+ window.siteURL
															+ '/show/'
															+ data
															+ '/product" class="btn btn-success btn-xs "><span class="glyphicon glyphicon-eye-open"></span> </a> &nbsp ';

													if (row.quantity == 0) {
														str += '<strike><a href="javascript:void(0)" class="btn btn-primary btn-xs disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a></strike>'
													} else {
														str += '<a href="'
																+ window.siteURL
																+ '/add/cart/'
																+ data
																+ '/product" class="btn btn-primary btn-xs "><span class="glyphicon glyphicon-shopping-cart"></span></a>'

													}

													return str;
												}
											}

									]

								});
					}

					/* Alert Fade Out */

					var $alert = $('.alert');
					if ($alert.length) {
						setTimeout(function() {
							$alert.fadeOut('slow');
						}, 3000)

					}

					/* For Activation of checbox */

					$(".switch input[type = 'checkbox']")
							.on(
									'change',
									function() {

										var checkbox = $(this);
										var checked = checkbox.prop('checked');

										var dmsg = (checked) ? "Are you sure you want to activate"
												: "Are you sure you want to deactivate?";
										var val = checkbox.prop('value');

										var value = confirm(dmsg)
										if (value) {
											alert('Modifications have been made to '
													+ val);
										} else {
											checkbox.prop('checked', !checked);

										}

									});

					/* Admin Table for admin */

					var adminTable = $("#adminProductTable");
					if (adminTable.length) {

						adminTable
								.DataTable({
									lengthMenu : [
											[ -1, 2, 5, 7, 10 ],
											[ 'All', 'Two records',
													'Five Records',
													'Seven Recoreds',
													'Ten Records' ] ],
									ajax : {
										url : window.siteURL
												+ '/json/data/admin/all/products',

										dataSrc : ''
									},
									columns : [

											{
												data : 'id'
											},
											{
												data : 'code',
												mRender : function(data, type,
														row) {
													var str = '';
													str += '<img src = "'
															+ window.siteURL
															+ '/resources/images/'
															+ data
															+ '.jpg " class="tableImg"/>';
													return str;
												}
											},
											{
												data : 'name',

											},
											{
												data : 'brand',

											},
											{
												data : 'unitPrice',
												mRender : function(data, type,
														row) {
													return '&#8377;' + data;
												}

											},
											{
												data : 'quantity',

											},
											{
												data : 'active',
												mRender : function(data, type,
														row) {
													var str = '';
													if (data) {
														str += "<div class = 'switch'>"
														str += "<input type = 'checkbox' value = "
																+ row.id
																+ " checked = 'checked'> </div>";

													} else {
														str += "<div class = 'switch'>"
														str += "<input type = 'checkbox' value = "
																+ row.id
																+ " /> </div>";

													}
													return str;
												}

											},
											{
												data : 'id',
												mRender : function(data, type,
														row) {
													var str = '';
													return str += '<a href = "'
															+ window.siteURL
															+ '/manage/edit/'
															+ data
															+ '/product/" class="btn btn-success">Edit </a>';

												}
											} ],
									initComplete : function() {
										var api = this.api();
										api
												.$(
														".switch input[type = 'checkbox']")
												.on(
														'change',
														function() {

															var checkbox = $(this);
															var checked = checkbox
																	.prop('checked');

															var dmsg = (checked) ? "Are you sure you want to activate"
																	: "Are you sure you want to deactivate?";
															var val = checkbox
																	.prop('value');

															var value = confirm(dmsg)
															if (value) {
																/*
																 * alert('Modifications
																 * have been
																 * made to ' +
																 * val);
																 */
																$
																		.post(
																				window.siteURL
																						+ "/manage/"
																						+ val
																						+ "/product/activation",
																				function(
																						data) {
																					alert(data);
																				});
															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);

															}

														});
									}
								});
					}

					/* Modal form validation */

					var modalForm = $("#mForm");
					if (modalForm.length) {

						modalForm.validate({
							rules : {
								name : {
									required : true,
									minlength : 2
									},
								description: 
									{
										required: true
									}
							},
							messages: {
								name: 
									{
										required: "*Give a name",
										minLength: "*Length must be 2"
									},
							description:
								{
									required: "*Give a name"
								}
							},
							errorElement: 'em',
							errorClass : 'error-body'

						});
					}

				});