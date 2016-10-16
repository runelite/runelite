import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class47 extends CacheableNode {
   @ObfuscatedName("z")
   public static NodeCache field1019 = new NodeCache(64);
   @ObfuscatedName("t")
   public boolean field1020 = false;
   @ObfuscatedName("id")
   static class32 field1022;
   @ObfuscatedName("bg")
   static class171 field1024;
   @ObfuscatedName("s")
   public static class170 field1026;
   @ObfuscatedName("bf")
   protected static FontMetrics field1028;
   @ObfuscatedName("h")
   static ModIcon field1030;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1953294948"
   )
   public void method943(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method944(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-472822643"
   )
   void method944(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1020 = true;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)LFileOnDisk;",
      garbageValue = "0"
   )
   public static FileOnDisk method945(String var0, String var1, boolean var2) {
      File var3 = new File(class152.field2273, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(GameEngine.field2232 == 33) {
         var4 = "_rc";
      } else if(GameEngine.field2232 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class92.field1598, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;B)V",
      garbageValue = "83"
   )
   static void method951(class227 var0, class227 var1) {
      if(class28.field651 == null) {
         class28.field651 = Client.method493(class152.field2281, "sl_back", "");
      }

      if(class137.field2114 == null) {
         class137.field2114 = ChatLineBuffer.method670(class152.field2281, "sl_flags", "");
      }

      if(null == class14.field195) {
         class14.field195 = ChatLineBuffer.method670(class152.field2281, "sl_arrows", "");
      }

      if(null == class113.field1983) {
         class113.field1983 = ChatLineBuffer.method670(class152.field2281, "sl_stars", "");
      }

      class82.method1801(class33.field715, 23, 765, 480, 0);
      class82.method1806(class33.field715, 0, 125, 23, 12425273, 9135624);
      class82.method1806(class33.field715 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4072("Select a world", class33.field715 + 62, 15, 0, -1);
      if(class113.field1983 != null) {
         class113.field1983[1].method1871(140 + class33.field715, 1);
         var1.method4032("Members only world", class33.field715 + 152, 10, 16777215, -1);
         class113.field1983[0].method1871(class33.field715 + 140, 12);
         var1.method4032("Free world", class33.field715 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class14.field195 != null) {
         int var2 = 280 + class33.field715;
         if(World.field633[0] == 0 && World.field632[0] == 0) {
            class14.field195[2].method1871(var2, 4);
         } else {
            class14.field195[0].method1871(var2, 4);
         }

         if(World.field633[0] == 0 && World.field632[0] == 1) {
            class14.field195[3].method1871(var2 + 15, 4);
         } else {
            class14.field195[1].method1871(15 + var2, 4);
         }

         var0.method4032("World", var2 + 32, 17, 16777215, -1);
         int var3 = 390 + class33.field715;
         if(World.field633[0] == 1 && World.field632[0] == 0) {
            class14.field195[2].method1871(var3, 4);
         } else {
            class14.field195[0].method1871(var3, 4);
         }

         if(World.field633[0] == 1 && World.field632[0] == 1) {
            class14.field195[3].method1871(15 + var3, 4);
         } else {
            class14.field195[1].method1871(15 + var3, 4);
         }

         var0.method4032("Players", 32 + var3, 17, 16777215, -1);
         var4 = 500 + class33.field715;
         if(World.field633[0] == 2 && World.field632[0] == 0) {
            class14.field195[2].method1871(var4, 4);
         } else {
            class14.field195[0].method1871(var4, 4);
         }

         if(World.field633[0] == 2 && World.field632[0] == 1) {
            class14.field195[3].method1871(15 + var4, 4);
         } else {
            class14.field195[1].method1871(var4 + 15, 4);
         }

         var0.method4032("Location", 32 + var4, 17, 16777215, -1);
         var5 = class33.field715 + 610;
         if(World.field633[0] == 3 && World.field632[0] == 0) {
            class14.field195[2].method1871(var5, 4);
         } else {
            class14.field195[0].method1871(var5, 4);
         }

         if(World.field633[0] == 3 && World.field632[0] == 1) {
            class14.field195[3].method1871(var5 + 15, 4);
         } else {
            class14.field195[1].method1871(15 + var5, 4);
         }

         var0.method4032("Type", 32 + var5, 17, 16777215, -1);
      }

      class82.method1801(class33.field715 + 708, 4, 50, 16, 0);
      var1.method4072("Cancel", class33.field715 + 708 + 25, 16, 16777215, -1);
      class33.field734 = -1;
      if(class28.field651 != null) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (1 + var23);
         var5 = 480 / (var24 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= World.field630) {
               --var4;
            }

            if((var5 - 1) * var4 >= World.field630) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.field630) {
               --var5;
            }
         } while(var5 != var6 || var4 != var7);

         var6 = (765 - var23 * var4) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var24) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var4 * var23 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var24 * var5 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = class33.field715 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field630; ++var14) {
            World var15 = World.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method642()) {
               if(var15.method607()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method631()) {
               var19 = 16711680;
               if(var15.method607()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method609()) {
               if(var15.method607()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method607()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class143.field2192 >= var11 && class143.field2189 >= var10 && class143.field2192 < var11 + var23 && class143.field2189 < var24 + var10 && var16) {
               class33.field734 = var14;
               class28.field651[var18].method1716(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class28.field651[var18].method1710(var11, var10);
            }

            if(null != class137.field2114) {
               class137.field2114[(var15.method607()?8:0) + var15.location].method1871(var11 + 29, var10);
            }

            var0.method4072(Integer.toString(var15.id), var11 + 15, var24 / 2 + var10 + 5, var19, -1);
            var1.method4072(var17, 60 + var11, 5 + var10 + var24 / 2, 268435455, -1);
            var10 += var7 + var24;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var6 + var23;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4027(World.worldList[class33.field734].activity) + 6;
            int var20 = var1.field3238 + 8;
            class82.method1801(class143.field2192 - var14 / 2, 5 + 20 + class143.field2189, var14, var20, 16777120);
            class82.method1815(class143.field2192 - var14 / 2, 5 + 20 + class143.field2189, var14, var20, 0);
            var1.method4072(World.worldList[class33.field734].activity, class143.field2192, 5 + class143.field2189 + 20 + var1.field3238 + 4, 0, -1);
         }
      }

      try {
         Graphics var21 = Frames.canvas.getGraphics();
         Player.bufferProvider.draw(var21, 0, 0);
      } catch (Exception var22) {
         Frames.canvas.repaint();
      }

   }
}
