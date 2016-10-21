import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class130 {
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -367496431
   )
   protected static int field2099;
   @ObfuscatedName("lm")
   static class133 field2100;

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2007046961"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.field473 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.field473) {
         var1 = Client.field327.method2535();
         var2 = Client.field327.method2569();
         var3 = Client.field327.method2535();
         class143.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class143.xteaKeys[var4][var5] = Client.field327.method2538();
            }
         }

         VertexNormal.mapRegions = new int[var3];
         XGrandExchangeOffer.field3222 = new int[var3];
         FrameMap.field1826 = new int[var3];
         class8.field148 = new byte[var3][];
         MessageNode.field798 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (6 + var1) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  VertexNormal.mapRegions[var3] = var7;
                  XGrandExchangeOffer.field3222[var3] = class62.field1267.method3299("m" + var5 + "_" + var6);
                  FrameMap.field1826[var3] = class62.field1267.method3299("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class13.method155(var1, var2);
      } else {
         var1 = Client.field327.method2535();
         var2 = Client.field327.method2535();
         var3 = Client.field327.method2535();
         Client.field327.method2770();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field327.method2771(1);
                  if(var7 == 1) {
                     Client.field299[var4][var5][var6] = Client.field327.method2771(26);
                  } else {
                     Client.field299[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field327.method2778();
         class143.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class143.xteaKeys[var4][var5] = Client.field327.method2538();
            }
         }

         VertexNormal.mapRegions = new int[var3];
         XGrandExchangeOffer.field3222 = new int[var3];
         FrameMap.field1826 = new int[var3];
         class8.field148 = new byte[var3][];
         MessageNode.field798 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field299[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(VertexNormal.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        VertexNormal.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        XGrandExchangeOffer.field3222[var3] = class62.field1267.method3299("m" + var11 + "_" + var12);
                        FrameMap.field1826[var3] = class62.field1267.method3299("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class13.method155(var2, var1);
      }

   }
}
