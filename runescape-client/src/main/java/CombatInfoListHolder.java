import java.awt.Font;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("i")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("a")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();
   @ObfuscatedName("qu")
   protected static Font field752;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 452148187
   )
   protected static int field753;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "-946081635"
   )
   public static void method701(class182 var0, class182 var1, class182 var2) {
      class196.field2861 = var0;
      class196.field2851 = var1;
      class196.field2860 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "348112723"
   )
   void method702(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2358(); null != var7; var7 = (CombatInfo1)this.combatInfo1.method2360()) {
         ++var6;
         if(var7.field662 == var1) {
            var7.method618(var1, var2, var3, var4);
            return;
         }

         if(var7.field662 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method2356(new CombatInfo1(var1, var2, var3, var4));
         }
      } else {
         CombatInfoList.method2357(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2358().unlink();
         }
      }

   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1515426745"
   )
   boolean method703() {
      return this.combatInfo1.method2362();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "114369188"
   )
   CombatInfo1 method707(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2358();
      if(var2 != null && var2.field662 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2360(); var3 != null && var3.field662 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2360()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field662 + var2.field663 + this.combatInfo2.field2814 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "81"
   )
   public static void method708() {
      if(null != class185.field2737) {
         class185.field2737.method2026();
      }

   }

   @ObfuscatedName("x")
   static final void method709(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "146557188"
   )
   @Export("calculateHeight")
   public static int calculateHeight(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass110;ZB)V",
      garbageValue = "-24"
   )
   public static void method711(class110 var0, boolean var1) {
      if(null != class185.field2737) {
         try {
            class185.field2737.method2026();
         } catch (Exception var7) {
            ;
         }

         class185.field2737 = null;
      }

      class185.field2737 = var0;
      FrameMap.method1666(var1);
      class185.field2735.offset = 0;
      class185.field2723 = null;
      class22.field238 = null;
      class185.field2743 = 0;

      while(true) {
         class181 var2 = (class181)class185.field2726.method2344();
         if(var2 == null) {
            while(true) {
               var2 = (class181)class185.field2731.method2344();
               if(null == var2) {
                  if(class185.field2739 != 0) {
                     try {
                        Buffer var3 = new Buffer(4);
                        var3.method2760(4);
                        var3.method2760(class185.field2739);
                        var3.method2918(0);
                        class185.field2737.method2018(var3.payload, 0, 4);
                     } catch (IOException var6) {
                        try {
                           class185.field2737.method2026();
                        } catch (Exception var5) {
                           ;
                        }

                        ++class185.field2736;
                        class185.field2737 = null;
                     }
                  }

                  class185.field2722 = 0;
                  class185.field2721 = class9.method117();
                  return;
               }

               class185.field2728.method2285(var2);
               class185.field2727.method2340(var2, var2.hash);
               ++class185.field2734;
               --class185.field2732;
            }
         }

         class185.field2724.method2340(var2, var2.hash);
         ++class185.field2725;
         --class185.field2741;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)V",
      garbageValue = "9"
   )
   static final void method712(class159 var0) {
      var0.method3031();
      int var1 = Client.localInteractingIndex;
      Player var2 = class148.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field244 = var1;
      int var3 = var0.method3032(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - FrameMap.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method215() << 6);
      var2.pathY[0] = var6 - XItemContainer.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method215() << 6);
      class60.plane = var2.field261 = var4;
      if(class45.field887[var1] != null) {
         var2.method214(class45.field887[var1]);
      }

      class45.field888 = 0;
      class45.field892[++class45.field888 - 1] = var1;
      class45.field885[var1] = 0;
      class45.field890 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3032(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class45.field889[var7] = (var9 << 28) + (var10 << 14) + var11;
            class45.field883[var7] = 0;
            class45.field894[var7] = -1;
            class45.field899[++class45.field890 - 1] = var7;
            class45.field885[var7] = 0;
         }
      }

      var0.method3040();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-638420397"
   )
   public static void method714() {
      NPCComposition.field2988.reset();
      NPCComposition.npcModelCache.reset();
   }
}
