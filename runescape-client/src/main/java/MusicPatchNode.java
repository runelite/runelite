import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1987451655
	)
	int field2440;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	MusicPatchNode2 field2452;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgg;"
	)
	@Export("patch")
	MusicPatch patch;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lcd;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1602742247
	)
	int field2438;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -2106336541
	)
	int field2450;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -871817931
	)
	int field2442;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -968890095
	)
	int field2443;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1922706661
	)
	int field2441;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1739231469
	)
	int field2445;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 959590897
	)
	int field2446;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -182096649
	)
	int field2447;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1688509749
	)
	int field2448;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -79165823
	)
	int field2449;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1291015747
	)
	int field2436;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -174266075
	)
	int field2451;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 889616959
	)
	int field2458;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 602095745
	)
	int field2453;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ldh;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1993238455
	)
	int field2455;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1377522023
	)
	int field2444;

	MusicPatchNode() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-18"
	)
	void method3826() {
		this.patch = null;
		this.rawSound = null;
		this.field2452 = null;
		this.stream = null;
	}
}
