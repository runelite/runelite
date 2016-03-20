import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("GameObject")
public final class class97 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1618181379
   )
   @Export("x")
   int field1650;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1333066751
   )
   @Export("height")
   int field1651;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1282112201
   )
   @Export("hash")
   public int field1653 = 0;
   @ObfuscatedName("y")
   @Export("renderable")
   public class84 field1654;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -193714387
   )
   @Export("orientation")
   int field1655;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -475625613
   )
   @Export("relativeX")
   int field1656;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 470862905
   )
   @Export("offsetX")
   int field1657;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1454343935
   )
   @Export("flags")
   int field1658 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -592102683
   )
   int field1659;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1990596615
   )
   @Export("offsetY")
   int field1660;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 398697699
   )
   @Export("relativeY")
   int field1661;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1330274781
   )
   @Export("plane")
   int field1662;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1902285057
   )
   @Export("y")
   int field1663;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1345694209
   )
   int field1664;

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(Lclass172;IIII)V",
      garbageValue = "733697752"
   )
   static final void method2214(class172 var0, int var1, int var2, int var3) {
      class10.method146();
      class174 var4 = var0.method3433(false);
      if(null != var4) {
         class79.method1852(var1, var2, var1 + var4.field2884, var4.field2883 + var2);
         if(client.field530 != 2 && 5 != client.field530) {
            int var5 = client.field546 + client.field495 & 2047;
            int var6 = 48 + class151.field2253.field870 / 32;
            int var7 = 464 - class151.field2253.field813 / 32;
            class1.field21.method1780(var1, var2, var4.field2884, var4.field2883, var6, var7, var5, client.field365 + 256, var4.field2886, var4.field2885);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < client.field524; ++var8) {
               var9 = 2 + 4 * client.field363[var8] - class151.field2253.field870 / 32;
               var10 = client.field526[var8] * 4 + 2 - class151.field2253.field813 / 32;
               class47.method1000(var1, var2, var9, var10, client.field317[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  class198 var19 = client.field419[class48.field1078][var8][var9];
                  if(var19 != null) {
                     var11 = 4 * var8 + 2 - class151.field2253.field870 / 32;
                     var12 = 2 + var9 * 4 - class151.field2253.field813 / 32;
                     class47.method1000(var1, var2, var11, var12, class26.field665[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < client.field331; ++var8) {
               class34 var17 = client.field358[client.field564[var8]];
               if(var17 != null && var17.vmethod755()) {
                  class39 var20 = var17.field785;
                  if(null != var20 && null != var20.field909) {
                     var20 = var20.method774();
                  }

                  if(var20 != null && var20.field902 && var20.field889) {
                     var11 = var17.field870 / 32 - class151.field2253.field870 / 32;
                     var12 = var17.field813 / 32 - class151.field2253.field813 / 32;
                     class47.method1000(var1, var2, var11, var12, class26.field665[1], var4);
                  }
               }
            }

            var8 = class32.field774;
            int[] var18 = class32.field759;

            for(var10 = 0; var10 < var8; ++var10) {
               class2 var21 = client.field415[var18[var10]];
               if(var21 != null && var21.vmethod755() && !var21.field52 && class151.field2253 != var21) {
                  var12 = var21.field870 / 32 - class151.field2253.field870 / 32;
                  int var13 = var21.field813 / 32 - class151.field2253.field813 / 32;
                  boolean var14 = false;
                  if(class10.method140(var21.field40, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class9.field151; ++var16) {
                     if(var21.field40.equals(class42.field1003[var16].field624)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var24 = false;
                  if(class151.field2253.field45 != 0 && var21.field45 != 0 && class151.field2253.field45 == var21.field45) {
                     var24 = true;
                  }

                  if(var14) {
                     class47.method1000(var1, var2, var12, var13, class26.field665[3], var4);
                  } else if(var24) {
                     class47.method1000(var1, var2, var12, var13, class26.field665[4], var4);
                  } else if(var15) {
                     class47.method1000(var1, var2, var12, var13, class26.field665[5], var4);
                  } else {
                     class47.method1000(var1, var2, var12, var13, class26.field665[2], var4);
                  }
               }
            }

            if(client.field311 != 0 && client.field303 % 20 < 10) {
               if(1 == client.field311 && client.field312 >= 0 && client.field312 < client.field358.length) {
                  class34 var22 = client.field358[client.field312];
                  if(var22 != null) {
                     var11 = var22.field870 / 32 - class151.field2253.field870 / 32;
                     var12 = var22.field813 / 32 - class151.field2253.field813 / 32;
                     class1.method10(var1, var2, var11, var12, client.field371[1], var4);
                  }
               }

               if(client.field311 == 2) {
                  var10 = 2 + (client.field418 * 4 - class147.field2214 * 4) - class151.field2253.field870 / 32;
                  var11 = 2 + (client.field315 * 4 - class17.field257 * 4) - class151.field2253.field813 / 32;
                  class1.method10(var1, var2, var10, var11, client.field371[1], var4);
               }

               if(10 == client.field311 && client.field313 >= 0 && client.field313 < client.field415.length) {
                  class2 var23 = client.field415[client.field313];
                  if(var23 != null) {
                     var11 = var23.field870 / 32 - class151.field2253.field870 / 32;
                     var12 = var23.field813 / 32 - class151.field2253.field813 / 32;
                     class1.method10(var1, var2, var11, var12, client.field371[1], var4);
                  }
               }
            }

            if(client.field528 != 0) {
               var10 = 2 + client.field528 * 4 - class151.field2253.field870 / 32;
               var11 = 2 + client.field529 * 4 - class151.field2253.field813 / 32;
               class47.method1000(var1, var2, var10, var11, client.field371[0], var4);
            }

            if(!class151.field2253.field52) {
               class79.method1830(var4.field2884 / 2 + var1 - 1, var4.field2883 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            class79.method1839(var1, var2, 0, var4.field2886, var4.field2885);
         }

         client.field500[var3] = true;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIZB)Ljava/lang/String;",
      garbageValue = "10"
   )
   static String method2215(int var0, int var1, boolean var2) {
      if(var2 && var0 >= 0) {
         int var3 = 2;

         for(int var4 = var0 / var1; 0 != var4; ++var3) {
            var4 /= var1;
         }

         char[] var5 = new char[var3];
         var5[0] = 43;

         for(int var6 = var3 - 1; var6 > 0; --var6) {
            int var7 = var0;
            var0 /= var1;
            int var8 = var7 - var0 * var1;
            if(var8 >= 10) {
               var5[var6] = (char)(87 + var8);
            } else {
               var5[var6] = (char)(var8 + 48);
            }
         }

         return new String(var5);
      } else {
         return Integer.toString(var0, var1);
      }
   }
}
