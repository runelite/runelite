import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class37 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -41127975
   )
   public static int field512;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(BB)C",
      garbageValue = "0"
   )
   public static char method486(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class266.field3661[var1 - 128];
            if(var2 == 0) {
               var2 = 63;
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-26"
   )
   public static void method487(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            Widget.field2686.method4122(var0);
            if(CombatInfo1.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < CombatInfo1.widgets[var0].length; ++var2) {
                  if(CombatInfo1.widgets[var0][var2] != null) {
                     if(CombatInfo1.widgets[var0][var2].type != 2) {
                        CombatInfo1.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  CombatInfo1.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LFloorUnderlayDefinition;",
      garbageValue = "-1496318055"
   )
   public static FloorUnderlayDefinition method488(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field3338.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.field3345.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.method4353(new Buffer(var2), var0);
         }

         var1.method4352();
         FloorUnderlayDefinition.field3338.put(var1, (long)var0);
         return var1;
      }
   }
}
