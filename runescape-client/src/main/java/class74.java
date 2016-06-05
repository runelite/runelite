import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class74 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -40883761
   )
   int field1368;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1508520803
   )
   int field1369;
   @ObfuscatedName("r")
   int[][] field1370;
   @ObfuscatedName("bj")
   static class168 field1371;
   @ObfuscatedName("my")
   static byte field1375;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "165587987"
   )
   static int method1544(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1295948137"
   )
   byte[] method1545(byte[] var1) {
      if(null != this.field1370) {
         int var2 = (int)((long)this.field1369 * (long)var1.length / (long)this.field1368) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1370[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1369;
            var9 = var5 / this.field1368;
            var4 += var9;
            var5 -= var9 * this.field1368;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1164834473"
   )
   int method1547(int var1) {
      if(this.field1370 != null) {
         var1 = 6 + (int)((long)this.field1369 * (long)var1 / (long)this.field1368);
      }

      return var1;
   }

   public class74(int var1, int var2) {
      if(var1 != var2) {
         int var3 = class30.method656(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1368 = var1;
         this.field1369 = var2;
         this.field1370 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1370[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(var6 - 7.0D + 1.0D);
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-15"
   )
   int method1555(int var1) {
      if(null != this.field1370) {
         var1 = (int)((long)this.field1369 * (long)var1 / (long)this.field1368);
      }

      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;B)Lclass78;",
      garbageValue = "-75"
   )
   public static class78 method1559(class167 var0, String var1, String var2) {
      int var3 = var0.method3236(var1);
      int var4 = var0.method3237(var3, var2);
      return class44.method907(var0, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Lclass173;",
      garbageValue = "-790519675"
   )
   public static class173 method1561(int var0, int var1) {
      class173 var2 = class170.method3344(var0);
      return var1 == -1?var2:(null != var2 && null != var2.field2770 && var1 < var2.field2770.length?var2.field2770[var1]:null);
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lclass173;I)Ljava/lang/String;",
      garbageValue = "1688117306"
   )
   static String method1562(String var0, class173 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class77.method1659(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(null != class139.field2168) {
               var7 = class14.method145(class139.field2168.field2251);
               if(class139.field2168.field2246 != null) {
                  var7 = (String)class139.field2168.field2246;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "-1393908941"
   )
   static final void method1563(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field355 + client.field302 & 2047;
         int var8 = class91.field1602[var7];
         int var9 = class91.field1603[var7];
         var8 = 256 * var8 / (client.field357 + 256);
         var9 = var9 * 256 / (256 + client.field357);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class44.field1035.method1673(var14 + 94 + var0 + 4 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class6.method79(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/awt/Component;III)Lclass56;",
      garbageValue = "1887799870"
   )
   public static final class56 method1564(class136 var0, Component var1, int var2, int var3) {
      if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class69 var7 = new class69();
            var7.field1197 = new int[(class21.field575?2:1) * 256];
            var7.field1190 = var3;
            var7.vmethod1466(var1);
            var7.field1183 = 1024 + (var3 & -1024);
            if(var7.field1183 > 16384) {
               var7.field1183 = 16384;
            }

            var7.vmethod1476(var7.field1183);
            if(class56.field1184 > 0 && class109.field1912 == null) {
               class109.field1912 = new class72();
               class109.field1912.field1357 = var0;
               var0.method2868(class109.field1912, class56.field1184);
            }

            if(class109.field1912 != null) {
               if(null != class109.field1912.field1352[var2]) {
                  throw new IllegalArgumentException();
               }

               class109.field1912.field1352[var2] = var7;
            }

            return var7;
         } catch (Throwable var6) {
            try {
               class54 var4 = new class54(var0, var2);
               var4.field1197 = new int[256 * (class21.field575?2:1)];
               var4.field1190 = var3;
               var4.vmethod1466(var1);
               var4.field1183 = 16384;
               var4.vmethod1476(var4.field1183);
               if(class56.field1184 > 0 && null == class109.field1912) {
                  class109.field1912 = new class72();
                  class109.field1912.field1357 = var0;
                  var0.method2868(class109.field1912, class56.field1184);
               }

               if(class109.field1912 != null) {
                  if(class109.field1912.field1352[var2] != null) {
                     throw new IllegalArgumentException();
                  }

                  class109.field1912.field1352[var2] = var4;
               }

               return var4;
            } catch (Throwable var5) {
               return new class56();
            }
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
