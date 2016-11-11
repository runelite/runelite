import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("h")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("e")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("at")
   static class171 field233;
   @ObfuscatedName("j")
   static ModIcon field236;
   @ObfuscatedName("i")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1294010614"
   )
   static void method177() {
      Client.field378.offset = 0;
      Client.field347.offset = 0;
      Client.packetOpcode = -1;
      Client.field352 = 1;
      Client.field421 = -1;
      Client.field354 = -1;
      Client.field348 = 0;
      Client.field350 = 0;
      Client.field317 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field403 = 0;
      Client.flagX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class138.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(null != var1) {
            var1.interacting = -1;
            var1.field890 = false;
         }
      }

      class5.method87();
      class117.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field494[var0] = true;
      }

      class75.method1610();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2060364029"
   )
   static void method182(int var0, int var1) {
      if(Client.field513 != 0 && var0 != -1) {
         GroundObject.method2209(class5.field104, var0, 0, Client.field513, false);
         Client.field539 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-2064585199"
   )
   static final int method183(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = FileOnDisk.method4168(var3, var5);
      int var8 = FileOnDisk.method4168(var3 + 1, var5);
      int var9 = FileOnDisk.method4168(var3, var5 + 1);
      int var10 = FileOnDisk.method4168(var3 + 1, var5 + 1);
      int var12 = 65536 - class94.field1642[var4 * 1024 / var2] >> 1;
      int var11 = (var7 * (65536 - var12) >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - class94.field1642[1024 * var4 / var2] >> 1;
      int var13 = (var10 * var14 >> 16) + (var9 * (65536 - var14) >> 16);
      int var16 = 65536 - class94.field1642[1024 * var6 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var16 * var13 >> 16);
      return var15;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IZIZB)V",
      garbageValue = "0"
   )
   static void method184(int var0, boolean var1, int var2, boolean var3) {
      if(VertexNormal.worldList != null) {
         class158.method3191(0, VertexNormal.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "1841539346"
   )
   public static String method185(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var1 * var0;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "1665652541"
   )
   static void method186(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class221.field3219, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.method2529(3);
         var3.method2529(null != var1?1:0);
         var3.method2537(var0.getPath());
         if(null != var1) {
            var3.method2537("");
         }

         var2.method4153(var3.payload, 0, var3.offset);
         var2.method4156();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZB)I",
      garbageValue = "-48"
   )
   static int method187(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method596()?(var1.method596()?0:1):(var1.method596()?-1:0)):(var2 == 5?(var0.method617()?(var1.method617()?0:1):(var1.method617()?-1:0)):(var2 == 6?(var0.method622()?(var1.method622()?0:1):(var1.method622()?-1:0)):(var2 == 7?(var0.method593()?(var1.method593()?0:1):(var1.method593()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-82"
   )
   public static int method188(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + Item.method662(var0.charAt(var3));
      }

      return var2;
   }
}
