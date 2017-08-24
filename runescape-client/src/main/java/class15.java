import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class15 implements Comparator {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 865881245
   )
   protected static int field305;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 754465011
   )
   static int field302;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 1067194241
   )
   static int field303;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lv;Lv;B)I",
      garbageValue = "18"
   )
   int method94(class14 var1, class14 var2) {
      return var1.field296.totalQuantity < var2.field296.totalQuantity?-1:(var2.field296.totalQuantity == var1.field296.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method94((class14)var1, (class14)var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lij;",
      garbageValue = "1936429388"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3331.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "23"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1437492515"
   )
   static void method108() {
      if(Actor.loadWorlds()) {
         class91.worldSelectShown = true;
      }

   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(Lbo;IIS)V",
      garbageValue = "3087"
   )
   static void method95(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class216.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1263 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1265 = 0;
         }

         if(var3 == 2) {
            var0.field1265 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class216.getAnimation(var1).forcedPriority >= class216.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1263 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1265 = 0;
         var0.field1249 = var0.queueSize;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1826879744"
   )
   static final int method107(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
