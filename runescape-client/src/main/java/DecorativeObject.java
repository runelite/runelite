import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -983047051
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2018909997
   )
   @Export("x")
   int x;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1433917057
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1235439931
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1642298511
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1306369651
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("c")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("i")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1791630381
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 85667939
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -196038647
   )
   @Export("offsetX")
   int offsetX;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-99"
   )
   static void method1980() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         class138.method2536("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(Item.method876("services", false) + "m=accountappeal/login.ws");
            URLConnection var4 = var3.openConnection();
            var4.setRequestProperty("connection", "close");
            var4.setDoInput(true);
            var4.setDoOutput(true);
            var4.setConnectTimeout(5000);
            OutputStreamWriter var5 = new OutputStreamWriter(var4.getOutputStream());
            var5.write("data1=req");
            var5.flush();
            InputStream var6 = var4.getInputStream();
            Buffer var7 = new Buffer(new byte[1000]);

            while(true) {
               int var8 = var6.read(var7.payload, var7.offset, 1000 - var7.offset);
               if(var8 == -1) {
                  var7.offset = 0;
                  long var10 = var7.method2819();
                  var1 = var10;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var14) {
            var1 = 0L;
         }

         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = class0.method10(var1, class41.username);
         }

         switch(var0) {
         case 2:
            class138.method2536("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            class138.method2536("", "Error connecting to server.", "");
            break;
         case 4:
            class138.method2536("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class138.method2536("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class138.method2536("", "Error connecting to server.", "");
            break;
         case 7:
            class138.method2536("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
