<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css_files/admin.css" />
	</head>
	<body>
			<table id="package_table" style="position: absolute; left: 20%; top: 23%;">																																										
				<s:iterator value="packages" id="packages" status="status">
					<tr>
						<td> <s:property value="#packages.name" /> </td>																																																																																																																								
						<td>
							<a href="admin_get_package_by_name?pkgName=
									<s:property value="#packages.name" />">
								编辑
							</a>
						</td>
						<td>
							<a href="admin_delete_package_by_name?pkgName=
									<s:property value="#packages.name" />">
							删除
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
	</BODY>
</HTML>