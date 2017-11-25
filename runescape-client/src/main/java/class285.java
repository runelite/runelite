import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
public class class285 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static final class285 field3786;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   public static final class285 field3787;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static final class285 field3785;
   @ObfuscatedName("b")
   public static int[] field3788;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 824333845
   )
   public final int field3784;

   static {
      field3786 = new class285(0);
      field3787 = new class285(1);
      field3785 = new class285(2);
   }

   class285(int var1) {
      this.field3784 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "1927443945"
   )
   static int method5112(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 3400) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         Enum var6 = (Enum)Enum.field3466.get((long)var3);
         Enum var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            byte[] var14 = Enum.field3475.getConfigData(8, var3);
            var6 = new Enum();
            if(var14 != null) {
               var6.decode(new Buffer(var14));
            }

            Enum.field3466.put(var6, (long)var3);
            var5 = var6;
         }

         var6 = var5;
         if(var5.valType != 's') {
            ;
         }

         for(int var7 = 0; var7 < var6.size; ++var7) {
            if(var4 == var6.keys[var7]) {
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var6.stringVals[var7];
               var6 = null;
               break;
            }
         }

         if(var6 != null) {
            class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var6.defaultString;
         }

         return 1;
      } else if(var0 == 3408) {
         class13.intStackSize -= 4;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         int var10 = class82.intStack[class13.intStackSize + 2];
         int var11 = class82.intStack[class13.intStackSize + 3];
         Enum var8 = (Enum)Enum.field3466.get((long)var10);
         Enum var12;
         if(var8 != null) {
            var12 = var8;
         } else {
            byte[] var13 = Enum.field3475.getConfigData(8, var10);
            var8 = new Enum();
            if(var13 != null) {
               var8.decode(new Buffer(var13));
            }

            Enum.field3466.put(var8, (long)var10);
            var12 = var8;
         }

         var8 = var12;
         if(var3 == var12.keyType && var4 == var12.valType) {
            for(int var9 = 0; var9 < var8.size; ++var9) {
               if(var11 == var8.keys[var9]) {
                  if(var4 == 115) {
                     class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var8.stringVals[var9];
                  } else {
                     class82.intStack[++class13.intStackSize - 1] = var8.intVals[var9];
                  }

                  var8 = null;
                  break;
               }
            }

            if(var8 != null) {
               if(var4 == 115) {
                  class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var8.defaultString;
               } else {
                  class82.intStack[++class13.intStackSize - 1] = var8.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "null";
            } else {
               class82.intStack[++class13.intStackSize - 1] = 0;
            }

            return 1;
         }
      } else {
         return 2;
      }
   }
}
