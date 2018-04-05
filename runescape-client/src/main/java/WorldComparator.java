import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Comparator;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 585666805
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 659377825
   )
   static int field279;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "1187585650"
   )
   int method65(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method65((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "1105337242"
   )
   static boolean method70(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1729529097"
   )
   static void method69() {
      class90.username = class90.username.trim();
      if(class90.username.length() == 0) {
         BoundingBox3DDrawMode.method53("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = GrandExchangeEvent.method89();
         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var4 = class90.username;
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

            var6.encryptRsa(class85.field1322, class85.field1323);
            var7.putByte(10);

            for(var9 = 0; var9 < 3; ++var9) {
               var7.putInt(var5.nextInt());
            }

            var7.putLong(var5.nextLong());
            var7.method3671(var5.nextLong());
            if(Client.field908 != null) {
               var7.putBytes(Client.field908, 0, Client.field908.length);
            } else {
               byte[] var20 = MilliTimer.method3192();
               var7.putBytes(var20, 0, var20.length);
            }

            var7.putLong(var5.nextLong());
            var7.encryptRsa(class85.field1322, class85.field1323);
            var9 = WorldMapRegion.getLength(var4);
            if(var9 % 8 != 0) {
               var9 += 8 - var9 % 8;
            }

            Buffer var10 = new Buffer(var9);
            var10.putString(var4);
            var10.offset = var9;
            var10.encryptXtea2(var8);
            Buffer var11 = new Buffer(var10.offset + var7.offset + var6.offset + 5);
            var11.putByte(2);
            var11.putByte(var6.offset);
            var11.putBytes(var6.payload, 0, var6.offset);
            var11.putByte(var7.offset);
            var11.putBytes(var7.payload, 0, var7.offset);
            var11.putShort(var10.offset);
            var11.putBytes(var10.payload, 0, var10.offset);
            String var12 = SoundTaskDataProvider.method816(var11.payload);

            byte var3;
            try {
               URL var13 = new URL(VerticalAlignment.method4715("services", false) + "m=accountappeal/login.ws");
               URLConnection var14 = var13.openConnection();
               var14.setDoInput(true);
               var14.setDoOutput(true);
               var14.setConnectTimeout(5000);
               OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
               var15.write("data2=" + class297.method5290(var12) + "&dest=" + class297.method5290("passwordchoice.ws"));
               var15.flush();
               InputStream var16 = var14.getInputStream();
               var11 = new Buffer(new byte[1000]);

               while(true) {
                  int var17 = var16.read(var11.payload, var11.offset, 1000 - var11.offset);
                  if(var17 == -1) {
                     var15.close();
                     var16.close();
                     String var21 = new String(var11.payload);
                     if(var21.startsWith("OFFLINE")) {
                        var3 = 4;
                     } else if(var21.startsWith("WRONG")) {
                        var3 = 7;
                     } else if(var21.startsWith("RELOAD")) {
                        var3 = 3;
                     } else if(var21.startsWith("Not permitted for social network accounts.")) {
                        var3 = 6;
                     } else {
                        var11.decryptXtea(var8);

                        while(var11.offset > 0 && var11.payload[var11.offset - 1] == 0) {
                           --var11.offset;
                        }

                        var21 = new String(var11.payload, 0, var11.offset);
                        boolean var18;
                        if(var21 == null) {
                           var18 = false;
                        } else {
                           label128: {
                              try {
                                 new URL(var21);
                              } catch (MalformedURLException var23) {
                                 var18 = false;
                                 break label128;
                              }

                              var18 = true;
                           }
                        }

                        if(!var18) {
                           var3 = 5;
                        } else {
                           label123: {
                              if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                 try {
                                    Desktop.getDesktop().browse(new URI(var21));
                                    break label123;
                                 } catch (Exception var22) {
                                    ;
                                 }
                              }

                              if(class57.field667.startsWith("win")) {
                                 Buffer.method3727(var21, 0);
                              } else if(class57.field667.startsWith("mac")) {
                                 CombatInfoListHolder.method1865(var21, 1, "openjs");
                              } else {
                                 Buffer.method3727(var21, 2);
                              }
                           }

                           var3 = 2;
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
            } catch (Throwable var24) {
               var24.printStackTrace();
               var3 = 5;
            }

            var0 = var3;
         }

         switch(var0) {
         case 2:
            BoundingBox3DDrawMode.method53("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class90.loginIndex = 6;
            break;
         case 3:
            BoundingBox3DDrawMode.method53("", "Error connecting to server.", "");
            break;
         case 4:
            BoundingBox3DDrawMode.method53("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            BoundingBox3DDrawMode.method53("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            BoundingBox3DDrawMode.method53("", "Error connecting to server.", "");
            break;
         case 7:
            BoundingBox3DDrawMode.method53("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "2120981356"
   )
   static int method57(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = var4 + var3;
         return 1;
      } else if(var0 == 4001) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = var3 * var4;
         return 1;
      } else if(var0 == 4003) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class81.intStack[--intStackSize];
         class81.intStack[++intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class81.intStack[--intStackSize];
         class81.intStack[++intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         intStackSize -= 5;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         int var5 = class81.intStack[intStackSize + 2];
         int var6 = class81.intStack[intStackSize + 3];
         int var7 = class81.intStack[intStackSize + 4];
         class81.intStack[++intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = var3 + var4 * var3 / 100;
         return 1;
      } else if(var0 == 4008) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         if(var3 == 0) {
            class81.intStack[++intStackSize - 1] = 0;
         } else {
            class81.intStack[++intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         if(var3 == 0) {
            class81.intStack[++intStackSize - 1] = 0;
            return 1;
         } else {
            switch(var4) {
            case 0:
               class81.intStack[++intStackSize - 1] = Integer.MAX_VALUE;
               break;
            case 1:
               class81.intStack[++intStackSize - 1] = var3;
               break;
            case 2:
               class81.intStack[++intStackSize - 1] = (int)Math.sqrt((double)var3);
               break;
            case 3:
               class81.intStack[++intStackSize - 1] = (int)Math.cbrt((double)var3);
               break;
            case 4:
               class81.intStack[++intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
               break;
            default:
               class81.intStack[++intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
            }

            return 1;
         }
      } else if(var0 == 4014) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         intStackSize -= 2;
         var3 = class81.intStack[intStackSize];
         var4 = class81.intStack[intStackSize + 1];
         class81.intStack[++intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         intStackSize -= 3;
         long var9 = (long)class81.intStack[intStackSize];
         long var11 = (long)class81.intStack[intStackSize + 1];
         long var13 = (long)class81.intStack[intStackSize + 2];
         class81.intStack[++intStackSize - 1] = (int)(var9 * var13 / var11);
         return 1;
      } else {
         return 2;
      }
   }
}
