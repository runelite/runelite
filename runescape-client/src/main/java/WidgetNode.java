import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("m")
   boolean field173 = false;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2068519717
   )
   int field174;
   @ObfuscatedName("ma")
   static byte field175;
   @ObfuscatedName("cp")
   static class110 field176;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1692064065
   )
   @Export("id")
   int id;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-749679557"
   )
   static final void method201(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = Client.field539 + (Client.field456 - Client.field539) * var5 / 100;
      int var7 = 512 * var3 * var6 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field545) {
         var15 = Client.field545;
         var6 = 334 * var15 * var2 / (var3 * 512);
         if(var6 > Client.field540) {
            var6 = Client.field540;
            var8 = 512 * var6 * var3 / (334 * var15);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class219.method4040();
               class219.method4071(var0, var1, var9, var3, -16777216);
               class219.method4071(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field546) {
         var15 = Client.field546;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 < Client.field543) {
            var6 = Client.field543;
            var8 = 334 * var2 * var15 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class219.method4040();
               class219.method4071(var0, var1, var2, var9, -16777216);
               class219.method4071(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field458 - Client.field541) * var5 / 100 + Client.field541;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 32 * var10 + 128 + 15;
            int var12 = 600 + 3 * var11;
            int var13 = class84.field1444[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method1775(var14, 500, 800, var2, var3);
      }

      Client.field547 = var0;
      Client.field523 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "2111051899"
   )
   static MessageNode method202(int var0) {
      return (MessageNode)class47.field925.method2378((long)var0);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-301585291"
   )
   static void method203() {
      int var0 = GameEngine.field1776;
      int var1 = GameEngine.field1783;
      int var2 = class166.field2322 - class16.field169 - var0;
      int var3 = class49.field953 - class65.field1103 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field281.method2156();
            int var5 = 0;
            int var6 = 0;
            if(var4 == MessageNode.field230) {
               Insets var7 = MessageNode.field230.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class49.field953);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class166.field2322, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class166.field2322 - var2, var6, var2, class49.field953);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class49.field953 - var3, class166.field2322, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }
}
