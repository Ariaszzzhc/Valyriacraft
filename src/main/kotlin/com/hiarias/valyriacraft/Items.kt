package com.hiarias.valyriacraft

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import java.util.function.Consumer

val ITEM_GROUP: ItemGroup = FabricItemGroupBuilder.create(
    Identifier(MOD_ID, "general")
)
    .icon {
        ItemStack(Items.OBSIDIAN)
    }
    .build()

val ITEMS = sortedMapOf<String, Item>()

val HAND_HELD = sortedSetOf<String>()

val REGISTRATION_EVENT = sortedMapOf<String, Consumer<Item>>()

fun of(
    id: String,
    maxCount: Int = 64,
    registrationEvent: Consumer<Item>? = null,
    handHeld: Boolean = false,
    rarity: Rarity = Rarity.COMMON
): Item {
    return of(id, maxCount, registrationEvent, handHeld, rarity) {
        Item(it)
    }
}

fun <T : Item> of(
    id: String,
    maxCount: Int = 64,
    registrationEvent: Consumer<Item>? = null,
    handHeld: Boolean = false,
    rarity: Rarity = Rarity.COMMON,
    ctor: (FabricItemSettings) -> T,
): T {
    val item = ctor.invoke(FabricItemSettings().maxCount(maxCount).rarity(rarity).group(ITEM_GROUP))

    ITEMS.putIfAbsent(id, item)

    registrationEvent?.also {
        REGISTRATION_EVENT[id] = it
    }

    if (handHeld) {
        HAND_HELD.add(id)
    }

    return item
}

val OBSIDIAN_DUST: Item = of("OBSIDIAN_DUST")
