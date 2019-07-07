import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cy")
@Implements("Formatting")
public class Formatting {
   @ObfuscatedName("d")
   static int[] field353;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("archive12")
   static Archive archive12;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "1654486766"
   )
   static int method2023(int var0, Script var1, boolean var2) {
      Widget var3 = var2 ? WorldMapIcon1.field1030 : GrandExchangeOfferAgeComparator.field1111;
      if (var0 == ScriptOpcodes.CC_GETINVOBJECT) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.itemId;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETINVCOUNT) {
         if (var3.itemId != -1) {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.itemQuantity;
         } else {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETID) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.childIndex;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-162828509"
   )
   static int method2022(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var5;
      EnumDefinition var6;
      if (var0 == ScriptOpcodes.ENUM_STRING) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         var6 = Interpreter.getEnum(var3);
         if (var6.outputType != 's') {
         }

         for (var5 = 0; var5 < var6.outputCount; ++var5) {
            if (var4 == var6.keys[var5]) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6.strVals[var5];
               var6 = null;
               break;
            }
         }

         if (var6 != null) {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6.defaultStr;
         }

         return 1;
      } else if (var0 != ScriptOpcodes.ENUM) {
         if (var0 == ScriptOpcodes.ENUM_GETOUTPUTCOUNT) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            var6 = Interpreter.getEnum(var3);
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var6.size();
            return 1;
         } else {
            return 2;
         }
      } else {
         RouteStrategy.Interpreter_intStackSize -= 4;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         int var7 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 2];
         var5 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 3];
         EnumDefinition var8 = Interpreter.getEnum(var7);
         if (var3 == var8.inputType && var4 == var8.outputType) {
            for (int var9 = 0; var9 < var8.outputCount; ++var9) {
               if (var5 == var8.keys[var9]) {
                  if (var4 == 115) {
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.strVals[var9];
                  } else {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var8.intVals[var9];
                  }

                  var8 = null;
                  break;
               }
            }

            if (var8 != null) {
               if (var4 == 115) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.defaultStr;
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var8.defaultInt;
               }
            }

            return 1;
         } else {
            if (var4 == 115) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "null";
            } else {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
