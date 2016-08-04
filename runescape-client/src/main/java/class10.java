import java.awt.Canvas;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class10 extends class110 {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1338980993
   )
   static int field165;
   @ObfuscatedName("jx")
   static class176[] field169;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 577181087
   )
   static int field171;
   @ObfuscatedName("bm")
   static class171 field172;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIILclass111;S)Z",
      garbageValue = "150"
   )
   protected boolean vmethod2486(int var1, int var2, int var3, class111 var4) {
      return var2 == super.field1951 && super.field1948 == var3;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/awt/Component;III)Lclass59;",
      garbageValue = "-937612401"
   )
   public static final class59 method141(class139 var0, Component var1, int var2, int var3) {
      if(class59.field1254 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class72 var4 = new class72();
            var4.field1248 = new int[256 * (class59.field1264?2:1)];
            var4.field1253 = var3;
            var4.vmethod1627(var1);
            var4.field1252 = 1024 + (var3 & -1024);
            if(var4.field1252 > 16384) {
               var4.field1252 = 16384;
            }

            var4.vmethod1628(var4.field1252);
            if(class59.field1245 > 0 && null == class186.field3013) {
               class186.field3013 = new class75();
               class186.field3013.field1427 = var0;
               var0.method3029(class186.field3013, class59.field1245);
            }

            if(class186.field3013 != null) {
               if(class186.field3013.field1424[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class186.field3013.field1424[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class59();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "121"
   )
   static void method143() {
      client var0 = client.field477;
      synchronized(client.field477) {
         Container var1 = client.field477.method3174();
         if(null != var1) {
            class78.field1450 = Math.max(var1.getSize().width, class102.field1757);
            class144.field2220 = Math.max(var1.getSize().height, class128.field2089);
            if(class114.field2013 == var1) {
               Insets var2 = class114.field2013.getInsets();
               class78.field1450 -= var2.right + var2.left;
               class144.field2220 -= var2.top + var2.bottom;
            }

            if(class78.field1450 <= 0) {
               class78.field1450 = 1;
            }

            if(class144.field2220 <= 0) {
               class144.field2220 = 1;
            }

            if(class53.method1139() == 1) {
               class189.field3056 = client.field508;
               class39.field892 = client.field321 * 503;
            } else {
               class189.field3056 = Math.min(class78.field1450, 7680);
               class39.field892 = Math.min(class144.field2220, 2160);
            }

            class147.field2268 = (class78.field1450 - class189.field3056) / 2;
            class147.field2262 = 0;
            class107.field1867.setSize(class189.field3056, class39.field892);
            int var3 = class189.field3056;
            int var4 = class39.field892;
            Canvas var5 = class107.field1867;

            Object var14;
            try {
               class84 var6 = new class84();
               var6.vmethod1964(var3, var4, var5);
               var14 = var6;
            } catch (Throwable var12) {
               class78 var7 = new class78();
               var7.vmethod1964(var3, var4, var5);
               var14 = var7;
            }

            class54.field1173 = (class80)var14;
            if(var1 == class114.field2013) {
               Insets var15 = class114.field2013.getInsets();
               class107.field1867.setLocation(class147.field2268 + var15.left, class147.field2262 + var15.top);
            } else {
               class107.field1867.setLocation(class147.field2268, class147.field2262);
            }

            class4.method44();
            if(client.field495 != -1) {
               int var10 = client.field495;
               int var11 = class189.field3056;
               int var8 = class39.field892;
               if(class14.method179(var10)) {
                  class0.method2(class176.field2836[var10], -1, var11, var8, true);
               }
            }

            class142.method3088();
         }
      }
   }
}
