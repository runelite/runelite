import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public final class class137 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1492151921
   )
   int field2045;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 256073115
   )
   int field2046;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 345961737
   )
   int field2047;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1086444817
   )
   int field2048;
   @ObfuscatedName("m")
   boolean field2049;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -116004415
   )
   int field2050;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -454422451
   )
   int field2051;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -1295095745
   )
   static int field2052;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "-128367635"
   )
   static String method2670(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class152) {
         class152 var2 = (class152)var0;
         var1 = var2.field2228 + " | ";
         var0 = var2.field2230;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class137(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field2049 = true;
      this.field2050 = var1;
      this.field2045 = var2;
      this.field2046 = var3;
      this.field2047 = var4;
      this.field2048 = var5;
      this.field2051 = var6;
      this.field2049 = var7;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1557767529"
   )
   static final void method2671(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class28.method251(var7, var9, var8, var10, -49088);
   }
}
