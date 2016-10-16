import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class75 implements Runnable {
   @ObfuscatedName("nz")
   static class58 field1389;
   @ObfuscatedName("z")
   volatile class59[] field1390 = new class59[2];
   @ObfuscatedName("t")
   volatile boolean field1391 = false;
   @ObfuscatedName("y")
   volatile boolean field1392 = false;
   @ObfuscatedName("co")
   static class146 field1394;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -167376597
   )
   static int field1395;
   @ObfuscatedName("s")
   class139 field1397;

   public void run() {
      this.field1392 = true;

      try {
         while(!this.field1391) {
            class59 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1390[var1];
               if(var2 != null) {
                  var2.method1184();
               }
            }

            class16.method185(10L);
            class139 var5 = this.field1397;
            var2 = null;
            if(var5.field2141 != null) {
               for(int var3 = 0; var3 < 50 && var5.field2141.peekEvent() != null; ++var3) {
                  class16.method185(1L);
               }

               if(null != var2) {
                  var5.field2141.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         class144.method2970((String)null, var8);
      } finally {
         this.field1392 = false;
      }

   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1799195396"
   )
   static final boolean method1584(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IIIIZS)V",
      garbageValue = "9376"
   )
   static final void method1585(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field523 - Client.field522) * var5 / 100 + Client.field522;
      int var7 = var3 * var6 * 512 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field528) {
         var15 = Client.field528;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 > Client.field520) {
            var6 = Client.field520;
            var8 = 512 * var6 * var3 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class82.method1794();
               class82.method1801(var0, var1, var9, var3, -16777216);
               class82.method1801(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > Client.field529) {
         var15 = Client.field529;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 < Client.field302) {
            var6 = Client.field302;
            var8 = var15 * var2 * 334 / (512 * var6);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class82.method1794();
               class82.method1801(var0, var1, var2, var9, -16777216);
               class82.method1801(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= 2 * var9;
         }
      }

      var8 = (Client.field525 - Client.field524) * var5 / 100 + Client.field524;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 32 * var10 + 128 + 15;
            int var12 = var11 * 3 + 600;
            int var13 = class94.field1631[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method1950(var14, 500, 800, var2, var3);
      }

      Client.field530 = var0;
      Client.field531 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }
}
