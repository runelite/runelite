import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Formatting")
public class Formatting {
   @ObfuscatedName("d")
   @Export("__cy_d")
   static int[] __cy_d;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache12")
   static IndexCache indexCache12;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "1654486766"
   )
   static int method2023(int var0, Script var1, boolean var2) {
      Widget var3 = var2?WorldMapIcon1.__t_i:class12.__n_n;
      if(var0 == 1700) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.itemQuantity;
         } else {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.childIndex;
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
      int var6;
      if(var0 == 3400) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         EnumDefinition var5 = Interpreter.getEnum(var3);
         if(var5.valType != 's') {
            ;
         }

         for(var6 = 0; var6 < var5.size0; ++var6) {
            if(var4 == var5.keys[var6]) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.stringVals[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.defaultString;
         }

         return 1;
      } else if(var0 != 3408) {
         if(var0 == 3411) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            EnumDefinition var10 = Interpreter.getEnum(var3);
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var10.size();
            return 1;
         } else {
            return 2;
         }
      } else {
         class179.Interpreter_intStackSize -= 4;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         int var9 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
         var6 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 3];
         EnumDefinition var7 = Interpreter.getEnum(var9);
         if(var3 == var7.keyType && var4 == var7.valType) {
            for(int var8 = 0; var8 < var7.size0; ++var8) {
               if(var6 == var7.keys[var8]) {
                  if(var4 == 115) {
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7.stringVals[var8];
                  } else {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7.defaultString;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "null";
            } else {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
