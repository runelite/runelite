import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class174 {
   @ObfuscatedName("w")
   static byte[][] field2416;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 572805841
   )
   static int field2417;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 631299737
   )
   static int field2418;
   @ObfuscatedName("t")
   static byte[][] field2419;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1061875211
   )
   static int field2420;
   @ObfuscatedName("z")
   static byte[][] field2421;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-962317979"
   )
   static synchronized byte[] method3248(int var0) {
      byte[] var1;
      if(var0 == 100 && field2420 > 0) {
         var1 = field2419[--field2420];
         field2419[field2420] = null;
         return var1;
      } else if(var0 == 5000 && field2417 > 0) {
         var1 = field2416[--field2417];
         field2416[field2417] = null;
         return var1;
      } else if(var0 == 30000 && field2418 > 0) {
         var1 = field2421[--field2418];
         field2421[field2418] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   static {
      field2420 = 0;
      field2417 = 0;
      field2418 = 0;
      field2419 = new byte[1000][];
      field2416 = new byte[250][];
      field2421 = new byte[50][];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1231322464"
   )
   static final void method3250(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class267.field3669[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   public static String method3252(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class268.field3673[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "4"
   )
   static final void method3253(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.method3487(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.method3512()) {
         if(var10.level == var0 && var1 == var10.x && var10.y == var2 && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class50.method727(var9);
         Client.pendingSpawns.method3505(var9);
      }

      var9.id = var4;
      var9.field1196 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
