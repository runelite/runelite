import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("p")
   static NodeCache field3343;
   @ObfuscatedName("n")
   public static IndexDataBase field3344;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1461836081
   )
   int field3345;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -363993371
   )
   public int field3346;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 974682951
   )
   public int field3347;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 679589559
   )
   public int field3348;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -847583687
   )
   public int field3349;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2118554941"
   )
   void method4372(int var1) {
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
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field3347 = (int)(var14 * 256.0D);
      this.field3348 = (int)(256.0D * var16);
      if(this.field3347 < 0) {
         this.field3347 = 0;
      } else if(this.field3347 > 255) {
         this.field3347 = 255;
      }

      if(this.field3348 < 0) {
         this.field3348 = 0;
      } else if(this.field3348 > 255) {
         this.field3348 = 255;
      }

      if(var16 > 0.5D) {
         this.field3349 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field3349 = (int)(var16 * var14 * 512.0D);
      }

      if(this.field3349 < 1) {
         this.field3349 = 1;
      }

      this.field3346 = (int)(var12 * (double)this.field3349);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1494834850"
   )
   void method4373(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4374(var1, var3, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-758935839"
   )
   void method4374(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field3345 = var1.read24BitInt();
      }

   }

   static {
      field3343 = new NodeCache(64);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1151992678"
   )
   void method4380() {
      this.method4372(this.field3345);
   }

   FloorUnderlayDefinition() {
      this.field3345 = 0;
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   static void method4390(String var0) {
      class47.field598 = var0;

      try {
         String var1 = class46.field590.getParameter(class274.field3724.field3728);
         String var2 = class46.field590.getParameter(class274.field3726.field3728);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + TextureProvider.method2414(class134.method2587() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class52.method753(class46.field590, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }
}
