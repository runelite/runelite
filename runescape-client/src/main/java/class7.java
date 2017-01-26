import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
final class class7 implements Comparator {
   @ObfuscatedName("as")
   static class184 field65;

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-832205938"
   )
   static final void method100(boolean var0) {
      Client.field402 = 0;
      Client.field554 = 0;
      Client.field323.method3054();
      int var1 = Client.field323.method3061(8);
      int var2;
      if(var1 < Client.field316) {
         for(var2 = var1; var2 < Client.field316; ++var2) {
            Client.field403[++Client.field402 - 1] = Client.field419[var2];
         }
      }

      if(var1 > Client.field316) {
         throw new RuntimeException("");
      } else {
         Client.field316 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.field419[var2];
            NPC var4 = Client.cachedNPCs[var3];
            var5 = Client.field323.method3061(1);
            if(var5 == 0) {
               Client.field419[++Client.field316 - 1] = var3;
               var4.field641 = Client.gameCycle;
            } else {
               var6 = Client.field323.method3061(2);
               if(var6 == 0) {
                  Client.field419[++Client.field316 - 1] = var3;
                  var4.field641 = Client.gameCycle;
                  Client.field319[++Client.field554 - 1] = var3;
               } else if(var6 == 1) {
                  Client.field419[++Client.field316 - 1] = var3;
                  var4.field641 = Client.gameCycle;
                  var7 = Client.field323.method3061(3);
                  var4.method710(var7, (byte)1);
                  var8 = Client.field323.method3061(1);
                  if(var8 == 1) {
                     Client.field319[++Client.field554 - 1] = var3;
                  }
               } else if(var6 == 2) {
                  Client.field419[++Client.field316 - 1] = var3;
                  var4.field641 = Client.gameCycle;
                  var7 = Client.field323.method3061(3);
                  var4.method710(var7, (byte)2);
                  var8 = Client.field323.method3061(3);
                  var4.method710(var8, (byte)2);
                  var9 = Client.field323.method3061(1);
                  if(var9 == 1) {
                     Client.field319[++Client.field554 - 1] = var3;
                  }
               } else if(var6 == 3) {
                  Client.field403[++Client.field402 - 1] = var3;
               }
            }
         }

         NPC var13;
         int var14;
         while(Client.field323.method3044(Client.field541) >= 27) {
            var1 = Client.field323.method3061(15);
            if(var1 == 32767) {
               break;
            }

            boolean var15 = false;
            if(Client.cachedNPCs[var1] == null) {
               Client.cachedNPCs[var1] = new NPC();
               var15 = true;
            }

            var13 = Client.cachedNPCs[var1];
            Client.field419[++Client.field316 - 1] = var1;
            var13.field641 = Client.gameCycle;
            var13.composition = Tile.getNpcDefinition(Client.field323.method3061(14));
            var14 = Client.field323.method3061(1);
            if(var14 == 1) {
               Client.field319[++Client.field554 - 1] = var1;
            }

            var5 = Client.field323.method3061(1);
            if(var0) {
               var6 = Client.field323.method3061(8);
               if(var6 > 127) {
                  var6 -= 256;
               }
            } else {
               var6 = Client.field323.method3061(5);
               if(var6 > 15) {
                  var6 -= 32;
               }
            }

            if(var0) {
               var7 = Client.field323.method3061(8);
               if(var7 > 127) {
                  var7 -= 256;
               }
            } else {
               var7 = Client.field323.method3061(5);
               if(var7 > 15) {
                  var7 -= 32;
               }
            }

            var8 = Client.field418[Client.field323.method3061(3)];
            if(var15) {
               var13.field643 = var13.angle = var8;
            }

            var13.field596 = var13.composition.field2999;
            var13.field645 = var13.composition.field2993;
            if(var13.field645 == 0) {
               var13.angle = 0;
            }

            var13.field600 = var13.composition.field3005;
            var13.field601 = var13.composition.field3006;
            var13.field602 = var13.composition.field3007;
            var13.field603 = var13.composition.field3008;
            var13.idlePoseAnimation = var13.composition.field3022;
            var13.field598 = var13.composition.field3003;
            var13.field599 = var13.composition.field3018;
            var13.method700(class16.localPlayer.pathX[0] + var7, class16.localPlayer.pathY[0] + var6, var5 == 1);
         }

         Client.field323.method3043();

         for(var1 = 0; var1 < Client.field554; ++var1) {
            var2 = Client.field319[var1];
            var13 = Client.cachedNPCs[var2];
            var14 = Client.field323.readUnsignedByte();
            if((var14 & 8) != 0) {
               var5 = Client.field323.method2954();
               int var10;
               int var11;
               if(var5 > 0) {
                  for(var6 = 0; var6 < var5; ++var6) {
                     var8 = -1;
                     var9 = -1;
                     var10 = -1;
                     var7 = Client.field323.method2979();
                     if(var7 == 32767) {
                        var7 = Client.field323.method2979();
                        var9 = Client.field323.method2979();
                        var8 = Client.field323.method2979();
                        var10 = Client.field323.method2979();
                     } else if(var7 != 32766) {
                        var9 = Client.field323.method2979();
                     } else {
                        var7 = -1;
                     }

                     var11 = Client.field323.method2979();
                     var13.method592(var7, var9, var8, var10, Client.gameCycle, var11);
                  }
               }

               var6 = Client.field323.readUnsignedByte();
               if(var6 > 0) {
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = Client.field323.method2979();
                     var9 = Client.field323.method2979();
                     if(var9 != 32767) {
                        var10 = Client.field323.method2979();
                        var11 = Client.field323.readUnsignedByte();
                        int var12 = var9 > 0?Client.field323.method2842():var11;
                        var13.method587(var8, Client.gameCycle, var9, var10, var11, var12);
                     } else {
                        var13.method584(var8);
                     }
                  }
               }
            }

            if((var14 & 64) != 0) {
               var5 = Client.field323.method2933();
               var6 = Client.field323.method2933();
               var7 = var13.x - (var5 - Projectile.baseX - Projectile.baseX) * 64;
               var8 = var13.y - 64 * (var6 - class3.baseY - class3.baseY);
               if(var7 != 0 || var8 != 0) {
                  var13.field620 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }

            if((var14 & 2) != 0) {
               var13.interacting = Client.field323.method2827();
               if(var13.interacting == '\uffff') {
                  var13.interacting = -1;
               }
            }

            if((var14 & 16) != 0) {
               var13.composition = Tile.getNpcDefinition(Client.field323.readUnsignedShort());
               var13.field596 = var13.composition.field2999;
               var13.field645 = var13.composition.field2993;
               var13.field600 = var13.composition.field3005;
               var13.field601 = var13.composition.field3006;
               var13.field602 = var13.composition.field3007;
               var13.field603 = var13.composition.field3008;
               var13.idlePoseAnimation = var13.composition.field3022;
               var13.field598 = var13.composition.field3003;
               var13.field599 = var13.composition.field3018;
            }

            if((var14 & 4) != 0) {
               var13.overhead = Client.field323.method2846();
               var13.field608 = 100;
            }

            if((var14 & 32) != 0) {
               var13.graphic = Client.field323.readUnsignedShort();
               var5 = Client.field323.method2831();
               var13.field633 = var5 >> 16;
               var13.field618 = (var5 & '\uffff') + Client.gameCycle;
               var13.field630 = 0;
               var13.field631 = 0;
               if(var13.field618 > Client.gameCycle) {
                  var13.field630 = -1;
               }

               if(var13.graphic == '\uffff') {
                  var13.graphic = -1;
               }
            }

            if((var14 & 1) != 0) {
               var5 = Client.field323.method2827();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = Client.field323.method2848();
               if(var13.animation == var5 && var5 != -1) {
                  var7 = class146.getAnimation(var5).replyMode;
                  if(var7 == 1) {
                     var13.actionFrame = 0;
                     var13.field626 = 0;
                     var13.actionAnimationDisable = var6;
                     var13.field648 = 0;
                  }

                  if(var7 == 2) {
                     var13.field648 = 0;
                  }
               } else if(var5 == -1 || var13.animation == -1 || class146.getAnimation(var5).forcedPriority >= class146.getAnimation(var13.animation).forcedPriority) {
                  var13.animation = var5;
                  var13.actionFrame = 0;
                  var13.field626 = 0;
                  var13.actionAnimationDisable = var6;
                  var13.field648 = 0;
                  var13.field651 = var13.field646;
               }
            }
         }

         for(var1 = 0; var1 < Client.field402; ++var1) {
            var2 = Client.field403[var1];
            if(Client.cachedNPCs[var2].field641 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field541 != Client.field323.offset) {
            throw new RuntimeException(Client.field323.offset + "," + Client.field541);
         } else {
            for(var1 = 0; var1 < Client.field316; ++var1) {
               if(null == Client.cachedNPCs[Client.field419[var1]]) {
                  throw new RuntimeException(var1 + "," + Client.field316);
               }
            }

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1723568536"
   )
   int method102(class2 var1, class2 var2) {
      return var1.field17 < var2.field17?-1:(var1.field17 == var2.field17?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2026093630"
   )
   static final int method113(int var0, int var1) {
      int var2 = class2.method23(var0 - 1, var1 - 1) + class2.method23(var0 + 1, var1 - 1) + class2.method23(var0 - 1, 1 + var1) + class2.method23(1 + var0, var1 + 1);
      int var3 = class2.method23(var0 - 1, var1) + class2.method23(1 + var0, var1) + class2.method23(var0, var1 - 1) + class2.method23(var0, 1 + var1);
      int var4 = class2.method23(var0, var1);
      return var4 / 4 + var2 / 16 + var3 / 8;
   }

   public int compare(Object var1, Object var2) {
      return this.method102((class2)var1, (class2)var2);
   }
}
