import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public final class class126 {
   @ObfuscatedName("v")
   int[] field2078 = new int[256];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2100768241
   )
   int field2080;
   @ObfuscatedName("m")
   int[] field2081 = new int[256];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1315070559
   )
   int field2082;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2046890481
   )
   int field2083;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1618901099
   )
   int field2084;
   @ObfuscatedName("kw")
   @Export("chatMessages")
   static ChatMessages chatMessages;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1191325526"
   )
   final int method2792() {
      if(--this.field2080 + 1 == 0) {
         this.method2793();
         this.field2080 = 255;
      }

      return this.field2078[this.field2080];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
   )
   final void method2793() {
      this.field2084 += ++this.field2082;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2081[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2083 ^= this.field2083 << 13;
            } else {
               this.field2083 ^= this.field2083 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2083 ^= this.field2083 << 2;
         } else {
            this.field2083 ^= this.field2083 >>> 16;
         }

         this.field2083 += this.field2081[var1 + 128 & 255];
         int var3;
         this.field2081[var1] = var3 = this.field2084 + this.field2083 + this.field2081[(var2 & 1020) >> 2];
         this.field2078[var1] = this.field2084 = this.field2081[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "13672"
   )
   final void method2794() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2078[var1];
         var3 += this.field2078[var1 + 1];
         var4 += this.field2078[var1 + 2];
         var5 += this.field2078[3 + var1];
         var6 += this.field2078[4 + var1];
         var7 += this.field2078[5 + var1];
         var8 += this.field2078[var1 + 6];
         var9 += this.field2078[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2081[var1] = var2;
         this.field2081[1 + var1] = var3;
         this.field2081[2 + var1] = var4;
         this.field2081[var1 + 3] = var5;
         this.field2081[4 + var1] = var6;
         this.field2081[5 + var1] = var7;
         this.field2081[var1 + 6] = var8;
         this.field2081[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2081[var1];
         var3 += this.field2081[1 + var1];
         var4 += this.field2081[2 + var1];
         var5 += this.field2081[var1 + 3];
         var6 += this.field2081[var1 + 4];
         var7 += this.field2081[5 + var1];
         var8 += this.field2081[var1 + 6];
         var9 += this.field2081[7 + var1];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2081[var1] = var2;
         this.field2081[1 + var1] = var3;
         this.field2081[var1 + 2] = var4;
         this.field2081[var1 + 3] = var5;
         this.field2081[var1 + 4] = var6;
         this.field2081[5 + var1] = var7;
         this.field2081[6 + var1] = var8;
         this.field2081[7 + var1] = var9;
      }

      this.method2793();
      this.field2080 = 256;
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "-761181533"
   )
   static final void method2797(Player var0, int var1, int var2, int var3) {
      if(class34.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.field37 == 0) {
               String var11 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = class34.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var10;
               if(var9 < -9) {
                  var10 = class92.method2126(16711680);
               } else if(var9 < -6) {
                  var10 = class92.method2126(16723968);
               } else if(var9 < -3) {
                  var10 = class92.method2126(16740352);
               } else if(var9 < 0) {
                  var10 = class92.method2126(16756736);
               } else if(var9 > 9) {
                  var10 = class92.method2126('\uff00');
               } else if(var9 > 6) {
                  var10 = class92.method2126(4259584);
               } else if(var9 > 3) {
                  var10 = class92.method2126(8453888);
               } else if(var9 > 0) {
                  var10 = class92.method2126(12648192);
               } else {
                  var10 = class92.method2126(16776960);
               }

               var4 = var11 + var10 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field37 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field432 == 1) {
               Player.addMenuEntry("Use", Client.field433 + " " + "->" + " " + class92.method2126(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field434) {
               if((class221.field3210 & 8) == 8) {
                  Player.addMenuEntry(Client.field492, Client.field438 + " " + "->" + " " + class92.method2126(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(null != Client.field408[var5]) {
                     short var6 = 0;
                     if(Client.field408[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field510 == class21.field578) {
                           continue;
                        }

                        if(Client.field510 == class21.field579 || class21.field581 == Client.field510 && var0.combatLevel > class34.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class34.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class34.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.field368[var5]) {
                        var6 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.field407[var5] + var6;
                     Player.addMenuEntry(Client.field408[var5], class92.method2126(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class92.method2126(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   class126(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2078[var2] = var1[var2];
      }

      this.method2794();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILclass110;LCollisionData;I)Z",
      garbageValue = "-1907955008"
   )
   public static final boolean method2802(int var0, int var1, class110 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class109.field1927[var6][var7] = 99;
      class109.field1925[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class109.field1932[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class109.field1933[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class109.field1932[var11];
         var5 = class109.field1933[var11];
         var11 = 1 + var11 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2401(1, var4, var5, var3)) {
            FileOnDisk.field3264 = var4;
            class109.field1929 = var5;
            return true;
         }

         int var15 = 1 + class109.field1925[var16][var17];
         if(var16 > 0 && class109.field1927[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class109.field1932[var18] = var4 - 1;
            class109.field1933[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1927[var16 - 1][var17] = 2;
            class109.field1925[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class109.field1927[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class109.field1932[var18] = 1 + var4;
            class109.field1933[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1927[1 + var16][var17] = 8;
            class109.field1925[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class109.field1927[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1932[var18] = var4;
            class109.field1933[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1927[var16][var17 - 1] = 1;
            class109.field1925[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class109.field1927[var16][var17 + 1] == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1932[var18] = var4;
            class109.field1933[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class109.field1927[var16][1 + var17] = 4;
            class109.field1925[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class109.field1927[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1932[var18] = var4 - 1;
            class109.field1933[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1927[var16 - 1][var17 - 1] = 3;
            class109.field1925[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class109.field1927[1 + var16][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1932[var18] = 1 + var4;
            class109.field1933[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1927[1 + var16][var17 - 1] = 9;
            class109.field1925[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class109.field1927[var16 - 1][1 + var17] == 0 && (var12[var13 - 1][1 + var14] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1932[var18] = var4 - 1;
            class109.field1933[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class109.field1927[var16 - 1][1 + var17] = 6;
            class109.field1925[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class109.field1927[1 + var16][var17 + 1] == 0 && (var12[var13 + 1][1 + var14] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1932[var18] = var4 + 1;
            class109.field1933[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class109.field1927[1 + var16][var17 + 1] = 12;
            class109.field1925[var16 + 1][1 + var17] = var15;
         }
      }

      FileOnDisk.field3264 = var4;
      class109.field1929 = var5;
      return false;
   }
}
