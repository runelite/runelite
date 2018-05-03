import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("varplayer_ref")
   static IndexDataBase varplayer_ref;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2005161095
   )
   public static int field3446;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("varplayers")
   static NodeCache varplayers;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1520269613
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "-1790088234"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.decode(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-636351580"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjr;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-1291509997"
   )
   public static void method4853(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.getFile(var2);
      int var7 = var1.getChild(var6, var3);
      ISAACCipher.method3902(var0, var1, var6, var7, var4, var5);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1700355006"
   )
   static void method4848() {
      class90.username = class90.username.trim();
      if(class90.username.length() == 0) {
         VerticalAlignment.method4829("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(IndexData.method4789("services", false) + "m=accountappeal/login.ws");
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
                  long var10 = var7.readLong();
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
         if(var1 == 0L) {
            var0 = 5;
         } else {
            var0 = class57.method879(var1, class90.username);
         }

         switch(var0) {
         case 2:
            VerticalAlignment.method4829("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class90.loginIndex = 6;
            break;
         case 3:
            VerticalAlignment.method4829("", "Error connecting to server.", "");
            break;
         case 4:
            VerticalAlignment.method4829("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            VerticalAlignment.method4829("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            VerticalAlignment.method4829("", "Error connecting to server.", "");
            break;
         case 7:
            VerticalAlignment.method4829("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
