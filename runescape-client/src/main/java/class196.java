import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class196 extends CacheableNode {
   @ObfuscatedName("o")
   static class182 field2866;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1974648075
   )
   public int field2867 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 229376067
   )
   int field2868 = -1;
   @ObfuscatedName("g")
   static NodeCache field2869 = new NodeCache(64);
   @ObfuscatedName("h")
   @Export("spriteCache")
   static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("v")
   static NodeCache field2871 = new NodeCache(20);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 401982499
   )
   int field2873 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -990223573
   )
   public int field2874 = 16777215;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -144260325
   )
   public int field2875 = 70;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -214169927
   )
   int field2876 = -1;
   @ObfuscatedName("a")
   public int[] field2877;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -980174625
   )
   int field2878 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1164462387
   )
   int field2879 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1126396083
   )
   public int field2880 = 0;
   @ObfuscatedName("m")
   static class182 field2881;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1805964135
   )
   public int field2882 = 0;
   @ObfuscatedName("q")
   String field2883 = "";
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 209724847
   )
   public int field2884 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1041849903
   )
   public int field2885 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1799373555
   )
   int field2886 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -331613007
   )
   int field2887 = -1;
   @ObfuscatedName("b")
   static class182 field2889;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "184713674"
   )
   void method3477(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3483(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method3478(int var1) {
      String var2 = this.field2883;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + KitDefinition.method3411(var1, false) + var2.substring(2 + var3);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "114"
   )
   public SpritePixels method3479() {
      if(this.field2876 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2876);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class152.method2709(field2881, this.field2876, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2876);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-822344494"
   )
   public SpritePixels method3481() {
      if(this.field2878 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2878);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class152.method2709(field2881, this.field2878, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2878);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1677539982"
   )
   public SpritePixels method3482() {
      if(this.field2879 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2879);
         if(null != var1) {
            return var1;
         } else {
            var1 = class152.method2709(field2881, this.field2879, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2879);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "41"
   )
   void method3483(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2873 = var1.method2741();
      } else if(var2 == 2) {
         this.field2874 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2876 = var1.method2741();
      } else if(var2 == 4) {
         this.field2878 = var1.method2741();
      } else if(var2 == 5) {
         this.field2868 = var1.method2741();
      } else if(var2 == 6) {
         this.field2879 = var1.method2741();
      } else if(var2 == 7) {
         this.field2880 = var1.method2729();
      } else if(var2 == 8) {
         this.field2883 = var1.method2735();
      } else if(var2 == 9) {
         this.field2875 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2882 = var1.method2729();
      } else if(var2 == 11) {
         this.field2885 = 0;
      } else if(var2 == 12) {
         this.field2884 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2867 = var1.method2729();
      } else if(var2 == 14) {
         this.field2885 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2887 = var1.readUnsignedShort();
         if(this.field2887 == '\uffff') {
            this.field2887 = -1;
         }

         this.field2886 = var1.readUnsignedShort();
         if(this.field2886 == '\uffff') {
            this.field2886 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2877 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2877[var5] = var1.readUnsignedShort();
            if(this.field2877[var5] == '\uffff') {
               this.field2877[var5] = -1;
            }
         }

         this.field2877[1 + var4] = var3;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass196;",
      garbageValue = "-272982331"
   )
   public final class196 method3491() {
      int var1 = -1;
      if(this.field2887 != -1) {
         var1 = XItemContainer.method161(this.field2887);
      } else if(this.field2886 != -1) {
         var1 = class165.widgetSettings[this.field2886];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2877.length - 1) {
         var2 = this.field2877[var1];
      } else {
         var2 = this.field2877[this.field2877.length - 1];
      }

      return var2 != -1?class164.method3054(var2):null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-217747532"
   )
   public SpritePixels method3501() {
      if(this.field2868 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2868);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class152.method2709(field2881, this.field2868, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2868);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass208;",
      garbageValue = "-1993060144"
   )
   public class208 method3506() {
      if(this.field2873 == -1) {
         return null;
      } else {
         class208 var1 = (class208)field2871.get((long)this.field2873);
         if(null != var1) {
            return var1;
         } else {
            class182 var3 = field2881;
            class182 var4 = field2889;
            int var5 = this.field2873;
            class208 var2;
            if(!Friend.method170(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.method3203(var5, 0);
               class208 var6;
               if(null == var7) {
                  var6 = null;
               } else {
                  class208 var8 = new class208(var7, class211.field3125, class225.field3217, FaceNormal.field1557, FileOnDisk.field1199, class225.field3215, XGrandExchangeOffer.field36);
                  class176.method3182();
                  var6 = var8;
               }

               var2 = var6;
            }

            if(var2 != null) {
               field2871.put(var2, (long)this.field2873);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZLclass208;B)V",
      garbageValue = "-56"
   )
   public static void method3511(class182 var0, class182 var1, boolean var2, class208 var3) {
      class217.field3166 = var0;
      ItemComposition.field2941 = var1;
      Widget.isMembersWorld = var2;
      ItemComposition.field2968 = class217.field3166.method3245(10);
      ItemComposition.field2946 = var3;
   }
}
