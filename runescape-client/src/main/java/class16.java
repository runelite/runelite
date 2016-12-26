import java.awt.Component;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class16 extends class131 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -976868051
   )
   int field168 = (int)(class72.method1385() / 1000L);
   @ObfuscatedName("e")
   String field169;
   @ObfuscatedName("dw")
   static int[] field171;
   @ObfuscatedName("n")
   static SpritePixels field172;
   @ObfuscatedName("f")
   short field175;

   class16(String var1, int var2) {
      this.field169 = var1;
      this.field175 = (short)var2;
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "25"
   )
   static final boolean method176(Widget var0) {
      if(null == var0.field2321) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2321.length; ++var1) {
            int var2 = ItemLayer.method1448(var0, var1);
            int var3 = var0.field2322[var1];
            if(var0.field2321[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2321[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2321[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1233881402"
   )
   static final void method177() {
      for(int var0 = 0; var0 < Client.field324; ++var0) {
         int var1 = Client.field405[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field544.readUnsignedByte();
         int var4;
         if((var3 & 16) != 0) {
            var2.graphic = Client.field544.method2750();
            var4 = Client.field544.method2806();
            var2.field639 = var4 >> 16;
            var2.field638 = Client.gameCycle + (var4 & '\uffff');
            var2.field636 = 0;
            var2.field637 = 0;
            if(var2.field638 > Client.gameCycle) {
               var2.field636 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         int var5;
         int var6;
         if((var3 & 64) != 0) {
            var4 = Client.field544.method2797();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field544.method2788();
            if(var4 == var2.animation && var4 != -1) {
               var6 = GameEngine.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field632 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field635 = 0;
               }

               if(var6 == 2) {
                  var2.field635 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || GameEngine.getAnimation(var4).forcedPriority >= GameEngine.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field632 = 0;
               var2.actionAnimationDisable = var5;
               var2.field635 = 0;
               var2.field607 = var2.field652;
            }
         }

         if((var3 & 8) != 0) {
            var2.composition = TextureProvider.getNpcDefinition(Client.field544.method2797());
            var2.field640 = var2.composition.field3012;
            var2.field651 = var2.composition.field2998;
            var2.field622 = var2.composition.field3003;
            var2.field646 = var2.composition.field3011;
            var2.field623 = var2.composition.field3001;
            var2.field609 = var2.composition.field3013;
            var2.idlePoseAnimation = var2.composition.field3007;
            var2.field656 = var2.composition.field3002;
            var2.field604 = var2.composition.field3010;
         }

         int var7;
         if((var3 & 32) != 0) {
            var4 = Client.field544.method2786();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field544.method2772();
                  if(var6 == 32767) {
                     var6 = Client.field544.method2772();
                     var8 = Client.field544.method2772();
                     var7 = Client.field544.method2772();
                     var9 = Client.field544.method2772();
                  } else if(var6 != 32766) {
                     var8 = Client.field544.method2772();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field544.method2772();
                  var2.method565(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field544.method2786();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field544.method2772();
                  var8 = Client.field544.method2772();
                  if(var8 != 32767) {
                     var9 = Client.field544.method2772();
                     var10 = Client.field544.method2788();
                     int var11 = var8 > 0?Client.field544.method2923():var10;
                     var2.method566(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method567(var7);
                  }
               }
            }
         }

         if((var3 & 2) != 0) {
            var2.overhead = Client.field544.method2767();
            var2.field614 = 100;
         }

         if((var3 & 4) != 0) {
            var4 = Client.field544.method2795();
            var5 = Client.field544.method2795();
            var6 = var2.x - (var4 - class15.baseX - class15.baseX) * 64;
            var7 = var2.y - 64 * (var5 - class20.baseY - class20.baseY);
            if(var6 != 0 || var7 != 0) {
               var2.field626 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 1) != 0) {
            var2.interacting = Client.field544.method2797();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)LFrames;",
      garbageValue = "7"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3054.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         class182 var3 = Sequence.field3065;
         class182 var4 = class149.field2041;
         boolean var5 = true;
         int[] var6 = var3.method3289(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3212(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3212(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(null != var2) {
            Sequence.field3054.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "-908425686"
   )
   static File method179(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class104.field1669 = new File(class39.field805, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class104.field1669.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class104.field1669, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.method1390()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method1392(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.method2808();
               if(var10 == 1) {
                  var5 = var8.method2808();
               }
            } else {
               var4 = var8.method2769();
               if(var10 == 1) {
                  var5 = var8.method2769();
               }
            }

            var7.method1389();
         } catch (IOException var20) {
            var20.printStackTrace();
         }

         if(var4 != null) {
            var22 = new File(var4);
            if(!var22.exists()) {
               var4 = null;
            }
         }

         if(null != var4) {
            var22 = new File(var4, "test.dat");
            if(!MessageNode.method200(var22, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label121:
         for(int var15 = 0; var15 < class157.field2123.length; ++var15) {
            for(int var16 = 0; var16 < MessageNode.field231.length; ++var16) {
               File var17 = new File(MessageNode.field231[var16] + class157.field2123[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && MessageNode.method200(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label121;
               }
            }
         }
      }

      if(null == var4) {
         var4 = class39.field805 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(var5 != null) {
         File var21 = new File(var5);
         var22 = new File(var4);

         try {
            File[] var23 = var21.listFiles();
            File[] var18 = var23;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var22, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         Actor.method562(new File(var4), (File)null);
      }

      return new File(var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZII)V",
      garbageValue = "946912947"
   )
   static void method180(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class41.field835) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         class219.method3947();
         byte[] var5 = var1.method3228("title.jpg", "");
         field172 = new SpritePixels(var5, var0);
         class41.field861 = field172.method4020();
         if((Client.flags & 536870912) != 0) {
            class101.field1639 = class110.method2048(var2, "logo_deadman_mode", "");
         } else {
            class101.field1639 = class110.method2048(var2, "logo", "");
         }

         class156.field2120 = class110.method2048(var2, "titlebox", "");
         class41.field826 = class110.method2048(var2, "titlebutton", "");
         class41.field827 = class15.method175(var2, "runes", "");
         class210.field3113 = class15.method175(var2, "title_mute", "");
         class142.field1996 = class110.method2048(var2, "options_radio_buttons,0", "");
         Friend.field148 = class110.method2048(var2, "options_radio_buttons,2", "");
         WidgetNode.field181 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            WidgetNode.field181[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            WidgetNode.field181[var6 + 64] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            WidgetNode.field181[128 + var6] = 16776960 + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            WidgetNode.field181[192 + var6] = 16777215;
         }

         class41.field834 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field834[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field834[64 + var6] = '\uff00' + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field834[var6 + 128] = '\uffff' + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field834[192 + var6] = 16777215;
         }

         class41.field853 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field853[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field853[var6 + 64] = 262144 * var6 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field853[var6 + 128] = 16711935 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field853[var6 + 192] = 16777215;
         }

         class41.field833 = new int[256];
         XGrandExchangeOffer.field44 = new int['耀'];
         class230.field3255 = new int['耀'];
         class107.method2007((ModIcon)null);
         GameObject.field1613 = new int['耀'];
         class119.field1850 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.field850 = "";
         }

         Overlay.field3048 = 0;
         VertexNormal.authCode = "";
         class41.field828 = true;
         class41.worldSelectShown = false;
         if(!class149.field2044.field692) {
            NPC.method690(2, class204.field3079, "scape main", "", 255, false);
         } else {
            class138.field1914 = 1;
            class145.field2014 = null;
            class30.field693 = -1;
            class138.field1915 = -1;
            ItemLayer.field1220 = 0;
            ItemLayer.field1221 = false;
            class138.field1916 = 2;
         }

         class185.method3360(false);
         class41.field835 = true;
         class41.field824 = (ItemLayer.field1223 - Client.field501) / 2;
         class41.loginWindowX = 202 + class41.field824;
         field172.method4071(class41.field824, 0);
         class41.field861.method4071(382 + class41.field824, 0);
         class101.field1639.method3979(382 + class41.field824 - class101.field1639.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[Lclass177;",
      garbageValue = "-63"
   )
   public static class177[] method181() {
      return new class177[]{class177.field2660, class177.field2663, class177.field2665, class177.field2661, class177.field2662, class177.field2664};
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "23329"
   )
   public static int method182(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }
}
