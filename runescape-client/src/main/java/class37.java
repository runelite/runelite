import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class37 {
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "Llm;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "27"
   )
   public static void method519(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "-540773889"
   )
   static int method520(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         class80.intStackSize -= 2;
         var3 = class80.intStack[class80.intStackSize];
         var4 = class80.intStack[class80.intStackSize + 1];
         Enum var5 = VertexNormal.method2804(var3);
         if(var5.valType != 's') {
            ;
         }

         for(var6 = 0; var6 < var5.size; ++var6) {
            if(var4 == var5.keys[var6]) {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var5.stringVals[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var5.defaultString;
         }

         return 1;
      } else if(var0 != 3408) {
         if(var0 == 3411) {
            var3 = class80.intStack[--class80.intStackSize];
            Enum var10 = VertexNormal.method2804(var3);
            class80.intStack[++class80.intStackSize - 1] = var10.method4904();
            return 1;
         } else {
            return 2;
         }
      } else {
         class80.intStackSize -= 4;
         var3 = class80.intStack[class80.intStackSize];
         var4 = class80.intStack[class80.intStackSize + 1];
         int var9 = class80.intStack[class80.intStackSize + 2];
         var6 = class80.intStack[class80.intStackSize + 3];
         Enum var7 = VertexNormal.method2804(var9);
         if(var3 == var7.keyType && var4 == var7.valType) {
            for(int var8 = 0; var8 < var7.size; ++var8) {
               if(var6 == var7.keys[var8]) {
                  if(var4 == 115) {
                     class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var7.stringVals[var8];
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var7.defaultString;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "null";
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
