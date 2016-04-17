import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class38 extends class207 {
   @ObfuscatedName("d")
   short field879;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 299973189
   )
   int field880 = (int)(class127.method2941() / 1000L);
   @ObfuscatedName("w")
   String field882;
   @ObfuscatedName("bm")
   static class168 field884;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "1854064445"
   )
   static String method851(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class148) {
         class148 var2 = (class148)var0;
         var1 = var2.field2225 + " | ";
         var0 = var2.field2219;
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
               String var10 = var7.substring(1 + var8, var9);
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

   class38(String var1, int var2) {
      this.field882 = var1;
      this.field879 = (short)var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1365321142"
   )
   public static int method852(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "1768372826"
   )
   static final void method853(String var0, int var1) {
      client.field338.method2873(114);
      client.field338.method2603(class104.method2383(var0) + 1);
      client.field338.method2694(var0);
      client.field338.method2638(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-17"
   )
   public static void method854(boolean var0) {
      if(null != class171.field2717) {
         try {
            class119 var1 = new class119(4);
            var1.method2603(var0?2:3);
            var1.method2675(0);
            class171.field2717.method3100(var1.field1993, 0, 4);
         } catch (IOException var4) {
            try {
               class171.field2717.method3095();
            } catch (Exception var3) {
               ;
            }

            ++class171.field2733;
            class171.field2717 = null;
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-528337584"
   )
   public static boolean method855() {
      class210 var0 = (class210)class211.field3138.method3950();
      return null != var0;
   }
}
