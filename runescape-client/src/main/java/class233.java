import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class233 {
   @ObfuscatedName("i")
   public static final boolean[] field2919;
   @ObfuscatedName("w")
   public static int[] field2920;
   @ObfuscatedName("ar")
   static java.awt.Font field2921;
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("fonts")
   static Fonts fonts;

   static {
      field2919 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2920 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2920[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "456506561"
   )
   public static void method4329() {
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "243268913"
   )
   @Export("execute6500")
   static int execute6500(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class80.intStack[++class80.intStackSize - 1] = class89.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            World.field1176 = 0;
            var3 = GameEngine.method982();
            if(var3 != null) {
               class80.intStack[++class80.intStackSize - 1] = var3.id;
               class80.intStack[++class80.intStackSize - 1] = var3.mask;
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var3.activity;
               class80.intStack[++class80.intStackSize - 1] = var3.location;
               class80.intStack[++class80.intStackSize - 1] = var3.playerCount;
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var3.address;
            } else {
               class80.intStack[++class80.intStackSize - 1] = -1;
               class80.intStack[++class80.intStackSize - 1] = 0;
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               class80.intStack[++class80.intStackSize - 1] = 0;
               class80.intStack[++class80.intStackSize - 1] = 0;
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = GameEngine.method982();
            if(var3 != null) {
               class80.intStack[++class80.intStackSize - 1] = var3.id;
               class80.intStack[++class80.intStackSize - 1] = var3.mask;
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var3.activity;
               class80.intStack[++class80.intStackSize - 1] = var3.location;
               class80.intStack[++class80.intStackSize - 1] = var3.playerCount;
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var3.address;
            } else {
               class80.intStack[++class80.intStackSize - 1] = -1;
               class80.intStack[++class80.intStackSize - 1] = 0;
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               class80.intStack[++class80.intStackSize - 1] = 0;
               class80.intStack[++class80.intStackSize - 1] = 0;
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var11;
            if(var0 == 6506) {
               var11 = class80.intStack[--class80.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var11 == class89.worldList[var5].id) {
                     var4 = class89.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class80.intStack[++class80.intStackSize - 1] = var4.id;
                  class80.intStack[++class80.intStackSize - 1] = var4.mask;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var4.activity;
                  class80.intStack[++class80.intStackSize - 1] = var4.location;
                  class80.intStack[++class80.intStackSize - 1] = var4.playerCount;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var4.address;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = -1;
                  class80.intStack[++class80.intStackSize - 1] = 0;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
                  class80.intStack[++class80.intStackSize - 1] = 0;
                  class80.intStack[++class80.intStackSize - 1] = 0;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class80.intStackSize -= 4;
               var11 = class80.intStack[class80.intStackSize];
               boolean var15 = class80.intStack[class80.intStackSize + 1] == 1;
               var5 = class80.intStack[class80.intStackSize + 2];
               boolean var6 = class80.intStack[class80.intStackSize + 3] == 1;
               if(class89.worldList != null) {
                  WallObject.method3002(0, class89.worldList.length - 1, var11, var15, var5, var6);
               }

               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field953 = class80.intStack[--class80.intStackSize] == 1;
                  return 1;
               } else {
                  int var12;
                  class262 var13;
                  if(var0 == 6513) {
                     class80.intStackSize -= 2;
                     var11 = class80.intStack[class80.intStackSize];
                     var12 = class80.intStack[class80.intStackSize + 1];
                     var13 = class157.method3115(var12);
                     if(var13.method4692()) {
                        class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = class230.getNpcDefinition(var11).method4915(var12, var13.field3449);
                     } else {
                        class80.intStack[++class80.intStackSize - 1] = class230.getNpcDefinition(var11).method4905(var12, var13.field3451);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class80.intStackSize -= 2;
                     var11 = class80.intStack[class80.intStackSize];
                     var12 = class80.intStack[class80.intStackSize + 1];
                     var13 = class157.method3115(var12);
                     if(var13.method4692()) {
                        class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = TextureProvider.getObjectDefinition(var11).method4790(var12, var13.field3449);
                     } else {
                        class80.intStack[++class80.intStackSize - 1] = TextureProvider.getObjectDefinition(var11).method4789(var12, var13.field3451);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class80.intStackSize -= 2;
                     var11 = class80.intStack[class80.intStackSize];
                     var12 = class80.intStack[class80.intStackSize + 1];
                     var13 = class157.method3115(var12);
                     if(var13.method4692()) {
                        class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = CombatInfo1.getItemDefinition(var11).method4875(var12, var13.field3449);
                     } else {
                        class80.intStack[++class80.intStackSize - 1] = CombatInfo1.getItemDefinition(var11).method4827(var12, var13.field3451);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class80.intStackSize -= 2;
                     var11 = class80.intStack[class80.intStackSize];
                     var12 = class80.intStack[class80.intStackSize + 1];
                     var13 = class157.method3115(var12);
                     if(var13.method4692()) {
                        String[] var14 = class80.scriptStringStack;
                        int var7 = ++WorldComparator.scriptStringStackSize - 1;
                        class263 var9 = (class263)class263.field3453.get((long)var11);
                        class263 var8;
                        if(var9 != null) {
                           var8 = var9;
                        } else {
                           byte[] var10 = class263.field3455.getConfigData(34, var11);
                           var9 = new class263();
                           if(var10 != null) {
                              var9.method4709(new Buffer(var10));
                           }

                           var9.method4713();
                           class263.field3453.put(var9, (long)var11);
                           var8 = var9;
                        }

                        var14[var7] = var8.method4712(var12, var13.field3449);
                     } else {
                        class80.intStack[++class80.intStackSize - 1] = class131.method2740(var11).method4711(var12, var13.field3451);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class80.intStack[++class80.intStackSize - 1] = 0;
                     return 1;
                  } else {
                     return var0 == 6520?1:(var0 == 6521?1:2);
                  }
               }
            } else {
               var11 = class80.intStack[--class80.intStackSize];
               if(var11 >= 0 && var11 < World.worldCount) {
                  var4 = class89.worldList[var11];
                  class80.intStack[++class80.intStackSize - 1] = var4.id;
                  class80.intStack[++class80.intStackSize - 1] = var4.mask;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var4.activity;
                  class80.intStack[++class80.intStackSize - 1] = var4.location;
                  class80.intStack[++class80.intStackSize - 1] = var4.playerCount;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var4.address;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = -1;
                  class80.intStack[++class80.intStackSize - 1] = 0;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
                  class80.intStack[++class80.intStackSize - 1] = 0;
                  class80.intStack[++class80.intStackSize - 1] = 0;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
