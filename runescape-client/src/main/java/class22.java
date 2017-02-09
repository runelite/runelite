import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class22 extends class119 {
   @ObfuscatedName("ny")
   static class65 field237;
   @ObfuscatedName("eu")
   static SpritePixels[] field239;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -1816379913
   )
   static int field240;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "2140491642"
   )
   public boolean vmethod2275(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field1846 && var3 == super.field1847;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "17"
   )
   public static synchronized long method224() {
      long var0 = System.currentTimeMillis();
      if(var0 < class162.field2280) {
         class162.field2277 += class162.field2280 - var0;
      }

      class162.field2280 = var0;
      return class162.field2277 + var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[BLclass116;B)V",
      garbageValue = "46"
   )
   static void method225(int var0, byte[] var1, class116 var2) {
      class180 var3 = new class180();
      var3.field2685 = 0;
      var3.hash = (long)var0;
      var3.field2682 = var1;
      var3.field2683 = var2;
      Deque var4 = class183.field2714;
      synchronized(class183.field2714) {
         class183.field2714.method2380(var3);
      }

      Object var9 = class183.field2712;
      synchronized(class183.field2712) {
         if(class183.field2715 == 0) {
            class63.field1093.method1945(new class183(), 5);
         }

         class183.field2715 = 600;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILclass182;IIIZI)V",
      garbageValue = "-333488808"
   )
   public static void method228(int var0, class182 var1, int var2, int var3, int var4, boolean var5) {
      class138.field1910 = 1;
      class1.field10 = var1;
      class138.field1915 = var2;
      ChatLineBuffer.field971 = var3;
      class97.field1631 = var4;
      class138.field1912 = var5;
      class15.field165 = var0;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1831567854"
   )
   static final void method229() {
      for(int var0 = 0; var0 < Client.field311; ++var0) {
         int var1 = Client.field320[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field323.readUnsignedByte();
         int var4;
         int var5;
         int var6;
         if((var3 & 16) != 0) {
            var4 = Client.field323.method2962();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field323.method3092();
            if(var4 == var2.animation && var4 != -1) {
               var6 = TextureProvider.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field624 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field590 = 0;
               }

               if(var6 == 2) {
                  var2.field590 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || TextureProvider.getAnimation(var4).forcedPriority >= TextureProvider.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field624 = 0;
               var2.actionAnimationDisable = var5;
               var2.field590 = 0;
               var2.field645 = var2.field644;
            }
         }

         int var7;
         if((var3 & 1) != 0) {
            var4 = Client.field323.readUnsignedShort();
            var5 = Client.field323.readUnsignedShort();
            var6 = var2.x - (var4 - class114.baseX - class114.baseX) * 64;
            var7 = var2.y - (var5 - CombatInfo1.baseY - CombatInfo1.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field635 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 32) != 0) {
            var2.interacting = Client.field323.method2962();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         if((var3 & 2) != 0) {
            var2.composition = class45.getNpcDefinition(Client.field323.method2963());
            var2.field597 = var2.composition.field2987;
            var2.field643 = var2.composition.field2984;
            var2.field598 = var2.composition.field2993;
            var2.field599 = var2.composition.field3007;
            var2.field600 = var2.composition.field2995;
            var2.field601 = var2.composition.field2996;
            var2.idlePoseAnimation = var2.composition.field2990;
            var2.field596 = var2.composition.field2991;
            var2.field642 = var2.composition.field2992;
         }

         if((var3 & 64) != 0) {
            var2.graphic = Client.field323.method3037();
            var4 = Client.field323.method2972();
            var2.field631 = var4 >> 16;
            var2.field630 = Client.gameCycle + (var4 & '\uffff');
            var2.field647 = 0;
            var2.field629 = 0;
            if(var2.field630 > Client.gameCycle) {
               var2.field647 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         if((var3 & 8) != 0) {
            var2.overhead = Client.field323.method2934();
            var2.field606 = 100;
         }

         if((var3 & 4) != 0) {
            var4 = Client.field323.method2953();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field323.method2939();
                  if(var6 == 32767) {
                     var6 = Client.field323.method2939();
                     var8 = Client.field323.method2939();
                     var7 = Client.field323.method2939();
                     var9 = Client.field323.method2939();
                  } else if(var6 != 32766) {
                     var8 = Client.field323.method2939();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field323.method2939();
                  var2.method628(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field323.method3092();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field323.method2939();
                  var8 = Client.field323.method2939();
                  if(var8 != 32767) {
                     var9 = Client.field323.method2939();
                     var10 = Client.field323.method3092();
                     int var11 = var8 > 0?Client.field323.method2953():var10;
                     var2.method625(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method629(var7);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo2;",
      garbageValue = "169999122"
   )
   public static CombatInfo2 method231(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field2821.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field2826.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method3512(new Buffer(var2));
         }

         CombatInfo2.field2821.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2033515993"
   )
   static void method232() {
      for(class31 var0 = (class31)class31.field693.method2403(); var0 != null; var0 = (class31)class31.field693.method2398()) {
         if(null != var0.field706) {
            var0.method699();
         }
      }

   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZB)V",
      garbageValue = "46"
   )
   static void method233(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      TextureProvider.method1460(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         TextureProvider.method1460(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2331((long)var1.id);
      if(null != var5) {
         int var6 = var5.id;
         if(class15.method193(var6)) {
            TextureProvider.method1460(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
