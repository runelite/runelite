import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public final class class61 {
   @ObfuscatedName("b")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("q")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1362033277
   )
   static int field686;
   @ObfuscatedName("p")
   static byte[][][] field687;
   @ObfuscatedName("r")
   static int[] field684;
   @ObfuscatedName("d")
   static int[] field692;
   @ObfuscatedName("x")
   static final int[] field690;
   @ObfuscatedName("w")
   static final int[] field691;
   @ObfuscatedName("j")
   static final int[] field694;
   @ObfuscatedName("z")
   static final int[] field693;
   @ObfuscatedName("e")
   static final int[] field689;
   @ObfuscatedName("k")
   static final int[] field695;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1902746247
   )
   static int field696;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1623015035
   )
   static int field685;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field686 = 99;
      field690 = new int[]{1, 2, 4, 8};
      field691 = new int[]{16, 32, 64, 128};
      field694 = new int[]{1, 0, -1, 0};
      field693 = new int[]{0, -1, 0, 1};
      field689 = new int[]{1, -1, -1, 1};
      field695 = new int[]{-1, -1, 1, 1};
      field696 = (int)(Math.random() * 17.0D) - 8;
      field685 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfe;Lgo;I)Lgc;",
      garbageValue = "-1181458349"
   )
   public static PacketNode method1076(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2;
      if(PacketNode.field2462 == 0) {
         var2 = new PacketNode();
      } else {
         var2 = PacketNode.packetBufferNodes[--PacketNode.field2462];
      }

      var2.clientPacket = var0;
      var2.field2458 = var0.packetLength;
      if(var2.field2458 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2458 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2458 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2458 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2460 = 0;
      return var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2138140533"
   )
   public static boolean method1064(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "1961272824"
   )
   static int method1097(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = NetWriter.getWidget(class80.intStack[--class80.intStackSize]);
      } else {
         var3 = var2?class223.field2643:class80.field1228;
      }

      String var4 = class80.scriptStringStack[--class43.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class80.intStack[--class80.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class80.intStack[--class80.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class80.scriptStringStack[--class43.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class80.intStack[--class80.intStackSize]);
         }
      }

      var7 = class80.intStack[--class80.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2859 = var8;
      } else if(var0 == 1401) {
         var3.field2841 = var8;
      } else if(var0 == 1402) {
         var3.field2861 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2906 = var8;
      } else if(var0 == 1406) {
         var3.field2869 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2877 = var8;
      } else if(var0 == 1410) {
         var3.field2867 = var8;
      } else if(var0 == 1411) {
         var3.field2766 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2868 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2879 = var8;
      } else if(var0 == 1419) {
         var3.field2880 = var8;
      } else if(var0 == 1420) {
         var3.field2881 = var8;
      } else if(var0 == 1421) {
         var3.field2882 = var8;
      } else if(var0 == 1422) {
         var3.field2830 = var8;
      } else if(var0 == 1423) {
         var3.field2884 = var8;
      } else if(var0 == 1424) {
         var3.field2900 = var8;
      } else if(var0 == 1425) {
         var3.field2778 = var8;
      } else if(var0 == 1426) {
         var3.field2796 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2886 = var8;
      }

      var3.field2857 = true;
      return 1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2098250386"
   )
   public static String method1062(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1077951125"
   )
   static final void method1055(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         NPCComposition.method5107(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1084 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
