import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public final class class104 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1376057967
   )
   int field1786;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 345869361
   )
   int field1787;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 465893237
   )
   int field1788;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -972612865
   )
   int field1789;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1564094591
   )
   int field1792;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 425792819
   )
   int field1793;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -421189439
   )
   int field1794;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1809617515
   )
   int field1795;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -798794623
   )
   int field1796;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1129139875
   )
   int field1797;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 858968563
   )
   int field1798;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1055297663
   )
   int field1799;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -674661435
   )
   int field1800;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -322196685
   )
   int field1801;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1611909969
   )
   int field1802;
   @ObfuscatedName("n")
   static int[] field1803;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1501255393
   )
   int field1804;
   @ObfuscatedName("g")
   public static String field1805;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -290619307
   )
   int field1806;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1193006571
   )
   int field1807;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)[Lclass80;",
      garbageValue = "788879052"
   )
   static class80[] method2279(class167 var0, int var1, int var2) {
      if(!class35.method714(var0, var1, var2)) {
         return null;
      } else {
         class80[] var3 = new class80[class76.field1395];

         for(int var4 = 0; var4 < class76.field1395; ++var4) {
            class80 var5 = var3[var4] = new class80();
            var5.field1425 = class226.field3214;
            var5.field1432 = class76.field1386;
            var5.field1428 = class76.field1387[var4];
            var5.field1431 = class76.field1390[var4];
            var5.field1427 = class76.field1389[var4];
            var5.field1429 = class9.field159[var4];
            var5.field1426 = class76.field1396;
            var5.field1430 = class21.field575[var4];
         }

         class27.method633();
         return var3;
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   static final void method2280(boolean var0) {
      client.field403 = 0;
      client.field319 = 0;
      client.field324.method2739();
      int var1 = client.field324.method2750(8);
      int var2;
      if(var1 < client.field317) {
         for(var2 = var1; var2 < client.field317; ++var2) {
            client.field404[++client.field403 - 1] = client.field318[var2];
         }
      }

      if(var1 > client.field317) {
         throw new RuntimeException("");
      } else {
         client.field317 = 0;

         int var3;
         int var4;
         int var5;
         int var6;
         for(var2 = 0; var2 < var1; ++var2) {
            int var7 = client.field318[var2];
            class34 var8 = client.field515[var7];
            var3 = client.field324.method2750(1);
            if(0 == var3) {
               client.field318[++client.field317 - 1] = var7;
               var8.field864 = client.field335;
            } else {
               var4 = client.field324.method2750(2);
               if(0 == var4) {
                  client.field318[++client.field317 - 1] = var7;
                  var8.field864 = client.field335;
                  client.field320[++client.field319 - 1] = var7;
               } else if(1 == var4) {
                  client.field318[++client.field317 - 1] = var7;
                  var8.field864 = client.field335;
                  var5 = client.field324.method2750(3);
                  var8.method696(var5, (byte)1);
                  var6 = client.field324.method2750(1);
                  if(var6 == 1) {
                     client.field320[++client.field319 - 1] = var7;
                  }
               } else if(var4 == 2) {
                  client.field318[++client.field317 - 1] = var7;
                  var8.field864 = client.field335;
                  var5 = client.field324.method2750(3);
                  var8.method696(var5, (byte)2);
                  var6 = client.field324.method2750(3);
                  var8.method696(var6, (byte)2);
                  int var9 = client.field324.method2750(1);
                  if(var9 == 1) {
                     client.field320[++client.field319 - 1] = var7;
                  }
               } else if(var4 == 3) {
                  client.field404[++client.field403 - 1] = var7;
               }
            }
         }

         class27.method632(var0);

         for(var1 = 0; var1 < client.field319; ++var1) {
            var2 = client.field320[var1];
            class34 var10 = client.field515[var2];
            int var11 = client.field324.method2492();
            if(0 != (var11 & 32)) {
               var3 = client.field324.method2526();
               var4 = client.field324.method2526();
               var5 = var10.field823 - 64 * (var3 - class22.field594 - class22.field594);
               var6 = var10.field813 - 64 * (var4 - class114.field1981 - class114.field1981);
               if(var5 != 0 || 0 != var6) {
                  var10.field824 = (int)(Math.atan2((double)var5, (double)var6) * 325.949D) & 2047;
               }
            }

            if((var11 & 2) != 0) {
               var10.field782 = class99.method2179(client.field324.method2527());
               var10.field872 = var10.field782.field887;
               var10.field852 = var10.field782.field895;
               var10.field820 = var10.field782.field894;
               var10.field821 = var10.field782.field909;
               var10.field847 = var10.field782.field892;
               var10.field855 = var10.field782.field897;
               var10.field817 = var10.field782.field914;
               var10.field860 = var10.field782.field899;
               var10.field839 = var10.field782.field893;
            }

            if((var11 & 64) != 0) {
               var3 = client.field324.method2492();
               var4 = client.field324.method2492();
               var10.method729(var3, var4, client.field335);
               var10.field867 = client.field335 + 300;
               var10.field846 = client.field324.method2584();
               var10.field835 = client.field324.method2526();
            }

            if((var11 & 16) != 0) {
               var3 = client.field324.method2520();
               var4 = client.field324.method2518();
               var10.method729(var3, var4, client.field335);
               var10.field867 = client.field335 + 300;
               var10.field846 = client.field324.method2526();
               var10.field835 = client.field324.method2533();
            }

            if(0 != (var11 & 4)) {
               var10.field848 = client.field324.method2527();
               var3 = client.field324.method2497();
               var10.field859 = var3 >> 16;
               var10.field825 = (var3 & '\uffff') + client.field335;
               var10.field849 = 0;
               var10.field822 = 0;
               if(var10.field825 > client.field335) {
                  var10.field849 = -1;
               }

               if('\uffff' == var10.field848) {
                  var10.field848 = -1;
               }
            }

            if(0 != (var11 & 8)) {
               var10.field837 = client.field324.method2584();
               if(var10.field837 == '\uffff') {
                  var10.field837 = -1;
               }
            }

            if((var11 & 128) != 0) {
               var3 = client.field324.method2533();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = client.field324.method2492();
               if(var10.field843 == var3 && -1 != var3) {
                  var5 = class4.method42(var3).field988;
                  if(1 == var5) {
                     var10.field844 = 0;
                     var10.field845 = 0;
                     var10.field851 = var4;
                     var10.field826 = 0;
                  }

                  if(2 == var5) {
                     var10.field826 = 0;
                  }
               } else if(var3 == -1 || -1 == var10.field843 || class4.method42(var3).field993 >= class4.method42(var10.field843).field993) {
                  var10.field843 = var3;
                  var10.field844 = 0;
                  var10.field845 = 0;
                  var10.field851 = var4;
                  var10.field826 = 0;
                  var10.field870 = var10.field841;
               }
            }

            if((var11 & 1) != 0) {
               var10.field819 = client.field324.method2500();
               var10.field828 = 100;
            }
         }

         for(var1 = 0; var1 < client.field403; ++var1) {
            var2 = client.field404[var1];
            if(client.field515[var2].field864 != client.field335) {
               client.field515[var2].field782 = null;
               client.field515[var2] = null;
            }
         }

         if(client.field324.field2005 != client.field325) {
            throw new RuntimeException(client.field324.field2005 + "," + client.field325);
         } else {
            for(var1 = 0; var1 < client.field317; ++var1) {
               if(null == client.field515[client.field318[var1]]) {
                  throw new RuntimeException(var1 + "," + client.field317);
               }
            }

         }
      }
   }
}
