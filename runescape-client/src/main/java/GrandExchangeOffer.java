import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 2002711639
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("o")
   @Export("state")
   byte state;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1792802829
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 558590353
   )
   @Export("price")
   public int price;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1552450863
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 857031075
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 259307607
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgc;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.state = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1252213521"
   )
   @Export("status")
   public int status() {
      return this.state & 7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1557948118"
   )
   @Export("type")
   public int type() {
      return (this.state & 8) == 8?1:0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "312415706"
   )
   void method109(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-98"
   )
   void method104(int var1) {
      this.state &= -9;
      if(var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-76"
   )
   static synchronized byte[] method127(int var0) {
      return class195.method3729(var0, false);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-1611634518"
   )
   static int method110(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         int[] var3 = class81.intStack;
         int var4 = ++WorldComparator.intStackSize - 1;
         int var5 = Client.isResized?2:1;
         var3[var4] = var5;
         return 1;
      } else {
         int var6;
         if(var0 == 5307) {
            var6 = class81.intStack[--WorldComparator.intStackSize];
            if(var6 == 1 || var6 == 2) {
               GameCanvas.method832(var6);
            }

            return 1;
         } else if(var0 == 5308) {
            class81.intStack[++WorldComparator.intStackSize - 1] = Client.preferences.screenType;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var6 = class81.intStack[--WorldComparator.intStackSize];
            if(var6 == 1 || var6 == 2) {
               Client.preferences.screenType = var6;
               MouseInput.method1062();
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(Lba;I)V",
      garbageValue = "-1262162742"
   )
   static final void method125(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.queueSize == 0) {
         var0.field1158 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = CombatInfo1.getAnimation(var0.animation);
            if(var0.field1216 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1158;
               return;
            }

            if(var0.field1216 <= 0 && var1.priority == 0) {
               ++var0.field1158;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1172 * 64;
         int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1172 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.orientation = 1280;
            } else if(var2 > var4) {
               var0.orientation = 1792;
            } else {
               var0.orientation = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.orientation = 768;
            } else if(var2 > var4) {
               var0.orientation = 256;
            } else {
               var0.orientation = 512;
            }
         } else if(var2 < var4) {
            var0.orientation = 1024;
         } else if(var2 > var4) {
            var0.orientation = 0;
         }

         byte var5 = var0.pathTraversed[var0.queueSize - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.orientation - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field1209;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1165;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1177;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1167;
            }

            if(var7 == -1) {
               var7 = var0.field1165;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1205 != 0) {
                  var8 = 2;
               }

               if(var0.queueSize > 2) {
                  var8 = 6;
               }

               if(var0.queueSize > 3) {
                  var8 = 8;
               }

               if(var0.field1158 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1158;
               }
            } else {
               if(var0.queueSize > 1) {
                  var8 = 6;
               }

               if(var0.queueSize > 2) {
                  var8 = 8;
               }

               if(var0.field1158 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1158;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field1165 && var0.field1169 != -1) {
               var0.poseAnimation = var0.field1169;
            }

            if(var10 != var3 || var2 != var4) {
               if(var10 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var10 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var3 == var0.x && var4 == var0.y) {
               --var0.queueSize;
               if(var0.field1216 > 0) {
                  --var0.field1216;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.queueSize;
            if(var0.field1216 > 0) {
               --var0.field1216;
            }

         }
      }
   }
}
