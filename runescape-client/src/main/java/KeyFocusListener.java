import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   @Export("keyboard")
   static KeyFocusListener keyboard;
   @ObfuscatedName("cm")
   @Export("keyPressed")
   public static boolean[] keyPressed;
   @ObfuscatedName("cv")
   static int[] field616;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 955752471
   )
   static int field609;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 582729975
   )
   static int field610;
   @ObfuscatedName("ce")
   static char[] field594;
   @ObfuscatedName("cr")
   static int[] field612;
   @ObfuscatedName("cf")
   public static int[] field613;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -311840527
   )
   public static int field593;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -1293966161
   )
   static int field615;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 2045583319
   )
   static int field606;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 2050030589
   )
   static int field617;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -749012037
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("cs")
   @Export("KeyHandler_keyCodes")
   static int[] KeyHandler_keyCodes;

   static {
      keyboard = new KeyFocusListener();
      keyPressed = new boolean[112];
      field616 = new int[128];
      field609 = 0;
      field610 = 0;
      field594 = new char[128];
      field612 = new int[128];
      field613 = new int[128];
      field593 = 0;
      field615 = 0;
      field606 = 0;
      field617 = 0;
      keyboardIdleTicks = 0;
      KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   @Export("keyPressed")
   @ObfuscatedName("keyPressed")
   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field610 >= 0 && var2 >= 0) {
            field616[field610] = var2;
            field610 = field610 + 1 & 127;
            if(field609 == field610) {
               field610 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field606 + 1 & 127;
            if(var3 != field615) {
               field612[field606] = var2;
               field594[field606] = 0;
               field606 = var3;
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
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field610 >= 0 && var2 >= 0) {
            field616[field610] = ~var2;
            field610 = field610 + 1 & 127;
            if(field610 == field609) {
               field610 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label58: {
                  if(var2 != 0) {
                     char[] var7 = class314.cp1252AsciiExtension;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label58;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field606 + 1 & 127;
               if(var4 != field615) {
                  field612[field606] = -1;
                  field594[field606] = var2;
                  field606 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @Export("focusLost")
   @Hook("focusLost")
   @ObfuscatedName("focusLost")
   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field610 = -1;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;Ljava/lang/String;)Lff;"
   )
   public static RunException method808(Throwable var0, String var1) {
      RunException var2;
      if(var0 instanceof RunException) {
         var2 = (RunException)var0;
         var2.field2184 = var2.field2184 + ' ' + var1;
      } else {
         var2 = new RunException(var0, var1);
      }

      return var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgf;I)V",
      garbageValue = "1314789376"
   )
   static final void method794(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class93.playerIndexesCount; ++var2) {
         var3 = class93.playerIndices[var2];
         if((class93.field1411[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class93.field1411[var3] = (byte)(class93.field1411[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = World.method1642(var0);
                  class93.field1411[var3] = (byte)(class93.field1411[var3] | 2);
               } else {
                  FrameMap.decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class93.playerIndexesCount; ++var2) {
            var3 = class93.playerIndices[var2];
            if((class93.field1411[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class93.field1411[var3] = (byte)(class93.field1411[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = World.method1642(var0);
                     class93.field1411[var3] = (byte)(class93.field1411[var3] | 2);
                  } else {
                     FrameMap.decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class93.field1416; ++var2) {
               var3 = class93.field1418[var2];
               if((class93.field1411[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class93.field1411[var3] = (byte)(class93.field1411[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = World.method1642(var0);
                        class93.field1411[var3] = (byte)(class93.field1411[var3] | 2);
                     } else if(ScriptVarType.decodeRegionHash(var0, var3)) {
                        class93.field1411[var3] = (byte)(class93.field1411[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class93.field1416; ++var2) {
                  var3 = class93.field1418[var2];
                  if((class93.field1411[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class93.field1411[var3] = (byte)(class93.field1411[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = World.method1642(var0);
                           class93.field1411[var3] = (byte)(class93.field1411[var3] | 2);
                        } else if(ScriptVarType.decodeRegionHash(var0, var3)) {
                           class93.field1411[var3] = (byte)(class93.field1411[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class93.playerIndexesCount = 0;
                  class93.field1416 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class93.field1411[var2] = (byte)(class93.field1411[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class93.playerIndices[++class93.playerIndexesCount - 1] = var2;
                     } else {
                        class93.field1418[++class93.field1416 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(IZZZI)Ljs;",
      garbageValue = "1008043309"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class167.dat2File != null) {
         var4 = new IndexFile(var0, class167.dat2File, class167.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, GameCanvas.indexStore255, var0, var1, var2, var3);
   }
}
