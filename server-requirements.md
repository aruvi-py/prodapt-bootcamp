A web server needs to be able to do the following steps in an infinite loop:

1. Listen for incoming requests - we configure this by installing a server like tomcat and by setting the context to make use of our java dynamic web project classes.
1. Unpack the HTTP request - we configure this by creating a web.xml, registering our sevlets there, and setting up a `<servlet-mapping>`
1. Process the request - we configure this by extending one of the `*Servlet` family of abstract classes provided by Jakarta EE. We generally like to extend `HttpServlet` and provide overridden implementations of doGet(...), doPost(...), etc. Whatever we don't override will return a 405 unsupported method response.
1. Pack the HTTP response - a HttpServletResponse is already created and given to us by the `do*` family of methods. We need to fill it up. One way to do it is by getting a PrintWriter using the resp.getWriter() method and printing to it.
1. Send back the HTTP response - apache takes care of this.
