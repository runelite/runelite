import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("j")
   @Export("value")
   String value;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 227923613
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @Export("name")
   String name;
   @ObfuscatedName("w")
   @Export("sender")
   String sender;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -251351299
   )
   @Export("id")
   int id = class162.method3144();
   @ObfuscatedName("c")
   static class179 field229;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 368121523
   )
   static int field230;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1000973131
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("pp")
   static Clipboard field233;
   @ObfuscatedName("eg")
   static ModIcon[] field234;

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(LWidget;II)I",
      garbageValue = "86435240"
   )
   static final int method214(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class37.method759(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!PlayerComposition.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class146.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class172.field2334[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class146.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = VertexNormal.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class172.field2333[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class37.method759(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!PlayerComposition.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class146.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class10.method127(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (VertexNormal.localPlayer.x >> 7) + class114.baseX;
               }

               if(var6 == 19) {
                  var7 = CombatInfo1.baseY + (VertexNormal.localPlayer.y >> 7);
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;B)Ljava/lang/String;",
      garbageValue = "0"
   )
   static String method215(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var6 = var0.indexOf("%" + var2);
               if(var6 == -1) {
                  break;
               }

               var0 = var0.substring(0, var6) + ItemLayer.method1467(method214(var1, var2 - 1)) + var0.substring(2 + var6);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(class99.field1649 != null) {
               int var5 = class99.field1649.field1670;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var3 = var4;
               if(class99.field1649.field1675 != null) {
                  var3 = (String)class99.field1649.field1675;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-84669411"
   )
   void method220(int var1, String var2, String var3, String var4) {
      this.id = class162.method3144();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;B)V",
      garbageValue = "52"
   )
   static void method221(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = ItemLayer.method1468(var1, var2);
      if(null != var5) {
         if(null != var5.field2064) {
            class18 var6 = new class18();
            var6.field190 = var5;
            var6.field193 = var0;
            var6.field200 = var4;
            var6.field198 = var5.field2064;
            class9.method118(var6);
         }

         boolean var10 = true;
         if(var5.contentType > 0) {
            var10 = NPC.method747(var5);
         }

         if(var10) {
            int var8 = class88.method1872(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> 1 + var9 & 1) != 0;
            if(var7) {
               if(var0 == 1) {
                  Client.field321.method3195(20);
                  Client.field321.method3057(var1);
                  Client.field321.method3094(var2);
                  Client.field321.method3094(var3);
               }

               if(var0 == 2) {
                  Client.field321.method3195(116);
                  Client.field321.method3057(var1);
                  Client.field321.method3094(var2);
                  Client.field321.method3094(var3);
               }

               if(var0 == 3) {
                  Client.field321.method3195(129);
                  Client.field321.method3057(var1);
                  Client.field321.method3094(var2);
                  Client.field321.method3094(var3);
               }

               if(var0 == 4) {
                  Client.field321.method3195(211);
                  Client.field321.method3057(var1);
                  Client.field321.method3094(var2);
                  Client.field321.method3094(var3);
               }

               if(var0 == 5) {
                  Client.field321.method3195(9);
                  Client.field321.method3057(var1);
                  Client.field321.method3094(var2);
                  Client.field321.method3094(var3);
               }

               if(var0 == 6) {
                  Client.field321.method3195(159);
                  Client.field321.method3057(var1);
                  Client.field321.method3094(var2);
                  Client.field321.method3094(var3);
               }

               if(var0 == 7) {
                  Client.field321.method3195(221);
                  Client.field321.method3057(var1);
                  Client.field321.method3094(var2);
                  Client.field321.method3094(var3);
               }

               if(var0 == 8) {
                  Client.field321.method3195(90);
                  Client.field321.method3057(var1);
                  Client.field321.method3094(var2);
                  Client.field321.method3094(var3);
               }

               if(var0 == 9) {
                  Client.field321.method3195(168);
                  Client.field321.method3057(var1);
                  Client.field321.method3094(var2);
                  Client.field321.method3094(var3);
               }

               if(var0 == 10) {
                  Client.field321.method3195(205);
                  Client.field321.method3057(var1);
                  Client.field321.method3094(var2);
                  Client.field321.method3094(var3);
               }

            }
         }
      }
   }
}
