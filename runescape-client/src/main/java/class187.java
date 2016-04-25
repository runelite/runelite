import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class187 extends class208 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1435375133
   )
   int field3012;
   @ObfuscatedName("m")
   class62 field3013;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 1568772507
   )
   @Export("baseX")
   static int field3014;
   @ObfuscatedName("z")
   class185 field3015;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -694649201
   )
   int field3016;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1828268863
   )
   int field3017;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1500949737
   )
   int field3018;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1751343027
   )
   int field3020;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -575184693
   )
   int field3021;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1282250057
   )
   int field3022;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 47369313
   )
   int field3023;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1593782701
   )
   int field3024;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1433524271
   )
   int field3025;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -266907503
   )
   int field3026;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -811498585
   )
   int field3027;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 173879289
   )
   int field3029;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2066463869
   )
   int field3030;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -571169889
   )
   int field3031;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 201667431
   )
   int field3032;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -330852881
   )
   int field3034;
   @ObfuscatedName("y")
   class64 field3035;
   @ObfuscatedName("h")
   class181 field3036;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "195901739"
   )
   void method3696() {
      this.field3036 = null;
      this.field3013 = null;
      this.field3015 = null;
      this.field3035 = null;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "0"
   )
   static final void method3698(boolean var0) {
      client.field336 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field336) {
         var1 = client.field320.method2534();
         var2 = client.field320.method2534();
         var3 = client.field320.method2502();
         class7.field132 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class7.field132[var4][var5] = client.field320.method2505();
            }
         }

         class98.field1638 = new int[var3];
         class40.field904 = new int[var3];
         class50.field1083 = new int[var3];
         class31.field728 = new byte[var3][];
         class164.field2646 = new byte[var3][];
         boolean var13 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var13 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (6 + var1) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || 49 != var6 && 149 != var6 && 147 != var6 && 50 != var5 && (49 != var5 || 47 != var6)) {
                  class98.field1638[var3] = var7;
                  class40.field904[var3] = class158.field2578.method3232("m" + var5 + "_" + var6);
                  class50.field1083[var3] = class158.field2578.method3232("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class4.method34(var2, var1);
      } else {
         var1 = client.field320.method2535();
         var2 = client.field320.method2502();
         var3 = client.field320.method2502();
         client.field320.method2736();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field320.method2737(1);
                  if(1 == var7) {
                     client.field337[var4][var5][var6] = client.field320.method2737(26);
                  } else {
                     client.field337[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field320.method2733();
         class7.field132 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class7.field132[var4][var5] = client.field320.method2505();
            }
         }

         class98.field1638 = new int[var3];
         class40.field904 = new int[var3];
         class50.field1083 = new int[var3];
         class31.field728 = new byte[var3][];
         class164.field2646 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field337[var4][var5][var6];
                  if(-1 != var7) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class98.field1638[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(-1 != var10) {
                        class98.field1638[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class40.field904[var3] = class158.field2578.method3232("m" + var11 + "_" + var12);
                        class50.field1083[var3] = class158.field2578.method3232("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class4.method34(var1, var2);
      }

   }
}
