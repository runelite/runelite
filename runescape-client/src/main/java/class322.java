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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;III)Lln;",
      garbageValue = "-2000477161"
   )
   @Export("readSprite")
   public static Sprite readSprite(AbstractArchive archive, int group, int file) {
      return !SpriteMask.loadSprite(archive, group, file) ? null : class258.method4900();
   }

   static {
      reflectionChecks = new IterableNodeDeque();
   }
}
