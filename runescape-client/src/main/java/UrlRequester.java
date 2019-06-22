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

@ObfuscatedName("eo")
@Implements("UrlRequester")
public class UrlRequester implements Runnable {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -883931753
   )
   @Export("__eo_u")
   static int __eo_u;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   @Export("__eo_ak")
   static Bounds __eo_ak;
   @ObfuscatedName("m")
   @Export("thread")
   final Thread thread;
   @ObfuscatedName("f")
   @Export("isClosed")
   volatile boolean isClosed;
   @ObfuscatedName("q")
   @Export("requests")
   Queue requests;

   public UrlRequester() {
      this.requests = new LinkedList();
      this.thread = new Thread(this);
      this.thread.setPriority(1);
      this.thread.start();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Ley;",
      garbageValue = "1097505066"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "32583"
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

   @Export("run")
   @ObfuscatedName("run")
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
            NpcDefinition.sendStackTrace((String)null, var17);
         }
      }

   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-9"
   )
   static final void method3258(int var0, int var1, int var2, int var3) {
      Client.overheadTextCount = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = -1;
      int var7 = Players.Players_count;
      int[] var8 = Players.Players_indices;

      int var9;
      for(var9 = 0; var9 < var7 + Client.npcCount; ++var9) {
         Object var10;
         if(var9 < var7) {
            var10 = Client.players[var8[var9]];
            if(var8[var9] == Client.combatTargetPlayerIndex) {
               var4 = true;
               var5 = var9;
               continue;
            }

            if(var10 == Canvas.localPlayer) {
               var6 = var9;
               continue;
            }
         } else {
            var10 = Client.npcs[Client.npcIndices[var9 - var7]];
         }

         class39.drawActor2d((Actor)var10, var9, var0, var1, var2, var3);
      }

      if(Client.renderSelf && var6 != -1) {
         class39.drawActor2d(Canvas.localPlayer, var6, var0, var1, var2, var3);
      }

      if(var4) {
         class39.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var5, var0, var1, var2, var3);
      }

      for(var9 = 0; var9 < Client.overheadTextCount; ++var9) {
         int var19 = Client.overheadTextXs[var9];
         int var11 = Client.overheadTextYs[var9];
         int var12 = Client.overheadTextXOffsets[var9];
         int var13 = Client.overheadTextAscents[var9];
         boolean var14 = true;

         while(var14) {
            var14 = false;

            for(int var15 = 0; var15 < var9; ++var15) {
               if(var11 + 2 > Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] && var11 - var13 < Client.overheadTextYs[var15] + 2 && var19 - var12 < Client.overheadTextXOffsets[var15] + Client.overheadTextXs[var15] && var19 + var12 > Client.overheadTextXs[var15] - Client.overheadTextXOffsets[var15] && Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] < var11) {
                  var11 = Client.overheadTextYs[var15] - Client.overheadTextAscents[var15];
                  var14 = true;
               }
            }
         }

         Client.viewportTempX = Client.overheadTextXs[var9];
         Client.viewportTempY = Client.overheadTextYs[var9] = var11;
         String var20 = Client.overheadText[var9];
         if(Client.chatEffects == 0) {
            int var16 = 16776960;
            if(Client.overheadTextColors[var9] < 6) {
               var16 = Client.__client_pv[Client.overheadTextColors[var9]];
            }

            if(Client.overheadTextColors[var9] == 6) {
               var16 = Client.viewportDrawCount % 20 < 10?16711680:16776960;
            }

            if(Client.overheadTextColors[var9] == 7) {
               var16 = Client.viewportDrawCount % 20 < 10?255:'\uffff';
            }

            if(Client.overheadTextColors[var9] == 8) {
               var16 = Client.viewportDrawCount % 20 < 10?'뀀':8454016;
            }

            int var17;
            if(Client.overheadTextColors[var9] == 9) {
               var17 = 150 - Client.overheadTextCyclesRemaining[var9];
               if(var17 < 50) {
                  var16 = var17 * 1280 + 16711680;
               } else if(var17 < 100) {
                  var16 = 16776960 - (var17 - 50) * 327680;
               } else if(var17 < 150) {
                  var16 = (var17 - 100) * 5 + 65280;
               }
            }

            if(Client.overheadTextColors[var9] == 10) {
               var17 = 150 - Client.overheadTextCyclesRemaining[var9];
               if(var17 < 50) {
                  var16 = var17 * 5 + 16711680;
               } else if(var17 < 100) {
                  var16 = 16711935 - (var17 - 50) * 327680;
               } else if(var17 < 150) {
                  var16 = (var17 - 100) * 327680 + 255 - (var17 - 100) * 5;
               }
            }

            if(Client.overheadTextColors[var9] == 11) {
               var17 = 150 - Client.overheadTextCyclesRemaining[var9];
               if(var17 < 50) {
                  var16 = 16777215 - var17 * 327685;
               } else if(var17 < 100) {
                  var16 = (var17 - 50) * 327685 + 65280;
               } else if(var17 < 150) {
                  var16 = 16777215 - (var17 - 100) * 327680;
               }
            }

            if(Client.overheadTextEffects[var9] == 0) {
               class2.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0);
            }

            if(Client.overheadTextEffects[var9] == 1) {
               class2.fontBold12.drawCenteredWave(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
            }

            if(Client.overheadTextEffects[var9] == 2) {
               class2.fontBold12.drawCenteredWave2(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
            }

            if(Client.overheadTextEffects[var9] == 3) {
               class2.fontBold12.drawCenteredShake(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var9]);
            }

            if(Client.overheadTextEffects[var9] == 4) {
               var17 = (150 - Client.overheadTextCyclesRemaining[var9]) * (class2.fontBold12.stringWidth(var20) + 100) / 150;
               Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
               class2.fontBold12.draw(var20, var0 + Client.viewportTempX + 50 - var17, Client.viewportTempY + var1, var16, 0);
               Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.overheadTextEffects[var9] == 5) {
               var17 = 150 - Client.overheadTextCyclesRemaining[var9];
               int var18 = 0;
               if(var17 < 25) {
                  var18 = var17 - 25;
               } else if(var17 > 125) {
                  var18 = var17 - 125;
               }

               Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - class2.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
               class2.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, var18 + Client.viewportTempY + var1, var16, 0);
               Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class2.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
         }
      }

   }
}
