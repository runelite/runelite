import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   public static Buffer field3190;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("o")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1052670967
   )
   @Export("ordinal")
   final int ordinal;

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
}
