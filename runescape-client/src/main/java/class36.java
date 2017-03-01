import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class36 {
   @ObfuscatedName("y")
   static final BigInteger field770 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("p")
   static final BigInteger field771 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("na")
   static class57 field772;

   class36() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "26320"
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
         var1 = Client.field334.readUnsignedShort();
         var2 = Client.field334.method2922();
         var3 = Client.field334.readUnsignedShort();
         XItemContainer.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               XItemContainer.xteaKeys[var4][var5] = Client.field334.readInt();
            }
         }

         Buffer.mapRegions = new int[var3];
         Script.field959 = new int[var3];
         class118.field1847 = new int[var3];
         class145.field2009 = new byte[var3][];
         Player.field267 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (6 + var1) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  Buffer.mapRegions[var3] = var7;
                  Script.field959[var3] = class154.field2094.method3426("m" + var5 + "_" + var6);
                  class118.field1847[var3] = class154.field2094.method3426("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class179.method3348(var1, var2);
      } else {
         var1 = Client.field334.readUnsignedShort();
         var2 = Client.field334.method2924();
         var3 = Client.field334.readUnsignedShort();
         Client.field334.method3165();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field334.method3147(1);
                  if(var7 == 1) {
                     Client.field351[var4][var5][var6] = Client.field334.method3147(26);
                  } else {
                     Client.field351[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field334.method3148();
         XItemContainer.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               XItemContainer.xteaKeys[var4][var5] = Client.field334.readInt();
            }
         }

         Buffer.mapRegions = new int[var3];
         Script.field959 = new int[var3];
         class118.field1847 = new int[var3];
         class145.field2009 = new byte[var3][];
         Player.field267 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field351[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == Buffer.mapRegions[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        Buffer.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        Script.field959[var3] = class154.field2094.method3426("m" + var11 + "_" + var12);
                        class118.field1847[var3] = class154.field2094.method3426("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class179.method3348(var2, var1);
      }

   }
}
