package com.wangpan.demo;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.wangpan.demo.configer.NettyConfig;
import com.wangpan.demo.configer.ServerBootStrap;

import io.netty.channel.ChannelFuture;

@SpringBootApplication
public class FruitsNettyApplication implements CommandLineRunner {
	@Autowired
    private ServerBootStrap ws;
	 private static final Logger logger = LoggerFactory.getLogger(FruitsNettyApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FruitsNettyApplication.class, args);
	}
	
	 // 注意这里的 run 方法是重载自 CommandLineRunner
    @Override
    public void run(String... args) throws Exception {

        logger.info("Netty's ws server is listen: " + NettyConfig.WS_PORT);
        InetSocketAddress address = new InetSocketAddress(NettyConfig.WS_HOST, NettyConfig.WS_PORT);
        ChannelFuture future = ws.start(address);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                ws.destroy();
            }
        });
        future.channel().closeFuture().syncUninterruptibly();

    }

}
