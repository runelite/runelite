import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class152 extends RuntimeException {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 857815193
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("d")
   public static Applet field2230;
   @ObfuscatedName("r")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("k")
   public static String field2224;
   @ObfuscatedName("p")
   String field2226;
   @ObfuscatedName("q")
   Throwable field2232;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-544118423"
   )
   static int method3019(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
      } else {
         var3 = var2?class81.field1341:class81.field1340;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class81.intStack[--class81.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method4118(var4, class81.scriptStringStack[--class81.scriptStringStackSize]);
            return 1;
         } else {
            --class81.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class81.intStackSize -= 2;
         var4 = class81.intStack[class81.intStackSize];
         int var5 = class81.intStack[class81.intStackSize + 1];
         var3.dragParent = class5.method18(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2736 = class81.intStack[--class81.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2734 = class81.intStack[--class81.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2757 = class81.intStack[--class81.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class81.scriptStringStack[--class81.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class81.scriptStringStack[--class81.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
