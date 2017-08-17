import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class69 implements Runnable {
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   static Task field850;
   @ObfuscatedName("h")
   volatile boolean field849;
   @ObfuscatedName("f")
   Queue field852;
   @ObfuscatedName("j")
   final Thread field848;

   class69() {
      this.field852 = new LinkedList();
      this.field848 = new Thread(this);
      this.field848.setPriority(1);
      this.field848.start();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-57"
   )
   void method1150() {
      this.field849 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field848.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lcm;",
      garbageValue = "-7"
   )
   class83 method1151(URL var1) {
      class83 var2 = new class83(var1);
      synchronized(this) {
         this.field852.add(var2);
         this.notify();
         return var2;
      }
   }

   public void run() {
      while(!this.field849) {
         try {
            class83 var1;
            synchronized(this) {
               var1 = (class83)this.field852.poll();
               if(var1 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException var13) {
                     ;
                  }
                  continue;
               }
            }

            DataInputStream var2 = null;
            URLConnection var3 = null;

            try {
               var3 = var1.field1333.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var4 = var3.getContentLength();
               if(var4 >= 0) {
                  byte[] var5 = new byte[var4];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.field1335 = var5;
               }

               var1.field1336 = true;
            } catch (IOException var14) {
               var1.field1336 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            Varcs.method1853((String)null, var17);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "2065924437"
   )
   static void method1159(String var0, String var1, String var2) {
      class93.loginMessage1 = var0;
      class93.loginMessage2 = var1;
      class93.loginMessage3 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfo;II)V",
      garbageValue = "-1119550065"
   )
   static final void method1152(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class97.field1506 = 0;
      method1158(var0);
      class82.method1612(var0);
      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfo;B)V",
      garbageValue = "0"
   )
   static final void method1158(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class97.field1510; ++var2) {
         var3 = class97.field1511[var2];
         if((class97.field1507[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class97.field1507[var3] = (byte)(class97.field1507[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = Ignore.method1168(var0);
                  class97.field1507[var3] = (byte)(class97.field1507[var3] | 2);
               } else {
                  class262.decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class97.field1510; ++var2) {
            var3 = class97.field1511[var2];
            if((class97.field1507[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class97.field1507[var3] = (byte)(class97.field1507[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = Ignore.method1168(var0);
                     class97.field1507[var3] = (byte)(class97.field1507[var3] | 2);
                  } else {
                     class262.decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class97.field1512; ++var2) {
               var3 = class97.field1513[var2];
               if((class97.field1507[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class97.field1507[var3] = (byte)(class97.field1507[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = Ignore.method1168(var0);
                        class97.field1507[var3] = (byte)(class97.field1507[var3] | 2);
                     } else if(WorldMapType2.decodeRegionHash(var0, var3)) {
                        class97.field1507[var3] = (byte)(class97.field1507[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class97.field1512; ++var2) {
                  var3 = class97.field1513[var2];
                  if((class97.field1507[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class97.field1507[var3] = (byte)(class97.field1507[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = Ignore.method1168(var0);
                           class97.field1507[var3] = (byte)(class97.field1507[var3] | 2);
                        } else if(WorldMapType2.decodeRegionHash(var0, var3)) {
                           class97.field1507[var3] = (byte)(class97.field1507[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class97.field1510 = 0;
                  class97.field1512 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class97.field1507[var2] = (byte)(class97.field1507[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class97.field1511[++class97.field1510 - 1] = var2;
                     } else {
                        class97.field1513[++class97.field1512 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-214236119"
   )
   static final void method1157(String var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(161);
      Client.secretPacketBuffer1.putByte(class169.getLength(var0) + 1);
      Client.secretPacketBuffer1.putString(var0);
      Client.secretPacketBuffer1.method3200(var1);
   }
}
