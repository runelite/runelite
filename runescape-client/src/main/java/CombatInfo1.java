import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1051473115
   )
   @Export("health")
   int health;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -345249683
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1042524761
   )
   int field689;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1829916919
   )
   int field690;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field689 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field690 = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1489917738"
   )
   void method623(int var1, int var2, int var3, int var4) {
      this.field689 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field690 = var4;
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-423303126"
   )
   static final void method625(String var0) {
      if(!var0.equals("")) {
         Client.field309.method3076(164);
         Client.field309.putByte(class164.method3157(var0));
         Client.field309.method2822(var0);
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "1439824084"
   )
   static final void method628(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(null != var3.children) {
                  method628(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2405((long)var3.id);
               if(null != var4) {
                  int var5 = var4.id;
                  if(class44.method892(var5)) {
                     method628(Widget.widgets[var5], var1);
                  }
               }
            }

            class18 var6;
            if(var1 == 0 && var3.field2293 != null) {
               var6 = new class18();
               var6.field223 = var3;
               var6.field232 = var3.field2293;
               Frames.method1963(var6);
            }

            if(var1 == 1 && null != var3.field2294) {
               if(var3.index >= 0) {
                  Widget var7 = World.method670(var3.id);
                  if(null == var7 || var7.children == null || var3.index >= var7.children.length || var7.children[var3.index] != var3) {
                     continue;
                  }
               }

               var6 = new class18();
               var6.field223 = var3;
               var6.field232 = var3.field2294;
               Frames.method1963(var6);
            }
         }
      }

   }
}
