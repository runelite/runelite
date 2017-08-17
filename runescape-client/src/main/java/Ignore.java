import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("fi")
   static int[] field872;
   @ObfuscatedName("ax")
   static int[] field871;
   @ObfuscatedName("j")
   @Export("name")
   String name;
   @ObfuscatedName("h")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "49"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(BaseVarType.validInterfaces[var0]) {
         return true;
      } else if(!SoundTask.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = SoundTask.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            BaseVarType.validInterfaces[var0] = true;
            return true;
         } else {
            if(class176.widgets[var0] == null) {
               class176.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class176.widgets[var0][var2] == null) {
                  byte[] var3 = SoundTask.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     class176.widgets[var0][var2] = new Widget();
                     class176.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class176.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        class176.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            BaseVarType.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method1171() {
      VarPlayerType.varplayers.reset();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1828834929"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class67.listFetcher == null) {
            class67.listFetcher = class11.field264.method1151(new URL(class61.field777));
         } else if(class67.listFetcher.method1614()) {
            byte[] var0 = class67.listFetcher.method1617();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            World.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = World.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            ScriptEvent.method1163(World.worldList, 0, World.worldList.length - 1, World.field1293, World.field1292);
            class67.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class67.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfo;I)I",
      garbageValue = "-1077703136"
   )
   static int method1168(PacketBuffer var0) {
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
      signature = "(IIIZIZB)V",
      garbageValue = "55"
   )
   static void method1172(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = class36.method511(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class36.method511(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method1172(var0, var7 - 1, var2, var3, var4, var5);
         method1172(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-380545431"
   )
   static char method1167(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }
}
