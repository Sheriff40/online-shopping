<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="my-4">Shop Name</h1>


			<div class="list-group">

				<c:forEach var = "c" items = "${categories}">
					<a href="${SITE_URL}/show/category/${c.id}/product" id = "a_${c.name} }" 
					class="list-group-item">${c.name}</a>
				</c:forEach>
			
			</div>
