# sample net

## usage

```java
Server server = new BaseServer(8080);

server.router(0, new BaseRouter() {
    @Override
    public void handle(Context ctx) {
      ctx.str("hello world");
    }
});

server.router(1, ctx -> {
  String name = ctx.getQuery("name");
  Person person = new Person();
  ctx.json(person);
});

server.addBeforeHandler((ctx, next) -> {
  ctx.set("name", "hello");
  next.handle(ctx);
});
server.addAfterHandler((ctx, next) -> {
  ctx.set("name", "hello");
  next.handle(ctx);
});
server.start();

```

## Examples

### Echo Server

```java
public class EchoServer {

  public static void main(String[] args) throws IOException {
    Server server = new BaseServer(7777);

    server.router(0, ctx -> {
      String str = ctx.bodyStr();
      System.out.printf("recv from client: %s%n", str);
      try {
        ctx.str(str);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    server.start();
  }
}
```