import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("a")
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("w")
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("i")
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("s")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("t")
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -892837143
   )
   @Export("ordinal")
   public final int ordinal;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-22"
   )
   public static void method4105() {
      if(class238.field3272 != null) {
         class238.field3272.close();
      }

   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.ordinal = var2;
   }

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }
}
