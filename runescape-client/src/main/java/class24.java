import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public final class class24 extends Node {
   @ObfuscatedName("u")
   class67 field601;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1248933693
   )
   int field603;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1580707209
   )
   int field604;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -368352729
   )
   int field605;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2118523539
   )
   int field606;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1049553037
   )
   int field607;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1429344523
   )
   int field608;
   @ObfuscatedName("k")
   static Deque field609 = new Deque();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1780362941
   )
   int field610;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1837044459
   )
   int field611;
   @ObfuscatedName("b")
   int[] field612;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1172052775
   )
   int field613;
   @ObfuscatedName("e")
   class67 field614;
   @ObfuscatedName("p")
   ObjectComposition field615;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -962674229
   )
   int field616;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-15021"
   )
   void method598() {
      int var1 = this.field608;
      ObjectComposition var2 = this.field615.getImpostor();
      if(var2 != null) {
         this.field608 = var2.field979;
         this.field606 = var2.field980 * 128;
         this.field610 = var2.field981;
         this.field611 = var2.field943;
         this.field612 = var2.field983;
      } else {
         this.field608 = -1;
         this.field606 = 0;
         this.field610 = 0;
         this.field611 = 0;
         this.field612 = null;
      }

      if(this.field608 != var1 && this.field601 != null) {
         class112.field1970.method1177(this.field601);
         this.field601 = null;
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "556397097"
   )
   static final void method600() {
      for(class31 var0 = (class31)Client.field415.method3864(); var0 != null; var0 = (class31)Client.field415.method3851()) {
         if(var0.field707 == class145.plane && !var0.field714) {
            if(Client.gameCycle >= var0.field706) {
               var0.method680(Client.field357);
               if(var0.field714) {
                  var0.unlink();
               } else {
                  Frames.region.method1972(var0.field707, var0.field718, var0.field712, var0.field710, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-14892537"
   )
   static final void method602(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3 && var1 == var3.parentId && (!var3.field2815 || !class5.method56(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.field2815 && class5.method56(var3) && var3 != Player.field31) {
                  continue;
               }

               method602(var0, var3.id);
               if(var3.children != null) {
                  method602(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3828((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(class85.method1938(var5)) {
                     method602(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2845 != -1 || var3.field2846 != -1) {
                  boolean var7 = Player.method30(var3);
                  if(var7) {
                     var5 = var3.field2846;
                  } else {
                     var5 = var3.field2845;
                  }

                  if(var5 != -1) {
                     Sequence var6 = NPC.getAnimation(var5);

                     for(var3.field2873 += Client.field357; var3.field2873 > var6.field1008[var3.field2920]; class166.method3253(var3)) {
                        var3.field2873 -= var6.field1008[var3.field2920];
                        ++var3.field2920;
                        if(var3.field2920 >= var6.field1006.length) {
                           var3.field2920 -= var6.field1010;
                           if(var3.field2920 < 0 || var3.field2920 >= var6.field1006.length) {
                              var3.field2920 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2874 != 0 && !var3.field2815) {
                  int var8 = var3.field2874 >> 16;
                  var5 = var3.field2874 << 16 >> 16;
                  var8 *= Client.field357;
                  var5 *= Client.field357;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class166.method3253(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1444056068"
   )
   static final boolean method603(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
