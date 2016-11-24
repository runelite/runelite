import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class15 {
   @ObfuscatedName("m")
   static final class15 field152 = new class15();
   @ObfuscatedName("d")
   static final class15 field154 = new class15();
   @ObfuscatedName("h")
   static final class15 field155 = new class15();
   @ObfuscatedName("nn")
   static class57 field156;
   @ObfuscatedName("n")
   static final class15 field158 = new class15();
   @ObfuscatedName("py")
   public static class103 field159;

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(LWidget;II)Ljava/lang/String;",
      garbageValue = "799629470"
   )
   static String method190(Widget var0, int var1) {
      int var3 = class185.method3463(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.field2178 == null?null:(null != var0.actions && var0.actions.length > var1 && null != var0.actions[var1] && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "([LWidget;IB)V",
      garbageValue = "-73"
   )
   static final void method191(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method191(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2405((long)var3.id);
               if(var4 != null) {
                  XItemContainer.method181(var4.id, var1);
               }
            }

            class18 var5;
            if(var1 == 0 && null != var3.field2176) {
               var5 = new class18();
               var5.field192 = var3;
               var5.field196 = var3.field2176;
               class164.method3225(var5, 200000);
            }

            if(var1 == 1 && var3.field2177 != null) {
               if(var3.index >= 0) {
                  Widget var6 = class5.method79(var3.id);
                  if(null == var6 || var6.children == null || var3.index >= var6.children.length || var6.children[var3.index] != var3) {
                     continue;
                  }
               }

               var5 = new class18();
               var5.field192 = var3;
               var5.field196 = var3.field2177;
               class164.method3225(var5, 200000);
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   public static void method192() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         ++class105.keyboardIdleTicks;
         class105.field1699 = class105.field1696;
         class105.field1716 = 0;
         int var1;
         if(class105.field1718 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class105.field1709[var1] = false;
            }

            class105.field1718 = class105.field1711;
         } else {
            while(class105.field1711 != class105.field1718) {
               var1 = class105.field1710[class105.field1711];
               class105.field1711 = 1 + class105.field1711 & 127;
               if(var1 < 0) {
                  class105.field1709[~var1] = false;
               } else {
                  if(!class105.field1709[var1] && class105.field1716 < class105.field1715.length - 1) {
                     class105.field1715[++class105.field1716 - 1] = var1;
                  }

                  class105.field1709[var1] = true;
               }
            }
         }

         class105.field1696 = class105.field1714;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;IB)V",
      garbageValue = "-112"
   )
   static void method193(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class31 var5 = new class31();
      var5.field705 = var0;
      var5.field710 = var1 * 128;
      var5.field699 = var2 * 128;
      int var6 = var3.field2903;
      int var7 = var3.field2907;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field2907;
         var7 = var3.field2903;
      }

      var5.field698 = (var6 + var1) * 128;
      var5.field695 = (var7 + var2) * 128;
      var5.field702 = var3.field2922;
      var5.field701 = var3.field2936 * 128;
      var5.field704 = var3.field2898;
      var5.field713 = var3.field2938;
      var5.field706 = var3.field2895;
      if(var3.impostorIds != null) {
         var5.field709 = var3;
         var5.method688();
      }

      class31.field697.method2454(var5);
      if(var5.field706 != null) {
         var5.field707 = var5.field704 + (int)(Math.random() * (double)(var5.field713 - var5.field704));
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1433563008"
   )
   static void method194(int var0) {
      Client.field498 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      ItemComposition.method3726();
      if(Client.gameState >= 25) {
         class34.method730();
      }

      GameEngine.field1780 = true;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1321909817"
   )
   static final void method195() {
      int[] var0 = class45.field902;

      int var1;
      for(var1 = 0; var1 < class45.field897; ++var1) {
         Player var4 = Client.cachedPlayers[var0[var1]];
         if(null != var4 && var4.field607 > 0) {
            --var4.field607;
            if(var4.field607 == 0) {
               var4.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field326; ++var1) {
         int var2 = Client.field559[var1];
         NPC var3 = Client.cachedNPCs[var2];
         if(null != var3 && var3.field607 > 0) {
            --var3.field607;
            if(var3.field607 == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-1407480586"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2902.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2912.method3329(6, var0);
         var1 = new ObjectComposition();
         var1.field2918 = var0;
         if(null != var2) {
            var1.method3654(new Buffer(var2));
         }

         var1.method3670();
         if(var1.field2930) {
            var1.field2908 = 0;
            var1.field2909 = false;
         }

         ObjectComposition.field2902.put(var1, (long)var0);
         return var1;
      }
   }
}
