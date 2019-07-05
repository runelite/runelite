import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = 2069364655
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 801157533
   )
   int field574;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("patch")
   MusicPatch patch;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   @Export("rawSound")
   RawSound rawSound;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   MusicPatchNode2 field575;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2058553171
   )
   int field576;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 62958303
   )
   int field577;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -836502917
   )
   int field578;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -308599455
   )
   int field579;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -471899285
   )
   int field580;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1520706641
   )
   int field581;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -852988281
   )
   int field582;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -439388365
   )
   int field583;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 476852577
   )
   int field584;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2136855685
   )
   int field585;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2083252379
   )
   int field586;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1605236771
   )
   int field587;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 173672931
   )
   int field588;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 219840779
   )
   int field589;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   @Export("stream")
   RawPcmStream stream;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -666877449
   )
   int field590;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1359854411
   )
   int field591;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "39"
   )
   void method219() {
      this.patch = null;
      this.rawSound = null;
      this.field575 = null;
      this.stream = null;
   }
}
