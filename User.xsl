<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
		  <body>
		    <h2>User Details</h2>
		    <table border="1">
		      <tr>
		        <th>UserId</th>
		        <th>FirstName</th>
		        <th>lastName</th>
		        <th>location</th>
		      </tr>
		      <xsl:for-each select="users/user">
		      <tr>
		      	<td><xsl:value-of select="@id"/></td>
		        <td><xsl:value-of select="firstName" /></td>
		        <td><xsl:value-of select="lastName" /></td>
		        <td><xsl:value-of select="location"/></td>
		      </tr>
		      </xsl:for-each>
		    </table>
		  </body>
		  </html>
	</xsl:template>
</xsl:stylesheet>