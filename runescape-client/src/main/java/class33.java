import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class33 {
   @ObfuscatedName("u")
   static final class33 field772 = new class33();
   @ObfuscatedName("x")
   static final class33 field773 = new class33();
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 1640747829
   )
   @Export("menuHeight")
   static int field774;
   @ObfuscatedName("b")
   static final class33 field776 = new class33();
   @ObfuscatedName("aw")
   static class146 field777;
   @ObfuscatedName("f")
   static final class33 field781 = new class33();

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "15865"
   )
   static final void method746() {
      int[] var0 = class32.field761;

      int var1;
      for(var1 = 0; var1 < class32.field753; ++var1) {
         class2 var2 = client.field302[var0[var1]];
         if(var2 != null && var2.field882 > 0) {
            --var2.field882;
            if(var2.field882 == 0) {
               var2.field824 = null;
            }
         }
      }

      for(var1 = 0; var1 < client.field494; ++var1) {
         int var4 = client.field330[var1];
         class34 var3 = client.field328[var4];
         if(var3 != null && var3.field882 > 0) {
            --var3.field882;
            if(var3.field882 == 0) {
               var3.field824 = null;
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "417668467"
   )
   static final void method747(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class36.field814.method4045(var0, 250);
      int var6 = class36.field814.method4046(var0, 250) * 13;
      class79.method1854(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 0);
      class79.method1860(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      class36.field814.method4051(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class26.method672(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
      if(var1) {
         try {
            Graphics var7 = class89.field1567.getGraphics();
            class12.field196.vmethod1939(var7, 0, 0);
         } catch (Exception var13) {
            class89.field1567.repaint();
         }
      } else {
         int var12 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < client.field490; ++var11) {
            if(client.field497[var11] + client.field495[var11] > var12 && client.field495[var11] < var12 + var9 && client.field496[var11] + client.field498[var11] > var8 && client.field496[var11] < var10 + var8) {
               client.field493[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIBB)V",
      garbageValue = "67"
   )
   static final void method748(class2 var0, int var1, int var2, byte var3) {
      int var4 = var0.field875[0];
      int var5 = var0.field876[0];
      int var6 = var0.method16();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var7 = class59.method1322(var4, var5, var0.method16(), class28.method698(var1, var2), client.field350[var0.field35], true, client.field321, client.field569);
            if(var7 >= 1) {
               for(int var8 = 0; var8 < var7 - 1; ++var8) {
                  var0.method30(client.field321[var8], client.field569[var8], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "509178242"
   )
   public static void method749() {
      class76.field1397 = null;
      class52.field1178 = null;
      class28.field690 = null;
      class31.field744 = null;
      class7.field135 = null;
      class76.field1400 = (byte[][])null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass42;IIII)V",
      garbageValue = "-1839318237"
   )
   static void method750(class42 var0, int var1, int var2, int var3) {
      if(client.field554 < 50 && client.field349 != 0) {
         if(var0.field1005 != null && var1 < var0.field1005.length) {
            int var4 = var0.field1005[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field531[client.field554] = var5;
               client.field532[client.field554] = var6;
               client.field533[client.field554] = 0;
               client.field392[client.field554] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field521[client.field554] = (var8 << 16) + (var9 << 8) + var7;
               ++client.field554;
            }
         }
      }
   }
}
