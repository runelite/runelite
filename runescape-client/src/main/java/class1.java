import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class1 {
   @ObfuscatedName("n")
   public static Comparator field4 = new class7();
   @ObfuscatedName("v")
   public static Comparator field6;
   @ObfuscatedName("y")
   public static Comparator field7;
   @ObfuscatedName("cc")
   public static char field8;
   @ObfuscatedName("x")
   public final List field9;
   @ObfuscatedName("g")
   public static Comparator field10;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "1661782390"
   )
   public void method15(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field9, var1);
      } else {
         Collections.sort(this.field9, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field9 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field9.add(new class2(var1, var5, var3));
      }

   }

   static {
      new class0();
      field10 = new class5();
      field6 = new class6();
      field7 = new class3();
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "2060395528"
   )
   static final void method17(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field290 && CollisionData.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = Friend.region.method1815(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = Friend.region.method1966(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = Friend.region.method1925(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = Friend.region.method1831(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = Friend.region.method1924(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               Friend.region.method1807(var0, var2, var3);
               var12 = ChatMessages.getObjectDefinition(var13);
               if(var12.field2915 != 0) {
                  Client.collisionMaps[var0].method2349(var2, var3, var14, var15, var12.field2936);
               }
            }

            if(var1 == 1) {
               Friend.region.method1797(var0, var2, var3);
            }

            if(var1 == 2) {
               Friend.region.method1912(var0, var2, var3);
               var12 = ChatMessages.getObjectDefinition(var13);
               if(var12.sizeX + var2 > 103 || var3 + var12.sizeX > 103 || var12.sizeY + var2 > 103 || var12.sizeY + var3 > 103) {
                  return;
               }

               if(var12.field2915 != 0) {
                  Client.collisionMaps[var0].method2355(var2, var3, var12.sizeX, var12.sizeY, var15, var12.field2936);
               }
            }

            if(var1 == 3) {
               Friend.region.method1956(var0, var2, var3);
               var12 = ChatMessages.getObjectDefinition(var13);
               if(var12.field2915 == 1) {
                  Client.collisionMaps[var0].method2376(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class10.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            WallObject.method1983(var0, var11, var2, var3, var4, var5, var6, Friend.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "32"
   )
   static final void method18(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(Projectile.method874(var0)) {
         TextureProvider.field1212 = null;
         ChatLineBuffer.gameDraw(class231.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(null != TextureProvider.field1212) {
            ChatLineBuffer.gameDraw(TextureProvider.field1212, -1412584499, var1, var2, var3, var4, NPC.field766, Player.field263, var7);
            TextureProvider.field1212 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field494[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field494[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1634458040"
   )
   static final void method19() {
      for(class25 var0 = (class25)Client.field392.method2503(); var0 != null; var0 = (class25)Client.field392.method2492()) {
         if(var0.field575 > 0) {
            --var0.field575;
         }

         if(var0.field575 == 0) {
            if(var0.field579 < 0 || XClanMember.method261(var0.field579, var0.field576)) {
               method17(var0.field581, var0.field585, var0.field577, var0.field578, var0.field579, var0.field580, var0.field576);
               var0.unlink();
            }
         } else {
            if(var0.field586 > 0) {
               --var0.field586;
            }

            if(var0.field586 == 0 && var0.field577 >= 1 && var0.field578 >= 1 && var0.field577 <= 102 && var0.field578 <= 102 && (var0.field582 < 0 || XClanMember.method261(var0.field582, var0.field584))) {
               method17(var0.field581, var0.field585, var0.field577, var0.field578, var0.field582, var0.field583, var0.field584);
               var0.field586 = -1;
               if(var0.field582 == var0.field579 && var0.field579 == -1) {
                  var0.unlink();
               } else if(var0.field582 == var0.field579 && var0.field580 == var0.field583 && var0.field576 == var0.field584) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "-50"
   )
   public static void method20(class182 var0) {
      class168.field2192 = var0;
      class187.field2780 = class168.field2192.method3352(16);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIIB)V",
      garbageValue = "30"
   )
   static final void method21(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -class40.method830(var4 + 932731 + var2, var5 + var3 + 556238) * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class10.overlayIds[var1][var2][var3] = var0.readByte();
               class3.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class6.overlayRotations[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class202.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
