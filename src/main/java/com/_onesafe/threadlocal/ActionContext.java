package com._onesafe.threadlocal;

import javax.security.auth.login.Configuration;

/**
 * Created by onesafe on 28/09/2018.
 * 使用ThreadLocal设计线程上下文
 */
public class ActionContext {

    private static final ThreadLocal<Context> context = ThreadLocal.withInitial(Context::new);

    public static Context get() {
        return context.get();
    }

    static class Context {
        private Configuration configuration;
        private String name;

        private Context() {
            this.name = "onesafe";
        }

        public Configuration getConfiguration() {
            return configuration;
        }

        public void setConfiguration(Configuration configuration) {
            this.configuration = configuration;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
