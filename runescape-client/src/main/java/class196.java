import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class196 extends CacheableNode {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1720896537
   )
   public int field2871 = 0;
   @ObfuscatedName("n")
   static class182 field2872;
   @ObfuscatedName("g")
   static class182 field2873;
   @ObfuscatedName("v")
   public static NodeCache field2874 = new NodeCache(64);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1694879105
   )
   int field2875 = -1;
   @ObfuscatedName("p")
   public static NodeCache field2876 = new NodeCache(20);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1170069311
   )
   public int field2880 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1588053421
   )
   public int field2881 = 16777215;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 572022461
   )
   public int field2882 = 70;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -398369561
   )
   int field2883 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1168159361
   )
   int field2884 = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1067908473
   )
   int field2885 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 358559161
   )
   int field2886 = -1;
   @ObfuscatedName("y")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("e")
   String field2888 = "";
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1063853315
   )
   public int field2889 = -1;
   @ObfuscatedName("x")
   static class182 field2890;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1825059467
   )
   public int field2891 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -819580751
   )
   public int field2892 = 0;
   @ObfuscatedName("z")
   public int[] field2893;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1630712715
   )
   int field2894 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1927221233
   )
   int field2895 = -1;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1535987240"
   )
   void method3623(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3624(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-87"
   )
   void method3624(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2894 = var1.method2901();
      } else if(var2 == 2) {
         this.field2881 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2883 = var1.method2901();
      } else if(var2 == 4) {
         this.field2895 = var1.method2901();
      } else if(var2 == 5) {
         this.field2884 = var1.method2901();
      } else if(var2 == 6) {
         this.field2886 = var1.method2901();
      } else if(var2 == 7) {
         this.field2871 = var1.readShort();
      } else if(var2 == 8) {
         this.field2888 = var1.method2895();
      } else if(var2 == 9) {
         this.field2882 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2880 = var1.readShort();
      } else if(var2 == 11) {
         this.field2889 = 0;
      } else if(var2 == 12) {
         this.field2891 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2892 = var1.readShort();
      } else if(var2 == 14) {
         this.field2889 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2875 = var1.readUnsignedShort();
         if(this.field2875 == '\uffff') {
            this.field2875 = -1;
         }

         this.field2885 = var1.readUnsignedShort();
         if(this.field2885 == '\uffff') {
            this.field2885 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2893 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2893[var5] = var1.readUnsignedShort();
            if(this.field2893[var5] == '\uffff') {
               this.field2893[var5] = -1;
            }
         }

         this.field2893[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-376575449"
   )
   public SpritePixels method3627() {
      if(this.field2883 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2883);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameEngine.method2296(field2872, this.field2883, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2883);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "0"
   )
   public SpritePixels method3628() {
      if(this.field2884 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2884);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameEngine.method2296(field2872, this.field2884, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2884);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1502076311"
   )
   public SpritePixels method3629() {
      if(this.field2895 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2895);
         if(null != var1) {
            return var1;
         } else {
            var1 = GameEngine.method2296(field2872, this.field2895, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2895);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "3"
   )
   public SpritePixels method3630() {
      if(this.field2886 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2886);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameEngine.method2296(field2872, this.field2886, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2886);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-453450611"
   )
   static final void method3631(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field416 != 0 || Client.field444) {
         int var2 = class2.method23();
         String var3;
         if(Client.field416 == 1 && Client.menuOptionCount < 2) {
            var3 = "Use" + " " + Client.field443 + " " + "->";
         } else if(Client.field444 && Client.menuOptionCount < 2) {
            var3 = Client.field353 + " " + Client.field448 + " " + "->";
         } else {
            String var4;
            if(var2 < 0) {
               var4 = "";
            } else if(Client.menuTargets[var2].length() > 0) {
               var4 = Client.menuOptions[var2] + " " + Client.menuTargets[var2];
            } else {
               var4 = Client.menuOptions[var2];
            }

            var3 = var4;
         }

         if(Client.menuOptionCount > 2) {
            var3 = var3 + class37.method813(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class217.field3188.method3917(var3, 4 + var0, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Lclass196;",
      garbageValue = "-1085821864"
   )
   public final class196 method3642() {
      int var1 = -1;
      if(this.field2875 != -1) {
         var1 = class18.method202(this.field2875);
      } else if(this.field2885 != -1) {
         var1 = class165.widgetSettings[this.field2885];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2893.length - 1) {
         var2 = this.field2893[var1];
      } else {
         var2 = this.field2893[this.field2893.length - 1];
      }

      return var2 != -1?Script.method971(var2):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1718143346"
   )
   public String method3648(int var1) {
      String var2 = this.field2888;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class157.method3138(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "-500513427"
   )
   public Font method3659() {
      if(this.field2894 == -1) {
         return null;
      } else {
         Font var1 = (Font)field2876.get((long)this.field2894);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class49.method980(field2872, field2873, this.field2894, 0);
            if(var1 != null) {
               field2876.put(var1, (long)this.field2894);
            }

            return var1;
         }
      }
   }
}
