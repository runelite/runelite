import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ev")
@Implements("UserComparator4")
public class UserComparator4 implements Comparator {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -112939189
   )
   @Export("WorldMapElement_count")
   public static int WorldMapElement_count;
   @ObfuscatedName("m")
   @Export("reversed")
   final boolean reversed;

   public UserComparator4(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "950234237"
   )
   @Export("compareBuddy")
   int compareBuddy(Buddy var1, Buddy var2) {
      return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.compareBuddy((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "725116015"
   )
   public static boolean method3336(CharSequence var0) {
      return class214.method4144(var0, 10, true);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-2050984400"
   )
   static int method3335(int var0, Script var1, boolean var2) {
      if (var0 == ScriptOpcodes.GETWINDOWMODE) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = SpotAnimationDefinition.getWindowedMode();
         return 1;
      } else {
         int var3;
         if (var0 == ScriptOpcodes.SETWINDOWMODE) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            if (var3 == 1 || var3 == 2) {
               GroundItem.setWindowedMode(var3);
            }

            return 1;
         } else if (var0 == ScriptOpcodes.GETDEFAULTWINDOWMODE) {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = ReflectionCheck.clientPreferences.windowMode;
            return 1;
         } else if (var0 != ScriptOpcodes.SETDEFAULTWINDOWMODE) {
            if (var0 == 5310) {
               --RouteStrategy.Interpreter_intStackSize;
               return 1;
            } else {
               return 2;
            }
         } else {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            if (var3 == 1 || var3 == 2) {
               ReflectionCheck.clientPreferences.windowMode = var3;
               WorldMapSection3.savePreferences();
            }

            return 1;
         }
      }
   }
}
