import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 82695789
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1459466075
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 510823575
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 354489651
   )
   int field1648;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 68790567
   )
   @Export("y")
   int y;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIIZI)V",
      garbageValue = "927544741"
   )
   public static void method2209(class170 var0, int var1, int var2, int var3, boolean var4) {
      class186.field3010 = 1;
      class35.field800 = var0;
      FrameMap.field1823 = var1;
      class186.field3015 = var2;
      class186.field3016 = var3;
      class186.field3017 = var4;
      class54.field1154 = 10000;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1441768123"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.field351 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.field351) {
         var1 = Client.field347.method2572();
         var2 = Client.field347.method2528();
         var3 = Client.field347.method2546();
         class113.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class113.xteaKeys[var4][var5] = Client.field347.method2549();
            }
         }

         class16.mapRegions = new int[var3];
         class145.field2227 = new int[var3];
         Client.field586 = new int[var3];
         class4.field76 = new byte[var3][];
         class174.field2779 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class16.mapRegions[var3] = var7;
                  class145.field2227[var3] = class9.field173.method3304("m" + var5 + "_" + var6);
                  Client.field586[var3] = class9.field173.method3304("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class18.method201(var1, var2);
      } else {
         var1 = Client.field347.method2572();
         var2 = Client.field347.method2546();
         var3 = Client.field347.method2546();
         Client.field347.method2786();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field347.method2787(1);
                  if(var7 == 1) {
                     Client.field364[var4][var5][var6] = Client.field347.method2787(26);
                  } else {
                     Client.field364[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field347.method2790();
         class113.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class113.xteaKeys[var4][var5] = Client.field347.method2549();
            }
         }

         class16.mapRegions = new int[var3];
         class145.field2227 = new int[var3];
         Client.field586 = new int[var3];
         class4.field76 = new byte[var3][];
         class174.field2779 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field364[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class16.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class16.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class145.field2227[var3] = class9.field173.method3304("m" + var11 + "_" + var12);
                        Client.field586[var3] = class9.field173.method3304("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class18.method201(var1, var2);
      }

   }
}
