import java.io.File;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("l")
   public static File field2092;
   @ObfuscatedName("t")
   @Export("url")
   final URL url;
   @ObfuscatedName("q")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("i")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1954067076"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-93586350"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lgd;",
      garbageValue = "529797464"
   )
   public static PacketNode method3096() {
      PacketNode var0;
      if(PacketNode.field2473 == 0) {
         var0 = new PacketNode();
      } else {
         var0 = PacketNode.packetBufferNodes[--PacketNode.field2473];
      }

      var0.clientPacket = null;
      var0.field2469 = 0;
      var0.packetBuffer = new PacketBuffer(5000);
      return var0;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(Ljd;IIII)V",
      garbageValue = "-21726711"
   )
   static final void method3097(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3738) {
               if(!var0.field3732 || Client.field1016 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class245.method4529(var0.combatLevel, WorldMapData.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3732 && Client.field993) {
                     class169.addMenuEntry("Examine", class37.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class169.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class37.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class150.field2100 & 2) == 2) {
                        class169.addMenuEntry(Client.field1006, Client.field1074 + " " + "->" + " " + class37.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3732 && Client.field993?2000:0;
                     String[] var6 = var0.actions;
                     int var7;
                     int var8;
                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var5 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var5 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var5 + 13;
                              }

                              class169.addMenuEntry(var6[var7], class37.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(AttackOption.AttackOption_hidden != Client.npcAttackOption) {
                                 if(Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var0.combatLevel > WorldMapData.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class169.addMenuEntry(var6[var7], class37.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3732 || !Client.field993) {
                        class169.addMenuEntry("Examine", class37.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
