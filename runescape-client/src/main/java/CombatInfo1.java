import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1481785453
   )
   @Export("health")
   int health;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1731250797
   )
   int field666;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1896973849
   )
   int field668;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1062958427
   )
   @Export("healthRatio")
   int healthRatio;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "4"
   )
   void method643(int var1, int var2, int var3, int var4) {
      this.field668 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field666 = var4;
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field668 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field666 = var4;
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "1209258905"
   )
   static void method646(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class20.method210(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class20.method210(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2428((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class159.method3142(var6)) {
            class20.method210(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "228786306"
   )
   static final void method647(int var0) {
      if(class159.method3142(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3) {
               var3.field2318 = 0;
               var3.field2303 = 0;
            }
         }

      }
   }
}
