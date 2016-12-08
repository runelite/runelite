import java.awt.FontMetrics;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1979470569
   )
   @Export("z")
   int z;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1429359223
   )
   @Export("y")
   int y;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 118590673
   )
   @Export("x")
   int x;
   @ObfuscatedName("nc")
   static class51 field1554;
   @ObfuscatedName("bf")
   static FontMetrics field1555;
   @ObfuscatedName("v")
   public static int[] field1557;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-2108641679"
   )
   public static void method1844(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(var1 != null) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class101) {
               class101 var6 = (class101)var1;
               var5 = var6.field1647 + " | ";
               var4 = var6.field1648;
            } else {
               var5 = "";
            }

            StringWriter var18 = new StringWriter();
            PrintWriter var7 = new PrintWriter(var18);
            var4.printStackTrace(var7);
            var7.close();
            String var8 = var18.toString();
            BufferedReader var9 = new BufferedReader(new StringReader(var8));
            String var10 = var9.readLine();

            while(true) {
               String var11 = var9.readLine();
               if(null == var11) {
                  var5 = var5 + "| " + var10;
                  var2 = var5;
                  break;
               }

               int var12 = var11.indexOf(40);
               int var13 = var11.indexOf(41, var12 + 1);
               if(var12 >= 0 && var13 >= 0) {
                  String var14 = var11.substring(var12 + 1, var13);
                  int var15 = var14.indexOf(".java:");
                  if(var15 >= 0) {
                     var14 = var14.substring(0, var15) + var14.substring(5 + var15);
                     var5 = var5 + var14 + ' ';
                     continue;
                  }

                  var11 = var11.substring(0, var12);
               }

               var11 = var11.trim();
               var11 = var11.substring(var11.lastIndexOf(32) + 1);
               var11 = var11.substring(var11.lastIndexOf(9) + 1);
               var5 = var5 + var11 + ' ';
            }
         }

         if(var0 != null) {
            if(null != var1) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(class101.field1653 == null) {
            return;
         }

         URL var3 = new URL(class101.field1653.getCodeBase(), "clienterror.ws?c=" + class101.field1646 + "&u=" + class101.field1649 + "&v1=" + class103.field1678 + "&v2=" + class103.field1666 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "-1347975005"
   )
   static final void method1845(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class84.field1435[var6];
            int var9 = class84.field1446[var6];
            var8 = var8 * 256 / (256 + Client.mapScaleDelta);
            var9 = var9 * 256 / (256 + Client.mapScaleDelta);
            int var10 = var2 * var9 + var8 * var3 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method4058(var5.field2164 / 2 + var10 - var4.field3208 / 2, var5.field2165 / 2 - var11 - var4.field3209 / 2, var0, var1, var5.field2164, var5.field2165, var5.field2162, var5.field2168);
            } else {
               var4.method4048(var10 + var5.field2164 / 2 + var0 - var4.field3208 / 2, var5.field2165 / 2 + var1 - var11 - var4.field3209 / 2);
            }

         }
      }
   }
}
