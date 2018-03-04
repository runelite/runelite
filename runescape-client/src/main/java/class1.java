import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class1 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   static final class1 field6;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   static final class1 field1;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   static final class1 field2;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   static final class1 field10;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   static final class1 field3;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   static final class1 field5;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   static final class1 field0;
   @ObfuscatedName("aw")
   static int[] field11;
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 65410309
   )
   static int field9;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 531705127
   )
   final int field7;

   static {
      field6 = new class1(6);
      field1 = new class1(2);
      field2 = new class1(0);
      field10 = new class1(1);
      field3 = new class1(5);
      field5 = new class1(4);
      field0 = new class1(3);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-695158748"
   )
   public static File method5(String var0) {
      if(!class170.field2214) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class170.field2211.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class170.field2212, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class170.field2211.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1959582093"
   )
   static int method1(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "619278380"
   )
   static final void method3() {
      class243.method4617("You can\'t add yourself to your own friend list");
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(ZLgb;I)V",
      garbageValue = "-352159059"
   )
   @Hook("onNpcUpdate")
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field899.packetLength) >= 27) {
            int var2 = var1.getBits(15);
            if(var2 != 32767) {
               boolean var3 = false;
               if(Client.cachedNPCs[var2] == null) {
                  Client.cachedNPCs[var2] = new NPC();
                  var3 = true;
               }

               NPC var4 = Client.cachedNPCs[var2];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var4.npcCycle = Client.gameCycle;
               int var5 = Client.field976[var1.getBits(3)];
               if(var3) {
                  var4.orientation = var4.angle = var5;
               }

               int var6;
               if(var0) {
                  var6 = var1.getBits(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = var1.getBits(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7;
               if(var0) {
                  var7 = var1.getBits(8);
                  if(var7 > 127) {
                     var7 -= 256;
                  }
               } else {
                  var7 = var1.getBits(5);
                  if(var7 > 15) {
                     var7 -= 32;
                  }
               }

               var4.composition = class255.getNpcDefinition(var1.getBits(14));
               int var8 = var1.getBits(1);
               int var9 = var1.getBits(1);
               if(var9 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

               var4.field1193 = var4.composition.field3709;
               var4.field1183 = var4.composition.field3722;
               if(var4.field1183 == 0) {
                  var4.angle = 0;
               }

               var4.field1163 = var4.composition.field3731;
               var4.field1139 = var4.composition.field3728;
               var4.field1149 = var4.composition.field3717;
               var4.field1147 = var4.composition.field3734;
               var4.idlePoseAnimation = var4.composition.field3712;
               var4.field1145 = var4.composition.field3713;
               var4.field1148 = var4.composition.field3714;
               var4.method1866(TotalQuantityComparator.localPlayer.pathX[0] + var6, TotalQuantityComparator.localPlayer.pathY[0] + var7, var8 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "69"
   )
   static final void method0(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class18.loadWidget(var0)) {
         Signlink.field2184 = null;
         WorldComparator.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(Signlink.field2184 != null) {
            WorldComparator.gameDraw(Signlink.field2184, -1412584499, var1, var2, var3, var4, class86.field1308, ScriptState.field758, var7);
            Signlink.field2184 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1053[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1053[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Liw;B)Z",
      garbageValue = "-112"
   )
   static final boolean method2(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field886 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1009.method4518(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1009.method4515(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1009.method4513(false);
         }

         if(var1 == 325) {
            Client.field1009.method4513(true);
         }

         if(var1 == 326) {
            PacketNode var4 = class31.method285(ClientPacket.field2422, Client.field899.field1470);
            Client.field1009.method4531(var4.packetBuffer);
            Client.field899.method2082(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
