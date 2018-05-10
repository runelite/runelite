import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class13 {
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -186313731
   )
   static int field99;
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("slFlagSprites")
   static IndexedSprite[] slFlagSprites;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -865738607
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 2008638169
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1880010131
   )
   int field103;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   Coordinates field100;

   @ObfuscatedSignature(
      signature = "(ILhh;)V"
   )
   class13(int var1, Coordinates var2) {
      this.field103 = var1;
      this.field100 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lge;IB)V",
      garbageValue = "32"
   )
   static final void method125(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class81.field1176 = 0;
      FileSystem.method4619(var0);
      FontName.method5521(var0);
      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }
}
