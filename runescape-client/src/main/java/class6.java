import java.applet.Applet;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class6 implements Comparator {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 7042529635960629701L
   )
   static long field64;
   @ObfuscatedName("bx")
   static class184 field68;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 310029029
   )
   static int field69;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = 549661149
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -724542975
   )
   static int field72;
   @ObfuscatedName("s")
   public static class182 field73;

   public int compare(Object var1, Object var2) {
      return this.method70((class2)var1, (class2)var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "2"
   )
   int method70(class2 var1, class2 var2) {
      return var1.method17().compareTo(var2.method17());
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "1029628923"
   )
   public static Object method73(byte[] var0, boolean var1) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class156.field2125) {
            try {
               class151 var2 = new class151();
               var2.vmethod2930(var0);
               return var2;
            } catch (Throwable var3) {
               class156.field2125 = true;
            }
         }

         return var0;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "964778666"
   )
   static final void method76(Actor var0) {
      var0.field607 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class110.getAnimation(var0.poseAnimation);
         if(null != var1 && null != var1.frameIDs) {
            ++var0.field635;
            if(var0.poseFrame < var1.frameIDs.length && var0.field635 > var1.frameLenghts[var0.poseFrame]) {
               var0.field635 = 1;
               ++var0.poseFrame;
               World.method635(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field635 = 0;
               var0.poseFrame = 0;
               World.method635(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field604) {
         if(var0.field642 < 0) {
            var0.field642 = 0;
         }

         int var3 = class48.method844(var0.graphic).field2801;
         if(var3 != -1) {
            Sequence var2 = class110.getAnimation(var3);
            if(null != var2 && null != var2.frameIDs) {
               ++var0.field643;
               if(var0.field642 < var2.frameIDs.length && var0.field643 > var2.frameLenghts[var0.field642]) {
                  var0.field643 = 1;
                  ++var0.field642;
                  World.method635(var2, var0.field642, var0.x, var0.y);
               }

               if(var0.field642 >= var2.frameIDs.length && (var0.field642 < 0 || var0.field642 >= var2.frameIDs.length)) {
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
         var1 = class110.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field663 > 0 && var0.field661 <= Client.gameCycle && var0.field651 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class110.getAnimation(var0.animation);
         if(null != var1 && null != var1.frameIDs) {
            ++var0.field638;
            if(var0.actionFrame < var1.frameIDs.length && var0.field638 > var1.frameLenghts[var0.actionFrame]) {
               var0.field638 = 1;
               ++var0.actionFrame;
               World.method635(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field640;
               if(var0.field640 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  World.method635(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field607 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "80704228"
   )
   static void method77() {
      if(Client.field446) {
         Widget var0 = class112.method2038(class3.field43, Client.field447);
         if(var0 != null && null != var0.field2301) {
            class18 var1 = new class18();
            var1.field204 = var0;
            var1.field205 = var0.field2301;
            CombatInfo1.method594(var1);
         }

         Client.field446 = false;
         class204.method3671(var0);
      }
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1377541346"
   )
   static final boolean method78(Widget var0) {
      if(var0.field2322 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2322.length; ++var1) {
            int var2 = class11.method132(var0, var1);
            int var3 = var0.field2310[var1];
            if(var0.field2322[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2322[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2322[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1411981924"
   )
   static final void method79(String var0) {
      if(!var0.equals("")) {
         Client.field336.method2963(144);
         class159 var1 = Client.field336;
         int var2 = var0.length() + 1;
         var1.method2708(var2);
         Client.field336.method2714(var0);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-166392934"
   )
   static final int method80(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & 16711935) * var3 + (var1 & 16711935) * var2 & -16711936) + ((var1 & '\uff00') * var2 + var3 * (var0 & '\uff00') & 16711680) >> 8;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;S)V",
      garbageValue = "1102"
   )
   public static void method81(Applet var0, String var1) {
      class114.field1795 = var0;
      class114.field1791 = var1;
   }
}
