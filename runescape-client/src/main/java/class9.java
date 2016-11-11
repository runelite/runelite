import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class9 {
   @ObfuscatedName("u")
   static final BigInteger field168 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("n")
   static final BigInteger field169 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 1077231185
   )
   static int field172;
   @ObfuscatedName("bi")
   static class171 field173;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 362190919
   )
   static int field175;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "293257678"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field967.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field992.method3292(6, var0);
         var1 = new ObjectComposition();
         var1.field954 = var0;
         if(null != var2) {
            var1.method840(new Buffer(var2));
         }

         var1.method843();
         if(var1.field983) {
            var1.field961 = 0;
            var1.field962 = false;
         }

         ObjectComposition.field967.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "2083035835"
   )
   static final void method126(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.field938 != null) {
            var0 = var0.method813();
         }

         if(var0 != null) {
            if(var0.field937) {
               if(!var0.field927 || Client.field566 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class14.method170(var0.combatLevel, class138.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field453 == 1) {
                     class132.addMenuEntry("Use", Client.field312 + " " + "->" + " " + class137.method2909(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field455) {
                     if((class18.field285 & 2) == 2) {
                        class132.addMenuEntry(Client.field458, Client.field459 + " " + "->" + " " + class137.method2909(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field471) {
                        var5 = Friend.method193(var5);
                     }

                     int var6;
                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(var6 == 0) {
                                 var7 = 9;
                              }

                              if(var6 == 1) {
                                 var7 = 10;
                              }

                              if(var6 == 2) {
                                 var7 = 11;
                              }

                              if(var6 == 3) {
                                 var7 = 12;
                              }

                              if(var6 == 4) {
                                 var7 = 13;
                              }

                              class132.addMenuEntry(var5[var6], class137.method2909(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(class21.field607 != Client.field327) {
                                 if(class21.field601 == Client.field327 || Client.field327 == class21.field606 && var0.combatLevel > class138.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(var6 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var6 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var6 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var6 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class132.addMenuEntry(var5[var6], class137.method2909(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class132.addMenuEntry("Examine", class137.method2909(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "217978200"
   )
   public static int method127(int var0) {
      class50 var1 = class192.method3770(var0);
      int var2 = var1.field1095;
      int var3 = var1.field1094;
      int var4 = var1.field1097;
      int var5 = class179.field2955[var4 - var3];
      return class179.widgetSettings[var2] >> var3 & var5;
   }
}
