/*
 * Copyright (c) 2023, Moshe Ben-Zacharia <moshebenzacharia@gmail.com>
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
package net.runelite.client.plugins.timetracking.farming;

import java.util.HashMap;
import java.util.Map;

///Useful for debugging
class GeomancyMaps
{

	public final Map<Integer, String> cropTypes = new HashMap<>();
	public final Map<Integer, String> patchNames = new HashMap<>();
	public final Map<Integer, String> patchTypes = new HashMap<>();

	GeomancyMaps()
	{
		cropTypes.put(1942, "Potatoes");
		cropTypes.put(1957, "Onions");
		cropTypes.put(1965, "Cabbages");
		cropTypes.put(1982, "Tomatoes");
		cropTypes.put(5986, "Sweetcorn");
		cropTypes.put(5504, "Strawberries");
		cropTypes.put(5982, "Watermelons");
		cropTypes.put(231, "Snape grass");
		cropTypes.put(6010, "Marigolds");
		cropTypes.put(6014, "Rosemary");
		cropTypes.put(6012, "Nasturtiums");
		cropTypes.put(22932, "White lily");
		cropTypes.put(1793, "Woad");
		cropTypes.put(225, "Limpwurt");
		cropTypes.put(6059, "Scarecrow");
		cropTypes.put(249, "Guam leaf");
		cropTypes.put(251, "Marrentill");
		cropTypes.put(253, "Tarromin");
		cropTypes.put(255, "Harralander");
		cropTypes.put(257, "Ranarr weed");
		cropTypes.put(2998, "Toadflax");
		cropTypes.put(259, "Irit leaf");
		cropTypes.put(261, "Avantoe");
		cropTypes.put(263, "Kwuarm");
		cropTypes.put(3000, "Snapdragon");
		cropTypes.put(265, "Cadantine");
		cropTypes.put(2481, "Lantadyme");
		cropTypes.put(267, "Dwarf weed");
		cropTypes.put(269, "Torstol");
		cropTypes.put(3261, "Goutweed");
		cropTypes.put(229, "Dead herb");
		cropTypes.put(1926, "Empty bin");
		cropTypes.put(6033, "Compostable items");
		cropTypes.put(6032, "Compost");
		cropTypes.put(6035, "Supercompostable items");
		cropTypes.put(6034, "Supercompost");
		cropTypes.put(21483, "Ultracompost");
		cropTypes.put(2519, "Tomatoes");
		cropTypes.put(2518, "Rotten tomatoes");
		cropTypes.put(5994, "Hammerstone hops");
		cropTypes.put(5996, "Asgarnian hops");
		cropTypes.put(5998, "Yanillian hops");
		cropTypes.put(6000, "Krandorian hops");
		cropTypes.put(6002, "Wildblood hops");
		cropTypes.put(6006, "Barley");
		cropTypes.put(5931, "Jute");
		cropTypes.put(1951, "Redberry bush");
		cropTypes.put(753, "Cadavaberry bush");
		cropTypes.put(2126, "Dwellberry bush");
		cropTypes.put(247, "Jangerberry bush");
		cropTypes.put(239, "Whiteberry bush");
		cropTypes.put(6018, "Poison Ivy bush");
		cropTypes.put(1955, "Apple tree");
		cropTypes.put(1963, "Banana tree");
		cropTypes.put(2108, "Orange tree");
		cropTypes.put(5970, "Curry tree");
		cropTypes.put(2114, "Pineapple plant");
		cropTypes.put(5972, "Papaya tree");
		cropTypes.put(5974, "Palm tree");
		cropTypes.put(22929, "Dragonfruit tree");
		cropTypes.put(1521, "Oak tree");
		cropTypes.put(1519, "Willow tree");
		cropTypes.put(1517, "Maple tree");
		cropTypes.put(1515, "Yew tree");
		cropTypes.put(1513, "Magic tree");
		cropTypes.put(2015, "Spirit tree");
		cropTypes.put(6004, "Bittercap mushrooms");
		cropTypes.put(6016, "Cactus");
		cropTypes.put(3138, "Potato cactus");
		cropTypes.put(2398, "Belladonna");
		cropTypes.put(5980, "Calquat tree");
		cropTypes.put(1987, "Grapevine");
		cropTypes.put(21504, "Giant Seaweed");
		cropTypes.put(6333, "Teak tree");
		cropTypes.put(6332, "Mahogany tree");
		cropTypes.put(23044, "Hespori plant");
		cropTypes.put(19669, "Redwood tree");
		cropTypes.put(22935, "Celastrus tree");
		cropTypes.put(22938, "Kronos plant");
		cropTypes.put(22939, "Iasor plant");
		cropTypes.put(22940, "Attas plant");
		cropTypes.put(23962, "Crystal tree");

		patchNames.put(8, "Falador (NW)");
		patchNames.put(9, "Falador (SE)");
		patchNames.put(10, "Catherby (N)");
		patchNames.put(11, "Catherby (S)");
		patchNames.put(12, "Ardougne (N)");
		patchNames.put(13, "Ardougne (S)");
		patchNames.put(14, "Morytania (NW)");
		patchNames.put(15, "Morytania (SE)");
		patchNames.put(142, "Harmony");
		patchNames.put(51, "Hosidius (NE)");
		patchNames.put(52, "Hosidius (SW)");
		patchNames.put(27, "Falador");
		patchNames.put(28, "Catherby");
		patchNames.put(29, "Ardougne");
		patchNames.put(30, "Morytania");
		patchNames.put(53, "Hosidius");
		patchNames.put(43, "Falador");
		patchNames.put(44, "Catherby");
		patchNames.put(45, "Ardougne");
		patchNames.put(46, "Morytania");
		patchNames.put(143, "Harmony");
		patchNames.put(54, "Hosidius");
		patchNames.put(47, "Troll Stronghold");
		patchNames.put(152, "Weiss");
		patchNames.put(39, "Falador");
		patchNames.put(40, "Catherby");
		patchNames.put(41, "Morytania");
		patchNames.put(42, "Ardougne");
		patchNames.put(55, "Hosidius");
		patchNames.put(169, "Prifddinas");
		patchNames.put(141, "Farming Guild");
		patchNames.put(16, "Yanille");
		patchNames.put(17, "Entrana");
		patchNames.put(18, "Lumbridge");
		patchNames.put(19, "Seers' Village");
		patchNames.put(20, "Varrock");
		patchNames.put(21, "Rimmington");
		patchNames.put(22, "Etceteria");
		patchNames.put(23, "Ardougne");
		patchNames.put(4, "Gnome Stronghold");
		patchNames.put(5, "Tree Gnome Village");
		patchNames.put(6, "Brimhaven");
		patchNames.put(7, "Catherby");
		patchNames.put(49, "Lletya");
		patchNames.put(0, "Taverley");
		patchNames.put(1, "Falador");
		patchNames.put(2, "Varrock");
		patchNames.put(3, "Lumbridge");
		patchNames.put(48, "Gnome Stronghold");
		patchNames.put(24, "Port Sarim");
		patchNames.put(25, "Etceteria");
		patchNames.put(26, "Brimhaven");
		patchNames.put(50, "Hosidius");
		patchNames.put(37, "Canifis");
		patchNames.put(31, "Tai Bwo Wannai");
		patchNames.put(36, "Al Kharid");
		patchNames.put(38, "Draynor Manor");
		patchNames.put(56, "Vinery (W1)");
		patchNames.put(57, "Vinery (W2)");
		patchNames.put(58, "Vinery (W3)");
		patchNames.put(59, "Vinery (W4)");
		patchNames.put(60, "Vinery (W5)");
		patchNames.put(61, "Vinery (W6)");
		patchNames.put(62, "Vinery (E1)");
		patchNames.put(63, "Vinery (E2)");
		patchNames.put(64, "Vinery (E3)");
		patchNames.put(65, "Vinery (E4)");
		patchNames.put(66, "Vinery (E5)");
		patchNames.put(67, "Vinery (E6)");
		patchNames.put(147, "Fossil Island");
		patchNames.put(148, "Fossil Island");
		patchNames.put(149, "Fossil Island");
		patchNames.put(150, "Fossil Island");
		patchNames.put(151, "Fossil Island");
		patchNames.put(153, "Farming Guild");
		patchNames.put(154, "Farming Guild");
		patchNames.put(155, "Farming Guild");
		patchNames.put(156, "Farming Guild (N)");
		patchNames.put(157, "Farming Guild (S)");
		patchNames.put(166, "Prifddinas (N)");
		patchNames.put(167, "Prifddinas (S)");
		patchNames.put(158, "Farming Guild");
		patchNames.put(159, "Farming Guild");
		patchNames.put(160, "Farming Guild");
		patchNames.put(161, "Farming Guild");
		patchNames.put(168, "Prifddinas");
		patchNames.put(164, "Farming Guild");
		patchNames.put(162, "Farming Guild");
		patchNames.put(163, "Farming Guild");
		patchNames.put(165, "Farming Guild");
		patchNames.put(170, "Prifddinas");

		patchTypes.put(8, "Allotment");
		patchTypes.put(9, "Allotment");
		patchTypes.put(10, "Allotment");
		patchTypes.put(11, "Allotment");
		patchTypes.put(12, "Allotment");
		patchTypes.put(13, "Allotment");
		patchTypes.put(14, "Allotment");
		patchTypes.put(15, "Allotment");
		patchTypes.put(142, "Allotment");
		patchTypes.put(51, "Allotment");
		patchTypes.put(52, "Allotment");
		patchTypes.put(156, "Allotment");
		patchTypes.put(157, "Allotment");
		patchTypes.put(166, "Allotment");
		patchTypes.put(167, "Allotment");
		patchTypes.put(27, "Flower patch");
		patchTypes.put(28, "Flower patch");
		patchTypes.put(29, "Flower patch");
		patchTypes.put(30, "Flower patch");
		patchTypes.put(53, "Flower patch");
		patchTypes.put(161, "Flower patch");
		patchTypes.put(168, "Flower patch");
		patchTypes.put(43, "Herb patch");
		patchTypes.put(44, "Herb patch");
		patchTypes.put(45, "Herb patch");
		patchTypes.put(46, "Herb patch");
		patchTypes.put(143, "Herb patch");
		patchTypes.put(54, "Herb patch");
		patchTypes.put(158, "Herb patch");
		patchTypes.put(47, "Herb patch");
		patchTypes.put(152, "Herb patch");
		patchTypes.put(39, "Compost bin");
		patchTypes.put(40, "Compost bin");
		patchTypes.put(41, "Compost bin");
		patchTypes.put(42, "Compost bin");
		patchTypes.put(55, "Compost bin");
		patchTypes.put(169, "Compost bin");
		patchTypes.put(141, "Big compost bin");
		patchTypes.put(16, "Hops patch");
		patchTypes.put(17, "Hops patch");
		patchTypes.put(18, "Hops patch");
		patchTypes.put(19, "Hops patch");
		patchTypes.put(20, "Bush patch");
		patchTypes.put(21, "Bush patch");
		patchTypes.put(22, "Bush patch");
		patchTypes.put(23, "Bush patch");
		patchTypes.put(155, "Bush patch");
		patchTypes.put(4, "Fruit tree patch");
		patchTypes.put(5, "Fruit tree patch");
		patchTypes.put(6, "Fruit tree patch");
		patchTypes.put(7, "Fruit tree patch");
		patchTypes.put(49, "Fruit tree patch");
		patchTypes.put(153, "Fruit tree patch");
		patchTypes.put(0, "Tree patch");
		patchTypes.put(1, "Tree patch");
		patchTypes.put(2, "Tree patch");
		patchTypes.put(3, "Tree patch");
		patchTypes.put(48, "Tree patch");
		patchTypes.put(160, "Tree patch");
		patchTypes.put(24, "Spirit tree patch");
		patchTypes.put(25, "Spirit tree patch");
		patchTypes.put(26, "Spirit tree patch");
		patchTypes.put(50, "Spirit tree patch");
		patchTypes.put(154, "Spirit tree patch");
		patchTypes.put(37, "Mushrooms patch");
		patchTypes.put(31, "Calquat patch");
		patchTypes.put(36, "Cactus patch");
		patchTypes.put(159, "Cactus patch");
		patchTypes.put(38, "Belladonna patch");
		patchTypes.put(56, "Grapevine patch");
		patchTypes.put(57, "Grapevine patch");
		patchTypes.put(58, "Grapevine patch");
		patchTypes.put(59, "Grapevine patch");
		patchTypes.put(60, "Grapevine patch");
		patchTypes.put(61, "Grapevine patch");
		patchTypes.put(62, "Grapevine patch");
		patchTypes.put(63, "Grapevine patch");
		patchTypes.put(64, "Grapevine patch");
		patchTypes.put(65, "Grapevine patch");
		patchTypes.put(66, "Grapevine patch");
		patchTypes.put(67, "Grapevine patch");
		patchTypes.put(147, "Seaweed patch");
		patchTypes.put(148, "Seaweed patch");
		patchTypes.put(149, "Hardwood tree patch");
		patchTypes.put(150, "Hardwood tree patch");
		patchTypes.put(151, "Hardwood tree patch");
		patchTypes.put(164, "Hespori patch");
		patchTypes.put(162, "Redwood patch");
		patchTypes.put(163, "Celastrus patch");
		patchTypes.put(165, "Anima patch");
		patchTypes.put(170, "Crystal tree patch");
	}
}