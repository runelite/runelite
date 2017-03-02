import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
final class class44 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 581979561
   )
   static int field890;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "636296970"
   )
   static String method874(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class101) {
         class101 var2 = (class101)var0;
         var1 = var2.field1646 + " | ";
         var0 = var2.field1647;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(null == var7) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, 1 + var8);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(5 + var11);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1487126995"
   )
   int method875(class2 var1, class2 var2) {
      if(var1.field24 == var2.field24) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field24) {
               return -1;
            }

            if(Client.world == var2.field24) {
               return 1;
            }
         }

         return var1.field24 < var2.field24?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method875((class2)var1, (class2)var2);
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1408962757"
   )
   static final void method884(Actor var0) {
      var0.field632 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = XClanMember.getAnimation(var0.poseAnimation);
         if(null != var1 && var1.frameIDs != null) {
            ++var0.field629;
            if(var0.poseFrame < var1.frameIDs.length && var0.field629 > var1.frameLenghts[var0.poseFrame]) {
               var0.field629 = 1;
               ++var0.poseFrame;
               class15.method192(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field629 = 0;
               var0.poseFrame = 0;
               class15.method192(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field641) {
         if(var0.field639 < 0) {
            var0.field639 = 0;
         }

         int var3 = class160.method3154(var0.graphic).field2797;
         if(var3 != -1) {
            Sequence var2 = XClanMember.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.field628;
               if(var0.field639 < var2.frameIDs.length && var0.field628 > var2.frameLenghts[var0.field639]) {
                  var0.field628 = 1;
                  ++var0.field639;
                  class15.method192(var2, var0.field639, var0.x, var0.y);
               }

               if(var0.field639 >= var2.frameIDs.length && (var0.field639 < 0 || var0.field639 >= var2.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var1 = XClanMember.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field660 > 0 && var0.field647 <= Client.gameCycle && var0.field633 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = XClanMember.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field635;
            if(var0.actionFrame < var1.frameIDs.length && var0.field635 > var1.frameLenghts[var0.actionFrame]) {
               var0.field635 = 1;
               ++var0.actionFrame;
               class15.method192(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field637;
               if(var0.field637 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class15.method192(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field632 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-620897161"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 31) {
         Client.field327.method3124(254);
         Client.field327.method2842(class109.field1732);
         Client.field327.method2844(var1);
         Client.field327.method2890(var0);
         Client.field327.method2890(GroundObject.field1284);
         Client.field327.method2899(XGrandExchangeOffer.field42);
         Client.field327.method2842(var3);
         Client.field396 = 0;
         class101.field1644 = class140.method2681(var1);
         Client.field308 = var0;
      }

      Player var8;
      if(var2 == 46) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(46);
            Client.field327.method3010(class105.field1700[82]?1:0);
            Client.field327.method2890(var3);
         }
      }

      if(var2 == 14) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(1);
            Client.field327.method3010(class105.field1700[82]?1:0);
            Client.field327.method2890(var3);
            Client.field327.method2842(GroundObject.field1284);
            Client.field327.method2842(class109.field1732);
            Client.field327.method2899(XGrandExchangeOffer.field42);
         }
      }

      if(var2 == 36) {
         Client.field327.method3124(253);
         Client.field327.method2899(var1);
         Client.field327.method2890(var0);
         Client.field327.method2887(var3);
         Client.field396 = 0;
         class101.field1644 = class140.method2681(var1);
         Client.field308 = var0;
      }

      if(var2 == 1) {
         Client.field392 = var6;
         Client.field524 = var7;
         Client.field326 = 2;
         Client.field394 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field327.method3124(140);
         Client.field327.method2889(GroundObject.field1284);
         Client.field327.method2842(var3 >> 14 & 32767);
         Client.field327.method3008(XGrandExchangeOffer.field42);
         Client.field327.method2880(class105.field1700[82]?1:0);
         Client.field327.method2889(class2.baseY + var1);
         Client.field327.method2887(MessageNode.baseX + var0);
         Client.field327.method2842(class109.field1732);
      }

      NPC var14;
      if(var2 == 12) {
         var14 = Client.cachedNPCs[var3];
         if(var14 != null) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(189);
            Client.field327.method2842(var3);
            Client.field327.method3048(class105.field1700[82]?1:0);
         }
      }

      int var9;
      Widget var15;
      if(var2 == 29) {
         Client.field327.method3124(54);
         Client.field327.method2844(var1);
         var15 = class140.method2681(var1);
         if(null != var15.dynamicValues && var15.dynamicValues[0][0] == 5) {
            var9 = var15.dynamicValues[0][1];
            if(class165.widgetSettings[var9] != var15.field2192[0]) {
               class165.widgetSettings[var9] = var15.field2192[0];
               CombatInfoListHolder.method777(var9);
            }
         }
      }

      if(var2 == 42) {
         Client.field327.method3124(60);
         Client.field327.method2898(var1);
         Client.field327.method2890(var0);
         Client.field327.method2842(var3);
         Client.field396 = 0;
         class101.field1644 = class140.method2681(var1);
         Client.field308 = var0;
      }

      if(var2 == 10) {
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(193);
            Client.field327.method3010(class105.field1700[82]?1:0);
            Client.field327.method2842(var3);
         }
      }

      if(var2 == 51) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(133);
            Client.field327.method2889(var3);
            Client.field327.method2880(class105.field1700[82]?1:0);
         }
      }

      if(var2 == 1005) {
         var15 = class140.method2681(var1);
         if(null != var15 && var15.itemQuantities[var0] >= 100000) {
            class140.sendGameMessage(27, "", var15.itemQuantities[var0] + " x " + class168.getItemDefinition(var3).name);
         } else {
            Client.field327.method3124(4);
            Client.field327.method2890(var3);
         }

         Client.field396 = 0;
         class101.field1644 = class140.method2681(var1);
         Client.field308 = var0;
      }

      if(var2 == 19) {
         Client.field392 = var6;
         Client.field524 = var7;
         Client.field326 = 2;
         Client.field394 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field327.method3124(8);
         Client.field327.method2889(var1 + class2.baseY);
         Client.field327.method2842(var3);
         Client.field327.method2960(class105.field1700[82]?1:0);
         Client.field327.method2889(var0 + MessageNode.baseX);
      }

      if(var2 == 7) {
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(195);
            Client.field327.method2887(GroundObject.field1284);
            Client.field327.method2842(class109.field1732);
            Client.field327.method2890(var3);
            Client.field327.method2899(XGrandExchangeOffer.field42);
            Client.field327.method3048(class105.field1700[82]?1:0);
         }
      }

      if(var2 == 30 && Client.field546 == null) {
         Client.field327.method3124(192);
         Client.field327.method2844(var1);
         Client.field327.method2890(var0);
         Client.field546 = CollisionData.method2322(var1, var0);
         Frames.method1960(Client.field546);
      }

      if(var2 == 22) {
         Client.field392 = var6;
         Client.field524 = var7;
         Client.field326 = 2;
         Client.field394 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field327.method3124(152);
         Client.field327.method2890(MessageNode.baseX + var0);
         Client.field327.method2889(var3);
         Client.field327.method2887(var1 + class2.baseY);
         Client.field327.method2960(class105.field1700[82]?1:0);
      }

      if(var2 == 25) {
         var15 = CollisionData.method2322(var1, var0);
         if(null != var15) {
            XClanMember.method258();
            RSCanvas.method2141(var1, var0, class0.method10(class8.method112(var15)), var15.item);
            Client.field438 = 0;
            Client.field328 = class37.method807(var15);
            if(Client.field328 == null) {
               Client.field328 = "Null";
            }

            if(var15.hasScript) {
               Client.field350 = var15.name + class187.method3515(16777215);
            } else {
               Client.field350 = class187.method3515('\uff00') + var15.field2312 + class187.method3515(16777215);
            }
         }

      } else {
         if(var2 == 35) {
            Client.field327.method3124(215);
            Client.field327.method2898(var1);
            Client.field327.method2887(var0);
            Client.field327.method2842(var3);
            Client.field396 = 0;
            class101.field1644 = class140.method2681(var1);
            Client.field308 = var0;
         }

         if(var2 == 17) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(83);
            Client.field327.method2890(var0 + MessageNode.baseX);
            Client.field327.method2844(class170.field2331);
            Client.field327.method2889(class2.baseY + var1);
            Client.field327.method2889(var3);
            Client.field327.method2887(Client.field441);
            Client.field327.method2880(class105.field1700[82]?1:0);
         }

         if(var2 == 2) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(13);
            Client.field327.method3010(class105.field1700[82]?1:0);
            Client.field327.method2842(MessageNode.baseX + var0);
            Client.field327.method2889(var1 + class2.baseY);
            Client.field327.method2890(var3 >> 14 & 32767);
            Client.field327.method2898(class170.field2331);
            Client.field327.method2890(Client.field441);
         }

         if(var2 == 24) {
            var15 = class140.method2681(var1);
            boolean var16 = true;
            if(var15.contentType > 0) {
               var16 = CombatInfoListHolder.method769(var15);
            }

            if(var16) {
               Client.field327.method3124(54);
               Client.field327.method2844(var1);
            }
         }

         if(var2 == 41) {
            Client.field327.method3124(68);
            Client.field327.method2842(var3);
            Client.field327.method3008(var1);
            Client.field327.method2889(var0);
            Client.field396 = 0;
            class101.field1644 = class140.method2681(var1);
            Client.field308 = var0;
         }

         if(var2 == 8) {
            var14 = Client.cachedNPCs[var3];
            if(null != var14) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(161);
               Client.field327.method2960(class105.field1700[82]?1:0);
               Client.field327.method2889(Client.field441);
               Client.field327.method2889(var3);
               Client.field327.method2899(class170.field2331);
            }
         }

         if(var2 == 4) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(200);
            Client.field327.method2887(var0 + MessageNode.baseX);
            Client.field327.method3048(class105.field1700[82]?1:0);
            Client.field327.method2842(var3 >> 14 & 32767);
            Client.field327.method2890(class2.baseY + var1);
         }

         if(var2 == 43) {
            Client.field327.method3124(101);
            Client.field327.method2898(var1);
            Client.field327.method2889(var0);
            Client.field327.method2890(var3);
            Client.field396 = 0;
            class101.field1644 = class140.method2681(var1);
            Client.field308 = var0;
         }

         if(var2 == 21) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(134);
            Client.field327.method2890(var3);
            Client.field327.method3010(class105.field1700[82]?1:0);
            Client.field327.method2889(class2.baseY + var1);
            Client.field327.method2887(MessageNode.baseX + var0);
         }

         if(var2 == 3) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(232);
            Client.field327.method3048(class105.field1700[82]?1:0);
            Client.field327.method2842(var3 >> 14 & 32767);
            Client.field327.method2890(MessageNode.baseX + var0);
            Client.field327.method2887(class2.baseY + var1);
         }

         if(var2 == 1004) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.field327.method3124(4);
            Client.field327.method2890(var3);
         }

         if(var2 == 34) {
            Client.field327.method3124(5);
            Client.field327.method2887(var0);
            Client.field327.method2889(var3);
            Client.field327.method2899(var1);
            Client.field396 = 0;
            class101.field1644 = class140.method2681(var1);
            Client.field308 = var0;
         }

         if(var2 == 58) {
            var15 = CollisionData.method2322(var1, var0);
            if(null != var15) {
               Client.field327.method3124(236);
               Client.field327.method2887(var15.item);
               Client.field327.method2842(Client.field441);
               Client.field327.method2844(var1);
               Client.field327.method3008(class170.field2331);
               Client.field327.method2842(var0);
               Client.field327.method2890(Client.field442);
            }
         }

         if(var2 == 13) {
            var14 = Client.cachedNPCs[var3];
            if(null != var14) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(245);
               Client.field327.method2889(var3);
               Client.field327.method2880(class105.field1700[82]?1:0);
            }
         }

         if(var2 == 23) {
            if(Client.isMenuOpen) {
               Varbit.region.method1758();
            } else {
               Varbit.region.method1792(class156.plane, var0, var1, true);
            }
         }

         if(var2 == 11) {
            var14 = Client.cachedNPCs[var3];
            if(null != var14) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(126);
               Client.field327.method2889(var3);
               Client.field327.method3010(class105.field1700[82]?1:0);
            }
         }

         if(var2 == 32) {
            Client.field327.method3124(217);
            Client.field327.method2890(Client.field441);
            Client.field327.method2890(var3);
            Client.field327.method2898(var1);
            Client.field327.method2890(var0);
            Client.field327.method2898(class170.field2331);
            Client.field396 = 0;
            class101.field1644 = class140.method2681(var1);
            Client.field308 = var0;
         }

         if(var2 == 45) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(136);
               Client.field327.method2880(class105.field1700[82]?1:0);
               Client.field327.method2889(var3);
            }
         }

         if(var2 == 44) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(69);
               Client.field327.method3010(class105.field1700[82]?1:0);
               Client.field327.method2890(var3);
            }
         }

         if(var2 == 39) {
            Client.field327.method3124(118);
            Client.field327.method2890(var3);
            Client.field327.method2898(var1);
            Client.field327.method2889(var0);
            Client.field396 = 0;
            class101.field1644 = class140.method2681(var1);
            Client.field308 = var0;
         }

         if(var2 == 57 || var2 == 1007) {
            var15 = CollisionData.method2322(var1, var0);
            if(null != var15) {
               var9 = var15.item;
               Widget var10 = CollisionData.method2322(var1, var0);
               if(var10 != null) {
                  if(null != var10.field2288) {
                     class18 var11 = new class18();
                     var11.field185 = var10;
                     var11.field190 = var3;
                     var11.field194 = var5;
                     var11.field197 = var10.field2288;
                     class97.method1988(var11);
                  }

                  boolean var13 = true;
                  if(var10.contentType > 0) {
                     var13 = CombatInfoListHolder.method769(var10);
                  }

                  if(var13 && class188.method3518(class8.method112(var10), var3 - 1)) {
                     if(var3 == 1) {
                        Client.field327.method3124(212);
                        Client.field327.method2844(var1);
                        Client.field327.method2842(var0);
                        Client.field327.method2842(var9);
                     }

                     if(var3 == 2) {
                        Client.field327.method3124(36);
                        Client.field327.method2844(var1);
                        Client.field327.method2842(var0);
                        Client.field327.method2842(var9);
                     }

                     if(var3 == 3) {
                        Client.field327.method3124(20);
                        Client.field327.method2844(var1);
                        Client.field327.method2842(var0);
                        Client.field327.method2842(var9);
                     }

                     if(var3 == 4) {
                        Client.field327.method3124(130);
                        Client.field327.method2844(var1);
                        Client.field327.method2842(var0);
                        Client.field327.method2842(var9);
                     }

                     if(var3 == 5) {
                        Client.field327.method3124(66);
                        Client.field327.method2844(var1);
                        Client.field327.method2842(var0);
                        Client.field327.method2842(var9);
                     }

                     if(var3 == 6) {
                        Client.field327.method3124(40);
                        Client.field327.method2844(var1);
                        Client.field327.method2842(var0);
                        Client.field327.method2842(var9);
                     }

                     if(var3 == 7) {
                        Client.field327.method3124(146);
                        Client.field327.method2844(var1);
                        Client.field327.method2842(var0);
                        Client.field327.method2842(var9);
                     }

                     if(var3 == 8) {
                        Client.field327.method3124(3);
                        Client.field327.method2844(var1);
                        Client.field327.method2842(var0);
                        Client.field327.method2842(var9);
                     }

                     if(var3 == 9) {
                        Client.field327.method3124(147);
                        Client.field327.method2844(var1);
                        Client.field327.method2842(var0);
                        Client.field327.method2842(var9);
                     }

                     if(var3 == 10) {
                        Client.field327.method3124(123);
                        Client.field327.method2844(var1);
                        Client.field327.method2842(var0);
                        Client.field327.method2842(var9);
                     }
                  }
               }
            }
         }

         if(var2 == 5) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(157);
            Client.field327.method2890(var1 + class2.baseY);
            Client.field327.method2889(var3 >> 14 & 32767);
            Client.field327.method3048(class105.field1700[82]?1:0);
            Client.field327.method2887(var0 + MessageNode.baseX);
         }

         if(var2 == 1001) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(11);
            Client.field327.method3010(class105.field1700[82]?1:0);
            Client.field327.method2890(var3 >> 14 & 32767);
            Client.field327.method2887(var0 + MessageNode.baseX);
            Client.field327.method2842(var1 + class2.baseY);
         }

         if(var2 == 47) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(225);
               Client.field327.method2842(var3);
               Client.field327.method3048(class105.field1700[82]?1:0);
            }
         }

         if(var2 == 49) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(58);
               Client.field327.method2887(var3);
               Client.field327.method2880(class105.field1700[82]?1:0);
            }
         }

         if(var2 == 6) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(196);
            Client.field327.method2890(var3 >> 14 & 32767);
            Client.field327.method2880(class105.field1700[82]?1:0);
            Client.field327.method2887(MessageNode.baseX + var0);
            Client.field327.method2842(class2.baseY + var1);
         }

         if(var2 == 26) {
            Client.field327.method3124(6);

            for(WidgetNode var17 = (WidgetNode)Client.componentTable.method2423(); null != var17; var17 = (WidgetNode)Client.componentTable.method2424()) {
               if(var17.field179 == 0 || var17.field179 == 3) {
                  class30.method683(var17, true);
               }
            }

            if(Client.field546 != null) {
               Frames.method1960(Client.field546);
               Client.field546 = null;
            }
         }

         if(var2 == 15) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(112);
               Client.field327.method2842(var3);
               Client.field327.method2960(class105.field1700[82]?1:0);
               Client.field327.method3008(class170.field2331);
               Client.field327.method2887(Client.field441);
            }
         }

         if(var2 == 50) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(53);
               Client.field327.method2880(class105.field1700[82]?1:0);
               Client.field327.method2889(var3);
            }
         }

         if(var2 == 18) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(191);
            Client.field327.method2889(var0 + MessageNode.baseX);
            Client.field327.method2880(class105.field1700[82]?1:0);
            Client.field327.method2842(class2.baseY + var1);
            Client.field327.method2890(var3);
         }

         if(var2 == 1002) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.field327.method3124(92);
            Client.field327.method2887(var3 >> 14 & 32767);
         }

         if(var2 == 9) {
            var14 = Client.cachedNPCs[var3];
            if(null != var14) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(102);
               Client.field327.method3048(class105.field1700[82]?1:0);
               Client.field327.method2889(var3);
            }
         }

         if(var2 == 40) {
            Client.field327.method3124(160);
            Client.field327.method2890(var3);
            Client.field327.method2889(var0);
            Client.field327.method2844(var1);
            Client.field396 = 0;
            class101.field1644 = class140.method2681(var1);
            Client.field308 = var0;
         }

         if(var2 == 48) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field392 = var6;
               Client.field524 = var7;
               Client.field326 = 2;
               Client.field394 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field327.method3124(111);
               Client.field327.method2880(class105.field1700[82]?1:0);
               Client.field327.method2889(var3);
            }
         }

         if(var2 == 37) {
            Client.field327.method3124(176);
            Client.field327.method2890(var3);
            Client.field327.method2899(var1);
            Client.field327.method2889(var0);
            Client.field396 = 0;
            class101.field1644 = class140.method2681(var1);
            Client.field308 = var0;
         }

         if(var2 == 1003) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            var14 = Client.cachedNPCs[var3];
            if(var14 != null) {
               NPCComposition var12 = var14.composition;
               if(null != var12.configs) {
                  var12 = var12.method3807();
               }

               if(var12 != null) {
                  Client.field327.method3124(19);
                  Client.field327.method2889(var12.id);
               }
            }
         }

         if(var2 == 20) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(137);
            Client.field327.method2842(MessageNode.baseX + var0);
            Client.field327.method2889(var3);
            Client.field327.method3010(class105.field1700[82]?1:0);
            Client.field327.method2887(class2.baseY + var1);
         }

         if(var2 == 28) {
            Client.field327.method3124(54);
            Client.field327.method2844(var1);
            var15 = class140.method2681(var1);
            if(var15.dynamicValues != null && var15.dynamicValues[0][0] == 5) {
               var9 = var15.dynamicValues[0][1];
               class165.widgetSettings[var9] = 1 - class165.widgetSettings[var9];
               CombatInfoListHolder.method777(var9);
            }
         }

         if(var2 == 16) {
            Client.field392 = var6;
            Client.field524 = var7;
            Client.field326 = 2;
            Client.field394 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field327.method3124(85);
            Client.field327.method2889(var0 + MessageNode.baseX);
            Client.field327.method3048(class105.field1700[82]?1:0);
            Client.field327.method2889(var3);
            Client.field327.method2887(class2.baseY + var1);
            Client.field327.method2890(class109.field1732);
            Client.field327.method2887(GroundObject.field1284);
            Client.field327.method2899(XGrandExchangeOffer.field42);
         }

         if(var2 == 33) {
            Client.field327.method3124(47);
            Client.field327.method2887(var3);
            Client.field327.method2889(var0);
            Client.field327.method2898(var1);
            Client.field396 = 0;
            class101.field1644 = class140.method2681(var1);
            Client.field308 = var0;
         }

         if(var2 == 38) {
            XClanMember.method258();
            var15 = class140.method2681(var1);
            Client.field438 = 1;
            class109.field1732 = var0;
            XGrandExchangeOffer.field42 = var1;
            GroundObject.field1284 = var3;
            Frames.method1960(var15);
            Client.field439 = class187.method3515(16748608) + class168.getItemDefinition(var3).name + class187.method3515(16777215);
            if(null == Client.field439) {
               Client.field439 = "null";
            }

         } else {
            if(Client.field438 != 0) {
               Client.field438 = 0;
               Frames.method1960(class140.method2681(XGrandExchangeOffer.field42));
            }

            if(Client.field549) {
               XClanMember.method258();
            }

            if(class101.field1644 != null && Client.field396 == 0) {
               Frames.method1960(class101.field1644);
            }

         }
      }
   }
}
