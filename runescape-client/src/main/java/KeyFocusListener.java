import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -650949759
   )
   static int field634;
   @ObfuscatedName("cc")
   static int[] field639;
   @ObfuscatedName("cg")
   public static boolean[] field631;
   @ObfuscatedName("cn")
   static int[] field642;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 482323787
   )
   static int field626;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -738419315
   )
   static int field636;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 816437709
   )
   static int field630;
   @ObfuscatedName("cx")
   static char[] field635;
   @ObfuscatedName("cb")
   static int[] field633;
   @ObfuscatedName("ck")
   public static int[] field637;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1572200691
   )
   public static int field643;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -755767081
   )
   static int field618;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1991361017
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks;

   static {
      keyboard = new KeyFocusListener();
      field631 = new boolean[112];
      field642 = new int[128];
      field626 = 0;
      field634 = 0;
      field635 = new char[128];
      field633 = new int[128];
      field637 = new int[128];
      field643 = 0;
      field630 = 0;
      field636 = 0;
      field618 = 0;
      keyboardIdleTicks = 0;
      field639 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field639.length) {
            var2 = field639[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field634 >= 0 && var2 >= 0) {
            field642[field634] = ~var2;
            field634 = field634 + 1 & 127;
            if(field634 == field626) {
               field634 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class218.method4056(var2)) {
            int var3 = field636 + 1 & 127;
            if(var3 != field630) {
               field633[field636] = -1;
               field635[field636] = var2;
               field636 = var3;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field634 = -1;
      }

   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field639.length) {
            var2 = field639[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field634 >= 0 && var2 >= 0) {
            field642[field634] = var2;
            field634 = field634 + 1 & 127;
            if(field626 == field634) {
               field634 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field636 + 1 & 127;
            if(var3 != field630) {
               field633[field636] = var2;
               field635[field636] = 0;
               field636 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIB)I",
      garbageValue = "4"
   )
   public static int method754(byte[] var0, int var1) {
      int var3 = -1;

      for(int var4 = 0; var4 < var1; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-1"
   )
   static final void method765(boolean var0) {
      while(true) {
         if(Client.secretPacketBuffer2.bitsAvail(Client.packetLength) >= 27) {
            int var1 = Client.secretPacketBuffer2.getBits(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.npcIndices[++Client.field952 - 1] = var1;
               var3.field1245 = Client.gameCycle;
               var3.composition = class19.getNpcDefinition(Client.secretPacketBuffer2.getBits(14));
               int var4 = Client.field1030[Client.secretPacketBuffer2.getBits(3)];
               if(var2) {
                  var3.orientation = var3.angle = var4;
               }

               int var5;
               if(var0) {
                  var5 = Client.secretPacketBuffer2.getBits(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = Client.secretPacketBuffer2.getBits(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6 = Client.secretPacketBuffer2.getBits(1);
               if(var6 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var1;
               }

               int var7;
               if(var0) {
                  var7 = Client.secretPacketBuffer2.getBits(8);
                  if(var7 > 127) {
                     var7 -= 256;
                  }
               } else {
                  var7 = Client.secretPacketBuffer2.getBits(5);
                  if(var7 > 15) {
                     var7 -= 32;
                  }
               }

               int var8 = Client.secretPacketBuffer2.getBits(1);
               var3.field1254 = var3.composition.field3547;
               var3.field1229 = var3.composition.field3570;
               if(var3.field1229 == 0) {
                  var3.angle = 0;
               }

               var3.field1241 = var3.composition.field3553;
               var3.field1214 = var3.composition.field3554;
               var3.field1249 = var3.composition.field3548;
               var3.field1211 = var3.composition.field3556;
               var3.idlePoseAnimation = var3.composition.field3550;
               var3.field1227 = var3.composition.field3551;
               var3.field1212 = var3.composition.field3546;
               var3.method1709(class54.localPlayer.pathX[0] + var5, class54.localPlayer.pathY[0] + var7, var8 == 1);
               continue;
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         return;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "2072305348"
   )
   static File method767(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class156.field2228 = new File(class33.userHome, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class156.field2228.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class156.field2228, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.length()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.read(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.getJagString();
               if(var10 == 1) {
                  var5 = var8.getJagString();
               }
            } else {
               var4 = var8.getCESU8();
               if(var10 == 1) {
                  var5 = var8.getCESU8();
               }
            }

            var7.close();
         } catch (IOException var20) {
            var20.printStackTrace();
         }

         if(var4 != null) {
            var22 = new File(var4);
            if(!var22.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var22 = new File(var4, "test.dat");
            if(!class74.method1141(var22, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label124:
         for(int var15 = 0; var15 < class262.field3617.length; ++var15) {
            for(int var16 = 0; var16 < class156.cacheLocations.length; ++var16) {
               File var17 = new File(class156.cacheLocations[var16] + class262.field3617[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && class74.method1141(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label124;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class33.userHome + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(var5 != null) {
         File var21 = new File(var5);
         var22 = new File(var4);

         try {
            File[] var23 = var21.listFiles();
            File[] var18 = var23;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var22, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         World.method1593(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
