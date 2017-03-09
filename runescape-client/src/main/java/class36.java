import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class36 {
   @ObfuscatedName("w")
   static final BigInteger field795 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("h")
   static final BigInteger field800 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = 1633111973
   )
   static int field805;
   @ObfuscatedName("a")
   static int[] field807;

   class36() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "35"
   )
   public static boolean method803(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1097715766"
   )
   static final void method804() {
      for(int var0 = 0; var0 < Client.field419; ++var0) {
         --Client.field558[var0];
         if(Client.field558[var0] >= -10) {
            class53 var1 = Client.field560[var0];
            if(var1 == null) {
               Object var10000 = null;
               var1 = class53.method1060(class188.field2778, Client.field556[var0], 0);
               if(null == var1) {
                  continue;
               }

               Client.field558[var0] += var1.method1052();
               Client.field560[var0] = var1;
            }

            if(Client.field558[var0] < 0) {
               int var2;
               if(Client.field559[var0] != 0) {
                  int var3 = 128 * (Client.field559[var0] & 255);
                  int var10 = Client.field559[var0] >> 16 & 255;
                  int var5 = 64 + var10 * 128 - class22.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field559[var0] >> 8 & 255;
                  int var7 = 64 + 128 * var6 - class22.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     Client.field558[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = Client.field554 * (var3 - var8) / var3;
               } else {
                  var2 = Client.field553;
               }

               if(var2 > 0) {
                  class55 var11 = var1.method1051().method1093(ItemLayer.field1224);
                  class66 var4 = class66.method1261(var11, 100, var2);
                  var4.method1339(Client.field557[var0] - 1);
                  class195.field2863.method1001(var4);
               }

               Client.field558[var0] = -100;
            }
         } else {
            --Client.field419;

            for(int var9 = var0; var9 < Client.field419; ++var9) {
               Client.field556[var9] = Client.field556[1 + var9];
               Client.field560[var9] = Client.field560[var9 + 1];
               Client.field557[var9] = Client.field557[1 + var9];
               Client.field558[var9] = Client.field558[var9 + 1];
               Client.field559[var9] = Client.field559[1 + var9];
            }

            --var0;
         }
      }

      if(Client.field552 && !Friend.method199()) {
         if(Client.field550 != 0 && Client.field445 != -1) {
            class40.method821(class3.field39, Client.field445, 0, Client.field550, false);
         }

         Client.field552 = false;
      }

   }
}
