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
   public static Canvas canvas;
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
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
         Client.menuOptions[Client.menuOptionCount] = var0;
         Client.menuTargets[Client.menuOptionCount] = var1;
         Client.menuTypes[Client.menuOptionCount] = var2;
         Client.menuIdentifiers[Client.menuOptionCount] = var3;
         Client.menuActionParams0[Client.menuOptionCount] = var4;
         Client.menuActionParams1[Client.menuOptionCount] = var5;
         ++Client.menuOptionCount;
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
         String var1 = class156.method3300(var0, Client.field518);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class156.method3300(var3.name, Client.field518))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class156.method3300(var3.previousName, Client.field518))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;S)V",
      garbageValue = "-24890"
   )
   static final void method2396(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
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
               ObjectComposition var21 = class160.getObjectDefinition(var11);
               int var22 = var16 & 7;
               int var23 = var15 & 7;
               int var24 = var21.field960;
               int var25 = var21.field970;
               int var26;
               if((var20 & 1) == 1) {
                  var26 = var24;
                  var24 = var25;
                  var25 = var26;
               }

               int var27 = var7 & 3;
               int var28;
               if(var27 == 0) {
                  var28 = var22;
               } else if(var27 == 1) {
                  var28 = var23;
               } else if(var27 == 2) {
                  var28 = 7 - var22 - (var24 - 1);
               } else {
                  var28 = 7 - var23 - (var25 - 1);
               }

               var26 = var28 + var2;
               int var29 = var16 & 7;
               int var30 = var15 & 7;
               int var31 = var21.field960;
               int var32 = var21.field970;
               int var33;
               if((var20 & 1) == 1) {
                  var33 = var31;
                  var31 = var32;
                  var32 = var33;
               }

               int var34 = var7 & 3;
               int var35;
               if(var34 == 0) {
                  var35 = var30;
               } else if(var34 == 1) {
                  var35 = 7 - var29 - (var31 - 1);
               } else if(var34 == 2) {
                  var35 = 7 - var30 - (var32 - 1);
               } else {
                  var35 = var29;
               }

               var33 = var3 + var35;
               if(var26 > 0 && var33 > 0 && var26 < 103 && var33 < 103) {
                  int var36 = var1;
                  if((class5.tileSettings[1][var26][var33] & 2) == 2) {
                     var36 = var1 - 1;
                  }

                  CollisionData var37 = null;
                  if(var36 >= 0) {
                     var37 = var9[var36];
                  }

                  class177.method3597(var1, var26, var33, var11, var20 + var7 & 3, var19, var8, var37);
               }
            }
         }
      }
   }
}
