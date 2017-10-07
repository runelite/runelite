import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class39 {
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = 139502535
   )
   static int field546;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -135434815
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("ng")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static class277 field551;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   final class33 field556;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 170615207
   )
   public final int field552;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1257267345
   )
   int field555;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   public final Coordinates field548;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   public final Coordinates field547;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2088966667
   )
   final int field549;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1955312783
   )
   int field553;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1634170089
   )
   final int field550;

   @ObfuscatedSignature(
      signature = "(ILhl;Lhl;Laf;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field552 = var1;
      this.field548 = var2;
      this.field547 = var3;
      this.field556 = var4;
      Area var5 = class3.field24[this.field552];
      SpritePixels var6 = var5.method4395(false);
      if(var6 != null) {
         this.field549 = var6.width;
         this.field550 = var6.height;
      } else {
         this.field549 = 0;
         this.field550 = 0;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "20"
   )
   boolean method531(int var1, int var2) {
      Area var3 = class3.field24[this.field552];
      switch(var3.field3289.field3547) {
      case 0:
         if(var1 > this.field555 - this.field549 && var1 <= this.field555) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field555 - this.field549 / 2 && var1 <= this.field549 / 2 + this.field555) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field555 || var1 >= this.field549 + this.field555) {
            return false;
         }
      }

      switch(var3.field3305.field3275) {
      case 0:
         if(var2 >= this.field553 - this.field550 / 2 && var2 <= this.field550 / 2 + this.field553) {
            break;
         }

         return false;
      case 1:
         if(var2 <= this.field553 - this.field550 || var2 > this.field553) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field553 || var2 >= this.field550 + this.field553) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   boolean method529(int var1, int var2) {
      return this.field556 == null?false:(var1 >= this.field555 - this.field556.field487 / 2 && var1 <= this.field556.field487 / 2 + this.field555?var2 >= this.field553 && var2 <= this.field556.field484 + this.field553:false);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "769789679"
   )
   boolean method530(int var1, int var2) {
      return this.method531(var1, var2)?true:this.method529(var1, var2);
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "([Lhj;II)V",
      garbageValue = "1206539122"
   )
   static final void method537(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !Script.method1926(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && Script.method1926(var3) && var3 != class27.field403) {
                  continue;
               }

               method537(var0, var3.id);
               if(var3.children != null) {
                  method537(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(class93.loadWidget(var5)) {
                     method537(class177.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2649 != -1 || var3.field2706 != -1) {
                  boolean var7 = ItemContainer.method1129(var3);
                  if(var7) {
                     var5 = var3.field2706;
                  } else {
                     var5 = var3.field2649;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class204.getAnimation(var5);

                     for(var3.field2781 += Client.field1122; var3.field2781 > var6.frameLenghts[var3.field2776]; class25.method172(var3)) {
                        var3.field2781 -= var6.frameLenghts[var3.field2776];
                        ++var3.field2776;
                        if(var3.field2776 >= var6.frameIDs.length) {
                           var3.field2776 -= var6.frameStep;
                           if(var3.field2776 < 0 || var3.field2776 >= var6.frameIDs.length) {
                              var3.field2776 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2714 != 0 && !var3.hasScript) {
                  int var8 = var3.field2714 >> 16;
                  var5 = var3.field2714 << 16 >> 16;
                  var8 *= Client.field1122;
                  var5 *= Client.field1122;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class25.method172(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public static boolean method538(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
