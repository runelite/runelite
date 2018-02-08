import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class185 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 474002585
   )
   static int field2520;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 775708239
   )
   static int field2519;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1918999137
   )
   static int field2521;
   @ObfuscatedName("h")
   static byte[][] field2522;
   @ObfuscatedName("i")
   static byte[][] field2518;
   @ObfuscatedName("w")
   static byte[][] field2523;

   static {
      field2520 = 0;
      field2519 = 0;
      field2521 = 0;
      field2522 = new byte[1000][];
      field2518 = new byte[250][];
      field2523 = new byte[50][];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ljl;",
      garbageValue = "1792353026"
   )
   public static class262 method3760(int var0) {
      class262 var1 = (class262)class262.field3466.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class262.field3468.getConfigData(11, var0);
         var1 = new class262();
         if(var2 != null) {
            var1.method4831(new Buffer(var2));
         }

         var1.method4845();
         class262.field3466.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "-1288382285"
   )
   static synchronized byte[] method3753(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2520 > 0) {
         var2 = field2522[--field2520];
         field2522[field2520] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2519 > 0) {
         var2 = field2518[--field2519];
         field2518[field2519] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2521 > 0) {
         var2 = field2523[--field2521];
         field2523[field2521] = null;
         return var2;
      }

      if(class225.field2731 != null) {
         for(int var4 = 0; var4 < FileOnDisk.field1475.length; ++var4) {
            if(FileOnDisk.field1475[var4] != var0) {
               if(var0 < FileOnDisk.field1475[var4]) {
                  ;
               }
            } else if(TotalQuantityComparator.field287[var4] > 0) {
               byte[] var3 = class225.field2731[var4][--TotalQuantityComparator.field287[var4]];
               class225.field2731[var4][TotalQuantityComparator.field287[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lcp;",
      garbageValue = "-1034065407"
   )
   static AttackOption[] method3758() {
      return new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1004131221"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = ClientPacket.getSmoothNoise2D(var3, var5);
      int var8 = ClientPacket.getSmoothNoise2D(var3 + 1, var5);
      int var9 = ClientPacket.getSmoothNoise2D(var3, var5 + 1);
      int var10 = ClientPacket.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var10 * var14 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
      return var15;
   }
}
