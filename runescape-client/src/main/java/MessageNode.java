import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("bh")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("t")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -960693555
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2034802227
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1063398945
   )
   @Export("type")
   int type;
   @ObfuscatedName("z")
   @Export("name")
   String name;
   @ObfuscatedName("v")
   @Export("sender")
   String sender;
   @ObfuscatedName("m")
   @Export("value")
   String value;

   @Hook("setMessage")
   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = ItemContainer.method1101();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1257496034"
   )
   @Export("setMessage")
   @Hook("setMessage")
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = ItemContainer.method1101();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZB)V",
      garbageValue = "-48"
   )
   public static void method1132(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class56.field654.startsWith("win")) {
            class33.method358(var0, 0);
         } else if(class56.field654.startsWith("mac")) {
            ClanMember.method1188(var0, 1, "openjs");
         } else {
            class33.method358(var0, 2);
         }
      } else {
         class33.method358(var0, 3);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "596150380"
   )
   public static void method1139() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfr;II)V",
      garbageValue = "1630131126"
   )
   public static void method1136(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.count = var0.readUnsignedByte();
      var2.field3795 = var0.readInt();
      var2.type = new int[var2.count];
      var2.errorIdentifiers = new int[var2.count];
      var2.fields = new Field[var2.count];
      var2.field3798 = new int[var2.count];
      var2.methods = new Method[var2.count];
      var2.args = new byte[var2.count][][];

      for(int var3 = 0; var3 < var2.count; ++var3) {
         try {
            int var4 = var0.readUnsignedByte();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.readString();
                  var6 = var0.readString();
                  var7 = var0.readUnsignedByte();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.readString();
                  }

                  String var20 = var0.readString();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.readInt();
                        var10[var11] = new byte[var12];
                        var0.readBytes(var10[var11], 0, var12);
                     }
                  }

                  var2.type[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = GraphicsObject.loadClassFromDescriptor(var8[var12]);
                  }

                  Class var22 = GraphicsObject.loadClassFromDescriptor(var20);
                  if(GraphicsObject.loadClassFromDescriptor(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = GraphicsObject.loadClassFromDescriptor(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(Reflection.getMethodName(var16).equals(var6)) {
                        Class[] var17 = Reflection.getParameterTypes(var16);
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var21[var19] != var17[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.args[var3] = var10;
               }
            } else {
               var5 = var0.readString();
               var6 = var0.readString();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.readInt();
               }

               var2.type[var3] = var4;
               var2.field3798[var3] = var7;
               if(GraphicsObject.loadClassFromDescriptor(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(GraphicsObject.loadClassFromDescriptor(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.errorIdentifiers[var3] = -1;
         } catch (SecurityException var25) {
            var2.errorIdentifiers[var3] = -2;
         } catch (NullPointerException var26) {
            var2.errorIdentifiers[var3] = -3;
         } catch (Exception var27) {
            var2.errorIdentifiers[var3] = -4;
         } catch (Throwable var28) {
            var2.errorIdentifiers[var3] = -5;
         }
      }

      class289.classInfos.addFirst(var2);
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(Lbw;IIII)V",
      garbageValue = "-1320035461"
   )
   static final void method1138(Player var0, int var1, int var2, int var3) {
      if(class181.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = class181.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = ISAACCipher.getColTags(16711680);
               } else if(var9 < -6) {
                  var6 = ISAACCipher.getColTags(16723968);
               } else if(var9 < -3) {
                  var6 = ISAACCipher.getColTags(16740352);
               } else if(var9 < 0) {
                  var6 = ISAACCipher.getColTags(16756736);
               } else if(var9 > 9) {
                  var6 = ISAACCipher.getColTags(65280);
               } else if(var9 > 6) {
                  var6 = ISAACCipher.getColTags(4259584);
               } else if(var9 > 3) {
                  var6 = ISAACCipher.getColTags(8453888);
               } else if(var9 > 0) {
                  var6 = ISAACCipher.getColTags(12648192);
               } else {
                  var6 = ISAACCipher.getColTags(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var10;
            if(Client.itemSelectionState == 1) {
               RSCanvas.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + ISAACCipher.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class156.field2161 & 8) == 8) {
                  RSCanvas.addMenuEntry(Client.lastSelectedSpellActionName, Client.lastSelectedSpellName + " " + "->" + " " + ISAACCipher.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(AttackOption.AttackOption_hidden == Client.playerAttackOption) {
                           continue;
                        }

                        if(Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > class181.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(class181.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class181.localPlayer.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.playerMenuTypes[var10] + var11;
                     RSCanvas.addMenuEntry(Client.playerOptions[var10], ISAACCipher.getColTags(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = ISAACCipher.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
