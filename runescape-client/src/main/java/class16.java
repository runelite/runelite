import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class16 extends class131 {
   @ObfuscatedName("n")
   static Widget field181;
   @ObfuscatedName("c")
   String field182;
   @ObfuscatedName("f")
   short field183;
   @ObfuscatedName("x")
   static int[] field184;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -315384659
   )
   public static int field186;
   @ObfuscatedName("ck")
   static Font field187;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2120641935
   )
   int field191 = (int)(class2.method27() / 1000L);

   class16(String var1, int var2) {
      this.field182 = var1;
      this.field183 = (short)var2;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-380909538"
   )
   static void method156(int var0) {
      if(var0 == -1 && !Client.field531) {
         class211.method3825();
      } else if(var0 != -1 && Client.field530 != var0 && Client.field529 != 0 && !Client.field531) {
         class184 var1 = class164.field2170;
         int var2 = Client.field529;
         class138.field1933 = 1;
         ChatLineBuffer.field967 = var1;
         GroundObject.field1298 = var0;
         class207.field3097 = 0;
         class138.field1921 = var2;
         class138.field1927 = false;
         class138.field1926 = 2;
      }

      Client.field530 = var0;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-157755033"
   )
   static final void method157(boolean var0) {
      Client.field416 = 0;
      Client.field334 = 0;
      Client.field352.method2982();
      int var1 = Client.field352.method2973(8);
      int var2;
      if(var1 < Client.field332) {
         for(var2 = var1; var2 < Client.field332; ++var2) {
            Client.field521[++Client.field416 - 1] = Client.field333[var2];
         }
      }

      if(var1 > Client.field332) {
         throw new RuntimeException("");
      } else {
         Client.field332 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         for(var2 = 0; var2 < var1; ++var2) {
            int var13 = Client.field333[var2];
            NPC var4 = Client.cachedNPCs[var13];
            var5 = Client.field352.method2973(1);
            if(var5 == 0) {
               Client.field333[++Client.field332 - 1] = var13;
               var4.field653 = Client.gameCycle;
            } else {
               var6 = Client.field352.method2973(2);
               if(var6 == 0) {
                  Client.field333[++Client.field332 - 1] = var13;
                  var4.field653 = Client.gameCycle;
                  Client.field335[++Client.field334 - 1] = var13;
               } else if(var6 == 1) {
                  Client.field333[++Client.field332 - 1] = var13;
                  var4.field653 = Client.gameCycle;
                  var7 = Client.field352.method2973(3);
                  var4.method696(var7, (byte)1);
                  var8 = Client.field352.method2973(1);
                  if(var8 == 1) {
                     Client.field335[++Client.field334 - 1] = var13;
                  }
               } else if(var6 == 2) {
                  Client.field333[++Client.field332 - 1] = var13;
                  var4.field653 = Client.gameCycle;
                  var7 = Client.field352.method2973(3);
                  var4.method696(var7, (byte)2);
                  var8 = Client.field352.method2973(3);
                  var4.method696(var8, (byte)2);
                  var9 = Client.field352.method2973(1);
                  if(var9 == 1) {
                     Client.field335[++Client.field334 - 1] = var13;
                  }
               } else if(var6 == 3) {
                  Client.field521[++Client.field416 - 1] = var13;
               }
            }
         }

         class5.method69(var0);

         for(var1 = 0; var1 < Client.field334; ++var1) {
            var2 = Client.field335[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var14 = Client.field352.readUnsignedByte();
            if((var14 & 64) != 0) {
               var5 = Client.field352.method2759();
               var6 = Client.field352.method2759();
               var7 = var3.x - (var5 - class22.baseX - class22.baseX) * 64;
               var8 = var3.y - 64 * (var6 - class103.baseY - class103.baseY);
               if(var7 != 0 || var8 != 0) {
                  var3.field632 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }

            if((var14 & 1) != 0) {
               var3.overhead = Client.field352.method2911();
               var3.field649 = 100;
            }

            if((var14 & 32) != 0) {
               var3.interacting = Client.field352.method2757();
               if(var3.interacting == '\uffff') {
                  var3.interacting = -1;
               }
            }

            if((var14 & 2) != 0) {
               var3.graphic = Client.field352.method2757();
               var5 = Client.field352.method2826();
               var3.field631 = var5 >> 16;
               var3.field604 = (var5 & '\uffff') + Client.gameCycle;
               var3.field642 = 0;
               var3.field643 = 0;
               if(var3.field604 > Client.gameCycle) {
                  var3.field642 = -1;
               }

               if(var3.graphic == '\uffff') {
                  var3.graphic = -1;
               }
            }

            if((var14 & 4) != 0) {
               var5 = Client.field352.readUnsignedByte();
               int var10;
               int var11;
               if(var5 > 0) {
                  for(var6 = 0; var6 < var5; ++var6) {
                     var8 = -1;
                     var9 = -1;
                     var10 = -1;
                     var7 = Client.field352.method2735();
                     if(var7 == 32767) {
                        var7 = Client.field352.method2735();
                        var9 = Client.field352.method2735();
                        var8 = Client.field352.method2735();
                        var10 = Client.field352.method2735();
                     } else if(var7 != 32766) {
                        var9 = Client.field352.method2735();
                     } else {
                        var7 = -1;
                     }

                     var11 = Client.field352.method2735();
                     var3.method577(var7, var9, var8, var10, Client.gameCycle, var11);
                  }
               }

               var6 = Client.field352.readUnsignedByte();
               if(var6 > 0) {
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = Client.field352.method2735();
                     var9 = Client.field352.method2735();
                     if(var9 != 32767) {
                        var10 = Client.field352.method2735();
                        var11 = Client.field352.method2763();
                        int var12 = var9 > 0?Client.field352.method2763():var11;
                        var3.method578(var8, Client.gameCycle, var9, var10, var11, var12);
                     } else {
                        var3.method580(var8);
                     }
                  }
               }
            }

            if((var14 & 8) != 0) {
               var3.composition = Buffer.getNpcDefinition(Client.field352.method2757());
               var3.field645 = var3.composition.field3010;
               var3.field646 = var3.composition.field3014;
               var3.field636 = var3.composition.field3016;
               var3.field613 = var3.composition.field3017;
               var3.field614 = var3.composition.field3018;
               var3.field615 = var3.composition.field3019;
               var3.idlePoseAnimation = var3.composition.field3013;
               var3.field610 = var3.composition.field3036;
               var3.field611 = var3.composition.field3033;
            }

            if((var14 & 16) != 0) {
               var5 = Client.field352.method2759();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = Client.field352.readUnsignedByte();
               if(var5 == var3.animation && var5 != -1) {
                  var7 = class110.getAnimation(var5).replyMode;
                  if(var7 == 1) {
                     var3.actionFrame = 0;
                     var3.field638 = 0;
                     var3.actionAnimationDisable = var6;
                     var3.field640 = 0;
                  }

                  if(var7 == 2) {
                     var3.field640 = 0;
                  }
               } else if(var5 == -1 || var3.animation == -1 || class110.getAnimation(var5).forcedPriority >= class110.getAnimation(var3.animation).forcedPriority) {
                  var3.animation = var5;
                  var3.actionFrame = 0;
                  var3.field638 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field640 = 0;
                  var3.field663 = var3.field658;
               }
            }
         }

         for(var1 = 0; var1 < Client.field416; ++var1) {
            var2 = Client.field521[var1];
            if(Client.gameCycle != Client.cachedNPCs[var2].field653) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field339 != Client.field352.offset) {
            throw new RuntimeException(Client.field352.offset + "," + Client.field339);
         } else {
            for(var1 = 0; var1 < Client.field332; ++var1) {
               if(Client.cachedNPCs[Client.field333[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field332);
               }
            }

         }
      }
   }
}
