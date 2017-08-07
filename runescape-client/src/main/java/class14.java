import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class14 {
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -2023828309
   )
   static int field295;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("w")
   String field286;
   @ObfuscatedName("y")
   String field294;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 4452745623806105907L
   )
   public final long field287;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1328227701
   )
   public final int field293;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lm;"
   )
   public final XGrandExchangeOffer field288;

   @ObfuscatedSignature(
      signature = "(Lfh;BI)V"
   )
   class14(Buffer var1, byte var2, int var3) {
      this.field294 = var1.readString();
      this.field286 = var1.readString();
      this.field293 = var1.readUnsignedShort();
      this.field287 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field288 = new XGrandExchangeOffer();
      this.field288.method99(2);
      this.field288.method104(var2);
      this.field288.price = var4;
      this.field288.totalQuantity = var5;
      this.field288.quantitySold = 0;
      this.field288.spent = 0;
      this.field288.itemId = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "593795347"
   )
   public String method71() {
      return this.field294;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2101147266"
   )
   public String method75() {
      return this.field286;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-756749335"
   )
   public static int method81(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Ljp;",
      garbageValue = "-79363766"
   )
   public static IndexedSprite method80() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class287.field3775;
      var0.originalHeight = class287.field3776;
      var0.offsetX = class287.field3779[0];
      var0.offsetY = class277.offsetsY[0];
      var0.originalWidth = class287.field3778[0];
      var0.height = class277.field3719[0];
      var0.palette = class287.field3777;
      var0.pixels = class287.spritePixels[0];
      class262.method4747();
      return var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2136133003"
   )
   static int method70(int var0, int var1) {
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

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(Lhg;II)I",
      garbageValue = "1805452089"
   )
   static final int method78(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class266.method4862(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!ClassInfo.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class212.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class223.field2808[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class212.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class54.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class223.field2812[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class266.method4862(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!ClassInfo.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class212.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class209.method3887(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class54.localPlayer.x >> 7) + class25.baseX;
               }

               if(var6 == 19) {
                  var7 = (class54.localPlayer.y >> 7) + ScriptEvent.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfb;IB)V",
      garbageValue = "0"
   )
   static final void method79(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class97.field1500 = 0;
      Ignore.method1116(var0);

      for(int var3 = 0; var3 < class97.field1500; ++var3) {
         int var4 = class97.field1501[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 32) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         class203.method3680(var0, var4, var5, var6);
      }

      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }
}
