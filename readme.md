# sample net

一个非常简单的TCP服务器，消息通过简单的TLV格式封装，标识域作为消息ID，与一个路由绑定。未来可能还会提供beforeHandle和afterHandle的hook。

## Usage

期望能达到的效果

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