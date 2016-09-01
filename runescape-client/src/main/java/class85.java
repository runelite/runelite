import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class85 implements class115 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -595047605
   )
   final int field1463;
   @ObfuscatedName("r")
   static final class85 field1464 = new class85(1, 1);
   @ObfuscatedName("t")
   public static class175 field1465;
   @ObfuscatedName("z")
   static final class85 field1466 = new class85(3, 3);
   @ObfuscatedName("i")
   static final class85 field1467 = new class85(4, 4);
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1774389561
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("j")
   static final class85 field1469 = new class85(2, 2);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2088490343
   )
   public final int field1472;
   @ObfuscatedName("x")
   public static final class85 field1474 = new class85(0, 0);
   @ObfuscatedName("n")
   static class13 field1475;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1074689381"
   )
   public int vmethod3206() {
      return this.field1463;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "1590533716"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method593() != Client.isMembers) {
         Client.isMembers = var0.method593();
         class143.method3023(var0.method593());
      }

      class59.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      NPCComposition.field920 = Client.field560 == 0?'ꩊ':var0.id + '鱀';
      class14.field207 = Client.field560 == 0?443:'썐' + var0.id;
      Client.field317 = NPCComposition.field920;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class85(int var1, int var2) {
      this.field1472 = var1;
      this.field1463 = var2;
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "2019822924"
   )
   static final void method1924(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var1 == var3.parentId && (!var3.field2809 || !class34.method712(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.field2809 && class34.method712(var3) && ItemComposition.field1180 != var3) {
                  continue;
               }

               method1924(var0, var3.id);
               if(null != var3.children) {
                  method1924(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3830((long)var3.id);
               if(null != var4) {
                  var5 = var4.id;
                  if(class175.method3419(var5)) {
                     method1924(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2857 != -1 || var3.field2821 != -1) {
                  boolean var7 = class45.method921(var3);
                  if(var7) {
                     var5 = var3.field2821;
                  } else {
                     var5 = var3.field2857;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class113.getAnimation(var5);

                     for(var3.field2945 += Client.field329; var3.field2945 > var6.field999[var3.field2932]; class75.method1606(var3)) {
                        var3.field2945 -= var6.field999[var3.field2932];
                        ++var3.field2932;
                        if(var3.field2932 >= var6.field1001.length) {
                           var3.field2932 -= var6.field1002;
                           if(var3.field2932 < 0 || var3.field2932 >= var6.field1001.length) {
                              var3.field2932 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2866 != 0 && !var3.field2809) {
                  int var8 = var3.field2866 >> 16;
                  var5 = var3.field2866 << 16 >> 16;
                  var8 *= Client.field329;
                  var5 *= Client.field329;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class75.method1606(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZS)I",
      garbageValue = "-11749"
   )
   static int method1925(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method595()?(var1.method595()?0:1):(var1.method595()?-1:0)):(var2 == 5?(var0.method617()?(var1.method617()?0:1):(var1.method617()?-1:0)):(var2 == 6?(var0.method594()?(var1.method594()?0:1):(var1.method594()?-1:0)):(var2 == 7?(var0.method593()?(var1.method593()?0:1):(var1.method593()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "4970"
   )
   static void method1926() {
      if(Client.field404) {
         Widget var0 = class166.method3265(XClanMember.field626, Client.field482);
         if(null != var0 && var0.field2902 != null) {
            class0 var1 = new class0();
            var1.field7 = var0;
            var1.field8 = var0.field2902;
            class158.method3201(var1, 200000);
         }

         Client.field404 = false;
         class75.method1606(var0);
      }
   }
}
