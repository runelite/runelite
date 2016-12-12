import java.awt.Image;
import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("qm")
   protected static Image field925;
   @ObfuscatedName("k")
   boolean[] field927;
   @ObfuscatedName("g")
   int[] field928;
   @ObfuscatedName("n")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("a")
   boolean field931 = false;
   @ObfuscatedName("f")
   boolean[] field932;
   @ObfuscatedName("qw")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 411210452968476661L
   )
   long field935;

   ChatMessages() {
      this.field928 = new int[Friend.field152.method3220(19)];
      this.messages = new String[Friend.field152.method3220(15)];
      this.field932 = new boolean[this.field928.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.field928.length; ++var1) {
         class188 var3 = (class188)class188.field2782.get((long)var1);
         class188 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            var4 = class188.field2781.method3211(19, var1);
            var3 = new class188();
            if(null != var4) {
               var3.method3384(new Buffer(var4));
            }

            class188.field2782.put(var3, (long)var1);
            var2 = var3;
         }

         this.field932[var1] = var2.field2784;
      }

      this.field927 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var6 = (class189)class189.field2786.get((long)var1);
         class189 var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            var4 = class189.field2787.method3211(15, var1);
            var6 = new class189();
            if(var4 != null) {
               var6.method3393(new Buffer(var4));
            }

            class189.field2786.put(var6, (long)var1);
            var5 = var6;
         }

         this.field927[var1] = var5.field2788;
      }

      for(var1 = 0; var1 < this.field928.length; ++var1) {
         this.field928[var1] = -1;
      }

      this.method810();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1300778118"
   )
   int method805(int var1) {
      return this.field928[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2052853407"
   )
   String method806(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "1803013956"
   )
   FileOnDisk method808(boolean var1) {
      return NPC.method688("2", MessageNode.field226.field2687, var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "120621234"
   )
   void method809() {
      FileOnDisk var1 = this.method808(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field928.length; ++var4) {
            if(this.field932[var4] && this.field928[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field927[var5] && null != this.messages[var5]) {
               var2 += 2 + class57.method1067(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2932(1);
         var9.method2746(var3);

         int var6;
         for(var6 = 0; var6 < this.field928.length; ++var6) {
            if(this.field932[var6] && this.field928[var6] != -1) {
               var9.method2746(var6);
               var9.method2748(this.field928[var6]);
            }
         }

         var9.method2746(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field927[var6] && null != this.messages[var6]) {
               var9.method2746(var6);
               var9.method2757(this.messages[var6]);
            }
         }

         var1.method1388(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method1389();
         } catch (Exception var16) {
            ;
         }

      }

      this.field931 = false;
      this.field935 = class72.method1385();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "274699251"
   )
   void method810() {
      FileOnDisk var1 = this.method808(false);

      try {
         byte[] var2 = new byte[(int)var1.method1390()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var1.method1392(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new EOFException();
            }
         }

         Buffer var13 = new Buffer(var2);
         if(var13.payload.length - var13.offset < 1) {
            return;
         }

         int var14 = var13.readUnsignedByte();
         if(var14 < 0 || var14 > 1) {
            return;
         }

         int var15 = var13.readUnsignedShort();

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < var15; ++var7) {
            var8 = var13.readUnsignedShort();
            var9 = var13.method2844();
            if(this.field932[var8]) {
               this.field928[var8] = var9;
            }
         }

         var7 = var13.readUnsignedShort();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var13.readUnsignedShort();
            String var10 = var13.method2767();
            if(this.field927[var9]) {
               this.messages[var9] = var10;
            }
         }
      } catch (Exception var24) {
         ;
      } finally {
         try {
            var1.method1389();
         } catch (Exception var23) {
            ;
         }

      }

      this.field931 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "46"
   )
   void method811(int var1, int var2) {
      this.field928[var1] = var2;
      if(this.field932[var1]) {
         this.field931 = true;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1958163658"
   )
   boolean method812() {
      return this.field931;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1426219727"
   )
   void method822() {
      int var1;
      for(var1 = 0; var1 < this.field928.length; ++var1) {
         if(!this.field932[var1]) {
            this.field928[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field927[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-46"
   )
   void method825() {
      if(this.field931 && this.field935 < class72.method1385() - 60000L) {
         this.method809();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1630785560"
   )
   void method832(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field927[var1]) {
         this.field931 = true;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(LActor;IS)V",
      garbageValue = "-7007"
   )
   static final void method833(Actor var0, int var1) {
      Sequence var2;
      int var3;
      int var4;
      int var11;
      if(var0.field602 > Client.gameCycle) {
         class57.method1026(var0);
      } else if(var0.field645 >= Client.gameCycle) {
         Actor.method573(var0);
      } else {
         var0.poseAnimation = var0.idlePoseAnimation;
         if(var0.field652 == 0) {
            var0.field603 = 0;
         } else {
            label585: {
               if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                  var2 = GameEngine.getAnimation(var0.animation);
                  if(var0.field607 > 0 && var2.precedenceAnimating == 0) {
                     ++var0.field603;
                     break label585;
                  }

                  if(var0.field607 <= 0 && var2.priority == 0) {
                     ++var0.field603;
                     break label585;
                  }
               }

               var11 = var0.x;
               var3 = var0.y;
               var4 = var0.pathX[var0.field652 - 1] * 128 + var0.field640 * 64;
               int var5 = 128 * var0.pathY[var0.field652 - 1] + var0.field640 * 64;
               if(var11 < var4) {
                  if(var3 < var5) {
                     var0.field649 = 1280;
                  } else if(var3 > var5) {
                     var0.field649 = 1792;
                  } else {
                     var0.field649 = 1536;
                  }
               } else if(var11 > var4) {
                  if(var3 < var5) {
                     var0.field649 = 768;
                  } else if(var3 > var5) {
                     var0.field649 = 256;
                  } else {
                     var0.field649 = 512;
                  }
               } else if(var3 < var5) {
                  var0.field649 = 1024;
               } else if(var3 > var5) {
                  var0.field649 = 0;
               }

               byte var6 = var0.field655[var0.field652 - 1];
               if(var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                  int var7 = var0.field649 - var0.angle & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field646;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field622;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field609;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field623;
                  }

                  if(var8 == -1) {
                     var8 = var0.field622;
                  }

                  var0.poseAnimation = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof NPC) {
                     var10 = ((NPC)var0).composition.isClickable;
                  }

                  if(var10) {
                     if(var0.angle != var0.field649 && var0.interacting == -1 && var0.field651 != 0) {
                        var9 = 2;
                     }

                     if(var0.field652 > 2) {
                        var9 = 6;
                     }

                     if(var0.field652 > 3) {
                        var9 = 8;
                     }

                     if(var0.field603 > 0 && var0.field652 > 1) {
                        var9 = 8;
                        --var0.field603;
                     }
                  } else {
                     if(var0.field652 > 1) {
                        var9 = 6;
                     }

                     if(var0.field652 > 2) {
                        var9 = 8;
                     }

                     if(var0.field603 > 0 && var0.field652 > 1) {
                        var9 = 8;
                        --var0.field603;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.field622 == var0.poseAnimation && var0.field600 != -1) {
                     var0.poseAnimation = var0.field600;
                  }

                  if(var11 != var4 || var3 != var5) {
                     if(var11 < var4) {
                        var0.x += var9;
                        if(var0.x > var4) {
                           var0.x = var4;
                        }
                     } else if(var11 > var4) {
                        var0.x -= var9;
                        if(var0.x < var4) {
                           var0.x = var4;
                        }
                     }

                     if(var3 < var5) {
                        var0.y += var9;
                        if(var0.y > var5) {
                           var0.y = var5;
                        }
                     } else if(var3 > var5) {
                        var0.y -= var9;
                        if(var0.y < var5) {
                           var0.y = var5;
                        }
                     }
                  }

                  if(var4 == var0.x && var5 == var0.y) {
                     --var0.field652;
                     if(var0.field607 > 0) {
                        --var0.field607;
                     }
                  }
               } else {
                  var0.x = var4;
                  var0.y = var5;
                  --var0.field652;
                  if(var0.field607 > 0) {
                     --var0.field607;
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field602 = 0;
         var0.field645 = 0;
         var0.x = var0.field640 * 64 + 128 * var0.pathX[0];
         var0.y = var0.field640 * 64 + 128 * var0.pathY[0];
         var0.method580();
      }

      if(var0 == class39.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field602 = 0;
         var0.field645 = 0;
         var0.x = var0.field640 * 64 + 128 * var0.pathX[0];
         var0.y = 128 * var0.pathY[0] + var0.field640 * 64;
         var0.method580();
      }

      if(var0.field651 != 0) {
         if(var0.interacting != -1) {
            Object var13 = null;
            if(var0.interacting < '耀') {
               var13 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var13 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var13 != null) {
               var3 = var0.x - ((Actor)var13).x;
               var4 = var0.y - ((Actor)var13).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field649 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field625) {
               var0.interacting = -1;
               var0.field625 = false;
            }
         }

         if(var0.field626 != -1 && (var0.field652 == 0 || var0.field603 > 0)) {
            var0.field649 = var0.field626;
            var0.field626 = -1;
         }

         var11 = var0.field649 - var0.angle & 2047;
         if(var11 == 0 && var0.field625) {
            var0.interacting = -1;
            var0.field625 = false;
         }

         if(var11 != 0) {
            ++var0.field650;
            boolean var14;
            if(var11 > 1024) {
               var0.angle -= var0.field651;
               var14 = true;
               if(var11 < var0.field651 || var11 > 2048 - var0.field651) {
                  var0.angle = var0.field649;
                  var14 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field650 > 25 || var14)) {
                  if(var0.field656 != -1) {
                     var0.poseAnimation = var0.field656;
                  } else {
                     var0.poseAnimation = var0.field622;
                  }
               }
            } else {
               var0.angle += var0.field651;
               var14 = true;
               if(var11 < var0.field651 || var11 > 2048 - var0.field651) {
                  var0.angle = var0.field649;
                  var14 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field650 > 25 || var14)) {
                  if(var0.field604 != -1) {
                     var0.poseAnimation = var0.field604;
                  } else {
                     var0.poseAnimation = var0.field622;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field650 = 0;
         }
      }

      var0.field605 = false;
      if(var0.poseAnimation != -1) {
         var2 = GameEngine.getAnimation(var0.poseAnimation);
         if(null != var2 && var2.frameIDs != null) {
            ++var0.field629;
            if(var0.poseFrame < var2.frameIDs.length && var0.field629 > var2.frameLenghts[var0.poseFrame]) {
               var0.field629 = 1;
               ++var0.poseFrame;
               Friend.method169(var2, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var2.frameIDs.length) {
               var0.field629 = 0;
               var0.poseFrame = 0;
               Friend.method169(var2, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field638) {
         if(var0.field636 < 0) {
            var0.field636 = 0;
         }

         var11 = Ignore.method193(var0.graphic).field2797;
         if(var11 != -1) {
            Sequence var12 = GameEngine.getAnimation(var11);
            if(var12 != null && var12.frameIDs != null) {
               ++var0.field637;
               if(var0.field636 < var12.frameIDs.length && var0.field637 > var12.frameLenghts[var0.field636]) {
                  var0.field637 = 1;
                  ++var0.field636;
                  Friend.method169(var12, var0.field636, var0.x, var0.y);
               }

               if(var0.field636 >= var12.frameIDs.length && (var0.field636 < 0 || var0.field636 >= var12.frameIDs.length)) {
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
         var2 = GameEngine.getAnimation(var0.animation);
         if(var2.precedenceAnimating == 1 && var0.field607 > 0 && var0.field602 <= Client.gameCycle && var0.field645 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var2 = GameEngine.getAnimation(var0.animation);
         if(var2 != null && null != var2.frameIDs) {
            ++var0.field632;
            if(var0.actionFrame < var2.frameIDs.length && var0.field632 > var2.frameLenghts[var0.actionFrame]) {
               var0.field632 = 1;
               ++var0.actionFrame;
               Friend.method169(var2, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var2.frameIDs.length) {
               var0.actionFrame -= var2.frameStep;
               ++var0.field635;
               if(var0.field635 >= var2.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var2.frameIDs.length) {
                  Friend.method169(var2, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field605 = var2.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1098130345"
   )
   static final void method834(int var0) {
      if(class212.method3870(var0)) {
         class31.method648(Widget.widgets[var0], -1);
      }
   }
}
