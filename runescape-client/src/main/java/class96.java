import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
final class class96 implements Comparator {
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1336382059
   )
   static int field1501;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   class96(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lr;Lr;I)I",
      garbageValue = "1092665140"
   )
   int method1781(class14 var1, class14 var2) {
      if(var2.field293 == var1.field293) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field293) {
               return -1;
            }

            if(var2.field293 == Client.world) {
               return 1;
            }
         }

         return var1.field293 < var2.field293?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1781((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "-1926562015"
   )
   static String method1790(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class153) {
         class153 var2 = (class153)var0;
         var1 = var2.field2217 + " | ";
         var0 = var2.field2218;
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2044834327"
   )
   public static boolean method1784(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
