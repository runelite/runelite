import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class31 {
   @ObfuscatedName("aa")
   protected static boolean field425;
   @ObfuscatedName("bj")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("q")
   static int[] field431;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 875591035
   )
   final int field433;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 885418291
   )
   final int field432;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1836191379
   )
   final int field426;

   class31(int var1, int var2, int var3) {
      this.field433 = var1;
      this.field432 = var2;
      this.field426 = var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Ljc;",
      garbageValue = "1796291299"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIIII[Lfu;I)V",
      garbageValue = "69365252"
   )
   static final void method269(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class40.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILit;IB)V",
      garbageValue = "-6"
   )
   static void method270(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class82 var5 = new class82();
      var5.field1304 = var0;
      var5.field1315 = var1 * 128;
      var5.field1306 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field1307 = (var6 + var1) * 128;
      var5.field1317 = (var7 + var2) * 128;
      var5.field1312 = var3.ambientSoundId;
      var5.field1309 = var3.field3455 * 128;
      var5.field1305 = var3.field3456;
      var5.field1313 = var3.field3418;
      var5.field1314 = var3.field3458;
      if(var3.impostorIds != null) {
         var5.field1310 = var3;
         var5.method1560();
      }

      class82.field1311.addFront(var5);
      if(var5.field1314 != null) {
         var5.field1303 = var5.field1305 + (int)(Math.random() * (double)(var5.field1313 - var5.field1305));
      }

   }
}
