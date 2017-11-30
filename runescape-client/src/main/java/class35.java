import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("an")
public class class35 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   static final class35 field462;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   static final class35 field468;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1440292873
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 865731653
   )
   static int field467;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1026690135
   )
   final int field463;

   static {
      field462 = new class35(0);
      field468 = new class35(1);
   }

   class35(int var1) {
      this.field463 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "22"
   )
   public static int method496(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "964318674"
   )
   public static boolean method492(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field621.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var13.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class56.field622;
            Object[] var5 = new Object[]{(new URL(class56.field622.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field622.getAppletContext().showDocument(new URL(class56.field622.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method755(class56.field622, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class56.field622.getAppletContext().showDocument(new URL(class56.field622.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   static int method493(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-4"
   )
   static void method494(int var0) {
      Client.field942 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      int var1 = Client.isResized?2:1;
      if(var1 == 1) {
         TotalQuantityComparator.clientInstance.method809(765, 503);
      } else {
         TotalQuantityComparator.clientInstance.method809(7680, 2160);
      }

      if(Client.gameState >= 25) {
         Ignore.method1058();
      }

   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-465782610"
   )
   static final void method495() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == BoundingBox2D.plane && Client.gameCycle <= var0.cycle) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.moveProjectile(var1.x, var1.y, WorldMapType2.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = UrlRequest.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.moveProjectile(var3.x, var3.y, WorldMapType2.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.update(Client.field847);
               class48.region.method2701(BoundingBox2D.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(Lhz;I)V",
      garbageValue = "-153167897"
   )
   static final void method491(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1045 == -1) {
            Client.field1045 = var0.spriteId;
            Client.field1101 = var0.field2752;
         }

         if(Client.field1090.isFemale) {
            var0.spriteId = Client.field1045;
         } else {
            var0.spriteId = Client.field1101;
         }

      } else if(var1 == 325) {
         if(Client.field1045 == -1) {
            Client.field1045 = var0.spriteId;
            Client.field1101 = var0.field2752;
         }

         if(Client.field1090.isFemale) {
            var0.spriteId = Client.field1101;
         } else {
            var0.spriteId = Client.field1045;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
