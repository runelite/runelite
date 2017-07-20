import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class203 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1297827199
   )
   public static int field2471;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   public static Track1 field2475;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static class204 field2470;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 324164759
   )
   public static int field2468;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 482845909
   )
   public static int field2473;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field2469;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field2476;
   @ObfuscatedName("r")
   public static boolean field2474;

   static {
      field2471 = 0;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "222950155"
   )
   static final void method3640(int var0) {
      int[] var1 = class43.field576.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
               class19.region.method2724(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class19.region.method2724(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class43.field576.method4949();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
               Actor.method1496(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               Actor.method1496(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1056 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class19.region.method2646(class10.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class169.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.field1135[Client.field1056] = Area.field3265[var8].method4181(false);
                  Client.field1039[Client.field1056] = var5;
                  Client.field1134[Client.field1056] = var6;
                  ++Client.field1056;
               }
            }
         }
      }

      WorldMapType1.field417.setRaster();
   }
}
