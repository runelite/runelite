import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 409758951
   )
   public static int field654;
   @ObfuscatedName("cr")
   static int[] field667;
   @ObfuscatedName("cq")
   public static boolean[] field655;
   @ObfuscatedName("cl")
   public static int[] field656;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -2003444815
   )
   public static int field657;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1556971749
   )
   public static int field664;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -155836273
   )
   public static int field666;
   @ObfuscatedName("ch")
   static char[] field659;
   @ObfuscatedName("ca")
   static int[] field643;
   @ObfuscatedName("ci")
   public static int[] field658;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -114656503
   )
   public static int field662;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1524088871
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1771508655
   )
   public static int field665;
   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;

   static {
      keyboard = new KeyFocusListener();
      field655 = new boolean[112];
      field656 = new int[128];
      field657 = 0;
      field654 = 0;
      field659 = new char[128];
      field643 = new int[128];
      field658 = new int[128];
      field662 = 0;
      field666 = 0;
      field664 = 0;
      field665 = 0;
      keyboardIdleTicks = 0;
      field667 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field667.length) {
            var2 = field667[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field654 >= 0 && var2 >= 0) {
            field656[field654] = var2;
            field654 = field654 + 1 & 127;
            if(field654 == field657) {
               field654 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field664 + 1 & 127;
            if(var3 != field666) {
               field643[field664] = var2;
               field659[field664] = 0;
               field664 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field667.length) {
            var2 = field667[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field654 >= 0 && var2 >= 0) {
            field656[field654] = ~var2;
            field654 = field654 + 1 & 127;
            if(field657 == field654) {
               field654 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field654 = -1;
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && KitDefinition.method4485(var2)) {
            int var3 = field664 + 1 & 127;
            if(var3 != field666) {
               field643[field664] = -1;
               field659[field664] = var2;
               field664 = var3;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(Lbw;IIBI)V",
      garbageValue = "-1176521572"
   )
   static final void method781(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.getSize();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var7 = class45.method667(var4, var5, var0.getSize(), class9.method53(var1, var2), Client.collisionMaps[var0.field894], true, Client.field1190, Client.field1191);
            if(var7 >= 1) {
               for(int var8 = 0; var8 < var7 - 1; ++var8) {
                  var0.method1177(Client.field1190[var8], Client.field1191[var8], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-2126527034"
   )
   static boolean method783(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field695.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class52.method796(class56.field694, var2, new Object[]{(new URL(class56.field694.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field694.getAppletContext().showDocument(new URL(class56.field694.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method795(class56.field694, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class56.field694.getAppletContext().showDocument(new URL(class56.field694.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfd;I)I",
      garbageValue = "1431851173"
   )
   static int method785(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "976326333"
   )
   static int method786(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var3].method101();
         return 1;
      } else if(var0 == 3904) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class81.intStack[--class81.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method99();
            class81.intStack[++class81.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class81.intStack[--class81.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method99();
            class81.intStack[++class81.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class81.intStack[--class81.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method99();
            class81.intStack[++class81.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class81.intStack[--class81.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method99();
            class81.intStack[++class81.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class81.intStack[--class81.intStackSize] == 1;
               if(class19.field330 != null) {
                  class19.field330.method74(class13.field283, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class81.intStack[--class81.intStackSize] == 1;
               if(class19.field330 != null) {
                  class19.field330.method74(class13.field280, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class81.intStackSize -= 2;
               var13 = class81.intStack[class81.intStackSize] == 1;
               boolean var4 = 1 == class81.intStack[class81.intStackSize + 1];
               if(class19.field330 != null) {
                  class19.field330.method74(new class93(var4), var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class81.intStack[--class81.intStackSize] == 1;
               if(class19.field330 != null) {
                  class19.field330.method74(class13.field281, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class81.intStack[--class81.intStackSize] == 1;
               if(class19.field330 != null) {
                  class19.field330.method74(class13.field282, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class81.intStack[++class81.intStackSize - 1] = class19.field330 == null?0:class19.field330.field284.size();
               return 1;
            } else {
               class14 var11;
               if(var0 == 3920) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var11 = (class14)class19.field330.field284.get(var3);
                  class81.intStack[++class81.intStackSize - 1] = var11.field297;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var11 = (class14)class19.field330.field284.get(var3);
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var11.method80();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var11 = (class14)class19.field330.field284.get(var3);
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var11.method84();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var11 = (class14)class19.field330.field284.get(var3);
                  long var5 = class147.currentTimeMs() - class51.field675 - var11.field289;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var11 = (class14)class19.field330.field284.get(var3);
                  class81.intStack[++class81.intStackSize - 1] = var11.field295.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var11 = (class14)class19.field330.field284.get(var3);
                  class81.intStack[++class81.intStackSize - 1] = var11.field295.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var11 = (class14)class19.field330.field284.get(var3);
                  class81.intStack[++class81.intStackSize - 1] = var11.field295.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "1"
   )
   static final void method787(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = CacheFile.getTileHeight(var0, var1, class5.plane) - var2;
         var0 -= class211.cameraX;
         var3 -= ScriptState.cameraZ;
         var1 -= ChatLineBuffer.cameraY;
         int var4 = Graphics3D.SINE[class9.cameraPitch];
         int var5 = Graphics3D.COSINE[class9.cameraPitch];
         int var6 = Graphics3D.SINE[class174.cameraYaw];
         int var7 = Graphics3D.COSINE[class174.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.screenY = Client.viewportHeight / 2 + var0 * Client.scale / var1;
            Client.screenX = var8 * Client.scale / var1 + Client.viewportWidth / 2;
         } else {
            Client.screenY = -1;
            Client.screenX = -1;
         }

      } else {
         Client.screenY = -1;
         Client.screenX = -1;
      }
   }
}
