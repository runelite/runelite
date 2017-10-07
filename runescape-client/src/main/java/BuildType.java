import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -990518267
   )
   static int field3190;
   @ObfuscatedName("ff")
   static int[] field3191;
   @ObfuscatedName("q")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 999181077
   )
   @Export("ordinal")
   public final int ordinal;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.ordinal = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "-77"
   )
   static String method4209(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class269.field3681[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class269.field3681[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class269.field3681[(var6 & 15) << 2 | var7 >>> 6]).append(class269.field3681[var7 & 63]);
            } else {
               var3.append(class269.field3681[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class269.field3681[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Liu;",
      garbageValue = "1021830326"
   )
   public static class252 method4211(int var0) {
      class252 var1 = (class252)class252.field3395.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class252.field3397.getConfigData(34, var0);
         var1 = new class252();
         if(var2 != null) {
            var1.method4555(new Buffer(var2));
         }

         var1.method4547();
         class252.field3395.put(var1, (long)var0);
         return var1;
      }
   }
}
