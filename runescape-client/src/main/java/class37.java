import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class37 {
   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   static IndexFile field534;
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lip;III)[Lky;",
      garbageValue = "-1130716731"
   )
   static SpritePixels[] method483(IndexDataBase var0, int var1, int var2) {
      return !class261.method4822(var0, var1, var2)?null:MilliTimer.method2965();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;S)V",
      garbageValue = "-11876"
   )
   public static void method492(IndexDataBase var0, IndexDataBase var1) {
      KitDefinition.identKit_ref = var0;
      KitDefinition.field3346 = var1;
      KitDefinition.field3347 = KitDefinition.identKit_ref.fileCount(3);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILct;ZS)I",
      garbageValue = "20735"
   )
   static int method491(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         Enum var5 = FileOnDisk.method2428(var3);
         if(var5.valType != 's') {
            ;
         }

         for(var6 = 0; var6 < var5.size; ++var6) {
            if(var4 == var5.keys[var6]) {
               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var5.stringVals[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var5.defaultString;
         }

         return 1;
      } else if(var0 != 3408) {
         return 2;
      } else {
         class278.intStackSize -= 4;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         int var9 = class81.intStack[class278.intStackSize + 2];
         var6 = class81.intStack[class278.intStackSize + 3];
         Enum var7 = FileOnDisk.method2428(var9);
         if(var3 == var7.keyType && var4 == var7.valType) {
            for(int var8 = 0; var8 < var7.size; ++var8) {
               if(var6 == var7.keys[var8]) {
                  if(var4 == 115) {
                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var7.stringVals[var8];
                  } else {
                     class81.intStack[++class278.intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var7.defaultString;
               } else {
                  class81.intStack[++class278.intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "null";
            } else {
               class81.intStack[++class278.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "-26"
   )
   static int method493(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = var3 + var4;
         return 1;
      } else if(var0 == 4001) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = var3 * var4;
         return 1;
      } else if(var0 == 4003) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class81.intStack[--class278.intStackSize];
         class81.intStack[++class278.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class81.intStack[--class278.intStackSize];
         class81.intStack[++class278.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class278.intStackSize -= 5;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         int var5 = class81.intStack[class278.intStackSize + 2];
         int var6 = class81.intStack[class278.intStackSize + 3];
         int var7 = class81.intStack[class278.intStackSize + 4];
         class81.intStack[++class278.intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = var3 + var3 * var4 / 100;
         return 1;
      } else if(var0 == 4008) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         if(var3 == 0) {
            class81.intStack[++class278.intStackSize - 1] = 0;
         } else {
            class81.intStack[++class278.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         if(var3 == 0) {
            class81.intStack[++class278.intStackSize - 1] = 0;
            return 1;
         } else {
            switch(var4) {
            case 0:
               class81.intStack[++class278.intStackSize - 1] = Integer.MAX_VALUE;
               break;
            case 1:
               class81.intStack[++class278.intStackSize - 1] = var3;
               break;
            case 2:
               class81.intStack[++class278.intStackSize - 1] = (int)Math.sqrt((double)var3);
               break;
            case 3:
               class81.intStack[++class278.intStackSize - 1] = (int)Math.cbrt((double)var3);
               break;
            case 4:
               class81.intStack[++class278.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
               break;
            default:
               class81.intStack[++class278.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
            }

            return 1;
         }
      } else if(var0 == 4014) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         class81.intStack[++class278.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class278.intStackSize -= 3;
         long var9 = (long)class81.intStack[class278.intStackSize];
         long var11 = (long)class81.intStack[class278.intStackSize + 1];
         long var13 = (long)class81.intStack[class278.intStackSize + 2];
         class81.intStack[++class278.intStackSize - 1] = (int)(var13 * var9 / var11);
         return 1;
      } else {
         return 2;
      }
   }
}
