import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class14 {
   @ObfuscatedName("a")
   public final XGrandExchangeOffer field285;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 9091047672326906775L
   )
   public final long field286;
   @ObfuscatedName("t")
   String field288;
   @ObfuscatedName("fq")
   static byte[][] field290;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1204895395
   )
   public final int field291;
   @ObfuscatedName("s")
   String field292;
   @ObfuscatedName("x")
   static int[] field293;

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(LWidget;IIS)V",
      garbageValue = "-32184"
   )
   static void method65(Widget var0, int var1, int var2) {
      if(var0.field2659 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2659 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2659 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2659 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2659 == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2660 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2660 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2660 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2660 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2660 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1097 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2046327336"
   )
   public String method66() {
      return this.field288;
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "823660554"
   )
   static final void method67() {
      if(MouseInput.soundSystem1 != null) {
         MouseInput.soundSystem1.method2022();
      }

      if(FrameMap.soundSystem0 != null) {
         FrameMap.soundSystem0.method2022();
      }

   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-100777433"
   )
   static final void method73(Actor var0) {
      var0.field1267 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class224.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1254;
            if(var0.poseFrame < var1.frameIDs.length && var0.field1254 > var1.frameLenghts[var0.poseFrame]) {
               var0.field1254 = 1;
               ++var0.poseFrame;
               class67.method1123(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field1254 = 0;
               var0.poseFrame = 0;
               class67.method1123(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1244 < 0) {
            var0.field1244 = 0;
         }

         int var2 = Renderable.getSpotAnimType(var0.graphic).field3332;
         if(var2 != -1) {
            Sequence var3 = class224.getAnimation(var2);
            if(var3 != null && var3.frameIDs != null) {
               ++var0.field1277;
               if(var0.field1244 < var3.frameIDs.length && var0.field1277 > var3.frameLenghts[var0.field1244]) {
                  var0.field1277 = 1;
                  ++var0.field1244;
                  class67.method1123(var3, var0.field1244, var0.x, var0.y);
               }

               if(var0.field1244 >= var3.frameIDs.length && (var0.field1244 < 0 || var0.field1244 >= var3.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var1 = class224.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field1269 > 0 && var0.field1274 <= Client.gameCycle && var0.field1285 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class224.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1247;
            if(var0.actionFrame < var1.frameIDs.length && var0.field1247 > var1.frameLenghts[var0.actionFrame]) {
               var0.field1247 = 1;
               ++var0.actionFrame;
               class67.method1123(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field1262;
               if(var0.field1262 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class67.method1123(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1267 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-649823314"
   )
   static final void method75(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.queueSize == 0) {
         var0.field1275 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class224.getAnimation(var0.animation);
            if(var0.field1269 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1275;
               return;
            }

            if(var0.field1269 <= 0 && var1.priority == 0) {
               ++var0.field1275;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1242 * 64;
         int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1242 * 64;
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

         byte var5 = var0.field1297[var0.queueSize - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.orientation - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field1283;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1246;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1249;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1270;
            }

            if(var7 == -1) {
               var7 = var0.field1246;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.orientation != var0.angle && var0.interacting == -1 && var0.field1291 != 0) {
                  var8 = 2;
               }

               if(var0.queueSize > 2) {
                  var8 = 6;
               }

               if(var0.queueSize > 3) {
                  var8 = 8;
               }

               if(var0.field1275 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1275;
               }
            } else {
               if(var0.queueSize > 1) {
                  var8 = 6;
               }

               if(var0.queueSize > 2) {
                  var8 = 8;
               }

               if(var0.field1275 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1275;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field1246 == var0.poseAnimation && var0.field1250 != -1) {
               var0.poseAnimation = var0.field1250;
            }

            if(var3 != var10 || var2 != var4) {
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

            if(var3 == var0.x && var0.y == var4) {
               --var0.queueSize;
               if(var0.field1269 > 0) {
                  --var0.field1269;
               }
            }
         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.queueSize;
            if(var0.field1269 > 0) {
               --var0.field1269;
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LScriptEvent;I)V",
      garbageValue = "-1910023906"
   )
   public static void method76(ScriptEvent var0) {
      class31.method267(var0, 200000);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-48"
   )
   public static final boolean method77() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      KeyFocusListener var1 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field674 == KeyFocusListener.field672) {
            return false;
         } else {
            class168.field2346 = KeyFocusListener.field669[KeyFocusListener.field672];
            IndexDataBase.field3238 = KeyFocusListener.field660[KeyFocusListener.field672];
            KeyFocusListener.field672 = KeyFocusListener.field672 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "69"
   )
   public String method78() {
      return this.field292;
   }

   class14(Buffer var1, byte var2, int var3) {
      this.field288 = var1.readString();
      this.field292 = var1.readString();
      this.field291 = var1.readUnsignedShort();
      this.field286 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field285 = new XGrandExchangeOffer();
      this.field285.method89(2);
      this.field285.method92(var2);
      this.field285.price = var4;
      this.field285.totalQuantity = var5;
      this.field285.quantitySold = 0;
      this.field285.spent = 0;
      this.field285.itemId = var3;
   }
}
