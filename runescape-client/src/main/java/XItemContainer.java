import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1541875845
   )
   static int field120;
   @ObfuscatedName("c")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("n")
   @Export("stackSizes")
   int[] stackSizes;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -500558161
   )
   protected static int field130;
   @ObfuscatedName("d")
   @Export("itemContainers")
   static XHashTable itemContainers;

   XItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   static {
      itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1306213096"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method923(var0, var1, var2, var3);
      class47.field924.method2729(var5, (long)var5.id);
      class47.field927.method2883(var5);
      Client.field477 = Client.field311;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;II)Lclass163;",
      garbageValue = "2131850693"
   )
   static class163 method164(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method3300(var1);
      return var2 == null?null:new class163(var2);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "79"
   )
   static final void method167() {
      int var0 = Client.field346 + class22.localPlayer.x;
      int var1 = class22.localPlayer.y + Client.field526;
      if(field120 - var0 < -500 || field120 - var0 > 500 || class8.field79 - var1 < -500 || class8.field79 - var1 > 500) {
         field120 = var0;
         class8.field79 = var1;
      }

      if(var0 != field120) {
         field120 += (var0 - field120) / 16;
      }

      if(class8.field79 != var1) {
         class8.field79 += (var1 - class8.field79) / 16;
      }

      int var2;
      int var3;
      if(class115.field1799 == 4 && CombatInfo1.field662) {
         var2 = class115.field1806 - Client.field371;
         Client.field470 = var2 * 2;
         Client.field371 = var2 != -1 && var2 != 1?(class115.field1806 + Client.field371) / 2:class115.field1806;
         var3 = Client.field370 - class115.field1805;
         Client.field373 = var3 * 2;
         Client.field370 = var3 != -1 && var3 != 1?(Client.field370 + class115.field1805) / 2:class115.field1805;
      } else {
         if(class105.field1695[96]) {
            Client.field373 += (-24 - Client.field373) / 2;
         } else if(class105.field1695[97]) {
            Client.field373 += (24 - Client.field373) / 2;
         } else {
            Client.field373 /= 2;
         }

         if(class105.field1695[98]) {
            Client.field470 += (12 - Client.field470) / 2;
         } else if(class105.field1695[99]) {
            Client.field470 += (-12 - Client.field470) / 2;
         } else {
            Client.field470 /= 2;
         }

         Client.field371 = class115.field1806;
         Client.field370 = class115.field1805;
      }

      Client.mapAngle = Client.mapAngle + Client.field373 / 2 & 2047;
      Client.field366 += Client.field470 / 2;
      if(Client.field366 < 128) {
         Client.field366 = 128;
      }

      if(Client.field366 > 383) {
         Client.field366 = 383;
      }

      var2 = field120 >> 7;
      var3 = class8.field79 >> 7;
      int var4 = CombatInfo1.method600(field120, class8.field79, Client.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = Client.plane;
               if(var8 < 3 && (class10.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class10.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field375) {
         Client.field375 += (var6 - Client.field375) / 24;
      } else if(var6 < Client.field375) {
         Client.field375 += (var6 - Client.field375) / 80;
      }

   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1882995521"
   )
   static final String method168(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class213.method4037('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class213.method4037(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class213.method4037(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1246907857"
   )
   public static void method169(Component var0) {
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1711 = -1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "0"
   )
   public static int method171(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-704586151"
   )
   public static boolean method172(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1569297193"
   )
   public static int method173(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("d")
   public static String method174(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class212.field3140[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("c")
   public static String method175(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class212.field3140[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
