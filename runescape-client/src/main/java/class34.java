import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("NPC")
public final class class34 extends class37 {
   @ObfuscatedName("c")
   public static short[][] field760;
   @ObfuscatedName("d")
   public static class167 field761;
   @ObfuscatedName("b")
   @Export("composition")
   class39 field762;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "853773613"
   )
   protected final class105 vmethod1913() {
      if(null == this.field762) {
         return null;
      } else {
         class42 var1 = super.field801 != -1 && super.field827 == 0?class17.method178(super.field801):null;
         class42 var2 = super.field818 == -1 || super.field795 == super.field818 && null != var1?null:class17.method178(super.field818);
         class105 var3 = this.field762.method771(var1, super.field822, var2, super.field819);
         if(null == var3) {
            return null;
         } else {
            var3.method2323();
            super.field839 = var3.field1436;
            if(super.field835 != -1 && super.field811 != -1) {
               class105 var4 = class32.method708(super.field835).method908(super.field811);
               if(var4 != null) {
                  var4.method2315(0, -super.field834, 0);
                  class105[] var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(this.field762.field865 == 1) {
               var3.field1811 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IBS)V",
      garbageValue = "2"
   )
   final void method722(int var1, byte var2) {
      int var3 = super.field844[0];
      int var4 = super.field831[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.field801 != -1 && class17.method178(super.field801).field978 == 1) {
         super.field801 = -1;
      }

      if(super.field808 < 9) {
         ++super.field808;
      }

      for(int var5 = super.field808; var5 > 0; --var5) {
         super.field844[var5] = super.field844[var5 - 1];
         super.field831[var5] = super.field831[var5 - 1];
         super.field846[var5] = super.field846[var5 - 1];
      }

      super.field844[0] = var3;
      super.field831[0] = var4;
      super.field846[0] = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "1"
   )
   final void method724(int var1, int var2, boolean var3) {
      if(super.field801 != -1 && class17.method178(super.field801).field978 == 1) {
         super.field801 = -1;
      }

      super.field808 = 0;
      super.field836 = 0;
      super.field847 = 0;
      super.field844[0] = var1;
      super.field831[0] = var2;
      super.field813 = super.field832 * 64 + 128 * super.field844[0];
      super.field791 = 128 * super.field831[0] + super.field832 * 64;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "9"
   )
   final boolean vmethod760() {
      return this.field762 != null;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1103334894"
   )
   static final void method731() {
      client.field332.method2792();
      int var0 = client.field332.method2784(8);
      int var1;
      if(var0 < client.field449) {
         for(var1 = var0; var1 < client.field449; ++var1) {
            client.field414[++client.field344 - 1] = client.field318[var1];
         }
      }

      if(var0 > client.field449) {
         throw new RuntimeException("");
      } else {
         client.field449 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = client.field318[var1];
            class34 var3 = client.field326[var2];
            int var4 = client.field332.method2784(1);
            if(var4 == 0) {
               client.field318[++client.field449 - 1] = var2;
               var3.field838 = client.field296;
            } else {
               int var5 = client.field332.method2784(2);
               if(var5 == 0) {
                  client.field318[++client.field449 - 1] = var2;
                  var3.field838 = client.field296;
                  client.field330[++client.field462 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     client.field318[++client.field449 - 1] = var2;
                     var3.field838 = client.field296;
                     var6 = client.field332.method2784(3);
                     var3.method722(var6, (byte)1);
                     var7 = client.field332.method2784(1);
                     if(var7 == 1) {
                        client.field330[++client.field462 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     client.field318[++client.field449 - 1] = var2;
                     var3.field838 = client.field296;
                     var6 = client.field332.method2784(3);
                     var3.method722(var6, (byte)2);
                     var7 = client.field332.method2784(3);
                     var3.method722(var7, (byte)2);
                     int var8 = client.field332.method2784(1);
                     if(var8 == 1) {
                        client.field330[++client.field462 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     client.field414[++client.field344 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)I",
      garbageValue = "517122175"
   )
   static int method734(class173 var0) {
      class201 var1 = (class201)client.field311.method3807(((long)var0.field2748 << 32) + (long)var0.field2749);
      return null != var1?var1.field3100:var0.field2820;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "4"
   )
   static final int method735(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class160.method3200(var3, var5);
      int var8 = class160.method3200(1 + var3, var5);
      int var9 = class160.method3200(var3, var5 + 1);
      int var10 = class160.method3200(1 + var3, var5 + 1);
      int var12 = 65536 - class91.field1564[1024 * var4 / var2] >> 1;
      int var11 = (var8 * var12 >> 16) + ((65536 - var12) * var7 >> 16);
      int var14 = 65536 - class91.field1564[1024 * var4 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - class91.field1564[1024 * var6 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var16 * var13 >> 16);
      return var15;
   }
}
