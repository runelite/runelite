import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public class class253 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1998659586"
   )
   @Export("processClientError")
   public static void processClientError(String var0, Throwable var1) {
      if(var1 != null) {
         var1.printStackTrace();
      } else {
         try {
            String var2 = "";
            if(var1 != null) {
               Throwable var4 = var1;
               String var5;
               if(var1 instanceof RunException) {
                  RunException var6 = (RunException)var1;
                  var5 = var6.field2171 + " | ";
                  var4 = var6.parent;
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

               label61:
               while(true) {
                  while(true) {
                     String var11 = var9.readLine();
                     if(var11 == null) {
                        var5 = var5 + "| " + var10;
                        var2 = var5;
                        break label61;
                     }

                     int var12 = var11.indexOf(40);
                     int var13 = var11.indexOf(41, var12 + 1);
                     if(var12 >= 0 && var13 >= 0) {
                        String var14 = var11.substring(var12 + 1, var13);
                        int var15 = var14.indexOf(".java:");
                        if(var15 >= 0) {
                           var14 = var14.substring(0, var15) + var14.substring(var15 + 5);
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
            if(RunException.field2168 == null) {
               return;
            }

            URL var3 = new URL(RunException.field2168.getCodeBase(), "clienterror.ws?c=" + class152.revision + "&u=" + RunException.field2169 + "&v1=" + Signlink.javaVendor + "&v2=" + Signlink.javaVersion + "&ct=" + RunException.field2170 + "&e=" + var2);
            DataInputStream var17 = new DataInputStream(var3.openStream());
            var17.read();
            var17.close();
         } catch (Exception var16) {
            ;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;Ljr;B)V",
      garbageValue = "-45"
   )
   public static void method4620(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      Sequence.seq_ref = var0;
      Sequence.skel_ref = var1;
      Sequence.skin_ref = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljh;",
      garbageValue = "396795345"
   )
   public static class278 method4619(int var0) {
      class278 var1 = (class278)class278.field3545.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class278.field3549.getConfigData(11, var0);
         var1 = new class278();
         if(var2 != null) {
            var1.method4991(new Buffer(var2));
         }

         var1.method4990();
         class278.field3545.put(var1, (long)var0);
         return var1;
      }
   }
}
