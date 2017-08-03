import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("e")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 129039311
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "86"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2381) {
         class177.field2389 += class175.field2381 - var0;
      }

      class175.field2381 = var0;
      return var0 + class177.field2389;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public static void method4101() {
      if(class238.field3235 != null) {
         class238.field3235.close();
      }

   }
}
