/*
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
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

package net.runelite.client.plugins.fairyring;

public enum FairyRingCodes {

    // A
    AIQ("AIQ", "Mudskipper Point"),
    AIR("AIR", "(Island) South-east of Ardougne"),
    AJQ("AJQ", "Cave south of Dorgesh-Kaan"),
    AJR("AJR", "Slayer cave"),
    AJS("AJS", "Penguins near Miscellania"),
    AKQ("AKQ", "Piscatoris Hunter area"),
    AKS("AKS", "Feldip Hunter area"),
    ALP("ALP", "(Island) Lighthouse"),
    ALQ("ALQ", "Haunted Woods east of Canifis"),
    ALR("ALR", "Abyssal Area"),
    ALS("ALS", "McGrubor's Wood"),

    // B
    BIP("BIP", "(Island) South-west of Mort Myre"),
    BIQ("BIQ", "Kalphite Hive"),
    BIS("BIS", "Ardougne Zoo - Unicorns"),
    BJR("BJR", "Realm of the Fisher King"),
    BJS("BJS", "(Island) Near Zul-Andra"),
    BKP("BKP", "South of Castle Wars"),
    BKQ("BKQ", "Enchanted Valley"),
    BKR("BKR", "Mort Myre Swamp, south of Canifis"),
    BKS("BKS", "Zanaris"),
    BLP("BLP", "TzHaar area"),
    BLR("BLR", "Legends' Guild"),

    // C
    CIP("CIP", "(Island) Miscellania"),
    CIQ("CIQ", "North-west of Yanille"),
    CIS("CIS", "North of the Arceuus House Library"),
    CJR("CJR", "Sinclair Mansion (east)"),
    CKP("CKP", "Cosmic entity's plane"),
    CKR("CKR", "South of Tai Bwo Wannai Village"),
    CKS("CKS", "Canifis"),
    CLP("CLP", "(Island) South of Draynor Village"),
    CLR("CLR", "(Island) Ape Atoll"),
    CLS("CLS", "(Island) Hazelmere's home"),

    // D
    DIP("DIP", "(Sire Boss) Abyssal Nexus"),
    DIR("DIR", "Gorak's Plane"),
    DIQ("DIQ", "Player-owned house"),
    DIS("DIS", "Wizards' Tower"),
    DJP("DJP", "Tower of Life"),
    DJR("DJR", "Chasm of Fire"),
    DKP("DKP", "South of Musa Point"),
    DKR("DKR", "Edgeville, Grand Exchange"),
    DKS("DKS", "Polar Hunter area"),
    DLQ("DLQ", "North of Nardah"),
    DLR("DLR", "(Island) Poison Waste south of Isafdar"),
    DLS("DLS", "Myreque hideout under The Hollows");



    private String fairyCode;
    private String description;

    FairyRingCodes(String fairyCode, String description)
    {
        this.fairyCode = fairyCode;
        this.description = description;
    }

    String getDescription()
    {
        return description;
    }

    String getFairyCode()
    {
        return fairyCode;
    }
}
