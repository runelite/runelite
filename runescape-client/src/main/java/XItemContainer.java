import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("o")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("v")
   public static class72[] field120;
   @ObfuscatedName("k")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("y")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -1722471545
   )
   public static int field123;

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-2060656868"
   )
   static final String[] method170(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(null != var0 && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass184;",
      garbageValue = "-1033112145"
   )
   static class184 method185(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(class104.field1694 != null) {
         var4 = new class116(var0, class104.field1694, field120[var0], 1000000);
      }

      return new class184(var4, class103.field1684, var0, var1, var2, var3);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LSpotanim;",
      garbageValue = "1234368900"
   )
   public static Spotanim method187(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field2786.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field2773.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field2776 = var0;
         if(null != var2) {
            var1.method3456(new Buffer(var2));
         }

         Spotanim.field2786.put(var1, (long)var0);
         return var1;
      }
   }
}
