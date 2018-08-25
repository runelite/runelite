/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.farmingprofit;

import lombok.Getter;
import net.runelite.api.ItemID;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Crop {

    UNKNOWN(-1,-1, "Unknown"),

    SNAPDRAGON(ItemID.GRIMY_SNAPDRAGON, ItemID.SNAPDRAGON_SEED, "Snapdragon herb"),
    RANARR(ItemID.GRIMY_RANARR_WEED, ItemID.RANARR_SEED, "Ranarr herb");

    Crop(int productId, int seedId, String displayName)
    {
        this.productId = productId;
        this.seedId = seedId;
        this.displayName = displayName;
    }

    @Getter
    private final int productId;
    @Getter
    private final int seedId;
    @Getter
    private final String displayName;
    private static final Map<Integer, Crop> map = Collections.unmodifiableMap(initializeMapping());

    public static Crop fromProductId(int product) {
        if (map.containsKey(product)) {
            return map.get(product);
        }
        return Crop.UNKNOWN;
    }

    private static Map<Integer, Crop> initializeMapping() {
        Map<Integer, Crop> mMap = new HashMap<>();
        for (Crop s : Crop.values()) {
            mMap.put(s.productId, s);
        }
        return mMap;
    }

}
