import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Tile")
public final class class101 extends class208 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -392801099
   )
   int field1735;
   @ObfuscatedName("i")
   class101 field1736;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 928245533
   )
   @Export("plane")
   int field1737;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 122872717
   )
   int field1738;
   @ObfuscatedName("t")
   boolean field1739;
   @ObfuscatedName("d")
   class97 field1740;
   @ObfuscatedName("n")
   @Export("wallObject")
   class87 field1741;
   @ObfuscatedName("m")
   @Export("decorativeObject")
   class94 field1742;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -234724427
   )
   int field1743;
   @ObfuscatedName("s")
   @Export("itemLayer")
   class99 field1744;
   @ObfuscatedName("g")
   @Export("groundObject")
   class93 field1745;
   @ObfuscatedName("k")
   @Export("objects")
   class98[] field1746 = new class98[5];
   @ObfuscatedName("o")
   int[] field1747 = new int[5];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 103743485
   )
   int field1748 = 0;
   @ObfuscatedName("l")
   class89 field1749;
   @ObfuscatedName("h")
   boolean field1750;
   @ObfuscatedName("e")
   boolean field1751;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 760056327
   )
   int field1753;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1338609599
   )
   int field1754;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -299228825
   )
   int field1755;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1846527451
   )
   public static int field1756;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 140461227
   )
   @Export("y")
   int field1757;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 871308783
   )
   int field1759;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -768568223
   )
   @Export("x")
   int field1760;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -364434959
   )
   static int field1761;

   class101(int var1, int var2, int var3) {
      this.field1738 = this.field1737 = var1;
      this.field1760 = var2;
      this.field1757 = var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "121"
   )
   public static void method2343() {
      class179.field2922.method3796();
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(Lclass173;II)I",
      garbageValue = "-1598068282"
   )
   static final int method2344(class173 var0, int var1) {
      if(var0.field2866 != null && var1 < var0.field2866.length) {
         try {
            int[] var2 = var0.field2866[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.field424[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field425[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = client.field426[var2[var4++]];
               }

               int var9;
               class173 var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class153.method3177(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class141.method3001(var11).field1146 || client.field410)) {
                     for(var12 = 0; var12 < var10.field2889.length; ++var12) {
                        if(var11 + 1 == var10.field2889[var12]) {
                           var7 += var10.field2750[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class176.field2905[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class155.field2287[client.field425[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class176.field2905[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class15.field225.field40;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class155.field2285[var9]) {
                        var7 += client.field425[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class153.method3177(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class141.method3001(var11).field1146 || client.field410)) {
                     for(var12 = 0; var12 < var10.field2889.length; ++var12) {
                        if(1 + var11 == var10.field2889[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = client.field452;
               }

               if(var6 == 12) {
                  var7 = client.field453;
               }

               if(var6 == 13) {
                  var9 = class176.field2905[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class130.method2851(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = class172.field2734 + (class15.field225.field837 >> 7);
               }

               if(var6 == 19) {
                  var7 = (class15.field225.field880 >> 7) + class20.field576;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
