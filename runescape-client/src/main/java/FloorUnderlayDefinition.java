import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1109283477
   )
   public int field2819;
   @ObfuscatedName("d")
   public static IndexDataBase field2820;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2066705291
   )
   int field2821 = 0;
   @ObfuscatedName("c")
   public static NodeCache field2822 = new NodeCache(64);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1953708393
   )
   public int field2823;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 813249313
   )
   public int field2824;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2049356051
   )
   public int field2825;
   @ObfuscatedName("km")
   static class112 field2828;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1734456081"
   )
   public void method3488(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3506(var1, var3, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1566703063"
   )
   public void method3490() {
      this.method3493(this.field2821);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "3"
   )
   public static void method3492(int var0) {
      if(class159.field2063 != 0) {
         class159.field2069 = var0;
      } else {
         class159.field2066.method3002(var0);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-477473193"
   )
   void method3493(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field2823 = (int)(256.0D * var14);
      this.field2819 = (int)(var16 * 256.0D);
      if(this.field2823 < 0) {
         this.field2823 = 0;
      } else if(this.field2823 > 255) {
         this.field2823 = 255;
      }

      if(this.field2819 < 0) {
         this.field2819 = 0;
      } else if(this.field2819 > 255) {
         this.field2819 = 255;
      }

      if(var16 > 0.5D) {
         this.field2824 = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.field2824 = (int)(var14 * var16 * 512.0D);
      }

      if(this.field2824 < 1) {
         this.field2824 = 1;
      }

      this.field2825 = (int)((double)this.field2824 * var12);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "555236040"
   )
   void method3506(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2821 = var1.read24BitInt();
      }

   }
}
