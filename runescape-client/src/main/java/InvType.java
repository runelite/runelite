import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static IndexDataBase field3247;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("inventoryCache")
   static NodeCache inventoryCache;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1334662393
   )
   @Export("size")
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   InvType() {
      this.size = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1627662832"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4813(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "472098137"
   )
   void method4813(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(IIIILlc;Lhr;I)V",
      garbageValue = "1079660383"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class224 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5911(var10 + var5.field2570 / 2 - var4.maxWidth / 2, var5.field2575 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2570, var5.field2575, var5.field2573, var5.field2572);
            } else {
               var4.drawAt(var0 + var10 + var5.field2570 / 2 - var4.maxWidth / 2, var5.field2575 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
