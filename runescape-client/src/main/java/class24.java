import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public final class class24 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1583791111
   )
   int field610;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 43679499
   )
   int field611;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -348471115
   )
   int field612;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 112650781
   )
   int field613;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1509837907
   )
   int field614;
   @ObfuscatedName("cm")
   public static char field615;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -557590795
   )
   int field616;
   @ObfuscatedName("m")
   class67 field617;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2138372475
   )
   int field618;
   @ObfuscatedName("q")
   class67 field619;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2107444763
   )
   int field620;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -895893101
   )
   int field621;
   @ObfuscatedName("u")
   int[] field622;
   @ObfuscatedName("r")
   ObjectComposition field623;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1941586975
   )
   int field625;
   @ObfuscatedName("ab")
   static boolean field626;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 1380992493
   )
   static int field628;
   @ObfuscatedName("a")
   static Deque field629 = new Deque();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-948185426"
   )
   public static String method590(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class139.method2930(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1375845103"
   )
   static Class method591(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1575516227"
   )
   void method596() {
      int var1 = this.field616;
      ObjectComposition var2 = this.field623.getImpostor();
      if(null != var2) {
         this.field616 = var2.field960;
         this.field625 = var2.field968 * 128;
         this.field618 = var2.field992;
         this.field611 = var2.field947;
         this.field622 = var2.field976;
      } else {
         this.field616 = -1;
         this.field625 = 0;
         this.field618 = 0;
         this.field611 = 0;
         this.field622 = null;
      }

      if(var1 != this.field616 && this.field617 != null) {
         GameObject.field1759.method1188(this.field617);
         this.field617 = null;
      }

   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIB)V",
      garbageValue = "0"
   )
   static final void method597(Widget var0, int var1, int var2, int var3) {
      WidgetNode.method41();
      class178 var4 = var0.method3445(false);
      if(var4 != null) {
         class82.method1830(var1, var2, var4.field2959 + var1, var4.field2964 + var2);
         if(Client.field404 != 2 && Client.field404 != 5) {
            int var5 = Client.mapScale + Client.mapAngle & 2047;
            int var6 = WidgetNode.localPlayer.x / 32 + 48;
            int var7 = 464 - WidgetNode.localPlayer.y / 32;
            TextureProvider.field1712.method1789(var1, var2, var4.field2959, var4.field2964, var6, var7, var5, Client.mapScaleDelta + 256, var4.field2961, var4.field2960);

            int var8;
            int var17;
            int var19;
            for(var8 = 0; var8 < Client.field510; ++var8) {
               var19 = 2 + Client.field365[var8] * 4 - WidgetNode.localPlayer.x / 32;
               var17 = 2 + Client.field512[var8] * 4 - WidgetNode.localPlayer.y / 32;
               Friend.method192(var1, var2, var19, var17, Client.field513[var8], var4);
            }

            int var12;
            int var18;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var19 = 0; var19 < 104; ++var19) {
                  Deque var10 = Client.groundItemDeque[Item.plane][var8][var19];
                  if(var10 != null) {
                     var18 = 2 + var8 * 4 - WidgetNode.localPlayer.x / 32;
                     var12 = var19 * 4 + 2 - WidgetNode.localPlayer.y / 32;
                     Friend.method192(var1, var2, var18, var12, Client.field449[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field319; ++var8) {
               NPC var9 = Client.cachedNPCs[Client.field320[var8]];
               if(null != var9 && var9.vmethod785()) {
                  NPCComposition var21 = var9.composition;
                  if(var21 != null && null != var21.field923) {
                     var21 = var21.method810();
                  }

                  if(var21 != null && var21.isMinimapVisible && var21.field942) {
                     var18 = var9.x / 32 - WidgetNode.localPlayer.x / 32;
                     var12 = var9.y / 32 - WidgetNode.localPlayer.y / 32;
                     Friend.method192(var1, var2, var18, var12, Client.field449[1], var4);
                  }
               }
            }

            var8 = class34.field779;
            int[] var20 = class34.field780;

            for(var17 = 0; var17 < var8; ++var17) {
               Player var11 = Client.cachedPlayers[var20[var17]];
               if(var11 != null && var11.vmethod785() && !var11.field41 && WidgetNode.localPlayer != var11) {
                  var12 = var11.x / 32 - WidgetNode.localPlayer.x / 32;
                  int var13 = var11.y / 32 - WidgetNode.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class132.method2871(var11.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class133.field2138; ++var16) {
                     if(var11.name.equals(class175.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var24 = false;
                  if(WidgetNode.localPlayer.team != 0 && var11.team != 0 && WidgetNode.localPlayer.team == var11.team) {
                     var24 = true;
                  }

                  if(var14) {
                     Friend.method192(var1, var2, var12, var13, Client.field449[3], var4);
                  } else if(var24) {
                     Friend.method192(var1, var2, var12, var13, Client.field449[4], var4);
                  } else if(var15) {
                     Friend.method192(var1, var2, var12, var13, Client.field449[5], var4);
                  } else {
                     Friend.method192(var1, var2, var12, var13, Client.field449[2], var4);
                  }
               }
            }

            if(Client.field298 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field298 == 1 && Client.field299 >= 0 && Client.field299 < Client.cachedNPCs.length) {
                  NPC var22 = Client.cachedNPCs[Client.field299];
                  if(var22 != null) {
                     var18 = var22.x / 32 - WidgetNode.localPlayer.x / 32;
                     var12 = var22.y / 32 - WidgetNode.localPlayer.y / 32;
                     Item.method680(var1, var2, var18, var12, class164.field2709[1], var4);
                  }
               }

               if(Client.field298 == 2) {
                  var17 = Client.field301 * 4 - class9.baseX * 4 + 2 - WidgetNode.localPlayer.x / 32;
                  var18 = Client.field302 * 4 - KitDefinition.baseY * 4 + 2 - WidgetNode.localPlayer.y / 32;
                  Item.method680(var1, var2, var17, var18, class164.field2709[1], var4);
               }

               if(Client.field298 == 10 && Client.field300 >= 0 && Client.field300 < Client.cachedPlayers.length) {
                  Player var23 = Client.cachedPlayers[Client.field300];
                  if(null != var23) {
                     var18 = var23.x / 32 - WidgetNode.localPlayer.x / 32;
                     var12 = var23.y / 32 - WidgetNode.localPlayer.y / 32;
                     Item.method680(var1, var2, var18, var12, class164.field2709[1], var4);
                  }
               }
            }

            if(Client.flagX != 0) {
               var17 = Client.flagX * 4 + 2 - WidgetNode.localPlayer.x / 32;
               var18 = Client.flagY * 4 + 2 - WidgetNode.localPlayer.y / 32;
               Friend.method192(var1, var2, var17, var18, class164.field2709[0], var4);
            }

            if(!WidgetNode.localPlayer.field41) {
               class82.method1883(var1 + var4.field2959 / 2 - 1, var4.field2964 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            class82.method1874(var1, var2, 0, var4.field2961, var4.field2960);
         }

         Client.field486[var3] = true;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "16777215"
   )
   public static String method599(int var0, boolean var1) {
      return var1 && var0 >= 0?class40.method801(var0, 10, var1):Integer.toString(var0);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)LWidget;",
      garbageValue = "2"
   )
   public static Widget method600(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || null == Widget.widgets[var1][var2]) {
         boolean var3 = class93.method2114(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1649606258"
   )
   public static void method601() {
      NPCComposition.field932.reset();
      NPCComposition.npcModelCache.reset();
   }
}
