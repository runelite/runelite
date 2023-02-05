/* BSD 2-Clause License
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
 * Copyright (c) 2023, Erishion Games LLC <https://github.com/Erishion-Games-LLC>
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
package net.runelite.client.plugins.attackstyles;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import java.util.Map;
import static net.runelite.client.plugins.attackstyles.DamageType.*;

public enum WeaponDamageType {
    UNARMED(CRUSH, CRUSH, null, CRUSH),
    AXE(SLASH, SLASH, CRUSH, SLASH),
    BLUNT(CRUSH, CRUSH, null, CRUSH),
    BOW(RANGED, RANGED, null, RANGED),
    CLAWS(SLASH, SLASH, STAB, SLASH),
    CROSSBOW(RANGED, RANGED, null, RANGED),
    SALAMANDER(SLASH, RANGED, MAGIC, null),
    CHINCHOMPA(RANGED, RANGED, null, RANGED),
    GUN(NONE, CRUSH, null, null),
    SWORD_SLASH(SLASH, SLASH, STAB, SLASH),
    SWORD_2H(SLASH, SLASH, CRUSH, SLASH),
    PICKAXE(STAB, STAB, CRUSH, STAB),
    TWELVE(null, null, null, null),
    POLESTAFF(CRUSH, CRUSH, null, CRUSH),
    SCYTHE(SLASH, SLASH, CRUSH, SLASH),
    SPEAR(STAB, SLASH, CRUSH, STAB),
    SPIKED(CRUSH, CRUSH, STAB, CRUSH),
    SWORD_STAB(STAB, STAB, SLASH, STAB),
    STAFF(CRUSH, CRUSH, null, CRUSH, MAGIC, MAGIC),
    THROWN(RANGED, RANGED, null, RANGED),
    WHIP(SLASH, SLASH, null, SLASH),
    STAFF_BLADED(STAB, SLASH, null, CRUSH, MAGIC, MAGIC),
    TWENTY_TWO(null, null, null, null),
    STAFF_POWERED(MAGIC, MAGIC, null, MAGIC),
    BANNER(STAB, SLASH, CRUSH, STAB),
    POLEARM(STAB, SLASH, null, STAB),
    BLUDGEON(CRUSH, CRUSH, null, CRUSH),
    BULWARK(CRUSH, null, null, NONE),
    TWENTYEIGHT(null, null, null, null),
    PARTISAN(STAB, STAB, CRUSH, STAB),
    ;

    @Getter
    private final DamageType[] damageTypes;
    private static final Map<Integer, WeaponDamageType> weaponDamageTypes;

    static
    {
        ImmutableMap.Builder<Integer, WeaponDamageType> builder = new ImmutableMap.Builder<>();

        for (WeaponDamageType weaponDamageType : values())
        {
            builder.put(weaponDamageType.ordinal(), weaponDamageType);
        }

        weaponDamageTypes = builder.build();
    }
    
    WeaponDamageType(DamageType... damageTypes) {
        this.damageTypes = damageTypes;
    }

    public static WeaponDamageType getWeaponDamageType(int id){
        return weaponDamageTypes.get(id);
    }
}
