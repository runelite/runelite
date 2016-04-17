import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public abstract class class131 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1116697844"
   )
   public abstract void vmethod3205(Component var1);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "313"
   )
   public abstract int vmethod3208();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "214731469"
   )
   public abstract void vmethod3206(Component var1);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-1377695529"
   )
   static void method2962(class122 var0, int var1) {
      boolean var2 = var0.method2863(1) == 1;
      if(var2) {
         class32.field770[++class32.field769 - 1] = var1;
      }

      int var3 = var0.method2863(2);
      class2 var4 = client.field550[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field56 = false;
         } else if(var1 == client.field457) {
            throw new RuntimeException();
         } else {
            class32.field766[var1] = (var4.field54 << 28) + (class144.field2204 + var4.field871[0] >> 6 << 14) + (var4.field835[0] + class3.field67 >> 6);
            if(-1 != var4.field827) {
               class32.field767[var1] = var4.field827;
            } else {
               class32.field767[var1] = var4.field853;
            }

            class32.field759[var1] = var4.field842;
            client.field550[var1] = null;
            if(var0.method2863(1) != 0) {
               class175.method3529(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(1 == var3) {
            var5 = var0.method2863(3);
            var6 = var4.field871[0];
            var7 = var4.field835[0];
            if(0 == var5) {
               --var6;
               --var7;
            } else if(1 == var5) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(4 == var5) {
               ++var6;
            } else if(5 == var5) {
               --var6;
               ++var7;
            } else if(6 == var5) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 != client.field457 || var4.field844 >= 1536 && var4.field819 >= 1536 && var4.field844 < 11776 && var4.field819 < 11776) {
               if(var2) {
                  var4.field56 = true;
                  var4.field57 = var6;
                  var4.field34 = var7;
               } else {
                  var4.field56 = false;
                  var4.method19(var6, var7, class32.field772[var1]);
               }
            } else {
               var4.method20(var6, var7);
               var4.field56 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method2863(4);
            var6 = var4.field871[0];
            var7 = var4.field835[0];
            if(0 == var5) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(3 == var5) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(5 == var5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(7 == var5) {
               var6 -= 2;
            } else if(8 == var5) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(10 == var5) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(12 == var5) {
               --var6;
               var7 += 2;
            } else if(13 == var5) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(15 == var5) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 == client.field457 && (var4.field844 < 1536 || var4.field819 < 1536 || var4.field844 >= 11776 || var4.field819 >= 11776)) {
               var4.method20(var6, var7);
               var4.field56 = false;
            } else if(var2) {
               var4.field56 = true;
               var4.field57 = var6;
               var4.field34 = var7;
            } else {
               var4.field56 = false;
               var4.method19(var6, var7, class32.field772[var1]);
            }

         } else {
            var5 = var0.method2863(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2863(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.field871[0];
               var11 = var4.field835[0] + var9;
               if(client.field457 == var1 && (var4.field844 < 1536 || var4.field819 < 1536 || var4.field844 >= 11776 || var4.field819 >= 11776)) {
                  var4.method20(var10, var11);
                  var4.field56 = false;
               } else if(var2) {
                  var4.field56 = true;
                  var4.field57 = var10;
                  var4.field34 = var11;
               } else {
                  var4.field56 = false;
                  var4.method19(var10, var11, class32.field772[var1]);
               }

               var4.field54 = (byte)(var4.field54 + var7 & 3);
               if(client.field457 == var1) {
                  class42.field1002 = var4.field54;
               }

            } else {
               var6 = var0.method2863(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class144.field2204 + var4.field871[0] & 16383) - class144.field2204;
               var11 = (class3.field67 + var4.field835[0] + var9 & 16383) - class3.field67;
               if(client.field457 != var1 || var4.field844 >= 1536 && var4.field819 >= 1536 && var4.field844 < 11776 && var4.field819 < 11776) {
                  if(var2) {
                     var4.field56 = true;
                     var4.field57 = var10;
                     var4.field34 = var11;
                  } else {
                     var4.field56 = false;
                     var4.method19(var10, var11, class32.field772[var1]);
                  }
               } else {
                  var4.method20(var10, var11);
                  var4.field56 = false;
               }

               var4.field54 = (byte)(var7 + var4.field54 & 3);
               if(var1 == client.field457) {
                  class42.field1002 = var4.field54;
               }

            }
         }
      }
   }
}
