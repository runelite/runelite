import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("BoundingBox")
public abstract class BoundingBox extends Node {
   @ObfuscatedName("as")
   static int[] field238;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1068243907
   )
   static int field239;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 2059250391
   )
   static int field240;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1781276934"
   )
   @Export("draw")
   public abstract void draw();
}
