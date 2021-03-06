/*
 * Copyright 2007-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ymate.platform.core.event;

/**
 * 事件管理提供者接口
 *
 * @param <T>       事件所有者类型
 * @param <E>       事件枚举
 * @param <EVENT>   事件对象类型
 * @param <CONTEXT> 事件监听器上下文对象类型
 * @author 刘镇 (suninformation@163.com) on 15/5/16 上午2:15
 * @version 1.0
 */
public interface IEventProvider<T, E extends Enum<E>, EVENT extends Class<? extends IEvent>, CONTEXT extends EventContext<T, E>> {

    /**
     * 初始化事件管理提供者对象
     *
     * @param eventConfig 事件配置接口实例
     */
    void init(IEventConfig eventConfig);

    /**
     * @return 返回事件配置
     */
    IEventConfig getEventConfig();

    /**
     * 销毁
     */
    void destroy();

    /**
     * 注册事件类型
     *
     * @param eventClass 事件类型
     */
    void registerEvent(EVENT eventClass);

    /**
     * 解注册事件类型
     *
     * @param eventClass 事件类型
     * @return 移除成功将返回true
     */
    boolean unregisterEvent(EVENT eventClass);

    /**
     * 注册事件监听器
     *
     * @param eventClass    监听的事件类型
     * @param eventListener 事件监听器接口实例
     */
    void registerListener(EVENT eventClass, IEventListener<CONTEXT> eventListener);

    /**
     * 注册事件监听器
     *
     * @param mode          事件触发模式
     * @param eventClass    监听的事件类型
     * @param eventListener 事件监听器接口实例
     */
    void registerListener(Events.MODE mode, EVENT eventClass, IEventListener<CONTEXT> eventListener);

    /**
     * 解注册事件监听器
     *
     * @param eventClass    监听的事件类型
     * @param listenerClass 事件监听器类型
     * @return 移除成功将返回true
     */
    boolean unregisterListener(EVENT eventClass, Class<? extends IEventListener> listenerClass);

    /**
     * 触发事件
     *
     * @param context 事件上下文
     */
    void fireEvent(CONTEXT context);
}
