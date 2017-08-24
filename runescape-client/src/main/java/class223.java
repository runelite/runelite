import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class223 {
   @ObfuscatedName("j")
   public static final boolean[] field2845;
   @ObfuscatedName("a")
   public static int[] field2847;
   @ObfuscatedName("f")
   static int[] field2846;
   @ObfuscatedName("na")
   @ObfuscatedSignature(
      signature = "[Lbj;"
   )
   @Export("clanMembers")
   static ClanMember[] clanMembers;

   static {
      field2845 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2847 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2847[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "768"
   )
   public static void method4101() {
      if(class294.field3904 != null) {
         class294.field3904.close();
      }

   }
}
