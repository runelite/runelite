import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public final class class143 implements Runnable {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -495527811
   )
   int field2171 = 0;
   @ObfuscatedName("w")
   OutputStream field2172;
   @ObfuscatedName("f")
   Socket field2173;
   @ObfuscatedName("bq")
   static class168 field2175;
   @ObfuscatedName("h")
   class146 field2176;
   @ObfuscatedName("g")
   byte[] field2177;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1740947967
   )
   int field2178 = 0;
   @ObfuscatedName("s")
   boolean field2179 = false;
   @ObfuscatedName("k")
   boolean field2180 = false;
   @ObfuscatedName("gi")
   static class173 field2182;
   @ObfuscatedName("p")
   class136 field2183;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 152966257
   )
   protected static int field2185;
   @ObfuscatedName("e")
   InputStream field2186;
   @ObfuscatedName("u")
   static int[] field2187;

   @ObfuscatedName("dq")
   static final void method2981(String var0) {
      if(null != var0) {
         String var1 = class122.method2773(var0, client.field283);
         if(null != var1) {
            for(int var2 = 0; var2 < client.field549; ++var2) {
               class7 var3 = client.field550[var2];
               String var4 = var3.field141;
               String var5 = class122.method2773(var4, client.field283);
               if(class154.method3163(var0, var1, var4, var5)) {
                  --client.field549;

                  for(int var6 = var2; var6 < client.field549; ++var6) {
                     client.field550[var6] = client.field550[1 + var6];
                  }

                  client.field471 = client.field463;
                  client.field321.method2762(206);
                  client.field321.method2565(class47.method982(var0));
                  client.field321.method2514(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("w")
   public void method2982() {
      if(!this.field2179) {
         synchronized(this) {
            this.field2179 = true;
            this.notifyAll();
         }

         if(null != this.field2176) {
            while(0 == this.field2176.field2213) {
               class130.method2818(1L);
            }

            if(1 == this.field2176.field2213) {
               try {
                  ((Thread)this.field2176.field2216).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2176 = null;
      }
   }

   @ObfuscatedName("h")
   public void method2983(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2179) {
         if(this.field2180) {
            this.field2180 = false;
            throw new IOException();
         } else {
            if(null == this.field2177) {
               this.field2177 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2177[this.field2171] = var1[var5 + var2];
                  this.field2171 = (this.field2171 + 1) % 5000;
                  if((4900 + this.field2178) % 5000 == this.field2171) {
                     throw new IOException();
                  }
               }

               if(null == this.field2176) {
                  this.field2176 = this.field2183.method2888(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("f")
   public int method2984() throws IOException {
      return this.field2179?0:this.field2186.read();
   }

   @ObfuscatedName("s")
   public int method2985() throws IOException {
      return this.field2179?0:this.field2186.available();
   }

   public class143(Socket var1, class136 var2) throws IOException {
      this.field2183 = var2;
      this.field2173 = var1;
      this.field2173.setSoTimeout(30000);
      this.field2173.setTcpNoDelay(true);
      this.field2173.setReceiveBufferSize(16384);
      this.field2173.setSendBufferSize(16384);
      this.field2186 = this.field2173.getInputStream();
      this.field2172 = this.field2173.getOutputStream();
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "-6769"
   )
   static final void method2987(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class151.field2250.method1952(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(0 != var5) {
         var6 = class151.field2250.method1979(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class141.field2160.field1379;
         var11 = 24624 + var1 * 4 + 2048 * (103 - var2);
         var12 = var5 >> 14 & 32767;
         class40 var13 = class26.method633(var12);
         if(var13.field916 != -1) {
            class80 var14 = class12.field190[var13.field916];
            if(var14 != null) {
               int var15 = (var13.field908 * 4 - var14.field1390) / 2;
               int var16 = (var13.field915 * 4 - var14.field1391) / 2;
               var14.method1880(var15 + 4 * var1 + 48, var16 + 48 + 4 * (104 - var2 - var13.field915));
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(0 == var7) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(1 == var7) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[2 + var11] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1 + var11 + 1536] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + var11 + 1536] = var9;
               }
            }

            if(3 == var8) {
               if(0 == var7) {
                  var10[var11] = var9;
               } else if(1 == var7) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3 + 1536] = var9;
               } else if(3 == var7) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(3 == var7) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(2 == var7) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }
         }
      }

      var5 = class151.field2250.method2012(var0, var1, var2);
      if(var5 != 0) {
         var6 = class151.field2250.method1979(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var19 = class26.method633(var9);
         int var23;
         if(var19.field916 != -1) {
            class80 var21 = class12.field190[var19.field916];
            if(var21 != null) {
               var12 = (var19.field908 * 4 - var21.field1390) / 2;
               var23 = (var19.field915 * 4 - var21.field1391) / 2;
               var21.method1880(48 + var1 * 4 + var12, 48 + (104 - var2 - var19.field915) * 4 + var23);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class141.field2160.field1379;
            var23 = var1 * 4 + 24624 + 2048 * (103 - var2);
            if(var7 != 0 && 2 != var7) {
               var22[var23] = var11;
               var22[1 + var23 + 512] = var11;
               var22[2 + var23 + 1024] = var11;
               var22[3 + 1536 + var23] = var11;
            } else {
               var22[1536 + var23] = var11;
               var22[1 + var23 + 1024] = var11;
               var22[512 + var23 + 2] = var11;
               var22[var23 + 3] = var11;
            }
         }
      }

      var5 = class151.field2250.method1955(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class40 var17 = class26.method633(var6);
         if(var17.field916 != -1) {
            class80 var18 = class12.field190[var17.field916];
            if(null != var18) {
               var9 = (var17.field908 * 4 - var18.field1390) / 2;
               int var20 = (var17.field915 * 4 - var18.field1391) / 2;
               var18.method1880(var9 + var1 * 4 + 48, 48 + 4 * (104 - var2 - var17.field915) + var20);
            }
         }
      }

   }

   @ObfuscatedName("p")
   public void method2991(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2179) {
         while(var3 > 0) {
            int var4 = this.field2186.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   protected void finalize() {
      this.method2982();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2178 == this.field2171) {
                     if(this.field2179) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field2178;
                  if(this.field2171 >= this.field2178) {
                     var1 = this.field2171 - this.field2178;
                  } else {
                     var1 = 5000 - this.field2178;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2172.write(this.field2177, var2, var1);
               } catch (IOException var8) {
                  this.field2180 = true;
               }

               this.field2178 = (this.field2178 + var1) % 5000;

               try {
                  if(this.field2171 == this.field2178) {
                     this.field2172.flush();
                  }
               } catch (IOException var7) {
                  this.field2180 = true;
               }
               continue;
            }

            try {
               if(null != this.field2186) {
                  this.field2186.close();
               }

               if(this.field2172 != null) {
                  this.field2172.close();
               }

               if(null != this.field2173) {
                  this.field2173.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.field2177 = null;
            break;
         }
      } catch (Exception var11) {
         class1.method16((String)null, var11);
      }

   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "642607586"
   )
   static final void method3001(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field285 && var0 != class48.field1063) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(0 == var1) {
            var7 = class151.field2250.method1952(var0, var2, var3);
         }

         if(1 == var1) {
            var7 = class151.field2250.method1942(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class151.field2250.method2012(var0, var2, var3);
         }

         if(3 == var1) {
            var7 = class151.field2250.method1955(var0, var2, var3);
         }

         int var11;
         if(0 != var7) {
            var11 = class151.field2250.method1979(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            class40 var12;
            if(var1 == 0) {
               class151.field2250.method1943(var0, var2, var3);
               var12 = class26.method633(var13);
               if(var12.field924 != 0) {
                  client.field338[var0].method2413(var2, var3, var14, var15, var12.field917);
               }
            }

            if(var1 == 1) {
               class151.field2250.method1944(var0, var2, var3);
            }

            if(var1 == 2) {
               class151.field2250.method1945(var0, var2, var3);
               var12 = class26.method633(var13);
               if(var12.field908 + var2 > 103 || var12.field908 + var3 > 103 || var12.field915 + var2 > 103 || var3 + var12.field915 > 103) {
                  return;
               }

               if(var12.field924 != 0) {
                  client.field338[var0].method2414(var2, var3, var12.field908, var12.field915, var15, var12.field917);
               }
            }

            if(3 == var1) {
               class151.field2250.method1932(var0, var2, var3);
               var12 = class26.method633(var13);
               if(1 == var12.field924) {
                  client.field338[var0].method2438(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field80[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class27.method644(var0, var11, var2, var3, var4, var5, var6, class151.field2250, client.field338[var0]);
         }
      }

   }

   @ObfuscatedName("s")
   public static class227 method3003(String var0, String var1, boolean var2) {
      File var3 = new File(class149.field2237, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class227 var10 = new class227(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class189.field3047 == 33) {
         var4 = "_rc";
      } else if(34 == class189.field3047) {
         var4 = "_wip";
      }

      File var5 = new File(class35.field765, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class227 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class227(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class227(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
