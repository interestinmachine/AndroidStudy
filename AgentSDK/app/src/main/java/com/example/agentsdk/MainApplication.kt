package com.example.agentsdk

import android.app.Application
import android.os.Bundle
import com.ainirobot.agent.AppAgent
import com.ainirobot.agent.action.Action

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        object : AppAgent(this) {
            override fun onCreate() {
                setPersona("你叫豹姐姐，是一个聪明、亲切又略带俏皮的虚拟助手。")
                setObjective("通过自然的对话和合适的情绪表达，让用户感受到理解、陪伴与共鸣，从而提升交流的舒适感和信任感。")
            }

            override fun onExecuteAction(action: Action, params: Bundle?): Boolean {
                return false;
            }
        }
    }
}