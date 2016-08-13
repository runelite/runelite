import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class47 extends CacheableNode {
   @ObfuscatedName("r")
   public boolean field1071 = false;
   @ObfuscatedName("m")
   static class227 field1072;
   @ObfuscatedName("g")
   static NodeCache field1073 = new NodeCache(64);
   @ObfuscatedName("b")
   static ModIcon field1075;
   @ObfuscatedName("l")
   public static class170 field1076;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "1690118408"
   )
   static final void method998(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class26.field649.length; ++var2) {
         class26.field649[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class26.field649[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class144.field2226[var5] = (class26.field649[128 + var5] + class26.field649[var5 - 128] + class26.field649[var5 + 1] + class26.field649[var5 - 1]) / 4;
            }
         }

         int[] var6 = class26.field649;
         class26.field649 = class144.field2226;
         class144.field2226 = var6;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = 16 + var4 + var0.offsetX;
                  int var8 = var0.offsetY + var3 + 16;
                  int var7 = var5 + (var8 << 7);
                  class26.field649[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1196405378"
   )
   void method999(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1000(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1673014659"
   )
   void method1000(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1071 = true;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-1376592207"
   )
   public static byte[] method1004(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])((byte[])var0));
         return var1?class118.method2561(var3):var3;
      } else if(var0 instanceof class128) {
         class128 var2 = (class128)var0;
         return var2.vmethod2938();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "424684931"
   )
   protected static final void method1008() {
      class137.field2129 = null;
      class1.field18 = null;
      class20.field584 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-540361836"
   )
   static final void method1009() {
      if(null != class125.field2069) {
         class125.field2069.method1294();
      }

      if(Projectile.field127 != null) {
         Projectile.field127.method1294();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2130688362"
   )
   public static int method1011() {
      return ++class143.mouseIdleTicks - 1;
   }
}
