import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
@Implements("ISAACCipher")
public final class ISAACCipher {
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("h")
   static int[] field2393;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1696294569
   )
   @Export("valuesRemaining")
   int valuesRemaining;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1564458615
   )
   int field2397;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2120903043
   )
   int field2390;
   @ObfuscatedName("m")
   @Export("mm")
   int[] mm;
   @ObfuscatedName("g")
   @Export("randResult")
   int[] randResult;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2146948077
   )
   int field2396;

   ISAACCipher(int[] var1) {
      this.mm = new int[256];
      this.randResult = new int[256];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.randResult[var2] = var1[var2];
      }

      this.method3371();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1537902330"
   )
   @Export("generateMoreResults")
   final void generateMoreResults() {
      this.field2397 += ++this.field2390;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.mm[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2396 ^= this.field2396 << 13;
            } else {
               this.field2396 ^= this.field2396 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2396 ^= this.field2396 << 2;
         } else {
            this.field2396 ^= this.field2396 >>> 16;
         }

         this.field2396 += this.mm[var1 + 128 & 255];
         int var3;
         this.mm[var1] = var3 = this.field2397 + this.field2396 + this.mm[(var2 & 1020) >> 2];
         this.randResult[var1] = this.field2397 = var2 + this.mm[(var3 >> 8 & 1020) >> 2];
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-46191741"
   )
   final void method3371() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.randResult[var1];
         var3 += this.randResult[var1 + 1];
         var4 += this.randResult[var1 + 2];
         var5 += this.randResult[var1 + 3];
         var6 += this.randResult[4 + var1];
         var7 += this.randResult[var1 + 5];
         var8 += this.randResult[var1 + 6];
         var9 += this.randResult[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.mm[var1];
         var3 += this.mm[var1 + 1];
         var4 += this.mm[var1 + 2];
         var5 += this.mm[var1 + 3];
         var6 += this.mm[var1 + 4];
         var7 += this.mm[var1 + 5];
         var8 += this.mm[var1 + 6];
         var9 += this.mm[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      this.generateMoreResults();
      this.valuesRemaining = 256;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-386868153"
   )
   @Export("nextInt")
   final int nextInt() {
      if(0 == --this.valuesRemaining + 1) {
         this.generateMoreResults();
         this.valuesRemaining = 255;
      }

      return this.randResult[this.valuesRemaining];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lip;IIB)Z",
      garbageValue = "0"
   )
   static boolean method3381(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class5.decodeSprite(var3);
         return true;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1573905712"
   )
   static void method3380() {
      class92.username = class92.username.trim();
      if(class92.username.length() == 0) {
         class22.method165("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(WorldMapData.method347("services", false) + "m=accountappeal/login.ws");
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
                  long var23 = var7.readLong();
                  var1 = var23;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var38) {
            var1 = 0L;
         }

         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var39 = class92.username;
            Random var40 = new Random();
            Buffer var27 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var40.nextInt(), var40.nextInt(), (int)(var1 >> 32), (int)var1};
            var27.putByte(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var27.putInt(var40.nextInt());
            }

            var27.putInt(var10[0]);
            var27.putInt(var10[1]);
            var27.putLong(var1);
            var27.putLong(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var27.putInt(var40.nextInt());
            }

            var27.encryptRsa(class87.field1362, class87.field1363);
            var9.putByte(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.putInt(var40.nextInt());
            }

            var9.putLong(var40.nextLong());
            var9.method3228(var40.nextLong());
            if(Client.field951 != null) {
               var9.putBytes(Client.field951, 0, Client.field951.length);
            } else {
               byte[] var12 = new byte[24];

               try {
                  class155.field2207.seek(0L);
                  class155.field2207.read(var12);

                  int var28;
                  for(var28 = 0; var28 < 24 && var12[var28] == 0; ++var28) {
                     ;
                  }

                  if(var28 >= 24) {
                     throw new IOException();
                  }
               } catch (Exception var37) {
                  for(int var35 = 0; var35 < 24; ++var35) {
                     var12[var35] = -1;
                  }
               }

               var9.putBytes(var12, 0, var12.length);
            }

            var9.putLong(var40.nextLong());
            var9.encryptRsa(class87.field1362, class87.field1363);
            var11 = class15.getLength(var39);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var41 = new Buffer(var11);
            var41.putString(var39);
            var41.offset = var11;
            var41.encryptXtea2(var10);
            Buffer var13 = new Buffer(var9.offset + 5 + var27.offset + var41.offset);
            var13.putByte(2);
            var13.putByte(var27.offset);
            var13.putBytes(var27.payload, 0, var27.offset);
            var13.putByte(var9.offset);
            var13.putBytes(var9.payload, 0, var9.offset);
            var13.putShort(var41.offset);
            var13.putBytes(var41.payload, 0, var41.offset);
            byte[] var15 = var13.payload;
            int var17 = var15.length;
            StringBuilder var18 = new StringBuilder();

            int var21;
            for(int var19 = 0; var19 < var17 + 0; var19 += 3) {
               int var20 = var15[var19] & 255;
               var18.append(class269.field3660[var20 >>> 2]);
               if(var19 < var17 - 1) {
                  var21 = var15[var19 + 1] & 255;
                  var18.append(class269.field3660[(var20 & 3) << 4 | var21 >>> 4]);
                  if(var19 < var17 - 2) {
                     int var22 = var15[var19 + 2] & 255;
                     var18.append(class269.field3660[(var21 & 15) << 2 | var22 >>> 6]).append(class269.field3660[var22 & 63]);
                  } else {
                     var18.append(class269.field3660[(var21 & 15) << 2]).append("=");
                  }
               } else {
                  var18.append(class269.field3660[(var20 & 3) << 4]).append("==");
               }
            }

            String var16 = var18.toString();
            var16 = var16;

            byte var33;
            try {
               URL var29 = new URL(WorldMapData.method347("services", false) + "m=accountappeal/login.ws");
               URLConnection var42 = var29.openConnection();
               var42.setDoInput(true);
               var42.setDoOutput(true);
               var42.setConnectTimeout(5000);
               OutputStreamWriter var30 = new OutputStreamWriter(var42.getOutputStream());
               var30.write("data2=" + Client.method1460(var16) + "&dest=" + Client.method1460("passwordchoice.ws"));
               var30.flush();
               InputStream var31 = var42.getInputStream();
               var13 = new Buffer(new byte[1000]);

               while(true) {
                  var21 = var31.read(var13.payload, var13.offset, 1000 - var13.offset);
                  if(var21 == -1) {
                     var30.close();
                     var31.close();
                     String var32 = new String(var13.payload);
                     if(var32.startsWith("OFFLINE")) {
                        var33 = 4;
                     } else if(var32.startsWith("WRONG")) {
                        var33 = 7;
                     } else if(var32.startsWith("RELOAD")) {
                        var33 = 3;
                     } else if(var32.startsWith("Not permitted for social network accounts.")) {
                        var33 = 6;
                     } else {
                        var13.decryptXtea(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var32 = new String(var13.payload, 0, var13.offset);
                        if(KeyFocusListener.method737(var32)) {
                           class37.method488(var32, true, false);
                           var33 = 2;
                        } else {
                           var33 = 5;
                        }
                     }
                     break;
                  }

                  var13.offset += var21;
                  if(var13.offset >= 1000) {
                     var33 = 5;
                     break;
                  }
               }
            } catch (Throwable var36) {
               var36.printStackTrace();
               var33 = 5;
            }

            var0 = var33;
         }

         switch(var0) {
         case 2:
            class22.method165("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class92.loginIndex = 6;
            break;
         case 3:
            class22.method165("", "Error connecting to server.", "");
            break;
         case 4:
            class22.method165("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class22.method165("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class22.method165("", "Error connecting to server.", "");
            break;
         case 7:
            class22.method165("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "136766161"
   )
   static int method3379(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         BufferProvider.intStackSize -= 3;
         var3 = class83.intStack[BufferProvider.intStackSize];
         var4 = class83.intStack[BufferProvider.intStackSize + 1];
         int var5 = class83.intStack[BufferProvider.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = class239.method4167(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class48.field614 = var12;
               } else {
                  FaceNormal.field2099 = var12;
               }

               class21.method156(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class48.field614:FaceNormal.field2099;
            Widget var10 = class239.method4167(var9.id);
            var10.children[var9.index] = null;
            class21.method156(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
            var9.children = null;
            class21.method156(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
               if(var9 != null) {
                  class83.intStack[++BufferProvider.intStackSize - 1] = 1;
                  if(var2) {
                     class48.field614 = var9;
                  } else {
                     FaceNormal.field2099 = var9;
                  }
               } else {
                  class83.intStack[++BufferProvider.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            BufferProvider.intStackSize -= 2;
            var3 = class83.intStack[BufferProvider.intStackSize];
            var4 = class83.intStack[BufferProvider.intStackSize + 1];
            Widget var11 = CollisionData.method2946(var3, var4);
            if(var11 != null && var4 != -1) {
               class83.intStack[++BufferProvider.intStackSize - 1] = 1;
               if(var2) {
                  class48.field614 = var11;
               } else {
                  FaceNormal.field2099 = var11;
               }
            } else {
               class83.intStack[++BufferProvider.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
