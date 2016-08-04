import java.awt.Canvas;
import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public final class class107 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -912550267
   )
   int field1849;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -983993287
   )
   int field1850;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1467737373
   )
   int field1851;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -99838509
   )
   int field1852;
   @ObfuscatedName("pu")
   static GarbageCollectorMXBean field1853;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1727558899
   )
   int field1854;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1678553177
   )
   int field1855;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1175617373
   )
   int field1856;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -887212975
   )
   int field1857;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1825068833
   )
   int field1858;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -648575883
   )
   int field1859;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1179132597
   )
   int field1860;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1720245405
   )
   int field1861;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 547182591
   )
   int field1862;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2126613425
   )
   int field1863;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1116415725
   )
   int field1864;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1187956039
   )
   int field1865;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 596246853
   )
   int field1866;
   @ObfuscatedName("qz")
   @Export("canvas")
   public static Canvas field1867;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -714216299
   )
   int field1868;

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "1465861288"
   )
   @Export("addMenuEntry")
   static final void method2394(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field434) {
         if(client.field368 < 500) {
            client.field440[client.field368] = var0;
            client.field510[client.field368] = var1;
            client.field438[client.field368] = var2;
            client.field291[client.field368] = var3;
            client.field436[client.field368] = var4;
            client.field437[client.field368] = var5;
            ++client.field368;
         }

      }
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Z",
      garbageValue = "20871"
   )
   static boolean method2395(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class156.method3300(var0, client.field518);

         for(int var2 = 0; var2 < client.field565; ++var2) {
            class7 var3 = client.field566[var2];
            if(var1.equalsIgnoreCase(class156.method3300(var3.field132, client.field518))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class156.method3300(var3.field131, client.field518))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILclass89;[Lclass111;S)V",
      garbageValue = "-24890"
   )
   static final void method2396(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class89 var8, class111[] var9) {
      class122 var10 = new class122(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2646();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2646();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.method2633();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < 8 + var5 && var15 >= var6 && var15 < var6 + 8) {
               class42 var21 = class160.method3312(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.field960;
               int var28 = var21.field970;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var23 + var2;
               int var32 = var16 & 7;
               int var33 = var15 & 7;
               int var35 = var21.field960;
               int var36 = var21.field970;
               int var37;
               if((var20 & 1) == 1) {
                  var37 = var35;
                  var35 = var36;
                  var36 = var37;
               }

               int var34 = var7 & 3;
               int var31;
               if(var34 == 0) {
                  var31 = var33;
               } else if(var34 == 1) {
                  var31 = 7 - var32 - (var35 - 1);
               } else if(var34 == 2) {
                  var31 = 7 - var33 - (var36 - 1);
               } else {
                  var31 = var32;
               }

               var37 = var3 + var31;
               if(var29 > 0 && var37 > 0 && var29 < 103 && var37 < 103) {
                  int var38 = var1;
                  if((class5.field80[1][var29][var37] & 2) == 2) {
                     var38 = var1 - 1;
                  }

                  class111 var39 = null;
                  if(var38 >= 0) {
                     var39 = var9[var38];
                  }

                  class177.method3597(var1, var29, var37, var11, var20 + var7 & 3, var19, var8, var39);
               }
            }
         }
      }
   }
}
