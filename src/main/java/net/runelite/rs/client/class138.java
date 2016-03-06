package net.runelite.rs.client;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eh")
public final class class138 extends Canvas {
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 1934134293
   )
   static int field2153;
   @ObfuscatedName("j")
   Component field2155;

   public final void update(Graphics var1) {
      this.field2155.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field2155.paint(var1);
   }

   class138(Component var1) {
      this.field2155 = var1;
   }

   @ObfuscatedName("r")
   public static String method2883(CharSequence var0) {
      return class28.method652('*', var0.length());
   }

   @ObfuscatedName("h")
   static final void method2885(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class10.field165.length; ++var2) {
         class10.field165[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class10.field165[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class126.field2045[var5] = (class10.field165[var5 + 1] + class10.field165[var5 - 1] + class10.field165[var5 - 128] + class10.field165[128 + var5]) / 4;
            }
         }

         int[] var8 = class10.field165;
         class10.field165 = class126.field2045;
         class126.field2045 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1434; ++var3) {
            for(var4 = 0; var4 < var0.field1431; ++var4) {
               if(var0.field1429[var2++] != 0) {
                  var5 = var0.field1433 + 16 + var4;
                  int var6 = var3 + 16 + var0.field1430;
                  int var7 = (var6 << 7) + var5;
                  class10.field165[var7] = 0;
               }
            }
         }
      }

   }
}
