import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public final class class31 extends Node {
   @ObfuscatedName("e")
   class66 field698;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -560744271
   )
   int field699;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -685379939
   )
   int field700;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -995462711
   )
   int field701;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1624239507
   )
   int field702;
   @ObfuscatedName("u")
   static Deque field703 = new Deque();
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -542717043
   )
   int field704;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1808250131
   )
   int field705;
   @ObfuscatedName("g")
   class66 field706;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1802267763
   )
   int field707;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -484152267
   )
   int field708;
   @ObfuscatedName("m")
   int[] field709;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2078144791
   )
   int field710;
   @ObfuscatedName("v")
   ObjectComposition field712;
   @ObfuscatedName("gb")
   static Widget field715;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -894399931
   )
   int field716;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)Lclass142;",
      garbageValue = "642462369"
   )
   static class142 method676(class182 var0, int var1) {
      byte[] var2 = var0.method3267(var1);
      return var2 == null?null:new class142(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1487663354"
   )
   void method677() {
      int var1 = this.field705;
      ObjectComposition var2 = this.field712.getImpostor();
      if(var2 != null) {
         this.field705 = var2.field2924;
         this.field704 = var2.field2925 * 128;
         this.field707 = var2.field2926;
         this.field708 = var2.field2900;
         this.field709 = var2.field2928;
      } else {
         this.field705 = -1;
         this.field704 = 0;
         this.field707 = 0;
         this.field708 = 0;
         this.field709 = null;
      }

      if(var1 != this.field705 && this.field706 != null) {
         class20.field222.method903(this.field706);
         this.field706 = null;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "2077302431"
   )
   static final void method680(Actor var0, int var1) {
      int var5;
      if(var0.field610 > Client.gameCycle) {
         var5 = var0.field610 - Client.gameCycle;
         int var3 = var0.field603 * 64 + var0.field641 * 128;
         int var4 = var0.field603 * 64 + var0.field643 * 128;
         var0.x += (var3 - var0.x) / var5;
         var0.y += (var4 - var0.y) / var5;
         var0.field657 = 0;
         var0.field650 = var0.field647;
      } else if(var0.field646 >= Client.gameCycle) {
         XGrandExchangeOffer.method41(var0);
      } else {
         Tile.method1511(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field610 = 0;
         var0.field646 = 0;
         var0.x = var0.field603 * 64 + 128 * var0.pathX[0];
         var0.y = var0.field603 * 64 + 128 * var0.pathY[0];
         var0.method602();
      }

      if(class148.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field610 = 0;
         var0.field646 = 0;
         var0.x = var0.field603 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field603 * 64 + 128 * var0.pathY[0];
         var0.method602();
      }

      class41.method773(var0);
      var0.field602 = false;
      Sequence var2;
      if(var0.poseAnimation != -1) {
         var2 = CombatInfo2.getAnimation(var0.poseAnimation);
         if(null != var2 && null != var2.frameIDs) {
            ++var0.field606;
            if(var0.poseFrame < var2.frameIDs.length && var0.field606 > var2.frameLenghts[var0.poseFrame]) {
               var0.field606 = 1;
               ++var0.poseFrame;
               ItemLayer.method1411(var2, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var2.frameIDs.length) {
               var0.field606 = 0;
               var0.poseFrame = 0;
               ItemLayer.method1411(var2, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field648) {
         if(var0.field634 < 0) {
            var0.field634 = 0;
         }

         var5 = class185.method3389(var0.graphic).field2772;
         if(var5 != -1) {
            Sequence var6 = CombatInfo2.getAnimation(var5);
            if(null != var6 && null != var6.frameIDs) {
               ++var0.field638;
               if(var0.field634 < var6.frameIDs.length && var0.field638 > var6.frameLenghts[var0.field634]) {
                  var0.field638 = 1;
                  ++var0.field634;
                  ItemLayer.method1411(var6, var0.field634, var0.x, var0.y);
               }

               if(var0.field634 >= var6.frameIDs.length && (var0.field634 < 0 || var0.field634 >= var6.frameIDs.length)) {
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
         var2 = CombatInfo2.getAnimation(var0.animation);
         if(var2.precedenceAnimating == 1 && var0.field658 > 0 && var0.field610 <= Client.gameCycle && var0.field646 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var2 = CombatInfo2.getAnimation(var0.animation);
         if(null != var2 && null != var2.frameIDs) {
            ++var0.field633;
            if(var0.actionFrame < var2.frameIDs.length && var0.field633 > var2.frameLenghts[var0.actionFrame]) {
               var0.field633 = 1;
               ++var0.actionFrame;
               ItemLayer.method1411(var2, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var2.frameIDs.length) {
               var0.actionFrame -= var2.frameStep;
               ++var0.field635;
               if(var0.field635 >= var2.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var2.frameIDs.length) {
                  ItemLayer.method1411(var2, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field602 = var2.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1453267970"
   )
   static void method682() {
      Client var0 = Client.field279;
      synchronized(Client.field279) {
         Container var1 = Client.field279.method2074();
         if(null != var1) {
            ItemLayer.field1211 = Math.max(var1.getSize().width, class138.field1905);
            class11.field115 = Math.max(var1.getSize().height, class110.field1740);
            if(GameObject.field1615 == var1) {
               Insets var2 = GameObject.field1615.getInsets();
               ItemLayer.field1211 -= var2.right + var2.left;
               class11.field115 -= var2.bottom + var2.top;
            }

            if(ItemLayer.field1211 <= 0) {
               ItemLayer.field1211 = 1;
            }

            if(class11.field115 <= 0) {
               class11.field115 = 1;
            }

            if(class182.method3335() == 1) {
               class0.field1 = Client.field495;
               class65.field1099 = Client.field496;
            } else {
               class0.field1 = Math.min(ItemLayer.field1211, 7680);
               class65.field1099 = Math.min(class11.field115, 2160);
            }

            GameEngine.field1765 = (ItemLayer.field1211 - class0.field1) / 2;
            GameEngine.field1766 = 0;
            class165.canvas.setSize(class0.field1, class65.field1099);
            int var3 = class0.field1;
            int var4 = class65.field1099;
            Canvas var5 = class165.canvas;

            Object var11;
            try {
               MainBufferProvider var6 = new MainBufferProvider();
               var6.init(var3, var4, var5);
               var11 = var6;
            } catch (Throwable var9) {
               SecondaryBufferProvider var7 = new SecondaryBufferProvider();
               var7.init(var3, var4, var5);
               var11 = var7;
            }

            GameEngine.bufferProvider = (BufferProvider)var11;
            if(var1 == GameObject.field1615) {
               Insets var12 = GameObject.field1615.getInsets();
               class165.canvas.setLocation(GameEngine.field1765 + var12.left, GameEngine.field1766 + var12.top);
            } else {
               class165.canvas.setLocation(GameEngine.field1765, GameEngine.field1766);
            }

            class26.method600();
            if(Client.widgetRoot != -1) {
               XGrandExchangeOffer.method64(Client.widgetRoot, class0.field1, class65.field1099, true);
            }

            Client.method588();
         }
      }
   }
}
