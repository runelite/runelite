import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("u")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 175058789
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILck;ZB)I",
      garbageValue = "3"
   )
   static int method4241(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class139.field2008:AttackOption.field1306;
      if(var0 == 1700) {
         class82.intStack[++class82.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class82.intStack[++class82.intStackSize - 1] = var3.itemQuantity;
         } else {
            class82.intStack[++class82.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class82.intStack[++class82.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }
}
