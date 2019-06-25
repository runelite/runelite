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
   @Export("__m")
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
   @Export("__w")
   MusicPatchNode2 __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2058553171
   )
   @Export("__o")
   int __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 62958303
   )
   @Export("__u")
   int __u;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -836502917
   )
   @Export("__g")
   int __g;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -308599455
   )
   @Export("__l")
   int __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -471899285
   )
   @Export("__e")
   int __e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1520706641
   )
   @Export("__x")
   int __x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -852988281
   )
   @Export("__d")
   int __d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -439388365
   )
   @Export("__k")
   int __k;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 476852577
   )
   @Export("surfaceOffsetY")
   int __n;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2136855685
   )
   @Export("__i")
   int __i;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2083252379
   )
   @Export("__a")
   int __a;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1605236771
   )
   @Export("__z")
   int __z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 173672931
   )
   @Export("__j")
   int __j;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 219840779
   )
   @Export("__s")
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
   @Export("__y")
   int __y;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1359854411
   )
   @Export("__b")
   int __b;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "39"
   )
   @Export("__m_370")
   void __m_370() {
      this.patch = null;
      this.rawSound = null;
      this.__w = null;
      this.stream = null;
   }
}
