import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("RC")
   public static final BuildType RC;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("WIP")
   public static final BuildType WIP;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("LIVE")
   public static final BuildType LIVE;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("BUILD_LIVE")
   public static final BuildType BUILD_LIVE;
   @ObfuscatedName("fe")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("l")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -376512769
   )
   public final int field3357;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.field3357 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljs;",
      garbageValue = "-1440239756"
   )
   @Export("getUnderlayDefinition")
   public static FloorUnderlayDefinition getUnderlayDefinition(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "-1675869357"
   )
   static void method4551(byte[] var0, int var1) {
      if(Client.field888 == null) {
         Client.field888 = new byte[24];
      }

      class205.method3857(var0, var1, Client.field888, 0, 24);
   }
}
