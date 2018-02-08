import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class45 extends class28 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1641771941
   )
   static int field565;
   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field566;
   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field562;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -476376155
   )
   int field559;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -469507673
   )
   int field567;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1336141597
   )
   int field563;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -364433625
   )
   int field557;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgy;B)V",
      garbageValue = "118"
   )
   void method620(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field479.field478) {
         throw new IllegalStateException("");
      } else {
         super.field391 = var2.readUnsignedByte();
         super.field393 = var2.readUnsignedByte();
         super.field398 = var2.readUnsignedShort();
         super.field389 = var2.readUnsignedShort();
         this.field559 = var2.readUnsignedByte();
         this.field567 = var2.readUnsignedByte();
         super.field390 = var2.readUnsignedShort();
         super.field394 = var2.readUnsignedShort();
         this.field563 = var2.readUnsignedByte();
         this.field557 = var2.readUnsignedByte();
         super.field393 = Math.min(super.field393, 4);
         super.field388 = new short[1][64][64];
         super.field395 = new short[super.field393][64][64];
         super.field396 = new byte[super.field393][64][64];
         super.field397 = new byte[super.field393][64][64];
         super.field392 = new class31[super.field393][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field476.field470) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field390 && var5 == super.field394 && var6 == this.field563 && var7 == this.field557) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method214(var8 + this.field563 * 8, var9 + this.field557 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1505138942"
   )
   boolean method611(int var1, int var2) {
      return var1 < this.field563 * 8?false:(var2 < this.field557 * 8?false:(var1 >= this.field563 * 8 + 8?false:var2 < this.field557 * 8 + 8));
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "30"
   )
   int method630() {
      return this.field559;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "29"
   )
   int method633() {
      return this.field567;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-111"
   )
   int method610() {
      return this.field563;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "94"
   )
   int method615() {
      return this.field557;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field390 == var2.field390 && var2.field394 == super.field394?var2.field563 == this.field563 && var2.field557 == this.field557:false;
      }
   }

   public int hashCode() {
      return super.field390 | super.field394 << 8 | this.field563 << 16 | this.field557 << 24;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "295950936"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(Lbe;I)V",
      garbageValue = "1665654795"
   )
   static final void method618(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.queueSize == 0) {
         var0.field1172 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = FileRequest.getAnimation(var0.animation);
            if(var0.field1161 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1172;
               return;
            }

            if(var0.field1161 <= 0 && var1.priority == 0) {
               ++var0.field1172;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1127 * 64;
         int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1127 * 64;
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

            int var7 = var0.field1123;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1156;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1125;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1124;
            }

            if(var7 == -1) {
               var7 = var0.field1156;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.orientation != var0.angle && var0.interacting == -1 && var0.field1167 != 0) {
                  var8 = 2;
               }

               if(var0.queueSize > 2) {
                  var8 = 6;
               }

               if(var0.queueSize > 3) {
                  var8 = 8;
               }

               if(var0.field1172 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1172;
               }
            } else {
               if(var0.queueSize > 1) {
                  var8 = 6;
               }

               if(var0.queueSize > 2) {
                  var8 = 8;
               }

               if(var0.field1172 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1172;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field1156 && var0.field1126 != -1) {
               var0.poseAnimation = var0.field1126;
            }

            if(var10 != var3 || var4 != var2) {
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
               if(var0.field1161 > 0) {
                  --var0.field1161;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.queueSize;
            if(var0.field1161 > 0) {
               --var0.field1161;
            }

         }
      }
   }
}
