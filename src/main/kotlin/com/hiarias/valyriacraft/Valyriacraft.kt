package com.hiarias.valyriacraft

import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager

object Valyriacraft : ModInitializer {
    const val MOD_ID = "valyriacraft"
    val logger = LogManager.getLogger(MOD_ID)

    override fun onInitialize() {
        logger.info("Hello, World!")
    }
}
