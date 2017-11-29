import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class25 {
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = 686377759
   )
   static int field350;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field348;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1157793573
   )
   int field351;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   Coordinates field349;

   @ObfuscatedSignature(
      signature = "(ILhp;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field351 = var1;
      this.field349 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Lfo;",
      garbageValue = "1027124895"
   )
   public static class169[] method187() {
      return new class169[]{class169.field2409, class169.field2415, class169.field2410, class169.field2411, class169.field2408, class169.field2413, class169.field2414, class169.field2412, class169.field2416, class169.field2417};
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1798765715"
   )
   static void method188() {
      class91.username = class91.username.trim();
      if(class91.username.length() == 0) {
         NPC.method1749("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(ScriptState.method1090("services", false) + "m=accountappeal/login.ws");
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
         } catch (Exception var31) {
            var1 = 0L;
         }

         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var32 = class91.username;
            Random var33 = new Random();
            Buffer var26 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var33.nextInt(), var33.nextInt(), (int)(var1 >> 32), (int)var1};
            var26.putByte(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var26.putInt(var33.nextInt());
            }

            var26.putInt(var10[0]);
            var26.putInt(var10[1]);
            var26.putLong(var1);
            var26.putLong(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var26.putInt(var33.nextInt());
            }

            var26.encryptRsa(class86.field1298, class86.field1301);
            var9.putByte(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.putInt(var33.nextInt());
            }

            var9.putLong(var33.nextLong());
            var9.method3284(var33.nextLong());
            AttackOption.method1776(var9);
            var9.putLong(var33.nextLong());
            var9.encryptRsa(class86.field1298, class86.field1301);
            var11 = AbstractSoundSystem.getLength(var32);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var12 = new Buffer(var11);
            var12.putString(var32);
            var12.offset = var11;
            var12.encryptXtea2(var10);
            Buffer var13 = new Buffer(var12.offset + var26.offset + var9.offset + 5);
            var13.putByte(2);
            var13.putByte(var26.offset);
            var13.putBytes(var26.payload, 0, var26.offset);
            var13.putByte(var9.offset);
            var13.putBytes(var9.payload, 0, var9.offset);
            var13.putShort(var12.offset);
            var13.putBytes(var12.payload, 0, var12.offset);
            String var14 = class274.method5048(var13.payload);

            byte var28;
            try {
               URL var15 = new URL(ScriptState.method1090("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + ChatLineBuffer.method1918(var14) + "&dest=" + ChatLineBuffer.method1918("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var13 = new Buffer(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var13.payload, var13.offset, 1000 - var13.offset);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var27 = new String(var13.payload);
                     if(var27.startsWith("OFFLINE")) {
                        var28 = 4;
                     } else if(var27.startsWith("WRONG")) {
                        var28 = 7;
                     } else if(var27.startsWith("RELOAD")) {
                        var28 = 3;
                     } else if(var27.startsWith("Not permitted for social network accounts.")) {
                        var28 = 6;
                     } else {
                        var13.decryptXtea(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var27 = new String(var13.payload, 0, var13.offset);
                        boolean var20;
                        if(var27 == null) {
                           var20 = false;
                        } else {
                           label105: {
                              try {
                                 new URL(var27);
                              } catch (MalformedURLException var29) {
                                 var20 = false;
                                 break label105;
                              }

                              var20 = true;
                           }
                        }

                        if(var20) {
                           MessageNode.method1132(var27, true, false);
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
            } catch (Throwable var30) {
               var30.printStackTrace();
               var28 = 5;
            }

            var0 = var28;
         }

         switch(var0) {
         case 2:
            NPC.method1749("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class91.loginIndex = 6;
            break;
         case 3:
            NPC.method1749("", "Error connecting to server.", "");
            break;
         case 4:
            NPC.method1749("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            NPC.method1749("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            NPC.method1749("", "Error connecting to server.", "");
            break;
         case 7:
            NPC.method1749("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lcf;I)V",
      garbageValue = "-1497933033"
   )
   public static final void method191(TaskDataProvider var0) {
      class3.soundTaskDataProvider = var0;
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   static final void method190() {
      if(FileOnDisk.soundSystem1 != null) {
         FileOnDisk.soundSystem1.method2095();
      }

      if(class3.soundSystem0 != null) {
         class3.soundSystem0.method2095();
      }

   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2083442145"
   )
   static boolean method189(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
