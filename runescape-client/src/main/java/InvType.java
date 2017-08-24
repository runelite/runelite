import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("inventoryCache")
   public static NodeCache inventoryCache;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexData field3283;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field3284;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1549307139
   )
   @Export("size")
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   public InvType() {
      this.size = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "1925095105"
   )
   void method4274(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-680436864"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4274(var1, var2);
      }
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(Lhx;IIII)V",
      garbageValue = "-1727303757"
   )
   static final void method4280(Widget var0, int var1, int var2, int var3) {
      class211 var4 = var0.method4031(false);
      if(var4 != null) {
         if(Client.field1079 < 3) {
            class44.compass.method5031(var1, var2, var4.field2600, var4.field2599, 25, 25, Client.mapAngle, 256, var4.field2602, var4.field2601);
         } else {
            Rasterizer2D.method4957(var1, var2, 0, var4.field2602, var4.field2601);
         }

      }
   }
}
