import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class14 {
   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field281;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      longValue = 7019711567611887193L
   )
   static long field280;
   @ObfuscatedName("g")
   String field274;
   @ObfuscatedName("u")
   String field277;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 5635280382728096227L
   )
   public final long field275;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 811550195
   )
   public final int field278;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   public final XGrandExchangeOffer field276;

   @ObfuscatedSignature(
      signature = "(Lfp;BI)V"
   )
   class14(Buffer var1, byte var2, int var3) {
      this.field277 = var1.readString();
      this.field274 = var1.readString();
      this.field278 = var1.readUnsignedShort();
      this.field275 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field276 = new XGrandExchangeOffer();
      this.field276.method112(2);
      this.field276.method114(var2);
      this.field276.price = var4;
      this.field276.totalQuantity = var5;
      this.field276.quantitySold = 0;
      this.field276.spent = 0;
      this.field276.itemId = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "4"
   )
   public String method82() {
      return this.field277;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1375354460"
   )
   public String method73() {
      return this.field274;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "1488836204"
   )
   static String method72(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class152) {
         class152 var2 = (class152)var0;
         var1 = var2.field2180 + " | ";
         var0 = var2.field2182;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Lho;B)Lho;",
      garbageValue = "-112"
   )
   static Widget method83(Widget var0) {
      int var1 = Item.method1707(class60.getWidgetConfig(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class239.method4167(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "676337530"
   )
   static final void method71(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class181.field2404 || WallObject.field2088 != var1) {
         class181.field2404 = var0;
         WallObject.field2088 = var1;
         class152.setGameState(25);
         class163.drawStatusBox("Loading - please wait.", true);
         int var3 = class21.baseX;
         int var4 = class164.baseY;
         class21.baseX = (var0 - 6) * 8;
         class164.baseY = (var1 - 6) * 8;
         int var5 = class21.baseX - var3;
         int var6 = class164.baseY - var4;
         var3 = class21.baseX;
         var4 = class164.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < '耀'; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var13 + var5;
               int var16 = var14 + var6;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.field935 = 0;
         Client.field1008 = false;
         Client.field1131 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(Lbt;III)V",
      garbageValue = "-1486834766"
   )
   static void method81(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class31.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1243 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1245 = 0;
         }

         if(var3 == 2) {
            var0.field1245 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class31.getAnimation(var1).forcedPriority >= class31.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1243 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1245 = 0;
         var0.field1219 = var0.queueSize;
      }

   }
}
