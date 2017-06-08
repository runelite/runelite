import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class13 {
   @ObfuscatedName("p")
   public static Comparator field278;
   @ObfuscatedName("i")
   public static Comparator field279;
   @ObfuscatedName("j")
   public static Comparator field280;
   @ObfuscatedName("bc")
   static class289 field281;
   @ObfuscatedName("f")
   public static Comparator field283;
   @ObfuscatedName("n")
   public final List field284;

   static {
      field278 = new class19();
      new class12();
      field279 = new class17();
      field280 = new class18();
      field283 = new class15();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "222435924"
   )
   public void method85(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field284, var1);
      } else {
         Collections.sort(this.field284, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field284 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field284.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "346270808"
   )
   static final void method87(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field1068 != 0 || Client.field1071) {
         int var2 = Script.method1824();
         String var3;
         if(Client.field1068 == 1 && Client.menuOptionCount < 2) {
            var3 = "Use" + " " + Client.field988 + " " + "->";
         } else if(Client.field1071 && Client.menuOptionCount < 2) {
            var3 = Client.field1074 + " " + Client.field1075 + " " + "->";
         } else {
            var3 = class87.method1682(var2);
         }

         if(Client.menuOptionCount > 2) {
            var3 = var3 + class60.method996(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class241.field3288.method4793(var3, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1318414070"
   )
   public static int method88(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-155950589"
   )
   public static int method89(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-1829986223"
   )
   static final void method90(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !Ignore.method1079(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && Ignore.method1079(var3) && var3 != class83.field1354) {
                  continue;
               }

               method90(var0, var3.id);
               if(var3.children != null) {
                  method90(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3545((long)var3.id);
               if(var4 != null) {
                  XClanMember.method1125(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2699 != -1 || var3.field2666 != -1) {
                  boolean var7 = WorldMapType2.method512(var3);
                  if(var7) {
                     var5 = var3.field2666;
                  } else {
                     var5 = var3.field2699;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class169.getAnimation(var5);

                     for(var3.field2662 += Client.field990; var3.field2662 > var6.frameLenghts[var3.field2774]; CombatInfo1.method1515(var3)) {
                        var3.field2662 -= var6.frameLenghts[var3.field2774];
                        ++var3.field2774;
                        if(var3.field2774 >= var6.frameIDs.length) {
                           var3.field2774 -= var6.frameStep;
                           if(var3.field2774 < 0 || var3.field2774 >= var6.frameIDs.length) {
                              var3.field2774 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2708 != 0 && !var3.hasScript) {
                  int var8 = var3.field2708 >> 16;
                  var5 = var3.field2708 << 16 >> 16;
                  var8 *= Client.field990;
                  var5 *= Client.field990;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var3.rotationZ + var5 & 2047;
                  CombatInfo1.method1515(var3);
               }
            }
         }
      }

   }
}
