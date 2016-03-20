import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class185 extends class66 {
   @ObfuscatedName("dk")
   static byte[][] field2994;
   @ObfuscatedName("r")
   class198 field2995 = new class198();
   @ObfuscatedName("f")
   class55 field2996 = new class55();
   @ObfuscatedName("a")
   class183 field2997;

   @ObfuscatedName("g")
   protected class66 vmethod3752() {
      class186 var1;
      do {
         var1 = (class186)this.field2995.method3861();
         if(null == var1) {
            return null;
         }
      } while(var1.field3017 == null);

      return var1.field3017;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass186;[IIIII)V",
      garbageValue = "-321520927"
   )
   void method3756(class186 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2997.field2957[var1.field3011] & 4) != 0 && var1.field3013 < 0) {
         int var6 = this.field2997.field2969[var1.field3011] / class56.field1185;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3002) / var6;
            if(var7 > var4) {
               var1.field3002 += var6 * var4;
               break;
            }

            var1.field3017.vmethod3779(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3002 += var6 * var7 - 1048576;
            int var8 = class56.field1185 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3017;
            if(0 == this.field2997.field2967[var1.field3011]) {
               var1.field3017 = class64.method1327(var1.field3001, var10.method1342(), var10.method1333(), var10.method1441());
            } else {
               var1.field3017 = class64.method1327(var1.field3001, var10.method1342(), 0, var10.method1441());
               this.field2997.method3633(var1, var1.field3005.field2921[var1.field3004] < 0);
               var1.field3017.method1483(var8, var10.method1333());
            }

            if(var1.field3005.field2921[var1.field3004] < 0) {
               var1.field3017.method1329(-1);
            }

            var10.method1380(var8);
            var10.vmethod3779(var2, var3, var5 - var3);
            if(var10.method1442()) {
               this.field2996.method1152(var10);
            }
         }
      }

      var1.field3017.vmethod3779(var2, var3, var4);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass186;II)V",
      garbageValue = "412414074"
   )
   void method3757(class186 var1, int var2) {
      if((this.field2997.field2957[var1.field3011] & 4) != 0 && var1.field3013 < 0) {
         int var3 = this.field2997.field2969[var1.field3011] / class56.field1185;
         int var4 = (var3 + 1048575 - var1.field3002) / var3;
         var1.field3002 = var3 * var2 + var1.field3002 & 1048575;
         if(var4 <= var2) {
            if(this.field2997.field2967[var1.field3011] == 0) {
               var1.field3017 = class64.method1327(var1.field3001, var1.field3017.method1342(), var1.field3017.method1333(), var1.field3017.method1441());
            } else {
               var1.field3017 = class64.method1327(var1.field3001, var1.field3017.method1342(), 0, var1.field3017.method1441());
               this.field2997.method3633(var1, var1.field3005.field2921[var1.field3004] < 0);
            }

            if(var1.field3005.field2921[var1.field3004] < 0) {
               var1.field3017.method1329(-1);
            }

            var2 = var1.field3002 / var3;
         }
      }

      var1.field3017.vmethod3765(var2);
   }

   @ObfuscatedName("l")
   protected void vmethod3765(int var1) {
      this.field2996.vmethod3765(var1);

      for(class186 var3 = (class186)this.field2995.method3860(); null != var3; var3 = (class186)this.field2995.method3861()) {
         if(!this.field2997.method3655(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3018) {
                  this.method3757(var3, var2);
                  var3.field3018 -= var2;
                  break;
               }

               this.method3757(var3, var3.field3018);
               var2 -= var3.field3018;
            } while(!this.field2997.method3723(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass80;I)V",
      garbageValue = "1126315940"
   )
   static final void method3766(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class21.field590.length; ++var2) {
         class21.field590[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class21.field590[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class149.field2229[var5] = (class21.field590[128 + var5] + class21.field590[var5 - 128] + class21.field590[var5 - 1] + class21.field590[var5 + 1]) / 4;
            }
         }

         int[] var8 = class21.field590;
         class21.field590 = class149.field2229;
         class149.field2229 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1417; ++var3) {
            for(var4 = 0; var4 < var0.field1418; ++var4) {
               if(var0.field1423[var2++] != 0) {
                  var5 = 16 + var4 + var0.field1419;
                  int var6 = var0.field1421 + var3 + 16;
                  int var7 = (var6 << 7) + var5;
                  class21.field590[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   protected class66 vmethod3767() {
      class186 var1 = (class186)this.field2995.method3860();
      return (class66)(null == var1?null:(null != var1.field3017?var1.field3017:this.vmethod3752()));
   }

   class185(class183 var1) {
      this.field2997 = var1;
   }

   @ObfuscatedName("m")
   protected int vmethod3770() {
      return 0;
   }

   @ObfuscatedName("al")
   static final void method3778(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = 6 + var2;
      int var5 = class72.field1348.method4054(var0, 250);
      int var6 = class72.field1348.method4055(var0, 250) * 13;
      class79.method1830(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 0);
      class79.method1853(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 16777215);
      class72.field1348.method4095(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class18.method210(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class45.field1042.getGraphics();
            class139.field2149.vmethod1900(var7, 0, 0);
         } catch (Exception var8) {
            class45.field1042.repaint();
         }
      } else {
         class0.method4(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("j")
   protected void vmethod3779(int[] var1, int var2, int var3) {
      this.field2996.vmethod3779(var1, var2, var3);

      for(class186 var6 = (class186)this.field2995.method3860(); var6 != null; var6 = (class186)this.field2995.method3861()) {
         if(!this.field2997.method3655(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3018) {
                  this.method3756(var6, var1, var4, var5, var4 + var5);
                  var6.field3018 -= var5;
                  break;
               }

               this.method3756(var6, var1, var4, var6.field3018, var4 + var5);
               var4 += var6.field3018;
               var5 -= var6.field3018;
            } while(!this.field2997.method3723(var6, var1, var4, var5));
         }
      }

   }
}
