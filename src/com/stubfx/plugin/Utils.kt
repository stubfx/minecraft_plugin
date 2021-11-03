package com.stubfx.plugin

import org.bukkit.Location

class Utils {

    companion object {
        fun checkLocationsWorld(l1: Location, l2: Location) {
            if (l1.world != l2.world) {
                throw IllegalArgumentException("both locations must be from the same world")
            }
        }

        fun getMinLocation(l1: Location, l2: Location): Location {
            checkLocationsWorld(l1, l2)
            return Location(l1.world, minOf(l1.x, l2.x), minOf(l1.y, l2.y), minOf(l1.z, l2.z))
        }

        fun getMaxLocation(l1: Location, l2: Location): Location {
            checkLocationsWorld(l1, l2)
            return Location(l1.world, maxOf(l1.x, l2.x), maxOf(l1.y, l2.y), maxOf(l1.z, l2.z))
        }
    }

}