
$(document).ready(function(){
	
	switch(menu)
	{
		case 'about':
			{
				$("#about").addClass('active');
				break;
			}
		case 'contact':
		{
			$("#contact").addClass('active');
			break;
		}
		case 'All products':
			{
				$('#listproducts').addClass('active');
				break;
			}
		
		default:
		{
			$("#listproducts").addClass('active');
			$('#a_'+menu).addClass('active');
			
			break;
		}
	
	}
	
});