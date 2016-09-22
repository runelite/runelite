import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("ki")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("d")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -997026389
   )
   @Export("world")
   int world;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 148607411
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("z")
   boolean field240;
   @ObfuscatedName("t")
   boolean field241;
   @ObfuscatedName("du")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("a")
   @Export("name")
   String name;

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1550352504"
   )
   static final void method188() {
      int var0 = VertexNormal.menuX;
      int var1 = class14.menuY;
      int var2 = class85.menuWidth;
      int var3 = Renderable.menuHeight;
      int var4 = 6116423;
      class82.method1883(var0, var1, var2, var3, var4);
      class82.method1883(var0 + 1, 1 + var1, var2 - 2, 16, 0);
      class82.method1834(1 + var0, var1 + 18, var2 - 2, var3 - 19, 0);
      Frames.field1850.method4157("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class143.field2225;
      int var6 = class143.field2222;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = 31 + var1 + 15 * (Client.menuOptionCount - 1 - var7);
         int var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < 3 + var8) {
            var9 = 16776960;
         }

         Frames.field1850.method4157(class16.method182(var7), var0 + 3, var8, var9, 0);
      }

      class152.method3180(VertexNormal.menuX, class14.menuY, class85.menuWidth, Renderable.menuHeight);
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-690015451"
   )
   static String method189(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field281 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field281 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field281 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field281 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field281 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != Client.field287) {
         var3 = "/p=" + Client.field287;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field489 + "/a=" + class144.field2237 + var3 + "/";
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "-1902243766"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field1011.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class212.field3174.method3309(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method900(new Buffer(var2));
         }

         var1.method902();
         Sequence.field1011.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-13"
   )
   static void method191() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[1 + var3];
                  Client.menuTargets[var3] = Client.menuTargets[1 + var3];
                  Client.menuTypes[var3] = Client.menuTypes[1 + var3];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;I)V",
      garbageValue = "701389111"
   )
   static final void method192(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      if(var4 != null) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class94.field1670[var6];
            int var9 = class94.field1676[var6];
            var8 = var8 * 256 / (256 + Client.mapScaleDelta);
            var9 = 256 * var9 / (Client.mapScaleDelta + 256);
            int var10 = var8 * var3 + var9 * var2 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method1756(var5.field2959 / 2 + var10 - var4.field1481 / 2, var5.field2964 / 2 - var11 - var4.field1482 / 2, var0, var1, var5.field2959, var5.field2964, var5.field2961, var5.field2960);
            } else {
               var4.method1746(var10 + var0 + var5.field2959 / 2 - var4.field1481 / 2, var5.field2964 / 2 + var1 - var11 - var4.field1482 / 2);
            }

         }
      }
   }
}
