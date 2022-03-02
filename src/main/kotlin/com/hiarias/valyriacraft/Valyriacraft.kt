package com.hiarias.valyriacraft

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

const val MOD_ID = "valyriacraft"

val LOGGER: Logger = LogManager.getLogger(MOD_ID)

@Suppress("unused")
fun init() {
    LOGGER.info("Hello, World!")
    registerItem()
}

private fun registerItem() {
    ITEMS.forEach { (id, item) ->
        Registry.register(Registry.ITEM, Identifier(MOD_ID, id), item)
    }
}
