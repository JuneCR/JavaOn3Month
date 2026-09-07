package com.june.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

// name="sayhi" 决定了用户执行时的命令叫 sayhi
@Mojo(name = "sayhi", defaultPhase = LifecyclePhase.INITIALIZE)
public class GreetingMojo extends AbstractMojo {

    // 这个参数既可以在pom.xml里配，也可以用 -Dgreeting.name=xxx 传
    @Parameter(property = "greeting.name", defaultValue = "Maven 新手")
    private String name;

    // 注入当前项目对象，用来获取项目名称
    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    // ★ 这就是 Mojo 干活的入口方法！
    public void execute() throws MojoExecutionException {
        getLog().info("=====================================");
        getLog().info("🎉 恭喜！你的第一个 Mojo 执行成功了！");
        getLog().info("📢 传入的名字是：" + name);
        getLog().info("📁 当前测试项目名称：" + project.getName());
        getLog().info("=====================================");
    }
}