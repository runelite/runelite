import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("UrlRequester")
public class UrlRequester implements Runnable {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("timer")
   protected static Timer timer;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      longValue = -8966280129938593429L
   )
   static long field2126;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -730105281
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("o")
   @Export("thread")
   final Thread thread;
   @ObfuscatedName("k")
   @Export("isClosed")
   volatile boolean isClosed;
   @ObfuscatedName("t")
   @Export("requests")
   Queue requests;

   public UrlRequester() {
      this.requests = new LinkedList();
      this.thread = new Thread(this);
      this.thread.setPriority(1);
      this.thread.start();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lev;",
      garbageValue = "1428764522"
   )
   @Export("request")
   public UrlRequest request(URL var1) {
      UrlRequest var2 = new UrlRequest(var1);
      synchronized(this) {
         this.requests.add(var2);
         this.notify();
         return var2;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1544803497"
   )
   @Export("close")
   public void close() {
      this.isClosed = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.thread.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   public void run() {
      while(!this.isClosed) {
         try {
            UrlRequest var1;
            synchronized(this) {
               var1 = (UrlRequest)this.requests.poll();
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
               var3 = var1.url.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var7 = var3.getContentLength();
               if(var7 >= 0) {
                  byte[] var5 = new byte[var7];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.response0 = var5;
               }

               var1.isDone0 = true;
            } catch (IOException var14) {
               var1.isDone0 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            AttackOption.processClientError((String)null, var17);
         }
      }

   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(Lgs;I)V",
      garbageValue = "-479462566"
   )
   static final void method3091(PacketBuffer var0) {
      for(int var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
         int var2 = Client.pendingNpcFlagsIndices[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = var0.readUnsignedByte();
         int var5;
         int var6;
         int var7;
         if((var4 & 4) != 0) {
            var5 = var0.readUnsignedShort();
            if(var5 == 65535) {
               var5 = -1;
            }

            var6 = var0.readUnsignedShortOb1();
            if(var5 == var3.animation && var5 != -1) {
               var7 = CombatInfo1.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.actionFrameCycle = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1193 = 0;
               }

               if(var7 == 2) {
                  var3.field1193 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || CombatInfo1.getAnimation(var5).forcedPriority >= CombatInfo1.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.actionFrameCycle = 0;
               var3.actionAnimationDisable = var6;
               var3.field1193 = 0;
               var3.field1216 = var3.queueSize;
            }
         }

         if((var4 & 64) != 0) {
            var3.composition = class234.getNpcDefinition(var0.readUnsignedShort());
            var3.field1172 = var3.composition.size;
            var3.field1205 = var3.composition.rotation;
            var3.field1165 = var3.composition.walkingAnimation;
            var3.field1209 = var3.composition.rotate180Animation;
            var3.field1167 = var3.composition.rotate90RightAnimation;
            var3.field1177 = var3.composition.rotate90LeftAnimation;
            var3.idlePoseAnimation = var3.composition.standingAnimation;
            var3.field1163 = var3.composition.field3716;
            var3.field1164 = var3.composition.field3714;
         }

         int var8;
         if((var4 & 2) != 0) {
            var5 = var0.readUnsignedShort();
            var6 = var0.method3554();
            var7 = var3.x - (var5 - class138.baseX - class138.baseX) * 64;
            var8 = var3.y - (var6 - class23.baseY - class23.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1185 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 32) != 0) {
            var3.interacting = var0.method3555();
            if(var3.interacting == 65535) {
               var3.interacting = -1;
            }
         }

         if((var4 & 16) != 0) {
            var5 = var0.method3538();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = var0.getUSmart();
                  if(var7 == 32767) {
                     var7 = var0.getUSmart();
                     var9 = var0.getUSmart();
                     var8 = var0.getUSmart();
                     var10 = var0.getUSmart();
                  } else if(var7 != 32766) {
                     var9 = var0.getUSmart();
                  } else {
                     var7 = -1;
                  }

                  var11 = var0.getUSmart();
                  var3.method1657(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = var0.method3538();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  if(var9 != 32767) {
                     var10 = var0.getUSmart();
                     var11 = var0.readUnsignedShortOb1();
                     int var12 = var9 > 0?var0.readUnsignedShortOb1():var11;
                     var3.setCombatInfo(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1659(var8);
                  }
               }
            }
         }

         if((var4 & 1) != 0) {
            var3.graphic = var0.method3555();
            var5 = var0.method3562();
            var3.field1198 = var5 >> 16;
            var3.graphicsDelay = (var5 & 65535) + Client.gameCycle;
            var3.spotAnimFrame = 0;
            var3.spotAnimFrameCycle = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.spotAnimFrame = -1;
            }

            if(var3.graphic == 65535) {
               var3.graphic = -1;
            }
         }

         if((var4 & 8) != 0) {
            var3.overhead = var0.readString();
            var3.overheadTextCyclesRemaining = 100;
         }
      }

   }
}
