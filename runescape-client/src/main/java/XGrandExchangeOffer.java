import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("ba")
   @Export("host")
   static String host;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1746315405
   )
   @Export("price")
   public int price;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1979468901
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1525284777
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -298905153
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("eu")
   static SpritePixels field39;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = 9172745362726750889L
   )
   static long field40;
   @ObfuscatedName("go")
   static Widget field42;
   @ObfuscatedName("f")
   @Export("progress")
   byte progress;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1501504317
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("bh")
   static ModIcon[] field45;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "1483032684"
   )
   public static ModIcon method30(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method3351(var1);
      int var4 = var0.method3352(var3, var2);
      ModIcon var5;
      if(!VertexNormal.method1667(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon var7 = new ModIcon();
         var7.width = class225.field3231;
         var7.originalHeight = class146.field2038;
         var7.offsetX = class225.field3230[0];
         var7.offsetY = ItemComposition.field3003[0];
         var7.originalWidth = class225.field3232[0];
         var7.height = ChatLineBuffer.field994[0];
         var7.palette = class225.field3234;
         var7.pixels = BufferProvider.field3199[0];
         WidgetNode.method172();
         var5 = var7;
      }

      return var5;
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-94"
   )
   public int method31() {
      return this.progress & 7;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "113"
   )
   static final void method32(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field672 == 0) {
         var0.field651 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var10 = Friend.getAnimation(var0.animation);
            if(var0.field655 > 0 && var10.precedenceAnimating == 0) {
               ++var0.field651;
               return;
            }

            if(var0.field655 <= 0 && var10.priority == 0) {
               ++var0.field651;
               return;
            }
         }

         int var1 = var0.x;
         int var2 = var0.y;
         int var3 = var0.pathX[var0.field672 - 1] * 128 + var0.field622 * 64;
         int var4 = 128 * var0.pathY[var0.field672 - 1] + var0.field622 * 64;
         if(var1 < var3) {
            if(var2 < var4) {
               var0.field669 = 1280;
            } else if(var2 > var4) {
               var0.field669 = 1792;
            } else {
               var0.field669 = 1536;
            }
         } else if(var1 > var3) {
            if(var2 < var4) {
               var0.field669 = 768;
            } else if(var2 > var4) {
               var0.field669 = 256;
            } else {
               var0.field669 = 512;
            }
         } else if(var2 < var4) {
            var0.field669 = 1024;
         } else if(var2 > var4) {
            var0.field669 = 0;
         }

         byte var5 = var0.field675[var0.field672 - 1];
         if(var3 - var1 <= 256 && var3 - var1 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field669 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field627;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field626;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field629;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field645;
            }

            if(var7 == -1) {
               var7 = var0.field626;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.field669 && var0.interacting == -1 && var0.field671 != 0) {
                  var8 = 2;
               }

               if(var0.field672 > 2) {
                  var8 = 6;
               }

               if(var0.field672 > 3) {
                  var8 = 8;
               }

               if(var0.field651 > 0 && var0.field672 > 1) {
                  var8 = 8;
                  --var0.field651;
               }
            } else {
               if(var0.field672 > 1) {
                  var8 = 6;
               }

               if(var0.field672 > 2) {
                  var8 = 8;
               }

               if(var0.field651 > 0 && var0.field672 > 1) {
                  var8 = 8;
                  --var0.field651;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field626 && var0.field630 != -1) {
               var0.poseAnimation = var0.field630;
            }

            if(var3 != var1 || var4 != var2) {
               if(var1 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var1 > var3) {
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

            if(var0.x == var3 && var4 == var0.y) {
               --var0.field672;
               if(var0.field655 > 0) {
                  --var0.field655;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field672;
            if(var0.field655 > 0) {
               --var0.field655;
            }

         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "55805293"
   )
   void method33(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1822344993"
   )
   void method34(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2073198389"
   )
   public int method45() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "1805629422"
   )
   static void method54(Widget var0) {
      Widget var1 = var0.parentId == -1?null:FaceNormal.method1932(var0.parentId);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class32.field755;
         var3 = class168.field2207;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      ScriptState.method143(var0, var2, var3, false);
      class16.method170(var0, var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "811002875"
   )
   public static int method55(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + DecorativeObject.method1955(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "1355958196"
   )
   static final void method56(Actor var0, int var1) {
      Widget.method3294(var0.x, var0.y, var1);
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }
}
