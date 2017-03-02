import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class40 implements class158 {
   @ObfuscatedName("i")
   static final class40 field805 = new class40(2);
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = -2707681
   )
   static int field806;
   @ObfuscatedName("b")
   static final class40 field807 = new class40(0);
   @ObfuscatedName("t")
   static final class40 field808 = new class40(3);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 579175071
   )
   final int field809;
   @ObfuscatedName("l")
   static final class40 field810 = new class40(1);
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 1392398467
   )
   static int field812;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 751344499
   )
   static int field813;
   @ObfuscatedName("bd")
   static class184 field814;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int vmethod4183() {
      return this.field809;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZI)LFrames;",
      garbageValue = "1816530750"
   )
   public static Frames method818(class182 var0, class182 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3357(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3354(var2, var5[var6]);
         if(null == var7) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3354(var8, 0);
            if(null == var9) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-152267005"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.field329.method2894();
         var2 = Client.field329.method3057();
         var3 = Client.field329.readUnsignedShort();
         XItemContainer.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               XItemContainer.xteaKeys[var4][var5] = Client.field329.readInt();
            }
         }

         class3.mapRegions = new int[var3];
         class104.field1687 = new int[var3];
         class6.field52 = new int[var3];
         class105.field1711 = new byte[var3][];
         GameEngine.field1779 = new byte[var3][];
         boolean var13 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var13 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class3.mapRegions[var3] = var7;
                  class104.field1687[var3] = class26.field588.method3363("m" + var5 + "_" + var6);
                  class6.field52[var3] = class26.field588.method3363("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         ItemLayer.method1519(var2, var1);
      } else {
         var1 = Client.field329.method2894();
         var2 = Client.field329.method2894();
         var3 = Client.field329.readUnsignedShort();
         Client.field329.method3141();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field329.method3119(1);
                  if(var7 == 1) {
                     Client.field347[var4][var5][var6] = Client.field329.method3119(26);
                  } else {
                     Client.field347[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field329.method3125();
         XItemContainer.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               XItemContainer.xteaKeys[var4][var5] = Client.field329.readInt();
            }
         }

         class3.mapRegions = new int[var3];
         class104.field1687 = new int[var3];
         class6.field52 = new int[var3];
         class105.field1711 = new byte[var3][];
         GameEngine.field1779 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field347[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class3.mapRegions[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class3.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class104.field1687[var3] = class26.field588.method3363("m" + var11 + "_" + var12);
                        class6.field52[var3] = class26.field588.method3363("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         ItemLayer.method1519(var2, var1);
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field809 = var1;
   }
}
