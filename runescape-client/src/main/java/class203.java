import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class203 {
   @ObfuscatedName("k")
   public static boolean field2495;
   @ObfuscatedName("i")
   static IndexDataBase field2496;
   @ObfuscatedName("r")
   static Track1 field2497;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1797166945
   )
   public static int field2498;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1136205249
   )
   public static int field2499;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2001536553
   )
   public static int field2500;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -83316807
   )
   public static int field2501;
   @ObfuscatedName("u")
   static IndexDataBase field2502;
   @ObfuscatedName("h")
   static IndexDataBase field2503;

   static {
      field2498 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LSpotanim;",
      garbageValue = "65754960"
   )
   public static Spotanim method3752(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field3312.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3323.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field3310 = var0;
         if(var2 != null) {
            var1.method4405(new Buffer(var2));
         }

         Spotanim.field3312.put(var1, (long)var0);
         return var1;
      }
   }
}
