# SpringBoot-Content-Caching

- ContentCachingRequestWrapper
- ContentCachingResponseWrapper


###

```java

@Slf4j
@Component
public class LoggingRequestResponseFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(requestWrapper, responseWrapper);

        String requestBody = new String(requestWrapper.getContentAsByteArray(), requestWrapper.getCharacterEncoding());
        String responseBody = new String(responseWrapper.getContentAsByteArray(), responseWrapper.getCharacterEncoding());
        responseWrapper.copyBodyToResponse();

        log.info("requestBody -> {}", requestBody);
        log.info("responseBody -> {}", responseBody);
    }

}

```

### Demo 

    curl localhost:8080/get
    curl -XPOST -H "Content-type: application/json" -d '{"reqId":"1","reqName":"test"}' 'http://localhost:8080/post'