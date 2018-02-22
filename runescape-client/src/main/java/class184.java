import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class184 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1955419386"
   )
   static void method3451() {
      class89.username = class89.username.trim();
      if(class89.username.length() == 0) {
         class194.method3794("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = ItemContainer.method1112();
         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var4 = class89.username;
            Random var5 = new Random();
            Buffer var6 = new Buffer(128);
            Buffer var7 = new Buffer(128);
            int[] var8 = new int[]{var5.nextInt(), var5.nextInt(), (int)(var1 >> 32), (int)var1};
            var6.putByte(10);

            int var9;
            for(var9 = 0; var9 < 4; ++var9) {
               var6.putInt(var5.nextInt());
            }

            var6.putInt(var8[0]);
            var6.putInt(var8[1]);
            var6.putLong(var1);
            var6.putLong(0L);

            for(var9 = 0; var9 < 4; ++var9) {
               var6.putInt(var5.nextInt());
            }

            var6.encryptRsa(class84.field1263, class84.field1258);
            var7.putByte(10);

            for(var9 = 0; var9 < 3; ++var9) {
               var7.putInt(var5.nextInt());
            }

            var7.putLong(var5.nextLong());
            var7.method3765(var5.nextLong());
            if(Client.field857 != null) {
               var7.putBytes(Client.field857, 0, Client.field857.length);
            } else {
               byte[] var18 = class155.method3154();
               var7.putBytes(var18, 0, var18.length);
            }

            var7.putLong(var5.nextLong());
            var7.encryptRsa(class84.field1263, class84.field1258);
            var9 = class43.getLength(var4);
            if(var9 % 8 != 0) {
               var9 += 8 - var9 % 8;
            }

            Buffer var10 = new Buffer(var9);
            var10.putString(var4);
            var10.offset = var9;
            var10.encryptXtea2(var8);
            Buffer var11 = new Buffer(var6.offset + var7.offset + var10.offset + 5);
            var11.putByte(2);
            var11.putByte(var6.offset);
            var11.putBytes(var6.payload, 0, var6.offset);
            var11.putByte(var7.offset);
            var11.putBytes(var7.payload, 0, var7.offset);
            var11.putShort(var10.offset);
            var11.putBytes(var10.payload, 0, var10.offset);
            String var12 = class92.method1936(var11.payload);

            byte var3;
            try {
               URL var13 = new URL(ScriptEvent.method1136("services", false) + "m=accountappeal/login.ws");
               URLConnection var14 = var13.openConnection();
               var14.setDoInput(true);
               var14.setDoOutput(true);
               var14.setConnectTimeout(5000);
               OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
               var15.write("data2=" + class176.method3426(var12) + "&dest=" + class176.method3426("passwordchoice.ws"));
               var15.flush();
               InputStream var16 = var14.getInputStream();
               var11 = new Buffer(new byte[1000]);

               while(true) {
                  int var17 = var16.read(var11.payload, var11.offset, 1000 - var11.offset);
                  if(var17 == -1) {
                     var15.close();
                     var16.close();
                     String var19 = new String(var11.payload);
                     if(var19.startsWith("OFFLINE")) {
                        var3 = 4;
                     } else if(var19.startsWith("WRONG")) {
                        var3 = 7;
                     } else if(var19.startsWith("RELOAD")) {
                        var3 = 3;
                     } else if(var19.startsWith("Not permitted for social network accounts.")) {
                        var3 = 6;
                     } else {
                        var11.decryptXtea(var8);

                        while(var11.offset > 0 && var11.payload[var11.offset - 1] == 0) {
                           --var11.offset;
                        }

                        var19 = new String(var11.payload, 0, var11.offset);
                        if(MouseInput.method1046(var19)) {
                           class176.method3424(var19, true, false);
                           var3 = 2;
                        } else {
                           var3 = 5;
                        }
                     }
                     break;
                  }

                  var11.offset += var17;
                  if(var11.offset >= 1000) {
                     var3 = 5;
                     break;
                  }
               }
            } catch (Throwable var20) {
               var20.printStackTrace();
               var3 = 5;
            }

            var0 = var3;
         }

         switch(var0) {
         case 2:
            class194.method3794("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class89.loginIndex = 6;
            break;
         case 3:
            class194.method3794("", "Error connecting to server.", "");
            break;
         case 4:
            class194.method3794("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class194.method3794("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class194.method3794("", "Error connecting to server.", "");
            break;
         case 7:
            class194.method3794("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1275611543"
   )
   public static void method3454() {
      ObjectComposition.objects.reset();
      ObjectComposition.field3520.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3522.reset();
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1029315535"
   )
   static final void method3455() {
      Overlay.overlays.reset();
      FloorUnderlayDefinition.underlays.reset();
      UrlRequest.method3093();
      method3454();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      Widget.method4468();
      GameSocket.method3378();
      Varbit.varbits.reset();
      class40.method563();
      Timer.method3308();
      CombatInfo2.field3455.reset();
      CombatInfo2.spriteCache.reset();
      class272.field3480.reset();
      class271.field3474.reset();
      FaceNormal.method3052();
      PlayerComposition.field2754.reset();
      ClientPacket.method3433();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1406.reset();
      Client.indexInterfaces.reset();
      class155.indexSoundEffects.reset();
      GameCanvas.indexCache3.reset();
      class54.indexCache4.reset();
      Script.indexMaps.reset();
      class155.indexTrack1.reset();
      DynamicObject.indexModels.reset();
      MessageNode.indexSprites.reset();
      class63.indexTextures.reset();
      class85.indexCache10.reset();
      GrandExchangeOffer.indexTrack2.reset();
      class80.indexScripts.reset();
   }
}
