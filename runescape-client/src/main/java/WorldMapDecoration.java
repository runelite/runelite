import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -318235643
   )
   static int field415;
   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 834871609
   )
   @Export("objectDefinitionId")
   final int objectDefinitionId;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1468314231
   )
   @Export("decoration")
   final int decoration;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1000572825
   )
   @Export("rotation")
   final int rotation;

   WorldMapDecoration(int var1, int var2, int var3) {
      this.objectDefinitionId = var1;
      this.decoration = var2;
      this.rotation = var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "-1466354376"
   )
   public static int method289(byte[] var0, int var1) {
      return class178.method3429(var0, 0, var1);
   }
}
