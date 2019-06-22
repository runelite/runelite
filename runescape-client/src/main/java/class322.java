import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("le")
public class class322 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   @Export("reflectionChecks")
   public static IterableNodeDeque reflectionChecks;

   static {
      reflectionChecks = new IterableNodeDeque();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;III)Lln;",
      garbageValue = "-2000477161"
   )
   @Export("readSprite")
   public static Sprite readSprite(AbstractIndexCache var0, int var1, int var2) {
      return !SpriteMask.method4392(var0, var1, var2)?null:class258.method4900();
   }
}
