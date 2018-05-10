import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class59 extends class166 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   static class98 field557;
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("urlRequester")
   static UrlRequester urlRequester;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 1955230301
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -2137417073
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILfm;I)Z",
      garbageValue = "1081805803"
   )
   public boolean vmethod3457(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2066 && var3 == super.field2067;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Ljj;",
      garbageValue = "324953864"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_indexCache.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "225778137"
   )
   static void method1126() {
      for(class68 var0 = (class68)class68.field1002.getFront(); var0 != null; var0 = (class68)class68.field1002.getNext()) {
         if(var0.field1006 != null) {
            class141.field1906.method2050(var0.field1006);
            var0.field1006 = null;
         }

         if(var0.field1010 != null) {
            class141.field1906.method2050(var0.field1010);
            var0.field1010 = null;
         }
      }

      class68.field1002.clear();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;B)Ljava/lang/String;",
      garbageValue = "-72"
   )
   public static String method1128(Buffer var0) {
      String var1;
      try {
         int var2 = var0.getUSmart();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class300.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class165.getString(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "109337396"
   )
   public static void method1120(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "269419072"
   )
   public static int method1122(int var0) {
      long var2 = class120.field1688[var0];
      int var1 = (int)(var2 >>> 14 & 3L);
      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1851845520"
   )
   public static void method1130() {
      Overlay.overlays.reset();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIZII)J",
      garbageValue = "-1211445183"
   )
   public static long method1129(int var0, int var1, int var2, boolean var3, int var4) {
      long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
      if(var3) {
         var5 |= 65536L;
      }

      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-27"
   )
   static void method1124() {
      class78.username = class78.username.trim();
      if(class78.username.length() == 0) {
         Resampler.method2307("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(CacheFile.method2551("services", false) + "m=accountappeal/login.ws");
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
                  long var22 = var7.readLong();
                  var1 = var22;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var32) {
            var1 = 0L;
         }

         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var33 = class78.username;
            Random var34 = new Random();
            Buffer var26 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var34.nextInt(), var34.nextInt(), (int)(var1 >> 32), (int)var1};
            var26.putByte(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var26.putInt(var34.nextInt());
            }

            var26.putInt(var10[0]);
            var26.putInt(var10[1]);
            var26.putLong(var1);
            var26.putLong(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var26.putInt(var34.nextInt());
            }

            var26.encryptRsa(class73.field1062, class73.field1060);
            var9.putByte(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.putInt(var34.nextInt());
            }

            var9.putLong(var34.nextLong());
            var9.method3646(var34.nextLong());
            if(Client.field718 != null) {
               var9.putBytes(Client.field718, 0, Client.field718.length);
            } else {
               byte[] var27 = PlayerComposition.method4515();
               var9.putBytes(var27, 0, var27.length);
            }

            var9.putLong(var34.nextLong());
            var9.encryptRsa(class73.field1062, class73.field1060);
            var11 = Size.getLength(var33);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var12 = new Buffer(var11);
            var12.putString(var33);
            var12.offset = var11;
            var12.encryptXtea2(var10);
            Buffer var13 = new Buffer(var26.offset + var9.offset + var12.offset + 5);
            var13.putByte(2);
            var13.putByte(var26.offset);
            var13.putBytes(var26.payload, 0, var26.offset);
            var13.putByte(var9.offset);
            var13.putBytes(var9.payload, 0, var9.offset);
            var13.putShort(var12.offset);
            var13.putBytes(var12.payload, 0, var12.offset);
            String var14 = Frames.method3087(var13.payload);

            byte var28;
            try {
               URL var15 = new URL(CacheFile.method2551("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + LoginPacket.method3466(var14) + "&dest=" + LoginPacket.method3466("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var13 = new Buffer(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var13.payload, var13.offset, 1000 - var13.offset);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var29 = new String(var13.payload);
                     if(var29.startsWith("OFFLINE")) {
                        var28 = 4;
                     } else if(var29.startsWith("WRONG")) {
                        var28 = 7;
                     } else if(var29.startsWith("RELOAD")) {
                        var28 = 3;
                     } else if(var29.startsWith("Not permitted for social network accounts.")) {
                        var28 = 6;
                     } else {
                        var13.decryptXtea(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var29 = new String(var13.payload, 0, var13.offset);
                        boolean var20;
                        if(var29 == null) {
                           var20 = false;
                        } else {
                           label120: {
                              try {
                                 new URL(var29);
                              } catch (MalformedURLException var30) {
                                 var20 = false;
                                 break label120;
                              }

                              var20 = true;
                           }
                        }

                        if(var20) {
                           class54.method1073(var29, true, false);
                           var28 = 2;
                        } else {
                           var28 = 5;
                        }
                     }
                     break;
                  }

                  var13.offset += var19;
                  if(var13.offset >= 1000) {
                     var28 = 5;
                     break;
                  }
               }
            } catch (Throwable var31) {
               var31.printStackTrace();
               var28 = 5;
            }

            var0 = var28;
         }

         switch(var0) {
         case 2:
            Resampler.method2307(class237.field2928, class237.field3073, class237.field2832);
            class78.loginIndex = 6;
            break;
         case 3:
            Resampler.method2307("", "Error connecting to server.", "");
            break;
         case 4:
            Resampler.method2307("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            Resampler.method2307("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            Resampler.method2307("", "Error connecting to server.", "");
            break;
         case 7:
            Resampler.method2307("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
