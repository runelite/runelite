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

@ObfuscatedName("dr")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("i")
   static int[] field1832;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 343387521
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("f")
   Frame[] field1834;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "467765835"
   )
   public boolean method2313(int var1) {
      return this.field1834[var1].field1595;
   }

   Frames(class170 var1, class170 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3321(var3);
      this.field1834 = new Frame[var6];
      int[] var7 = var1.method3311(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3304(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3890(); null != var12; var12 = (FrameMap)var5.method3892()) {
            if(var11 == var12.field1830) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3292(0, var11);
            } else {
               var13 = var2.method3292(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method3886(var10);
         }

         this.field1834[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)LModIcon;",
      garbageValue = "1367671420"
   )
   static ModIcon method2315(class170 var0, int var1, int var2) {
      byte[] var4 = var0.method3304(var1, var2);
      boolean var3;
      if(null == var4) {
         var3 = false;
      } else {
         class13.method154(var4);
         var3 = true;
      }

      return !var3?null:FrameMap.method2312();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-713466702"
   )
   public static void method2316(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class151) {
               class151 var6 = (class151)var1;
               var5 = var6.field2270 + " | ";
               var4 = var6.field2271;
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
               if(var11 == null) {
                  var5 = var5 + "| " + var10;
                  var2 = var5;
                  break;
               }

               int var12 = var11.indexOf(40);
               int var13 = var11.indexOf(41, var12 + 1);
               if(var12 >= 0 && var13 >= 0) {
                  String var14 = var11.substring(1 + var12, var13);
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
            if(var1 != null) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(class151.field2268 == null) {
            return;
         }

         URL var3 = new URL(class151.field2268.getCodeBase(), "clienterror.ws?c=" + class151.field2269 + "&u=" + class127.field2089 + "&v1=" + class139.field2146 + "&v2=" + class139.field2140 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }
}
