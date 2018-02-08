import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1613868595
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Les;",
      garbageValue = "-25440425"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cx")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "155785843"
   )
   public static void method3110(int var0, int var1) {
      Varbit var2 = IndexFile.method3336(var0);
      int var3 = var2.configId;
      int var4 = var2.leastSignificantBit;
      int var5 = var2.mostSignificantBit;
      int var6 = class222.varpsMasks[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class222.widgetSettings[var3] = class222.widgetSettings[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "214890999"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3320 != 0 && var3 > IndexDataBase.field3320) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3320 == 0 || var6 <= IndexDataBase.field3320)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class178.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }
}
