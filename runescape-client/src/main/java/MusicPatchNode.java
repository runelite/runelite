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
   int __m;
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
   MusicPatchNode2 __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2058553171
   )
   int __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 62958303
   )
   int __u;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -836502917
   )
   int __g;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -308599455
   )
   int __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -471899285
   )
   int __e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1520706641
   )
   int __x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -852988281
   )
   int __d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -439388365
   )
   int __k;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 476852577
   )
   int __n;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2136855685
   )
   int __i;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2083252379
   )
   int __a;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1605236771
   )
   int __z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 173672931
   )
   int __j;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 219840779
   )
   int __s;
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
   int __y;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1359854411
   )
   int __b;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "39"
   )
   void __m_370() {
      this.patch = null;
      this.rawSound = null;
      this.__w = null;
      this.stream = null;
   }
}
