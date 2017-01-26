import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class196 extends CacheableNode {
   @ObfuscatedName("k")
   static NodeCache field2860 = new NodeCache(20);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1701063553
   )
   public int field2861 = 0;
   @ObfuscatedName("q")
   static NodeCache field2862 = new NodeCache(64);
   @ObfuscatedName("d")
   @Export("spriteCache")
   static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("p")
   static class182 field2865;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2138772263
   )
   int field2867 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 330247405
   )
   int field2868 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1842613877
   )
   public int field2869 = 70;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1519602651
   )
   int field2870 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -880578261
   )
   int field2871 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 538042843
   )
   int field2872 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -811745001
   )
   int field2873 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1350727867
   )
   public int field2874 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1673458403
   )
   public int field2876 = -1;
   @ObfuscatedName("f")
   String field2877 = "";
   @ObfuscatedName("g")
   static class182 field2878;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -914202317
   )
   public int field2879 = 16777215;
   @ObfuscatedName("b")
   public int[] field2880;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1164494945
   )
   int field2881 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1240745561
   )
   public int field2882 = 0;
   @ObfuscatedName("x")
   static class182 field2883;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 234767845
   )
   public int field2885 = -1;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1452910149"
   )
   void method3546(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3548(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1427931680"
   )
   void method3548(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2867 = var1.method2843();
      } else if(var2 == 2) {
         this.field2879 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2870 = var1.method2843();
      } else if(var2 == 4) {
         this.field2872 = var1.method2843();
      } else if(var2 == 5) {
         this.field2871 = var1.method2843();
      } else if(var2 == 6) {
         this.field2873 = var1.method2843();
      } else if(var2 == 7) {
         this.field2874 = var1.readShort();
      } else if(var2 == 8) {
         this.field2877 = var1.method2825();
      } else if(var2 == 9) {
         this.field2869 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2861 = var1.readShort();
      } else if(var2 == 11) {
         this.field2876 = 0;
      } else if(var2 == 12) {
         this.field2885 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2882 = var1.readShort();
      } else if(var2 == 14) {
         this.field2876 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2881 = var1.readUnsignedShort();
         if(this.field2881 == '\uffff') {
            this.field2881 = -1;
         }

         this.field2868 = var1.readUnsignedShort();
         if(this.field2868 == '\uffff') {
            this.field2868 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2880 = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2880[var5] = var1.readUnsignedShort();
            if(this.field2880[var5] == '\uffff') {
               this.field2880[var5] = -1;
            }
         }

         this.field2880[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "613104953"
   )
   public String method3550(int var1) {
      String var2 = this.field2877;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(2 + var3);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-22681590"
   )
   public SpritePixels method3551() {
      if(this.field2870 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2870);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class186.method3417(field2878, this.field2870, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2870);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-127"
   )
   public SpritePixels method3552() {
      if(this.field2871 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2871);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class186.method3417(field2878, this.field2871, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2871);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "690397992"
   )
   public SpritePixels method3553() {
      if(this.field2872 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2872);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class186.method3417(field2878, this.field2872, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2872);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-71"
   )
   public SpritePixels method3554() {
      if(this.field2873 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2873);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class186.method3417(field2878, this.field2873, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2873);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)LFont;",
      garbageValue = "8"
   )
   public Font method3555() {
      if(this.field2867 == -1) {
         return null;
      } else {
         Font var1 = (Font)field2860.get((long)this.field2867);
         if(null != var1) {
            return var1;
         } else {
            var1 = Friend.method182(field2878, field2883, this.field2867, 0);
            if(null != var1) {
               field2860.put(var1, (long)this.field2867);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)Z",
      garbageValue = "-1362290308"
   )
   static boolean method3575(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(null == var3) {
         return false;
      } else {
         ItemLayer.method1455(var3);
         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Lclass196;",
      garbageValue = "19"
   )
   public final class196 method3590() {
      int var1 = -1;
      if(this.field2881 != -1) {
         var1 = class8.method114(this.field2881);
      } else if(this.field2868 != -1) {
         var1 = class165.widgetSettings[this.field2868];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2880.length - 1) {
         var2 = this.field2880[var1];
      } else {
         var2 = this.field2880[this.field2880.length - 1];
      }

      return var2 != -1?class108.method2038(var2):null;
   }
}
