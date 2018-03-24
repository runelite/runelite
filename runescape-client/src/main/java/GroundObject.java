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

@ObfuscatedName("dz")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2046876731
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1589792585
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -114277663
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 219425471
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1940716223
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "643160643"
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
                  var5 = var6.field2153 + " | ";
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

               label62:
               while(true) {
                  while(true) {
                     String var11 = var9.readLine();
                     if(var11 == null) {
                        var5 = var5 + "| " + var10;
                        var2 = var5;
                        break label62;
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
            if(RunException.field2154 == null) {
               return;
            }

            URL var3 = new URL(RunException.field2154.getCodeBase(), "clienterror.ws?c=" + class303.revision + "&u=" + class61.field699 + "&v1=" + Signlink.javaVendor + "&v2=" + Signlink.javaVersion + "&e=" + var2);
            DataInputStream var17 = new DataInputStream(var3.openStream());
            var17.read();
            var17.close();
         } catch (Exception var16) {
            ;
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "804754558"
   )
   static void method2672() {
      class90.username = class90.username.trim();
      if(class90.username.length() == 0) {
         class93.method1974("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = BoundingBox3DDrawMode.method58();
         int var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            var0 = Actor.method1650(var1, class90.username);
         }

         switch(var0) {
         case 2:
            class93.method1974("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class90.loginIndex = 6;
            break;
         case 3:
            class93.method1974("", "Error connecting to server.", "");
            break;
         case 4:
            class93.method1974("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class93.method1974("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class93.method1974("", "Error connecting to server.", "");
            break;
         case 7:
            class93.method1974("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
