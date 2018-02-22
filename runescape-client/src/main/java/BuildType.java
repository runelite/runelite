import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("RC")
   public static final BuildType RC;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("WIP")
   public static final BuildType WIP;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("LIVE")
   public static final BuildType LIVE;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("BUILD_LIVE")
   public static final BuildType BUILD_LIVE;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -1852900619
   )
   static int field3303;
   @ObfuscatedName("a")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1455559149
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

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1487750203"
   )
   static final void method4528(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field979[var4] = true;
         }
      }

   }
}
