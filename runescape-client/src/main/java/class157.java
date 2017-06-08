import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class157 {
   @ObfuscatedName("g")
   static int[] field2263;
   @ObfuscatedName("i")
   static Hashtable field2265;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -1270230725
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("p")
   static File field2268;
   @ObfuscatedName("n")
   static boolean field2270;

   static {
      field2270 = false;
      field2265 = new Hashtable(16);
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1936164056"
   )
   static final void method2976(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = WidgetNode.field817.method4794(var0, 250);
      int var6 = WidgetNode.field817.method4783(var0, 250) * 13;
      Rasterizer2D.method5040(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 0);
      Rasterizer2D.method4976(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 16777215);
      WidgetNode.field817.method4792(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class69.method1078(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
      if(var1) {
         class47.field601.vmethod5052(0, 0);
      } else {
         int var7 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field1119; ++var11) {
            if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var7 && Client.widgetPositionX[var11] < var9 + var7 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var8 + var10) {
               Client.field1122[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)Z",
      garbageValue = "10242"
   )
   public static boolean method2977(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label87: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label87;
               }

               if(var7 == 43) {
                  break label87;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var4 * 10 + var9;
            if(var8 / 10 != var4) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }
}
