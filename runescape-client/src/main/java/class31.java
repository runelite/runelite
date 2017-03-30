import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public final class class31 extends Node {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1904836257
   )
   int field722;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 669088571
   )
   int field723;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -532902425
   )
   int field724;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1202028305
   )
   int field725;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -636289247
   )
   int field726;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 836210751
   )
   int field727;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2033605
   )
   int field728;
   @ObfuscatedName("r")
   ObjectComposition field729;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1236658845
   )
   int field730;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -238022879
   )
   int field731;
   @ObfuscatedName("f")
   static Deque field732 = new Deque();
   @ObfuscatedName("q")
   int[] field733;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -270573199
   )
   int field734;
   @ObfuscatedName("p")
   class66 field735;
   @ObfuscatedName("w")
   class66 field736;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZIB)V",
      garbageValue = "-19"
   )
   static void method654(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class41.field860) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         Rasterizer2D.method4057();
         byte[] var5 = var1.method3353("title.jpg", "");
         class41.field838 = new SpritePixels(var5, var0);
         class1.field7 = class41.field838.method4131();
         if((Client.flags & 536870912) != 0) {
            class41.field839 = XGrandExchangeOffer.method30(var2, "logo_deadman_mode", "");
         } else {
            class41.field839 = XGrandExchangeOffer.method30(var2, "logo", "");
         }

         class41.field836 = XGrandExchangeOffer.method30(var2, "titlebox", "");
         class88.field1561 = XGrandExchangeOffer.method30(var2, "titlebutton", "");
         class41.field837 = ItemComposition.method3719(var2, "runes", "");
         class41.field840 = ItemComposition.method3719(var2, "title_mute", "");
         class172.field2373 = XGrandExchangeOffer.method30(var2, "options_radio_buttons,0", "");
         class47.field951 = XGrandExchangeOffer.method30(var2, "options_radio_buttons,2", "");
         class63.field1122 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class63.field1122[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class63.field1122[var6 + 64] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class63.field1122[128 + var6] = 16776960 + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class63.field1122[var6 + 192] = 16777215;
         }

         Friend.field158 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            Friend.field158[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            Friend.field158[var6 + 64] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            Friend.field158[128 + var6] = 262144 * var6 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            Friend.field158[var6 + 192] = 16777215;
         }

         class41.field867 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field867[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field867[64 + var6] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field867[128 + var6] = var6 * 1024 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field867[192 + var6] = 16777215;
         }

         class137.field1933 = new int[256];
         Friend.field159 = new int['耀'];
         class9.field83 = new int['耀'];
         class10.method138((ModIcon)null);
         class25.field603 = new int['耀'];
         MessageNode.field249 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.password = "";
         }

         CombatInfo1.field683 = 0;
         Ignore.authCode = "";
         class41.field861 = true;
         class41.worldSelectShown = false;
         if(!class148.field2058.field719) {
            IndexData var9 = Client.field586;
            int var7 = var9.method3351("scape main");
            int var8 = var9.method3352(var7, "");
            class138.field1940 = 1;
            class149.field2061 = var9;
            class138.field1941 = var7;
            RSCanvas.field1777 = var8;
            NPC.field783 = 255;
            class138.field1938 = false;
            class138.field1937 = 2;
         } else {
            CollisionData.method2347(2);
         }

         class3.method19(false);
         class41.field860 = true;
         class41.field859 = (class32.field755 - Client.field362) / 2;
         class41.loginWindowX = class41.field859 + 202;
         class41.field838.method4141(class41.field859, 0);
         class1.field7.method4141(class41.field859 + 382, 0);
         class41.field839.method4088(382 + class41.field859 - class41.field839.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "1375471995"
   )
   public static String method655(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class206.field3100[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[1 + var4] & 255;
            var3.append(class206.field3100[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[2 + var4] & 255;
               var3.append(class206.field3100[(var6 & 15) << 2 | var7 >>> 6]).append(class206.field3100[var7 & 63]);
            } else {
               var3.append(class206.field3100[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class206.field3100[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-943644270"
   )
   static final String[] method659(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;B)V",
      garbageValue = "2"
   )
   static final void method662(CipherBuffer var0) {
      for(int var1 = 0; var1 < class45.field930; ++var1) {
         int var2 = class45.field931[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 4) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 64) != 0) {
            var6 = var0.readUnsignedByte();
            byte[] var7 = new byte[var6];
            Buffer var8 = new Buffer(var7);
            var0.readBytes(var7, 0, var6);
            class45.field919[var2] = var8;
            var3.method206(var8);
         }

         int var16;
         if((var4 & 2) != 0) {
            var6 = var0.readUnsignedShort();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var16 = var0.readUnsignedByte();
            Friend.method165(var3, var6, var16);
         }

         if((var4 & 32) != 0) {
            var3.interacting = var0.readUnsignedShort();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 128) != 0) {
            var3.overhead = var0.readString();
            if(var3.overhead.charAt(0) == 126) {
               var3.overhead = var3.overhead.substring(1);
               Player.sendGameMessage(2, var3.name, var3.overhead);
            } else if(Projectile.localPlayer == var3) {
               Player.sendGameMessage(2, var3.name, var3.overhead);
            }

            var3.field632 = false;
            var3.field635 = 0;
            var3.field618 = 0;
            var3.field656 = 150;
         }

         int var9;
         int var10;
         if((var4 & 16) != 0) {
            var6 = var0.readUnsignedByte();
            int var11;
            int var17;
            int var18;
            if(var6 > 0) {
               for(var16 = 0; var16 < var6; ++var16) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var17 = var0.method2880();
                  if(var17 == 32767) {
                     var17 = var0.method2880();
                     var10 = var0.method2880();
                     var9 = var0.method2880();
                     var11 = var0.method2880();
                  } else if(var17 != 32766) {
                     var10 = var0.method2880();
                  } else {
                     var17 = -1;
                  }

                  var18 = var0.method2880();
                  var3.method585(var17, var10, var9, var11, Client.gameCycle, var18);
               }
            }

            var16 = var0.readUnsignedByte();
            if(var16 > 0) {
               for(var17 = 0; var17 < var16; ++var17) {
                  var9 = var0.method2880();
                  var10 = var0.method2880();
                  if(var10 != 32767) {
                     var11 = var0.method2880();
                     var18 = var0.readUnsignedByte();
                     int var19 = var10 > 0?var0.readUnsignedByte():var18;
                     var3.method570(var9, Client.gameCycle, var10, var11, var18, var19);
                  } else {
                     var3.method569(var9);
                  }
               }
            }
         }

         if((var4 & 1) != 0) {
            var3.field646 = var0.readUnsignedShort();
            if(var3.field672 == 0) {
               var3.field669 = var3.field646;
               var3.field646 = -1;
            }
         }

         if((var4 & 8) != 0) {
            var6 = var0.readUnsignedShort();
            class177 var20 = (class177)Client.method556(class3.method23(), var0.readUnsignedByte());
            boolean var23 = var0.readUnsignedByte() == 1;
            var9 = var0.readUnsignedByte();
            var10 = var0.offset;
            if(var3.name != null && var3.composition != null) {
               boolean var22 = false;
               if(var20.field2688 && class94.method1951(var3.name)) {
                  var22 = true;
               }

               if(!var22 && Client.field421 == 0 && !var3.field265) {
                  class45.field932.offset = 0;
                  var0.readBytes(class45.field932.payload, 0, var9);
                  class45.field932.offset = 0;
                  Buffer var13 = class45.field932;
                  String var12 = IndexFile.method2305(var13, 32767);
                  String var14 = FontTypeFace.method3900(class94.method1954(var12));
                  var3.overhead = var14.trim();
                  var3.field635 = var6 >> 8;
                  var3.field618 = var6 & 255;
                  var3.field656 = 150;
                  var3.field632 = var23;
                  var3.inSequence = var3 != Projectile.localPlayer && var20.field2688 && Client.field472 != "" && var14.toLowerCase().indexOf(Client.field472) == -1;
                  int var15;
                  if(var20.field2690) {
                     var15 = var23?91:1;
                  } else {
                     var15 = var23?90:2;
                  }

                  if(var20.field2695 != -1) {
                     Player.sendGameMessage(var15, class30.method648(var20.field2695) + var3.name, var14);
                  } else {
                     Player.sendGameMessage(var15, var3.name, var14);
                  }
               }
            }

            var0.offset = var9 + var10;
         }

         if((var4 & 4096) != 0) {
            var3.graphic = var0.readUnsignedShort();
            var6 = var0.readInt();
            var3.field659 = var6 >> 16;
            var3.field658 = (var6 & '\uffff') + Client.gameCycle;
            var3.field678 = 0;
            var3.field638 = 0;
            if(var3.field658 > Client.gameCycle) {
               var3.field678 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 512) != 0) {
            var3.field660 = var0.readByte();
            var3.field662 = var0.readByte();
            var3.field661 = var0.readByte();
            var3.field643 = var0.readByte();
            var3.field664 = var0.readUnsignedShort() + Client.gameCycle;
            var3.field665 = var0.readUnsignedShort() + Client.gameCycle;
            var3.field640 = var0.readUnsignedShort();
            if(var3.field259) {
               var3.field660 += var3.field263;
               var3.field662 += var3.field255;
               var3.field661 += var3.field263;
               var3.field643 += var3.field255;
               var3.field672 = 0;
            } else {
               var3.field660 += var3.pathX[0];
               var3.field662 += var3.pathY[0];
               var3.field661 += var3.pathX[0];
               var3.field643 += var3.pathY[0];
               var3.field672 = 1;
            }

            var3.field655 = 0;
         }

         if((var4 & 256) != 0) {
            class45.field921[var2] = var0.readByte();
         }

         if((var4 & 1024) != 0) {
            var5 = var0.readByte();
         }

         if((var4 & 2048) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.actions[var6] = var0.readString();
            }
         }

         if(var3.field259) {
            if(var5 == 127) {
               var3.method216(var3.field263, var3.field255);
            } else {
               byte var21;
               if(var5 != -1) {
                  var21 = var5;
               } else {
                  var21 = class45.field921[var2];
               }

               var3.method209(var3.field263, var3.field255, var21);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "761721894"
   )
   void method665() {
      int var1 = this.field734;
      ObjectComposition var2 = this.field729.getImpostor();
      if(null != var2) {
         this.field734 = var2.ambientSoundId;
         this.field728 = var2.field2909 * 128;
         this.field731 = var2.field2943;
         this.field727 = var2.field2944;
         this.field733 = var2.field2939;
      } else {
         this.field734 = -1;
         this.field728 = 0;
         this.field731 = 0;
         this.field727 = 0;
         this.field733 = null;
      }

      if(this.field734 != var1 && null != this.field736) {
         Ignore.field224.method943(this.field736);
         this.field736 = null;
      }

   }
}
