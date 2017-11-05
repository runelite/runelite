import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("j")
final class class18 implements Comparator {
   @ObfuscatedName("s")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 998120087
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(La;La;I)I",
      garbageValue = "1647586437"
   )
   int method141(class14 var1, class14 var2) {
      return var1.method84().compareTo(var2.method84());
   }

   public int compare(Object var1, Object var2) {
      return this.method141((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lif;",
      garbageValue = "-1825068601"
   )
   public static Overlay method135(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILfr;Lih;I)V",
      garbageValue = "860714026"
   )
   static void method139(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.field3200 = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = class236.field3229;
      synchronized(class236.field3229) {
         class236.field3229.addFront(var3);
      }

      GroundObject.method2538();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-7"
   )
   public static boolean method137(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(Lia;IIIS)V",
      garbageValue = "16256"
   )
   static final void method129(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3582) {
               if(!var0.field3584 || Client.field1082 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class35.method478(var0.combatLevel, class66.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3584 && Client.field1174) {
                     class215.addMenuEntry("Examine", class24.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class215.addMenuEntry("Use", Client.field1068 + " " + "->" + " " + class24.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class90.field1421 & 2) == 2) {
                        class215.addMenuEntry(Client.field1072, Client.field1087 + " " + "->" + " " + class24.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3584 && Client.field1174?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.field1085) {
                        var6 = class8.method43(var6);
                     }

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

                              class215.addMenuEntry(var6[var7], class24.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.field949 != class89.field1406) {
                                 if(Client.field949 == class89.field1404 || class89.field1405 == Client.field949 && var0.combatLevel > class66.localPlayer.combatLevel) {
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

                                 class215.addMenuEntry(var6[var7], class24.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3584 || !Client.field1174) {
                        class215.addMenuEntry("Examine", class24.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lhj;I)Z",
      garbageValue = "-711415293"
   )
   static final boolean method140(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field977 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1185.method4029(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1185.method4056(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1185.method4044(false);
         }

         if(var1 == 325) {
            Client.field1185.method4044(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CHARACTER_DESIGN);
            Client.field1185.method4042(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(IIIILky;Lhh;I)V",
      garbageValue = "-283737240"
   )
   static final void method138(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2589 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class46.mapedge.method5176(var15 + (var0 + var5.field2589 / 2 - var17 / 2), var5.field2592 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         class9.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
