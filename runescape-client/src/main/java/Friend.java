import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("d")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1820474391
   )
   @Export("world")
   int world;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 946818609
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -1053222353
   )
   static int field147;
   @ObfuscatedName("r")
   boolean field148;
   @ObfuscatedName("n")
   @Export("name")
   String name;
   @ObfuscatedName("aj")
   static SpritePixels[] field150;
   @ObfuscatedName("w")
   boolean field151;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-30"
   )
   public static int method189() {
      return ++class115.mouseIdleTicks - 1;
   }
}
