# EHMQ

a hyper message queue for gp

## task description

先构建一个工作场景：一个worker线程池，一个任务分发器，一个任务队列。任务分发器将任务推入队列，worker线程从队列中取任务处理。这个场景有一个约束条件：每个任务只能由一个线程处理。

在这个场景中，需要解决的问题是：任务在线程处理的过程中会发生变化，可能有新事件到达，如何高效地实现任务的分发与调度？

以无锁的方式实现事件传递，同时不允许有任务和事件丢失的情况发生。

## requirement analysis

- 功能
    - 生产者-消费者模式功能的基本实现
        - 订阅-推送机制
        - 消费时消息不存在的处理政策
        - 生产时消息过多的处理政策
        - double ack问题
    - 提供消费者对消息的唯一访问
- 性能
    - 尽量高的消息队列的性能
    - 完全避免消息丢失的情况
- 其他
    - 采用无锁实现

## design

- 消息入队流程采取先持久化，后反馈入队结果，保证消息的不丢失
- 控制指令的实现
- 锁实现的替代方法
    - 单机实现 乐观锁 `CAS`
    - 多机实现 基于redis的乐观锁
- 不可靠信道信息交流问题
    - 单机实现不考虑信息交流问题
    - 多机实现借鉴成熟消息队列的实现方式

## ref

- [Disruptor](https://github.com/LMAX-Exchange/disruptor/wiki/Introduction)
- J.U.C
- [Vert.X](https://vertx.io)
- [RabbitMQ](http://www.rabbitmq.com)
- [kafka](http://kafka.apache.org)
